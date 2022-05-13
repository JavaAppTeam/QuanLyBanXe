package Entity;

public class ChiTietHoaDonBaoHanh {
	private String maHoaDon,maBaoHanh;
	private int soLuong;
	private int idPhuTung;

	public ChiTietHoaDonBaoHanh() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonBaoHanh(String maHoaDon, String maBaoHanh,int idPhuTung, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maBaoHanh = maBaoHanh;
		this.soLuong = soLuong; 
		this.idPhuTung = idPhuTung;
	}

	public int getIdPhuTung() {
		return idPhuTung;
	}

	public void setIdPhuTung(int idPhuTung) {
		this.idPhuTung = idPhuTung;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaBaoHanh() {
		return maBaoHanh;
	}

	public void setMaBaoHanh(String maBaoHanh) {
		this.maBaoHanh = maBaoHanh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


}
