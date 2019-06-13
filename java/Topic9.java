import org.junit.Test;

/**
 * 作业9: 请用面向对象的思路设计: 马路上跑汽车
 *
 * - 马路: 可能是告诉, 也可能是辅路,还可能是乡村公路
 *
 * - 汽车: 可能是宝马, 可能是奔驰, 还可能是奥拓
 *
 * - 请用多态来进行设计
 *
 * @author haoc
 */
public class Topic9 {

	/*
	 * 路
	 */
	public class Road {
		public String type;
		public Road() {
			// TODO Auto-generated constructor stub
			this.type = "马路";
		}
		public Road(String type) {
			this.type = type;
		}
		public String getRoadType() {
			return this.type;
		}
	}
	
	public class FuRoad extends Road {
		public FuRoad() {
			this.type = "辅路";
		}
		public String getRoadType () {
			return this.type;
		}
	}
	
	public class XiaoRoad extends Road {
		public XiaoRoad() {
			this.type = "乡村工路";
		}
		public String getRoadType () {
			return this.type;
		}
	}
	
	/*
	 * 汽车
	 */
	public class Car {
		private String name;
		public Car(String name) {
			// TODO Auto-generated constructor stub
			this.name = "小汽车";
		}
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void run(Road road) {
			System.out.println(road.type + "上跑" + this.getName());
		}
	}
	
	public class BmwCar extends Car {
		public BmwCar(String name) {
			super(name);
			// TODO Auto-generated constructor stub
			setName(name);
		}
	}
	
	public class BenzeCar extends Car {

		public BenzeCar(String name) {
			super(name);
			// TODO Auto-generated constructor stub
			setName(name);
		}
	}
	
	public class AutoCar extends Car {

		public AutoCar(String name) {
			super(name);
			// TODO Auto-generated constructor stub
			setName(name);
		}
		
	}
	
	/*
	 * 测试用例
	 */
	@Test
	public void userTest() {
		Road maLuRoad = new Road();
		Road fuRoad = new FuRoad();
		Road xiaoLu = new XiaoRoad();
		System.out.println(maLuRoad.getRoadType() + "," + fuRoad.getRoadType() + "," + xiaoLu.getRoadType());
		
		Car bmw = new BmwCar("宝马");
		Car benze = new BenzeCar("奔驰");
		Car auto = new AutoCar("奥拓");
		bmw.run(maLuRoad);
		benze.run(fuRoad);
		auto.run(xiaoLu);
		
	}
	
	/* output
	马路,辅路,乡村工路
	马路上跑宝马
	辅路上跑奔驰
	乡村工路上跑奥拓
	 */
}
