import java.util.*;

public class ArrayTestDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("this is shavekevin");
		// 方法一；通过for each 遍历list 也可以直接用for循环
		for (String str : list) {
			System.out.println(str);
		}
		// 方法二，把链表变成数组相关内容进行遍历
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		// 使用迭代器进行相关遍历
		Iterator<String> ite = list.iterator();
		// 判断下一个元素是否有值
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}

	}
}