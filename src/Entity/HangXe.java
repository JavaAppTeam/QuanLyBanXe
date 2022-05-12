package Entity;

import java.util.Objects;

public class HangXe {

	@Override
	public String toString() {
		return "HangXe [maHang=" + maHang + ", tenHang=" + tenHang + ", trangThai=" + trangThai + "]";
	}

	private String maHang,tenHang;
	private boolean trangThai;
	
	public HangXe() {
		// TODO Auto-generated constructor stub
	}

	public HangXe(String maHang, String tenHang, boolean trangThai) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.trangThai = trangThai;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangXe other = (HangXe) obj;
		return Objects.equals(maHang, other.maHang);
	}
}
