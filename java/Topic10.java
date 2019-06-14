import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 作业10: 集合作业(需要提前学习下 List,Map等基本用法)
 *
 * - 定义一个对象,User,属性有 name,age,score,gender
 *
 * - 使用集合ArrayList,来装一批User, 数据可以随意
 *
 * - 要求1: 遍历集合,打印所有内部数据
 *
 * - 要求2: 按照年纪(age)进行分组,比如23岁,有3个人, 24岁有5个人,
 *
 * - 要求3: 按照分数(score)范围分组, 比如 60-70, 有一组人, 70-80有一组人
 *
 * - 要求4: 基于分数排序, 由高到低
 *
 * - 要求5: 基于性别分组,求男同学的平均分,求女同学的平均分
 *
 * @author haoc
 */
public class Topic10 {

	public class User {
		private String name;
		private String gender;
		private int age;
		private int score;
		
		public User(String name, String gender, int age, int score) {
			this.name = name;
			this.score = score;
			this.age = age;
			this.gender = gender;
		}
		
		public void displayUser() {
			System.out.println("name=" + this.name + ",age=" + String.valueOf(this.age) + ",gender=" + this.gender + ",score=" + String.valueOf(this.score));
		}
		
		public String getScoreGroup() {
			String result = "0~9";
			int myScoreGroup = this.score / 10 ;
			result = myScoreGroup*10 + "~" + (myScoreGroup*10+9);
			return result;
		}
	}
	
	@Test
	public void userTest() {
		List<User> userList = new ArrayList<>();
		//创建用户
		for (int i = 0; i < 6; i++) {
			String gender = "女";
			int age = 18;
			int score = 60;
			if (i % 2 == 0) {
				gender = "男";
				score = 60;
			}
			if (i % 3 == 0) {
				age = 20;
			}
			if (i % 3 == 0) {
				score = 70;
			}
			User tmpUser = new User("小李"+i,gender , age, score+i);
			userList.add(tmpUser);
			tmpUser.displayUser();
			tmpUser.getScoreGroup();
		}
		//按年龄分组用户
		Map<Integer, List<User>> ageTypeMap = new HashMap<>();
		for (int i = 0; i < userList.size(); i++) {
			User tmpUser = userList.get(i);
			if (!ageTypeMap.containsKey(tmpUser.age)) {
				List<User> userTmpList = new ArrayList<>();
				userTmpList.add(tmpUser);
				ageTypeMap.put(tmpUser.age, userTmpList);
			} else {//存在相同的年龄则放到一起
				List<User> userTmpList = new ArrayList<>();
				userTmpList = ageTypeMap.get(tmpUser.age);
				userTmpList.add(tmpUser);
				ageTypeMap.put(tmpUser.age, userTmpList);
			}
		}
		System.out.println("按年龄分组的数量是:" + ageTypeMap.size());
		
		//按照分数段分组，每10分一个小分段。例如，0~9,10~19,20~29 ...
		Map<String, List<User>> scoreTypeMap = new HashMap<>();
		for (int i = 0; i < userList.size(); i++) {
			User tmpUser = userList.get(i);
			if (!scoreTypeMap.containsKey(tmpUser.getScoreGroup())) {
				List<User> userTmpList = new ArrayList<>();
				userTmpList.add(tmpUser);
				scoreTypeMap.put(tmpUser.getScoreGroup(), userTmpList);
			} else {//存在相同的分数分组则放到一起
				List<User> userTmpList = new ArrayList<>();
				userTmpList = scoreTypeMap.get(tmpUser.getScoreGroup());
				userTmpList.add(tmpUser);
				scoreTypeMap.put(tmpUser.getScoreGroup(), userTmpList);
			}
		}
		System.out.println("按分数分组的数量是:" + scoreTypeMap.size() + ",具体分组key是:" + scoreTypeMap.keySet());
		
		//基于分数由高向低排列
		Collections.sort(userList, new Comparator<User>() {
			public int compare(User userA, User userB) {
				if (userA.score > userB.score) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		System.out.println("用户按分数排序后的输出:");
		for (User user:userList) {
			user.displayUser();
		}
		
		//按照性别分组，分别求平均分
		Map<String, List<User>> genderTypeMap = new HashMap<>();
		for (int i = 0; i < userList.size(); i++) {
			User tmpUser = userList.get(i);
			if (!genderTypeMap.containsKey(tmpUser.gender)) {
				List<User> userTmpList = new ArrayList<>();
				userTmpList.add(tmpUser);
				genderTypeMap.put(tmpUser.gender, userTmpList);
			} else {//存在相同的分数分组则放到一起
				List<User> userTmpList = new ArrayList<>();
				userTmpList = genderTypeMap.get(tmpUser.gender);
				userTmpList.add(tmpUser);
				genderTypeMap.put(tmpUser.gender, userTmpList);
			}
		}
		//计算平均分 遍历map
		for(Map.Entry<String, List<User>> entry: genderTypeMap.entrySet()) {
			List<User> tmpUserList = new ArrayList<>();
			tmpUserList = entry.getValue();
			int scoreCount = 0;
			for (int i = 0; i < tmpUserList.size(); i++) {
				scoreCount += tmpUserList.get(i).score;
			}
			System.out.println("用户性别为:" + entry.getKey() + ",平均分是:" + scoreCount/tmpUserList.size());
		}	
	}
	
/*output
name=小李0,age=20,gender=男,score=70
name=小李1,age=18,gender=女,score=61
name=小李2,age=18,gender=男,score=62
name=小李3,age=20,gender=女,score=73
name=小李4,age=18,gender=男,score=64
name=小李5,age=18,gender=女,score=65
按年龄分组的数量是:2
按分数分组的数量是:2,具体分组key是:[60~69, 70~79]
用户按分数排序后的输出:
name=小李1,age=18,gender=女,score=61
name=小李2,age=18,gender=男,score=62
name=小李4,age=18,gender=男,score=64
name=小李5,age=18,gender=女,score=65
name=小李0,age=20,gender=男,score=70
name=小李3,age=20,gender=女,score=73
用户性别为:女,平均分是:66
用户性别为:男,平均分是:65

*/
}
