package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public List<CuaHang> getAllDSCuaHang() throws SQLException {
		List<CuaHang> dsCuaHang = new ArrayList<>();
		CuaHang ch = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select * from CuaHang";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maCH = rs.getString("MaCuaHang");
				String tinhTP = rs.getString("TinhTP");
				String quanHuyen = rs.getString("QuanHuyen");
				String phuongXa = rs.getString("PhuongXa");
				String hotlline = rs.getString("Hotline");
				ch = new CuaHang(maCH, tinhTP, quanHuyen,phuongXa,hotlline);
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
	public Boolean themCH(CuaHang ch) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement pStmt = null;
		int i = 0;
		try {
			String sql = "insert into CuaHang values(?,?,?,?,?)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,0);
			pStmt.setString(2, ch.getTinhTP());
			pStmt.setString(3, ch.getQuanHuyen());
			pStmt.setString(4, ch.getPhuongXa());	
			pStmt.setInt(5, Integer.parseInt(ch.getHotLine()));
			
			i = pStmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i > 0;
	}
	public boolean suaCH(CuaHang ch) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		conn = connectDB.getConnection();
		PreparedStatement pStmt = null;
		int i = 0;
		try {
			String sql = "update CuaHang set TinhTP=?, QuanHuyen=?, PhuongXa=?, Hotline=? where MaCuaHang=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ch.getTinhTP());
			pStmt.setString(2, ch.getQuanHuyen());
			pStmt.setString(3, ch.getPhuongXa());
			pStmt.setInt(4, Integer.parseInt(ch.getHotLine()));
			pStmt.setString(5, ch.getMaCuaHang());
			
			i = pStmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i > 0;
	}
	public Boolean xoaHD(String maCuaHang) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement pStmt = null;
		int i = 0;
		try {
			String sql = "delete from CuaHang where MaCuaHang='"+maCuaHang+"'";
			pStmt = conn.prepareStatement(sql);
			
			i = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i > 0;
	}

}
