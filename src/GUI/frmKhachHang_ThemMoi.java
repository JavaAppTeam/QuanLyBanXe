package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import DAO.KhachHang_DAO;
import Entity.KhachHang;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmKhachHang_ThemMoi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKhachHang;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtNgaySinh;
	private ButtonGroup groupGioiTinh;
	JCalendar dateChoose;
	KhachHang_DAO khDAO;
	JRadioButton radNu,radNam;

	/**
	 * Tên : Võ Thị Trà Giang , ngày tạo : 13/5/2022
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKhachHang_ThemMoi frame = new frmKhachHang_ThemMoi();
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
	public frmKhachHang_ThemMoi() {
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 192, 203));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.PINK);
		panel.setBounds(5, 5, 619, 380);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 30, 177, 32);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("CMND:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 92, 177, 32);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 154, 177, 32);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 216, 177, 32);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(10, 278, 177, 32);
		panel.add(lblNewLabel_1_1_1_1_1);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKhachHang.setBounds(197, 31, 406, 32);
		panel.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setText("Giang Võ");

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(197, 94, 406, 32);
		panel.add(txtCMND);
		txtCMND.setText("09175853");

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(197, 157, 406, 32);
		panel.add(txtSDT);
		txtSDT.setText("0972347165");

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgaySinh.setBounds(197, 220, 406, 32);
		panel.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtNgaySinh.setText("2001-03-02");

		radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radNam.setBounds(196, 283, 59, 22);
		panel.add(radNam);
		radNam.setSelected(true);

		radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radNu.setBounds(272, 283, 59, 22);
		panel.add(radNu);

		groupGioiTinh = new ButtonGroup();
		groupGioiTinh.add(radNam);
		groupGioiTinh.add(radNu);

		try {
			khDAO = new KhachHang_DAO();
		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iValid()) {
					if (isDuplicate()) {
						String gt = radNu.isSelected() == true ? "Nữ" : "Nam";
						KhachHang kh = new KhachHang(txtTenKhachHang.getText(), Date.valueOf(txtNgaySinh.getText()),
								txtSDT.getText(), txtCMND.getText(), gt);
						try {
							if (khDAO.themKh(kh)) {
								JOptionPane.showMessageDialog(null, "Thêm thành công");
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại");
							}
						} catch (SQLException | HeadlessException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Mã khách hàng hoặc CMND hoặc số điện thoại  đã tồn tại");
					}

				}
			}
		});
		btnThem.setIcon(new ImageIcon(frmKhachHang_ThemMoi.class.getResource("/image/add32.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(417, 317, 177, 53);
		panel.add(btnThem);

	}
	public boolean isDuplicate() {
		String gt = radNu.isSelected() == true ? "Nữ" : "Nam";
		KhachHang kh = new KhachHang(txtTenKhachHang.getText(), Date.valueOf(txtNgaySinh.getText()),
				txtSDT.getText(), txtCMND.getText(), gt);
		List<KhachHang> dssv;
		try {
			dssv = khDAO.getAll();
			for (KhachHang i : dssv) {
				if (i.equals(kh)) {
					return true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean iValid() {
		boolean vlTen = Pattern.matches(".+", txtTenKhachHang.getText());
		boolean vlNS = Pattern.matches("^([0-9]{4}\\-[0-9]{2}\\-[0-9]{2})", txtNgaySinh.getText());
		boolean vlCMND = Pattern.matches("[0-9]{8,9}", txtCMND.getText());
		boolean vlSDT = Pattern.matches("0[0-9]{9}", txtSDT.getText());

		if (!checknull()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ");
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
			JOptionPane.showMessageDialog(this, "So dien thoai phai bat dau bang 0 va theo sau gom 9 ki tu so");
			return false;
		}
		return true;
	}

	public boolean checknull() {
		if (txtTenKhachHang.getText() == "" | txtNgaySinh.getText() == "" | txtSDT.getText() == ""
				| txtCMND.getText() == "")
			return false;
		return true;
	}

}
