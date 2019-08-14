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
## Java 实例 - 数组扩容
以下实例演示了如何在数组初始化后对数组进行扩容：
```
public class ArrayExpended {
    public static void main(String[] args) {
        String[] names = new String[] { "A", "B", "C" };
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str : extended){
            System.out.println(str);
        }
    }
}
```
编译后的结果为：

```
A
B
C
D
E
```
## 

```
public class RemoveDupicate {
    public static void main(String[] args) 
    {
        int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2, 9, 2};
        findDupicateInArray(my_array);
 
    }
 
    public static void findDupicateInArray(int[] a) {
        int count=0;
        for(int j=0;j<a.length;j++) {
            for(int k =j+1;k<a.length;k++) {
                if(a[j]==a[k]) {
                    count++;
                }
            }
            if(count==1)
               System.out.println( "重复元素 : " +  a[j] );
            count = 0;
        }
    }
}
```
编译后的结果为：
```
重复元素 : 5
重复元素 : 6
重复元素 : 2
```
## Java 实例 - 删除数组元素

以下实例演示了如何使用 remove () 方法来删除数组元素：
```
import java.util.*;
public class RemoveObject {
    public static void main(String[] args) {
        ArrayList<String> objArray = new ArrayList<String>();
        objArray.clear();
        objArray.add(0,"第 0 个元素");
        objArray.add(1,"第 1 个元素");
        objArray.add(2,"第 2 个元素");
        System.out.println("数组删除元素前："+objArray);
        objArray.remove(1);
        objArray.remove("第 0 个元素");
        System.out.println("数组删除元素后："+objArray);
    }
}
```
编译后的结果为：
```
数组删除元素前：[第 0 个元素, 第 1 个元素, 第 2 个元素]
数组删除元素后：[第 2 个元素]
```

## Java 实例 - 数组差集

以下实例演示了如何使用 removeAll () 方法来计算两个数组的差集：
```
import java.util.ArrayList;
 
public class MinusArray {
    public static void main(String[] args)  {
        ArrayList objArray = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");
        objArray.add(0,"common1");
        objArray.add(1,"common2");
        objArray.add(2,"notcommon2");
        System.out.println("array1 的元素" +objArray);
        System.out.println("array2 的元素" +objArray2);
        objArray.removeAll(objArray2);
        System.out.println("array1 与 array2 数组差集为："+objArray);
    }
}
```
编译后的结果为：
```
array1 的元素[common1, common2, notcommon2]
array2 的元素[common1, common2, notcommon, notcommon1]
array1 与 array2 数组差集为：[notcommon2]
```
## Java 实例 - 在数组中查找指定元素
以下实例演示了如何使用 contains () 方法来查找数组中的指定元素：

```
import java.util.ArrayList;
 
public class ContainObjectDemo {
    public static void main(String[] args)  {
        ArrayList<String> objArray = new ArrayList<String>();
        ArrayList<String> objArray2 = new ArrayList<String>();
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");
        objArray.add(0,"common1");
        objArray.add(1,"common2");
        System.out.println("objArray 的数组元素："+objArray);
        System.out.println("objArray2 的数组元素："+objArray2);
        System.out.println("objArray 是否包含字符串common2? ： "
        +objArray.contains("common2"));
        System.out.println("objArray2 是否包含数组 objArray? ："
        +objArray2.contains(objArray) );
    }
}
```
编译后的结果为：

```
objArray 的数组元素：[common1, common2]
objArray2 的数组元素：[common1, common2, notcommon, notcommon1]
objArray 是否包含字符串common2? ： true
objArray2 是否包含数组 objArray? ：false
```
## Java 实例 - 判断数组是否相等
以下实例演示了如何使用 equals ()方法来判断数组是否相等：
```
import java.util.Arrays;
 
public class ArrayEqualDemo {
    public static void main(String[] args) throws Exception {
        int[] ary = {1,2,3,4,5,6};
        int[] ary1 = {1,2,3,4,5,6};
        int[] ary2 = {1,2,3,4};
        System.out.println("数组 ary 是否与数组 ary1相等? ："
        +Arrays.equals(ary, ary1));
        System.out.println("数组 ary 是否与数组 ary2相等? ："
        +Arrays.equals(ary, ary2));
    }
}
```
编译后的结果为：
```
数组 ary 是否与数组 ary1相等? ：true
数组 ary 是否与数组 ary2相等? ：false
```
## Java 实例 - 数组并集
以下实例演示了如何使用 union ()方法来计算两个数组的并集：

```
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
 
public class CombineDemo {
    public static void main(String[] args) throws Exception {
        String[] arr1 = { "1", "2", "3" };
        String[] arr2 = { "4", "5", "6" };
        String[] result_union = union(arr1, arr2);
        System.out.println("并集的结果如下：");
 
        for (String str : result_union) {
            System.out.println(str);
        }
    }
 
    // 求两个字符串数组的并集，利用set的元素唯一性
    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<String>();
 
        for (String str : arr1) {
            set.add(str);
        }
 
        for (String str : arr2) {
            set.add(str);
        }
 
        String[] result = {  };
 
        return set.toArray(result);
    }
}

```
编译后的结果为：
```
并集的结果如下：
3
2
1
6
5
4
```
源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





