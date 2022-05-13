package GUI;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Xe_DAO;
import Entity.HangXe;
import Entity.LoaiXe;
import Entity.Xe;
import Support.CheckInput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class FrmXe extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 *  Tên: Võ Thị Trà Giang Ngày tạo: 16/04/2022
	 */
	private JPanel contentPane;
	private JTable tblThongTinXe;
	private DefaultTableModel tblModelXe;
	private JButton btnThem, btnSua, btnXoaTrang, btnLuu, btnDelete,btnTimKiem;
	private JTextField txtTenXe, txtMucTieuThu, txtGiaTien, txtDungTich, txtSoLuong ;
	private JComboBox cboHangXe, cboLoaiXe;
	private JCheckBox chbTrangThai;
	private DefaultComboBoxModel cboModelHangXe, cboModelLoaiXe;
	private Xe_DAO Xe_DAO = new Xe_DAO();
	String[] col = { "Mã xe", "Tên xe", "Mã hãng xe", "Mã loại xe", "Mức tiêu thụ nhiên liệu", "Dung tích", "Giá tiền",
			"Số lượng tồn", "Trạng thái" };
	private JButton btnCT;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXe frame = new FrmXe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmXe() {
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(-5, -26, 1600, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(220, 20, 60));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBorder(
				new TitledBorder(null, "Th\u00F4ng tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 994, 382);
		contentPane.add(panel);
		panel.setLayout(null);

//		-======== INPUT ======================
		JLabel lblNewLabel = new JLabel("M\u1EE9c ti\u00EAu th\u1EE5 nhi\u00EAn li\u1EC7u:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 153, 217, 26);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Dung t\u00EDch: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 200, 179, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i xe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(23, 109, 179, 23);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("H\u00E3ng xe:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(23, 65, 179, 23);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("T\u00EAn xe:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(23, 21, 179, 23);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_1_1 = new JLabel("Gi\u00E1 ti\u1EC1n:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(23, 288, 179, 23);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(23, 244, 179, 23);
		panel.add(lblNewLabel_1_1_1);

		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenXe.setText("SH125i Cao cấp ABS");
		txtTenXe.setBounds(332, 11, 637, 37);
		panel.add(txtTenXe);

		txtMucTieuThu = new JTextField();
		txtMucTieuThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMucTieuThu.setText("2.46");
		txtMucTieuThu.setBounds(332, 152, 637, 36);
		panel.add(txtMucTieuThu);

		txtDungTich = new JTextField();
		txtDungTich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDungTich.setText("7.8");
		txtDungTich.setBounds(332, 199, 637, 36);
		panel.add(txtDungTich);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setText("10");
		txtSoLuong.setBounds(332, 246, 637, 36);
		panel.add(txtSoLuong);

		txtGiaTien = new JTextField();
		txtGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaTien.setText("79812000");
		txtGiaTien.setBounds(332, 293, 637, 36);
		panel.add(txtGiaTien);

		cboHangXe = new JComboBox();
		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setBounds(332, 58, 637, 36);
		panel.add(cboHangXe);

		cboLoaiXe = new JComboBox();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBounds(332, 105, 637, 36);
		panel.add(cboLoaiXe);

		JLabel lblNewLabel_1_1_2 = new JLabel("Trạng Thái:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(23, 332, 179, 23);
		panel.add(lblNewLabel_1_1_2);

		chbTrangThai = new JCheckBox("");
		chbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chbTrangThai.setSelected(true);
		chbTrangThai.setBounds(332, 340, 21, 24);
		panel.add(chbTrangThai);

		JPanel pnImage = new JPanel();
		pnImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnImage.setBackground(Color.WHITE);
		pnImage.setBounds(1014, 11, 504, 382);
		contentPane.add(pnImage);
		pnImage.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(FrmXe.class.getResource("/image/picXe1.png")));
		pnImage.add(lblNewLabel_5, BorderLayout.CENTER);

		// =================================================
		// ====================== button
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 403, 1508, 55);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(80, 10, 107, 36);
		panel_1.add(btnThem);
		btnThem.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnThem.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSua = new JButton("Cập nhật");
		btnSua.setBounds(267, 10, 134, 36);
		panel_1.add(btnSua);
		btnSua.setEnabled(false);
		btnSua.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnCapNhat.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(481, 10, 134, 36);
		panel_1.add(btnXoaTrang);
		btnXoaTrang.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnXoaTrang.png")));
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(695, 10, 107, 36);
		panel_1.add(btnLuu);
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnSave.png")));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1069, 10, 134, 36);
		panel_1.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnTim.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(882, 10, 107, 36);
		panel_1.add(btnDelete);
		btnDelete.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnXoa.png")));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setEnabled(false);

		btnCT = new JButton("Chi Tiết");
		btnCT.setBounds(1283, 10, 140, 36);
		panel_1.add(btnCT);
		btnCT.setIcon(new ImageIcon(FrmXe.class.getResource("/image/MenuItemTrangChu.png")));
		btnCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCT.setEnabled(false);

		// ==================== TABLE ==================
		JPanel pnTable = new JPanel();
		tblModelXe = new DefaultTableModel(col, 0);
		pnTable.setBounds(10, 468, 1508, 273);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblThongTinXe = new JTable(tblModelXe);
		tblThongTinXe.setFillsViewportHeight(true);
		tblThongTinXe.setColumnSelectionAllowed(false);
		tblThongTinXe.setCellSelectionEnabled(true);
		tblThongTinXe.setRowHeight(25);
		tblThongTinXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblThongTinXe.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tblThongTinXe);
		pnTable.add(scrollPane);

		

//		======= ACTION ===============

		btnThem.addActionListener(this);
		btnDelete.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnCT.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tblThongTinXe.addMouseListener(this);

	}

	private void showMessage(String message, JTextField txt) {
		// TODO Auto-generated method stub
		if (txt != null) {
			txt.requestFocus();
			JOptionPane.showMessageDialog(null, message);
		} else {
			JOptionPane.showMessageDialog(null, message);
		}

	}

	public Xe taoXe() {
		String tenXe = txtTenXe.getText();
		String maHangXe = getMaHang((String)cboHangXe.getSelectedItem());  
		String idLoaiXe = getMaLoai((String)cboLoaiXe.getSelectedItem());
		double mucTieuThu = Double.parseDouble(txtMucTieuThu.getText());
		double dungTich = Double.parseDouble(txtDungTich.getText());
		int giaTien = Integer.parseInt(txtGiaTien.getText());
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		boolean trangThai;
		if (chbTrangThai.isSelected() == true)
			trangThai = true;
		else
			trangThai = false;
		return (new Xe(soLuong, tenXe, maHangXe, idLoaiXe, mucTieuThu, dungTich, giaTien, trangThai));
	}

	public String getTenHang(String maHang) {
		try {
			for (HangXe i : Xe_DAO.getAllHangXe()) {
				if (i.getMaHang().equalsIgnoreCase(maHang))
					return i.getTenHang();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String getMaHang(String tenHang)
	{
		try {
			for (HangXe i : Xe_DAO.getAllHangXe()) {
				if (i.getTenHang().equalsIgnoreCase(tenHang))
					return i.getMaHang();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String getMaLoai(String tenloai) {
		try {
			for (LoaiXe i : Xe_DAO.getAllLoaiXe()) {
				if (i.getTenLoai().equalsIgnoreCase(tenloai))
					return i.getMaLoai()+"";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	

	public void loadDataToText(Xe xe) {
		txtTenXe.setText(xe.getTenXe());
		txtDungTich.setText(xe.getDungTich()+"");
		txtGiaTien.setText((int)xe.getGiaTien() + "");
		txtMucTieuThu.setText(xe.getMucTieuThu()+"");
		txtSoLuong.setText(xe.getSoLuongTon() + "");
		// --- set cbo hãng xe
		for (int i = 0; i < cboHangXe.getItemCount(); i++) {
			String index = getTenHang(xe.getMaHangXe());

			if (index != null) {
				String tenXe = (String) cboHangXe.getSelectedItem();
				if (index.equalsIgnoreCase(tenXe)) {
					cboHangXe.setSelectedIndex(i);
				}
			}

		}

		for (int i = 0; i < cboLoaiXe.getItemCount(); i++) {
			if (xe.equals((String) cboLoaiXe.getItemAt(i))) {
				cboLoaiXe.setSelectedIndex(i);
			}
		}

		if (xe.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);

	}

	public void loadDatatoTable() throws Exception {
		tblThongTinXe.setModel(tblModelXe = new DefaultTableModel(col, 0));
//		String[] col = {"Mã xe", "Tên xe", "Mã hãng xe", "Mã loại xe","Mức tiêu thụ nhiên liệu", "Dung tích", "Giá tiền", "Số lượng tồn","Trạng thái"};
		for (Xe xe : Xe_DAO.getallSP()) {
			String trangThai = "Còn bán";

			if (!xe.isTrangThai())
				trangThai = "Không còn bán";

			Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
					xe.getDungTich(), (int)xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
			tblModelXe.addRow(obj);
		}
	}

	public void loadCboHangXe() {
		try {
//			=============== LOAD CBO HANG XE ===================
			cboModelHangXe = new DefaultComboBoxModel();
			for (HangXe i : Xe_DAO.getAllHangXe())
				cboModelHangXe.addElement(i.getTenHang());
			cboHangXe.setModel(cboModelHangXe);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void loadCboLoaiXe() {
		try {
//			================ LOAD CBO LOAI XE =================
			cboModelLoaiXe = new DefaultComboBoxModel();
			for (LoaiXe i : Xe_DAO.getAllLoaiXe())
				cboModelLoaiXe.addElement(i.getTenLoai());
			cboLoaiXe.setModel(cboModelLoaiXe);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {                                
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDelete)) {
			String tenXe = txtTenXe.getText();
			Xe item = null;
			try {
				item = Xe_DAO.getSPTheoTen(tenXe);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA Xe này?", "Thông báo xác nhận XÓA Xe",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				try {	
					if (item == null)
						showMessage("Xóa thất bại", null);
					Xe_DAO.deleteXe(item.getMaXe());
					loadDatatoTable();
					xoatrang();
					showMessage("Xóa thành công!!!", null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (obj.equals(btnLuu)) {
			if (checkEmpty()) {
				if (validateLSP()) {
					Xe item = taoXe();
					if (item == null)
						showMessage("Lưu thất bại!!!", null);
					else {
						try {
							Xe_DAO.themSPS(item);
							showMessage("Thêm thành công!!!", null);
							loadDatatoTable();
						} catch (Exception e2) {
							// TODO: handle exception
							showMessage("Lưu thất bại!!!", null);
						}
						xoatrang();
					}
				}

			}

		} else if (obj.equals(btnSua)) {
			btnLuu.setEnabled(true);
			btnThem.setEnabled(false);
			btnDelete.setEnabled(false);
			int select = tblThongTinXe.getSelectedRow();
			if (select >= 0) {
				if(checkEmpty())
				{
					if(validateLSP())
					{
						Xe xe = taoXe();
						Xe item  = null;
						try {
							item = Xe_DAO.getSPTheoTen(txtTenXe.getText());
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							Xe_DAO.capnhat(xe,item.getMaXe());
							loadDatatoTable();
							xoatrang();
							JOptionPane.showMessageDialog(null, "Sửa thành công!!!!");
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"Vui lòng chọn dòng cần sửa!!!");
			}

		} else if (obj.equals(btnThem)) {
//			xoatrang();
			btnLuu.setEnabled(true);
			btnDelete.setEnabled(false);
			btnSua.setEnabled(false);
		} else if (obj.equals(btnXoaTrang)) {
			xoatrang();
		}else if(obj.equals(btnCT))
		{
			int select = tblThongTinXe.getSelectedRow();
			if(select >= 0)
			{
				Xe xe = taoXe();
				Xe item  = null;
				try {
					item = Xe_DAO.getSPTheoTen(xe.getTenXe());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				FrmChiTietXe frm = new FrmChiTietXe(item);
				frm.pack();
				frm.setBounds(20, 20, 1372, 710);
				frm.setBackground(new Color(135, 206, 250));
				frm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				frm.setFocusCycleRoot(true);
				frm.setFocusableWindowState(true);
				frm.setVisible(true);
			}
		}else if(obj.equals(btnTimKiem)) {
			FrmTimKiemXe frmTimKiem = new FrmTimKiemXe();
			frmTimKiem.pack();
			frmTimKiem.setBounds(0, 20, 1600, 800);
			frmTimKiem.setBackground(new Color(135, 206, 250));
			frmTimKiem.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			frmTimKiem.setFocusCycleRoot(true);
			frmTimKiem.setFocusableWindowState(true);
			frmTimKiem.setVisible(true);
			frmTimKiem.loadCboGiaTien();
			frmTimKiem.loadCboHangXe();
			frmTimKiem.loadCboLoaiXe();
			try {
				frmTimKiem.loadDatatoTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void xoatrang() {
		txtDungTich.setText("");
		txtGiaTien.setText("");
		txtMucTieuThu.setText("");
		txtSoLuong.setText("");
		txtTenXe.setText("");
		cboHangXe.setSelectedItem("");
		cboLoaiXe.setSelectedItem("");
		chbTrangThai.setSelected(false);
		txtTenXe.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblThongTinXe.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(Xe_DAO.getallSP().get(select));
				btnThem.setEnabled(true);
				btnLuu.setEnabled(false);
				btnSua.setEnabled(true);
				btnDelete.setEnabled(true);
				btnCT.setEnabled(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public boolean validateLSP() {
		// check ten xe
		String tenXe = txtTenXe.getText().trim();
		if (tenXe.matches("/[a-zA-Z]{2,} ?[\\s-]*([A-Za-z]{1,})?[\\s-]*(\\d+)([a-z]+)?[\\s-]*([A-Z]*\\b)/g")) {
			showMessage("Error: Tên xe không được chứa kỳ tự đặt biệt VD:Yamaha Sirius 2021", txtTenXe);
			return false;
		}
		// check regex
		String dungTich = txtDungTich.getText().trim();
		if (!CheckInput.checkDouble(dungTich)) {
			showMessage("Error: Vui lòng nhập số thực VD: 1.99", null);
			return false;
		}

		String mucTieuThu = txtMucTieuThu.getText().trim();
		if (!CheckInput.checkDouble(mucTieuThu)) {
			showMessage("Error: Vui lòng nhập số thực VD: 1.99 ", txtMucTieuThu);
			return false;
		}

		String soLuong = txtSoLuong.getText().trim();
		if (!CheckInput.checkInteger(soLuong)) {
			showMessage("Error: Vui lòng nhập số VD: 10", null);
			return false;
		}

		String giaTien = txtGiaTien.getText().trim();
		if (!CheckInput.checkInteger(giaTien)) {
			showMessage("Error: Vui lòng nhập số VD: 10", null);
			return false;
		}

		return true;
	}

	public boolean checkEmpty() {
//		private JTextField txtTenXe, txtMucTieuThu, txtGiaTien, txtDungTich, txtSoLuong;
		if (txtTenXe.getText().equals("")) {
			showMessage("Tên không được để trống!!!", txtTenXe);
			return false;
		} else {
			if (txtMucTieuThu.getText().equals("")) {
				showMessage("Mức tiêu thụ không được để trống!!!", txtMucTieuThu);
				return false;
			} else {
				if (((String) cboHangXe.getSelectedItem()).equals("")) {
					showMessage("Hãng xe không được để trống!!!", null);
					cboHangXe.requestFocus();
					return false;
				} else {
					if (((String) cboLoaiXe.getSelectedItem()).equals("")) {
						showMessage("Loại xe không được để trống!!!", null);
						cboLoaiXe.requestFocus();
						return false;
					} else {
						if (txtDungTich.getText().equals("")) {
							showMessage("Dung tích không được để trống!!!", txtDungTich);
							return false;
						} else {
							if (txtSoLuong.getText().equals("")) {
								showMessage("Số lượng không được để trống!!!", txtSoLuong);
								return false;
							} else {
								if (txtGiaTien.getText().equals("")) {
									showMessage("Giá tiền không được để trống!!!", txtGiaTien);
									return false;
								}
							}
						}
					}
				}

			}
		}
		return true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
