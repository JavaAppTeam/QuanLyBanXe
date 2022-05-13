package GUI;

import java.awt.Color;
import DAO.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class FrmTrangChu extends JInternalFrame {
	/**
	 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 16/04/2022
	 */
	private NhanVien_DAO nhanVienDAO = new NhanVien_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTrangChu frame = new FrmTrangChu("nv01");
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
	public FrmTrangChu(String maNV) {

		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		setResizable(true);
		// set size
		setBounds(-5, -26, 1600, 780);

		JPanel pTrangCHu = new JPanel();
		pTrangCHu.setBackground(Color.WHITE);
		pTrangCHu.setBounds(0, 0, 1186, 654);
		getContentPane().add(pTrangCHu);
		pTrangCHu.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/backgroundTrangChu.png")));
		lblNewLabel.setBounds(275, 0, 1253, 816);
		pTrangCHu.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/logo.png")));
		lblNewLabel_1.setBounds(0, 0, 275, 200);
		pTrangCHu.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/lblVS.png")));
		lblNewLabel_2.setBounds(404, 389, 251, 251);
		pTrangCHu.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(0, 200, 275, 551);
		pTrangCHu.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 8, 255, 90);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/user1.png")));

		JPanel panel = new JPanel();
		panel.setBounds(10, 109, 255, 90);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Tên nhân viên :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 235, 14);
		panel.add(lblNewLabel_5);
		String tenNV = nhanVienDAO.getTenNVFormMaNV(maNV);
		lblNewLabel_5.setText(tenNV);

		JLabel lblNewLabel_6 = new JLabel("Chức vụ :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 50, 235, 14);
		panel.add(lblNewLabel_6);
		String maChucVu = nhanVienDAO.getChucVuTheoMa(maNV);
		if(maChucVu.equals("HC"))
			lblNewLabel_6.setText("Nhân viên hành chánh");
		else
			lblNewLabel_6.setText("Nhân viên kỹ thuật");

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/penguin.png")));
		lblNewLabel_3.setBounds(10, 220, 255, 249);
		panel_1.add(lblNewLabel_3);

	}
}
