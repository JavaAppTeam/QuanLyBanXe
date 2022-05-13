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
import Entity.LoaiXe;
import Entity.Xe;

public class Xe_DAO {
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

	public Xe getXeMaXe(String maxe, int soluong, int giatien) throws SQLException {
		Xe xe = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select x.TenXe, x.DungTich, ctx.SoKhung, ctx.SoMay, ctx.MaXe from Xe x join ChiTietXe ctx on x.IDXe = ctx.IDXe  where ctx.MaXe="
					+ "'" + maxe + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maxes = rs.getString("MaXe");
				String tenxe = rs.getString("TenXe");
				String sokhung = rs.getString("SoKhung");
				String somay = rs.getString("SoMay");
				String dungtich = rs.getString("DungTich");
				xe = new Xe(maxes, tenxe, soluong, sokhung, somay, dungtich, giatien);
			}
			return xe;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public List<Xe> getListXeOnMaHD(String maHDFrmHD) throws ClassNotFoundException, SQLException {
		Xe xe = null;
		List<Xe> dsXe = new ArrayList<Xe>();
		conn = connectDB.getConnection();
		int stt = 0;
		try {
			String sql = "select x.TenXe, cthd.SoLuong, cthd.DonGia, kh.TenKH from KhachHang kh join HoaDon hd on kh.MaKH=hd.MaKH\r\n"
					+ "						   join ChiTietHoaDon cthd on hd.MaHoaDon=cthd.MaHoaDon\r\n"
					+ "						   join ChiTietXe ctx on cthd.MaXe=ctx.MaXe\r\n"
					+ "						   join Xe x on x.IDXe=ctx.IDXe\r\n"
					+ "						   where cthd.MaHoaDon=" + "'" + maHDFrmHD + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				stt += 1;
				String tenXe = rs.getString("TenXe");
				int soLuong = rs.getInt("SoLuong");
				float donGia = rs.getFloat("DonGia");
				String tenKH = rs.getString("TenKH");
				xe = new Xe(stt, tenXe, soLuong, donGia, tenKH);
				dsXe.add(xe);
			}
			return dsXe;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Xe> getallSP() throws Exception {
		List<Xe> lstXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM Xe WHERE trangthai=1";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstXe = new ArrayList<>();
			while (rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThai = rs.getBoolean(9);
				lstXe.add(new Xe(maXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstXe;
	}

	public List<Xe> getXeTheoDanhMuc(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean trangThai)
			throws Exception {
		List<Xe> lstXe = null;
		int flat = 1;
		String sql;
		try {
			Connection con = connectDB.getConnection();
			if (!trangThai)
				flat = 0;
			if (maLoaiXeTK.isEmpty()) {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "%') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND"
						+ " (trangthai = " + flat + ")";
			} else {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND"
						+ " (IDLoaiXe = " + maLoaiXeTK + ") AND" + " (trangthai = " + flat + ")";
			}

			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstXe = new ArrayList<>();
			while (rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThaiXe = rs.getBoolean(9);
				lstXe.add(new Xe(maXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThaiXe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstXe;
	}

	public List<Xe> getXeTheoGiaTienDuoi20(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean trangThai) throws Exception {
		List<Xe> lstXe = null;
		int flat = 1;
		String sql;
		try {
			Connection con = connectDB.getConnection();
			if (!trangThai)
				flat = 0;
			if (maLoaiXeTK.isEmpty() || maLoaiXeTK == null) {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "%') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND" +
						" (GiaTien <= 20000000) AND"
						+ " (trangthai = " + flat + ")";
			} else {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND"
						+ " (IDLoaiXe = " + maLoaiXeTK + ") AND" +
						" (GiaTien <= 20000000) AND"+ 
						" (trangthai = " + flat + ")";
			}
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstXe = new ArrayList<>();
			while (rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThaiXe = rs.getBoolean(9);
				lstXe.add(new Xe(maXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThaiXe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstXe;
	}

	public List<Xe> getXeTheoGiaTienTu20TDen100T(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean trangThai) throws Exception {
		List<Xe> lstXe = null;
		int flat = 1;
		String sql;
		try {
			Connection con = connectDB.getConnection();
			if (!trangThai)
				flat = 0;
			if (maLoaiXeTK.equals("")) {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "%') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND" +
						" (GiaTien >= 20000000 AND GiaTien <= 100000000) AND"
						+ " (trangthai = " + flat + ")";
			} else {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND"
						+ " (IDLoaiXe = " + maLoaiXeTK + ") AND" +
						" (GiaTien >= 20000000 AND GiaTien <= 100000000) AND"+ 
						" (trangthai = " + flat + ")";
			}
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstXe = new ArrayList<>();
			while (rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThaiXe = rs.getBoolean(9);
				lstXe.add(new Xe(maXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThaiXe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstXe;
	}

	public List<Xe> getXeTheoGiaTienTren100T(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean trangThai) throws Exception {
		List<Xe> lstXe = null;
		int flat = 1;
		String sql;
		try {
			Connection con = connectDB.getConnection();
			if (!trangThai)
				flat = 0;
			if (maLoaiXeTK.isEmpty()) {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "%') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND" +
						" (GiaTien > 100000000) AND"
						+ " (trangthai = " + flat + ")";
			} else {
				sql = "SELECT IDXe, TenXe, MaHangXe, IDLoaiXe, MucTieuThuNhienLieu, DungTich, GiaTien, SoLuongTon, trangthai FROM Xe"
						+ " WHERE  (TenXe LIKE N'%" + tenXeTK + "') AND" + " (MaHangXe LIKE '%" + maHangTK + "') AND"
						+ " (IDLoaiXe = " + maLoaiXeTK + ") AND" +
						" (GiaTien > 100000000) AND"+ 
						" (trangthai = " + flat + ")";
			}
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstXe = new ArrayList<>();
			while (rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThaiXe = rs.getBoolean(9);
				lstXe.add(new Xe(maXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThaiXe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstXe;
	}

	public List<HangXe> getAllHangXe() throws Exception {
		List<HangXe> lstHangXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM HangXe";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstHangXe = new ArrayList<>();
			while (rs.next()) {
				String maHangXe = rs.getString(1);
				String tenHangXe = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				lstHangXe.add(new HangXe(maHangXe, tenHangXe, trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstHangXe;
	}

	public List<LoaiXe> getAllLoaiXe() throws Exception {
		List<LoaiXe> lstLoaiXe = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM LoaiXe";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			lstLoaiXe = new ArrayList<>();
			while (rs.next()) {
				int maLoai = rs.getInt(1);
				String tenLoai = rs.getString(2);
				boolean trangThai = rs.getBoolean(3);
				lstLoaiXe.add(new LoaiXe(maLoai, tenLoai, trangThai));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lstLoaiXe;
	}

	public Xe getSPTheoID(String maXe) throws Exception {
		Xe xe;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM Xe WHERE IDXe ='" + maXe + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				int idXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThai = rs.getBoolean(9);
				xe = new Xe(idXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThai);
				return xe;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			closeConnection();
		}
		return null;
	}

	public Xe getSPTheoTen(String ten) throws Exception {
		Xe xe;
		try {
			Connection con = connectDB.getConnection();
			String sql = "SELECT * FROM Xe WHERE TenXe =N'" + ten + "'";
			java.sql.Statement statement = con.createStatement();
			rs = ((java.sql.Statement) statement).executeQuery(sql);
			while (rs.next()) {
				int idXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String maHangXe = rs.getString(3);
				String idLoaiXe = rs.getString(4);
				double mucTieuThu = rs.getDouble(5);
				double dungTich = rs.getDouble(6);
				int giaTien = rs.getInt(7);
				int soLuong = rs.getInt(8);
				boolean trangThai = rs.getBoolean(9);
				xe = new Xe(idXe, soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThai);
				return xe;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public boolean themSPS(Xe dto) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "Insert into Xe values(?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, dto.getTenXe());
			statement.setString(2, dto.getMaHangXe());
			statement.setString(3, dto.getMaLoai());
			statement.setDouble(4, dto.getMucTieuThu());
			statement.setDouble(5, dto.getDungTich());
			statement.setDouble(6, dto.getGiaTien());
			statement.setInt(7, dto.getSoLuongTon());
			statement.setBoolean(8, dto.isTrangThai());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capnhat(Xe xe, int maXe) throws ClassNotFoundException, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		System.out.println(xe);
		try {
			statement = con.prepareStatement(
					"UPDATE Xe SET TenXe=?,MaHangXe=?,IDLoaiXe=?,MucTieuThuNhienLieu=?,DungTich=?,GiaTien=?,SoLuongTon=?,trangthai=? WHERE IDXe=?");
			statement.setString(1, xe.getTenXe());
			statement.setString(2, xe.getMaHangXe());
			statement.setInt(3, Integer.parseInt(xe.getMaLoai()));
			statement.setDouble(4, xe.getMucTieuThu());
			statement.setDouble(5, xe.getDungTich());
			statement.setDouble(6, xe.getGiaTien());
			statement.setInt(7, xe.getSoLuongTon());
			statement.setBoolean(8, xe.isTrangThai());
			statement.setInt(9, maXe);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean deleteXe(int maXe) throws Exception, SQLException {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("UPDATE Xe SET trangThai=0 WHERE IDXe=?");
			deleteCTXe(maXe);
			stmt.setInt(1, maXe);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean deleteCTXe(int maXe) throws Exception {
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE ChiTietXe SET TrangThai=0 WHERE IDXe=?");
			stmt.setInt(1, maXe);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

}
