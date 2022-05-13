package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import ConnectDB.*;
import Entity.ChiTietHoaDonBaoHanh;
import DAO.*;
import DAO.PhuTungDao;

public class ChiTietBaoHanhDao {
	/*
	 * Tên: Trần Văn Sỹ
	 * Ngày tạo: 20/04/2022
	 */
	PhuTungDao phuTungDao = new PhuTungDao();
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;
	public ChiTietBaoHanhDao() {
		super();
	}
	private void closeConnect() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if (preStm != null) {
			preStm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	public ArrayList<ChiTietHoaDonBaoHanh> getAllCTBH() throws Exception {
		ArrayList<ChiTietHoaDonBaoHanh> lstCTBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * from ChiTietHoaDonBaoHanh where MaBaoHanh";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstCTBH = new ArrayList<>();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maBaoHanh = rs.getString(2);
				int idPhuTung = rs.getInt(3);
				int soLuong = rs.getInt(4);
				lstCTBH.add(new ChiTietHoaDonBaoHanh(maHoaDon,maBaoHanh,idPhuTung,soLuong));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return lstCTBH;
	}
	
	public ArrayList<ChiTietHoaDonBaoHanh> getCTBHTheoMa(String maHD) throws Exception {
		ArrayList<ChiTietHoaDonBaoHanh> lstCTBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * from ChiTietHoaDonBaoHanh where MaBaoHanh = '"+maHD+"'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstCTBH = new ArrayList<>();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maBaoHanh = rs.getString(2);
				int idPhuTung = rs.getInt(3);
				int soLuong = rs.getInt(4);
				lstCTBH.add(new ChiTietHoaDonBaoHanh(maHoaDon,maBaoHanh,idPhuTung,soLuong));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return lstCTBH;
	}
	public boolean delCTBH(String mabh) throws Exception, SQLException
	{
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement("delete from ChiTietHoaDonBaoHanh where mabaohanh=? ");
			stmt.setString(1, mabh);

			n = stmt.executeUpdate();
			if(n>=0) {
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnect();
		}	
		return false;
	}
	public boolean delCTHoaDonBaoHanh(ChiTietHoaDonBaoHanh ctbh) throws Exception, SQLException
	{
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement("delete from ChiTietHoaDonBaoHanh where (mabaohanh=? and mahoadon =? and idphutung = ? )");
			stmt.setString(1, ctbh.getMaBaoHanh());
			stmt.setString(2,ctbh.getMaHoaDon());
			stmt.setInt(3, ctbh.getIdPhuTung());
			n = stmt.executeUpdate();
			if(n>=0) {
				stmt1 = con.prepareStatement("update PhuTungXe set SoLuongTon = SoLuongTon + ? where IDPhuTung = ?");
				stmt1.setInt(1, ctbh.getSoLuong());
				stmt1.setInt(2, ctbh.getIdPhuTung());
				int m = stmt1.executeUpdate();
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnect();
		}	
		return false;
	}
	public boolean addCTBH(ChiTietHoaDonBaoHanh ctbh) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		if(checkTonTai(ctbh)==false) {
			try {
				String sql = "insert into ChiTietHoaDonBaoHanh values (?,?,?,?)";
				statement = con.prepareStatement(sql);
				statement.setString(1, ctbh.getMaHoaDon());
				statement.setString(2, ctbh.getMaBaoHanh());
				statement.setInt(3, ctbh.getIdPhuTung());
				statement.setInt(4, ctbh.getSoLuong());
				n = statement.executeUpdate();
				updateSoLuongTon(ctbh.getSoLuong(),ctbh.getIdPhuTung());
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			String sql = "UPDATE ChiTietHoaDonBaoHanh SET SoLuong=SoLuong+? where (IDPhuTung = ? and maHoadon =? and MaBaoHanh =?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, ctbh.getSoLuong());
			statement.setInt(2, ctbh.getIdPhuTung());
			statement.setString(3, ctbh.getMaHoaDon());
			statement.setString(4, ctbh.getMaBaoHanh());
			n = statement.executeUpdate();
			updateSoLuongTon(ctbh.getSoLuong(),ctbh.getIdPhuTung());
			return true;
		}

		return false;
	}
	public boolean checkTonTai(ChiTietHoaDonBaoHanh ctbh) throws ClassNotFoundException, SQLException {
		ArrayList<ChiTietHoaDonBaoHanh> lstCTBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from ChiTietHoaDonBaoHanh  WHERE (IDPhuTung ="+ctbh.getIdPhuTung()+" and maHoadon ='"+ctbh.getMaHoaDon()+"' and MaBaoHanh ='"+ctbh.getMaBaoHanh()+"')";
			java.sql.Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);
			lstCTBH = new ArrayList<>();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maBaoHanh = rs.getString(2);
				int idPhuTung = rs.getInt(3);
				int soLuong = rs.getInt(4);
				lstCTBH.add(new ChiTietHoaDonBaoHanh(maHoaDon,maBaoHanh,idPhuTung,soLuong));
				if(lstCTBH != null)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return false;
	}
	
	public Date layNgayLapHoaDon (String maHD){
		Date ngayLap= null;
		Connection con;
		try {
			con = connectDB.getConnection();
			String sql = "SELECT NgayLapHoaDon FROM     HoaDon WHERE  (MaHoaDon = '"+maHD+"')";
			java.sql.Statement statement = con.createStatement();
			rs =((java.sql.Statement) statement).executeQuery(sql);
			while(rs.next()) {
				ngayLap = rs.getDate(1);
				return ngayLap;
			}
			closeConnect();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	
	public Date layNgayLapHoaDonBaoHanh (String maHDBH) throws ClassNotFoundException, SQLException {
		Date ngayLap= null;
		Connection con = connectDB.getConnection();
		String sql = "SELECT NgayLapHoaDon FROM HoaDonBaoHanh WHERE  (MaBaoHanh = '"+maHDBH+"')";
		java.sql.Statement statement = con.createStatement();
		rs =((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			ngayLap = rs.getDate(1);
		}
		closeConnect();
		
		return ngayLap;
	}
	public boolean checkLoi(String maBaoHanh) throws ClassNotFoundException, SQLException {
		boolean check = false;
		Connection con = connectDB.getConnection();
		String sql = "SELECT LyDoBaoHanh FROM HoaDonBaoHanh WHERE  (MaBaoHanh = '"+maBaoHanh+"')";
		java.sql.Statement statement = con.createStatement();
		rs =((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			check = rs.getBoolean(1);
			return check;
		}
		return false;
	}
	public boolean updateSoLuongTon(int soLuong, int maPT) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE PhuTungXe SET SoLuongTon=SoLuongTon-? WHERE IDPhuTung =?");
			statement.setInt(1,soLuong);
			statement.setInt(2, maPT);
			n = statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
