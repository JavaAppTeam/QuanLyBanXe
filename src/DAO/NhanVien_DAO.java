package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.connectDB;
import Entity.NhanVien;

public class NhanVien_DAO {
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
	public ArrayList<NhanVien> getalltbNhanVien(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			String sql = "Select * from NhanVien";
			java.sql.Statement statement =  con.createStatement();
			ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String sDT = rs.getString(3);
				String diaChi = rs.getString(4);
				String email = rs.getString(5);
				String	chucVu =rs.getString(6);
				NhanVien NV = new NhanVien(maNV, tenNV, sDT, diaChi, email,chucVu);
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
