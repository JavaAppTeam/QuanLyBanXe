package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.*;
import Entity.HoaDonBaoHanh;
import Entity.LoaiXe;
import Entity.Xe;

public class HoaDonBaoHanhDao {
	/*
	 * Tên: Trần Văn Sỹ
	 * Ngày tạo: 20/04/2022
	 */
	ChiTietBaoHanhDao ctBaoHanhDao;
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;
	public HoaDonBaoHanhDao() {
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
	public ArrayList<HoaDonBaoHanh> getallHDBH() throws Exception {
		ArrayList<HoaDonBaoHanh> lstHDBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM HoaDonBaoHanh WHERE trangthai=0";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstHDBH = new ArrayList<>();
			while (rs.next()) {
				int idBaoHanh = rs.getInt(1);
				String maBaoHanh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				boolean lyDoBaoHanh = rs.getBoolean(4);
				String ghiChu = rs.getString(5);
				boolean trangThai = rs.getBoolean(6);
				lstHDBH.add(new HoaDonBaoHanh(maBaoHanh, lyDoBaoHanh, ghiChu, trangThai,ngayLap));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return lstHDBH;
	}
	public ArrayList<HoaDonBaoHanh> getAllHDBH() throws Exception {
		ArrayList<HoaDonBaoHanh> lstHDBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM HoaDonBaoHanh";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstHDBH = new ArrayList<>();
			while (rs.next()) {
				int idBaoHanh = rs.getInt(1);
				String maBaoHanh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				boolean lyDoBaoHanh = rs.getBoolean(4);
				String ghiChu = rs.getString(5);
				boolean trangThai = rs.getBoolean(6);
				lstHDBH.add(new HoaDonBaoHanh(maBaoHanh,lyDoBaoHanh,ghiChu,trangThai,ngayLap));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return lstHDBH;
	}
	
	public ArrayList<HoaDonBaoHanh> getHDBHTheoMa(String maHD) throws Exception {
		ArrayList<HoaDonBaoHanh> lstHDBH = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from hoadonbaohanh where mabaohanh like '%"+maHD+"%'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstHDBH = new ArrayList<>();
			while (rs.next()) {
				int idBaoHanh = rs.getInt(1);
				String maBaoHanh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				boolean lyDoBaoHanh = rs.getBoolean(4);
				String ghiChu = rs.getString(5);
				boolean trangThai = rs.getBoolean(6);
				lstHDBH.add(new HoaDonBaoHanh(maBaoHanh,lyDoBaoHanh,ghiChu,trangThai,ngayLap));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return lstHDBH;
	}
	public boolean deleteHDBH(String maHD) throws Exception, SQLException
	{
		ctBaoHanhDao = new ChiTietBaoHanhDao();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			ctBaoHanhDao.delCTBH(maHD);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Không xóa được ct hóa đơn");
		}
		try {
			
			stmt = con.prepareStatement("delete from hoadonbaohanh where mabaohanh=?");
			stmt.setString(1, maHD);
			n = stmt.executeUpdate();
			if(n==0) {
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			closeConnect();
		}	
	}
	public boolean addHDBH(HoaDonBaoHanh hdbh) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into HoaDonBaoHanh values (Default,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setDate(1,hdbh.getNgayLap());
			statement.setBoolean(2, hdbh.isLyDoBaoHanh());
			statement.setString(3, hdbh.getGhiChu());
			statement.setBoolean(4, hdbh.isTrangThai());
			n = statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean upDateHoaDonBaoHanh(boolean liDoBaoHanh, String ghiChu, boolean trangThai,String maBaoHanh) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE HoaDonBaoHanh SET LyDoBaoHanh = ? ,TrangThai= ?, GhiChu =? WHERE MaBaoHanh=?");
			statement.setBoolean(1,liDoBaoHanh);
			statement.setBoolean(2,trangThai);
			statement.setString(3, ghiChu);
			statement.setString(4,maBaoHanh);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
}
