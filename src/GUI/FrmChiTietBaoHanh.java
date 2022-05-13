package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import DAO.*;
import Entity.ChiTietHoaDonBaoHanh;
import Entity.PhuTungXe;

public class FrmChiTietBaoHanh extends JFrame implements MouseListener {
	private double tongTien;
	private JPanel contentPane;
	private String maHoaDonBaoHanh,maHoaDon;
	private JTextField txtMaBaoHanh;
	private JTextField txtIDPhuTung;
	private JTextField txtSoLuong;
	private JTable tblChiTietBaoHanh;
	private DefaultTableModel dtmCTBaoHanh;
	JButton btnThem, btnDelete, btnXoaTrang;
	String[] colHeader = { "MÃ HÓA ĐƠN", "MÃ BẢO HÀNH", "ID PHỤ TÙNG", "SỐ LƯỢNG", "GIÁ" };
	private JTable tblPhuTung;
	private DefaultTableModel dtmPhuTung;
	String[] colHeader1 = { "ID Phụ tùng", "Tên phụ tùng", "Số lượng tồn", "trạng thái", "Đơn giá" };
	private JButton btnReset,btnKiemTraHangBaoHanh;
	private ChiTietBaoHanhDao chiTietBaoHanhDao = new ChiTietBaoHanhDao();
	private PhuTungDao phuTungDao = new PhuTungDao();
	private ArrayList<ChiTietHoaDonBaoHanh> arrCTBH;
	JLabel lblTongTien;
	private JTextField txtMaHD;
	private JButton btnThoat;

