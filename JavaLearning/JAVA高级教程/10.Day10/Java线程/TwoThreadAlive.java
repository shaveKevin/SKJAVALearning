/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 09:46:19
 * @LastEditors: Please set LastEditors
 */
public class TwoThreadAlive extends Thread {
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
      TwoThreadAlive tt = new TwoThreadAlive();
      tt.setName("Thread");
      System.out.println("before start(), tt.isAlive()=" + tt.isAlive());
      tt.start();
      System.out.println("just after start(), tt.isAlive()=" + tt.isAlive());
      for (int i = 0; i < 10; i++) {
         tt.printMsg();
      }
      System.out.println("The end of main(), tt.isAlive()=" + tt.isAlive());
   }
}