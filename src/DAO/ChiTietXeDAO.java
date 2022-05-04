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
	
	public List<ChiTietXe> getallSP(int maXe) throws Exception {
		List<ChiTietXe> lstChiTietXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT MaXe, SoKhung, SoMay, IDXe, ThoiHanBaoHanh, TrangThai FROM ChiTietXe WHERE trangthai=1 and IDXe ='" + maXe + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstChiTietXe = new ArrayList<>();
			while (rs.next()) {
				String maCTXe = rs.getString(1);
				String soKhung = rs.getString(2);
				String soMay = rs.getString(3);
				int idXe = rs.getInt(4);
				int thoiGianBH = rs.getInt(5);
				boolean trangThai = rs.getBoolean(6);
				lstChiTietXe.add(new ChiTietXe(maCTXe, soKhung, soMay, idXe, thoiGianBH, trangThai));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstChiTietXe;
	}

	public boolean themSPS(ChiTietXe ctXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			// YMH01-0000
			String sql = "Insert into ChiTietXe values(Default,?,?,?,Default)";
			statement = con.prepareStatement(sql);
			statement.setString(1, ctXe.getSoKhung());
			statement.setInt(2, ctXe.getMaXe());
			statement.setInt(3, ctXe.getThoiGianBH());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ChiTietXe getChiTietXe(String soKhung) throws Exception {
		ChiTietXe ctXe;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT MaXe, SoKhung, SoMay, IDXe, ThoiHanBaoHanh, TrangThai FROM ChiTietXe WHERE SoKhung like N'%" + soKhung + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				String maCtXe = rs.getString(1);
				String khungXe = rs.getString(2);
				String soMay = rs.getString(3);
				int idXe = rs.getInt(4);
				int tgBaoHanh = rs.getInt(5);
				boolean trangThai = rs.getBoolean(6);
				ctXe = new ChiTietXe(maCtXe, soKhung, soMay, idXe, tgBaoHanh, trangThai);
				System.out.println(ctXe);
				return ctXe;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public boolean capnhat(ChiTietXe ctXe, String maCTXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		System.out.println(ctXe);
		try {
			statement = con.prepareStatement("UPDATE ChiTietXe SET ThoiHanBaoHanh=?,TrangThai=? WHERE MaXe=?");
			statement.setInt(1,ctXe.getThoiGianBH());
			statement.setBoolean(2, ctXe.isTrangThai());
			statement.setString(3, maCTXe);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteCTXe(String maCTXe) throws Exception {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE ChiTietXe SET TrangThai=0 WHERE MaXe=?");
			stmt.setString(1, maCTXe);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

}
