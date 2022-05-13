package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class HoaDonBaoHanh {
	private String maHDBaoHanh,ghiChu;
	private boolean trangThai,lyDoBaoHanh;
	private Date ngayLap;

	public HoaDonBaoHanh() {
		// TODO Auto-generated constructor stub
	}
	

	public HoaDonBaoHanh(String maHDBaoHanh, boolean lyDoBaoHanh, String ghiChu, boolean trangThai, Date ngayLap) {
		super();
		this.maHDBaoHanh = maHDBaoHanh;
		this.lyDoBaoHanh = lyDoBaoHanh;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.ngayLap = ngayLap;
	}

	

	public HoaDonBaoHanh(boolean lyDoBaoHanh, String ghiChu, boolean trangThai) {
		super();
		this.lyDoBaoHanh = lyDoBaoHanh;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}


	public Date getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	public String getMaHDBaoHanh() {
		return maHDBaoHanh;
	}

	public void setMaHDBaoHanh(String maHDBaoHanh) {
		this.maHDBaoHanh = maHDBaoHanh;
	}

	public boolean isLyDoBaoHanh() {
		return lyDoBaoHanh;
	}

	public void setLyDoBaoHanh(boolean lyDoBaoHanh) {
		this.lyDoBaoHanh = lyDoBaoHanh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
}
