package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.KhachHang;
import Entity.PhuTungXe;

public class KhachHang_DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	List<KhachHang> lstKhachHang;
	public KhachHang_DAO() throws ClassNotFoundException, SQLException {
		lstKhachHang = new ArrayList<KhachHang>();
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
	public List<KhachHang> getAll() throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[KhachHang]");
		ResultSet rs  = ps.executeQuery();
		while(rs.next()) {
			String gt =  rs.getBoolean("GioiTinh")?"Nam":"Nữ";
			KhachHang kh= new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getDate("NgaySinh"),  rs.getString("SoDienThoai"),  rs.getString("CMND"), gt); 
			this.lstKhachHang.add(kh);
		}
		closeConnection();
		return this.lstKhachHang;
	}
	public List<KhachHang> findKH(String makh) {
		List<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			conn = connectDB.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from KhachHang where MaKH =?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(1,makh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				String gt =  rs.getBoolean("GioiTinh")?"Nam":"Nữ";
				KhachHang rskh= new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getDate("NgaySinh"),  rs.getString("SoDienThoai"),  rs.getString("CMND"), gt); 
				dsKH.add(rskh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsKH;
	}
	public List<KhachHang> getAllSdtKH() throws SQLException {
		// TODO Auto-generated method stub
		KhachHang kh = null;
		List<KhachHang> dsKH = new ArrayList<>();
		try {
			conn = connectDB.getConnection();
			String sql = "select SoDienThoai from KhachHang";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String sdt = rs.getString("SoDienThoai");
				kh = new KhachHang(sdt);
				dsKH.add(kh);
			}
			return dsKH;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return dsKH;
	}
	public boolean addKH(KhachHang kh) throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into [QuanLyCuaHangXe].[dbo].[KhachHang] values (?,?,?,?,?,?)");
		ps.setString(1, kh.getMaKH());
		ps.setString(2, kh.getTenKH());
		ps.setString(3, kh.getNgaySinh().toString());
		ps.setString(4, kh.getSdt());
		ps.setString(5, kh.getCMND());
		String gt = kh.getGioiTinh()=="Nam"?"True":"False";
		ps.setString(6, gt);
		
		int rs = ps.executeUpdate();
		closeConnection();
		return rs ==1?true:false;
	}
	
	public boolean themKh(KhachHang kh) throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "Insert into KhachHang values(Default,?,?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, kh.getTenKH());
			statement.setString(2,kh.getNgaySinh().toString());
			statement.setString(3, kh.getSdt());
			statement.setString(4, kh.getCMND());
			String gt = kh.getGioiTinh()=="Nam"?"True":"False";
			statement.setString(5, gt);
			statement.setBoolean(6, true);
			n = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n ==1?true:false;
	}
	
	

	public boolean updateKH(KhachHang kh) throws SQLException, ClassNotFoundException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("update [QuanLyCuaHangXe].[dbo].[KhachHang] set TenKH = ?,NgaySinh = ?, SoDienThoai = ?, CMND = ?, GioiTinh =? where MaKH =? ");
	
		ps.setString(1, kh.getTenKH());
		ps.setString(2, kh.getNgaySinh().toString());
		ps.setString(3, kh.getSdt());
		ps.setString(4, kh.getCMND());
		String gt = kh.getGioiTinh()=="Nam"?"True":"False";
		ps.setString(5, gt);
		ps.setString(6, kh.getMaKH());	
		int rs = ps.executeUpdate();
		closeConnection();
		return rs ==1?true:false;
		}
	public boolean deleteKH(String maKH) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from [QuanLyCuaHangXe].[dbo].[KhachHang] where MaKH = '"+maKH+"' ");
//		ps.setString( 1, maKH);
		int rs = ps.executeUpdate();
		closeConnection();
		return rs ==1?true:false;
	}
	public String getKHTheoSDT(String sdt) throws SQLException {
		//KhachHang kh;
		try {
			conn = connectDB.getConnection();
			String sql = "select MaKH from KhachHang where SoDienThoai="+"'"+sdt+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				return maKH;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	public String getTenToMaKH(String maKH) throws SQLException {
		try {
			conn = connectDB.getConnection();
			String sql = "select TenKH from KhachHang where MaKH="+"'"+maKH+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenKH = rs.getString("TenKH");
				return tenKH;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	public String getMaHDFromSDT(String sdt) {
		try {
			conn = connectDB.getConnection();
			String sql = "select MaKH from KhachHang where SoDienThoai="+"'"+sdt+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				return maKH;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getTenFormSDT(String sDT) {
		try {
			conn = connectDB.getConnection();
			String sql = "select TenKH from KhachHang where SoDienThoai="+"'"+sDT+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenKH = rs.getString("TenKH");
				return tenKH;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
