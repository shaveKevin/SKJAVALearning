# Java高级编程第10天
## Java集合

## Java 实例 - 数组转集合
以下实例演示了使用 Java Util 类的 Arrays.asList(name) 方法将数组转换为集合：

```
import java.util.*;
import java.io.*;
 
public class ArrayToCollection{
   public static void main(String args[]) 
   throws IOException{
      int n = 5;         // 5 个元素
      String[] name = new String[n];
      for(int i = 0; i < n; i++){
         name[i] = String.valueOf(i);
      }
      List<String> list = Arrays.asList(name); 
      System.out.println();
      for(String li: list){
         String str = li;
         System.out.print(str + " ");
      }
   }
}
```
编译后的结果为：
```
0 1 2 3 4 
```
## Java 实例 - 集合比较
以下实例将字符串转换为集合并使用 Collection 类的 Collection.min() 和 Collection.max() 来比较集合中的元素：

```

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
 
class CompareSetCollection {
    public static void main(String[] args) {
        String[] coins = { "Penny", "nickel", "dime", "Quarter", "dollar" };
        Set<String> set = new TreeSet<String>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i <= 10; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
}
```
编译后的结果为：
```
Penny
dime
-----------
nickel
Quarter
```
## Java 实例 - HashMap遍历
以下实例演示了如何使用 Collection 类的 iterator() 方法来遍历集合：

```
import java.util.*;
 
public class CollectionDemo {
   public static void main(String[] args) {
      HashMap< String, String> hMap = 
      new HashMap< String, String>();
      hMap.put("1", "1st");
      hMap.put("2", "2nd");
      hMap.put("3", "3rd");
      Collection cl = hMap.values();
      Iterator itr = cl.iterator();
      while (itr.hasNext()) {
         System.out.println(itr.next());
     }
   }
}
```
编译后的结果为：
```
1st
2nd
3rd
```
## Java 实例 - 集合长度
以下实例演示了如何使用 Collections 类 的collection.add() 来添加数据并使用 collection.size()来计算集合的长度：

```
import java.util.*;
 
public class CollectionLength {
   public static void main(String [] args) {   
      System.out.println( "集合实例!\n" ); 
      int size;
      HashSet collection = new HashSet ();
      String str1 = "Yellow", str2 = "White", str3 = 
      "Green", str4 = "Blue";  
      Iterator iterator;
      collection.add(str1);    
      collection.add(str2);   
      collection.add(str3);   
      collection.add(str4);
      System.out.print("集合数据: ");  
      iterator = collection.iterator();     
      while (iterator.hasNext()){
         System.out.print(iterator.next() + " ");  
      }
      System.out.println();
      size = collection.size();
      if (collection.isEmpty()){
         System.out.println("集合是空的");
      }
      else{
         System.out.println( "集合长度: " + size);
      }
      System.out.println();
   }
}
```
编译后的结果为：
```
集合实例!

集合数据: White Yellow Blue Green 
集合长度: 4
```
## Java 实例 - 集合打乱顺序
以下实例演示了如何使用 Collections 类 Collections.shuffle() 方法来打乱集合元素的顺序：

```
import java.util.*;
 
public class CollectionsShuffle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(new Integer(i));
        System.out.println("打乱前:");
        System.out.println(list);
 
        for (int i = 1; i < 6; i++) {
            System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
}
```
编译后的结果为：
```
打乱前:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
第1次打乱：
[7, 1, 4, 8, 9, 2, 3, 6, 0, 5]
第2次打乱：
[8, 4, 7, 3, 9, 6, 5, 0, 1, 2]
第3次打乱：
[3, 9, 6, 5, 8, 2, 4, 7, 1, 0]
第4次打乱：
[2, 9, 4, 6, 5, 8, 0, 7, 1, 3]
第5次打乱：
[3, 7, 9, 5, 6, 8, 0, 2, 1, 4]
```
## Java 实例 - 集合遍历

