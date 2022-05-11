package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.HangXe_DAO;
import DAO.KhachHang_DAO;
import Model.KhachHangModel;

public class FrmHangXe extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHangXe frame= new FrmHangXe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField txtTen;
	private JTextField txtMaHX;
	private Object table;
	private JScrollPane scroll;
	private HangXe_DAO hxDAO;
	private DefaultTableModel dataModel;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public FrmHangXe() {
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		setResizable(true);
		// set size
		setBounds(-5, -26, 1600, 780);

		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBackground(Color.WHITE);
		pnKhachHang.setBounds(0, 0, 1186, 654);
		getContentPane().add(pnKhachHang);
		pnKhachHang.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 1588, 60);
		pnKhachHang.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý hãng xe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_1.setBounds(0, 60, 1588, 136);
		pnKhachHang.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã hãng xe: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(133, 0, 120, 50);
		panel_1.add(lblNewLabel);
		txtMaHX = new JTextField();
		lblNewLabel.setLabelFor(txtMaHX);
		txtMaHX.setBounds(255, 0, 388, 50);
		panel_1.add(txtMaHX);
		txtMaHX.setColumns(10);
		
		JButton btnThem = new JButton("Thêm hãng xe");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(187, 60, 170, 50);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa hãng xe");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		btnSua.setBounds(470, 60, 138, 50);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa hãng xe");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(723, 60, 138, 50);
		panel_1.add(btnXoa);
		
		JButton btnXT = new JButton("Xóa Trắng");
		btnXT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXT.setBounds(975, 60, 138, 50);
		panel_1.add(btnXT);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(1067, 0, 388, 50);
		panel_1.add(txtTen);
		
		JLabel lblHVTn = new JLabel("Tên hãng xe: ");
		lblHVTn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHVTn.setBounds(945, 0, 120, 50);
		panel_1.add(lblHVTn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(166, 196, 1274, 555);
		pnKhachHang.add(panel_2);
		panel_2.setLayout(null);
		hxDAO = new HangXe_DAO();
		
		
		table = new JTable();
		JTableHeader header = ((JTable) table).getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD , 26));
		String[] tieude = {"Mã hãng xe","Tên hãng xe"};
		panel_2.add(scroll = new JScrollPane(table_1 = new JTable(dataModel = new DefaultTableModel(tieude, 0))));
		scroll.setBounds(0, 0, 1558, 555);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnXoa.setEnabled(true);
				int rowSelect = table_1.getSelectedRow();
				String maHX = (String) table_1.getValueAt(rowSelect, 0);
				String Ten = (String) table_1.getValueAt(rowSelect, 1);
				
				txtMaHX.setText(maHX);
				txtTen.setText(Ten);
				
			}
		});
		table_1.setRowHeight(30);
		scroll.setFont(new Font("Tahoma", Font.BOLD, 15));
		JTableHeader tableHeader = table_1.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		
	}
}
