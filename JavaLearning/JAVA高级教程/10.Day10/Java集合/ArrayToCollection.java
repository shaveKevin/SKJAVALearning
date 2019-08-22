/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 10:57:47
 * @LastEditors: Please set LastEditors
 */
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