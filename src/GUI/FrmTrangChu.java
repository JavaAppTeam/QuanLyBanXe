package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class FrmTrangChu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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
		setBounds(-5, -26, 1372, 710);
		
		JPanel pTrangCHu = new JPanel();
		pTrangCHu.setBackground(Color.WHITE);
		pTrangCHu.setBounds(0, 0, 1186, 654);
		getContentPane().add(pTrangCHu);
		pTrangCHu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/1.png")));
		lblNewLabel.setBounds(275, 0, 1090, 680);
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
		panel_1.setBounds(0, 200, 275, 480);
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
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setBounds(0, 11, 95, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Chức vụ :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(0, 50, 95, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmTrangChu.class.getResource("/image/penguin.png")));
		lblNewLabel_3.setBounds(10, 220, 255, 249);
		panel_1.add(lblNewLabel_3);

	}
}
