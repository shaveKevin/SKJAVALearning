class FreshJuiceEnum {
	/* 这是Java的枚举距离
     * 这里为类添加一个枚举的属性
     * *这里是多行注释的示例*
	 */
	enum FreshJuiceSize { SMALL,MEDIUM,LARGE }
	FreshJuiceSize size;
}
public class FreshJuice {
	// FreshJuice的方法
	/* 单行注释的实例 */
	public static void main(String[] args) {
		FreshJuiceEnum juice = new FreshJuiceEnum();
		juice.size = FreshJuiceEnum.FreshJuiceSize.MEDIUM;
		System.out.println(juice.size);
	}
}