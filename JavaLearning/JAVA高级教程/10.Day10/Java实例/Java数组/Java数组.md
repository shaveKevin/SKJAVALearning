# Java高级编程第10天
## Java 数组

### Java 实例 - 数组排序及元素查找


以下实例演示了如何使用sort()方法对Java数组进行排序，及如何使用 binarySearch() 方法来查找数组中的元素, 这边我们定义了 printArray() 方法来打印数组：

```
import java.util.Arrays;
 
public class MainClass {
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);
        printArray("数组排序结果为", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
    }
    private static void printArray(String message, int array[]) {
        System.out.println(message
        + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
```
编译后的结果为：
```
数组排序结果为: [length: 10]
-9, -7, -3, -2, 0, 2, 4, 5, 6, 8
元素 2  在第 5 个位置
```

## Java 实例 - 数组添加元素

以下实例演示了如何使用sort()方法对Java数组进行排序，及如何使用 insertElement () 方法向数组插入元素, 这边我们定义了 printArray() 方法来打印数组：

```
import java.util.Arrays;
 
public class ArrayInsertDemo {
   public static void main(String args[]) throws Exception {
      int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
      Arrays.sort(array);
      printArray("数组排序", array);
      int index = Arrays.binarySearch(array, 1);
      System.out.println("元素 1 所在位置（负数为不存在）："
      + index);  
      int newIndex = -index - 1;
      array = insertElement(array, 1, newIndex);
      printArray("数组添加元素 1", array);
   }
   private static void printArray(String message, int array[]) {
      System.out.println(message
      + ": [length: " + array.length + "]");
      for (int i = 0; i < array.length; i++) {
         if (i != 0){
            System.out.print(", ");
         }
         System.out.print(array[i]);         
      }
      System.out.println();
   }
   private static int[] insertElement(int original[],
   int element, int index) {
      int length = original.length;
      int destination[] = new int[length + 1];
      System.arraycopy(original, 0, destination, 0, index);
      destination[index] = element;
      System.arraycopy(original, index, destination, index
      + 1, length - index);
      return destination;
   }
}

```
编译后的结果为：
```
数组排序: [length: 10]
-9, -7, -3, -2, 0, 2, 4, 5, 6, 8
元素 1 所在位置（负数为不存在）：-6
数组添加元素 1: [length: 11]
-9, -7, -3, -2, 0, 1, 2, 4, 5, 6, 8
```
## Java 实例 - 获取数组长度

本文我们将为大家介绍如何使用数组的属性 length 来获取数组的长度。

以下实例中我们定义了二维数组，并获取数组的长度：
```
public class Main {
   public static void main(String args[]) {
      String[][] data = new String[2][5];
      System.out.println("第一维数组长度: " + data.length);
      System.out.println("第二维数组长度: " + data[0].length);
   }
}
```
编译后的结果为：
```
第一维数组长度: 2 
第二维数组长度: 5
```
## Java 实例 - 数组反转

以下实例中我们使用 Collections.reverse(ArrayList) 将数组进行反转：

```
import java.util.ArrayList;
import java.util.Collections;
 
public class ArrayReverseDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序: " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后排序: " + arrayList);
    }
}
```
编译后的结果为：
```
反转前排序: [A, B, C, D, E] 
反转后排序: [E, D, C, B, A] 
```
## Java 实例 - 数组输出
以下实例演示了如何通过循环输出数组：

```
public class WelcomeDemo {
    public static void main(String[] args){
        String[] runoobs = new String[3];
        runoobs[0] = "菜鸟教程";
        runoobs[1] = "菜鸟工具";
        runoobs[2] = "菜鸟笔记";
        for (int i = 0; i < runoobs.length; i++){
            System.out.println(runoobs[i]);
        }
    }
}
```
编译后的结果为：
```
菜鸟教程
菜鸟工具
菜鸟笔记
```
## Java 实例 - 数组获取最大和最小值

以下实例演示了如何通过 Collections 类的 Collections.max() 和 Collections.min() 方法来查找数组中的最大和最小值：


```
import java.util.Arrays;
import java.util.Collections;
 
public class MaxMinDemo {
    public static void main(String[] args) {
        Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5};
        int min = (int) Collections.min(Arrays.asList(numbers));
        int max = (int) Collections.max(Arrays.asList(numbers));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);
    }
}
```
编译后的结果为：
```
最小值: 1
最大值: 9
```
## Java 实例 - 数组合并

以下实例演示了如何通过 List 类的 Arrays.toString () 方法和 List 类的 list.Addall(array1.asList(array2) 方法将两个数组合并为一个数组：

```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Main {
    public static void main(String args[]) {
        String a[] = { "A", "E", "I" };
        String b[] = { "O", "U" };
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));
    }
}
```
编译后的结果为：
```
[A, E, I, O, U]
```
## Java 实例 - 数组填充

以下实例我们通过 Java Util 类的 Arrays.fill(arrayname,value) 方法和Arrays.fill(arrayname ,starting index ,ending index ,value) 方法向数组中填充元素：

```
import java.util.*;
 
public class FillTest {
    public static void main(String args[]) {
        int array[] = new int[6];
        Arrays.fill(array, 100);
        for (int i=0, n=array.length; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
        Arrays.fill(array, 3, 6, 50);
        for (int i=0, n=array.length; i< n; i++) {
            System.out.println(array[i]);
        }
    }
}
```
编译后的结果为：

```
100
100
100
100
100
100

100
100
100
50
50
50
```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





