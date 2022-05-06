package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Xe_DAO;
import Entity.HangXe;
import Entity.LoaiXe;
import Entity.Xe;

public class FrmTimKiemXe extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtTenXe;
	private JComboBox cboHangXe, cboLoaiXe, cboGiaTien;
	private JCheckBox chbTrangThai;
	private JButton btnLoad, btnTimKiem;
	private JTable tblTimKiem;
	private DefaultTableModel tblModelTimKiemXe;
	private DefaultComboBoxModel cboModelHangXe, cboModelLoaiXe, cboModelGiaTien;
	private Xe_DAO Xe_DAO = new Xe_DAO();
	String[] col = { "Mã xe", "Tên xe", "Mã hãng xe", "Mã loại xe", "Mức tiêu thụ nhiên liệu", "Dung tích", "Giá tiền",
			"Số lượng tồn", "Trạng thái" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTimKiemXe frame = new FrmTimKiemXe();
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
	public FrmTimKiemXe() {
		setBounds(100, 100, 1600, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 192, 203));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 192, 203));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(5, 5, 1535, 776);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 20, 740, 330);
		panel_1.setBackground(new Color(255, 192, 203));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("T\u00EAn xe:");
		lblNewLabel_4.setBounds(31, 44, 245, 51);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 28));

		JLabel lblNewLabel_3 = new JLabel("H\u00E3ng xe:");
		lblNewLabel_3.setBounds(31, 139, 245, 51);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 28));

		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i xe:");
		lblNewLabel_2.setBounds(31, 234, 245, 51);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 28));

		txtTenXe = new JTextField();
		txtTenXe.setBounds(190, 50, 524, 43);
		panel_1.add(txtTenXe);
		txtTenXe.setFont(new Font("Dialog", Font.PLAIN, 28));
		txtTenXe.setText("");

		cboHangXe = new JComboBox();
		cboHangXe.setBounds(190, 143, 524, 43);
		panel_1.add(cboHangXe);
		cboHangXe.setFont(new Font("Dialog", Font.PLAIN, 28));
		cboHangXe.setBackground(Color.WHITE);

		cboLoaiXe = new JComboBox();
		cboLoaiXe.setBounds(190, 236, 524, 43);
		panel_1.add(cboLoaiXe);
		cboLoaiXe.setFont(new Font("Dialog", Font.PLAIN, 28));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(760, 21, 755, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Gi\u00E1 ti\u1EC1n:");
		lblNewLabel_1_1.setBounds(53, 75, 245, 51);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 28));

		JLabel lblNewLabel_1_1_2 = new JLabel("Trạng Thái:");
		lblNewLabel_1_1_2.setBounds(53, 201, 245, 51);
		panel_2.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 28));

		chbTrangThai = new JCheckBox("");
		chbTrangThai.setBounds(289, 212, 29, 30);
		panel_2.add(chbTrangThai);
		chbTrangThai.setFont(new Font("Dialog", Font.PLAIN, 28));
		chbTrangThai.setSelected(true);

		cboGiaTien = new JComboBox();
		cboGiaTien.setFont(new Font("Dialog", Font.PLAIN, 28));
		cboGiaTien.setBackground(Color.WHITE);
		cboGiaTien.setBounds(289, 79, 422, 43);
		panel_2.add(cboGiaTien);
