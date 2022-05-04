package Support;

public class CheckInput {
	/**
	 * Launch the application.
	 * Tên: Võ Thị Trà Giang
	 * Ngày tạo: 16/04/2022
	 */
	public static boolean checkInteger(String item) {
		boolean check = false;
		int n = 0;
		try {
			n = Integer.parseInt(item);
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
	
	public static boolean checkDouble(String item) {
		boolean check = false;
		double n = 0;
		try {
			n = Double.parseDouble(item);
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
	
	
}
