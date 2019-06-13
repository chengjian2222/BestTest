import org.junit.Test;

/**
 * 输出1到100以内的所有质数
 *
 * 质数: 只能被1和自身整除的数,如3,7,11,13等
 *
 * @author haoc
 */
public class Topic2 {

	public void showPrimeNumber(int bigNumber){
		if (bigNumber > 100) {
			System.out.println("传入的参数不合法，请传入1到100以内的数字");
			return;
		}
		StringBuffer showNumberStr = new StringBuffer();
		for (int i = 2; i <= bigNumber; i++) {
			if (checkValidPrimeNumber(i)) {
				showNumberStr.append(i + ",");
			}
		}
		System.out.println("1~100以内所有的质数是:" + showNumberStr);
	}
	
	public Boolean checkValidPrimeNumber(int inputNumber) {

		Boolean flag = true;
		for (int i = 2; i < inputNumber; i++) {
			if (inputNumber % i == 0) {
				flag = false;
			}
		}
		return flag;
	}
	
	@Test
	public void test() {
		showPrimeNumber(100);
	}
	/* output
	 * 1~100以内所有的质数是:2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
	 * */
}
