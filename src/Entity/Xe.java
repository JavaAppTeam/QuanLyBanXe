package Entity;

public class Xe {

	private int maXe,soLuongTon;
	private double mucTieuThu,dungTich;
	private double giaTien;
	private String soKhung, soMay;
	private String maCTXe;
	private int soluongMua;
	private int stt;
	private float donGia;
	private String tenKH;
	private String tenXe,maHangXe,maLoai,mucTieuThuu,dungTichh;
	private boolean trangThai;
	

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
		this.mucTieuThuu = mucTieuThu;
		this.dungTichh = dungTich;
		this.giaTien = giaTien;
	}
	public Xe(int maXe, int soLuongTon, String tenXe, String maHangXe, String maLoai, double mucTieuThu,
			double dungTich, long giaTien, boolean trangThai) {
		super();
		this.maXe = maXe;
		this.soLuongTon = soLuongTon;
		this.tenXe = tenXe;
		this.maHangXe = maHangXe;
		this.maLoai = maLoai;
		this.mucTieuThu = mucTieuThu;
		this.dungTich = dungTich;
		this.giaTien = giaTien;
		this.trangThai = trangThai;
	}
	public Xe(int soLuongTon, String tenXe, String maHangXe, String maLoai, double mucTieuThu, double dungTich,
			long giaTien,boolean trangThai) {
		super();
		this.soLuongTon = soLuongTon;
		this.tenXe = tenXe;
		this.maHangXe = maHangXe;
		this.maLoai = maLoai;
		this.mucTieuThu = mucTieuThu;
		this.dungTich = dungTich;
		this.giaTien = giaTien;
		this.trangThai = trangThai;
	}
	public Xe(int soLuongTon, String tenXe, String maHangXe, String maLoai, String mucTieuThu, String dungTich,
			double giaTien) {
		super();
		this.soLuongTon = soLuongTon;
		this.tenXe = tenXe;
		this.maHangXe = maHangXe;
		this.maLoai = maLoai;
		this.mucTieuThuu = mucTieuThu;
		this.dungTichh = dungTich;
		this.giaTien = giaTien;
	}
	public Xe(String maCTXe,String tenxe,Integer soluongMua, String sokhung, String somay, String dungtich, Double giatien) {
		// TODO Auto-generated constructor stub
		this.maCTXe = maCTXe;
		this.tenXe = tenxe;
		this.soluongMua = soluongMua;
		this.soKhung = sokhung;
		this.soMay = somay;
		this.dungTichh = dungtich;
		this.giaTien = giatien;
	}
	public Xe(int stt, String tenXe, int soLuong, float donGia, String tenKH) {
		// TODO Auto-generated constructor stub
		this.stt = stt;
		this.tenXe = tenXe;
		this.soluongMua = soLuong;
		this.donGia = donGia;
		this.tenKH = tenKH;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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
	public double getMucTieuThu() {
		return mucTieuThu;
	}
	public void setMucTieuThu(double mucTieuThu) {
		this.mucTieuThu = mucTieuThu;
	}
	public double getDungTich() {
		return dungTich;
	}
	public void setDungTich(double dungTich) {
		this.dungTich = dungTich;
	}
	public String getMucTieuThuu() {
		return mucTieuThuu;
	}
	public void setMucTieuThuu(String mucTieuThuu) {
		this.mucTieuThuu = mucTieuThuu;
	}
	public String getDungTichh() {
		return dungTichh;
	}
	public void setDungTichh(String dungTichh) {
		this.dungTichh = dungTichh;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
}
