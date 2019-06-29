package day04.homework;
/**
 * 曾经的一个作业题, day02/Topic11
 * 作业11: I/O + 集合 + 对象 练习题
 *
 * 文件: 位置随意,数据格式: id, name, gender, score, address
 *
 * 读取出数据之后,放到对象中User
 *
 * 在将User放入集合中
 *
 * 集合中的User,按照address,gender,分组,且每个组内的分数还要排序
 *
 * - 如: 北京,男 ; 上海,女
 *  成建
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Topic03 {
	
	private static BufferedReader reader;

	public static void main(String[] args) throws Exception {
		String filePath = "/Users/chengjian/Documents/user.txt";
		reader = new BufferedReader(new FileReader(filePath));
		String value = "";
		
		Map<String,User> userMap = new HashMap<>();
		while ((value = reader.readLine()) != null) {
		    String[] strings = value.trim().split(",");
		    User tmpUser = new User(strings[0], strings[1], strings[2], Integer.valueOf(strings[3]), strings[4]);
		    userMap.put(strings[0], tmpUser);
		}
		
		//按照 address分组
		System.out.println("按地址分组");
		Map<String, List<User>> addressGroup = new HashMap<>();
		for (Entry<String, User> entry : userMap.entrySet()) {
			User user = entry.getValue();
			if (addressGroup.containsKey(user.getAddress())) {
				addressGroup.get(user.getAddress()).add(user);
			}else {
				List<User> list = new ArrayList<>();
				list.add(user);
				addressGroup.put(user.getAddress(), list);
			}
		}
		foreach(addressGroup);
		
		//按性别分组
		System.out.println("按性别分组");
		Map<String, List<User>> genderGroup = new HashMap<>();
		for (Entry<String, User> entry : userMap.entrySet()) {
			User user = entry.getValue();
			if (genderGroup.containsKey(user.getGender())) {
				genderGroup.get(user.getGender()).add(user);
			}else {
				List<User> list = new ArrayList<>();
				list.add(user);
				genderGroup.put(user.getGender(), list);
			}
		}
		foreach(genderGroup);
	}
	
	private static void foreach(Map<String, List<User>> userMap) {
	    for (Entry<String, List<User>> entry : userMap.entrySet()) {
	      String key = entry.getKey();
	      System.out.println("key = " + key);

	      final List<User> userList = entry.getValue();
	      //按年龄排序
	      Collections.sort(userList,Comparator.comparing(User::getScore));
	      for (User user : userList) {
	        System.out.println("\t user:" + user);
	      }
	    
	    }
	  }
	
/* out put
按地址分组
key = 广州;
	 user:id = U004,name = 小张,gender = 男,score = 90,address = 广州;
key = 北京;
	 user:id = U002,name = 小红,gender = 女,score = 80,address = 北京;
key = 上海;
	 user:id = U005,name = 小王,gender = 男,score = 10,address = 上海;
	 user:id = U007,name = 小刘,gender = 男,score = 12,address = 上海;
	 user:id = U008,name = 小胡,gender = 男,score = 23,address = 上海;
	 user:id = U003,name = 小李,gender = 男,score = 70,address = 上海;
	 user:id = U006,name = 小周,gender = 男,score = 99,address = 上海;
	 user:id = U001,name = 小明,gender = 男,score = 100,address = 上海;
按性别分组
key = 女
	 user:id = U002,name = 小红,gender = 女,score = 80,address = 北京;
key = 男
	 user:id = U005,name = 小王,gender = 男,score = 10,address = 上海;
	 user:id = U007,name = 小刘,gender = 男,score = 12,address = 上海;
	 user:id = U008,name = 小胡,gender = 男,score = 23,address = 上海;
	 user:id = U003,name = 小李,gender = 男,score = 70,address = 上海;
	 user:id = U004,name = 小张,gender = 男,score = 90,address = 广州;
	 user:id = U006,name = 小周,gender = 男,score = 99,address = 上海;
	 user:id = U001,name = 小明,gender = 男,score = 100,address = 上海;
 * */
	
	
}
