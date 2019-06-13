

import java.util.Arrays;
import java.util.EmptyStackException;

import org.junit.Test;

/**
 * 作业6: 使用数组实现一个栈,元素整型即可
 *
 * 要求:
 *
 * - 实现入栈,enqueue
 *
 * - 实现出栈,dequeue
 *
 * - 实现获取栈顶元素值,getFront
 *
 * - 实现获取栈的大小
 *
 * - 实现判断栈是否为空
 *
 * @author haoc
 */
public class Topic6 {
	
	public class Stack {
		// 初始化默认占用5个空间
		private int[] data = new int[5];
		private int size;
		
		/*
		 * 入栈
		 */
		public void enqueue (int number) {
			//判断栈的空间大小是否足够
			if (size >= data.length) {
				//扩容 翻倍
				data = Arrays.copyOf(data, data.length * 2);
			}
			System.out.println("入栈+1");
			data[size++] = number;
		}
		/*
		 * 获取栈顶的元素
		 */
		int getFront() {
			if (size == 0) {
				throw new EmptyStackException();
			}
			else {
				return data[size - 1];
			}
		}
		
		/*
		 * 出栈
		 */
		public int dequeue() {
			int value = this.getFront();
			size-- ;
			System.out.println("出栈-1");
			return value;
		}
		
		// 获取栈的大小
		public int getSize() {
			return this.size;
		}
		
		// 判断栈是否为空
		public boolean isEmpty() {
			if (size == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Test
	public void userStack() {
		Stack st = new Stack();
		System.out.println("size = " + st.getSize());
		st.enqueue(1);
		System.out.println("size = " + st.getSize() + ",getFront = " + st.getFront());
		st.enqueue(2);
		st.enqueue(3);
		st.enqueue(4);
		System.out.println("size = " + st.getSize() + ",getFront = " + st.getFront());
		st.dequeue();
		System.out.println("size = " + st.getSize() + ",getFront = " + st.getFront());
		st.dequeue();
		System.out.println("size = " + st.getSize() + ",getFront = " + st.getFront() + "," +st.isEmpty());
		st.dequeue();
		System.out.println("size = " + st.getSize() + ",getFront = " + st.getFront());
	}
/* output
size = 0
入栈+1
size = 1,getFront = 1
入栈+1
入栈+1
入栈+1
size = 4,getFront = 4
出栈-1
size = 3,getFront = 3
出栈-1
size = 2,getFront = 2,false
出栈-1
size = 1,getFront = 1
*/
	
}
