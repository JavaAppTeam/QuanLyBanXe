package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ConnectDB.connectDB;
import Entity.HoaDon;

public class HoaDon_DAO {
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
	public List<HoaDon> getAllHD() throws SQLException {
		List<HoaDon> dsHD = null;
		HoaDon hoaDon;
		try {
			conn = connectDB.getConnection();
			String sql = "select * from HoaDon";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			dsHD = new ArrayList<>();
			while (rs.next()) {			
				String strMaHD = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				String msnv = rs.getString(4);
				String mkh = rs.getString(5);
				String mch = rs.getString(6);
				hoaDon = new HoaDon(strMaHD,msnv,mkh,mch,ngayLap);
				dsHD.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return dsHD;
	}
	public HoaDon getAllHDTotext(String rowSelect) throws SQLException {
		HoaDon hoaDon = null;
		try {
			conn = connectDB.getConnection();
			String sql = "select SoLuong from HoaDon hd join ChiTietHoaDon cthd on hd.MaHoaDon = cthd.MaHoaDon where hd.MaHoaDon="+"'"+rowSelect+"'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			hoaDon = new HoaDon();
			while (rs.next()) {			
//				String strMaHD = rs.getString(2);
//				Date ngayLap = rs.getDate(3);
//				String msnv = rs.getString(4);
//				String mkh = rs.getString(5);
//				String mch = rs.getString(6);
//				String maxe = rs.getString(8);
//				Float dongia = rs.getFloat(9);
				int soLuong = rs.getInt(0);
				hoaDon = new HoaDon(soLuong);
				return hoaDon;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return hoaDon;
	}
	public boolean themHD(String maNV, String maKH, String maCH) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try {
			String sql = "insert into HoaDon (MaHoaDon,NgayLapHoaDon,MaSoNhanVien,MaKH,MaCuaHang) values (?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "");
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
	public String getMaHD() {
		try {
			conn = connectDB.getConnection();
			String sql = "SELECT TOP 1 * FROM HoaDon ORDER BY IDHoaDon DESC";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				return maHD;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getIDHD() {
		try {
			conn = connectDB.getConnection();
			String sql = "SELECT TOP 1 * FROM HoaDon ORDER BY IDHoaDon DESC";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int idHD = rs.getInt("IDHoaDon");
				return idHD;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public Boolean suaHD(String maKH, String maHD) throws ClassNotFoundException, SQLException {
		Connection conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		try {
			String sql = "update HoaDon set MaKH='"+maKH+"'"+ " where MaHoaDon='"+maHD+"'";
			statement = conn.prepareStatement(sql);
			
			i = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i > 0;
	}
	public Boolean xoaHD(String maHD) throws ClassNotFoundException, SQLException {
		conn = connectDB.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		try {
			String sql = "delete from HoaDon where MaHoaDon='"+maHD+"'";
			statement = conn.prepareStatement(sql);
			
			i = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i > 0;
	}
	public List<HoaDon> getAllMaHD(String maHd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HoaDon hd = null;
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		conn = connectDB.getConnection();
		Statement stmt = null;
		try {
			String sql = "select * from HoaDon where MaHoaDon='"+maHd+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				Date ngayLap = rs.getDate("NgayLapHoaDon");
				String maNV = rs.getString("MaSoNhanVien");
				String maKH = rs.getString("MaKH");
				String maCH = rs.getString("MaCuaHang");
				hd = new HoaDon(maHD,maNV,maKH,maCH,ngayLap);
				dsHD.add(hd);
			}
			return dsHD;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsHD;
	}
	public List<HoaDon> getAllMaHDToSdtKH(int iMaHD) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HoaDon hd = null;
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		conn = connectDB.getConnection();
		Statement stmt = null;
		try {
			String sql = "select * from KhachHang kh join HoaDon hd on kh.MaKH = hd.MaKH where kh.SoDienThoai='0"+iMaHD+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				Date ngayLap = rs.getDate("NgayLapHoaDon");
				String maNV = rs.getString("MaSoNhanVien");
				String maKH = rs.getString("MaKH");
				String maCH = rs.getString("MaCuaHang");
				hd = new HoaDon(maHD,maNV,maKH,maCH,ngayLap);
				dsHD.add(hd);
			}
			return dsHD;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsHD;
	}
	public List<HoaDon> addDshdToCuaHang(String maCh) throws ClassNotFoundException, SQLException {
		HoaDon hd = null;
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		conn = connectDB.getConnection();
		Statement stmt = null;
		try {
			String sql = "select * from CuaHang ch join HoaDon hd on ch.MaCuaHang = hd.MaCuaHang where ch.MaCuaHang='"+maCh+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				Date ngayLap = rs.getDate("NgayLapHoaDon");
				String maNV = rs.getString("MaSoNhanVien");
				String maKH = rs.getString("MaKH");
				String maCH = rs.getString("MaCuaHang");
				hd = new HoaDon(maHD,maNV,maKH,maCH,ngayLap);
				dsHD.add(hd);
			}
			return dsHD;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsHD;
	}

}
