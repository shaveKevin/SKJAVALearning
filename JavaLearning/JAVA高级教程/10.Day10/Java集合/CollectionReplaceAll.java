/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:23:07
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
public class CollectionReplaceAll {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
      System.out.println("List :"+list);
      Collections.replaceAll(list, "one", "hundrea");
      System.out.println("replaceAll: " + list);
   }
}