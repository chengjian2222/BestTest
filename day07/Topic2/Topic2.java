/**
 * 实现订单管理系统
 *
 * 订单数据:
 *    order_id,  唯一
 *    order_amount(订单金额),
 *    order_user_id(订单付款人id),
 *    order_user_name(订单付款人名字),
 *    order_merchant_id(订单商家id)
 *    order_merchant_name(订单商家名称)
 *
 * 要求:
 *  提供一个机遇客户端输入(Scaner)的程序,界面程序,给出相关选项
 *  如界面如下:
 *      1.创建订单
 *      2.修改订单
 *      3.删除订单
 *      4.查询订单
 *
 *
 *  生成订单,
 *  修改订单,基于order_id进行修改,可能修改的是金额,也可能是其他字段,具体修改啥,不确定
 *  删除订单,基于order_id进行删除
 *  查询,可以查询一条,基于order_id
 *  也可以基于其他字段,查询多条
 *
 * @author 成建
 */
package day07.homework.Topic2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Topic2 {

	private static Scanner scan;
	private static OrderDao dao;

	public static void main(String[] args) {
		startOrderManager();
	}

	public static void startOrderManager() {
		scan = new Scanner(System.in);
		setDao(new OrderDao());
		printMenu();
		// 判断是否还有输入
		while (scan.hasNext()) {
			String value = scan.next();
			if (value.equals("q")) {
				System.out.println("退出系统成功");
				break;
			} else if (isInteger(value)) {
				System.out.println("输入的数据为：" + value);
				switch (Integer.valueOf(value)) {
				case 1: {
					System.out.println("创建订单");
					BigDecimal amout = new BigDecimal(1000);
					Order order = new Order(1, amout, 1001, "小花", 10001, "大理酸汤鱼店");
					dao.addOrderBy(order);
					break;
				}
				case 2: {
					System.out.println("修改订单");
					BigDecimal amout = new BigDecimal(1);
					Order order = new Order(1, amout, 1001, "小花", 10001, "大理酸汤鱼店新店");
					dao.updateOrderBy(order);
					break;
				}
				case 3: {
					System.out.println("删除订单");
					Order order = new Order();
					order.setOrderId(1);
					dao.deleteOrderBy(order);
					break;
				}
				case 4: {
					System.out.println("查询订单");
					HashMap<String, String> condMap = new HashMap<>();
					condMap.put("order_id", "1");
					List<Order> orders = dao.queryOrderByMap(condMap);
					if (orders.size() > 0) {
						for (int i = 0; i < orders.size(); i++) {
							System.out.println(orders.get(i));
						}
					} else {
						System.out.println("暂无订单\n");
					}

					break;
				}
				default:
					System.out.println("对不起，这个功能还没有开放");
					break;
				}

				printMenu();
			} else {
				System.out.println("你输入的字符有误，请输入1~4之间的数字选择功能或者q退出");
			}

		}

	}

	public static void printMenu() {
		System.out.println("欢迎进入XX订单管理系统");
		System.out.println("1.创建订单\n2.修改订单\n3.删除订单\n4.查询订单\n5.退出请按q");
		System.out.println("请输入菜单项对应的数字继续操作：");
	}

	// 判断字符串是否纯数字
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static OrderDao getDao() {
		return dao;
	}

	public static void setDao(OrderDao dao) {
		Topic2.dao = dao;
	}
}

/*
欢迎进入XX订单管理系统
1.创建订单
2.修改订单
3.删除订单
4.查询订单
5.退出请按q
请输入菜单项对应的数字继续操作：
4
输入的数据为：4
查询订单
Order [orderId=1, orderAmount=1000, orderUserId=1001, orderUserName=小花, orderMerchantId=10001.0, orderMerchantName=大理酸汤鱼店]
欢迎进入XX订单管理系统
1.创建订单
2.修改订单
3.删除订单
4.查询订单
5.退出请按q
请输入菜单项对应的数字继续操作：
2
输入的数据为：2
修改订单
Order update Success
欢迎进入XX订单管理系统
1.创建订单
2.修改订单
3.删除订单
4.查询订单
5.退出请按q
请输入菜单项对应的数字继续操作：
4
输入的数据为：4
查询订单
Order [orderId=1, orderAmount=1, orderUserId=1001, orderUserName=小花, orderMerchantId=10001.0, orderMerchantName=大理酸汤鱼店新店]
欢迎进入XX订单管理系统
1.创建订单
2.修改订单
3.删除订单
4.查询订单
5.退出请按q
请输入菜单项对应的数字继续操作：
****/
