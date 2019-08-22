/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:19:05
 * @LastEditors: Please set LastEditors
 */
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