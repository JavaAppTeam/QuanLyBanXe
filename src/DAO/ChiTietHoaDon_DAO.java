package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.connectDB;
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

	public boolean themCTHD(String maHD, String maXe,float donGia, float thue, int soluong) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into ChiTietHoaDon (MaHoaDon,MaXe,DonGia,Thue,SoLuong) values (?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, maHD);
			statement.setString(2, maXe);
			statement.setFloat(3, donGia);
			statement.setFloat(4, thue);
			statement.setInt(5, soluong);
			
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
//	private ChiTietHoaDon getChiTietHoaDon() {
//		// TODO Auto-generated method stub
//		
//	}
}
