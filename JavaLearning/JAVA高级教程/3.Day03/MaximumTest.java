public class MaximumTest {

	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;//
		if (y.compareTo(max) > 0) {
			max = y;// 此时y最大
		}
		if (z.compareTo(max) > 0) {
			max = z; // 现在 z 更大
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.printf("%d, %d 和 %d 中最大的数为 %d\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
	}
}