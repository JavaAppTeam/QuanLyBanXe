package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.SystemColor;

public class FrmHoaDon extends JInternalFrame {
	private JTable table;
	private DefaultTableModel dataModel;
	private JScrollPane scroll;

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
	 */
	public FrmHoaDon() {
		setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().setBackground(Color.PINK);
		getContentPane().setForeground(new Color(0, 0, 0));
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 10, 1340, 264);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã số nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(695, 130, 117, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(695, 72, 106, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(685, 28, 117, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên hóa đơn: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(138, 77, 96, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(147, 33, 87, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã xe:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(182, 128, 52, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã cửa hàng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(716, 179, 96, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		JTextPane txtTenXe = new JTextPane();
		txtTenXe.setBounds(246, 28, 350, 28);
		panel.add(txtTenXe);
		
		JTextPane txtHang = new JTextPane();
		txtHang.setBounds(246, 77, 350, 28);
		panel.add(txtHang);
		
		JTextPane txtLoai = new JTextPane();
		txtLoai.setBounds(821, 28, 350, 28);
		panel.add(txtLoai);
		
		JTextPane txtMucTieuThu = new JTextPane();
		txtMucTieuThu.setBounds(821, 77, 350, 28);
		panel.add(txtMucTieuThu);
		
		JTextPane txtDungTich = new JTextPane();
		txtDungTich.setBounds(820, 126, 350, 28);
		panel.add(txtDungTich);
		
		JTextPane txtSoLuong = new JTextPane();
		txtSoLuong.setBounds(818, 179, 353, 28);
		panel.add(txtSoLuong);
		
		JTextPane txtGiaTien = new JTextPane();
		txtGiaTien.setBounds(246, 128, 350, 28);
		panel.add(txtGiaTien);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Đơn giá:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(170, 179, 64, 28);
		panel.add(lblNewLabel_1_1_1_2);
		
		JTextPane txtGiaTien_1 = new JTextPane();
		txtGiaTien_1.setBounds(246, 179, 350, 28);
		panel.add(txtGiaTien_1);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Thuế:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(182, 226, 52, 26);
		panel.add(lblNewLabel_1_1_1_3);
		
		JTextPane txtGiaTien_2 = new JTextPane();
		txtGiaTien_2.setBounds(246, 226, 925, 23);
		panel.add(txtGiaTien_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 378, 1340, 285);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		String[] tieuDe = { "Mã HD", "Tên HD", "Mã Xe", "Đơn Giá", "Thuế", "Ngày lập hóa đơn", "Mã khách hàng", "Mã số nhân viên", "Mã cửa hàng"};
		panel_1.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN BÁN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(603, 338, 304, 30);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setForeground(SystemColor.activeCaption);
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.setBounds(256, 288, 927, 40);
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("THÊM");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SỬA");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("XÓA");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LƯU");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("XÓA TRẮNG");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_4);
		setResizable(true);
		setBounds(-5, -26, 1372, 710);

	}
}
