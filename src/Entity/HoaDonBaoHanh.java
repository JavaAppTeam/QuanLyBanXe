package Entity;

public class HoaDonBaoHanh {
	private String maHDBaoHanh,lyDoBaoHanh,ghiChu;
	private boolean trangThai;

	public HoaDonBaoHanh() {
		// TODO Auto-generated constructor stub
	}
	

	public HoaDonBaoHanh(String maHDBaoHanh, String lyDoBaoHanh, String ghiChu, boolean trangThai) {
		super();
		this.maHDBaoHanh = maHDBaoHanh;
		this.lyDoBaoHanh = lyDoBaoHanh;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}

	

	public HoaDonBaoHanh(String lyDoBaoHanh, String ghiChu, boolean trangThai) {
		super();
		this.lyDoBaoHanh = lyDoBaoHanh;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}


	public String getMaHDBaoHanh() {
		return maHDBaoHanh;
	}

	public void setMaHDBaoHanh(String maHDBaoHanh) {
		this.maHDBaoHanh = maHDBaoHanh;
	}

	public String getLyDoBaoHanh() {
		return lyDoBaoHanh;
	}

	public void setLyDoBaoHanh(String lyDoBaoHanh) {
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
