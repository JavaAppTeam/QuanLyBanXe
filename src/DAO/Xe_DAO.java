package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectDB.connectDB;
import Entity.Xe;

public class Xe_DAO {
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
	public Xe getXeMaXe(String maxe, int soluong, int giatien) throws SQLException {
		Xe xe = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select x.TenXe, x.DungTich, ctx.SoKhung, ctx.SoMay, ctx.MaXe from Xe x join ChiTietXe ctx on x.IDXe = ctx.IDXe  where ctx.MaXe="+"'"+maxe+"'";
			stmt = conn.createStatement();
			rs =stmt.executeQuery(sql);
			while (rs.next()) {
				String maxes = rs.getString("MaXe");
				String tenxe = rs.getString("TenXe");
				String sokhung = rs.getString("SoKhung");
				String somay = rs.getString("SoMay");
				String dungtich = rs.getString("DungTich");
				xe = new Xe(maxes,tenxe,soluong,sokhung,somay,dungtich,giatien*1.0);
				}
			return xe;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}

}
