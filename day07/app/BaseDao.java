package day07.homework.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	final private static String URL = "jdbc:mysql://127.0.0.1:3306/infodatabase?characterEncoding=GBK";
	final private static String USER = "root";
	final private static String PASSWORD = "Cj199021";

	private Connection conn;

	public static Connection getConn() throws ClassNotFoundException, SQLException {
		// 1.加载数据访问驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2.连接到数据"库"上去
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
