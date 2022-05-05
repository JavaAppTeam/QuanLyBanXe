package Entity;

public class ChiTietXe {

	/**
	 * Launch the application. TÃªn: VÃµ Thá»‹ TrÃ  Giang NgÃ y táº¡o: 16/04/2022
	 */
	private String maCTXe, soKhung, soMay;
	private int maXe, thoiGianBH;
	private boolean trangThai;

	public ChiTietXe() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietXe(String maCTXe, String soKhung, String soMay, int maXe, int thoiGianBH,
			boolean trangThai) {
		super();
		this.maCTXe = maCTXe;
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.maXe = maXe;
		this.thoiGianBH = thoiGianBH;
		this.trangThai = trangThai;
	}

	public ChiTietXe(String soKhung, String soMay, int maXe, int thoiGianBH, boolean trangThai) {
		super();
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.maXe = maXe;
		this.thoiGianBH = thoiGianBH;
		this.trangThai = trangThai;
	}
	
	

	public ChiTietXe(String soKhung, int maXe, int thoiGianBH) {
		super();
		this.soKhung = soKhung;
		this.maXe = maXe;
		this.thoiGianBH = thoiGianBH;
	}
	
	

	public ChiTietXe(String soKhung, int maXe, int thoiGianBH, boolean trangThai) {
		super();
		this.soKhung = soKhung;
		this.maXe = maXe;
		this.thoiGianBH = thoiGianBH;
		this.trangThai = trangThai;
	}

	public String getMaCTXe() {
		return maCTXe;
	}

	public void setMaCTXe(String maCTXe) {
		this.maCTXe = maCTXe;
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

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public int getThoiGianBH() {
		return thoiGianBH;
	}

	public void setThoiGianBH(int thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

}
