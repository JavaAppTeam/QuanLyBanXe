package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.ChucVuNhanVien;

public class ChucVuNhanVien_DAO {
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
	public List<ChucVuNhanVien> getAllCVNhanVien() throws SQLException {
		// TODO Auto-generated method stub
		List<ChucVuNhanVien> dsCVNV = new ArrayList<>();
		ChucVuNhanVien cVNV = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select MaChucVu from ChucVuNhanVien";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maCVNV = rs.getString("MaChucVu");
				cVNV = new ChucVuNhanVien(maCVNV);
				dsCVNV.add(cVNV);
			}
			return dsCVNV;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return null;
	}
}
