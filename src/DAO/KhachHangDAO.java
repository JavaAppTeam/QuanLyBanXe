package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.KhachHang;

public class KhachHangDAO {
	Connection conn;
	List<KhachHang> lstKhachHang ;
	public KhachHangDAO() throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();	
		lstKhachHang = new ArrayList<KhachHang>();
	}
	
	public List<KhachHang> getAll() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from [QuanLyCuaHangXe].[dbo].[KhachHang]");
		ResultSet rs  = ps.executeQuery();
		while(rs.next()) {
			String gt =  rs.getBoolean("GioiTinh")?"Nam":"Nữ";
			KhachHang kh= new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getDate("NgaySinh"),  rs.getString("SoDienThoai"),  rs.getString("CMND"), gt); 
			this.lstKhachHang.add(kh);
		}
		return this.lstKhachHang;
	}
	public boolean addKH(KhachHang kh) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into [QuanLyCuaHangXe].[dbo].[KhachHang] values (?,?,?,?,?,?)");
		ps.setString(1, kh.getMaKH());
		ps.setString(2, kh.getTenKH());
		ps.setString(3, kh.getNgaySinh().toString());
		ps.setString(4, kh.getSdt());
		ps.setString(5, kh.getCMND());
		ps.setString(6, kh.getGioiTinh());
		
		int rs = ps.executeUpdate();
		return rs ==1?true:false;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		KhachHang_DAO khDAO = new KhachHang_DAO();
		KhachHang kh = new KhachHang("KH018", "Dat", Date.valueOf("2012-01-01"), "12312", "123", "false");
		System.out.println(khDAO.addKH(kh));	
	}
	
}