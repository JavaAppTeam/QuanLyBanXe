package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.print.DocFlavor.STRING;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ChucVuNhanVien_DAO;
import DAO.CuaHang_DAO;
import DAO.NhanVien_DAO;
import Entity.ChucVuNhanVien;
import Entity.CuaHang;
import Entity.NhanVien;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class FrmQLNhanVien extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private JPanel contentPane;
	private JTextField txtHoVaTenNV;
	private JTextField txtNgaySinhNV;
	private JTextField txtCMNDNV;
	private JTextField txtSDTNV;
	private JTextField txtNamKinhNghiemNV;
	private JTextField txtBacNV;
	private JTextField txtTrinhDoHocVanNV;
	private JTextField txtNgayVaoLamNV;
	private DefaultTableModel tblModelNV;
	private JTable tblThongTinNV;
	private JCheckBox chbTrangThai;
	private JComboBox cbbChucVu;
	private JButton btnLuuNV,btnXoaTrangNV,btnXoaNV,btnSuaNV,btnThemNV;
	private NhanVien_DAO nvDAO = new NhanVien_DAO();
	String[] col = {"Họ và tên", "CMND", "Ngày sinh", "SDT", "Mã chức vụ", "Bậc", "Ngày vào làm",
			"Trình độ học vấn","Năm kinh nghiệm","Trạng thái" };
	private JLabel lblTrngThi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLNhanVien frame = new FrmQLNhanVien();
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
	public FrmQLNhanVien() throws Exception {
		
		
//		======= ACTION ===============
		ShowGUI();
		
		loadDatatoTable();
		loadCVNhanVien();
		tblThongTinNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnThemNV.setEnabled(false);
				btnSuaNV.setEnabled(true);
				btnXoaNV.setEnabled(true);
				int rowSelect = tblThongTinNV.getSelectedRow();
				NhanVien temp = new NhanVien();
				
				temp.setTenNhanVien((String) tblThongTinNV.getValueAt(rowSelect, 0));
				temp.setCmnd((String) tblThongTinNV.getValueAt(rowSelect, 1)); 
				temp.setNgaySinh(LocalDate.parse((String) tblThongTinNV.getValueAt(rowSelect, 2).toString()));
				temp.setSdt((String) tblThongTinNV.getValueAt(rowSelect, 3));
				temp.setMaChucVu((String) tblThongTinNV.getValueAt(rowSelect, 4));
				temp.setBacTho((String) tblThongTinNV.getValueAt(rowSelect, 5));
				temp.setNgayVaoLam(LocalDate.parse((String) tblThongTinNV.getValueAt(rowSelect, 6).toString()));
				temp.setTrinhDoHocVan( Integer.parseInt((String) tblThongTinNV.getValueAt(rowSelect, 7).toString()));
				temp.setSoNamKinhNghiem( Integer.parseInt((String) tblThongTinNV.getValueAt(rowSelect, 8).toString()));
				temp.setTrangThai(Boolean.parseBoolean((String) tblThongTinNV.getValueAt(rowSelect, 9).toString()));
				loadDataToText(temp);
			}
		});
		btnThemNV.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnXoaNV.addActionListener(this);
		btnXoaTrangNV.addActionListener(this);
		btnLuuNV.addActionListener(this);
	

	}
	private void ShowGUI() {
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(-5, -26, 1372, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		-======== INPUT ======================
		JPanel lblTieuDe = new JPanel();
		lblTieuDe.setBounds(0, 0, 1360, 56);
		lblTieuDe.setBackground(new Color(255, 192, 203));
		getContentPane().add(lblTieuDe);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.add(lblNewLabel);
		
		JPanel pnContext = new JPanel();
		pnContext.setBounds(10, 56, 1350, 309);
		pnContext.setBackground(new Color(255, 192, 203));
		getContentPane().add(pnContext);
		
		JPanel pnControlTrai = new JPanel();
		pnControlTrai.setBackground(new Color(255, 192, 203));
		pnControlTrai.setBounds(0, 0, 668, 220);
		pnControlTrai.setLayout(null);
		
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCMND.setBounds(10, 50, 120, 24);
		pnControlTrai.add(lblCMND);
		
		txtHoVaTenNV = new JTextField();
		txtHoVaTenNV.setBackground(Color.WHITE);
		txtHoVaTenNV.setBounds(175, 10, 484, 24);
		pnControlTrai.add(txtHoVaTenNV);
		txtHoVaTenNV.setColumns(10);
		
		JLabel lblHoTenNV = new JLabel("Họ và tên");
		lblHoTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoTenNV.setBounds(10, 10, 120, 24);
		pnControlTrai.add(lblHoTenNV);
		
		txtNgaySinhNV = new JTextField();
		txtNgaySinhNV.setBackground(Color.WHITE);
		txtNgaySinhNV.setBounds(175, 90, 484, 24);
		txtNgaySinhNV.setColumns(10);
		pnControlTrai.add(txtNgaySinhNV);
		
		JLabel lblNgaySinhNV = new JLabel("Ngày sinh");
		lblNgaySinhNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinhNV.setBounds(10, 90, 120, 24);
		pnControlTrai.add(lblNgaySinhNV);
		
		txtCMNDNV = new JTextField();
		txtCMNDNV.setBackground(Color.WHITE);
		txtCMNDNV.setBounds(175, 50, 484, 24);
		txtCMNDNV.setColumns(10);
		pnControlTrai.add(txtCMNDNV);
		
		JLabel lblSDTNV = new JLabel("SĐT");
		lblSDTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDTNV.setBounds(10, 130, 120, 24);
		pnControlTrai.add(lblSDTNV);
		
		txtSDTNV = new JTextField();
		txtSDTNV.setBackground(Color.WHITE);
		txtSDTNV.setBounds(175, 130, 484, 24);
		txtSDTNV.setColumns(10);
		pnControlTrai.add(txtSDTNV);
		
		JPanel pnControlPhai = new JPanel();
		pnControlPhai.setBackground(new Color(255, 192, 203));
		pnControlPhai.setBounds(669, 0, 681, 220);
		pnControlPhai.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnControlPhai.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnControlPhai.setLayout(null);
		pnContext.setLayout(null);
		pnContext.add(pnControlTrai);
		
		JLabel lbmaChucVuNV = new JLabel("Chức vụ");
		lbmaChucVuNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbmaChucVuNV.setBounds(10, 170, 120, 24);
		pnControlTrai.add(lbmaChucVuNV);
		
		cbbChucVu = new JComboBox();
		cbbChucVu.setBounds(175, 176, 484, 21);
		pnControlTrai.add(cbbChucVu);
		pnContext.add(pnControlPhai);
		
		JLabel lblNgayVaoLamNV = new JLabel("Ngày vào làm");
		lblNgayVaoLamNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayVaoLamNV.setBounds(10, 10, 165, 24);
		pnControlPhai.add(lblNgayVaoLamNV);
		
		JLabel lblTrinhDoHocVanNV = new JLabel("Trình độ học vấn");
		lblTrinhDoHocVanNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrinhDoHocVanNV.setBounds(10, 50, 165, 24);
		pnControlPhai.add(lblTrinhDoHocVanNV);
		
		JLabel lblBacNV = new JLabel("Bậc");
		lblBacNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBacNV.setBounds(10, 90, 165, 24);
		pnControlPhai.add(lblBacNV);
		
		JLabel lblNamKinhNgiemNV = new JLabel("Năm kinh nghiệm");
		lblNamKinhNgiemNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNamKinhNgiemNV.setBounds(10, 130, 165, 24);
		pnControlPhai.add(lblNamKinhNgiemNV);
		
		txtNamKinhNghiemNV = new JTextField();
		txtNamKinhNghiemNV.setBackground(Color.WHITE);
		txtNamKinhNghiemNV.setColumns(10);
		txtNamKinhNghiemNV.setBounds(175, 130, 484, 24);
		pnControlPhai.add(txtNamKinhNghiemNV);
		
		txtBacNV = new JTextField();
		txtBacNV.setBackground(Color.WHITE);
		txtBacNV.setColumns(10);
		txtBacNV.setBounds(175, 90, 484, 24);
		pnControlPhai.add(txtBacNV);
		
		txtTrinhDoHocVanNV = new JTextField();
		txtTrinhDoHocVanNV.setBackground(Color.WHITE);
		txtTrinhDoHocVanNV.setColumns(10);
		txtTrinhDoHocVanNV.setBounds(175, 50, 484, 24);
		pnControlPhai.add(txtTrinhDoHocVanNV);
		
		txtNgayVaoLamNV = new JTextField();
		txtNgayVaoLamNV.setBackground(Color.WHITE);
		txtNgayVaoLamNV.setColumns(10);
		txtNgayVaoLamNV.setBounds(175, 10, 484, 24);
		pnControlPhai.add(txtNgayVaoLamNV);
		
		chbTrangThai = new JCheckBox("Làm");
		chbTrangThai.setBounds(175, 166, 73, 31);
		pnControlPhai.add(chbTrangThai);
		chbTrangThai.setBackground(new Color(255, 192, 203));
		chbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(10, 170, 120, 24);
		pnControlPhai.add(lblTrngThi);
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// =================================================
		// ====================== button
		
		btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemNV.setBackground(Color.LIGHT_GRAY);
		btnThemNV.setBounds(10, 249, 240, 39);
		pnContext.add(btnThemNV);
		
		btnSuaNV  = new JButton("Sửa nhân viên");
		btnSuaNV.setEnabled(false);
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuaNV.setBackground(Color.LIGHT_GRAY);
		btnSuaNV.setBounds(277, 249, 240, 39);
		pnContext.add(btnSuaNV);
		
		
		btnXoaNV = new JButton("Xoá nhân viên");
		btnXoaNV.setEnabled(false);
		btnXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaNV.setBackground(Color.LIGHT_GRAY);
		btnXoaNV.setBounds(562, 249, 240, 39);
		pnContext.add(btnXoaNV);
		
		btnXoaTrangNV = new JButton("Xoá trắng");
		btnXoaTrangNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaTrangNV.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangNV.setBounds(839, 249, 240, 39);
		pnContext.add(btnXoaTrangNV);
		
		btnLuuNV = new JButton("Lưu");
		btnLuuNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuuNV.setBackground(Color.LIGHT_GRAY);
		btnLuuNV.setBounds(1110, 249, 240, 39);
		pnContext.add(btnLuuNV);
		
		// ==================== TABLE ==================
		JPanel pnTable = new JPanel();
		tblModelNV = new DefaultTableModel(col, 0);
		pnTable.setBounds(10, 375, 1336, 273);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblThongTinNV = new JTable(tblModelNV);
		tblThongTinNV.setRowSelectionAllowed(true);
		tblThongTinNV.setFillsViewportHeight(true);
		tblThongTinNV.setColumnSelectionAllowed(false);
	
		tblThongTinNV.setRowHeight(25);
		tblThongTinNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblThongTinNV.setBackground(Color.WHITE);
		
		//pnTable.add(tblThongTinNV);
		JScrollPane scrollPane = new JScrollPane(tblThongTinNV);
		pnTable.add(scrollPane);
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
	public NhanVien taoNhanVien() {
		String tenNV = txtHoVaTenNV.getText();
		String cMND = txtCMNDNV.getText();
		LocalDate ngaySinh = LocalDate.parse(txtNgaySinhNV.getText());
		String SDT = txtSDTNV.getText();
		String maChucVu = cbbChucVu.getSelectedItem().toString();
		String bacTho = txtBacNV.getText();
		LocalDate ngayVaoLam = LocalDate.parse(txtNgayVaoLamNV.getText());
		int trinhDoHocVan = Integer.parseInt(txtTrinhDoHocVanNV.getText());
		int soNamKinhNghiem = Integer.parseInt(txtNamKinhNghiemNV.getText());
		boolean trangThai;
		if (chbTrangThai.isSelected() == true)
			trangThai = true;
		else
			trangThai = false;
		return (new NhanVien(tenNV, cMND, SDT, maChucVu, bacTho, ngaySinh, ngayVaoLam, trinhDoHocVan,soNamKinhNghiem,trangThai));
	}
	
	public void loadDataToText(NhanVien nhanVien) {
		txtHoVaTenNV.setText(nhanVien.getTenNhanVien());
		txtCMNDNV.setText(nhanVien.getCmnd());
		txtNgaySinhNV.setText(nhanVien.getNgaySinh()+"");
		txtSDTNV.setText(nhanVien.getSdt());
		txtBacNV.setText(nhanVien.getBacTho());
		cbbChucVu.setSelectedItem(nhanVien.getMaChucVu());
		txtNgayVaoLamNV.setText(nhanVien.getNgayVaoLam()+"");
		txtTrinhDoHocVanNV.setText(nhanVien.getTrinhDoHocVan()+"");
		txtNamKinhNghiemNV.setText(nhanVien.getSoNamKinhNghiem()+"");

		if (!nhanVien.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);

	}

	public void loadDatatoTable() throws Exception {
		tblThongTinNV.setModel(tblModelNV = new DefaultTableModel(col, 0));

		for (NhanVien nhanVien : nvDAO.getalltbNhanVien()) {
			String trangThai = "Đang làm";

			if (nhanVien.isTrangThai())
				trangThai = "Nghỉ việc";

			Object[] obj = { nhanVien.getTenNhanVien(), nhanVien.getCmnd(), nhanVien.getNgaySinh(), nhanVien.getSdt(), nhanVien.getMaChucVu(),
					nhanVien.getBacTho(), nhanVien.getNgayVaoLam(), nhanVien.getTrinhDoHocVan(), nhanVien.getSoNamKinhNghiem(), trangThai };
			tblModelNV.addRow(obj);
		}
		tblThongTinNV.repaint();
	}

	private void loadCVNhanVien() throws SQLException {
		ChucVuNhanVien_DAO chucVuNhanVien_DAO = new ChucVuNhanVien_DAO();
		cbbChucVu.removeAllItems();
		for(ChucVuNhanVien cnnv : chucVuNhanVien_DAO.getAllCVNhanVien()) {
			cbbChucVu.addItem(cnnv.getMaKyTu());
		}
	}
	private boolean kiemTraRong() {
		if(txtHoVaTenNV.getText().trim().length() == 0 ||
		   txtCMNDNV.getText().trim().length() == 0 || 
		   txtNgaySinhNV.getText().trim().length() == 0 || 
		   txtSDTNV.getText().trim().length() == 0 || 
		   txtBacNV.getText().trim().length() == 0 || 
		   txtNgayVaoLamNV.getText().trim().length() == 0 || 
		   txtTrinhDoHocVanNV.getText().trim().length() == 0 || 
		   txtNamKinhNghiemNV.getText().trim().length() == 0 || 
		   cbbChucVu.getSelectedItem().toString().trim().length() == 0
		   )
		{
			return false;
		}
		return true;
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThemNV))
		{
			try {
				txtHoVaTenNV.setText(null);
				txtCMNDNV.setText(null);
				txtNgaySinhNV.setText(null);
				txtSDTNV.setText(null);
				txtBacNV.setText(null);
				txtNgayVaoLamNV.setText(null);
				txtTrinhDoHocVanNV.setText(null);
				txtNamKinhNghiemNV.setText(null);
	
	
				chbTrangThai.setSelected(false);
				btnSuaNV.setEnabled(false);
				btnXoaNV.setEnabled(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		}
		if (obj.equals(btnXoaTrangNV))
		{
			try {
				txtHoVaTenNV.setText(null);
				txtCMNDNV.setText(null);
				txtNgaySinhNV.setText(null);
				txtSDTNV.setText(null);
				txtBacNV.setText(null);
				txtNgayVaoLamNV.setText(null);
				txtTrinhDoHocVanNV.setText(null);
				txtNamKinhNghiemNV.setText(null);
				chbTrangThai.setSelected(false);
				
				btnThemNV.setEnabled(true);
				btnSuaNV.setEnabled(false);
				btnXoaNV.setEnabled(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		}
		if (obj.equals(btnLuuNV)) {
			NhanVien_DAO nvDao = new NhanVien_DAO();
			if(kiemTraRong()) {
				NhanVien nvm = taoNhanVien();
				String nSinhTemp = nvm.getNgaySinh()+"";
				String nSinh = LocalDate.parse(nSinhTemp, formatter)+"";
				String nVaoLamTemp = nvm.getNgayVaoLam()+"";
				String nVaoLam = LocalDate.parse(nVaoLamTemp, formatter)+"";
				try {
					nvDao.themNV(nvm.getTenNhanVien(),nvm.getCmnd(),nvm.getSdt(),nvm.getMaChucVu(),nvm.getBacTho(),nSinh,nVaoLam,nvm.getTrinhDoHocVan(),nvm.getSoNamKinhNghiem(),nvm.isTrangThai());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			try {
				loadDatatoTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			else
			{
		        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		        JOptionPane.showMessageDialog(frame,
		                "Bạn không được để rỗng",
		                "Thêm Thất Bại",
		                JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	
}
