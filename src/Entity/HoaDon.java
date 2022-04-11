package Entity;

import java.time.LocalDate;

public class HoaDon {

	private String maHoaDon,maNV,maKH,maCH;
	private LocalDate ngayLap;
	private boolean trangThai;
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHoaDon, String maNV, String maKH, String maCH, LocalDate ngayLap, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maCH = maCH;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
	}
	public HoaDon(String maNV, String maKH, String maCH, LocalDate ngayLap, boolean trangThai) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.maCH = maCH;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
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
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
}
