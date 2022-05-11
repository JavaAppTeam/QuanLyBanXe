package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.HangXe;
public class HangXe_DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	List<HangXe> lstHangXe ;
	public HangXe_DAO() {
		this.lstHangXe = new ArrayList<HangXe>();
		
	}
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
	public List<HangXe> getAll() throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[HangXe]");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			HangXe hx = new HangXe(rs.getNString("MaHangXe"),rs.getString("TenHang"),rs.getBoolean("trangthai"));
			lstHangXe.add(hx);
		}
		closeConnection();
		return lstHangXe;
		
	}
	public boolean addHX(HangXe hx) throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("update [QuanLyCuaHangXe].[dbo].[HangXe] set ,TenHang =? where MaHangXe =?");
		ps.setString(0, hx.getTenHang());
		ps.setString(0, hx.getMaHang());
		int rs = ps.executeUpdate();
		return rs==1?true:false;
	}
	public boolean deleteHX(HangXe hx) throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete [QuanLyCuaHangXe].[dbo].[HangXe] where MaHangXe =?");
		ps.setString(0, hx.getMaHang());
		int rs = ps.executeUpdate();
		return rs==1?true:false;
	}
}