	/**
	 * Launch the application. Tên: Trần Văn Sỹ Ngày tạo: 16/04/2022
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChiTietBaoHanh frm = new FrmChiTietBaoHanh("BH001","");
					frm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public FrmChiTietBaoHanh(String maHDBH, String maHD) throws Exception {
		setTitle("Chi tiết hóa đơn");

		maHoaDonBaoHanh = maHDBH;
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(10, 10, 1340, 649);
		contentPane = new JPanel();
		contentPane.setBounds(10, 10, 1340, 661);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setForeground(new Color(220, 20, 60));
		contentPane.setBackground(new Color(255, 192, 203));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 650, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setForeground(new Color(220, 20, 60));
		panel.setBackground(new Color(255, 192, 203));

		JLabel lblNewLabel = new JLabel("Mã HDBH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 22, 98, 32);
		panel.add(lblNewLabel);

		txtMaBaoHanh = new JTextField();
		txtMaBaoHanh.setEnabled(false);
		txtMaBaoHanh.setBounds(210, 26, 382, 25);
		panel.add(txtMaBaoHanh);
		txtMaBaoHanh.setColumns(10);
		txtMaBaoHanh.setText(maHoaDonBaoHanh);

		JLabel lblMHd = new JLabel("Mã HD:");
		lblMHd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMHd.setBounds(31, 76, 98, 32);
		panel.add(lblMHd);

		JLabel lblId = new JLabel("ID Phụ tùng:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(31, 130, 120, 32);
		panel.add(lblId);

		JLabel lblId_1 = new JLabel("Số lượng:");
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId_1.setBounds(31, 184, 120, 32);
		panel.add(lblId_1);

		txtIDPhuTung = new JTextField();
		txtIDPhuTung.setEnabled(false);
		txtIDPhuTung.setColumns(10);
		txtIDPhuTung.setBounds(210, 128, 382, 25);
		panel.add(txtIDPhuTung);

		txtSoLuong = new JTextField();
		txtSoLuong.setEnabled(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(210, 179, 382, 25);
		panel.add(txtSoLuong);

		JLabel lblId_1_1 = new JLabel("Tổng tiền:");
		lblId_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId_1_1.setBounds(31, 238, 120, 32);
		panel.add(lblId_1_1);

		lblTongTien = new JLabel("0 đ");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBounds(210, 230, 382, 37);
		panel.add(lblTongTien);

		txtMaHD = new JTextField();
		txtMaHD.setEnabled(false);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(210, 77, 382, 25);
		panel.add(txtMaHD);

		tblChiTietBaoHanh = new JTable();
		tblChiTietBaoHanh.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblChiTietBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtmCTBaoHanh = new DefaultTableModel(colHeader, 0);
		tblChiTietBaoHanh.setModel(dtmCTBaoHanh);

		JScrollPane scrollPane = new JScrollPane(tblChiTietBaoHanh);
		scrollPane.setSize(1088, 285);
		scrollPane.setLocation(230, 317);
		contentPane.add(scrollPane);

		tblPhuTung = new JTable();
		tblPhuTung.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblPhuTung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtmPhuTung = new DefaultTableModel(colHeader1, 0);
		tblPhuTung.setModel(dtmPhuTung);

		JScrollPane scrollPane1 = new JScrollPane(tblPhuTung);
		scrollPane1.setSize(646, 261);
		scrollPane1.setLocation(670, 10);
		contentPane.add(scrollPane1);

		btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(FrmChiTietBaoHanh.class.getResource("/image/reset.png")));
		btnReset.setBounds(1274, 281, 32, 32);
		contentPane.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(11, 318, 208, 285);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
				btnThem = new JButton("Thêm");
				btnThem.setBounds(10, 24, 170, 41);
				panel_1.add(btnThem);
				btnThem.setIcon(new ImageIcon(FrmChiTietBaoHanh.class.getResource("/image/btnThem.png")));
				btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
						btnDelete = new JButton("Xóa");
						btnDelete.setBounds(10, 89, 170, 41);
						panel_1.add(btnDelete);
						btnDelete.setIcon(new ImageIcon(FrmChiTietBaoHanh.class.getResource("/image/btnXoaTrang.png")));
						btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
								btnXoaTrang = new JButton("Xóa trắng");
								btnXoaTrang.setBounds(10, 154, 170, 41);
								panel_1.add(btnXoaTrang);
								btnXoaTrang.setIcon(new ImageIcon(FrmChiTietBaoHanh.class.getResource("/image/btnXoaTrang.png")));
								btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
								btnThoat = new JButton("Trở về");
								btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
								btnThoat.setBounds(10, 219, 170, 41);
								panel_1.add(btnThoat);
								txtMaHD.setText(maHoaDon);
								
								btnKiemTraHangBaoHanh = new JButton("");
								btnKiemTraHangBaoHanh.setIcon(new ImageIcon(FrmChiTietBaoHanh.class.getResource("/image/check.png")));
								btnKiemTraHangBaoHanh.setBounds(602, 75, 38, 32);
								panel.add(btnKiemTraHangBaoHanh);
		addEvents();
	}

	public boolean regex() {
		// check soLuong
		int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
		int maPT = Integer.parseInt(txtIDPhuTung.getText().trim());
		int soLuongTon = 0;
		ArrayList<PhuTungXe> pt = null;
		try {
			pt = phuTungDao.getSPTheoMa(maPT);
			if (pt.size() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy mã phụ tùng");
				return false;
			}
			for (PhuTungXe ptx : pt) {
				soLuongTon = ptx.getSoLuongTon();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (soLuong > soLuongTon || soLuong < 0) {
			JOptionPane.showMessageDialog(null, "Số lượng ko thỏa");
			return false;
		}
		return true;
	}

	private void addEvents() throws Exception {
		// TODO Auto-generated method stub
		loadDataCTXe();
		loadDataPT();
		tblChiTietBaoHanh.addMouseListener(this);
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnThem.getText() == "Thêm") {
					clearInput();
					onInput();
					btnThem.setText("Lưu");
				} else if (kiemTraNull() == true) {
					JOptionPane.showMessageDialog(null, "Không để trống dữ liệu");
				} else if (regex() == false) {
				} else {
					try {
						// clearInput();
						addCTPT();
						delValuesonTable();
						loadDataPT();
						loadDataCTXe();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					clearInput();
					offInput();
					btnThem.setText("Thêm");
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tblChiTietBaoHanh.getSelectedRow();
				if(r == -1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn dòng cần xóa");
					return;
				}
				JFrame f= new JFrame();
				int hoi=JOptionPane.showConfirmDialog(f, "Bạn chắc xóa phụ tùng này khỏi hóa đơn","???",JOptionPane.YES_NO_OPTION);
				if(hoi==JOptionPane.YES_OPTION) {
					// TODO Auto-generated method stub
					try {
						del();
						delValuesonTable();
						loadDataPT();
						loadDataCTXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnXoaTrang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearInput();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnKiemTraHangBaoHanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date timeBaoHanh = chiTietBaoHanhDao.layNgayLapHoaDon(txtMaHD.getText().trim());
				if(txtMaHD.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã HD");
				}
				if(timeBaoHanh==null) {
					JOptionPane.showMessageDialog(null, "Mã hóa đơn bạn nhập không tồn tại");
				}
				else {
					LocalDate hanBaoHanh = timeBaoHanh.toLocalDate();
					JOptionPane.showMessageDialog(null, "Hạn bảo hành: "+ hanBaoHanh.plusMonths(12).toString());
				}
			}
		});
	}

	private void del() throws SQLException, Exception {
		boolean kq = chiTietBaoHanhDao.delCTHoaDonBaoHanh(createCTBH());
		if (kq == true)
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		else
			JOptionPane.showMessageDialog(null, "Fail");
	}

	private void clearInput() {
		txtIDPhuTung.setText("");
		txtSoLuong.setText("");
		//txtMaHD.setText("");
		txtMaHD.requestFocus();
	}

	private ChiTietHoaDonBaoHanh createCTBH() {
		String maBH = maHoaDonBaoHanh;
		String maHD = txtMaHD.getText();
		int idPhuTung = Integer.parseInt(txtIDPhuTung.getText());
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		return (new ChiTietHoaDonBaoHanh(maHD, maBH, idPhuTung, soLuong));
	}

	private void addCTPT() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean kq = chiTietBaoHanhDao.addCTBH(createCTBH());
		if (kq == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công!!!!");
		}
	}
	public boolean kiemTraNull() {
		if (txtMaHD.getText().trim().equals("") || txtIDPhuTung.getText().trim().equals("")
				|| txtSoLuong.getText().trim().equals("")) {
			return true;
		}
		return false;
	}

	private void loadDataPT() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<PhuTungXe> arrPtx = new ArrayList<PhuTungXe>();
		arrPtx = (ArrayList<PhuTungXe>) phuTungDao.getallSP();
		for (PhuTungXe pt : arrPtx) {
			Object[] rowData = { pt.getMaPhuTung(), pt.getTenPhuTung(), pt.getSoLuongTon(), pt.isTrangThai(),
					pt.getDonGia() };
			dtmPhuTung.addRow(rowData);
		}
	}

	private void delValuesonTable() {
		dtmPhuTung = null;
		dtmPhuTung = new DefaultTableModel(colHeader1, 0);
		tblPhuTung.setModel(dtmPhuTung);
		dtmCTBaoHanh = null;
		dtmCTBaoHanh = new DefaultTableModel(colHeader, 0);
		tblChiTietBaoHanh.setModel(dtmCTBaoHanh);
	}

	private void loadDataCTXe() throws Exception {
		arrCTBH = new ArrayList<ChiTietHoaDonBaoHanh>();
		arrCTBH = chiTietBaoHanhDao.getCTBHTheoMa(maHoaDonBaoHanh);
		LocalDate ngayLapHDBH = chiTietBaoHanhDao.layNgayLapHoaDonBaoHanh(txtMaBaoHanh.getText().trim()).toLocalDate();
		LocalDate thoiHanBaoHanh;
		ArrayList<PhuTungXe> ptx = new ArrayList<PhuTungXe>();
		double donGia = 0;
		double gia = 0;
		tongTien = 0;
		boolean check = chiTietBaoHanhDao.checkLoi(maHoaDonBaoHanh);
		for (ChiTietHoaDonBaoHanh hd : arrCTBH) {
			ptx = (ArrayList<PhuTungXe>) phuTungDao.getSPTheoMa(hd.getIdPhuTung());
			for (PhuTungXe pt : ptx) {
				donGia = pt.getDonGia();
			}
			thoiHanBaoHanh = chiTietBaoHanhDao.layNgayLapHoaDon(hd.getMaHoaDon()).toLocalDate().plusMonths(12);
			if(ngayLapHDBH.isBefore(thoiHanBaoHanh)&& check ==true) {
				gia = 0;
			}
			else
				gia = donGia * hd.getSoLuong();
			Object[] rowData = { hd.getMaHoaDon(), hd.getMaBaoHanh(), hd.getIdPhuTung(), hd.getSoLuong(), gia };
			dtmCTBaoHanh.addRow(rowData);
			tongTien += gia;
		}
		lblTongTien.setText(tongTien + " đ");
	}

	private void loadDataToText(ChiTietHoaDonBaoHanh ctbh) {
		txtMaHD.setText(ctbh.getMaHoaDon());
		txtIDPhuTung.setText(ctbh.getIdPhuTung() + "");
		txtSoLuong.setText(ctbh.getSoLuong() + "");
	}
	public void offInput() {
		txtIDPhuTung.setEnabled(false);
		txtSoLuong.setEnabled(false);
		txtMaHD.setEnabled(false);
	}
	public void onInput() {
		txtIDPhuTung.setEnabled(true);
		txtSoLuong.setEnabled(true);
		txtMaHD.setEnabled(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tblChiTietBaoHanh.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(chiTietBaoHanhDao.getCTBHTheoMa(maHoaDonBaoHanh).get(select));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
