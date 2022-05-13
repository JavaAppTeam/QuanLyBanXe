package Entity;

import java.util.Objects;

public class TaiKhoan {
	String maNV,passWord;

	@Override
	public String toString() {
		return "TaiKhoan [maNV=" + maNV + ", passWord=" + passWord + "]";
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maNV, other.maNV);
	}

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String maNV, String passWord) {
		super();
		this.maNV = maNV;
		this.passWord = passWord;
	}
}
