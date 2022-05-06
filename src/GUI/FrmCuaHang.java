package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.CuaHang_DAO;
import Entity.CuaHang;
import Entity.HoaDon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCuaHang extends JFrame {
	private JTable table;
	private JTable table_1;
	private DefaultTableModel dataModel;
	private JScrollPane scroll;
	private JTextPane txtMaCH, txtPX, txtQH, txtTP, txtHL;
	private String maCuaHang;
	private JButton btnXoa;

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
	 * @throws SQLException 
	 */
	public FrmCuaHang() throws SQLException {
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
		lblNewLabel_3.setBounds(698, 88, 64, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã cửa hàng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(164, 33, 87, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quận Huyện:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(164, 88, 87, 26);
		panel.add(lblNewLabel_1_1_1);
		
		txtMaCH = new JTextPane();
		txtMaCH.setBounds(275, 28, 350, 28);
		panel.add(txtMaCH);
		
		txtPX = new JTextPane();
		txtPX.setBounds(772, 33, 350, 28);
		panel.add(txtPX);
		
		txtQH = new JTextPane();
		txtQH.setBounds(275, 86, 350, 28);
		panel.add(txtQH);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Phường Xã:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(682, 31, 89, 26);
		panel.add(lblNewLabel_1_1_1_2);
		
		txtTP = new JTextPane();
		txtTP.setBounds(772, 88, 350, 28);
		panel.add(txtTP);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hotline:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(201, 146, 64, 26);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtHL = new JTextPane();
		txtHL.setBounds(275, 146, 847, 28);
		panel.add(txtHL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 378, 1340, 285);
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtMaCH.setEditable(false);
		entableText(false);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Segoe UI", Font.BOLD , 26));
		String[] tieuDe = { "Mã Cửa Hàng", "Phường Xã", "Quận Huyện", "Tỉnh TP", "Hotline"};
		panel_1.add(scroll = new JScrollPane(table_1 = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnXoa.setEnabled(true);
				int rowSelect = table_1.getSelectedRow();
				String maCH = (String) table_1.getValueAt(rowSelect, 0);
				String phuongXa = (String) table_1.getValueAt(rowSelect, 1);
				String quanHuyen = (String) table_1.getValueAt(rowSelect, 2);
				String tinhTP = (String) table_1.getValueAt(rowSelect, 3);
				String hotline = (String) table_1.getValueAt(rowSelect, 4);
				txtMaCH.setText(maCH);
				txtPX.setText(phuongXa);
				txtQH.setText(quanHuyen);
				txtTP.setText(tinhTP);
				txtHL.setText(hotline);
				maCuaHang = maCH; 
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
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuaHang_DAO chDao = new CuaHang_DAO();
				CuaHang ch = null;
				try {
					if(txtPX.getText()=="" || txtQH.getText()=="" || txtTP.getText() == "" || txtHL.getText()=="") {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin cửa hàng!");
						return;
					}
					else if(!txtHL.getText().matches("^0[1-9]{9,10}$")) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
						return;
					}
					else {
						ch = new CuaHang( txtTP.getText(),txtQH.getText(),txtPX.getText(),txtHL.getText());
						Boolean bThem = chDao.themCH(ch);
						if(bThem = true) {
							JOptionPane.showMessageDialog(null, "Thêm cửa hàng thành công!");
							loadCuaHang();
						}
						else {
							JOptionPane.showMessageDialog(null, "Thêm cửa hàng thất bại!");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SỬA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entableText(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("LƯU");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuaHang_DAO chDao = new CuaHang_DAO();
				CuaHang ch = null;
				try {
					if(txtPX.getText()=="" || txtQH.getText()=="" || txtTP.getText() == "" || txtHL.getText()=="") {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin cửa hàng!");
						return;
					}
					else if(!txtHL.getText().matches("^0[1-9]{9,10}$")) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
						return;
					}
					else {
						ch = new CuaHang(txtMaCH.getText(),txtTP.getText(),txtQH.getText(),txtPX.getText(),txtHL.getText());
						Boolean bSua = chDao.suaCH(ch);
						if(bSua = true) {
							JOptionPane.showMessageDialog(null, "Sửa cửa hàng thành công!");
							entableText(false);
							loadCuaHang();
						}
						else {
							JOptionPane.showMessageDialog(null, "Sửa cửa hàng thất bại!");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("XÓA TRẮNG");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoatrang();
			}
		});
		
		btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?","Lựa chọn",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					CuaHang_DAO chDao = new CuaHang_DAO();
					if(maCuaHang=="") {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn một cửa hàng để xóa!");
						return;
					}
					else {
						try {
							Boolean bXoa = chDao.xoaHD(maCuaHang);
							if(bXoa == true) {
								JOptionPane.showMessageDialog(null, "Xóa cửa hàng thành công!");
								btnXoa.setEnabled(false);
								loadCuaHang();
							}
							else {
								JOptionPane.showMessageDialog(null, "Xóa cửa hàng thất bại!");
							}
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}						
					btnXoa.setEnabled(false);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnXoa);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnNewButton_4);
		setResizable(true);
		setBounds(-5, -26, 1372, 710);

		
		loadCuaHang();
	}

	private void entableText(Boolean bool) {
		// TODO Auto-generated method stub
		txtTP.setEditable(bool);
		txtQH.setEditable(bool);
		txtPX.setEditable(bool);
		txtHL.setEditable(bool);
	}

	protected void xoatrang() {
		// TODO Auto-generated method stub
		txtMaCH.setText("");
		txtPX.setText("");
		txtQH.setText("");
		txtTP.setText("");
		txtHL.setText("");
	}

	private void loadCuaHang() throws SQLException {
		CuaHang_DAO chDao = new CuaHang_DAO();
		List<CuaHang> dsCH = new ArrayList<CuaHang>();
		dsCH = chDao.getAllDSCuaHang();
		int tblRow = table_1.getRowCount();
		
		for (int i = tblRow - 1; i >= 0; i--) {
			dataModel.removeRow(i);
		}
		for (CuaHang ch : dsCH) {
			dataModel.addRow(new Object[] {ch.getMaCuaHang(), ch.getPhuongXa(),ch.getQuanHuyen(),ch.getTinhTP(),ch.getHotLine()});
		}
	}
}
