/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:18:02
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
 
public class CollectionsMinMax {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four".split(" "));
      System.out.println(list);
      System.out.println("最大值: " + Collections.max(list));
      System.out.println("最小值: " + Collections.min(list));
   }
}