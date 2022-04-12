package Entity;

public class PhuTungXe {

	private int maPhuTung, soLuongTon;
	private String tenPhuTung;
	private double donGia;
	private boolean trangThai;

	public PhuTungXe() {
		// TODO Auto-generated constructor stub
	}

	public PhuTungXe(int maPhuTung, int soLuongTon, String tenPhuTung, double donGia, boolean trangThai) {
		super();
		this.maPhuTung = maPhuTung;
		this.soLuongTon = soLuongTon;
		this.tenPhuTung = tenPhuTung;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}

	public PhuTungXe(int soLuongTon, String tenPhuTung, double donGia, boolean trangThai) {
		super();
		this.soLuongTon = soLuongTon;
		this.tenPhuTung = tenPhuTung;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}

	public int getMaPhuTung() {
		return maPhuTung;
	}

	public void setMaPhuTung(int maPhuTung) {
		this.maPhuTung = maPhuTung;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getTenPhuTung() {
		return tenPhuTung;
	}

	public void setTenPhuTung(String tenPhuTung) {
		this.tenPhuTung = tenPhuTung;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
}
