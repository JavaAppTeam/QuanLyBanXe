package Entity;

public class ChiTietHoaDonBaoHanh {
	private String maHoaDon,maBaoHanh;
	private int soLuong;
	private double donGia;

	public ChiTietHoaDonBaoHanh() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonBaoHanh(String maHoaDon, String maBaoHanh, int soLuong, double donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maBaoHanh = maBaoHanh;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaBaoHanh() {
		return maBaoHanh;
	}

	public void setMaBaoHanh(String maBaoHanh) {
		this.maBaoHanh = maBaoHanh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	
}
