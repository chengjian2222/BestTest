import org.junit.Test;
/**
 * 作业7: 老师在黑板画圆
 *
 * 要求: 按照面向对象的思想设计
 *
 * - 老师不一定只会画圆,还可能会画正方形
 *
 * - 老师也可能会画大脸猫
 *
 * - 老师不见得只会在黑板上画,也可以在纸上画
 *
 * - 黑板只能用来画圆吗? 黑板还可以做题的
 *
 * - 圆形,也不是随便画的, 它还有圆心,有半径
 *
 * ----- 思考以上问题,在来设计, 看不懂的就多想想,让自己想5遍以上,如果还是想不明白,再来问老师
 *
 * @author haoc
 */
public class Topic7 {

	/*
	 * 教师类
	 */
	public class Teacher {
		public void draw(String content) {
			System.out.println("老师: " + content);
		}
		
		public void draw(String content, String location) {
			System.out.println("老师画: " + content + "在" + location);
		}
		
		public void draw (Backboard backboard,int radius,CircleCentre center) {
			Roundness roundness = new Roundness(radius, center);
			System.out.println("老师" + backboard.draw(roundness));
		}
	}
	
	/*
	 * 黑板类
	 */
	public class Backboard {
		public String draw(Roundness round) {
			String value = "在黑板上画->圆:半径=" + round.getRadius() + ",圆心=(" 
					+ round.getCircleCentre().x + "," 
					+ round.getCircleCentre().y + ")";
			return value;
		}
		
		public String doExercise() {
			String value = "在黑板上做题";
			return value;
		}
	}
	
	/*
	 * 圆形类
	 */
	public class Roundness {
		public int radius;
		public CircleCentre circleCentre;
		
		public Roundness(int radius,CircleCentre circleCentre) {
			this.radius = radius;
			this.circleCentre = circleCentre;
		}
		
		public void setRadius(int radius) {
			this.radius = radius;
		}
		
		public int getRadius() {
			return this.radius;
		}
		
		public void setCircleCentre(CircleCentre circleCentre) {
			circleCentre = this.circleCentre;
		}
		
		public CircleCentre getCircleCentre() {
			 return this.circleCentre;
		}
	}
	
	/*
	 * 圆心
	 */
	public class CircleCentre {
		public int x;
		public int y;
		
		public CircleCentre (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	/*
	 * 测试用例
	 */
	@Test
	public void userTest(){
		Teacher teacher = new Teacher();
		teacher.draw(new Backboard(),10,new CircleCentre(0, 0));
		teacher.draw("大脸猫");
		teacher.draw("正方形");
		teacher.draw(new Backboard().doExercise());
		teacher.draw("圆", "纸上");
	}
	
	/*
	 	老师在黑板上画->圆:半径=10,圆心=(0,0)
		老师: 大脸猫
		老师: 正方形
		老师: 在黑板上做题
		老师画: 圆在纸上
	 */
}
