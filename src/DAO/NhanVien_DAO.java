package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.NhanVien;

public class NhanVien_DAO {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
	public NhanVien_DAO() {
			
	}
	public ArrayList<NhanVien> getalltbNhanVien() throws ClassNotFoundException{
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			String sql = "Select * from NhanVien";
			java.sql.Statement statement =  con.createStatement();
			ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
			
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
				String trinhDoHocVan =rs.getString(10);
				String bacTho =rs.getString(11);
				String soNamKinhNghiem =rs.getString(12);
				String trangThai =rs.getString(13);
				
				NhanVien NV = new NhanVien(maNV,tenNV,cMND,sDT,maChucVu,bacTho,LocalDate.parse(ngaySinh, formatter),LocalDate.parse(ngayVaoLam, formatter),Integer.parseInt(trinhDoHocVan),Integer.parseInt(soNamKinhNghiem),Boolean.parseBoolean(trangThai));
				dsNV.add(NV);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	public List<NhanVien> getAllMaNV() throws SQLException {
		NhanVien nv = null;
		List<NhanVien> dsNV = new ArrayList<>();
		try {
			conn = connectDB.getConnection();
			String sql = "select MaSoNhanVien from NhanVien";
			stmt = conn.createStatement();
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
}
