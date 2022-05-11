package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import ConnectDB.connectDB;
import Entity.NhanVien;

public class NhanVien_DAO {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
	public List<NhanVien> getalltbNhanVien() throws SQLException {
		List<NhanVien> dsNV = null;
		try {
			conn = connectDB.getConnection();
			String sql = "Select * from NhanVien";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsNV = new ArrayList<>();
			
			
			
			while (rs.next()) {
				
				String idNV = rs.getString(1);
				String maNV = rs.getString(2);
				String tenNV = rs.getString(3);
				String cMND = rs.getString(4);
				String ngaySinh = rs.getString(5);
				String sDT = rs.getString(6);
				String maChucVu =rs.getString(7);
				String maCuaHang =rs.getString(8);
				String ngayVaoLam =rs.getString(9);
				String trinhDoHocVan = rs.getString(10) == null ? "0" : rs.getString(10);
				String bacTho =rs.getString(11) == null ? "Thợ Mới" : rs.getString(11);
				String soNamKinhNghiem = rs.getString(12) == null ? "0" : rs.getString(12);
				boolean trangThai =rs.getString(13).equals("1")? true : false;
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),trangThai);
				dsNV.add(NV);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsNV;
	}
	
	public List<NhanVien> getTKTenNhanVien(String keyw) throws SQLException {
		List<NhanVien> dsNV = null;
		try {
			conn = connectDB.getConnection();
			String sql = "Select * from NhanVien where TenNhanVien like '%" + keyw + "%'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsNV = new ArrayList<>();
			
			
			
			while (rs.next()) {
				
				String idNV = rs.getString(1);
				String maNV = rs.getString(2);
				String tenNV = rs.getString(3);
				String cMND = rs.getString(4);
				String ngaySinh = rs.getString(5);
				String sDT = rs.getString(6);
				String maChucVu =rs.getString(7);
				String maCuaHang =rs.getString(8);
				String ngayVaoLam =rs.getString(9);
				String trinhDoHocVan = rs.getString(10) == null ? "0" : rs.getString(10);
				String bacTho =rs.getString(11) == null ? "Tho moi" : rs.getString(11);
				String soNamKinhNghiem = rs.getString(12) == null ? "0" : rs.getString(12);
				boolean trangThai =rs.getString(13).equals("1")? true : false;
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),trangThai);
				dsNV.add(NV);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsNV;
	}
	public List<NhanVien> getTKCMNDNhanVien(String keyw) throws SQLException {
		List<NhanVien> dsNV = null;
		try {
			conn = connectDB.getConnection();
			String sql = "Select * from NhanVien where CMND like '%" + keyw + "%'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsNV = new ArrayList<>();
			
			
			
			while (rs.next()) {
				
				String idNV = rs.getString(1);
				String maNV = rs.getString(2);
				String tenNV = rs.getString(3);
				String cMND = rs.getString(4);
				String ngaySinh = rs.getString(5);
				String sDT = rs.getString(6);
				String maChucVu =rs.getString(7);
				String maCuaHang =rs.getString(8);
				String ngayVaoLam =rs.getString(9);
				String trinhDoHocVan = rs.getString(10) == null ? "0" : rs.getString(10);
				String bacTho =rs.getString(11) == null ? "Tho moi" : rs.getString(11);
				String soNamKinhNghiem = rs.getString(12) == null ? "0" : rs.getString(12);
				boolean trangThai =rs.getString(13).equals("1")? true : false;
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),trangThai);
				dsNV.add(NV);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsNV;
	}
	
