package day07.homework.Topic2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import day07.homework.app.BaseDao;

public class OrderDao extends BaseDao {

	public int addOrderBy(Order order) {
		if (null == order) {
			return -1;
		}
		int result = 0;
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = getConn();
			state = conn.prepareStatement(
					"insert into order_info(order_id,order_amount,order_user_id,order_user_name,order_merchant_id,order_merchant_name) values(?,?,?,?,?,?)");
			state.setInt(1, order.getOrderId());
			state.setBigDecimal(2, order.getOrderAmount());
			state.setInt(3, order.getOrderUserId());
			state.setString(4, order.getOrderUserName());
			state.setDouble(5, order.getOrderMerchantId());
			state.setString(6, order.getOrderMerchantName());

			int effectRow = state.executeUpdate();
			result = effectRow;
			if (effectRow > 0) {
				System.out.println("Order add Success");
			} else {
				System.out.println("Order add Error");
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

	public int updateOrderBy(Order order) {
		if (null == order) {
			return -1;
		}
		int result = 0;
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = getConn();
			state = conn.prepareStatement(
					"update order_info set order_amount = ?,order_user_id = ?,order_user_name = ?, order_merchant_id = ?,order_merchant_name = ? where order_id = ?");

			state.setBigDecimal(1, order.getOrderAmount());
			state.setInt(2, order.getOrderUserId());
			state.setString(3, order.getOrderUserName());
			state.setDouble(4, order.getOrderMerchantId());
			state.setString(5, order.getOrderMerchantName());

			state.setInt(6, order.getOrderId());

			int effectRow = state.executeUpdate();
			result = effectRow;
			if (effectRow > 0) {
				System.out.println("Order update Success");
			} else {
				System.out.println("Order update Error");
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

	public int deleteOrderBy(Order order) {
		if (null == order) {
			return -1;
		}
		int result = 0;
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = getConn();
			state = conn.prepareStatement("delete from order_info where order_id = ?");
			state.setInt(1, order.getOrderId());

			int effectRow = state.executeUpdate();
			result = effectRow;
			if (effectRow > 0) {
				System.out.println("Order delete Success");
			} else {
				System.out.println("Order delete Error");
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

	public List<Order> queryOrderByMap(HashMap condMap) {
		List<Order> result = new ArrayList<>();
		if (null == condMap) {
			return null;
		}
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = getConn();
			String sql = "select * from order_info";
			state = conn.prepareStatement(sql);

			ResultSet resultSet = state.executeQuery();
			while (resultSet.next()) {
				int orderId = resultSet.getInt("order_id");
				BigDecimal orderAmount = resultSet.getBigDecimal("order_amount");
				int orderUserId = resultSet.getInt("order_user_id");
				String orderUserName = resultSet.getString("order_user_name");
				int orderMerchantId = resultSet.getInt("order_merchant_id");
				String orderMerchantName = resultSet.getString("order_merchant_name");
				Order order = new Order(orderId, orderAmount, orderUserId, orderUserName, orderMerchantId,
						orderMerchantName);
				result.add(order);
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
