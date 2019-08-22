/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:32:12
 * @LastEditors: Please set LastEditors
 */
import java.net.*;
import java.io.*;
 
public class DorminUse {
   public static void main(String[] args) {
      Socket Skt;
      String host = "localhost";
      if (args.length > 0) {
         host = args[0];
      }
      for (int i = 0; i < 1024; i++) {
         try {
            System.out.println("查看 "+ i);
            Skt = new Socket(host, i);
            System.out.println("端口 " + i + " 已被使用");
         }
         catch (UnknownHostException e) {
            System.out.println("Exception occured"+ e);
            break;
         }
         catch (IOException e) {
         }
      }
   }
}