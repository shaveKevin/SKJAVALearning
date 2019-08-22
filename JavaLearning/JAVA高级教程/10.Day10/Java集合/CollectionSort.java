/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 16:54:39
 * @LastEditors: Please set LastEditors
 */
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
