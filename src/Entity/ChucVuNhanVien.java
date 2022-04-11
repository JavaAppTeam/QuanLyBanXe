package Entity;

public class ChucVuNhanVien {
	private int maChucVu;
	private String maKyTu,tenChucVu;

	public ChucVuNhanVien() {
		// TODO Auto-generated constructor stub
	}

	public ChucVuNhanVien(int maChucVu, String maKyTu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.maKyTu = maKyTu;
		this.tenChucVu = tenChucVu;
	}

	public ChucVuNhanVien(String maKyTu, String tenChucVu) {
		super();
		this.maKyTu = maKyTu;
		this.tenChucVu = tenChucVu;
	}

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getMaKyTu() {
		return maKyTu;
	}

	public void setMaKyTu(String maKyTu) {
		this.maKyTu = maKyTu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	
}
