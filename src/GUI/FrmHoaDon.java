package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JCalendar;

import DAO.HoaDon_DAO;
import Entity.HoaDon;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class FrmHoaDon extends JFrame {
	private JTable table_1;
	private DefaultTableModel dataModel;
	private JScrollPane scroll;
	private JTextField textField;
	private FrmHoaDon_ThemHoaDon frmHD_ThemHD;
	private HoaDon_DAO hdDao = new HoaDon_DAO();
	JTextPane txtMaHD, txtMaNV, txtMaCH, txtMaKH;
	JDateChooser dtNgayLap;
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
	 * @throws SQLException 
	 */
	public FrmHoaDon() throws SQLException, PropertyVetoException {
		setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().setBackground(Color.PINK);
		getContentPane().setForeground(new Color(0, 0, 0));
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		frmHD_ThemHD = new FrmHoaDon_ThemHoaDon();
		frmHD_ThemHD.setBounds(5, 26, 1139, 510);
		getContentPane().add(frmHD_ThemHD);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBorder(new TitledBorder(null, "Thông tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 34, 1340, 178);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(130, 113, 96, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(700, 55, 106, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(109, 76, 117, 23);
		JCalendar calendar = new JCalendar();
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(147, 33, 87, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã cửa hàng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(710, 95, 96, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtMaHD = new JTextPane();
		txtMaHD.setBounds(242, 30, 350, 28);
		panel.add(txtMaHD);
		
		dtNgayLap = new JDateChooser();
		dtNgayLap.setBounds(240, 73, 352, 30);
		panel.add(dtNgayLap);
		
		dtNgayLap = new JDateChooser();
		dtNgayLap.setBounds(240, 73, 352, 30);
		panel.add(dtNgayLap);
		
		txtMaNV = new JTextPane();
		txtMaNV.setBounds(242, 118, 350, 28);
		panel.add(txtMaNV);
		
		txtMaKH = new JTextPane();
		txtMaKH.setBounds(818, 55, 350, 28);
		panel.add(txtMaKH);
		
		txtMaCH = new JTextPane();
		txtMaCH.setBounds(817, 92, 350, 28);
		panel.add(txtMaCH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 378, 1340, 285);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		String[] tieuDe = { "Mã HD","Ngày lập hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã cửa hàng"};
		panel_1.add(scroll = new JScrollPane(table_1 = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		table_1.setRowHeight(30);
		JTableHeader tableHeader = table_1.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowSelect = table_1.getSelectedRow();
				String maHD = (String) table_1.getValueAt(rowSelect, 0);
				Date ngayLap = (Date) table_1.getValueAt(rowSelect, 1);
				String maKH = (String) table_1.getValueAt(rowSelect, 2);
				String maNV = (String) table_1.getValueAt(rowSelect, 3);
				String maCH = (String) table_1.getValueAt(rowSelect, 4);
				txtMaHD.setText(maHD);
				dtNgayLap.setDate(ngayLap);
				txtMaCH.setText(maCH);
				txtMaKH.setText(maKH);
				txtMaNV.setText(maNV);
			}
		});
		
		// can giua column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN BÁN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(556, 316, 306, 49);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setForeground(SystemColor.activeCaption);
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.setBounds(242, 247, 934, 40);
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHD_ThemHD.setVisible(true);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnXoa);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnLuu);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnXoaTrang);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(10, 328, 385, 40);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnThem_1 = new JButton("Tìm Kiếm");
		btnThem_1.setBounds(259, 4, 117, 29);
		panel_3.add(btnThem_1);
		btnThem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setBounds(10, 5, 239, 28);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(990, 328, 360, 40);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Cửa hàng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(56, 10, 78, 19);
		panel_4.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 6, 210, 29);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("|");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(46, 2, 10, 33);
		panel_4.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "alo");
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setIcon(new ImageIcon(FrmHoaDon.class.getResource("/image/icons8_bill_32.png")));
		btnNewButton.setBounds(0, 0, 46, 40);
		panel_4.add(btnNewButton);
		setResizable(true);
		setBounds(-5, -26, 1372, 710);
		loadCTHD();
	}

	private void loadCTHD() throws SQLException {
		// TODO Auto-generated method stub
		int tblRow = table_1.getRowCount();
		for (int i = tblRow - 1; i >= 0; i--) {
			dataModel.removeRow(i);
		}
		for (HoaDon hd : hdDao.getAllHD()) {
			dataModel.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLap(), hd.getMaKH(),hd.getMaNV(),hd.getMaCH()});
		}
	}
	
//	private void loadRowTableToText(String rowSelect) throws SQLException {
//		HoaDon hd = (HoaDon) hdDao.getAllHDTotext(rowSelect);
//			txtMaHD.setText(hd.getMaHoaDon());
//			dtNgayLap.setDate(hd.getNgayLap());
//			cbbmaCuaHang.setSelectedItem(hd.getMaCH());
//			cbbMaKH.setSelectedItem(hd.getMaKH());
//			txtSoLuong.setText((int)hd.getSoluong()+"");
//		}
}
