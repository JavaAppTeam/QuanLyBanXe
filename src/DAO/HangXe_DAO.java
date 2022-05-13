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
			HangXe hx = new HangXe(rs.getString("MaHangXe"),rs.getString("TenHang"),rs.getBoolean("trangthai"));
			lstHangXe.add(hx);
		}
		closeConnection();
		return lstHangXe;		
	}
	public List<HangXe> findAll(HangXe hxc,String tt) {
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[HangXe] where MaHangXe =? and TenHang=? and trangthai =?");
			ps.setString(1, hxc.getMaHang());
			ps.setString(2, hxc.getTenHang());
			ps.setString(2, tt);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HangXe hx = new HangXe(rs.getString("MaHangXe"),rs.getString("TenHang"),rs.getBoolean("trangthai"));
				lstHangXe.add(hx);
			}
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstHangXe;
	}
	
	public boolean updateHX(HangXe hx)  {
		int rs = 0;
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("update [QuanLyCuaHangXe].[dbo].[HangXe] set TenHang =? where MaHangXe =?");
			ps.setString(1, hx.getTenHang());
			ps.setString(2, hx.getMaHang());
			rs = ps.executeUpdate();
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs==1?true:false;
	}
	public boolean deleteHX(HangXe hx) {
		int rs = 0;
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("update [QuanLyCuaHangXe].[dbo].[HangXe] set trangthai ='false' where MaHangXe =?");
			ps.setString(1, hx.getMaHang());
			rs = ps.executeUpdate();
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs==1?true:false;
	}
	public boolean addHX(HangXe hx) {
		int rs = 0;
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into [QuanLyCuaHangXe].[dbo].[HangXe] values(?,?,1)");
			ps.setString(1, hx.getMaHang());
			ps.setString(2, hx.getTenHang());
			rs = ps.executeUpdate();
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs==1?true:false;
		
	}
	public HangXe findAllbyMa(String mahx, String tt) {
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[HangXe] where MaHangXe =? and trangthai =?");
			ps.setString(1, mahx);
			ps.setString(2, tt);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HangXe hx = new HangXe(rs.getString("MaHangXe"),rs.getString("TenHang"),rs.getBoolean("trangthai"));
				return hx;
			}
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public HangXe findAllbyTen(String Tenhx, String tt) {
		try {
			conn = connectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[HangXe] where TenHang =? and trangthai =?");
			ps.setString(1, Tenhx);
			ps.setString(2, tt);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HangXe hx = new HangXe(rs.getString("MaHangXe"),rs.getString("TenHang"),rs.getBoolean("trangthai"));
				return hx;
			}
			closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
