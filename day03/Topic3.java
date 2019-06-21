package day03.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 定义一个Map,key是userId,value是User,要求遍历整个Map的数据
 * User{String userId,String name,int age,Map<String,List<String>> hobby}
 * auth:成建
 */
public class Topic3 {
	
	public static void main(String[] args) {
		//创建User
		Topic3 topic3 = new Topic3();
		Map<String,User> userMap = topic3.initUser();
		
		//按年龄分组排序
		topic3.groupByAge(userMap);
		
		//按兴趣分组排序
		topic3.groupByHobby(userMap);
	}

	public Map<String,User> initUser() {
		Map<String,User> userMap = new HashMap<>();
		Map<String, List<String>> hobby = new HashMap<String, List<String>>();
		Map<String, List<String>> hobby2 = new HashMap<String, List<String>>();
		for (int i = 0; i < 2; i++) {
			List<String> contentList = new ArrayList();
			List<String> contentList2 = new ArrayList();
			if (i == 1) {
				contentList.add("测试秘籍");
				contentList.add("从删除到跑路");
				hobby.put("书籍", contentList);
				contentList2.add("盗梦空间");
				contentList2.add("泰坦尼克号");
				hobby2.put("电影", contentList2);
			}
			else {
				contentList.add("金瓶梅");
				contentList.add("春闺秘史");
				contentList.add("如何重整男人雄峰");
				hobby.put("文学", contentList);
			}
			
		}
		
		Topic3 topic3 = new Topic3();
		User user = topic3.new User("0U001", "大叔", 18,hobby);
		User user1 = topic3.new User("0U002", "小叔", 21,hobby);
		User user2 = topic3.new User("0U003", "隔壁老王", 45,hobby2);
		User user3 = topic3.new User("0U004", "老李", 28,hobby);
		User user4 = topic3.new User("0U005", "小明", 27,hobby);

		userMap.put(user.userId, user);
		userMap.put(user1.userId, user1);
		userMap.put(user2.userId, user2);
		userMap.put(user3.userId, user3);
		userMap.put(user4.userId, user4);
		
		for (String key : userMap.keySet()) {
			User tmpUser = userMap.get(key);
			System.out.println(tmpUser.toString());
		}
		return userMap; 
	}
	
	public void groupByAge(Map<String,User> userMap) {
		Map<String, List<User>> ageGroupUserMap = new HashMap<String, List<User>>();
		for (String key : userMap.keySet()) {
			User tmpUser = userMap.get(key);
			if (tmpUser.getAge() < 20) {
				List<User> tmp = new ArrayList<>();
				tmp = ageGroupUserMap.get("青年");
				if (tmp == null) {
					tmp = new ArrayList<>();
				}
				tmp.add(tmpUser);
				ageGroupUserMap.put("青年", tmp);
			} else if (tmpUser.getAge() < 30) {
				List<User> tmp = new ArrayList<>();
				tmp = ageGroupUserMap.get("中年");
				if (tmp == null) {
					tmp = new ArrayList<>();
				}
				tmp.add(tmpUser);
				ageGroupUserMap.put("中年", tmp);
			} else {
				List<User> tmp = new ArrayList<>();
				tmp = ageGroupUserMap.get("老年");
				if (tmp == null) {
					tmp = new ArrayList<>();
				}
				tmp.add(tmpUser);
				ageGroupUserMap.put("老年", tmp);
			}
		}
		System.out.println("按年龄段分组排序如下:");
		for (String key : ageGroupUserMap.keySet()) {
			List<User> tmpUserList = ageGroupUserMap.get(key);
			String value = "";
			for (int i = 0; i < tmpUserList.size(); i++) {
				value += tmpUserList.get(i).toString() + "\n";
			}
			System.out.println("key = " + key + ",value = \n" + value);
		}
	}
	
