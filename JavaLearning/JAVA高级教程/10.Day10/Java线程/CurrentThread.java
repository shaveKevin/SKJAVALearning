/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 10:27:24
 * @LastEditors: Please set LastEditors
 */
public class CurrentThread extends Thread {
   public static void main(String[] args) {
      CurrentThread t1 = new CurrentThread();
      t1.setName("thread1");
      t1.start();
      ThreadGroup currentGroup = 
      Thread.currentThread().getThreadGroup();
      int noThreads = currentGroup.activeCount();
      Thread[] lstThreads = new Thread[noThreads];
      currentGroup.enumerate(lstThreads);
      for (int i = 0; i < noThreads; i++)
      System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
   }
}