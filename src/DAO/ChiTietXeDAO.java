package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.ChiTietXe;

public class ChiTietXeDAO {
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
	public List<ChiTietXe> getAllMaXe() throws SQLException {
		List<ChiTietXe> ctx = null;
		ChiTietXe chiTietXe;
		try {
			conn = connectDB.getConnection();
			String sql = "select ctx.MaXe from ChiTietXe ctx join Xe x on ctx.IDXe=x.IDXe";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ctx = new ArrayList<>();
			while (rs.next()) {
				String maXe = rs.getString("MaXe");
				chiTietXe = new ChiTietXe(maXe);
				ctx.add(chiTietXe);
			}
			return ctx;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	public String getTenXe(String maXe) {
		try {
			conn = connectDB.getConnection();
			String sql = "select x.TenXe from Xe x join ChiTietXe ctx on x.IDXe=ctx.IDXe where ctx.MaXe="+"'"+maXe+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenXe = rs.getString("TenXe");
				return tenXe;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
