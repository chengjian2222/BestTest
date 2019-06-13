import org.junit.Test;

/**
 * 作业3: 实现一个计算器
 *
 * 需求如下:
 *
 * - 1.接收客户端输入(Java核心卷一,第三章,3.7节)的三个数据,格式: 数据1 操作符 数据2,如: 1 + 2
 *
 * - 2.如果数据1和2是数值型,则进行相应的运算符操作
 *
 * - 3.如果数据1和2不是数值型,则将数据1和数据2按字符串处理,与运算符一起拼接后输出,如: abc - bcd,输出"abc-bcd"
 *
 * 备注:
 *
 * - 1.计算器运算符只支持+,-,*,/,%
 *
 * - 2.数据和运算符之间使用空格隔开
 *
 * 要求:
 *
 * - 1.考虑程序的健壮性
 *
 * - 2.自行设计测试用例
 *
 * @author haoc
 */
public class Topic3 {

	public boolean myCalculator (Object startInput, String operator, Object endInput) {
		boolean result = false;
		// 判断是否合法操作符
		if (!isValidOperator(operator)) {
			return false;
		}
		if (startInput.toString().matches("\\d+(.\\d+)?") && endInput.toString().matches("\\d+(.\\d+)?")) {
			String value = "";
			switch (operator) {
			case "*":
			{
				value = startInput + " * " + endInput + " = "
			+ (Double.parseDouble(startInput.toString()) * Double.parseDouble(endInput.toString()));
				
				break;
			}
			case "/":
			{
				// 判断除数为0的时候特殊处理
				if (Double.parseDouble(endInput.toString()) == 0) {
					value = startInput + " " +operator+ " " + endInput + " = " + startInput.toString() + operator + endInput.toString();
					break;
				}
				value = startInput + " / " + endInput + " = "
						+ (Double.parseDouble(startInput.toString()) / Double.parseDouble(endInput.toString()));
				break;
			}
			case "+":
			{
				value = startInput + " + " + endInput + " = "
						+ (Double.parseDouble(startInput.toString()) + Double.parseDouble(endInput.toString()));
				break;
			}
			case "-":
			{
				value = startInput + " - " + endInput + " = "
						+ (Double.parseDouble(startInput.toString()) - Double.parseDouble(endInput.toString()));
				break;
			}
			default:
			{
				value = "运算符输入不在(+,-,*,/)之内，无法计算";
				break;
			}
			}
			System.out.println(value);
		}else {
			System.out.println("输入的两个参数不是数值型");
			String value = startInput + " " +operator+ " " + endInput + " = " + startInput.toString() + operator + endInput.toString();
			System.out.println(value);
		}
		
		return result;
	}
	
	public boolean isValidOperator(String myOperator) {
		String[]  operatorArr = {"+","-","*","/"};
		for (int i = 0; i < operatorArr.length; i++) {
			if (myOperator.contains(operatorArr[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void userCalculator () {
		myCalculator(123111.2, "+", 123);
		myCalculator(123111.2, "-", 123);
		myCalculator(123111.2, "*", 123);
		myCalculator(123111.2, "/", 123);
		myCalculator("123111.2", "+", "123");
		myCalculator(123111.2, "+", 123);
		myCalculator("123111.2", "+", "1dasdsa");
		myCalculator("abc", "+", "efg");
		myCalculator("123111.2", "/", "0.0");
	}
/*output
123111.2 + 123 = 123234.2
123111.2 - 123 = 122988.2
123111.2 * 123 = 1.51426776E7
123111.2 / 123 = 1000.9040650406504
123111.2 + 123 = 123234.2
123111.2 + 123 = 123234.2
输入的两个参数不是数值型
123111.2 + 1dasdsa = 123111.2+1dasdsa
输入的两个参数不是数值型
abc + efg = abc+efg
123111.2 / 0.0 = 123111.2/0.0
*/
}