//		====== BUTTON ==================
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 192, 203));
		panel_3.setBounds(10, 360, 1505, 72);
		panel.add(panel_3);
		panel_3.setLayout(null);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(FrmTimKiemXe.class.getResource("/image/search32.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnTimKiem.setBounds(1208, 10, 218, 52);
		panel_3.add(btnTimKiem);

		btnLoad = new JButton("");
		btnLoad.setBackground(Color.WHITE);
		btnLoad.setIcon(new ImageIcon(FrmTimKiemXe.class.getResource("/image/synchronize_30px.png")));
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnLoad.setBounds(1436, 10, 59, 52);
		panel_3.add(btnLoad);

		// ================= TABLE ===============
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblModelTimKiemXe = new DefaultTableModel(col, 0);
		pnTable.setBounds(10, 442, 1505, 286);
		panel.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblTimKiem = new JTable(tblModelTimKiemXe);
		tblTimKiem.setFillsViewportHeight(true);
		tblTimKiem.setColumnSelectionAllowed(false);
		tblTimKiem.setCellSelectionEnabled(true);
		tblTimKiem.setRowHeight(25);
		tblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tblTimKiem.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tblTimKiem);
		pnTable.add(scrollPane);

//		================ ACTION ================
		btnTimKiem.addActionListener(this);
		tblTimKiem.addMouseListener(this);

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

	public String getMaHang(String tenHang) {
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
					return i.getMaLoai() + "";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void loadDatatoTable() throws Exception {
		tblTimKiem.setModel(tblModelTimKiemXe = new DefaultTableModel(col, 0));
		for (Xe xe : Xe_DAO.getallSP()) {
			String trangThai = "Còn bán";

			if (!xe.isTrangThai())
				trangThai = "Không còn bán";

			Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
					xe.getDungTich(), xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
			tblModelTimKiemXe.addRow(obj);
		}
	}

	public void loadCboHangXe() {
		try {
//			=============== LOAD CBO HANG XE ===================
			cboModelHangXe = new DefaultComboBoxModel();
			cboModelHangXe.addElement("");
			for (HangXe i : Xe_DAO.getAllHangXe())
				cboModelHangXe.addElement(i.getTenHang());
			cboHangXe.setModel(cboModelHangXe);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean checkAllEmpty() {
		if (txtTenXe.getText().equals("")
				&& cboGiaTien.getSelectedItem().toString().equals("")
				&& cboHangXe.getSelectedItem().toString().equals("")
				&& cboLoaiXe.getSelectedItem().toString().equals("")) {
			return true;
		}
		return false;
	}

	public void loadCboLoaiXe() {
		try {
//			================ LOAD CBO LOAI XE =================
			cboModelLoaiXe = new DefaultComboBoxModel();
			cboModelLoaiXe.addElement("");
			for (LoaiXe i : Xe_DAO.getAllLoaiXe())
				cboModelLoaiXe.addElement(i.getTenLoai());
			cboLoaiXe.setModel(cboModelLoaiXe);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void loadCboGiaTien() {
		try {
//			================ LOAD CBO LOAI XE =================
			cboModelGiaTien = new DefaultComboBoxModel();
			cboModelGiaTien.addElement("");
			cboModelGiaTien.addElement("Dưới 20 triệu");
			cboModelGiaTien.addElement("Từ 20 triệu đến 100 triệu");
			cboModelGiaTien.addElement("Trên 100 triệu");
			cboGiaTien.setModel(cboModelGiaTien);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void loadXeTheoDanhMuc(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean tinhTrang)
	{
		tblTimKiem.setModel(tblModelTimKiemXe = new DefaultTableModel(col, 0));
		try {
			for (Xe xe : Xe_DAO.getXeTheoDanhMuc(tenXeTK,maHangTK,maLoaiXeTK,tinhTrang)) {
				String trangThai = "Còn bán";

				if (!xe.isTrangThai())
					trangThai = "Không còn bán";

				Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
						xe.getDungTich(), xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
				tblModelTimKiemXe.addRow(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadXeTheoGiaTienDuoi20(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean tinhTrang)
	{
		tblTimKiem.setModel(tblModelTimKiemXe = new DefaultTableModel(col, 0));
		try {
			for (Xe xe : Xe_DAO.getXeTheoGiaTienDuoi20(tenXeTK,maHangTK,maLoaiXeTK,tinhTrang)) {
				String trangThai = "Còn bán";

				if (!xe.isTrangThai())
					trangThai = "Không còn bán";

				Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
						xe.getDungTich(), xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
				tblModelTimKiemXe.addRow(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadXeTheoGiaTienTu20Den100(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean tinhTrang)
	{
		tblTimKiem.setModel(tblModelTimKiemXe = new DefaultTableModel(col, 0));
		try {
			for (Xe xe : Xe_DAO.getXeTheoGiaTienTu20TDen100T(tenXeTK,maHangTK,maLoaiXeTK,tinhTrang)) {
				String trangThai = "Còn bán";

				if (!xe.isTrangThai())
					trangThai = "Không còn bán";

				Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
						xe.getDungTich(), xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
				tblModelTimKiemXe.addRow(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadXeTheoGiaTienTren100(String tenXeTK, String maHangTK, String maLoaiXeTK, boolean tinhTrang)
	{
		tblTimKiem.setModel(tblModelTimKiemXe = new DefaultTableModel(col, 0));
		try {
			for (Xe xe : Xe_DAO.getXeTheoGiaTienTren100T(tenXeTK,maHangTK,maLoaiXeTK,tinhTrang)) {
				String trangThai = "Còn bán";

				if (!xe.isTrangThai())
					trangThai = "Không còn bán";

				Object[] obj = { xe.getMaXe(), xe.getTenXe(), xe.getMaHangXe(), xe.getMaLoai(), xe.getMucTieuThu(),
						xe.getDungTich(), xe.getGiaTien(), xe.getSoLuongTon(), trangThai };
				tblModelTimKiemXe.addRow(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnLoad)) {
			try {
				loadDatatoTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btnTimKiem)) {
			String tenXe = txtTenXe.getText();
			String hangXe = getMaHang((String) cboHangXe.getSelectedItem());
			if(hangXe == null) hangXe ="";
			String loaiXe =  getMaLoai((String) cboLoaiXe.getSelectedItem());
			if(loaiXe == null) loaiXe = "";
			boolean trangThai = true;
			if(!chbTrangThai.isSelected())
				trangThai = false;
			if (checkAllEmpty() || cboGiaTien.getSelectedIndex() == 0 ) {
				try {
					loadDatatoTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cboGiaTien.getSelectedIndex() == 1) {
				try {
					loadXeTheoGiaTienDuoi20(tenXe, hangXe, loaiXe, trangThai);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cboGiaTien.getSelectedIndex() == 2) {
				try {
					loadXeTheoGiaTienTu20Den100(tenXe, hangXe, loaiXe, trangThai);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (cboGiaTien.getSelectedIndex() == 3) {
				try {
					loadXeTheoGiaTienTren100(tenXe, hangXe, loaiXe, trangThai);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
