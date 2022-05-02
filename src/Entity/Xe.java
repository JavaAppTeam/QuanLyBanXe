package Entity;

public class Xe {

	private int maXe,soLuongTon;
	private String tenXe,maHangXe,maLoai,mucTieuThu,dungTich;
	private double giaTien;
	private String soKhung, soMay;
	private String maCTXe;
	private int soluongMua;
	

	public int getSoluongMua() {
		return soluongMua;
	}
	public void setSoluongMua(int soluongMua) {
		this.soluongMua = soluongMua;
	}
	public Xe() {
		// TODO Auto-generated constructor stub
	}
	public Xe(int maXe, int soLuongTon, String tenXe, String maHangXe, String maLoai, String mucTieuThu,
			String dungTich, double giaTien) {
		super();
		this.maXe = maXe;
		this.soLuongTon = soLuongTon;
		this.tenXe = tenXe;
		this.maHangXe = maHangXe;
		this.maLoai = maLoai;
		this.mucTieuThu = mucTieuThu;
		this.dungTich = dungTich;
		this.giaTien = giaTien;
	}
	public Xe(int soLuongTon, String tenXe, String maHangXe, String maLoai, String mucTieuThu, String dungTich,
			double giaTien) {
		super();
		this.soLuongTon = soLuongTon;
		this.tenXe = tenXe;
		this.maHangXe = maHangXe;
		this.maLoai = maLoai;
		this.mucTieuThu = mucTieuThu;
		this.dungTich = dungTich;
		this.giaTien = giaTien;
	}
	public Xe(String maCTXe,String tenxe,Integer soluongMua, String sokhung, String somay, String dungtich, Double giatien) {
		// TODO Auto-generated constructor stub
		this.maCTXe = maCTXe;
		this.tenXe = tenxe;
		this.soluongMua = soluongMua;
		this.soKhung = sokhung;
		this.soMay = somay;
		this.dungTich = dungtich;
		this.giaTien = giatien;
	}
	public String getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}
	public String getSoMay() {
		return soMay;
	}
	public void setSoMay(String soMay) {
		this.soMay = soMay;
	}
	public String getMaCTXe() {
		return maCTXe;
	}
	public void setMaCTXe(String maCTXe) {
		this.maCTXe = maCTXe;
	}
	public int getMaXe() {
		return maXe;
	}
	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getMaHangXe() {
		return maHangXe;
	}
	public void setMaHangXe(String maHangXe) {
		this.maHangXe = maHangXe;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getMucTieuThu() {
		return mucTieuThu;
	}
	public void setMucTieuThu(String mucTieuThu) {
		this.mucTieuThu = mucTieuThu;
	}
	public String getDungTich() {
		return dungTich;
	}
	public void setDungTich(String dungTich) {
		this.dungTich = dungTich;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	
	

}
