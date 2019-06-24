public class Transform {
	public static void main(String[] args) {
		// 自动转换
		char c1 = 'a';// 定义一个char类型
		int i1 = c1;// char自动类型转换为int
		System.out.println("char自动类型转换int后的值为"+ i1);
		char c2 = 'A';// 定义一个char类型
		int i2 = c2+1;//char类型和int类型计算
		System.out.println("char类型和int类型计算后的值等于"+i2);
		// 强制类型转换
		int i3 = 123;
		byte b = (byte)i3;
        System.out.println("int强制类型转换为byte后的值为"+i3);

	}
}