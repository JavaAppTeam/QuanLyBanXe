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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.HangXeDao;
import DAO.LoaiXeDao;
import Entity.HangXe;
import Entity.LoaiXe;

public class FrmLoaiXe extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTextField txtTenLoai;
	private JCheckBox chbTrangThai;
	private JButton btnThem, btnXoaTrang, btnLuu, btnDelete;
	private DefaultTableModel tblModelLoaiXe;
	private JTable tblLoaiXe;
	private LoaiXeDao loaiXeDAO = new LoaiXeDao();

	String[] col = { "Mã loại xe", "Tên loại xe", "Trạng thái" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLoaiXe frame = new FrmLoaiXe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public FrmLoaiXe() throws Exception {
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(-5, -26, 1600, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ==================== input
		JPanel panel = new JPanel();
		panel.setForeground(new Color(220, 20, 60));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin lo\u1EA1i xe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 1030, 277);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Trạng thái:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(23, 171, 142, 39);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Tên loại xe:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(23, 66, 142, 39);
		panel.add(lblNewLabel_4);

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 24));
		txtTenLoai.setText("Xe điện");
		txtTenLoai.setBounds(212, 73, 783, 28);
		panel.add(txtTenLoai);

		chbTrangThai = new JCheckBox("");
		chbTrangThai.setFont(new Font("Arial", Font.PLAIN, 24));
		chbTrangThai.setSelected(true);
		chbTrangThai.setBounds(212, 174, 21, 28);
		panel.add(chbTrangThai);

		JPanel pnImage = new JPanel();
		pnImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnImage.setBackground(Color.PINK);
		pnImage.setBounds(1063, 11, 513, 277);
		contentPane.add(pnImage);
		pnImage.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/picXe1.png")));
		pnImage.add(lblNewLabel, BorderLayout.CENTER);

//		================== BUTTON =================
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/add32.png")));
		btnThem.setBounds(252, 312, 160, 46);
		contentPane.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 28));

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/eraser32.png")));
		btnXoaTrang.setBounds(550, 312, 190, 46);
		contentPane.add(btnXoaTrang);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 28));

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/floppy-disk32.png")));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnLuu.setBounds(878, 312, 160, 46);
		contentPane.add(btnLuu);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/remove32.png")));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(1176, 312, 160, 46);
		contentPane.add(btnDelete);

		// ================= TABLE ===============
		JPanel pnTable = new JPanel();
		pnTable.setBounds(10, 375, 1566, 358);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblModelLoaiXe = new DefaultTableModel(col, 0);

		
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblLoaiXe = new JTable(tblModelLoaiXe);
		tblLoaiXe.setFillsViewportHeight(true);
		tblLoaiXe.setColumnSelectionAllowed(false);
		tblLoaiXe.setCellSelectionEnabled(true);
		tblLoaiXe.setRowHeight(25);
		tblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblLoaiXe.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tblLoaiXe);
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
		btnXoaTrang.addActionListener(this);
		tblLoaiXe.addMouseListener(this);
		loadDatatoTable();
	}

	public void loadDatatoTable() throws Exception {
		tblLoaiXe.setModel(tblModelLoaiXe = new DefaultTableModel(col, 0));
		for (LoaiXe item : loaiXeDAO.getallSP()) {
			String trangThai = "Còn hiện hành";

			if (!item.isTrangThai())
				trangThai = "Không còn hiện hành";
			Object[] obj = { item.getMaLoai(), item.getTenLoai(), trangThai };
			tblModelLoaiXe.addRow(obj);
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

	public LoaiXe taoLoaiXe() {
		String tenLoai = txtTenLoai.getText();
		boolean trangThai;
		if (chbTrangThai.isSelected()) {
			trangThai = true;
		} else
			trangThai = false;
		return new LoaiXe(tenLoai, trangThai);
	}

	public void loadDataToText(LoaiXe loaiXe) {
		txtTenLoai.setText(loaiXe.getTenLoai());
		if (loaiXe.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);
	}

	public void xoaTrang() {
		txtTenLoai.setText("");
		chbTrangThai.setSelected(false);
	}

	public boolean validateLSP() {
		// check ten xe
		String tenLoai = txtTenLoai.getText().trim();
		if (!tenLoai.matches(
				"[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\w]+")) {
			showMessage("Error: Vui lòng nhập đúng cú pháp VD: Tay Côn", txtTenLoai);
			return false;
		}
		return true;
	}

	public boolean checkEmpty() {
		if (txtTenLoai.getText().equals("")) {
			showMessage("Tên loại không được để trống!!!", txtTenLoai);
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDelete)) {
			String tenLoai = txtTenLoai.getText();
			LoaiXe item = null;
			try {
				item = loaiXeDAO.getXeTheoTenLoai(tenLoai);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA Loại xe này?",
					"Thông báo xác nhận XÓA Loại xe", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				try {
					if (item == null)
						showMessage("Xóa thất bại", null);
					loaiXeDAO.deleteLoaiXe(item.getMaLoai());
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
					LoaiXe item = taoLoaiXe();
					if (item == null)
						showMessage("Lưu thất bại!!!", null);
					else {
						try {
							loaiXeDAO.themSP(item);
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

		} else if (obj.equals(btnThem)) {
			btnLuu.setEnabled(true);
			btnDelete.setEnabled(false);
		} else if (obj.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblLoaiXe.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(loaiXeDAO.getallSP().get(select));
				btnThem.setEnabled(true);
				btnLuu.setEnabled(false);
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
