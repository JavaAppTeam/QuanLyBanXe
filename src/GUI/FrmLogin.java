package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import Entity.NhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import DAO.*;
import Entity.TaiKhoan;

public class FrmLogin extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JButton btnDN;
	private JButton btnThoat;
	LoginDao loginDao = new LoginDao();
	ArrayList<TaiKhoan> arrTK = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrmLogin frm = new FrmLogin();
		frm.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 400);
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(47, 72, 256, 256);
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/image/penguin.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0110\u0103ng Nh\u1EADp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(472, 72, 224, 40);
		contentPane.add(lblNewLabel_1);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserName.setBounds(480, 159, 273, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.setText("HC001");
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblNewLabel_2.setBounds(350, 159, 120, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(350, 200, 120, 30);
		contentPane.add(lblNewLabel_2_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(480, 200, 273, 30);
		contentPane.add(txtPassword);
		txtPassword.setText("1111");
		
		btnDN = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDN.setIcon(new ImageIcon(FrmLogin.class.getResource("/image/btnCapNhat.png")));
		btnDN.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		
		btnDN.setBackground(new Color(224, 255, 255));
		btnDN.setBounds(473, 280, 150, 48);
		contentPane.add(btnDN);
		
		btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			}
		});
		btnThoat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setIcon(new ImageIcon(FrmLogin.class.getResource("/image/cross.png")));
		btnThoat.setBounds(633, 280, 120, 48);
		contentPane.add(btnThoat);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(350, 125, 403, 5);
		contentPane.add(panel);
	
		
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnDN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

					boolean kq=kiemTraDangNhap();
					if(kq==true) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						try {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										FrmTong frame = new FrmTong(txtUserName.getText().trim(), "Quản lý");
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}		
					else if(kq==false)
						JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
		});
	}
	private boolean kiemTraDangNhap() {
		// TODO Auto-generated method stub
		String tk = txtUserName.getText().trim();
		String pass=txtPassword.getText().trim();
		try {
			boolean kq = loginDao.getAcount(tk,pass);
			if(kq==true)
				return true; 
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
