package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ChiTietXeDAO;
import DAO.Xe_DAO;
import Entity.ChiTietXe;
import Entity.PhuTungXe;
import Entity.Xe;
import Support.CheckInput;

import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class FrmChiTietXe extends JFrame implements ActionListener, MouseListener {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTable tblChiTietXe;
	private DefaultTableModel tblModelCTXe;
	private JButton btnThem, btnSua, btnXoaTrang, btnLuu, btnDelete;
	private JTextField txtTenXe, txtTgBaoHanh, txtSoKhung;
	private JCheckBox chbTrangThai;
	private ChiTietXeDAO chiTietXeDao = new ChiTietXeDAO();
	private Xe_DAO xeDao = new Xe_DAO();
	private String tenXe = "";
	private Xe xe = null;
	String[] col = { "Mã chi tiết xe", "Mã xe", "Số khung", "Số máy", "Thời hạn bảo hành", "Trạng thái" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xe xe = new Xe();
					FrmChiTietXe frame = new FrmChiTietXe(xe);

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
	public FrmChiTietXe(Xe xe) {

//===================================================
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 1372, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tenXe = xe.getTenXe();
		this.xe = xe;

		JPanel panel = new JPanel();
		panel.setForeground(new Color(220, 20, 60));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin chi ti\u1EBFt xe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 39, 807, 245);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thời gian bảo hành:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 148, 142, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Trạng thái:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 209, 87, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Số khung và số máy:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 88, 142, 24);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("T\u00EAn xe:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 37, 87, 14);
		panel.add(lblNewLabel_4);

		txtTenXe = new JTextField();
		txtTenXe.setBounds(212, 24, 569, 28);
		txtTenXe.setText(tenXe);
		panel.add(txtTenXe);
		txtTenXe.setEditable(false);

		txtTgBaoHanh = new JTextField();
		txtTgBaoHanh.setBounds(212, 144, 569, 28);
		panel.add(txtTgBaoHanh);
		txtTgBaoHanh.setText("6");

		txtSoKhung = new JTextField();
		txtSoKhung.setBounds(212, 84, 569, 28);
		panel.add(txtSoKhung);
		txtSoKhung.setText("15054");

		chbTrangThai = new JCheckBox("");
		chbTrangThai.setBounds(212, 211, 21, 21);
		panel.add(chbTrangThai);
		chbTrangThai.setSelected(true);

		JPanel pnImage = new JPanel();
		pnImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnImage.setBackground(Color.PINK);
		pnImage.setBounds(842, 39, 504, 245);
		contentPane.add(pnImage);
		pnImage.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(FrmChiTietXe.class.getResource("/image/1 (1).png")));
		pnImage.add(lblNewLabel_2, BorderLayout.CENTER);

		// =================================================
		// ====================== button

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnThem.png")));
		btnThem.setBounds(84, 295, 127, 31);
		contentPane.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnSua = new JButton("Cập nhật");
		btnSua.setEnabled(false);
		btnSua.setBounds(295, 295, 127, 31);
		contentPane.add(btnSua);
		btnSua.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnCapNhat.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnXoaTrang.png")));
		btnXoaTrang.setBounds(506, 295, 127, 31);
		contentPane.add(btnXoaTrang);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(FrmPhuTung.class.getResource("/image/btnSave.png")));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuu.setBounds(717, 295, 127, 31);
		contentPane.add(btnLuu);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(FrmXe.class.getResource("/image/btnXoa.png")));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(928, 295, 127, 31);
		contentPane.add(btnDelete);
		// ==================== TABLE ==================
		JPanel pnTable = new JPanel();
		pnTable.setBounds(10, 337, 1336, 311);
		tblModelCTXe = new DefaultTableModel(col, 0);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblChiTietXe = new JTable(tblModelCTXe);
		tblChiTietXe.setFillsViewportHeight(true);
		tblChiTietXe.setColumnSelectionAllowed(false);
		tblChiTietXe.setCellSelectionEnabled(true);
		tblChiTietXe.setRowHeight(25);
		tblChiTietXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblChiTietXe.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tblChiTietXe);
		pnTable.add(scrollPane);

		try {
			loadDataToTable(xe.getMaXe());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ==================== ACTION =================
		btnDelete.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tblChiTietXe.addMouseListener(this);
	}

	void loadDataToTable(int maXe) throws Exception {
		tblChiTietXe.setModel(tblModelCTXe = new DefaultTableModel(col, 0));
		for (ChiTietXe ctXe : chiTietXeDao.getallSP(maXe)) {
			String trangThai = "Còn bán";

			if (!ctXe.isTrangThai())
				trangThai = "Không còn bán";
			Object[] obj = { ctXe.getMaCTXe(), ctXe.getMaXe(), ctXe.getSoKhung(), ctXe.getSoMay(), ctXe.getThoiGianBH(),
					trangThai };
			tblModelCTXe.addRow(obj);
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

	public void xoatrang() {
		txtTgBaoHanh.setText("");
		txtSoKhung.setText("");
		txtTenXe.setText("");
		chbTrangThai.setSelected(false);
		txtTenXe.requestFocus();
	}

	public void loadDataToText(ChiTietXe chiTiet) {
		txtTenXe.setText(tenXe);
		txtSoKhung.setText(chiTiet.getSoKhung());
		txtTgBaoHanh.setText(chiTiet.getThoiGianBH() + "");
		if (chiTiet.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);
	}

	public boolean checkEmpty() {
		if (txtTenXe.getText().equals("")) {
			showMessage("Tên không được để trống!!!", txtTenXe);
			return false;
		} else {
			if (txtSoKhung.getText().equals("")) {
				showMessage("Mức tiêu thụ không được để trống!!!", txtSoKhung);
				return false;
			} else {
				if (txtTgBaoHanh.getText().equals("")) {
					showMessage("Hãng xe không được để trống!!!", null);
					txtTgBaoHanh.requestFocus();
					return false;
				}
			}
		}
		return true;
	}

	public boolean validateLSP() {
		// check regex HON01-0015
		String soKhung = txtSoKhung.getText().trim();
//		^[A-Z]{3}-\\d{5}$
		if (!txtSoKhung.getText().matches("\\d{5}")) {
			showMessage("Error: Vui lòng nhập theo cú pháp VD: 15051", null);
			return false;
		}

		String tgBaoHanh = txtTgBaoHanh.getText().trim();
		if (!CheckInput.checkInteger(tgBaoHanh)) {
			showMessage("Error: Vui lòng nhập số VD: 10", null);
			return false;
		}
		return true;
	}

	public ChiTietXe taoChiTietXe() {
		Xe_DAO xeDao = new Xe_DAO();
		String soKhung = txtSoKhung.getText().trim();
		Xe xe = null;
		try {
			xe = xeDao.getSPTheoTen(tenXe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int tgBaoHanh = Integer.parseInt(txtTgBaoHanh.getText().trim());
		boolean trangThai;
		if(chbTrangThai.isSelected())
			trangThai = true;
		else
			trangThai = false;
		return new ChiTietXe(soKhung, xe.getMaXe(), tgBaoHanh,trangThai);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDelete)) {
			ChiTietXe ctXe = null;
			try {
				ctXe = chiTietXeDao.getChiTietXe(txtSoKhung.getText());
				if (ctXe != null) {
					int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA Xe này?",
							"Thông báo xác nhận XÓA Xe", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						try {
							if (ctXe == null)
								showMessage("Xóa thất bại", null);
							chiTietXeDao.deleteCTXe(ctXe.getMaCTXe());
							loadDataToTable(xe.getMaXe());
							xoatrang();
							showMessage("Xóa thành công!!!", null);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj.equals(btnLuu)) {
			if (checkEmpty()) {
				if (validateLSP()) {
					ChiTietXe item = taoChiTietXe();
					if (item == null)
						showMessage("Lưu thất bại!!!", null);
					else {
//						String[] col = { "Mã chi tiết xe", "Mã xe", "Số khung", "Số máy", "Thời hạn bảo hành", "Trạng thái" };
						try {
							chiTietXeDao.themSPS(item);
							showMessage("Thêm thành công!!!", null);
							loadDataToTable(xe.getMaXe());
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
			int select = tblChiTietXe.getSelectedRow();
			if (select >= 0) {
				if (checkEmpty()) {
					String tgBaoHanh = txtTgBaoHanh.getText().trim();
					if (!CheckInput.checkInteger(tgBaoHanh)) {
						showMessage("Error: Vui lòng nhập số VD: 10", null);
						return;
					}
					ChiTietXe chiTietXe = taoChiTietXe();
					ChiTietXe item = null;
					try {
						item = chiTietXeDao.getChiTietXe(txtSoKhung.getText());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						chiTietXeDao.capnhat(chiTietXe, item.getMaCTXe());
						loadDataToTable(xe.getMaXe());
						xoatrang();
						JOptionPane.showMessageDialog(null, "Sửa thành công!!!!");
						txtSoKhung.setEditable(true);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
						txtSoKhung.setEditable(true);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa!!!");
			}

		} else if (obj.equals(btnThem)) {
//			xoatrang();
			btnLuu.setEnabled(true);
			btnDelete.setEnabled(false);
			btnSua.setEnabled(false);
		} else if (obj.equals(btnXoaTrang)) {
			xoatrang();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblChiTietXe.getSelectedRow();
		Xe xe = null;
		try {
			xe = xeDao.getSPTheoTen(tenXe);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (select >= 0) {
			try {
				loadDataToText(chiTietXeDao.getallSP(xe.getMaXe()).get(select));
				txtSoKhung.setEditable(false);
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
