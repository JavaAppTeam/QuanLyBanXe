package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.ChiTietHoaDon;

public class ChiTietHoaDon_DAO {
	Connection conn;
	PreparedStatement stmt;
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
	
//	private ChiTietHoaDon getChiTietHoaDon() {
//		// TODO Auto-generated method stub
//		
//	}
}
