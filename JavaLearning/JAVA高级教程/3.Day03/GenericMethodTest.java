public class GenericMethodTest {

	public static <E> void printArray(E[] inputArray) {
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
		;
	}

	public static void main(String[] args) {
		// 创建不同类型的数组

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.2, 2.3, 3.4, 4.5, 5.6 };
		Character[] charArray = { 'A', 'B', 'C', 'D', 'E' };
		System.out.println("整型数组元素为：");
		printArray(intArray);
		System.out.println("Double数组元素为：");
		printArray(doubleArray);
		System.out.println("字符数组元素为：");
		printArray(charArray);

	}
}