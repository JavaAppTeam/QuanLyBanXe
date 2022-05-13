package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.*;
import Entity.TaiKhoan;

public class LoginDao {
	/**
	 * Launch the application.
	 * Tên: Trần Văn Sỹ
	 * Ngày tạo: 27/04/2022
	 */
	Connection conn;
	ResultSet rs;
	PreparedStatement preStm;
	
	
	
	private void closeConnect() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if (preStm != null) {
			preStm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	public boolean getAcount(String userName,String pass) throws Exception {
		ArrayList<TaiKhoan> lstTK = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM TaiKhoanNhanVien WHERE (MaSoNhanVien = '"+userName+"' AND MatKhau='"+pass+"')";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstTK = new ArrayList<>();
			while (rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				lstTK.add(new TaiKhoan(username, password));
				if(lstTK!=null)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return false;
	}
	
}
