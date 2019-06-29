package day04.homework;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * case 6: 定义一个类,实现一个key对应一个列表.数据类型是泛型
 *
 * 具备最基本的数据添加,遍历等基本常用方法
 *
 * 作业: 实现与Map类似的功能
 *
 * @author 成建
 */
public class Topic02 {

	public static void main(String[] args) {
		CjMap<String, String> map = CjMap.of();
		map.add("1", "Hello");
		map.add("1", "World");
		map.add("1", "Test","OneCase", "Hello", "World");
		System.out.println(map);
		
		map.delete("Test");
		System.out.println("find(\"OneCase\") = "+ map.find("OneCase"));
		System.out.println(map);
		System.out.println(map.myGet("1"));
		System.out.println(map.myGet("2"));
	}
	
	static class CjMap<K,V > extends AbstractMap<K, V>{
		private K key;
		private List<V> val;
		
		private CjMap() {
			this.val = new ArrayList<V>();
		}
		
		public static <K,V> CjMap<K, V> of() {
			return new CjMap<>();
		}
		
		//添加元素
		public void add(K key, V val) {
			if (null != this.key) {
				this.val.add(val);
			} else {
				this.key = key;
				this.val.add(val);
			}
		}
		
		public void add(K key, V... val) {
			List<V> vals = Arrays.asList(val);
			
			if (null != this.key) {
				this.val.addAll(vals);
			} else {
				this.key = key;
				this.val.addAll(vals);
			}
		}
		
		//删除元素
		public boolean delete(V val) {
			if (this.val.contains(val)) {
				this.val.remove(val);
				return true;
			}
			else {
				return false;
			}
		}
		//查找元素
		public boolean find(V val) {
			if (this.val.contains(val)) {
				return true;
			}
			else {
				return false;
			}
		}
		//取出数据
		public List<V> myGet(K key) {
			if (this.key.equals(key)) {
				return this.val;
			} else {
				 return null;
			}
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("CjMap{ ");
			stringBuffer.append("Key = " + this.key);
			stringBuffer.append(",Value = " + this.val);
			stringBuffer.append(" }");
			return stringBuffer.toString();
		}
		
	}
	
}

/* output
CjMap{ Key = 1,Value = [Hello, World, Test, OneCase, Hello, World] }
find("OneCase") = true
CjMap{ Key = 1,Value = [Hello, World, OneCase, Hello, World] }
[Hello, World, OneCase, Hello, World]
null
 */
