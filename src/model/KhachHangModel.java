package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entity.KhachHang;

public class KhachHangModel extends AbstractTableModel{
	private String[] col =  {"Mã khách hàng","Tên","Số điện thoại","CMND","Giới tính","Ngày sinh"};
	private List<KhachHang> dskh;
	public KhachHangModel(List<KhachHang> dskh) {
		// TODO Auto-generated constructor stub
		this.dskh = dskh;
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dskh.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return col[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		KhachHang kh = dskh.get(rowIndex);
		switch(columnIndex) {
		case 0: return kh.getMaKH();
		case 1: return kh.getTenKH();
		case 2: return kh.getSdt();
		case 3: return kh.getCMND();
		case 4: return kh.getGioiTinh();
		case 5: return kh.getNgaySinh();
		}
		return kh;
	
	}
}
