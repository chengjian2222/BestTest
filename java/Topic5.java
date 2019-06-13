import org.junit.Test;

/**
 * 作业5:实现一个杨辉三角
 *
 * 要求: 打印多少行由方法入参传入
 *
 * 杨辉三角的样式:
 *
 *               1
 *              1 1
 *             1 2 1
 *            1 2 3 2 1
 *           1 2 3 5 3 2 1
 * @author haoc
 */
public class Topic5 {
	// 显示杨辉三角
	public void showRiangle(int lineNumber) {
		if (lineNumber <= 0) {
			System.out.println("请传入整形数字且要大于0");
			return;
		}
		int [][] arr = new int[lineNumber][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i+1];
		}
		for (int i = 0; i < lineNumber; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0 || i == j) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
			}
		}
		
		for (int i = 0; i < lineNumber; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	
	@Test
	public void myTest() {
//		showRiangle(4);
		showRiangle(8);
	}
	
/* output
1  
1  1  
1  2  1  
1  3  3  1  
1  4  6  4  1  
1  5  10  10  5  1  
1  6  15  20  15  6  1  
1  7  21  35  35  21  7  1  
 */
}
