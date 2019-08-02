import java.util.*;

public class GenericTestDemo {
	// 泛型 不指定参数类型
	public static void getData(List<?> data) {
		System.out.println("data:" + data.get(0));
	}
	public static void getUperNumber(List<? extends Number> data) {
		System.out.println("data :" + data.get(0));
	 }

	public static void main(String[] args) {
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number> number = new ArrayList<Number>();
		name.add("我是谁");
		age.add(18);
		number.add(314);
		getData(name);
		getData(age);
		getData(number);

		//getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3
	}



}