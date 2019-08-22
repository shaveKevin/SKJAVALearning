/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:13:37
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
 
public class CollectionToArray{
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