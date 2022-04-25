package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectDB.connectDB;
import Entity.NhanVien;

public class NhanVien_DAO {
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
}
