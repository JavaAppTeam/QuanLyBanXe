package Entity;

import java.time.LocalDate;

public class NhanVien {

	private String maNhanVien,tenNhanVien,cmnd,sdt,maChucVu,bacTho;
	private LocalDate ngaySinh,ngayVaoLam;
	private int trinhDoHocVan,soNamKinhNghiem;
	private boolean trangThai;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String cmnd, String sdt, String maChucVu,
			String bacTho, LocalDate ngaySinh, LocalDate ngayVaoLam, int trinhDoHocVan, int soNamKinhNghiem,
			boolean trangThai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.maChucVu = maChucVu;

		this.bacTho = bacTho;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.trinhDoHocVan = trinhDoHocVan;
		this.soNamKinhNghiem = soNamKinhNghiem;
		this.trangThai = trangThai;
	}

	public NhanVien(String tenNhanVien, String cmnd, String sdt, String maChucVu, String bacTho,
			LocalDate ngaySinh, LocalDate ngayVaoLam, int trinhDoHocVan, int soNamKinhNghiem, boolean trangThai) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.maChucVu = maChucVu;
		this.bacTho = bacTho;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.trinhDoHocVan = trinhDoHocVan;
		this.soNamKinhNghiem = soNamKinhNghiem;
		this.trangThai = trangThai;
	}

	public NhanVien(String maNV) {
		this.maNhanVien = maNV;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getBacTho() {
		return bacTho;
	}

	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public int getTrinhDoHocVan() {
		return trinhDoHocVan;
	}

	public void setTrinhDoHocVan(int trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}

	public int getSoNamKinhNghiem() {
		return soNamKinhNghiem;
	}

	public void setSoNamKinhNghiem(int soNamKinhNghiem) {
		this.soNamKinhNghiem = soNamKinhNghiem;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	

}
