package day07.homework.Topic1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
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

	public int addUserBy(User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = getConn();
			state = conn.prepareStatement("insert into user(id,name,address,score,gender) values(?,?,?,?,?)");
			state.setInt(1, user.getId());
			state.setString(2, user.getName());
			state.setString(3, user.getAddress());
			state.setInt(4, user.getScore());
			state.setString(5, user.getGender());
			int effectRow = state.executeUpdate();
			result = effectRow;
			if (effectRow > 0) {
				System.out.println("User add Success");
			} else {
				System.out.println("User add Error");
			}

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				if (null != state) {
					state.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

}
