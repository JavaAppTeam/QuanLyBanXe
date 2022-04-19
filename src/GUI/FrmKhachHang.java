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
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	private DefaultTableModel dataModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhachHang frame = new FrmKhachHang();
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
	public FrmKhachHang() {
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
		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		textField.setBounds(132, 0, 388, 50);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CMND: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 60, 120, 50);
		panel_1.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		lblNewLabel_2.setLabelFor(textField_4);
		textField_4.setColumns(10);
		textField_4.setBounds(132, 60, 388, 50);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 120, 120, 50);
		panel_1.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		lblNewLabel_3.setLabelFor(textField_5);
		textField_5.setColumns(10);
		textField_5.setBounds(132, 120, 388, 50);
		panel_1.add(textField_5);
		
		JButton btnNewButton = new JButton("Thêm khách hàng");
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
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(640, 0, 388, 50);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(640, 60, 388, 50);
		panel_1.add(textField_10);
		
		JList list = new JList();
		list.setBorder(new EmptyBorder(2, 2, 2, 2));
		list.setBounds(640, 120, 388, 50);
		panel_1.add(list);
		
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
		

		table = new JTable();
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		String[] tieuDe = { "Mã khách hàng ", "CMND", "Số điện thoại", "Họ và tên", "Ngày sinh", "Giới tính"};
		JScrollPane scroll;
		panel_1.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		

	}
}
