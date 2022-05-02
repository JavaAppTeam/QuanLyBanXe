package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	private void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	public List<KhachHang> getAllSdtKH() throws SQLException {
		// TODO Auto-generated method stub
		KhachHang kh = null;
		List<KhachHang> dsKH = new ArrayList<>();
		try {
			conn = connectDB.getConnection();
			String sql = "select SoDienThoai from KhachHang";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String sdt = rs.getString("SoDienThoai");
				kh = new KhachHang(sdt);
				dsKH.add(kh);
			}
			return dsKH;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return dsKH;
	}
	public String getKHTheoSDT(String sdt) {
		//KhachHang kh;
		try {
			conn = connectDB.getConnection();
			String sql = "select MaKH from KhachHang where SoDienThoai="+"'"+sdt+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				return maKH;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
