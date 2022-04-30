package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.NumberFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DAO.ChiTietXeDAO;
import DAO.CuaHang_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.Xe_DAO;
import Entity.ChiTietXe;
import Entity.CuaHang;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Xe;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class FrmHoaDon_ThemHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	
	private JTextPane txtThue;
	private JFormattedTextField txtDonGia;
	private JDateChooser dtNgayLap;
	private FrmHoaDon_ThemHoaDon frmHD_ThemHD;
	private JComboBox<String> cbbmaCuaHang,cbbMSNV,cbbMaXe;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel dataModel;
	private JScrollPane scrollPane;
	private JLabel lblTenXe, lblTongTien;
	private JComboBox<String> cbbSdtKH;
	private List<Xe> dsXe = new ArrayList<Xe>();
	private JSpinField spinField;
	private Xe xe;
	private Locale localeVN = new Locale("vi", "VN");
	private NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	private java.util.Date date;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHoaDon_ThemHoaDon frame = new FrmHoaDon_ThemHoaDon();
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
	 */
	public FrmHoaDon_ThemHoaDon() throws PropertyVetoException, SQLException {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setTitle("Thêm Hóa Đơn");
		//this.setClosable(true);
		//this.setIconifiable(true);
		this.setResizable(true);
		setBounds(5, 26, 1139, 510);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBorder(new TitledBorder(null, "Thông tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 1107, 231);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(510, 159, 96, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(490, 115, 116, 39);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 40, 120, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã cửa hàng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(517, 77, 96, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã xe:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(559, 37, 42, 23);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Đơn giá:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(89, 77, 63, 31);
		panel.add(lblNewLabel_4_2);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		txtDonGia = new JFormattedTextField(formatter);
		txtDonGia.setText("15,000,000");
		txtDonGia.setBounds(159, 80, 273, 28);
		panel.add(txtDonGia);
		
		JLabel lblNewLabel_4_3 = new JLabel("Thuế:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(99, 125, 49, 23);
		panel.add(lblNewLabel_4_3);
		
		txtThue = new JTextPane();
		txtThue.setText("0.15");
		txtThue.setBounds(159, 122, 273, 28);
		panel.add(txtThue);
		
		date = new java.util.Date();
		dtNgayLap = new JDateChooser();
		dtNgayLap.setDate(date);
		dtNgayLap.setBounds(157, 37, 275, 30);
		panel.add(dtNgayLap);
		
		cbbSdtKH = new JComboBox<String>();
		cbbSdtKH.setBounds(621, 116, 336, 31);
		panel.add(cbbSdtKH);
		cbbSdtKH.setEditable(true);
		AutoCompleteDecorator.decorate(cbbSdtKH);
		
		cbbmaCuaHang = new JComboBox<String>();
		cbbmaCuaHang.setBounds(621, 71, 336, 31);
		cbbmaCuaHang.setEditable(true);
		panel.add(cbbmaCuaHang);
		AutoCompleteDecorator.decorate(cbbmaCuaHang);
		
		cbbMSNV = new JComboBox<String>();
		cbbMSNV.setBounds(621, 157, 336, 31);
		panel.add(cbbMSNV);
		cbbMSNV.setEditable(true);
		AutoCompleteDecorator.decorate(cbbMSNV);
		
		cbbMaXe = new JComboBox<String>();
		cbbMaXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maXe = (String) cbbMaXe.getSelectedItem();
				try {
					loadTenXe(maXe);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		cbbMaXe.setBounds(621, 31, 116, 28);
		cbbMaXe.setEditable(true);
		AutoCompleteDecorator.decorate(cbbMaXe);
		panel.add(cbbMaXe);
		
		spinField = new JSpinField();
		spinField.setValue(1);
		spinField.setBounds(746, 27, 45, 37);
		spinField.setHorizontalAlignment(SwingConstants.CENTER);
		spinField.setMinimum(0);
		panel.add(spinField);
		
		lblTongTien = new JLabel();
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien.setVerticalAlignment(SwingConstants.CENTER);
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		lblTongTien.setBounds(159, 164, 273, 39);
		panel.add(lblTongTien);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/btnThem.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(967, 115, 42, 33);
		panel.add(btnNewButton_1);
		
		lblTenXe = new JLabel();
		lblTenXe.setBounds(801, 28, 156, 29);
		lblTenXe.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
		lblTenXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenXe.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(lblTenXe);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberFormat format = NumberFormat.getInstance(Locale.US);    
				Number number = null;
				int giaTien = 0;
				try {
					number = format.parse(txtDonGia.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					
				}
				int donGia = number == null ? 0 : number.intValue();
				String thue = txtThue.getText();
				//ThanhTien
				try {
					if(donGia == 0) {
						JOptionPane.showMessageDialog(null, "Đơn giá không được để trống!");
						txtDonGia.requestFocus();
						return;
					}
					else if(thue == ""){
						JOptionPane.showMessageDialog(null, "Thuế không được để trống!");
						txtThue.requestFocus();
						return;
					}
					else {
						try {
							//Them Xe
							giaTien = thanhTienBill(donGia);
							xe = createXe(giaTien);
							if(xe == null)
								return;
							
							//Kiem Tra Trung
							String strMa = (String) cbbMaXe.getSelectedItem();
							for(int i = 0; i < dsXe.size(); i++) {
								if(dsXe.get(i).getMaCTXe().equalsIgnoreCase(strMa)) {
									JOptionPane.showMessageDialog(null, "Mã xe trùng, chọn mã xe khác!");
									return;
								}
							}
							dsXe.add(xe);						
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
							
				Object[] ob = {xe.getMaCTXe(),xe.getTenXe(),xe.getSoluongMua(),xe.getSoKhung(),xe.getSoMay(),xe.getDungTich(),giaTien};
				dataModel.addRow(ob);
				
				//ThanhTien
				thanhTien();
					}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/btnThem.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(967, 27, 42, 33);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Tổng Tiền:");
		lblNewLabel_4_3_1.setForeground(Color.RED);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_3_1.setBounds(46, 173, 96, 23);
		panel.add(lblNewLabel_4_3_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 294, 1107, 177);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		String[] tieuDe = { "Mã Xe","Tên Xe","Số Lượng", "Số Khung", "Số máy", "Dung Tích","Giá"};
		table.setRowHeight(30);
		panel_1.add(scrollPane = new JScrollPane(table_1 = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		table_1.setRowHeight(25);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		
		JTableHeader tableHeader = table_1.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 14));
		
		JButton btnLu = new JButton("LƯU");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLu.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/btnSave.png")));
		btnLu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLu.setBounds(372, 247, 141, 35);
		getContentPane().add(btnLu);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table_1.getSelectedRow();
				if(selectRow < 0) {
					JOptionPane.showMessageDialog(null, "Chọn 1 mục trong bảng để xóa!");
				}
				else {
					Xe xe = dsXe.get(selectRow);
					if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?","Lựa chọn",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						dsXe.remove(xe);
						
						table_1.setModel(dataModel = new DefaultTableModel(tieuDe,0));
						editTable();
						for(Xe i : dsXe) {
							Object[] ob = {i.getMaCTXe(),i.getTenXe(),i.getSoluongMua(),i.getSoKhung(),i.getSoMay(),i.getDungTich(), (int)i.getGiaTien()};	
							dataModel.addRow(ob);
						};
						thanhTien();
						}
				}
			}
		});
		btnXa.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/btnXoa.png")));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXa.setBounds(559, 247, 141, 35);
		getContentPane().add(btnXa);
		loadMaXe();
		loadMaCH();
		loadSdtKH();
		loadMaNV();
	}

	protected void editTable() {
		// TODO Auto-generated method stub
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		
		JTableHeader tableHeader = table_1.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 14));
	}

	protected void thanhTien() {
		int total = 0;
		int iRow = table_1.getRowCount();
		for(int i = 0; i < iRow; i++) {
			int amount = (int) table_1.getValueAt(i, 6);
		    total += amount;
		}
		lblTongTien.setText(currencyVN.format(total));
	}

	protected int thanhTienBill(int donGia) throws ParseException {
		// TODO Auto-generated method stub
		int soluong = spinField.getValue();
		double thue = Double.parseDouble(txtThue.getText());
		int TongTien = (int) (donGia * soluong + (donGia * soluong)*thue);
		return TongTien;
	}

	protected Xe createXe(int giaTien) throws SQLException {
		// TODO Auto-generated method stub
		String maxe = (String) cbbMaXe.getSelectedItem();
		int soluong = spinField.getValue();
		if(soluong <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng xe phải lớn hơn 0!");
			return null;
		}
		Xe_DAO xeDao = new Xe_DAO();
		Xe xe = xeDao.getXeMaXe(maxe.trim(), soluong, giaTien);
		return xe;
	}

	private void loadMaNV() throws SQLException {
		// TODO Auto-generated method stub
		NhanVien_DAO nvien = new NhanVien_DAO();
		cbbMSNV.removeAllItems();
		for(NhanVien nv : nvien.getAllMaNV()) {
			cbbMSNV.addItem(nv.getMaNhanVien());
		}
	}

	private void loadSdtKH() throws SQLException {
		KhachHang_DAO kh = new KhachHang_DAO();
		cbbSdtKH.removeAllItems();
		for(KhachHang khachHang : kh.getAllSdtKH()) {
			cbbSdtKH.addItem(khachHang.getSdt());
		}
	}

	private void loadMaCH() throws SQLException {
		CuaHang_DAO cuaHang_DAO = new CuaHang_DAO();
		cbbmaCuaHang.removeAllItems();
		for(CuaHang ch : cuaHang_DAO.getAllCuaHang()) {
			cbbmaCuaHang.addItem(ch.getMaCuaHang());
		}
	}

	protected void loadTenXe(String maXe) {
		// TODO Auto-generated method stub
		ChiTietXeDAO chiTietXe = new ChiTietXeDAO();
		String strTenXe = chiTietXe.getTenXe(maXe);
		lblTenXe.setText(strTenXe);
	}

	private void loadMaXe() throws SQLException {
		ChiTietXeDAO chiTietXe = new ChiTietXeDAO();
		cbbMaXe.removeAllItems();
		for (ChiTietXe ctxe : chiTietXe.getAllMaXe()) {
			cbbMaXe.addItem(ctxe.getMaCTXe());
		}
	}
}