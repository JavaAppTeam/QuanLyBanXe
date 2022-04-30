package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.CuaHang;

public class CuaHang_DAO {
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
	public List<CuaHang> getAllCuaHang() throws SQLException {
		// TODO Auto-generated method stub
		List<CuaHang> dsCuaHang = new ArrayList<>();
		CuaHang ch = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select MaCuaHang from CuaHang";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maCH = rs.getString("MaCuaHang");
				ch = new CuaHang(maCH);
				dsCuaHang.add(ch);
			}
			return dsCuaHang;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return null;
	}

}
