package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class HoaDon {

	private String maHoaDon,maNV,maKH,maCH;
	private Date ngayLap;
	String maxe;
	float dongia;
	float thue;
	int soluong;
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHoaDon, String maNV, String maKH, String maCH, Date ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maCH = maCH;
		this.ngayLap = ngayLap;
	}
	public HoaDon(String maHoaDon, String maNV, String maKH, String maCH, Date ngayLap,String maxe,float dongia,float thue) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maCH = maCH;
		this.ngayLap = ngayLap;
		this.maxe = maxe;
		this.dongia = dongia;
		this.thue = thue;
	}
	public HoaDon(String maNV, String maKH, String maCH, Date ngayLap) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.maCH = maCH;
		this.ngayLap = ngayLap;
	}
	public HoaDon(int soLuong) {
		this.soluong = soLuong;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getMaxe() {
		return maxe;
	}
	public void setMaxe(String maxe) {
		this.maxe = maxe;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public float getThue() {
		return thue;
	}
	public void setThue(float thue) {
		this.thue = thue;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaCH() {
		return maCH;
	}
	public void setMaCH(String maCH) {
		this.maCH = maCH;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
}
