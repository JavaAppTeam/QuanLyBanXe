package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.HoaDon;

public class HoaDon_DAO {
	Connection conn;
	PreparedStatement preStm;
	ResultSet rs;
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
	public List<HoaDon> getAllHD() throws SQLException {
		List<HoaDon> dsHD = null;
		HoaDon hoaDon;
		try {
			conn = connectDB.getConnection();
			String sql = "select * from HoaDon";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsHD = new ArrayList<>();
			while (rs.next()) {			
				String strMaHD = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				String msnv = rs.getString(4);
				String mkh = rs.getString(5);
				String mch = rs.getString(6);
				hoaDon = new HoaDon(strMaHD,msnv,mkh,mch,ngayLap);
				dsHD.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsHD;
	}
	public HoaDon getAllHDTotext(String rowSelect) throws SQLException {
		HoaDon hoaDon = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select SoLuong from HoaDon hd join ChiTietHoaDon cthd on hd.MaHoaDon = cthd.MaHoaDon where hd.MaHoaDon="+"'"+rowSelect+"'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			hoaDon = new HoaDon();
			while (rs.next()) {			
//				String strMaHD = rs.getString(2);
//				Date ngayLap = rs.getDate(3);
//				String msnv = rs.getString(4);
//				String mkh = rs.getString(5);
//				String mch = rs.getString(6);
//				String maxe = rs.getString(8);
//				Float dongia = rs.getFloat(9);
				int soLuong = rs.getInt(0);
				hoaDon = new HoaDon(soLuong);
				return hoaDon;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return hoaDon;
	}

}
