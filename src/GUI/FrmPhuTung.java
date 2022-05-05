package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.midi.ShortMessage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.PhuTungDao;
import Entity.PhuTungXe;
import Entity.Xe;
import Support.CheckInput;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class FrmPhuTung extends JInternalFrame implements MouseListener, ActionListener {

	/**
	 *  Tên: Võ Thị Trà Giang Ngày tạo: 16/04/2022
	 */
	private JPanel contentPane;
	private JTable tblThongTinPhuTung;
	private JButton btnThem, btnSua, btnXoaTrang, btnLuu, btnDelete;
	private DefaultTableModel tblModelPhuTung;
	private PhuTungDao phuTungDAO = new PhuTungDao();
	private JTextField txtTenPhuTung, txtSoLuong, txtGiaTien;
	private JCheckBox chbTrangThai;
	String[] col = { "Mã phụ tùng", "Tên phụ tùng", "Số lượng tồn", "Trạng thái", "Đơn giá" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPhuTung frame = new FrmPhuTung();
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
	public FrmPhuTung() {
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(-5, -26, 1372, 710);
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
				new TitledBorder(null, "Thông tin phụ tùng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 807, 179);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Trạng thái:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 141, 87, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Tên phụ tùng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 25, 142, 22);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_1_1 = new JLabel("Đơn giá:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(23, 102, 87, 23);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(23, 64, 142, 22);
		panel.add(lblNewLabel_1_1_1);

		txtTenPhuTung = new JTextField();
		txtTenPhuTung.setText("Lốp sau");
		txtTenPhuTung.setBounds(212, 11, 569, 28);
		panel.add(txtTenPhuTung);

		txtSoLuong = new JTextField();
		txtSoLuong.setText("10");
		txtSoLuong.setBounds(212, 58, 569, 28);
		panel.add(txtSoLuong);

		txtGiaTien = new JTextField();
		txtGiaTien.setText("333300");
		txtGiaTien.setBounds(212, 97, 569, 28);
		panel.add(txtGiaTien);

		chbTrangThai = new JCheckBox("");
		chbTrangThai.setSelected(true);
		chbTrangThai.setBounds(212, 141, 21, 23);
		panel.add(chbTrangThai);

		JPanel pnImage = new JPanel();
		pnImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnImage.setBackground(Color.PINK);
		pnImage.setBounds(846, 11, 500, 179);
		contentPane.add(pnImage);
		pnImage.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/Untitled-2.png")));
		pnImage.add(lblNewLabel, BorderLayout.CENTER);

//		================== BUTTON =================
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnThem.png")));
		btnThem.setBounds(115, 235, 133, 46);
		contentPane.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnSua = new JButton("Cập nhật");
		btnSua.setEnabled(false);
		btnSua.setBounds(363, 235, 133, 46);
		contentPane.add(btnSua);
		btnSua.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnCapNhat.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnXoaTrang.png")));
		btnXoaTrang.setBounds(611, 235, 133, 46);
		contentPane.add(btnXoaTrang);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnSave.png")));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(859, 235, 133, 46);
		contentPane.add(btnLuu);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnXoa.png")));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(1107, 235, 133, 46);
		contentPane.add(btnDelete);

		// ================= TABLE ===============
		JPanel pnTable = new JPanel();
		pnTable.setBounds(10, 303, 1336, 345);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblModelPhuTung = new DefaultTableModel(col, 0);

		pnTable.setBounds(10, 375, 1336, 273);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblThongTinPhuTung = new JTable(tblModelPhuTung);
		tblThongTinPhuTung.setFillsViewportHeight(true);
		tblThongTinPhuTung.setColumnSelectionAllowed(false);
		tblThongTinPhuTung.setCellSelectionEnabled(true);
		tblThongTinPhuTung.setRowHeight(25);
		tblThongTinPhuTung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblThongTinPhuTung.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tblThongTinPhuTung);
		pnTable.add(scrollPane);

//		try {
//			loadDatatoTable();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ================= ACTION ===================================
		btnThem.addActionListener(this);
		btnDelete.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tblThongTinPhuTung.addMouseListener(this);

	}

	public void loadDatatoTable() throws Exception {
		tblThongTinPhuTung.setModel(tblModelPhuTung = new DefaultTableModel(col, 0));
		for (PhuTungXe item : phuTungDAO.getallSP()) {
			String trangThai = "Còn bán";

			if (!item.isTrangThai())
				trangThai = "Không còn bán";
			Object[] obj = { item.getMaPhuTung(), item.getTenPhuTung(), item.getSoLuongTon(), trangThai,
					item.getDonGia() };
			tblModelPhuTung.addRow(obj);
		}
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

	public PhuTungXe taoPhuTung() {
		String tenPT = txtTenPhuTung.getText();
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		double donGia = Double.parseDouble(txtGiaTien.getText());
		boolean trangThai;
		if (chbTrangThai.isSelected()) {
			trangThai = true;
		} else
			trangThai = false;
		return new PhuTungXe(soLuong, tenPT, donGia, trangThai);
	}

	public void loadDataToText(PhuTungXe phuTung) {
		txtTenPhuTung.setText(phuTung.getTenPhuTung());
		txtSoLuong.setText(phuTung.getSoLuongTon() + "");
		txtGiaTien.setText(phuTung.getDonGia() + "");
		if (phuTung.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);
	}

	public void xoaTrang() {
		txtGiaTien.setText("");
		txtSoLuong.setText("");
		txtTenPhuTung.setText("");
		chbTrangThai.setSelected(false);
	}

	public boolean validateLSP() {
		// check ten xe
		String tenXe = txtTenPhuTung.getText().trim();
		if (!tenXe.matches(
				"[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\w]+")) {
			showMessage("Error: Tên phụ tùng không được chứa kỳ tự đặt biệt VD:Bộ má phanh", txtTenPhuTung);
			return false;
		}
		String soLuong = txtSoLuong.getText().trim();
		if (!CheckInput.checkInteger(soLuong)) {
			showMessage("Error: Vui lòng nhập số VD: 10", null);
			return false;
		}

		String giaTien = txtGiaTien.getText().trim();
		if (!CheckInput.checkDouble(giaTien)) {
			showMessage("Error: Vui lòng nhập số VD: 10.00", null);
			return false;
		}

		return true;
	}

	public boolean checkEmpty() {
		if (txtTenPhuTung.getText().equals("")) {
			showMessage("Tên không được để trống!!!", txtTenPhuTung);
			return false;
		} else {
			if (txtGiaTien.getText().equals("")) {
				showMessage("Giá tiền không được để trống!!!", txtGiaTien);
				return false;
			} else {
				if (txtSoLuong.getText().equals("")) {
					showMessage("Số lượng không được để trống!!", txtSoLuong);
					return false;
				}

			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDelete)) {
			String tenPhuTung = txtTenPhuTung.getText();
			PhuTungXe item = null;
			try {
				item = phuTungDAO.getPhuTungTheoTen(tenPhuTung);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA Phụ tùng này?",
					"Thông báo xác nhận XÓA phù tùng", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				try {
					if (item == null)
						showMessage("Xóa thất bại", null);
					phuTungDAO.deletePhuTung(item.getMaPhuTung());
					loadDatatoTable();
					xoaTrang();
					showMessage("Xóa thành công!!!", null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (obj.equals(btnLuu)) {
			if (checkEmpty()) {
				if (validateLSP()) {
					PhuTungXe item = taoPhuTung();
					if (item == null)
						showMessage("Lưu thất bại!!!", null);
					else {
						try {
							phuTungDAO.themSP(item);
							showMessage("Thêm thành công!!!", null);
							loadDatatoTable();
						} catch (Exception e2) {
							// TODO: handle exception
							showMessage("Lưu thất bại!!!", null);
						}
						xoaTrang();
					}
				}

			}

		} else if (obj.equals(btnSua)) {
			btnLuu.setEnabled(true);
			btnThem.setEnabled(false);
			btnDelete.setEnabled(false);
			int select = tblThongTinPhuTung.getSelectedRow();
			if (select >= 0) {
				if (checkEmpty()) {
					if (validateLSP()) {
						PhuTungXe phuTung = taoPhuTung();
						PhuTungXe item = null;
						try {
							item = phuTungDAO.getPhuTungTheoTen(txtTenPhuTung.getText());
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							phuTungDAO.capnhat(phuTung, item.getMaPhuTung());
							loadDatatoTable();
							xoaTrang();
							JOptionPane.showMessageDialog(null, "Sửa thành công!!!!");
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa!!!");
			}

		} else if (obj.equals(btnThem)) {
			btnLuu.setEnabled(true);
			btnDelete.setEnabled(false);
			btnSua.setEnabled(false);
		} else if (obj.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblThongTinPhuTung.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(phuTungDAO.getallSP().get(select));
				btnThem.setEnabled(true);
				btnLuu.setEnabled(false);
				btnSua.setEnabled(true);
				btnDelete.setEnabled(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

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
