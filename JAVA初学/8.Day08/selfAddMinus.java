public class selfAddMinus {
	public static void main(String[] args) {
		/*
		int a = 3; // 定义一个变量
		int b = ++a; // 自增运算
		int c = 3;
		int d = --c;// 自减运算
		System.out.println("运算自增运算后的值等于 " + b);
		System.out.println("运算自减运算后的值等于 " + d);
		*/
		int a = 5;
		int b = 5;
		int x = 2*++a;
		int y = 2*b++;
		System.out.println("自增运算符前缀运算后a="+ a+",x="+x);
		System.out.println("自增运算符后缀运算后b="+ b+",y="+y);

	}
}