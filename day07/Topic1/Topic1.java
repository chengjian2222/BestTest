package day07.homework.Topic1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 回顾之前的一个作业, day02/homework.Topic11
 *
 * 从文件取出数据之后,将数据放到数据库中去,
 *
 * 注: 注意代码的健壮性 以及 编写相应的测试用例
 *
 * 要求: 经过几天的代码编写, 请尽量用一些设计的手段进去
 *
 * @author 成建
 */
public class Topic1 {

	public static void main(String[] args) {

		String filePath = "src/day07/homework/user.txt";

		List<String> userStrList = getUserListBy(filePath);

		List<User> users = praseUserBy(userStrList);

		// 3. 存入数据库
		UserDao dao = new UserDao();
		if (null != users) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				int resutl = dao.addUserBy(user);
				if (resutl > 0) {
					System.out.println("第" + i + "个user 插入数据库成功");
				} else {
					System.out.println("第" + i + "个user 插入数据库失败");
				}
			}
		}

	}

	// 1. 读取文件
	public static List<String> getUserListBy(String fileName) {
		ReadFile readFile = new ReadFile();
		List<String> userStrList = null;
		try {
			userStrList = ReadFile.readFileBy("src/day07/homework/user.txt");
			return userStrList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在，请确认后再继续操作");

		}
		return userStrList;
	}

	// 2. 解析数据存放到类
	public static List<User> praseUserBy(List<String> userStrList) {
		List<User> users = new ArrayList<>();
		if (null != userStrList) {
			for (int i = 0; i < userStrList.size(); i++) {
				String[] arr = userStrList.get(i).trim().split(",");
				User user = new User();
				if (arr.length >= 5) {
					user.setId(Integer.parseInt(arr[0]));
					user.setName(arr[1]);
					user.setGender(arr[2]);
					user.setScore(Integer.parseInt(arr[3]));
					user.setAddress(arr[4]);
				}
				System.out.println("Index = " + i + "," + user.toString());
				users.add(user);
			}
		}
		return users;
	}

}

/**
 * output +----+--------+--------+-------+---------+ | id | name | gender |
 * score | address | +----+--------+--------+-------+---------+ | 1 | 小李 | 男 |
 * 100 | 北京 | | 2 | 小明 | 男 | 80 | 上海 | | 3 | 小红 | 女 | 90 | 广州 | | 4 | 王二 | 男 |
 * 100 | 深圳 | | 5 | 李四 | 男 | 60 | 深圳 | | 6 | 张三 | 女 | 10 | 北京 | | 7 | 小七 | 女 |
 * 70 | 上海 | +----+--------+--------+-------+---------+ 7 rows in set (0.00 sec)
 * 
 */
