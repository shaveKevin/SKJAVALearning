/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 16:56:51
 * @LastEditors: Please set LastEditors
 */
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