```
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
 
public class CollectionSort {
 
   public static void main(String[] args) {
      // List集合的遍历
      listTest();
      // Set集合的遍历
      setTest();
   }
 
   private static void setTest() {
      Set<String> set = new HashSet<String>();
      set.add("JAVA");
      set.add("C");
      set.add("C++");
      // 重复数据添加失败
      set.add("JAVA");
      set.add("JAVASCRIPT");
 
      // 使用iterator遍历set集合
      Iterator<String> it = set.iterator();
      while (it.hasNext()) {
         String value = it.next();
         System.out.println(value);
      }
      
      // 使用增强for循环遍历set集合
      for(String s: set){
         System.out.println(s);
      }
   }
 
   // 遍历list集合
   private static void listTest() {
      List<String> list = new ArrayList<String>();
      list.add("菜");
      list.add("鸟");
      list.add("教");
      list.add("程");
      list.add("www.runoob.com");
 
      // 使用iterator遍历
      Iterator<String> it = list.iterator();
      while (it.hasNext()) {
         String value = it.next();
         System.out.println(value);
      }
 
      // 使用传统for循环进行遍历
      for (int i = 0, size = list.size(); i < size; i++) {
         String value = list.get(i);
         System.out.println(value);
      }
 
      // 使用增强for循环进行遍历
      for (String value : list) {
         System.out.println(value);
      }
   }
}
```
编译后的结果为：
```
菜
鸟
教
程
www.runoob.com
菜
鸟
教
程
www.runoob.com
菜
鸟
教
程
www.runoob.com
JAVA
JAVASCRIPT
C++
C
JAVA
JAVASCRIPT
C++
C
```
## Java 实例 - 集合反转
以下实例演示了如何使用 Collection 和 Listiterator 类的 listIterator() 和 collection.reverse() 方法来反转集合中的元素：
```
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
 
class CollectionReverse {
   public static void main(String[] args) {
      String[] coins = { "A", "B", "C", "D", "E" };
      List l = new ArrayList();
      for (int i = 0; i < coins.length; i++)
         l.add(coins[i]);
      ListIterator liter = l.listIterator();
      System.out.println("反转前");
      while (liter.hasNext())
         System.out.println(liter.next());
      Collections.reverse(l);
      liter = l.listIterator();
      System.out.println("反转后");
      while (liter.hasNext())
         System.out.println(liter.next());
   }
}
```
编译后的结果为：
```
反转前
A
B
C
D
E
反转后
E
D
C
B
A
```
## Java 实例 - 删除集合中指定元素
以下实例演示了如何使用 Collection 类的 collection.remove() 方法来删除集合中的指定的元素：


```
import java.util.*;
 
public class CollectionRemove {
   public static void main(String [] args) {   
      System.out.println( "集合实例!\n" ); 
      int size;
      HashSet collection = new HashSet ();
      String str1 = "Yellow", str2 = "White", str3 = 
      "Green", str4 = "Blue";  
      Iterator iterator;
      collection.add(str1);    
      collection.add(str2);   
      collection.add(str3);   
      collection.add(str4);
      System.out.print("集合数据: ");  
      iterator = collection.iterator();     
      while (iterator.hasNext()){
         System.out.print(iterator.next() + " ");  
      }
      System.out.println();
      collection.remove(str2);
      System.out.println("删除之后 [" + str2 + "]\n");
      System.out.print("现在集合的数据是: ");
      iterator = collection.iterator();     
      while (iterator.hasNext()){
         System.out.print(iterator.next() + " ");  
      }
      System.out.println();
      size = collection.size();
      System.out.println("集合大小: " + size + "\n");
   }
}
```
编译后的结果为：
```
集合实例!

集合数据: White Yellow Blue Green 
删除之后 [White]

现在集合的数据是: Yellow Blue Green 
集合大小: 3
```
## Java 实例 - 只读集合
以下实例演示了如何使用 Collection 类的 Collections.unmodifiableList() 方法来设置集合为只读：
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
public class CollectionsReadOnly {
   public static void main(String[] argv) 
   throws Exception {
      List stuff = Arrays.asList(new String[] { "a", "b" });
      List list = new ArrayList(stuff);
      list = Collections.unmodifiableList(list);
      try {
         list.set(0, "new value");
      } 
        catch (UnsupportedOperationException e) {
      }
      Set set = new HashSet(stuff);
      set = Collections.unmodifiableSet(set);
      Map map = new HashMap();
      map = Collections.unmodifiableMap(map);
      System.out.println("集合现在是只读");
   }
}

```
编译后的结果为：
```
集合现在是只读
```
## Java 实例 - 集合输出
以下实例演示了如何使用 Java Util 类的 tMap.keySet(),tMap.values() 和 tMap.firstKey() 方法将集合元素输出：


```
import java.util.*;
 
