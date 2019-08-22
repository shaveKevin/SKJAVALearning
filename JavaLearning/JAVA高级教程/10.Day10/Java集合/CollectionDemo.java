/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 11:04:25
 * @LastEditors: Please set LastEditors
 */
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