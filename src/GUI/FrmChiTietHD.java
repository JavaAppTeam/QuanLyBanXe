package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.Xe_DAO;
import Entity.HoaDon;
import Entity.Xe;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmChiTietHD extends JInternalFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblMaHD, lblTenKH,lblTenNV,lblTongThue;
	private DefaultTableModel dataModel;
	private Locale localeVN = new Locale("vi", "VN");
	private NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	private boolean bStatus = false;
	private JLabel lblTong,lblNgayLap;

	/**
	 * Launch the application.
	 */
	public interface FrmChiTietHDResponse{
		void getResponse(boolean bStatusPnCTHD);
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public FrmChiTietHD(FrmChiTietHDResponse frmChiTietHDResponse, String maHDFrmHD, String maKHFrmHD, String maNVToCTHD) throws ClassNotFoundException, SQLException {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setForeground(SystemColor.activeCaption);
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 10));
		setBounds(100, 100, 619, 608);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN LẺ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(188, 71, 236, 58);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HonDa BigWing");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 9, 146, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MST: 1268 797979");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(73, 35, 121, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_3.setBounds(395, 37, 54, 20);
		getContentPane().add(lblNewLabel_3);
		
		lblNgayLap = new JLabel("2425");
		lblNgayLap.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNgayLap.setBounds(459, 37, 121, 24);
		getContentPane().add(lblNgayLap);
		
		JPanel panel = new JPanel();
		panel.setBounds(13, 152, 582, 235);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		String[] tieuDe = { "STT","Tên Xe","Số lượng","Đơn giá","Thành Tiền"};
		table.setRowHeight(30);
		panel.add(scrollPane = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		table.setRowHeight(25);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 14));
		
		JLabel lblNewLabel_5 = new JLabel("Nhân Viên");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(403, 471, 78, 26);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Người Mua");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(100, 471, 98, 26);
		getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("(Ký ghi rõ họ tên)");
		lblNewLabel_6.setBounds(399, 495, 98, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("(Ký ghi rõ họ tên)");
		lblNewLabel_6_1.setBounds(96, 495, 102, 13);
		getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hotline: 0909 829 829");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(395, 9, 165, 26);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_7 = new JLabel("Mã HD:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(96, 122, 54, 20);
		getContentPane().add(lblNewLabel_7);
		
		lblMaHD = new JLabel("MaHD");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHD.setBounds(158, 122, 78, 20);
		getContentPane().add(lblMaHD);
		
		JLabel lblNewLabel_7_1 = new JLabel("Khách Hàng:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(311, 122, 96, 20);
		getContentPane().add(lblNewLabel_7_1);
		
		lblTenKH = new JLabel("Tên KH");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenKH.setBounds(408, 122, 187, 20);
		getContentPane().add(lblTenKH);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(FrmChiTietHD.class.getResource("/image/logo45.png")));
		lblNewLabel_9.setBounds(10, 9, 54, 51);
		getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChiTietHDResponse.getResponse(true);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(FrmChiTietHD.class.getResource("/image/cross.png")));
		btnNewButton.setBounds(577, 0, 30, 26);
		getContentPane().add(btnNewButton);
		
		lblTenNV = new JLabel("New label");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenNV.setBounds(359, 530, 170, 20);
		getContentPane().add(lblTenNV);
		lblTenNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNV.setVerticalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(13, 430, 582, 42);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5_2 = new JLabel("TỔNG TIỀN:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(321, 10, 96, 26);
		panel_1.add(lblNewLabel_5_2);
		
		lblTong = new JLabel("Tien");
		lblTong.setForeground(Color.RED);
		lblTong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTong.setBounds(431, 10, 141, 26);
		panel_1.add(lblTong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(13, 387, 582, 42);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblThue = new JLabel("THUẾ:");
		lblThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThue.setBounds(364, 10, 48, 26);
		panel_2.add(lblThue);
		
		lblTongThue = new JLabel("0 ₫");
		lblTongThue.setForeground(Color.BLACK);
		lblTongThue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongThue.setBounds(431, 10, 141, 26);
		panel_2.add(lblTongThue);
		
		loadCTHD(maHDFrmHD, maKHFrmHD,maNVToCTHD);
		loadTongTien();
		loadNgayLapHD();

	}

	private void loadNgayLapHD() {
		// TODO Auto-generated method stub
		HoaDon_DAO hdDao = new HoaDon_DAO();
		String maHD = lblMaHD.getText();
		Date dateHD = hdDao.getDayFromHD(maHD.trim()); 
		lblNgayLap.setText(dateHD+"");
	}

	private void loadTongTien() {
		// TODO Auto-generated method stub
		int iTong = 0;
		int iTongThue = 0;
		int row = table.getRowCount();
		for(int i = 0; i < row; i++ ) {
			int iSL = (int) table.getValueAt(i, 2);
			int iDonGia = (int) table.getValueAt(i, 3);
			iTongThue += (int)(iDonGia * iSL)*0.15;
			iTong += iSL*iDonGia;
		}
		lblTongThue.setText(currencyVN.format(iTongThue) + "");
		lblTong.setText(currencyVN.format(iTong + iTongThue) + "");
	}

	private void loadCTHD(String maHDFrmHD, String maKHFrmHD, String maNVToCTHD) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Xe_DAO xe = new Xe_DAO();
		KhachHang_DAO  khDAO = new KhachHang_DAO();
		NhanVien_DAO nvDAO = new NhanVien_DAO();
		List<Xe> dsXe = new ArrayList<>();
		dsXe = xe.getListXeOnMaHD(maHDFrmHD);
		int tblRow = table.getRowCount();
		lblMaHD.setText(maHDFrmHD);
		String tenKH = khDAO.getTenToMaKH(maKHFrmHD);
		String tenNV = nvDAO.getTenNVFormMaNV(maNVToCTHD);
		lblTenKH.setText(tenKH);
		lblTenNV.setText(tenNV);
		for (int i = tblRow - 1; i >= 0; i--) {
			dataModel.removeRow(i);
		}
		//dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
		for(Xe x : dsXe) {
			dataModel.addRow(new Object[] {x.getStt(),x.getTenXe(),x.getSoluongMua(),(int)x.getDonGia(),currencyVN.format(x.getSoluongMua()*x.getDonGia())});
		}
	}
}
