package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmQLNhanVien extends JInternalFrame {
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoVaTenNV;
	private JTextField txtNgaySinhNV;
	private JTextField txtCMNDNV;
	private JTextField txtSDTNV;
	private JTextField txtTrangThaiNV;
	private JTextField txtNamKinhNghiemNV;
	private JTextField txtBacNV;
	private JTextField txtTrinhDoHocVanNV;
	private JTextField txtNgayVaoLamNV;
	private JTable tblDSNV;
	private JTextField txtmaChucVuNV;
	private JTextField txtmaCuaHangNV;
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
		lblCMND.setBounds(5, 85, 120, 24);
		pnControlTrai.add(lblCMND);
		
		txtMaNV = new JTextField();
		txtMaNV.setBackground(Color.WHITE);
		txtMaNV.setBounds(170, 5, 484, 24);
		pnControlTrai.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(5, 5, 120, 24);
		pnControlTrai.add(lblMaNV);
		
		txtHoVaTenNV = new JTextField();
		txtHoVaTenNV.setBackground(Color.WHITE);
		txtHoVaTenNV.setBounds(170, 45, 484, 24);
		pnControlTrai.add(txtHoVaTenNV);
		txtHoVaTenNV.setColumns(10);
		
		JLabel lblHoTenNV = new JLabel("Họ và tên");
		lblHoTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoTenNV.setBounds(5, 45, 120, 24);
		pnControlTrai.add(lblHoTenNV);
		
		txtNgaySinhNV = new JTextField();
		txtNgaySinhNV.setBackground(Color.WHITE);
		txtNgaySinhNV.setBounds(170, 125, 484, 24);
		txtNgaySinhNV.setColumns(10);
		pnControlTrai.add(txtNgaySinhNV);
		
		JLabel lblNgaySinhNV = new JLabel("Ngày sinh");
		lblNgaySinhNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinhNV.setBounds(5, 125, 120, 24);
		pnControlTrai.add(lblNgaySinhNV);
		
		txtCMNDNV = new JTextField();
		txtCMNDNV.setBackground(Color.WHITE);
		txtCMNDNV.setBounds(170, 85, 484, 24);
		txtCMNDNV.setColumns(10);
		pnControlTrai.add(txtCMNDNV);
		
		JLabel lblSDTNV = new JLabel("SĐT");
		lblSDTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDTNV.setBounds(5, 165, 120, 24);
		pnControlTrai.add(lblSDTNV);
		
		txtSDTNV = new JTextField();
		txtSDTNV.setBackground(Color.WHITE);
		txtSDTNV.setBounds(170, 165, 484, 24);
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
		lbmaChucVuNV.setBounds(5, 205, 120, 24);
		pnControlTrai.add(lbmaChucVuNV);
		
		txtmaChucVuNV = new JTextField();
		txtmaChucVuNV.setColumns(10);
		txtmaChucVuNV.setBackground(Color.WHITE);
		txtmaChucVuNV.setBounds(170, 205, 484, 24);
		pnControlTrai.add(txtmaChucVuNV);
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
		
		JPanel pnTable = new JPanel();
		pnTable.setBackground(new Color(240, 255, 255));
		pnTable.setBounds(10, 298, 1340, 317);
		pnContext.add(pnTable);
		pnTable.setLayout(null);
		
		tblDSNV = new JTable();
		tblDSNV.setBackground(new Color(238, 130, 238));
		tblDSNV.setBounds(10, 344, 1320, -331);
		pnTable.add(tblDSNV);
		
		JButton btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemNV.setBackground(new Color(255, 192, 203));
		btnThemNV.setBounds(10, 249, 240, 39);
		pnContext.add(btnThemNV);
		
		JButton btnSuaNV = new JButton("Sửa nhân viên");
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuaNV.setBackground(new Color(255, 192, 203));
		btnSuaNV.setBounds(367, 249, 240, 39);
		pnContext.add(btnSuaNV);
		
		
		JButton btnXoaNV = new JButton("Xoá nhân viên");
		btnXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaNV.setBackground(new Color(255, 192, 203));
		btnXoaNV.setBounds(741, 249, 240, 39);
		pnContext.add(btnXoaNV);
		
		JButton btnXoaTrangNV = new JButton("Xoá trắng");
		btnXoaTrangNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaTrangNV.setBackground(new Color(255, 192, 203));
		btnXoaTrangNV.setBounds(1110, 249, 240, 39);
		pnContext.add(btnXoaTrangNV);
	}

}
