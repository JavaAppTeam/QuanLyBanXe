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

import DAO.KhachHang_DAO;
import Entity.KhachHang;
import Model.KhachHangModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import java.lang.reflect.Array;
import java.security.PublicKey;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

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
	private JButton btnTK;
	private KhachHang_DAO khDAO;
	private KhachHangModel dataModel1;
	private JTextField txtTK;

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
		// set size
		setBounds(-5, -26, 1600, 780);

		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBackground(Color.PINK);
		pnKhachHang.setBounds(0, 0, 1186, 654);
		getContentPane().add(pnKhachHang);
		pnKhachHang.setLayout(null);
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 1588, 60);
		pnKhachHang.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 60, 1276, 286);
		pnKhachHang.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 26, 120, 50);
		panel_1.add(lblNewLabel);
		txtMkh = new JTextField();
		txtMkh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMkh.setText("KH021");
		lblNewLabel.setLabelFor(txtMkh);
		txtMkh.setBounds(132, 26, 500, 50);
		panel_1.add(txtMkh);
		
		JLabel lblNewLabel_2 = new JLabel("CMND: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 86, 120, 50);
		panel_1.add(lblNewLabel_2);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCMND.setText("82181281");
		lblNewLabel_2.setLabelFor(txtCMND);
		txtCMND.setColumns(10);
		txtCMND.setBounds(132, 86, 500, 50);
		panel_1.add(txtCMND);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 146, 120, 50);
		panel_1.add(lblNewLabel_3);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setText("0913121213");
		lblNewLabel_3.setLabelFor(txtSDT);
		txtSDT.setColumns(10);
		txtSDT.setBounds(132, 146, 500, 50);
		panel_1.add(txtSDT);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setText("Dat");
		txtTen.setColumns(10);
		txtTen.setBounds(757, 29, 493, 50);
		panel_1.add(txtTen);
		
		txtNS = new JTextField();
		txtNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNS.setText("2001-10-10");
		txtNS.setColumns(10);
		txtNS.setBounds(757, 86, 493, 50);
		panel_1.add(txtNS);
		
		cboGT = new JComboBox();
		cboGT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGT.addItem("Nữ");
		cboGT.addItem("Nam");
		
		cboGT.setBorder(new EmptyBorder(2, 2, 2, 2));
		cboGT.setBounds(757, 146, 493, 50);
		panel_1.add(cboGT);
		
		JLabel lblNewLabel_3_2 = new JLabel("Giới Tính: ");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(638, 146, 120, 50);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày Sinh: ");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(638, 86, 120, 50);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblHVTn = new JLabel("Họ và tên : ");
		lblHVTn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHVTn.setBounds(638, 26, 120, 50);
		panel_1.add(lblHVTn);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(0, 212, 1276, 74);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(52, 10, 170, 50);
		panel_4.add(btnThem);
		btnThem.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/btnThem.png")));
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(252, 10, 138, 50);
		panel_4.add(btnSua);
		btnSua.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/btnSave.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(417, 10, 138, 50);
		panel_4.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/btnXoa.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnXT = new JButton("Xóa Trắng");
		btnXT.setBounds(578, 10, 138, 50);
		panel_4.add(btnXT);
		btnXT.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/btnXoaTrang.png")));
		btnXT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnTK = new JButton("Tìm kiếm");
		btnTK.setBounds(746, 10, 159, 50);
		panel_4.add(btnTK);
		btnTK.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/btnTim.png")));
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTK = new JTextField();
		txtTK.setBounds(915, 13, 351, 46);
		panel_4.add(txtTK);
		txtTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTK.setColumns(10);

		btnTK.addActionListener(this);
		btnXT.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.addActionListener(this);
		
		btnThem.addActionListener(this);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 349, 1540, 402);
		pnKhachHang.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		khDAO = new KhachHang_DAO();
		panel_2.add(scroll = new JScrollPane(table = new JTable(dataModel = napDataFormSQL())));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(1274, 79, 254, 267);
		pnKhachHang.add(panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FrmKhachHang.class.getResource("/image/KH1.jpg")));
		panel_3.add(lblNewLabel_4);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int row  = table.getSelectedRow();
					KhachHang kh = (KhachHang) napDataFormSQL().getValueAt(row);
					napKhachHang(kh);
				}catch (Exception ex) {
					System.out.println(ex);
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
				cboGT.setSelectedIndex(inx);
				
				}	
			});
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
	}
	public KhachHangModel napDataFormSQL() {
		KhachHang_DAO khDAO;
		try {
			khDAO = new KhachHang_DAO();
			List<KhachHang> trangthaitrue = new ArrayList<KhachHang>();
			for (KhachHang i :  khDAO.getAll()) {
				if (i.getTrangThai()) {
					trangthaitrue.add(i);
				}	
			}
			dataModel = new KhachHangModel(trangthaitrue);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataModel;
	}
	public boolean isDuplicate() {
		String gt = cboGT.getSelectedIndex()==0?"Nữ":"Nam";
		KhachHang  kh = new KhachHang(txtMkh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt,true);
		List<KhachHang> dssv;
		try {
			dssv = khDAO.getAll();
			for (KhachHang i :dssv) {
				if (i.equals(kh)) {
					return true;
				}
			}
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return false;
	
		
		
		
		
	}
	public boolean iValid() {
		boolean vlMkh = Pattern.matches("KH[0-9]{3}", txtMkh.getText());
		boolean vlTen = Pattern.matches(".+", txtTen.getText());
		boolean vlNS = Pattern.matches("^([0-9]{4}\\-[0-9]{2}\\-[0-9]{2})", txtNS.getText());
		boolean vlCMND = Pattern.matches("[0-9]{8,9}",txtCMND.getText());
		boolean vlSDT = Pattern.matches("0[0-9]{9}", txtSDT.getText());
		
		if(!checknull()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ");
		}
		if (!vlMkh) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng phải bắt đầu bằng KH theo sau 3 kí tự số");
			return false;
		}
		if (!vlTen) {
			JOptionPane.showMessageDialog(this, "Tên không chứa kí hiệu đặt biệt");
			return false;
		}
		if (!vlNS) {
			JOptionPane.showMessageDialog(this, "Ngày sinh theo format yyyy-mm-dd");
			return false;
		}
		if (!vlCMND) {
			JOptionPane.showMessageDialog(this, "CMND phải gồm 8 kí tự số");
			return false;
		}
		if (!vlSDT) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng 0 và theo sau là 9 kí tự số");
			return false;
		}
		
		
		return true;
	}
	public boolean checknull() {
		if( txtMkh.getText()==""|
			txtTen.getText()==""|
			txtNS.getText()==""|
			txtSDT.getText()==""|
			txtCMND.getText()=="" ) 
			return false;	
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o==btnThem) {
			if ( iValid()) {
				if(isDuplicate()) {
					JOptionPane.showMessageDialog(this, "Không được trùng Mã khách hàng, CMND, số điện thoại");
				}else {

			String gt = cboGT.getSelectedIndex()==0?"Nữ":"Nam";
			KhachHang  kh = new KhachHang(txtMkh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt,true);
					if(khDAO.addKH(kh)) {
						table.setModel(napDataFormSQL());
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					}else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				
				}
			}
		}
		if(o == btnXoa) {
//			System.out.println("btnxoa click");
			int row  = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this,"Hãy chọn dòng muốn xóa trước khi xóa" );
			}
			
			int col  = 0;
			String makh = (String) table.getValueAt(row, col);
