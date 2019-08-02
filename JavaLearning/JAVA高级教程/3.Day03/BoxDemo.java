public class BoxDemo<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
	public static void main(String[] args) {
		BoxDemo<Integer> integerBox = new BoxDemo<Integer>();
		BoxDemo<String>   stringBox = new BoxDemo<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("Java 学习"));
		System.out.printf("整型值为 :%d\n", integerBox.get());
		System.out.printf("字符串为 :%s\n", stringBox.get());
	}
}