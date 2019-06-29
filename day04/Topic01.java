package day04.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 自测下ArrayList与LinkedList在你本地的机器上的性能
 *
 * 主要是验证 LinkedList是不是所有数据都是删除和修改最快
 *
 * @author 成建
 */
public class Topic01 {

	public static void main(String[] args) {
		int count = 10000;
		System.out.println("数组数据量是:" + count);
		ArrayList<Integer> arrList = testArrayListBy(count);
		deleteArrayListBy(arrList);
		
		LinkedList<Integer> linkedList = testLinkedListBy(count);
		deleteLinkedListBy(linkedList);
	}
	
	public static ArrayList<Integer> testArrayListBy(double size) {
		long startTime = System.currentTimeMillis();    //获取开始时间
		//for循环添加数据
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		
		long endTime = System.currentTimeMillis();    //获取结束时间
		
		System.out.println("ArrayList添加时间：" + (endTime - startTime) + "ms"); 
		return list;
	}
	
	public static void deleteArrayListBy(ArrayList<Integer> list) {
		long startTime = System.currentTimeMillis();    //获取开始时间

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if (integer % 2 == 0) {
				iterator.remove();
			}
		}
		
		long endTime = System.currentTimeMillis();    //获取结束时间
		
		System.out.println("ArrayList删除时间：" + (endTime - startTime) + "ms"); 

	}
	
	public static LinkedList<Integer> testLinkedListBy(double size) {
		long startTime = System.currentTimeMillis();    //获取开始时间
		//for循环添加数据
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		
		long endTime = System.currentTimeMillis();    //获取结束时间
		
		System.out.println("LinkedList添加时间：" + (endTime - startTime) + "ms");
		
		return list;
	}
	
	public static void deleteLinkedListBy(LinkedList<Integer> list) {
		long startTime = System.currentTimeMillis();    //获取开始时间

		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if (integer % 2 == 0) {
				iterator.remove();
			}
		}
		
		long endTime = System.currentTimeMillis();    //获取结束时间
		
		System.out.println("LinkedList删除时间：" + (endTime - startTime) + "ms"); 

	}
	/*
	 * output 
数组数据量是:10000
ArrayList添加时间：3ms
ArrayList删除时间：11ms
LinkedList添加时间：3ms
LinkedList删除时间：6ms
		
		
数组数据量是:1000000
ArrayList添加时间：53ms
ArrayList删除时间：67161ms
LinkedList添加时间：169ms
LinkedList删除时间：25ms

总结：数据量越大ArrayList添加效率越高，LinkedList删除效率越高
	 * */
}
