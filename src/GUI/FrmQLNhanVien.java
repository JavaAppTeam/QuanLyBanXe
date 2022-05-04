package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;

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

import DAO.NhanVien_DAO;
import Entity.NhanVien;
import javax.swing.JCheckBox;

public class FrmQLNhanVien extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtHoVaTenNV;
	private JTextField txtNgaySinhNV;
	private JTextField txtCMNDNV;
	private JTextField txtSDTNV;
	private JTextField txtTrangThaiNV;
	private JTextField txtNamKinhNghiemNV;
	private JTextField txtBacNV;
	private JTextField txtTrinhDoHocVanNV;
	private JTextField txtNgayVaoLamNV;
	private JTextField txtmaChucVuNV;
	private JTextField txtmaCuaHangNV;
	private DefaultTableModel tblModelNV;
	private JTable tblThongTinNV;
	private JCheckBox chbTrangThai;
	private JButton btnLuuNV,btnXoaTrangNV,btnXoaNV,btnSuaNV,btnThemNV;
	private NhanVien_DAO nvDAO = new NhanVien_DAO();
	String[] col = { "Mã nhân viên", "Họ và tên", "CMND", "Ngày sinh", "SDT", "Mã chức vụ", "Ngày vào làm",
			"Trình độ học vấn", "Bậc","Năm kinh nghiệm","Trạng thái","Mã cửa hàng" };
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
	 */
	public FrmQLNhanVien() {
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
		pnContext.setBounds(0, 56, 1360, 625);
		pnContext.setBackground(new Color(255, 192, 203));
		getContentPane().add(pnContext);
		
		JPanel pnControlTrai = new JPanel();
		pnControlTrai.setBackground(new Color(255, 192, 203));
		pnControlTrai.setBounds(0, 0, 668, 239);
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
		pnControlPhai.setBounds(669, 0, 681, 239);
		pnControlPhai.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnControlPhai.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnControlPhai.setLayout(null);
		pnContext.setLayout(null);
		pnContext.add(pnControlTrai);
		
		JLabel lbmaChucVuNV = new JLabel("Mã chức vụ");
		lbmaChucVuNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbmaChucVuNV.setBounds(10, 170, 120, 24);
		pnControlTrai.add(lbmaChucVuNV);
		
		txtmaChucVuNV = new JTextField();
		txtmaChucVuNV.setColumns(10);
		txtmaChucVuNV.setBackground(Color.WHITE);
		txtmaChucVuNV.setBounds(175, 170, 484, 24);
		pnControlTrai.add(txtmaChucVuNV);
		
		lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrngThi.setBounds(10, 204, 120, 24);
		pnControlTrai.add(lblTrngThi);
		
		chbTrangThai = new JCheckBox("Làm");
		chbTrangThai.setBackground(new Color(255, 192, 203));
		chbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chbTrangThai.setBounds(175, 200, 73, 31);
		pnControlTrai.add(chbTrangThai);
		pnContext.add(pnControlPhai);
		
		JLabel lblNgayVaoLamNV = new JLabel("Ngày vào làm");
		lblNgayVaoLamNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayVaoLamNV.setBounds(16, 5, 165, 24);
		pnControlPhai.add(lblNgayVaoLamNV);
		
		JLabel lblTrinhDoHocVanNV = new JLabel("Trình độ học vấn");
		lblTrinhDoHocVanNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrinhDoHocVanNV.setBounds(16, 45, 165, 24);
		pnControlPhai.add(lblTrinhDoHocVanNV);
		
		JLabel lblBacNV = new JLabel("Bậc");
		lblBacNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBacNV.setBounds(16, 85, 165, 24);
		pnControlPhai.add(lblBacNV);
		
		JLabel lblNamKinhNgiemNV = new JLabel("Năm kinh nghiệm");
		lblNamKinhNgiemNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNamKinhNgiemNV.setBounds(16, 125, 165, 24);
		pnControlPhai.add(lblNamKinhNgiemNV);
		
		JLabel lblTrangThaiNV = new JLabel("Trạng thái");
		lblTrangThaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrangThaiNV.setBounds(16, 165, 165, 24);
		pnControlPhai.add(lblTrangThaiNV);
		
		txtTrangThaiNV = new JTextField();
		txtTrangThaiNV.setBackground(Color.WHITE);
		txtTrangThaiNV.setColumns(10);
		txtTrangThaiNV.setBounds(181, 165, 484, 24);
		pnControlPhai.add(txtTrangThaiNV);
		
		txtNamKinhNghiemNV = new JTextField();
		txtNamKinhNghiemNV.setBackground(Color.WHITE);
		txtNamKinhNghiemNV.setColumns(10);
		txtNamKinhNghiemNV.setBounds(181, 125, 484, 24);
		pnControlPhai.add(txtNamKinhNghiemNV);
		
		txtBacNV = new JTextField();
		txtBacNV.setBackground(Color.WHITE);
		txtBacNV.setColumns(10);
		txtBacNV.setBounds(181, 85, 484, 24);
		pnControlPhai.add(txtBacNV);
		
		txtTrinhDoHocVanNV = new JTextField();
		txtTrinhDoHocVanNV.setBackground(Color.WHITE);
		txtTrinhDoHocVanNV.setColumns(10);
		txtTrinhDoHocVanNV.setBounds(181, 45, 484, 24);
		pnControlPhai.add(txtTrinhDoHocVanNV);
		
		txtNgayVaoLamNV = new JTextField();
		txtNgayVaoLamNV.setBackground(Color.WHITE);
		txtNgayVaoLamNV.setColumns(10);
		txtNgayVaoLamNV.setBounds(181, 5, 484, 24);
		pnControlPhai.add(txtNgayVaoLamNV);
		
		JLabel lblmaCuaHangNV = new JLabel("Mã cửa hàng");
		lblmaCuaHangNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblmaCuaHangNV.setBounds(16, 205, 165, 24);
		pnControlPhai.add(lblmaCuaHangNV);
		
		txtmaCuaHangNV = new JTextField();
		txtmaCuaHangNV.setColumns(10);
		txtmaCuaHangNV.setBackground(Color.WHITE);
		txtmaCuaHangNV.setBounds(181, 205, 484, 24);
		pnControlPhai.add(txtmaCuaHangNV);

		// =================================================
		// ====================== button
		
		btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemNV.setBackground(new Color(255, 192, 203));
		btnThemNV.setBounds(10, 249, 240, 39);
		pnContext.add(btnThemNV);
		
		btnSuaNV  = new JButton("Sửa nhân viên");
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuaNV.setBackground(new Color(255, 192, 203));
		btnSuaNV.setBounds(277, 249, 240, 39);
		pnContext.add(btnSuaNV);
		
		
		btnXoaNV = new JButton("Xoá nhân viên");
		btnXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaNV.setBackground(new Color(255, 192, 203));
		btnXoaNV.setBounds(562, 249, 240, 39);
		pnContext.add(btnXoaNV);
		
		btnXoaTrangNV = new JButton("Xoá trắng");
		btnXoaTrangNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaTrangNV.setBackground(new Color(255, 192, 203));
		btnXoaTrangNV.setBounds(839, 249, 240, 39);
		pnContext.add(btnXoaTrangNV);
		
		btnLuuNV = new JButton("Lưu");
		btnLuuNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuuNV.setBackground(new Color(255, 192, 203));
		btnLuuNV.setBounds(1110, 249, 240, 39);
		pnContext.add(btnLuuNV);
		
		// ==================== TABLE ==================
		JPanel pnTable = new JPanel();
		tblModelNV = new DefaultTableModel(col, 0);
		pnTable.setBounds(10, 375, 1336, 273);
		contentPane.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		tblThongTinNV = new JTable(tblModelNV);
		tblThongTinNV.setFillsViewportHeight(true);
		tblThongTinNV.setColumnSelectionAllowed(false);
		tblThongTinNV.setCellSelectionEnabled(true);
		tblThongTinNV.setRowHeight(25);
		tblThongTinNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblThongTinNV.setBackground(Color.WHITE);
		//pnTable.add(tblThongTinNV);
		JScrollPane scrollPane = new JScrollPane(tblThongTinNV);
		pnTable.add(scrollPane);
		
//		======= ACTION ===============

//		btnThemNV.addActionListener(this);
//		btnSuaNV.addActionListener(this);
//		btnXoaNV.addActionListener(this);
//		btnXoaTrangNV.addActionListener(this);
//		btnLuuNV.addActionListener(this);
//		tblThongTinNV.addMouseListener(this);

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
		String maChucVu = txtmaChucVuNV.getText();
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
		txtmaChucVuNV.setText(nhanVien.getMaChucVu());
		txtBacNV.setText(nhanVien.getBacTho());
		txtNgayVaoLamNV.setText(nhanVien.getNgayVaoLam()+"");
		txtTrinhDoHocVanNV.setText(nhanVien.getTrinhDoHocVan()+"");
		txtNamKinhNghiemNV.setText(nhanVien.getSoNamKinhNghiem()+"");

		if (nhanVien.isTrangThai())
			chbTrangThai.setSelected(true);
		else
			chbTrangThai.setSelected(false);

	}

	public void loadDatatoTable() throws Exception {
		tblThongTinNV.setModel(tblModelNV = new DefaultTableModel(col, 0));

		for (NhanVien nhanVien : nvDAO.getalltbNhanVien()) {
			String trangThai = "Còn bán";

			if (!nhanVien.isTrangThai())
				trangThai = "Nghỉ việc";

			Object[] obj = { nhanVien.getTenNhanVien(), nhanVien.getCmnd(), nhanVien.getNgaySinh(), nhanVien.getSdt(), nhanVien.getMaChucVu(),
					nhanVien.getBacTho(), nhanVien.getNgayVaoLam(), nhanVien.getTrinhDoHocVan(), nhanVien.getSoNamKinhNghiem(), trangThai };
			tblModelNV.addRow(obj);
		}
	}
}
