package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FrmCuaHang extends JInternalFrame {
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
					FrmCuaHang frame = new FrmCuaHang();
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
	public FrmCuaHang() {
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
		panel.setBounds(10, 10, 1340, 217);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Tỉnh TP:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(696, 35, 64, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã cửa hàng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(164, 33, 87, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quận Huyện:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(164, 88, 87, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JTextPane txtTenXe = new JTextPane();
		txtTenXe.setBounds(275, 28, 350, 28);
		panel.add(txtTenXe);
		
		JTextPane txtHang = new JTextPane();
		txtHang.setBounds(772, 33, 350, 28);
		panel.add(txtHang);
		
		JTextPane txtGiaTien = new JTextPane();
		txtGiaTien.setBounds(275, 86, 350, 28);
		panel.add(txtGiaTien);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Phường Xã:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(671, 88, 89, 26);
		panel.add(lblNewLabel_1_1_1_2);
		
		JTextPane txtGiaTien_1 = new JTextPane();
		txtGiaTien_1.setBounds(772, 88, 350, 28);
		panel.add(txtGiaTien_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hotline:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(201, 146, 64, 26);
		panel.add(lblNewLabel_1_1_1_1);
		
		JTextPane txtGiaTien_2 = new JTextPane();
		txtGiaTien_2.setBounds(275, 146, 847, 28);
		panel.add(txtGiaTien_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 378, 1340, 285);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD , 26));
		String[] tieuDe = { "Mã Cửa Hàng", "Phường Xã", "Quận Huyện", "Tỉnh TP"};
		panel_1.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH CỬA HÀNG BÁN XE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(536, 322, 346, 30);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setForeground(SystemColor.activeCaption);
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.setBounds(256, 255, 880, 40);
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

		
		loadCuaHang();
	}

	private void loadCuaHang() {
		// TODO Auto-generated method stub
		
	}
}
