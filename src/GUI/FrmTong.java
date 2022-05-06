package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class FrmTong extends JFrame {

	private JPanel contentPane;
	private JMenu mnTimKiem, mnHeThong, mnDanhMuc, mnXuLy;
	private JMenuItem mntmDangKyCaNhanVien, mntmTrangChu, mntmDM_NV, mntmDM_KH, mntmTao_DH, mntmTao_HD, mntmTimKiem_KH,
			mntmTimKiem_SP;
	private FrmTrangChu frmTrangChu;
	private FrmQLNhanVien frmQLNhanVien;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmBaoHanh;
	private FrmTimKiemXe frmTiemKiemXe;
	private FrmPhuTung frmPhuTung;
	private FrmXe frmXe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTong frame = new FrmTong("QL1", "Quản lý");
					frame.setVisible(true);
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
	public FrmTong(String maNV, String chucVu) throws Exception {
		setTitle("Qu\u1EA3n l\u00FD b\u00E1n xe");
		setForeground(UIManager.getColor("inactiveCaptionBorder"));
		// new
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(false);

		setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		setType(Type.POPUP);
		setBackground(new Color(255, 192, 203));
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1380, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		// set size
		desktopPane.setBounds(0, 31, 1600, 900);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(-5, -26, 1372, 710);
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);

//		===== Xu ly ========
		// ==================Hệ thống==========================-

		frmTrangChu = new FrmTrangChu(maNV);
		desktopPane.add(frmTrangChu);

//		====== xe ===========
		frmXe = new FrmXe();
		desktopPane.add(frmXe);

		// === phutung
		frmPhuTung = new FrmPhuTung();
		desktopPane.add(frmPhuTung);

		frmQLNhanVien = new FrmQLNhanVien();
		// desktopPane.add(frmQLNhanVien);

		mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setBounds(210, 60, 137, 26);
		desktopPane.add(mntmNewMenuItem_2);
		frmTrangChu.setVisible(true);

		// ==============================Menu======================--

		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 1186, 32);
		contentPane.add(pMenu);
		pMenu.setLayout(new CardLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("window"));
		pMenu.add(menuBar, "name_417659960722100");

//				==========================================================
// 				==== menuhe thong
//				====item trangchuc
		mnHeThong = new JMenu("H\u1EC7 Th\u1ED1ng");
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHeThong.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuHeThong.png")));
		menuBar.add(mnHeThong);
		mntmTrangChu = new JMenuItem("Trang ch\u1EE7");
		mntmTrangChu.setBackground(new Color(135, 206, 250));
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anTatCa();
				chinhMau();
				frmTrangChu.setVisible(true);
				mntmTrangChu.setBackground(new Color(135, 206, 250));
			}
		});

		mntmTrangChu.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemTrangChu.png")));
		mnHeThong.add(mntmTrangChu);

//				=== item dang xuat
		JMenuItem mntmDangXuat = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					
			}
		});
		mntmDangXuat.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemDangXuat.png")));
		mnHeThong.add(mntmDangXuat);

//				=== itemItemThoat
		JMenuItem mntmThoat = new JMenuItem("Tho\u00E1t");
		mntmThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmThoat.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemThoat.png")));
		mnHeThong.add(mntmThoat);

//				===== MENU DANH MỤC
		mnDanhMuc = new JMenu("Danh mục");
		mnDanhMuc.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuDanhMuc.png")));
		menuBar.add(mnDanhMuc);
