package Entity;

import java.util.Objects;

public class CuaHang {
	private String maCuaHang,tinhTP,quanHuyen,phuongXa,hotLine;

	public CuaHang() {
		// TODO Auto-generated constructor stub
	}

	public CuaHang(String maCuaHang, String tinhTP, String quanHuyen, String phuongXa, String hotLine) {
		super();
		this.maCuaHang = maCuaHang;
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.hotLine = hotLine;
	}

	public CuaHang(String tinhTP, String quanHuyen, String phuongXa, String hotLine) {
		super();
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.hotLine = hotLine;
	}

	public CuaHang(String maCH) {
		this.maCuaHang = maCH;
	}

	public String getMaCuaHang() {
		return maCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) {
		this.maCuaHang = maCuaHang;
	}

	public String getTinhTP() {
		return tinhTP;
	}

	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}

	public String getHotLine() {
		return hotLine;
	}

	public void setHotLine(String hotLine) {
		this.hotLine = hotLine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCuaHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuaHang other = (CuaHang) obj;
		return Objects.equals(maCuaHang, other.maCuaHang);
	}
	
	

}
