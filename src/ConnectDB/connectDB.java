package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
public static Connection getConnection() throws ClassNotFoundException, SQLException {
	Connection conn;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangXe","sa","sapassword");
	if(conn!=null) {
		System.out.println("Connect success");
	}
	return conn;
}
}
