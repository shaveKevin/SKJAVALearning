/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 09:53:05
 * @LastEditors: Please set LastEditors
 */
public class SimplePriorities extends Thread {
   private int countDown = 5;
   private volatile double d = 0; 
   public SimplePriorities(int priority) {
      setPriority(priority);
      start();
   }
   public String toString() {
      return super.toString() + ": " + countDown;
   }
   public void run() {
      while(true) {
         for(int i = 1; i < 100000; i++)
         d = d + (Math.PI + Math.E) / (double)i;
         System.out.println(this);
         if(--countDown == 0) return;
      }
   }
   public static void main(String[] args) {
      new SimplePriorities(Thread.MAX_PRIORITY);
      for(int i = 0; i < 5; i++)
      new SimplePriorities(Thread.MIN_PRIORITY);
   }
}