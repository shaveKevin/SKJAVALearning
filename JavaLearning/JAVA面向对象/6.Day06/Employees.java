import java.io.*;
public class Employees {
	// salary是静态的私有变量
	private static double salary;
	//DEFAULT 是一个常量
	public static final String DEFAULT = "技术人员";


	public static void main(String[] args) {
     salary = 10000;
     System.out.println(DEFAULT + "平均工资" + salary);
	
	}
}