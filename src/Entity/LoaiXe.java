package Entity;

public class LoaiXe {

	private int maLoai;
	private String tenLoai;
	private boolean trangThai;
	public LoaiXe() {
		// TODO Auto-generated constructor stub
	}

	public LoaiXe(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	
	

	public LoaiXe(int maLoai, String tenLoai, boolean trangThai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.trangThai = trangThai;
	}

	public LoaiXe(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}
	

	public LoaiXe(String tenLoai, boolean trangThai) {
		super();
		this.tenLoai = tenLoai;
		this.trangThai = trangThai;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
