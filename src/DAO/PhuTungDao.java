package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.ChiTietXe;
import Entity.PhuTungXe;

public class PhuTungDao {

	/**
	 * Launch the application.
	 * Tên: Võ Thị Trà Giang
	 * Ngày tạo: 27/04/2022
	 */
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;
	
	public PhuTungDao() {
		// TODO Auto-generated constructor stub
	}

	private void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (preStm != null) {
			preStm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	public List<PhuTungXe> getallSP() throws Exception {
		List<PhuTungXe> lstPhuTung = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM PhuTungXe WHERE trangthai=1";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstPhuTung = new ArrayList<>();
			while (rs.next()) {
				int  maPhuTung = rs.getInt(1);
				String tenPhuTung = rs.getString(2);
				int soLuong = rs.getInt(3);
				boolean trangThai = rs.getBoolean(4);
				double giaTien = rs.getDouble(5);
				lstPhuTung.add(new PhuTungXe(maPhuTung, soLuong, tenPhuTung, giaTien, trangThai));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstPhuTung;
	}
	
	public boolean themSP(PhuTungXe phuTung) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			// YMH01-0000
			String sql = "Insert into PhuTungXe values(?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, phuTung.getTenPhuTung());
			statement.setInt(2, phuTung.getSoLuongTon());
			statement.setBoolean(3, phuTung.isTrangThai());
			statement.setDouble(4, phuTung.getDonGia());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public PhuTungXe getPhuTungTheoTen(String tenPT) throws Exception {
		PhuTungXe phuTung;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT IDPhuTung,TenPhuTung, SoLuongTon, TrangThai, DonGia FROM PhuTungXe WHERE TenPhuTung like N'%" + tenPT + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				int  maPhuTung = rs.getInt(1);
				String tenPhuTung = rs.getString(2);
				int soLuong = rs.getInt(3);
				boolean trangThai = rs.getBoolean(4);
				double giaTien = rs.getDouble(5);
				phuTung = new  PhuTungXe(maPhuTung, soLuong, tenPhuTung, giaTien, trangThai);
				System.out.println(phuTung);
				return phuTung;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public boolean capnhat(PhuTungXe phuTung, int maPT) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		System.out.println(phuTung);
		try {
			statement = con.prepareStatement("UPDATE PhuTungXe SET TenPhuTung=?, SoLuongTon=?,DonGia=?,TrangThai=? WHERE IDPhuTung=?");
			statement.setString(1,phuTung.getTenPhuTung());
			statement.setInt(2, phuTung.getSoLuongTon());
			statement.setDouble(3, phuTung.getDonGia());
			statement.setBoolean(4, phuTung.isTrangThai());
			statement.setInt(5, maPT);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deletePhuTung(int maPT) throws Exception {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE PhuTungXe SET TrangThai=0 WHERE IDPhuTung=?");
			stmt.setInt(1, maPT);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
}
