public class StringCompareEmp {
	public static void main(String[] args) {
		String str = "Hello World";
		String anotherString = "hello world";
		Object objStr = str;

		// compareTo 比较的是两个字符的ASCII的值，
		System.out.println(str.compareTo(anotherString));
		// 比较两个字符串不区分大小写
		System.out.println(str.compareToIgnoreCase(anotherString)); // 忽略大小写
		// objStr.toString() 之后 进行比较 
		System.out.println(str.compareTo(objStr.toString()));
		// 源码是这样的：
		/*
		public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
		*/
		//忽略大小写之后的比较
		/*
		 public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);
                        c2 = Character.toLowerCase(c2);
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }
		*/
	}
}