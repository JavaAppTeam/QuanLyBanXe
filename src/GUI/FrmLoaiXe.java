package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class FrmLoaiXe extends JInternalFrame {
	private JTextField txtIDLX;
	private JTextField txtTenLX;
	private JTable tblLoaiXe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLoaiXe frame = new FrmLoaiXe();
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
	public FrmLoaiXe() {
		doShow();
		addControl();
		

	}

	private void addControl() {
		
		
	}

	private void doShow() {
		setTitle("Quản lý loại xe");
		getContentPane().setBackground(new Color(255, 192, 203));
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBackground(new Color(255, 192, 203));
		getContentPane().add(pnHeader, BorderLayout.NORTH);
		pnHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Quản lý loại xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pnHeader.add(lblNewLabel);
		
		JPanel pnContext = new JPanel();
		pnContext.setBackground(new Color(255, 192, 203));
		getContentPane().add(pnContext, BorderLayout.CENTER);
		pnContext.setLayout(null);
		
		JPanel pnControl = new JPanel();
		pnControl.setBackground(new Color(255, 192, 203));
		pnControl.setBounds(25, 31, 1311, 75);
		pnContext.add(pnControl);
		pnControl.setLayout(null);
		
		JLabel lblIDLX = new JLabel("ID Loại xe");
		lblIDLX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIDLX.setBounds(10, 10, 144, 55);
		pnControl.add(lblIDLX);
		
		txtIDLX = new JTextField();
		txtIDLX.setBounds(164, 10, 445, 55);
		pnControl.add(txtIDLX);
		txtIDLX.setColumns(10);
		
		JLabel lblTenLX_1 = new JLabel("Tên Loại xe");
		lblTenLX_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenLX_1.setBounds(702, 10, 144, 55);
		pnControl.add(lblTenLX_1);
		
		txtTenLX = new JTextField();
		txtTenLX.setColumns(10);
		txtTenLX.setBounds(856, 10, 445, 55);
		pnControl.add(txtTenLX);
		
		JButton btnThemLX = new JButton("Thêm loại xe");
		btnThemLX.setBackground(new Color(255, 192, 203));
		btnThemLX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThemLX.setBounds(25, 116, 200, 50);
		pnContext.add(btnThemLX);
		
		JButton btnSuaLX = new JButton("Sửa loại xe");
		btnSuaLX.setBackground(new Color(255, 192, 203));
		btnSuaLX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuaLX.setBounds(380, 116, 200, 50);
		pnContext.add(btnSuaLX);
		
		JButton btnXoaLX = new JButton("Xoá loại xe");
		btnXoaLX.setBackground(new Color(255, 192, 203));
		btnXoaLX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaLX.setBounds(758, 116, 200, 50);
		pnContext.add(btnXoaLX);
		
		JButton btnXoaTrangLoaiXe = new JButton("Xoá Trắng");
		btnXoaTrangLoaiXe.setBackground(new Color(255, 192, 203));
		btnXoaTrangLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaTrangLoaiXe.setBounds(1136, 116, 200, 50);
		pnContext.add(btnXoaTrangLoaiXe);
		
		JPanel pnTable = new JPanel();
		pnTable.setBackground(new Color(255, 192, 203));
		pnTable.setBounds(25, 176, 1311, 415);
		pnContext.add(pnTable);
		pnTable.setLayout(null);
		
		tblLoaiXe = new JTable();
		tblLoaiXe.setBounds(10, 403, 1291, -392);
		pnTable.add(tblLoaiXe);
		setResizable(true);
		setBounds(-5, -26, 1372, 710);
		
	}

}
