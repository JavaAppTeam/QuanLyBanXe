package Entity;

public class HangXe {

	private String maHang,maKyTu,tenHang;
	public HangXe() {
		// TODO Auto-generated constructor stub
	}
	public HangXe(String maHang, String maKyTu, String tenHang) {
		super();
		this.maHang = maHang;
		this.maKyTu = maKyTu;
		this.tenHang = tenHang;
	}
	public HangXe(String maKyTu, String tenHang) {
		super();
		this.maKyTu = maKyTu;
		this.tenHang = tenHang;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getMaKyTu() {
		return maKyTu;
	}
	public void setMaKyTu(String maKyTu) {
		this.maKyTu = maKyTu;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	
	

}
