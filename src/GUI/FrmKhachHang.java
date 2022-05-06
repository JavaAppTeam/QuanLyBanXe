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

import DAO.KhachHangDAO;
import DAO.KhachHang_DAO;
import Entity.KhachHang;
import Model.KhachHangModel;
import entity.Sinhvien;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

public class FrmKhachHang extends JInternalFrame implements ActionListener {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtMkh;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTextField txtNS;
	private JTable table;
	private KhachHangModel dataModel;
	private JScrollPane scroll;
	private JComboBox cboGT;
	private Object btnNewButton;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXT;
	private JButton btnTADD;
	private KhachHang_DAO khDAO;

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
		txtMkh = new JTextField();
		txtMkh.setText("KH021");
		lblNewLabel.setLabelFor(txtMkh);
		txtMkh.setBounds(132, 0, 388, 50);
		panel_1.add(txtMkh);
		txtMkh.setColumns(10);
		
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
		
		btnThem = new JButton("Thêm khách hàng");
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(132, 180, 170, 50);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa khách hàng");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBounds(376, 180, 138, 50);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa khách hàng");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(620, 180, 138, 50);
		panel_1.add(btnXoa);
		
		btnXT = new JButton("Xóa Trắng");
		btnXT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXT.setBounds(869, 180, 138, 50);
		panel_1.add(btnXT);
		
		btnTADD = new JButton("Thay ảnh đại diện");
		btnTADD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTADD.setBounds(1145, 180, 159, 50);
		panel_1.add(btnTADD);
		
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
		cboGT.addItem("Nữ");
		cboGT.addItem("Nam");
		
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

		khDAO = new KhachHang_DAO();
		panel_2.add(scroll = new JScrollPane(table = new JTable(dataModel = new KhachHangModel(khDAO.getAll()))));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					List<KhachHang> dssv = khDAO.getAll();
					int row  = table.getSelectedRow();
					if(row >=0 && row < dssv.size()) {
						KhachHang  kh = dssv.get(row);
						napKhachHang(kh);
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
			}
		}

			private void napKhachHang(KhachHang kh) {
				txtMkh.setText(kh.getMaKH());
				txtTen.setText(kh.getTenKH());
				txtNS.setText(kh.getNgaySinh().toString());
				txtCMND.setText(kh.getCMND());
				txtSDT.setText(kh.getSdt());
				int inx =  kh.getGioiTinh() =="Nam" ?1:0;
				cboGT.setSelectedIndex(inx+1);
				
				}	
			});
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXT.addActionListener(this);
		btnTADD.addActionListener(this);
	}
	public boolean valid() {
		boolean vlMkh = Pattern.matches("KH[0-9]{3}", txtMkh.getText());
		boolean vlTen = Pattern.matches("[\\w+]", txtTen.getText());
		boolean vlNS = Pattern.matches("^([0-9]{4}\\-[0-9]{2}\\-[0-9]{2})", txtNS.getText());
		boolean vlCMND = Pattern.matches("[0-9]{8}",txtCMND.getText());
		boolean vlSDT = Pattern.matches("[0-9]{10}", txtSDT.getText());
		
		if (!vlMkh) {
			JOptionPane.showMessageDialog(this, "Ma khach hang phai bat dau bang KH theo sau 3 ki tu so");
			return false;
		}
		if (!vlTen) {
			JOptionPane.showMessageDialog(this, "Ten khong chua ki hieu dat biet");
			return false;
		}
		if (!vlNS) {
			JOptionPane.showMessageDialog(this, "Ngay sinh theo format yyyy-mm-dd");
			return false;
		}
		if (!vlCMND) {
			JOptionPane.showMessageDialog(this, "CMND phai gom 8 ky tu so");
			return false;
		}
		if (!vlSDT) {
			JOptionPane.showMessageDialog(this, "So dien thoai phai gom 10 ki tu so");
			return false;
		}
		
		return true;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o==btnThem) {
			if ( valid()) {
			String gt = cboGT.getSelectedIndex()==0?"Nam":"Nữ";
			KhachHang  kh = new KhachHang(txtMkh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt);
			try {
				if(khDAO.addKH(kh)) {
					JOptionPane.showMessageDialog(this, "Them Thanh Cong");
				}else {
					JOptionPane.showMessageDialog(this, "Them That bai");
				}
			} catch (SQLException | HeadlessException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		}
		if(o == btnXoa) {
			int row  = table.getSelectedRow();
			String maKH = table.getValueAt(0, row).toString();
			try {
				if(khDAO.deleteKH(maKH)){
					JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
				}else {
					JOptionPane.showMessageDialog(this, "Xoa That bai");
				}
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o==btnSua) {
			if (valid()) {
			String gt = cboGT.getSelectedIndex()==0?"Nam":"Nữ";
			KhachHang  kh = new KhachHang(txtMkh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt);
			try {
				if(khDAO.updateKH(kh)){
					JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
				}else {
					JOptionPane.showMessageDialog(this, "Sua That bai");
				}
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
		
	}
}
