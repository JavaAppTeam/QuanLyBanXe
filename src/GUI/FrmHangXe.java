package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import Entity.HangXe;
import Model.KhachHangModel;
import javax.swing.ImageIcon;

public class FrmHangXe extends JInternalFrame implements ActionListener{

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
	private JTable tblHangXe;
	private JTextField txtTK;
	private DefaultTableModel tblModelHangXe;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXT;
	private JButton btnXoa;
	private JButton btnTK;
	private String[] tieude = {"Mã hãng xe","Tên hãng xe"};

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
		
		btnThem = new JButton("Thêm ");
		btnThem.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/btnThem.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(187, 60, 170, 50);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/btnSave.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		btnSua.setBounds(416, 60, 138, 50);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa ");
		btnXoa.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/btnXoa.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(612, 60, 138, 50);
		panel_1.add(btnXoa);
		
		btnXT = new JButton("Xóa Trắng");
		btnXT.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/btnXoaTrang.png")));
		btnXT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXT.setBounds(804, 60, 138, 50);
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
		
		txtTK = new JTextField();
		txtTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTK.setBounds(1127, 61, 326, 50);
		panel_1.add(txtTK);
		txtTK.setColumns(10);
		
		btnTK = new JButton("Tìm kiếm");
		btnTK.setIcon(new ImageIcon(FrmHangXe.class.getResource("/image/btnTim.png")));
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTK.setBounds(992, 59, 125, 53);
		panel_1.add(btnTK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 192, 1588, 559);
		pnKhachHang.add(panel_2);
		panel_2.setLayout(null);
		hxDAO = new HangXe_DAO();
		
		
		table = new JTable();
		JTableHeader header = ((JTable) table).getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD , 26));
		panel_2.add(scroll = new JScrollPane(tblHangXe = new JTable(tblModelHangXe = new DefaultTableModel(tieude, 0))));
		scroll.setBounds(115, 10, 1350, 535);
		tblHangXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnXoa.setEnabled(true);
				int rowSelect = tblHangXe.getSelectedRow();
				String maHX = (String) tblHangXe.getValueAt(rowSelect, 0);
				String Ten = (String) tblHangXe.getValueAt(rowSelect, 1);
				
				txtMaHX.setText(maHX);
				txtTen.setText(Ten);
				
			}
		});
		tblHangXe.setRowHeight(30);
		scroll.setFont(new Font("Tahoma", Font.BOLD, 14));
		JTableHeader tableHeader = tblHangXe.getTableHeader();
		tableHeader.setFont(new Font("Segoe UI", Font.BOLD , 16));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tblHangXe.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tblHangXe.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		loadDataToModel();
		
		
		//actionlisten
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnTK.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXT.addActionListener(this);
		
	}
	public void clear() {
		txtMaHX.setText("");
		txtTen.setText("");
	}
	private void deleteAllTableRows(JTable table) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    while( model.getRowCount() > 0 ){
	        model.removeRow(0);
	    }
	}
	public boolean  checknull() {
		boolean check = (txtMaHX.getText().equals("") |
		txtTen.getText().equals(""))?false:true;
		return check;
	}
	public boolean iValid() {
		boolean vlMhx = Pattern.matches("[\\w]{3}", txtMaHX.getText());
		boolean vlTen = Pattern.matches(".+", txtTen.getText());
	
		if(!checknull()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ");
		}
		if (!vlMhx) {
			JOptionPane.showMessageDialog(this, "Ma khach hangla 3 ki tu ");
			return false;
		}
		if (!vlTen) {
			JOptionPane.showMessageDialog(this, "Ten khong chua ki hieu dat biet");
			return false;
		}
		return true;
	}
	public void loadDataToModel()  {
		deleteAllTableRows(tblHangXe);
		HangXe_DAO hxDAO = new HangXe_DAO() ;
		try {
			
			for (HangXe i : hxDAO.getAll()) {
				if(i.isTrangThai()) {
				Object obj[] = {i.getMaHang(),i.getTenHang()};
				tblModelHangXe.addRow(obj);
				}
			}
			tblHangXe.setModel(tblModelHangXe);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showmess(String mess ) {
		JOptionPane.showMessageDialog(this, mess);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnXT) {
			clear();
		}
		if (o == btnThem) {
			
			HangXe hx = new HangXe(txtMaHX.getText(), txtTen.getText(),true);
			
			for(HangXe h:hxDAO.findAll(hx,"False")) {
				System.out.println(h);
			}
			System.out.println("this y befor the test");
			
			
			if(!hxDAO.findAll(hx,"true").isEmpty()) {
				showmess("Hãng Xe đã tồn tại");
			}else 
			if(!hxDAO.findAll(hx,"False").isEmpty()) {
				hxDAO.updateHX(hx);
				showmess("Thêm hãng xe thành công!!");
			}else if(hxDAO.findAllbyMa(hx.getMaHang(),"false")!= null) {
				
			}
			else	
			if (hxDAO.addHX(hx)) {
					showmess("Thêm hãng xe thành công!!");
					loadDataToModel();
					
				}else {
					showmess("Thêm hãng xe không thành công tên không được trùng");
				}
			clear();
		}
		if(o == btnSua) {
			HangXe hx = new HangXe(txtMaHX.getText(), txtTen.getText(),true);
			if (hxDAO.updateHX(hx)) {
				showmess("Sửa Hãng Xe "+hx.getMaHang()+" Thành Công");
			}else {
				showmess("Sửa Thất bại !!");
			}
			loadDataToModel();
		}
		if(o ==btnXoa ) {
			HangXe hx = new HangXe(txtMaHX.getText(), txtTen.getText(),true);
			System.out.println(hx);
			if(hxDAO.deleteHX(hx)) {
				showmess("Xóa Thành Công !!");
				loadDataToModel();
				clear();
			}else {
				showmess("Xóa không thành công");
			}
		}
		if (o ==btnTK) {
			String mahx = txtTK.getText();
			if (mahx.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hãng muốn tìm");
				
			}else if(mahx.equals("Trở Về")) {
				deleteAllTableRows(tblHangXe);
				loadDataToModel();
				btnTK.setText("Tìm kiếm");
				txtTK.setText("");
			} else{
			deleteAllTableRows(tblHangXe);
			 	HangXe i = hxDAO.findAllbyMa(mahx, "true") ;
				Object[] objhx = {i.getMaHang(),i.getTenHang()};
				tblModelHangXe.addRow(objhx);
				
			btnTK.setText("Trở Về");
			txtTK.setText("Trở Về");
			}
			clear();
		}
		
	}
}
