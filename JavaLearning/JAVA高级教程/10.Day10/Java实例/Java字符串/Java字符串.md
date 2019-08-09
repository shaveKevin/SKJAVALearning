# Java高级编程第10天
## Java 字符串

## 字符串比较 

以下实例中我们通过字符串函数 compareTo (string) ，compareToIgnoreCase(String) 及 compareTo(object string) 来比较两个字符串，并返回字符串中第一个字母ASCII的差值。

实例代码如下：

```
public class StringCompareEmp {
	public static void main(String[] args) {
		String str = "Hello Worldm";
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
```
编译后的结过为：
```
-32
0
0
```

源码的判断逻辑是这样的：

首先判断出两者的长度 然后取出最小的长度，对字符串中的每个字符的ASCII码做比较，
如果不一样，那么就返回两者的差值。
如果刚好两者的大小不同，但是一方包含另外一方的时候，这时候返回的就是两者的长度差值忽略了大小写之后 先比较的是两个大写是否一致 如果不一致比较小写的是否一致。对比的依然是ASCII码。


## 查找字符串最后一次出现的位置

以下实例中我们通过字符串函数 strOrig.lastIndexOf(Stringname) 来查找子字符串 Stringname 在 strOrig 出现的位置：

实例代码如下：
```
public class SearchlastString {
    public static void main(String[] args) {
        String strOrig = "Hello world ,Hello Runoob";
        int lastIndex = strOrig.lastIndexOf("Runoob");
        //好不到的时候返回-1
        if(lastIndex == - 1){
           System.out.println("没有找到字符串 Runoob");
        }else{
           System.out.println("Runoob 字符串最后出现的位置： "+ lastIndex);
        }
        
    }
}
```
编译后的结果为：
```
Runoob 字符串最后出现的位置： 19
```

##  删除字符串中的一个字符

以下实例中我们通过字符串函数 substring() 函数来删除字符串中的一个字符，我们将功能封装在 removeCharAt 函数中。

实例代码如下：
```
public class Main {
   public static void main(String args[]) {
      String str = "this is Java";
      System.out.println(removeCharAt(str, 3));
   }
   public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
}
```
编译后的结果为：
```
thi is Java
```

## 字符串替换

```
public class StringReplaceEmp {
    public static void main(String[] args) {
        String str="Hllo World";
        System.out.println( str.replace( 'H','W' ) );
        System.out.println( str.replaceFirst("He", "Wa") );
        System.out.println( str.replaceAll("He", "Ha") );
    }
}
```
注意。这个替换是所有符合条件的都替换。。慎用。

编译后的结果为：
```
WWllo World
HHllo World
HHllo World
```
## 字符串反转
以下实例演示了如何使用 Java 的反转函数 reverse() 将字符串反转：

```
public class StringReverseExample{
   public static void main(String[] args){
      String string="runoob";
      String reverse = new StringBuffer(string).reverse().toString();
      System.out.println("字符串反转前:"+string);
      System.out.println("字符串反转后:"+reverse);
   }
}
```
编译后的结果为：
```
字符串反转前:runoob
字符串反转后:boonur
```
源码是这样的:
```
 public AbstractStringBuilder reverse() {
        boolean hasSurrogates = false;
        int n = count - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs();
        }
        return this;
    }
```

## 字符串搜索
 
 以下实例使用了 String 类的 indexOf() 方法在字符串中查找子字符串出现的位置，如果存在返回字符串出现的位置（第一位为0），如果不存在返回 -1
```
public class SearchStringEmp {
   public static void main(String[] args) {
      String strOrig = "Google Runoob Taobao";
      int intIndex = strOrig.indexOf("Runoob");
      if(intIndex == - 1){
         System.out.println("没有找到字符串 Runoob");
      }else{
         System.out.println("Runoob 字符串位置 " + intIndex);
      }
   }
}
```
编译后的结果为：
```
Runoob 字符串位置 7
```
## 字符串分割

以下实例使用了 split(string) 方法通过指定分隔符将字符串分割为数组：

```
public class StringReplaceEmp {
    public static void main(String[] args) {
        String str = "www-runoob-com";
        String[] temp;
        String delimeter = "-"; // 指定分割字符
        temp = str.split(delimeter); // 分割字符串
        // 普通 for 循环
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
            System.out.println("");
        }

        System.out.println("------java for each循环输出的方法-----");
        String str1 = "www.runoob.com";
        String[] temp1;
        String delimeter1 = "\\."; // 指定分割字符， . 号需要转义
        temp1 = str1.split(delimeter1); // 分割字符串
        for (String x : temp1) {
            System.out.println(x);
            System.out.println("");
        }
    }
}
```
编译后的结果为:
```
runoob
com
------java for each循环输出的方法-----
www
runoob
com
```



源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