public class CollectionPrint {
   public static void main(String[] args) {
      System.out.println("TreeMap 实例！\n");
      TreeMap tMap = new TreeMap();
      tMap.put(1, "Sunday");
      tMap.put(2, "Monday");
      tMap.put(3, "Tuesday");
      tMap.put(4, "Wednesday");
      tMap.put(5, "Thursday");
      tMap.put(6, "Friday");
      tMap.put(7, "Saturday");
      System.out.println("TreeMap 键：" 
      + tMap.keySet());
      System.out.println("TreeMap 值：" 
      + tMap.values());
      System.out.println("键为 5 的值为: " + tMap.get(5)+ "\n");
      System.out.println("第一个键: " + tMap.firstKey() 
      + " Value: " 
      + tMap.get(tMap.firstKey()) + "\n");
      System.out.println("最后一个键: " + tMap.lastKey() 
      + " Value: "+ tMap.get(tMap.lastKey()) + "\n");
      System.out.println("移除第一个数据: " 
      + tMap.remove(tMap.firstKey()));
      System.out.println("现在 TreeMap 键为: " 
      + tMap.keySet());
      System.out.println("现在 TreeMap 包含: " 
      + tMap.values() + "\n");
      System.out.println("移除最后一个数据: " 
      + tMap.remove(tMap.lastKey()));
      System.out.println("现在 TreeMap 键为: " 
      + tMap.keySet());
      System.out.println("现在 TreeMap 包含: " 
      + tMap.values());
   }
}
```
编译后的结果为：
```
TreeMap 实例！

TreeMap 键：[1, 2, 3, 4, 5, 6, 7]
TreeMap 值：[Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
键为 5 的值为: Thursday

第一个键: 1 Value: Sunday

最后一个键: 7 Value: Saturday

移除第一个数据: Sunday
现在 TreeMap 键为: [2, 3, 4, 5, 6, 7]
现在 TreeMap 包含: [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]

移除最后一个数据: Saturday
现在 TreeMap 键为: [2, 3, 4, 5, 6]
现在 TreeMap 包含: [Monday, Tuesday, Wednesday, Thursday, Friday]
```
## Java 实例 - 集合转数组
以下实例演示了如何使用 Java Util 类的 list.add() 和 list.toArray() 方法将集合转为数组：

```
import java.util.*;
 
public class CollectionToArray {
   public static void main(String[] args){
      List<String> list = new ArrayList<String>();
      list.add("菜"); 
      list.add("鸟"); 
      list.add("教");
      list.add("程");
      list.add("www.runoob.com");
      String[] s1 = list.toArray(new String[0]); 
      for(int i = 0; i < s1.length; ++i){
         String contents = s1[i];
         System.out.print(contents);
     } 
   }
}
```
编译后的结果为：
```
菜鸟教程www.runoob.com

```
## Java 实例 - List 循环移动元素
以下实例演示了如何使用 Collections 类的 rotate() 来循环移动元素，方法第二个参数指定了移动的起始位置：

```
import java.util.*;
public class CollectionSplit {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six".split(" "));
      System.out.println("List :"+list);
      Collections.rotate(list, 3);
      System.out.println("rotate: " + list);
   }
}
```
编译后的结果为：
```
List :[one, Two, three, Four, five, six]
rotate: [Four, five, six, one, Two, three]
```
## Java 实例 - 查找 List 中的最大最小值
以下实例演示了如何使用 Collections 类的 max() 和 min() 方法来获取List中最大最小值：

```
import java.util.*;
 
public class CollectionsMinMax {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
      System.out.println(list);
      System.out.println("最大值: " + Collections.max(list));
      System.out.println("最小值: " + Collections.min(list));
   }
}
```
编译后的结果为：
```
[one, Two, three, Four, five, six, one, three, Four]
最大值: three
最小值: Four
```
## Java 实例 - 遍历 HashTable 的键值

以下实例演示了如何使用 Hashtable 类的 keys() 方法来遍历输出键值：
```
import java.util.Enumeration;
import java.util.Hashtable;
 
public class HashtableDemo {
   public static void main(String[] args) {
      Hashtable ht = new Hashtable();
      ht.put("1", "One");
      ht.put("2", "Two");
      ht.put("3", "Three");
      Enumeration e = ht.keys();
      while (e.hasMoreElements()){
         System.out.println(e.nextElement());
      }
   }
}
```
编译后的结果为：
```
3
2
1
```
## Java 实例 - 使用 Enumeration 遍历 HashTable
以下实例演示了如何使用 Enumeration 类的 hasMoreElements 和 nextElement 方法来遍历输出 HashTable 中的内容：

```
import java.util.Enumeration;
import java.util.Hashtable;
 
