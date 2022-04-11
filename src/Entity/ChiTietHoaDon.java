package Entity;

public class ChiTietHoaDon {

	private String maHD,maXe;
	private double donGia,thue;
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(String maHD, String maXe, double donGia, double thue) {
		super();
		this.maHD = maHD;
		this.maXe = maXe;
		this.donGia = donGia;
		this.thue = thue;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) {
		this.thue = thue;
	}

	
	
}