	public void groupByHobby(Map<String, User> userMap) {
		// TODO Auto-generated method stub
		Map<String, List<User>> hobbyGroupUserMap = new HashMap<String, List<User>>();
		for (String key : userMap.keySet()) {
			User tmpUser = userMap.get(key);
			Map<String, List<String>> hobbyMap = tmpUser.hobbyMap;
			for(String keyStr : hobbyMap.keySet()) {
				if(keyStr.equals("文学")) {
					List<User> tmp = new ArrayList<>();
					tmp = hobbyGroupUserMap.get("文学");
					if (tmp == null) {
						tmp = new ArrayList<>();
					}
					tmp.add(tmpUser);
					hobbyGroupUserMap.put("文学", tmp);
					break;
				}else if( keyStr.equals("电影")) {
					List<User> tmp = new ArrayList<>();
					tmp = hobbyGroupUserMap.get("电影");
					if (tmp == null) {
						tmp = new ArrayList<>();
					}
					tmp.add(tmpUser);
					hobbyGroupUserMap.put("电影", tmp);
					break;
				}
			}
		}
		System.out.println("按兴趣爱好排序如下:");
		for (String key : hobbyGroupUserMap.keySet()) {
			List<User> tmpUserList = hobbyGroupUserMap.get(key);
			String value = "";
			for (int i = 0; i < tmpUserList.size(); i++) {
				value += tmpUserList.get(i).toString() + "\n";
			}
			System.out.println("key = " + key + ",value = \n" + value);
		}
	}

	class User {
		private String userId;
		private String name;
		private int age;
		private Map<String, List<String>> hobbyMap;
		
		public User(String userId, String name, int age, Map<String, List<String>> hobbyMap) {
			super();
			this.userId = userId;
			this.name = name;
			this.age = age;
			this.hobbyMap = hobbyMap;
		}
		
		public void displayUser() {
			String result = "";
			for(String key:this.hobbyMap.keySet()) {
				List<String> content = this.hobbyMap.get(key);
				String tmpContent = "";
				for (int i = 0; i < content.size(); i++) {
					tmpContent += content.get(i) + ",";
				}
				tmpContent = tmpContent.substring(0, tmpContent.length() - 1);
				result += key + "=[" + tmpContent + "],";
			}
			result = result.substring(0, result.length() - 1);
			result = this.userId + "," + this.name + ",hobby（" + result + ")";
			System.out.println(result);
		}
		
		public String toString() {
			String result = "";
			for(String key:this.hobbyMap.keySet()) {
				List<String> content = this.hobbyMap.get(key);
				String tmpContent = "";
				for (int i = 0; i < content.size(); i++) {
					tmpContent += content.get(i) + ",";
				}
				tmpContent = tmpContent.substring(0, tmpContent.length() - 1);
				result += key + "=[" + tmpContent + "],";
			}
			result = result.substring(0, result.length() - 1);
			result = this.userId + "," + this.name + "," + this.age + ",hobby（" + result + ")";

			return result;
		}
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			if (age < 0 || age > 140) {
				System.out.println(age + "年龄输入不符合规定");
				return;
			}
			this.age = age;
		}
		public Map<String, List<String>> getHobbyMap() {
			return hobbyMap;
		}
		public void setHobbyMap(Map<String, List<String>> hobbyMap) {
			this.hobbyMap = hobbyMap;
		}
		
	}
}

/* out put
 0U004,老李,28,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U003,隔壁老王,45,hobby（电影=[盗梦空间,泰坦尼克号])
0U002,小叔,21,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U001,大叔,18,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U005,小明,27,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
按年龄段分组排序如下:
key = 青年,value = 
0U001,大叔,18,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])

key = 老年,value = 
0U003,隔壁老王,45,hobby（电影=[盗梦空间,泰坦尼克号])

key = 中年,value = 
0U004,老李,28,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U002,小叔,21,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U005,小明,27,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])

按兴趣爱好排序如下:
key = 电影,value = 
0U003,隔壁老王,45,hobby（电影=[盗梦空间,泰坦尼克号])

key = 文学,value = 
0U004,老李,28,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U002,小叔,21,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U001,大叔,18,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
0U005,小明,27,hobby（文学=[金瓶梅,春闺秘史,如何重整男人雄峰],书籍=[测试秘籍,从删除到跑路])
 */
