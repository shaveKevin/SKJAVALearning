/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 10:15:09
 * @LastEditors: Please set LastEditors
 */
public class SleepingThread extends Thread {
   private int countDown = 5;
   private static int threadCount = 0;
   public SleepingThread() {
      super("" + ++threadCount);
      start();
   }
   public String toString() { 
      return "#" + getName() + ": " + countDown;
   }
   public void run() {
      while (true) {
         System.out.println(this);
         if (--countDown == 0)
            return;
         try {
            sleep(100);
         }
         catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
   }
   public static void main(String[] args) 
   throws InterruptedException {
      for (int i = 0; i < 5; i++)
      new SleepingThread().join();
      System.out.println("线程已被挂起");
   }
}