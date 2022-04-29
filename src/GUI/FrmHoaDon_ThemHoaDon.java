package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DAO.ChiTietXeDAO;
import Entity.ChiTietXe;
import Entity.CuaHang;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class FrmHoaDon_ThemHoaDon extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	private JTextPane txtMaHD, txtDonGia, txtThue;
	private JDateChooser dtNgayLap;
	private FrmHoaDon_ThemHoaDon frmHD_ThemHD;
	private JComboBox cbbMaKH,cbbmaCuaHang,cbbMSNV,cbbMaXe;
	private JTable table;
	private DefaultTableModel dataModel;
	private JScrollPane scrollPane;
	private JLabel lblTenXe;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHoaDon_ThemHoaDon frame = new FrmHoaDon_ThemHoaDon();
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
	public FrmHoaDon_ThemHoaDon() throws PropertyVetoException, SQLException {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setTitle("Thêm Hóa Đơn");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		setBounds(5, 26, 1139, 510);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBorder(new TitledBorder(null, "Thông tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(UIManager.getColor("inactiveCaption"));
		panel.setBounds(10, 10, 1107, 231);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(496, 164, 96, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(469, 115, 130, 39);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 79, 406, 23);
		JCalendar calendar = new JCalendar();
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(48, 36, 80, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã cửa hàng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(496, 77, 96, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtMaHD = new JTextPane();
		txtMaHD.setBounds(143, 33, 273, 28);
		panel.add(txtMaHD);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã xe:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(538, 37, 42, 23);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Đơn giá:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(67, 116, 349, 29);
		panel.add(lblNewLabel_4_2);
		
		txtDonGia = new JTextPane();
		txtDonGia.setBounds(143, 119, 273, 28);
		panel.add(txtDonGia);
		
		JLabel lblNewLabel_4_3 = new JLabel("Thuế:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(84, 164, 49, 23);
		panel.add(lblNewLabel_4_3);
		
		txtThue = new JTextPane();
		txtThue.setBounds(143, 161, 273, 28);
		panel.add(txtThue);
		
		dtNgayLap = new JDateChooser();
		dtNgayLap.setBounds(141, 76, 275, 30);
		panel.add(dtNgayLap);
		
		cbbMaKH = new JComboBox();
		cbbMaKH.setBounds(621, 116, 336, 31);
		panel.add(cbbMaKH);
		
		cbbmaCuaHang = new JComboBox();
		cbbmaCuaHang.setBounds(621, 71, 336, 31);
		panel.add(cbbmaCuaHang);
		
		cbbMSNV = new JComboBox();
		cbbMSNV.setBounds(621, 157, 336, 31);
		panel.add(cbbMSNV);
		
		cbbMaXe = new JComboBox();
		cbbMaXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maXe = (String) cbbMaXe.getSelectedItem();
				try {
					loadTenXe(maXe);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cbbMaXe.setBounds(621, 31, 96, 28);
		panel.add(cbbMaXe);
		
		JSpinField spinField = new JSpinField();
		spinField.setBounds(727, 28, 47, 33);
		spinField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(spinField);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrmHoaDon_ThemHoaDon.class.getResource("/image/btnThem.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(967, 115, 42, 33);
		panel.add(btnNewButton_1);
		
		lblTenXe = new JLabel();
		lblTenXe.setBounds(784, 28, 173, 33);
		lblTenXe.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		lblTenXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenXe.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(lblTenXe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 294, 1107, 177);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		String[] tieuDe = { "Mã Xe","Tên Xe", "Số Khung", "Số máy", "Giá Tiền"};
		panel_1.add(scrollPane = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 14));
		
		JButton btnNewButton = new JButton("THÊM");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(307, 249, 141, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnLu = new JButton("LƯU");
		btnLu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLu.setBounds(486, 249, 141, 35);
		getContentPane().add(btnLu);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXa.setBounds(662, 249, 141, 35);
		getContentPane().add(btnXa);
		loadMaXe();
		loadMaCH();
		loadMaKH();
		loadMaNV();
	}

	private void loadMaNV() {
		// TODO Auto-generated method stub
		
	}

	private void loadMaKH() {
		
	}

	private void loadMaCH() {
		CuaHang cuaHang = new CuaHang();
	}

	protected void loadTenXe(String maXe) {
		// TODO Auto-generated method stub
		ChiTietXeDAO chiTietXe = new ChiTietXeDAO();
		String strTenXe = chiTietXe.getTenXe(maXe);
		lblTenXe.setText(strTenXe);
	}

	private void loadMaXe() throws SQLException {
		ChiTietXeDAO chiTietXe = new ChiTietXeDAO();
		cbbMaXe.removeAllItems();
		for (ChiTietXe ctxe : chiTietXe.getAllMaXe()) {
			cbbMaXe.addItem(ctxe.getMaCTXe());
		}
	}
	
}
