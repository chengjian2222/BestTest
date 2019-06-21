package day03.homework;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 计算从键盘中输入的各个字母出现的次数.
 * 如：输入字符串􏰷􏰷"abcdabcdabcdabcd"，输入结果是：a(4)b(4)c(4)d(4)
 * auth:成建
 */
public class Topic2 {
	public static void main(String[] args) {
		//从键盘接受输入的内容
		System.out.println("请输入一串字符串:");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = (String) scanner.next();
			System.out.println("输入的是:" + string);
			System.out.println(combinationString(string)); 
			System.out.println("请输入一串字符串:");
		}
		
		System.out.println("输出的结果是:");
	}
	
	public static String combinationString(String str) {
		char[] strArr = str.toCharArray();
		Map<String, List<String>> strMap = new HashMap<>();
		for (int i = 0; i < strArr.length; i++) {
			String key = String.valueOf(strArr[i]);
			if (strMap.containsKey(key)) {
				List<String> tmpList = new ArrayList<>();
				List<String> list = strMap.get(key);
				
				tmpList.addAll(list);
				tmpList.add(String.valueOf(strArr[i]));
				strMap.put(key,tmpList);
			}
			else {//不存在
				List<String> tmpList = new ArrayList<>();
				tmpList.add(String.valueOf(strArr[i]));
				strMap.put(key,tmpList);
			}
		}
		String value = "";
		for(String key : strMap.keySet()) {
			List<String> tmpList = strMap.get(key);
			value += key + "(" + tmpList.size() + ")";
		}
		return value;
	}
}
/*output
请输入一串字符串:
absdaabcabc
输入的是:absdaabcabc
a(4)b(3)s(1)c(2)d(1)
请输入一串字符串:
abc1231111
输入的是:abc1231111
a(1)1(5)b(1)2(1)c(1)3(1)
请输入一串字符串:
 */