	public List<NhanVien> getTKSDTNhanVien(String keyw) throws SQLException {
		List<NhanVien> dsNV = null;
		try {
			conn = connectDB.getConnection();
			String sql = "Select * from NhanVien where SDT like '%" + keyw + "%'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsNV = new ArrayList<>();
			
			
			
			while (rs.next()) {
				
				String idNV = rs.getString(1);
				String maNV = rs.getString(2);
				String tenNV = rs.getString(3);
				String cMND = rs.getString(4);
				String ngaySinh = rs.getString(5);
				String sDT = rs.getString(6);
				String maChucVu =rs.getString(7);
				String maCuaHang =rs.getString(8);
				String ngayVaoLam =rs.getString(9);
				String trinhDoHocVan = rs.getString(10) == null ? "0" : rs.getString(10);
				String bacTho =rs.getString(11) == null ? "Tho moi" : rs.getString(11);
				String soNamKinhNghiem = rs.getString(12) == null ? "0" : rs.getString(12);
				boolean trangThai =rs.getString(13).equals("1")? true : false;
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),trangThai);
				dsNV.add(NV);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsNV;
	}
	
	public List<NhanVien> getAllMaNV() throws SQLException {
		NhanVien nv = null;
		List<NhanVien> dsNV = new ArrayList<>();
		try {
			conn = connectDB.getConnection();
			String sql = "select MaSoNhanVien from NhanVien";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaSoNhanVien");
				nv = new NhanVien(maNV);
				dsNV.add(nv);
			}
			return dsNV;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	public boolean themNV(String tenNV,String cMND,String sDT,String maChucVu,String bacTho,String ngaySinh, 
			String ngayVaoLam,int trinhDoHocVan,int soNamKinhNghiem,boolean trangThai) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try {
			String sql = "insert into NhanVien values (Default,?,?,?,?,?,?,?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1,tenNV);
			statement.setString(2,cMND);
			statement.setString(3, ngaySinh);
			statement.setString(4, sDT);
			statement.setString(5, maChucVu);
			statement.setString(6, "CH01");
			statement.setString(7, ngayVaoLam);
			statement.setInt(8, trinhDoHocVan);
			statement.setString(9, bacTho);
			statement.setInt(10, soNamKinhNghiem);
			statement.setBoolean(11, trangThai);
			
			n = statement.executeUpdate();
		} catch (Exception e2) {
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        JOptionPane.showMessageDialog(frame,
	                "Trùng thông tin ",
	                "Thêm Thất Bại",
	                JOptionPane.ERROR_MESSAGE);
		}
		return n > 0;	
	}
	public String getMaNV(String SDT) throws SQLException {
		try {
			conn = connectDB.getConnection();
			String sql = "select MaSoNhanVien from NhanVien where SDT='"+SDT+"'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			String maNV = rs.getString("MaSoNhanVien");	
			System.out.println(maNV);
			return maNV;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	public Boolean suanv(String maNV, String tenNV,String cMND,String sDT,String maChucVu,String bacTho,String ngaySinh, 
			String ngayVaoLam,int trinhDoHocVan,int soNamKinhNghiem,boolean trangThai ) throws ClassNotFoundException, SQLException {
		Connection conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		try {
			String sql = "update NhanVien set TenNhanVien=N'"+tenNV+"', MaChucVu='"+maChucVu+"'"  + ",BacTho=N'"+bacTho+"'" +",SoNamKinhNghiem='"+soNamKinhNghiem+"'" + ",TrangThai='"+trangThai+"'" + ",NgaySinh='"+ngaySinh+"'"+ ",NgayVaoLam='"+ngayVaoLam+"'" +  ",SDT='"+sDT+"'" +" where MaSoNhanVien='"+maNV+"'";
			statement = conn.prepareStatement(sql);
			
			i = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        JOptionPane.showMessageDialog(frame,
	                "Cập nhập thông tin ",
	                "Cập nhập thất Bại",
	                JOptionPane.ERROR_MESSAGE);
		}
		return i > 0;
	}
	public Boolean xoaNV(String maNV) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		try {
			String sql = "update NhanVien set TrangThai='"+false+"'  where MaSoNhanVien='"+maNV+"'";
			statement = conn.prepareStatement(sql);
			
			i = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i > 0;
	}
	public String getTenNVFormMaNV(String maNV) {
		try {
			conn = connectDB.getConnection();
			String sql = "select TenNhanVien from NhanVien where MaSoNhanVien="+"'"+maNV+"'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenNV = rs.getString("TenNhanVien");
				return tenNV;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
