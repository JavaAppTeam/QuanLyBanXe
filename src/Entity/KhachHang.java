package Entity;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	String MaKH;
	String TenKH;
	Date NgaySinh;
	String sdt;
	String CMND;
	String GioiTinh;
	Boolean TrangThai;

	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", TenKH=" + TenKH + ", NgaySinh=" + NgaySinh + ", sdt=" + sdt + ", CMND="
				+ CMND + ", GioiTinh=" + GioiTinh + ", TrangThai=" + TrangThai + "]";
	}

	public KhachHang(String maKH, String tenKH, Date ngaySinh, String sdt, String cMND, String gioiTinh,
			Boolean trangThai) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		NgaySinh = ngaySinh;
		this.sdt = sdt;
		CMND = cMND;
		GioiTinh = gioiTinh;
		TrangThai = trangThai;
	}

	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	public KhachHang(String maKH, String tenKH, Date ngaySinh, String sdt, String cMND, String gioiTinh) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		NgaySinh = ngaySinh;
		this.sdt = sdt;
		CMND = cMND;
		GioiTinh = gioiTinh;
	}

	public KhachHang(String tenKH, Date ngaySinh, String sdt, String cMND, String gioiTinh) {
		super();
		TenKH = tenKH;
		NgaySinh = ngaySinh;
		this.sdt = sdt;
		CMND = cMND;
		GioiTinh = gioiTinh;
		this.TrangThai = true;
	}

	public KhachHang(String ma, String sdt) {
		this.MaKH = ma;
	}

	public KhachHang(String sdt) {
		this.sdt = sdt;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}


	@Override
	public int hashCode() {
		return Objects.hash(MaKH, CMND, sdt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(MaKH, other.MaKH) & Objects.equals(CMND, other.CMND) & Objects.equals(sdt, other.sdt);
	}

}
