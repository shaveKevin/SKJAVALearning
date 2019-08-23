/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 09:50:01
 * @LastEditors: Please set LastEditors
 */
public class TwoThreadGetName extends Thread {
   public void run() {
      for (int i = 0; i < 10; i++) {
         printMsg();
      }
   }
   public void printMsg() {
      Thread t = Thread.currentThread();
      String name = t.getName();
      System.out.println("name=" + name);
   } 
   public static void main(String[] args) {
      TwoThreadGetName tt = new TwoThreadGetName();
      tt.start();
      for (int i = 0; i < 10; i++) {
         tt.printMsg();
      }
   }
}