//		=== xe
		JMenuItem mntmXe = new JMenuItem("    Xe  ");
		mntmXe.setIcon(new ImageIcon(FrmTong.class.getResource("/image/motorbike.png")));
		mntmXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anTatCa();
				chinhMau();
				frmXe.setVisible(true);
				frmXe.setBackground(new Color(135, 206, 250));
				try {
					frmXe.loadDatatoTable();
					frmXe.loadCboHangXe();
					frmXe.loadCboLoaiXe();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		mnDanhMuc.add(mntmXe);
//		== item laoi xe
		JMenuItem mntmLoaiXe = new JMenuItem("Loại xe");
		mntmLoaiXe.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemDMSP.png")));
		mnDanhMuc.add(mntmLoaiXe);
//		==== hãng xe
		JMenuItem mntmHangXe = new JMenuItem("Hãng xe");
		mntmHangXe.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemDMNCC.png")));
		mnDanhMuc.add(mntmHangXe);
//		==== phụ tụng 
		JMenuItem mntmPhuTung = new JMenuItem("Phụ tùng");
		mntmPhuTung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anTatCa();
				chinhMau();
				frmPhuTung.setVisible(true);
				frmPhuTung.setBackground(new Color(135, 206, 250));
				try {
					frmPhuTung.loadDatatoTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmPhuTung.setIcon(new ImageIcon(FrmTong.class.getResource("/image/helmet.png")));
		mnDanhMuc.add(mntmPhuTung);
//		===== Khách hàng
		mntmDM_KH = new JMenuItem("Khách hàng");
		mntmDM_KH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mntmDM_KH.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemQLKH.png")));
		mnDanhMuc.add(mntmDM_KH);
//		=== Nhân viên
		mntmDM_NV = new JMenuItem("Nhân viên");
		mntmDM_NV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				anTatCa();
				chinhMau();

				frmQLNhanVien.setVisible(true);
				frmQLNhanVien.setBackground(new Color(135, 206, 250));

			}
		});
		mntmDM_NV.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemQLNV.png")));
		mnDanhMuc.add(mntmDM_NV);

////				====item danh muc Xe

//		=== menu XỬ LÝ
		mnXuLy = new JMenu("Xử lý");
		mnXuLy.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuXuLy.png")));
		menuBar.add(mnXuLy);

//		=== item thêm đơn đặt hàng
		mntmTao_DH = new JMenuItem("Thêm đơn hàng");
		mntmTao_DH.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemTaoDH.png")));
		mntmTao_DH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mnXuLy.add(mntmTao_DH);

//		=== item thêm hóa đơn
		mntmTao_HD = new JMenuItem("Thêm hóa đơn");
		mntmTao_HD.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemTaoHD.png")));
		mntmTao_HD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//=====
			}
		});
		mnXuLy.add(mntmTao_HD);

		mntmBaoHanh = new JMenuItem("Thêm bảo hành");
		mntmBaoHanh.setIcon(new ImageIcon(FrmTong.class.getResource("/image/car-insurance.png")));
		mnXuLy.add(mntmBaoHanh);

//		==== danh mục tìm kiếm thông tin
		mnTimKiem = new JMenu("Tìm kiếm thông tin");
		mnTimKiem.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuTimKiem.png")));
		menuBar.add(mnTimKiem);

//		=== tìm kiếm xe
		mntmTimKiem_SP = new JMenuItem("Tìm kiếm Xe");
		mntmTimKiem_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTimKiemXe frmTimKiem = new FrmTimKiemXe();
				frmTimKiem.pack();
				frmTimKiem.setBounds(0, 20, 1600, 800);
				frmTimKiem.setBackground(new Color(135, 206, 250));
				frmTimKiem.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				frmTimKiem.setFocusCycleRoot(true);
				frmTimKiem.setFocusableWindowState(true);
				frmTimKiem.setVisible(true);
				frmTimKiem.loadCboGiaTien();
				frmTimKiem.loadCboHangXe();
				frmTimKiem.loadCboLoaiXe();
				try {
					frmTimKiem.loadDatatoTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmTimKiem_SP.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemTKS.png")));
		mnTimKiem.add(mntmTimKiem_SP);

//		=== item tiem kiem phu tung
		mntmTimKiem_SP = new JMenuItem("Tìm kiếm Phụ tùng");
		mntmTimKiem_SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

//		=== item tim kiem khach hang
		mntmTimKiem_KH = new JMenuItem("Tìm kiếm khách hàng");
		mntmTimKiem_KH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mntmTimKiem_KH.setIcon(new ImageIcon(FrmTong.class.getResource("/image/MenuItemTimKiemKH.png")));
		mnTimKiem.add(mntmTimKiem_KH);

	}

	void anTatCa() {
		frmTrangChu.setVisible(false);
		frmXe.setVisible(false);
		frmPhuTung.setVisible(false);
	}

	void chinhMau() {
		// mntmDangKyCaNhanVien.setBackground(new Color(240,240,240));
		mntmTrangChu.setBackground(new Color(240, 240, 240));
		mntmDM_NV.setBackground(new Color(240, 240, 240));
		mntmDM_KH.setBackground(new Color(240, 240, 240));
		mntmTao_DH.setBackground(new Color(240, 240, 240));
		mntmTao_HD.setBackground(new Color(240, 240, 240));
		mntmTimKiem_KH.setBackground(new Color(240, 240, 240));
		mntmTimKiem_SP.setBackground(new Color(240, 240, 240));
	}
}
