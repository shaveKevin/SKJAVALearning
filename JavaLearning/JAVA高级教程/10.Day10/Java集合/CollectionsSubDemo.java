/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:24:13
 * @LastEditors: Please set LastEditors
 */
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