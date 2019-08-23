/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 10:25:50
 * @LastEditors: Please set LastEditors
 */
class MyThread extends Thread{
   boolean waiting= true;
   boolean ready= false;
   MyThread() {
   }
   public void run() {
      String thrdName = Thread.currentThread().getName();
      System.out.println(thrdName + " 启动");
      while(waiting)
      System.out.println("等待："+waiting);
      System.out.println("等待...");
      startWait();
      try {
         Thread.sleep(1000);
      }
      catch(Exception exc) {
         System.out.println(thrdName + " 中断。");
      }
      System.out.println(thrdName + " 结束。");
   }
   synchronized void startWait() {
      try {
         while(!ready) wait();
      }
      catch(InterruptedException exc) {
         System.out.println("wait() 中断。");
      }
   }
   synchronized void notice() {
      ready = true;
      notify();
   }
}
public class ThreadDemo {
   public static void main(String args[]) 
   throws Exception{
      MyThread thrd = new MyThread();
      thrd.setName("MyThread #1");
      showThreadStatus(thrd);
      thrd.start();
      Thread.sleep(50);
      showThreadStatus(thrd);
      thrd.waiting = false;
      Thread.sleep(50);
      showThreadStatus(thrd);
      thrd.notice();
      Thread.sleep(50);
      showThreadStatus(thrd);
      while(thrd.isAlive()) {
          System.out.println("alive");
      }
      showThreadStatus(thrd);
   }
   static void showThreadStatus(Thread thrd) {
      System.out.println(thrd.getName()+" 存活:" +thrd.isAlive()+" 状态:" + thrd.getState() );
   }
}