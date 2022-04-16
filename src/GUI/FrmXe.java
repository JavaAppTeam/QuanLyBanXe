package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.*;
public class FrmXe extends JFrame {

	private JPanel contentPane;
//	private ImageIO

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXe frame = new FrmXe();
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
	public FrmXe() {
		setTitle("Qu\u1EA3n l\u00FD b\u00E1n xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(220, 20, 60));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 568, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u1EE9c ti\u00EAu th\u1EE5 nhi\u00EAn li\u1EC7u:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 126, 142, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dung t\u00EDch: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 162, 87, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i xe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 93, 87, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("H\u00E3ng xe:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 58, 87, 23);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("T\u00EAn xe:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 25, 87, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gi\u00E1 ti\u1EC1n:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(23, 241, 87, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(23, 203, 142, 22);
		panel.add(lblNewLabel_1_1_1);
		
		JTextPane txtTenXe = new JTextPane();
		txtTenXe.setBounds(184, 11, 350, 28);
		panel.add(txtTenXe);
		
		JTextPane txtHang = new JTextPane();
		txtHang.setBounds(184, 50, 350, 28);
		panel.add(txtHang);
		
		JTextPane txtLoai = new JTextPane();
		txtLoai.setBounds(184, 88, 350, 28);
		panel.add(txtLoai);
		
		JTextPane txtMucTieuThu = new JTextPane();
		txtMucTieuThu.setBounds(184, 122, 350, 28);
		panel.add(txtMucTieuThu);
		
		JTextPane txtDungTich = new JTextPane();
		txtDungTich.setBounds(184, 157, 350, 28);
		panel.add(txtDungTich);
		
		JTextPane txtSoLuong = new JTextPane();
		txtSoLuong.setBounds(184, 197, 350, 28);
		panel.add(txtSoLuong);
		
		JTextPane txtGiaTien = new JTextPane();
		txtGiaTien.setBounds(184, 236, 350, 28);
		panel.add(txtGiaTien);
		
		JPanel pnImage = new JPanel();
		pnImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnImage.setBackground(Color.PINK);
		pnImage.setBounds(588, 11, 379, 273);
//		BufferedImage picXe = ImageIO.read(new File("path-to-file"));
		contentPane.add(pnImage);
	}
}
