import java.io.*;
public class Employee {
	//这个实例对子类可见
	public String name;
	// 私有变量，尽在该类可见。
	private double salary;
	public Employee (String empName) {
		name = empName;
	}
	//设定salary的值
	public void setSalary(double empSal) {
		salary = empSal;
	}
	public void printEmp(){
		System.out.println("名字：" + name);
		System.out.println ("工资：" + salary);
	}
	public static void main(String[] args) {
	Employee empone = new Employee("Runoob");
	empone.setSalary(1000);
	empone.printEmp();
	
	}
}