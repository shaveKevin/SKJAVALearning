import java.io.*;
public class EmployeeTest {
	public static void main(String[] args) {
	// 使用便利构造器创建两个对象
	Employee empOne = new Employee("小王");
	Employee empTwo = new Employee("小八");
 // 调用成员的方法
  empOne.empAge(20);
  empOne.empDesignation("小精豆");
  empOne.empSalary(1000);
  empOne.printEmployee();
 
  empTwo.empAge(21);
  empTwo.empDesignation("汤姆猫");
  empTwo.empSalary(500);
  empTwo.printEmployee();
	}
}