public class HashTableEnumeration {
   public static void main(String[] args) {
      Hashtable ht = new Hashtable();
      ht.put("1", "One");
      ht.put("2", "Two");
      ht.put("3", "Three");
      Enumeration e = ht.elements();
      while(e.hasMoreElements()){
         System.out.println(e.nextElement());
      }
   }
}
```
编译后的结果为：
```
Three
Two
One
```
## Java 实例 - 集合中添加不同类型元素
以下实例演示了在集合类中添加不同类型的元素：


```
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
 
 
public class CollectionsAddElm {
   public static void main(String[] args) {
      List lnkLst = new LinkedList();
      lnkLst.add("element1");
      lnkLst.add("element2");
      lnkLst.add("element3");
      lnkLst.add("element4");
      displayAll(lnkLst);
      List aryLst = new ArrayList();
      aryLst.add("x");
      aryLst.add("y");
      aryLst.add("z");
      aryLst.add("w");
      displayAll(aryLst);
      Set hashSet = new HashSet();
      hashSet.add("set1");
      hashSet.add("set2");
      hashSet.add("set3");
      hashSet.add("set4");
      displayAll(hashSet);
      SortedSet treeSet = new TreeSet();
      treeSet.add("1");
      treeSet.add("2");
      treeSet.add("3");
      treeSet.add("4");
      displayAll(treeSet);
      LinkedHashSet lnkHashset = new LinkedHashSet();
      lnkHashset.add("one");
      lnkHashset.add("two");
      lnkHashset.add("three");
      lnkHashset.add("four");
      displayAll(lnkHashset);
      Map map1 = new HashMap();
      map1.put("key1", "J");
      map1.put("key2", "K");
      map1.put("key3", "L");
      map1.put("key4", "M");
      displayAll(map1.keySet());
      displayAll(map1.values());
      SortedMap map2 = new TreeMap();
      map2.put("key1", "JJ");
      map2.put("key2", "KK");
      map2.put("key3", "LL");
      map2.put("key4", "MM");
      displayAll(map2.keySet());
      displayAll(map2.values());
      LinkedHashMap map3 = new LinkedHashMap();
      map3.put("key1", "JJJ");
      map3.put("key2", "KKK");
      map3.put("key3", "LLL");
      map3.put("key4", "MMM");
      displayAll(map3.keySet());
      displayAll(map3.values());
   }
   static void displayAll(Collection col) {
      Iterator itr = col.iterator();
      while (itr.hasNext()) {
         String str = (String) itr.next();
         System.out.print(str + " ");
      }
      System.out.println();
   }
}
```
编译后的结果为：
```
element1 element2 element3 element4 
x y z w 
set3 set2 set4 set1 
1 2 3 4 
one two three four 
key1 key2 key3 key4 
J K L M 
key1 key2 key3 key4 
JJ KK LL MM 
key1 key2 key3 key4 
JJJ KKK LLL MMM 
```
## Java 实例 - List 元素替换
以下实例演示了如何使用 Collections 类的 replaceAll() 来替换List中所有的指定元素：

```
import java.util.*;
public class CollectionReplaceAll {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
      System.out.println("List :"+list);
      Collections.replaceAll(list, "one", "hundrea");
      System.out.println("replaceAll: " + list);
   }
}
```
编译后的结果为：
```
List :[one, Two, three, Four, five, six, one, three, Four]
replaceAll: [hundrea, Two, three, Four, five, six, hundrea, three, Four]
```
## Java 实例 - List 截取
以下实例演示了如何使用 Collections 类的 indexOfSubList() 和 lastIndexOfSubList() 方法来查看子列表是否在列表中，并查看子列表在列表中所在的位置：


```

import java.util.*;
 
public class CollectionsSubDemo {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
      System.out.println("List :"+list);
      List sublist = Arrays.asList("three Four".split(" "));
      System.out.println("子列表 :"+sublist);
      System.out.println("indexOfSubList: "
      + Collections.indexOfSubList(list, sublist));
      System.out.println("lastIndexOfSubList: "
      + Collections.lastIndexOfSubList(list, sublist));
   }
}
```
编译后的结果为：
```
List :[one, Two, three, Four, five, six, one, three, Four]
子列表 :[three, Four]
indexOfSubList: 2
lastIndexOfSubList: 7
```















源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





