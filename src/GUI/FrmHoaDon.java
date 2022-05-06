package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JCalendar;

import DAO.CuaHang_DAO;
import DAO.HoaDon_DAO;
import Entity.CuaHang;
import Entity.HoaDon;
import GUI.FrmChiTietHD.FrmChiTietHDResponse;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.Timer;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import com.toedter.calendar.JDateChooser;

public class FrmHoaDon extends JFrame {
	private JTable table_1;
	private DefaultTableModel dataModel;
	private JScrollPane scroll;
	private JTextField txtTimkiem;
	private FrmHoaDon_ThemHoaDon frmHD_ThemHD;
	private FrmChiTietHD frmChiTietHD;
	private HoaDon_DAO hdDao = new HoaDon_DAO();
	private JTextPane txtMaHD, txtMaNV, txtMaCH, txtMaKH;
	private JDateChooser dtNgayLap;
	private JButton btnLuu, btnSua, btnXoa, btnChiTietHD;
	private JComboBox cbbMaCuaHang;
	private String maHDToCTHD = "", maKHToCTHD = "", maNVToCTHD = "";
	public static JPanel pnShowCTHD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHoaDon frame = new FrmHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public FrmHoaDon() throws SQLException, PropertyVetoException, ClassNotFoundException {
		setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().setBackground(Color.PINK);
		getContentPane().setForeground(new Color(0, 0, 0));
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		pnShowCTHD = new JPanel();
		pnShowCTHD.setBounds(420, 20, 619, 608);
		getContentPane().add(pnShowCTHD);
		pnShowCTHD.setLayout(new BorderLayout(0, 0));
		
		frmHD_ThemHD = new FrmHoaDon_ThemHoaDon();
		pnShowCTHD.add(frmHD_ThemHD, BorderLayout.NORTH);
		pnShowCTHD.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBorder(new TitledBorder(null, "Thông tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 49, 1340, 195);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(130, 113, 96, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(700, 55, 106, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(109, 76, 117, 23);
		JCalendar calendar = new JCalendar();
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(147, 33, 87, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã cửa hàng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(710, 95, 96, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtMaHD = new JTextPane();
		txtMaHD.setBounds(242, 30, 350, 28);
		txtMaHD.setEditable(false);
		panel.add(txtMaHD);
		
		dtNgayLap = new JDateChooser();
		dtNgayLap.setBounds(240, 73, 352, 30);
		dtNgayLap.setEnabled(false);
		panel.add(dtNgayLap);
		
		dtNgayLap = new JDateChooser();
		dtNgayLap.setBounds(240, 73, 352, 30);
		panel.add(dtNgayLap);
		
		txtMaNV = new JTextPane();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(242, 118, 350, 28);
		panel.add(txtMaNV);
		
		txtMaKH = new JTextPane();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(818, 55, 350, 28);
		panel.add(txtMaKH);
		
		txtMaCH = new JTextPane();
		txtMaCH.setEditable(false);
		txtMaCH.setBounds(817, 92, 350, 28);
		panel.add(txtMaCH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(226, 349, 1124, 314);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		String[] tieuDe = { "Mã HD","Ngày lập hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã cửa hàng"};
		panel_1.add(scroll = new JScrollPane(table_1 = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		table_1.setRowHeight(30);
		JTableHeader tableHeader = table_1.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSua.setEnabled(true);
				int rowSelect = table_1.getSelectedRow();
				String maHD = (String) table_1.getValueAt(rowSelect, 0);
				Date ngayLap = (Date) table_1.getValueAt(rowSelect, 1);
				String maKH = (String) table_1.getValueAt(rowSelect, 2);
				String maNV = (String) table_1.getValueAt(rowSelect, 3);
				String maCH = (String) table_1.getValueAt(rowSelect, 4);
				txtMaHD.setText(maHD);
				dtNgayLap.setDate(ngayLap);
				txtMaCH.setText(maCH);
				txtMaKH.setText(maKH);
				txtMaNV.setText(maNV);
				maHDToCTHD = maHD;
				maKHToCTHD = maKH;
				maNVToCTHD = maNV;
			}
		});
		
		// can giua column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN BÁN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(644, 290, 306, 49);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(226, 294, 385, 40);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnThem_1 = new JButton("Tìm Kiếm");
		btnThem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strMaHD = txtTimkiem.getText();
				int iMaHD = 0;
				try {
					iMaHD = Integer.parseInt(strMaHD);
				} catch (Exception e2) {
					// TODO: handle exception
				}				
				if(iMaHD == 0)
				{
					List<HoaDon> dsHD = new ArrayList<HoaDon>();
					HoaDon_DAO hdDao = new HoaDon_DAO();
					try {
						dsHD = hdDao.getAllMaHD(strMaHD.trim());
						int tblRow = table_1.getRowCount();
						for (int i = tblRow - 1; i >= 0; i--) {
							dataModel.removeRow(i);
						}
						for (HoaDon hd : dsHD) {
							dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					List<HoaDon> dsHD = new ArrayList<HoaDon>();
					HoaDon_DAO hdDao = new HoaDon_DAO();
					try {
						dsHD = hdDao.getAllMaHDToSdtKH(iMaHD);
						int tblRow = table_1.getRowCount();
						for (int i = tblRow - 1; i >= 0; i--) {
							dataModel.removeRow(i);
						}
						for (HoaDon hd : dsHD) {
							dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
						}
						iMaHD = 0;
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnThem_1.setBounds(259, 4, 117, 29);
		panel_3.add(btnThem_1);
		btnThem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtTimkiem = new JTextField();
		txtTimkiem.setBounds(10, 5, 239, 28);
		panel_3.add(txtTimkiem);
		txtTimkiem.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(990, 294, 360, 40);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Cửa hàng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(56, 10, 78, 19);
		panel_4.add(lblNewLabel_5);
		
		cbbMaCuaHang = new JComboBox<String>();
		cbbMaCuaHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCH = (String) cbbMaCuaHang.getSelectedItem();
				HoaDon_DAO hdDao = new HoaDon_DAO();
				List<HoaDon> dsHD = new ArrayList<>();
				try {
					dsHD = hdDao.addDshdToCuaHang(maCH);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				int tblRow = table_1.getRowCount();
				for (int i = tblRow - 1; i >= 0; i--) {
					dataModel.removeRow(i);
				}
				for (HoaDon hd : dsHD) {
					dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
				}
			}
		});
		cbbMaCuaHang.setBounds(140, 6, 210, 29);
		panel_4.add(cbbMaCuaHang);
		
		JLabel lblNewLabel_6 = new JLabel("|");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(46, 2, 10, 33);
		panel_4.add(lblNewLabel_6);
		
		btnChiTietHD = new JButton();
		btnChiTietHD.setBackground(SystemColor.activeCaption);
		btnChiTietHD.setIcon(new ImageIcon(FrmHoaDon.class.getResource("/image/icons8_bill_32.png")));
		btnChiTietHD.setBounds(0, 0, 46, 40);
		panel_4.add(btnChiTietHD);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(10, 486, 195, 177);
		getContentPane().add(calendar_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 291, 195, 185);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHD_ThemHD.setVisible(true);
			}
		});
		btnThem.setBounds(10, 10, 171, 33);
		panel_2.add(btnThem);
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		btnChiTietHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(maHDToCTHD.equals("")) {
					JOptionPane.showMessageDialog(null, "Chọn một hóa đơn để xem chi tiết hóa đơn!");
				}
				else {
					try {
						pnShowCTHD.setVisible(true);
						frmChiTietHD = new FrmChiTietHD(new FrmChiTietHDResomseImpl(), maHDToCTHD, maKHToCTHD,maNVToCTHD);
						frmChiTietHD.setBounds(400, 0, 619, 608);
						pnShowCTHD.add(frmChiTietHD, BorderLayout.CENTER);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmChiTietHD.setVisible(true);
				}
			}
		});
		
		btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEdit();
				btnLuu.setEnabled(true);
			}
		});
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSua.setBounds(10, 53, 171, 33);
		panel_2.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				String maHD = (String) table_1.getValueAt(row, 0);
				HoaDon_DAO hdDao = new HoaDon_DAO();
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?","Lựa chọn",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				Boolean bXoa = false;
				try {
					bXoa = hdDao.xoaHD(maHD);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(bXoa == true)
				{
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				}
			}
			}
		});
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnXoa.setBounds(10, 96, 171, 33);
		panel_2.add(btnXoa);
		
		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKH = txtMaKH.getText();
				String maHD = txtMaHD.getText();
				HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
				Boolean bSuaHD;
				try {
					bSuaHD = hoaDon_DAO.suaHD(maKH,maHD);
					if(bSuaHD == true)
						JOptionPane.showMessageDialog(null, "Sửa thành công.");
					loadCTHD();
					btnLuu.setEnabled(true);
					return;
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLuu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLuu.setBounds(10, 142, 171, 33);
		btnLuu.setEnabled(false);
		panel_2.add(btnLuu);
		
		JLabel clock = new JLabel("clock");
		clock.setBounds(92, 10, 90, 23);
		getContentPane().add(clock);
		clock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		Timer timer;
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.util.Date date = new java.util.Date();
				DateFormat timDateFormat = new SimpleDateFormat("HH:mm:ss");
				String time = timDateFormat.format(date);
				clock.setText(time);
			}
		};
		timer = new Timer(1000, actionListener);
		timer.setInitialDelay(0);
		timer.start();
		java.util.Date date2 = new java.util.Date();
		DateFormat timDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String time2 = timDateFormat2.format(date2);
		
		JLabel datenow = new JLabel("date");
		datenow.setBounds(234, 10, 130, 23);
		getContentPane().add(datenow);
		datenow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		datenow.setText(time2);
				
		JLabel imgclock = new JLabel("");
		imgclock.setBounds(52, 5, 30, 28);
		getContentPane().add(imgclock);
		imgclock.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/alarm_clock_30px.png")));
		
		JLabel imgdate = new JLabel("");
		imgdate.setBounds(194, 5, 30, 28);
		getContentPane().add(imgdate);
		imgdate.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/thursday_30px.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadCTHD();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FrmHoaDon.class.getResource("/image/synchronize_30px.png")));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(1307, 254, 43, 40);
		getContentPane().add(btnNewButton_1);
		
		setResizable(false);
		setBounds(-5, -26, 1372, 710);
		loadCTHD();
		loadMaCH();
	}