//			System.out.println(makh);
			try {
				if (!isDuplicate()) {
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
				}else {
					if(khDAO.deleteKH(makh)==true){
						JOptionPane.showMessageDialog(this, "Xóa Thành Công");
					}else {
						JOptionPane.showMessageDialog(this, "Xóa Thất Bại");}
					}
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.setModel(napDataFormSQL());
			clear();
		}
		if (o==btnSua) {
			if (iValid()) {
					String gt = cboGT.getSelectedIndex()==0?"Nữ":"Nam";
					KhachHang  kh = new KhachHang(txtMkh.getText(),txtTen.getText(),Date.valueOf(txtNS.getText()),txtSDT.getText(),txtCMND.getText(),gt,true);
			try {
				if(khDAO.updateKH(kh)){
					JOptionPane.showMessageDialog(this, "Sửa Thành Công");
				}else {
					JOptionPane.showMessageDialog(this, "Sửa Thất Bại");
				}
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			table.setModel(napDataFormSQL());
		}
		if (o==btnXT) {
			clear();
		}
		if (o == btnTK) {
			String maTK = txtTK.getText();
			if(maTK.equals("")){
				table.setModel(napDataFormSQL()); 
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn tìm");
				
			}if(maTK.equals("Trở Về")) {
				table.setModel(napDataFormSQL()); 
				btnTK.setText("Tìm kiếm");
				txtTK.setText("");
			}
			else {
				dataModel = new KhachHangModel(khDAO.findKH(maTK));
				table.setModel(dataModel); 
				btnTK.setText("Trở Về");
				txtTK.setText("Trở Về");
			}
			
		}
	}

	private void clear() {
		txtMkh.setText("");
		txtTen.setText("");
		txtNS.setText("");
		txtSDT.setText("");
		txtCMND.setText("");
		
	}
}
