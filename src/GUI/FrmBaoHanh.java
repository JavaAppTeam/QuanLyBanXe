package GUI;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import DAO.*;
import Entity.HoaDonBaoHanh;

public class FrmBaoHanh extends JInternalFrame implements MouseListener {

	/**
	 * Launch the application. Tên: Trần Văn Sỹ Ngày tạo: 16/04/2022
	 */
	private JTextField txtMaBaoHanh;
	private JTextField txtGhiChu;
	private JTable tblBaoHanh;
	private DefaultTableModel dtmBaoHanh;
	private JTextField txtSearch;
	private JComboBox cboTrangThai;
	JComboBox cboLyDoBaoHanh;
	private DAO.HoaDonBaoHanhDao baoHanhDao = new HoaDonBaoHanhDao();
	JButton btnSearch, btnThem, btnUpdate, btnChiTiet;
	String[] colHeader = { "MÃ BẢO HÀNH", "NGÀY LẬP HÓA ĐƠN", "LÍ DO BẢO HÀNH", "GHI CHÚ", "TRẠNG THÁI" };
	ArrayList<HoaDonBaoHanh> arrHDBH = null;
	private JButton btnXoaTrang;
	private JTextField txtNgayLapHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBaoHanh frame = new FrmBaoHanh();
					frame.showWindown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showWindown() {
		this.setSize(993, 452);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public FrmBaoHanh() throws Exception {
		setBounds(-5, -26, 1600, 780);
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);

		JPanel Container = new JPanel();
		Container.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Qu\u1EA3n l\u00FD b\u1EA3o h\u00E0nh", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Container.setForeground(new Color(220, 20, 60));
		Container.setBackground(new Color(255, 192, 203));
		Container.setBounds(10, 10, 1508, 731);
		getContentPane().add(Container);
		Container.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(220, 20, 60));
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Container.add(panel_1);
		panel_1.setBounds(20, 21, 929, 227);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã bảo hành:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 17, 131, 25);
		panel_1.add(lblNewLabel);

		JLabel lblLDoBo = new JLabel("Lý do bảo hành:");
		lblLDoBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLDoBo.setBounds(24, 101, 152, 25);
		panel_1.add(lblLDoBo);

		JLabel lblLDo = new JLabel("Ghi chú:");
		lblLDo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLDo.setBounds(24, 143, 84, 25);
		panel_1.add(lblLDo);

		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrngThi.setBounds(24, 185, 108, 25);
		panel_1.add(lblTrngThi);

		txtMaBaoHanh = new JTextField();
		txtMaBaoHanh.setEnabled(false);
		txtMaBaoHanh.setBounds(247, 17, 627, 25);
		panel_1.add(txtMaBaoHanh);
		txtMaBaoHanh.setColumns(10);

		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(247, 139, 627, 25);
		panel_1.add(txtGhiChu);

		cboTrangThai = new JComboBox();
		cboTrangThai.setBounds(247, 181, 627, 25);
		panel_1.add(cboTrangThai);
		cboTrangThai.addItem("Hoan thanh");
		cboTrangThai.addItem("Chua hoan thanh");
		cboTrangThai.setSelectedIndex(1);

		JLabel lblNgyLpHa = new JLabel("Ngày lập hóa đơn:");
		lblNgyLpHa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyLpHa.setBounds(24, 59, 173, 25);
		panel_1.add(lblNgyLpHa);

		txtNgayLapHoaDon = new JTextField();
		txtNgayLapHoaDon.setEnabled(false);
		txtNgayLapHoaDon.setColumns(10);
		txtNgayLapHoaDon.setBounds(247, 59, 627, 25);
		txtNgayLapHoaDon.setText(LocalDate.now().toString());
		// txtNgayLapHoaDon.setText(now.plusMonths(24).toString());
		panel_1.add(txtNgayLapHoaDon);

		cboLyDoBaoHanh = new JComboBox();
		cboLyDoBaoHanh.setBounds(247, 101, 627, 21);
		cboLyDoBaoHanh.addItem("Lỗi của khách hàng");
		cboLyDoBaoHanh.addItem("Lỗi của nhà sản xuất");
		cboLyDoBaoHanh.setSelectedIndex(0);
		panel_1.add(cboLyDoBaoHanh);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setForeground(new Color(220, 20, 60));
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(20, 258, 1478, 60);
		Container.add(panel_2);
		panel_2.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setHorizontalAlignment(SwingConstants.LEADING);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/btnThem.png")));
		btnThem.setBounds(40, 10, 112, 38);
		panel_2.add(btnThem);

		btnUpdate = new JButton("Sửa thông tin");
		btnUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/btnSave.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(222, 10, 181, 38);
		panel_2.add(btnUpdate);

		btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/MenuItemTrangChu.png")));
		btnChiTiet.setHorizontalAlignment(SwingConstants.LEADING);
		btnChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChiTiet.setBounds(484, 10, 134, 38);
		panel_2.add(btnChiTiet);

		txtSearch = new JTextField();
		txtSearch.setBounds(969, 18, 405, 32);
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/btnTim.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEADING);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(1384, 16, 49, 32);
		panel_2.add(btnSearch);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/btnXoaTrang.png")));
		btnXoaTrang.setHorizontalAlignment(SwingConstants.LEADING);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaTrang.setBounds(698, 10, 149, 38);
		panel_2.add(btnXoaTrang);

		tblBaoHanh = new JTable();
		tblBaoHanh.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtmBaoHanh = new DefaultTableModel(colHeader, 0);
		tblBaoHanh.setModel(dtmBaoHanh);

		JScrollPane scrollPane = new JScrollPane(tblBaoHanh);
		scrollPane.setSize(1478, 330);
		scrollPane.setLocation(20, 391);
		Container.add(scrollPane);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(FrmBaoHanh.class.getResource("/image/picXe1.png")));
		lblNewLabel_5.setBounds(1005, 21, 462, 227);
		Container.add(lblNewLabel_5);
		
		JLabel lblListHan = new JLabel("List hóa đơn bảo hành");
		lblListHan.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListHan.setBounds(607, 339, 289, 42);
		Container.add(lblListHan);
		setResizable(true);
		addEvents();
	}

	private void addEvents() throws Exception {
		// TODO Auto-generated method stub
		loadDataToTable();
		tblBaoHanh.addMouseListener(this);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					delValuesOnTable();
					search();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnThem.getText() == "Thêm") {
					clearConTrol();
					btnThem.setText("Lưu");
				} else if (btnThem.getText() == "Lưu") {
					try {

						addHDBH();
						delValuesOnTable();
						loadDataToTable();
//						String m = JOptionPane.showInputDialog(null, "Nhập mã hóa đơn muốn bảo hành", 
//				                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						btnThem.setText("Thêm");
//						String m = JOptionPane.showInputDialog(null, "Nhập mã HÓA ĐƠN để bảo hành", 
//				                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						clearConTrol();
//						FrmChiTietBaoHanh frm = new FrmChiTietBaoHanh(txtMaBaoHanh.getText().trim(),m);
//						frm.setVisible(true);			
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Fail !!!!");
			}
		});
		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearConTrol();
			}
		});
		btnChiTiet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FrmChiTietBaoHanh frm = new FrmChiTietBaoHanh(txtMaBaoHanh.getText().trim(),"");
					frm.setVisible(true);
					 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					update();
					delValuesOnTable();
					loadDataToTable();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	private void update() throws ClassNotFoundException, SQLException {
		boolean liDo = false;
		boolean trangThai = false;
		if(cboLyDoBaoHanh.getSelectedIndex()==0)
			liDo = false;
		else 
			liDo = true;
		if(cboTrangThai.getSelectedIndex()==0)
			trangThai = true;
		else 
			trangThai = false;
		if(baoHanhDao.upDateHoaDonBaoHanh(liDo,txtGhiChu.getText().trim(), trangThai,txtMaBaoHanh.getText().trim()))
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			
	}

	private HoaDonBaoHanh createHDBH() throws ParseException {
		String maBaoHanh = txtMaBaoHanh.getText();
		boolean lyDoBaoHanh;
		String dateString = txtNgayLapHoaDon.getText().trim();
		Date ngayLap = Date.valueOf(dateString);
		if (cboLyDoBaoHanh.getSelectedIndex() == 0) {
			lyDoBaoHanh = false;
		} else {
			lyDoBaoHanh = true;
		}
		String ghiChu = txtGhiChu.getText();
		boolean trangThai;
		if (cboTrangThai.getSelectedIndex() == 0) {
			trangThai = true;
		} else
			trangThai = false;
		return (new HoaDonBaoHanh(maBaoHanh, lyDoBaoHanh, ghiChu, trangThai, ngayLap));
	}

	public void addHDBH() throws ClassNotFoundException, SQLException, ParseException {
		boolean kt = baoHanhDao.addHDBH(createHDBH());
		if (kt == true)
			JOptionPane.showMessageDialog(null, "Lưu thành công!!!!");
		else
			JOptionPane.showMessageDialog(null, "Fail !!!!");
	}

	private void loadDataToTable() throws Exception {
		// TODO Auto-generated method stub
		String tt = null;
		String lido= null;
		arrHDBH = new ArrayList<HoaDonBaoHanh>();
		arrHDBH = baoHanhDao.getallHDBH();
		for (HoaDonBaoHanh hd : arrHDBH) {
			if(hd.isLyDoBaoHanh())
				lido ="Lỗi của nhà sản xuất";
			else 
				lido="Lỗi của khách hàng";
			if (hd.isTrangThai())
				tt = "Hoàn thành";
			else
				tt = "Chưa hoàn thành";
			Object[] rowData = { hd.getMaHDBaoHanh(), hd.getNgayLap(),lido, hd.getGhiChu(), tt };
			dtmBaoHanh.addRow(rowData);
		}
	}

	private void del() throws SQLException, Exception {
		// TODO Auto-generated method stub
		String idXoa = txtMaBaoHanh.getText();
		baoHanhDao.deleteHDBH(idXoa);
	}

	private void search() throws Exception {
		// TODO Auto-generated method stub
		String idSearch = txtSearch.getText();
		arrHDBH = new ArrayList<HoaDonBaoHanh>();
		arrHDBH = baoHanhDao.getHDBHTheoMa(idSearch);
		for (HoaDonBaoHanh hd : arrHDBH) {
			Object[] rowData = { hd.getMaHDBaoHanh(),hd.getNgayLap(), hd.isLyDoBaoHanh(), hd.getGhiChu(), hd.isTrangThai() };
			dtmBaoHanh.addRow(rowData);
		}
	}

	private void delValuesOnTable() {
		dtmBaoHanh = null;
		dtmBaoHanh = new DefaultTableModel(colHeader, 0);
		tblBaoHanh.setModel(dtmBaoHanh);
	}

	public void loadDataToText(HoaDonBaoHanh hdbh) {
		txtMaBaoHanh.setText(hdbh.getMaHDBaoHanh() + "");
		txtGhiChu.setText(hdbh.getGhiChu() + "");
		txtNgayLapHoaDon.setText(hdbh.getNgayLap().toString());
		if (hdbh.isLyDoBaoHanh()) {
			cboLyDoBaoHanh.setSelectedIndex(1);
		} else {
			cboLyDoBaoHanh.setSelectedIndex(0);
		}
		if (hdbh.isTrangThai())
			cboTrangThai.setSelectedIndex(0);
		else {
			cboTrangThai.setSelectedIndex(1);
		}
	}

	private void clearConTrol() {
		txtMaBaoHanh.setText("Default");
		txtNgayLapHoaDon.setText(LocalDate.now().toString());
		cboLyDoBaoHanh.setSelectedIndex(0);
		txtGhiChu.setText("");
		txtSearch.setText("");
		cboTrangThai.setSelectedIndex(1);
		txtGhiChu.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblBaoHanh.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(baoHanhDao.getallHDBH().get(select));
			} catch (Exception e2) {
				// TODO: handle exception
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
