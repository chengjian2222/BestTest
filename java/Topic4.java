import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * 作业4: 封装一个数组对象(暂时用int型即可)
 *
 * 可先定义个数组看下,比如int[],有哪些方法提供,太少了
 *
 * 要求实现: 数组类
 *
 * - new 时传入指定大小
 *
 * - 可以添加元素
 *
 * - 可以删除元素
 *
 * - 可以根据给定元素,找到索引位置
 *
 * - 并支持跨度寻找,如find(1234,5),即夸过5个索引之后寻找
 *
 * - 实现对数组的遍历功能
 *
 * - 实现判断数组是否为空
 *
 * - 不理解,看下Topic6,栈的设计
 *
 * @author haoc
 */
public class Topic4 {
	
	public class UserArr {
		private int[] data = new int[10];
		private int size;
		private int index;
		
		public void setSize(int size) {
			this.size = size;
		}
		
		public UserArr(int size) {
			// TODO Auto-generated constructor stub
			this.size = size;
			this.data = new int[size];
		}
		
		public void add(int number) {
			if (index < data.length) {
				data[index++] = number;
			}
			else {
				System.out.println("数组已经存满");
			}
		}
		
		public boolean removeIndex(int index){	
		if (index <= this.index) {
				int [] tmpData = new int[this.size-1];
				//移除指定索引的数据
				System.arraycopy(data, 0, tmpData, 0,index);
				System.arraycopy(data, index+1, tmpData, index, size-1-index); 
				//把临时数组赋值给新的数组
				this.size--;
				this.data = new int [this.size];
				this.index = index;
				System.arraycopy(tmpData, 0, this.data, 0, tmpData.length);
				
				return true;
			} else {
			return false;
			}
		}
		//删除数组指定元素
		public boolean remove(int number) {
			
			return true;
		}
		
		/*
		 * 查询数组是否存在指定值,并且返回索引，不存在则返回-1
		 */
		public int find(int number) {
			for (int i = 0; i < data.length; i++) {
				if (data[i] == number) {
					return i;
				}
			}
			return -1;
		}
		
		/*
		 * 跨度查找
		 */
		public boolean find(int number,int index) {
			if (index >= this.size) {
				System.out.println("跨度的索引值不能大于数组的大小");
				return false;
			}
			for (int i = index; i < data.length; i++) {
				if (data[i] == number) {
					return true;
				}
			}
			return false;
		}
		
		public boolean isEmpty() {
			return (this.size == 0);
		}
		
	}
	
	@Test
	public void testUserArr() {
		UserArr arr = new UserArr(10);
		for (int i = 0; i < arr.size; i++) {
			arr.add(i+1);
		}
		
		System.out.println("数组的大小是:" + arr.size);
		arr.removeIndex(0);
		System.out.println("数组的大小是:" + arr.size);
		System.out.println("arr.find(5,6) 的结果是:"+arr.find(5,6));
		System.out.println("arr.find(5,2) 的结果是:"+arr.find(5,2));
		System.out.println("arr.find(4) 的结果是:"+arr.find(4));
		System.out.println("arr.isEmpty() = " + arr.isEmpty());
	}
	
/*output
数组的大小是:10
数组的大小是:9
arr.find(5,6) 的结果是:false
arr.find(5,2) 的结果是:true
arr.find(4) 的结果是:2
arr.isEmpty() = false
*/
	
}
