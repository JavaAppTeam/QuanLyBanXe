package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Test extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
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
		pTrangCHu.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pTrangCHu.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		pTrangCHu.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setBounds(0,0,1186, 300);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_5.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_6.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_7.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_8.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		panel_8.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_9.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		panel_9.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_3.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_10.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		panel_10.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_11.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		panel_11.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0,0, 1186, 300);
		pTrangCHu.add(panel_12, BorderLayout.SOUTH);

	}
}
