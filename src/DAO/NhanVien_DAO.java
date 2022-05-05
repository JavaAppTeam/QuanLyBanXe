package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				String bacTho =rs.getString(11) == null ? "Tho moi" : rs.getString(11);
				String soNamKinhNghiem = rs.getString(12) == null ? "0" : rs.getString(12);
				String trangThai =rs.getString(13);
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),Boolean.parseBoolean(trangThai));
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
	public boolean themNV(String tenNV,String cMND,String sDT,String maChucVu,String bacTho,LocalDate ngaySinh, LocalDate ngayVaoLam,int trinhDoHocVan,int soNamKinhNghiem,boolean trangThai) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try {
			String sql = "insert into NhanVien values (Default,?,?,?,?,?,?,?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1,);
			statement.setTimestamp(2,date);
			statement.setString(3, maNV);
			statement.setString(4, maKH);
			statement.setString(5, maCH);
			
			n = statement.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return n > 0;	
	}
}
