package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Entity.KhachHang;
import dao.KhachHangDAO;
import model.KhachHangModel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTable;

public class FrmKhachHang extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtKh;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTextField txtNS;
	private JTable table;
	private KhachHangModel dataModel;
	private JScrollPane scroll;
	private JComboBox cboGT;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhachHang frame = new FrmKhachHang();
					frame.setVisible(true);
					System.out.println("hi");
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
	public FrmKhachHang() throws ClassNotFoundException, SQLException {
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		setResizable(true);
		setBounds(-5, -26, 1372, 710);
		
		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBackground(Color.WHITE);
		pnKhachHang.setBounds(0, 0, 1186, 654);
		getContentPane().add(pnKhachHang);
		pnKhachHang.setLayout(null);
		
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 1360, 60);
		pnKhachHang.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_1.setBounds(0, 60, 1360, 243);
		pnKhachHang.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 120, 50);
		panel_1.add(lblNewLabel);
		txtKh = new JTextField();
		txtKh.setText("KH021");
		lblNewLabel.setLabelFor(txtKh);
		txtKh.setBounds(132, 0, 388, 50);
		panel_1.add(txtKh);
		txtKh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CMND: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 60, 120, 50);
		panel_1.add(lblNewLabel_2);
		
		txtCMND = new JTextField();
		txtCMND.setText("123123123");
		lblNewLabel_2.setLabelFor(txtCMND);
		txtCMND.setColumns(10);
		txtCMND.setBounds(132, 60, 388, 50);
		panel_1.add(txtCMND);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 120, 120, 50);
		panel_1.add(lblNewLabel_3);
		
		txtSDT = new JTextField();
		txtSDT.setText("0913121213");
		lblNewLabel_3.setLabelFor(txtSDT);
		txtSDT.setColumns(10);
		txtSDT.setBounds(132, 120, 388, 50);
		panel_1.add(txtSDT);
		
		JButton btnNewButton = new JButton("Thêm khách hàng");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String gt = cboGT.getSelectedIndex()==0?"Nam":"Nữ";
				KhachHang  kh = new KhachHang(txtKh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt);
				System.out.println(kh);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(132, 180, 170, 50);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa khách hàng");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(382, 180, 138, 50);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Xóa khách hàng");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(620, 180, 138, 50);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa Trắng");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_2.setBounds(869, 180, 138, 50);
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_4 = new JButton("Thay ảnh đại diện");
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_4.setBounds(1128, 180, 159, 50);
		panel_1.add(btnNewButton_1_4);
		
		txtTen = new JTextField();
		txtTen.setText("Dat");
		txtTen.setColumns(10);
		txtTen.setBounds(640, 3, 388, 50);
		panel_1.add(txtTen);
		
		txtNS = new JTextField();
		txtNS.setText("2001-10-10");
		txtNS.setColumns(10);
		txtNS.setBounds(640, 60, 388, 50);
		panel_1.add(txtNS);
		
		cboGT = new JComboBox();
		cboGT.addItem("Nam");
		cboGT.addItem("Nữ");
		cboGT.setBorder(new EmptyBorder(2, 2, 2, 2));
		cboGT.setBounds(640, 120, 388, 50);
		panel_1.add(cboGT);
		
		JLabel lblNewLabel_3_2 = new JLabel("Giới Tính: ");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(521, 120, 120, 50);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày Sinh: ");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(521, 60, 120, 50);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblHVTn = new JLabel("Họ và tên : ");
		lblHVTn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHVTn.setBounds(521, 0, 120, 50);
		panel_1.add(lblHVTn);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 301, 1360, 380);
		pnKhachHang.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		KhachHangDAO khDAO = new KhachHangDAO();
		panel_2.add(scroll = new JScrollPane(table = new JTable(dataModel = new KhachHangModel(khDAO.getAll()))));
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		
		
		
		

	}
}
