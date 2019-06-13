import java.util.Set;

import org.junit.Test;

/**
 * 作业8: 回想下面向对象练习的时候,我们设计的老师类和学生类,好多重复的属性和方法
 *
 * - 使用面向对象中的继承来抽象老师和学生更高一层的类,父类
 *
 * - 让相同的属性和方法可以抽离到父类中
 *
 * @author haoc
 */
public class Topic8 {

	public class People {
		public int age;
		public String name;
		public String sex;
		public People (int age, String name, String sex) {
			this.age = age;
			this.name = name;
			this.sex = sex;
		}
		
		public void eat() {
			System.out.println("姓名：" + this.name + ",性别:" + this.sex + ",年龄:" + this.age + ",吃东西");
		}
		public void eat(String someth) {
			System.out.println("姓名：" + this.name + ",性别:" + this.sex + ",年龄:" + this.age + ",吃:" +someth);
		}
		
		public void sleep() {
			System.out.println("睡觉");
		}
	}
	
	public class Teacher extends People {

		public Teacher(int age, String name, String sex) {
			super(age, name, sex);
			// TODO Auto-generated constructor stub
		}
		
		public void eat(String someth) {
			System.out.println("姓名：" + this.name + ",性别:" + this.sex + ",年龄:" + this.age + ",老师吃:" +someth);
		}
	}
	
	public class Student extends People {

		public Student(int age, String name, String sex) {
			super(age, name, sex);
			// TODO Auto-generated constructor stub
		}
		public void eat(String someth) {
			System.out.println("姓名：" + this.name + ",性别:" + this.sex + ",年龄:" + this.age + ",学生吃:" +someth);
		}
		
	}
	
	@Test
	public void userTest() {
		Teacher teacher = new Teacher(28, "李老师", "男");
		teacher.eat();
		teacher.eat("小龙虾");
		teacher.sleep();
		
		Student student = new Student(18, "小花", "女");
		student.eat("甜甜圈");
	}
/* output
姓名：李老师,性别:男,年龄:28,吃东西
姓名：李老师,性别:男,年龄:28,老师吃:小龙虾
睡觉
姓名：小花,性别:女,年龄:18,学生吃:甜甜圈
*/
}
