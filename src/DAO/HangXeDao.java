package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.HangXe;
import Entity.PhuTungXe;

public class HangXeDao {

	/**
	 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 27/04/2022
	 */
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;

	public HangXeDao() {
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

	public List<HangXe> getallSP() throws Exception {
		List<HangXe> lstHangXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM HangXe WHERE trangthai=1";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstHangXe = new ArrayList<>();
			while (rs.next()) {
				String maHangXe = rs.getString(1);
				String tenHangXe = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				lstHangXe.add(new HangXe(maHangXe, tenHangXe, trangThai));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstHangXe;
	}

	public boolean themSP(HangXe hangXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "Insert into HangXe values(?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, hangXe.getMaHang());
			statement.setString(2, hangXe.getTenHang());
			statement.setBoolean(3, hangXe.isTrangThai());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public HangXe getHangXeTheoMa(String maHang) throws Exception {
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM HangXe WHERE MaHangXe='" + maHang + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				String  maHangXe = rs.getString(1);
				String tenHang = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				return new HangXe(maHangXe, tenHang, trangThai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public boolean capnhat(HangXe hangXe, String maHangXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		System.out.println(hangXe);
		try {
			statement = con.prepareStatement("UPDATE HangXe SET TenHang=?,TrangThai=? WHERE MaHangXe=?");
			statement.setString(1,hangXe.getTenHang());
			statement.setBoolean(2, hangXe.isTrangThai());
			statement.setString(3, maHangXe);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteHangXe(String maHangXe) throws Exception {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE HangXe SET TrangThai=0 WHERE MaHangXe=?");
			stmt.setString(1, maHangXe);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
}
