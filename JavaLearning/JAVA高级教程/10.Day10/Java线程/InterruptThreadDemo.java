/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 10:32:31
 * @LastEditors: Please set LastEditors
 */
public class InterruptThreadDemo extends Object 
implements Runnable {
   public void run() {
      try {
         System.out.println("in run() - 将运行 work2() 方法");
         work2();
         System.out.println("in run() - 从 work2() 方法回来");
      }
      catch (InterruptedException x) {
         System.out.println("in run() - 中断 work2() 方法");
         return;
      }
      System.out.println("in run() - 休眠后执行");
      System.out.println("in run() - 正常离开");
   }
   public void work2() throws InterruptedException {
      while (true) {
         if (Thread.currentThread().isInterrupted()) {
            System.out.println("C isInterrupted()=" + Thread.currentThread().isInterrupted());
            Thread.sleep(2000);
            System.out.println("D isInterrupted()=" + Thread.currentThread().isInterrupted());
         }
      }
   }
   public void work() throws InterruptedException {
      while (true) {
         for (int i = 0; i < 100000; i++) {
            int j = i * 2;
         }
         System.out.println("A isInterrupted()=" + Thread.currentThread().isInterrupted());
         if (Thread.interrupted()) {
            System.out.println("B isInterrupted()=" + Thread.currentThread().isInterrupted());
            throw new InterruptedException();
         }
      }
   }
   public static void main(String[] args) {
      InterruptThreadDemo si = new InterruptThreadDemo();
      Thread t = new Thread(si);
      t.start();
      try {
         Thread.sleep(2000);
      }
      catch (InterruptedException x) {
      }
      System.out.println("in main() - 中断其他线程");
      t.interrupt();
      System.out.println("in main() - 离开");
   }
}
