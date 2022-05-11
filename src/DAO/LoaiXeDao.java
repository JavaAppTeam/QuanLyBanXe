package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.HangXe;
import Entity.LoaiXe;

public class LoaiXeDao {

	/**
	 * Launch the application.
	 */
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;
	public LoaiXeDao() {
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
	
	public List<LoaiXe> getallSP() throws Exception {
		List<LoaiXe> lstLoaiXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM LoaiXe WHERE trangthai=1";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstLoaiXe = new ArrayList<>();
			while (rs.next()) {
				int  maLoai = rs.getInt(1);
				String tenLoai = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				lstLoaiXe.add(new LoaiXe(maLoai, tenLoai, trangThai));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstLoaiXe;
	}
	
	public boolean themSP(LoaiXe loaiXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "Insert into LoaiXe values(?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, loaiXe.getTenLoai());
			statement.setBoolean(2, loaiXe.isTrangThai());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public LoaiXe getXeTheoTenLoai(String tenLoai) throws Exception {
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM LoaiXe WHERE TenLoaiXe like N'%" + tenLoai + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				int  maLoai = rs.getInt(1);
				String tenLoaiXe = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				return (new LoaiXe(maLoai, tenLoaiXe, trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	public boolean capnhat(LoaiXe loaiXe, int tenLoaiXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		System.out.println(loaiXe);
		try {
			statement = con.prepareStatement("UPDATE LoaiXe SET TenLoaiXe=?,TrangThai=? WHERE IDLoaiXe=?");
			statement.setString(1,loaiXe.getTenLoai());
			statement.setBoolean(2, loaiXe.isTrangThai());
			statement.setInt(3, tenLoaiXe);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteLoaiXe(int maLoaiXe) throws Exception {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE LoaiXe SET TrangThai=0 WHERE IDLoaiXe=?");
			stmt.setInt(1, maLoaiXe);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}
