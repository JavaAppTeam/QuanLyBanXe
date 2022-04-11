package Entity;

import java.time.LocalDate;

public class KhachHang {

	private String maKH, tenKH, sdt,cmnd,gioiTinh;
	private LocalDate ngaySinh;
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String tenKH, String sdt, String cmnd, String gioiTinh, LocalDate ngaySinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}
	public KhachHang(String tenKH, String sdt, String cmnd, String gioiTinh, LocalDate ngaySinh) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	

}