//	public FrmHoaDon(Boolean bCheckStatusForm) throws SQLException, PropertyVetoException {
//		FrmHoaDon frmHoaDon = new FrmHoaDon();
//		if(bCheckStatusForm == true) {
//			frmHoaDon.loadCTHD();
//		}
//		
//	}
	protected void openEdit() {
		// TODO Auto-generated method stub
		txtMaKH.setEditable(true);
	}

	private class FrmChiTietHDResomseImpl implements FrmChiTietHDResponse{

		@Override
		public void getResponse(boolean bStatusPnCTHD) {
			// TODO Auto-generated method stub
			if(bStatusPnCTHD == true) {
				pnShowCTHD.setVisible(false);
			}
		}
		
	}
	
	private void loadCTHD() throws SQLException {
		// TODO Auto-generated method stub
		int tblRow = table_1.getRowCount();
		for (int i = tblRow - 1; i >= 0; i--) {
			dataModel.removeRow(i);
		}
		for (HoaDon hd : hdDao.getAllHD()) {
			dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
		}
	}
	
	private void loadMaCH() throws SQLException {
		CuaHang_DAO cuaHang_DAO = new CuaHang_DAO();
		cbbMaCuaHang.removeAllItems();
		for(CuaHang ch : cuaHang_DAO.getAllCuaHang()) {
			cbbMaCuaHang.addItem(ch.getMaCuaHang());
		}
	}
}
