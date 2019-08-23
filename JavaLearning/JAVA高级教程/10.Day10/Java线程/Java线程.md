# Java高级编程第10天
## Java线程
## Java 实例 - 查看线程是否存活
以下实例演示了如何通过继承 Thread 类并使用 isAlive() 方法来检测一个线程是否存活：
```
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
```
编译后的结果为：
```
name=main
name=main
name=main
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=Thread
name=main
name=main
name=main
name=main
name=main
The end of main(), tt.isAlive()=false
```
## Java 实例 - 获取当前线程名称
以下实例演示了如何通过继承 Thread 类并使用 getName() 方法来获取当前线程名称：

```
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
```
编译后的结果为：
```
name=main
name=main
name=main
name=main
name=main
name=main
name=Thread-0
name=Thread-0
name=Thread-0
name=Thread-0
name=Thread-0
name=main
name=Thread-0
name=main
name=main
name=Thread-0
name=Thread-0
name=Thread-0
name=Thread-0
```
## Java 实例 - 状态监测
以下实例演示了如何通过继承 Thread 类并使用 currentThread.getName() 方法来监测线程的状态：

```
class MyThread extends Thread{
   boolean waiting= true;
   boolean ready= false;
   MyThread() {
   }
   public void run() {
      String thrdName = Thread.currentThread().getName();
      System.out.println(thrdName + " starting.");
      while(waiting) 
      System.out.println("waiting:"+waiting); 
      System.out.println("waiting...");
      startWait(); 
      try {
         Thread.sleep(1000);
      }
      catch(Exception exc) {
         System.out.println(thrdName + " interrupted.");
      }
      System.out.println(thrdName + " terminating.");
   }
   synchronized void startWait() {
      try {
         while(!ready) wait();
      }
      catch(InterruptedException exc) {
         System.out.println("wait() interrupted");
      }
   }
   synchronized void notice() {
      ready = true;
      notify();
   }
}
public class MyThreadDemo {
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
      while(thrd.isAlive()) 
      System.out.println("alive");
      showThreadStatus(thrd);
   }
   static void showThreadStatus(Thread thrd) {
      System.out.println(thrd.getName() + "Alive:=" + thrd.isAlive() + " State:=" + thrd.getState());
   }
}
```
编译后的结果为：
```
……
alive
alive
MyThread #1 terminating.
alive
……
```

##  Java 实例 - 线程优先级设置
以下实例演示了如何通过setPriority() 方法来设置线程的优先级：
```
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
```
编译后的结果为：
```
Thread[Thread-1,1,main]: 4
Thread[Thread-5,1,main]: 3
Thread[Thread-0,10,main]: 4
Thread[Thread-3,1,main]: 3
Thread[Thread-4,1,main]: 3
Thread[Thread-5,1,main]: 2
Thread[Thread-2,1,main]: 2
Thread[Thread-1,1,main]: 3
Thread[Thread-3,1,main]: 2
Thread[Thread-4,1,main]: 2
Thread[Thread-0,10,main]: 3
Thread[Thread-2,1,main]: 1
Thread[Thread-5,1,main]: 1
Thread[Thread-4,1,main]: 1
Thread[Thread-1,1,main]: 2
Thread[Thread-3,1,main]: 1
Thread[Thread-0,10,main]: 2
Thread[Thread-1,1,main]: 1
Thread[Thread-0,10,main]: 1
```
## Java 实例 - 死锁及解决方法
死锁是这样一种情形：多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。由于线程被无限期地阻塞，因此程序不可能正常终止。
java 死锁产生的四个必要条件：

* 1、互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用

* 2、不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。

* 3、请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有。

* 4、循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。

当上述四个条件都成立的时候，便形成死锁。当然，死锁的情况下如果打破上述任何一个条件，便可让死锁消失。下面用java代码来模拟一下死锁的产生。

解决死锁问题的方法是：一种是用synchronized，一种是用Lock显式锁实现。

而如果不恰当的使用了锁，且出现同时要锁多个对象时，会出现死锁情况，如下：

```
import java.util.Date;
 
public class LockTest {
   public static String obj1 = "obj1";
   public static String obj2 = "obj2";
   public static void main(String[] args) {
      LockA la = new LockA();
      new Thread(la).start();
      LockB lb = new LockB();
      new Thread(lb).start();
   }
}
class LockA implements Runnable{
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockA 开始执行");
         while(true){
            synchronized (LockTest.obj1) {
               System.out.println(new Date().toString() + " LockA 锁住 obj1");
               Thread.sleep(3000); // 此处等待是给B能锁住机会
               synchronized (LockTest.obj2) {
                  System.out.println(new Date().toString() + " LockA 锁住 obj2");
                  Thread.sleep(60 * 1000); // 为测试，占用了就不放
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
class LockB implements Runnable{
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockB 开始执行");
         while(true){
            synchronized (LockTest.obj2) {
               System.out.println(new Date().toString() + " LockB 锁住 obj2");
               Thread.sleep(3000); // 此处等待是给A能锁住机会
               synchronized (LockTest.obj1) {
                  System.out.println(new Date().toString() + " LockB 锁住 obj1");
                  Thread.sleep(60 * 1000); // 为测试，占用了就不放
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
```
编译后的结果为：
```
Fri Aug 23 09:56:30 CST 2019 LockA 开始执行
Fri Aug 23 09:56:30 CST 2019 LockB 开始执行
Fri Aug 23 09:56:30 CST 2019 LockA 锁住 obj1
Fri Aug 23 09:56:30 CST 2019 LockB 锁住 obj2
```
此时死锁产生。

为了解决这个问题，我们不使用显示的去锁，我们用信号量去控制。

信号量可以控制资源能被多少线程访问，这里我们指定只能被一个线程访问，就做到了类似锁住。而信号量可以指定去获取的超时时间，我们可以根据这个超时时间，去做一个额外处理。

对于无法成功获取的情况，一般就是重复尝试，或指定尝试的次数，也可以马上退出。

```
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
 
public class UnLockTest {
   public static String obj1 = "obj1";
   public static final Semaphore a1 = new Semaphore(1);
   public static String obj2 = "obj2";
   public static final Semaphore a2 = new Semaphore(1);
 
   public static void main(String[] args) {
      LockAa la = new LockAa();
      new Thread(la).start();
      LockBb lb = new LockBb();
      new Thread(lb).start();
   }
}
class LockAa implements Runnable {
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockA 开始执行");
         while (true) {
            if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
               System.out.println(new Date().toString() + " LockA 锁住 obj1");
               if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                  System.out.println(new Date().toString() + " LockA 锁住 obj2");
                  Thread.sleep(60 * 1000); // do something
               }else{
                  System.out.println(new Date().toString() + "LockA 锁 obj2 失败");
               }
            }else{
               System.out.println(new Date().toString() + "LockA 锁 obj1 失败");
            }
            UnLockTest.a1.release(); // 释放
            UnLockTest.a2.release();
            Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
class LockBb implements Runnable {
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockB 开始执行");
         while (true) {
            if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
               System.out.println(new Date().toString() + " LockB 锁住 obj2");
               if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                  System.out.println(new Date().toString() + " LockB 锁住 obj1");
                  Thread.sleep(60 * 1000); // do something
               }else{
                  System.out.println(new Date().toString() + "LockB 锁 obj1 失败");
               }
            }else{
               System.out.println(new Date().toString() + "LockB 锁 obj2 失败");
            }
            UnLockTest.a1.release(); // 释放
            UnLockTest.a2.release();
            Thread.sleep(10 * 1000); // 这里只是为了演示，所以tryAcquire只用1秒，而且B要给A让出能执行的时间，否则两个永远是死锁
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
```
编译后的结果为：
```
Fri Aug 23 10:05:09 CST 2019 LockB 开始执行
Fri Aug 23 10:05:09 CST 2019 LockA 开始执行
Fri Aug 23 10:05:09 CST 2019 LockB 锁住 obj2
Fri Aug 23 10:05:09 CST 2019 LockA 锁住 obj1
Fri Aug 23 10:05:10 CST 2019LockB 锁 obj1 失败
Fri Aug 23 10:05:10 CST 2019 LockA 锁住 obj2
```
## Java 实例 - 获取线程id
以下实例演示了如何使用 getThreadId() 方法获取线程id：


```
public class GetThreadIdDemo extends Object implements Runnable {
   private ThreadID var;
  
   public GetThreadIdDemo(ThreadID v) {
     this.var = v;
   }
  
   public void run() {
     try {
       print("var getThreadID =" + var.getThreadID());
       Thread.sleep(2000);
       print("var getThreadID =" + var.getThreadID());
     } catch (InterruptedException x) {
     }
   }
  
   private static void print(String msg) {
     String name = Thread.currentThread().getName();
     System.out.println(name + ": " + msg);
   }
  
   public static void main(String[] args) {
     ThreadID tid = new ThreadID();
     GetThreadIdDemo shared = new GetThreadIdDemo(tid);
  
     try {
       Thread threadA = new Thread(shared, "threadA");
       threadA.start();
  
       Thread.sleep(500);
  
       Thread threadB = new Thread(shared, "threadB");
       threadB.start();
  
       Thread.sleep(500);
  
       Thread threadC = new Thread(shared, "threadC");
       threadC.start();
     } catch (InterruptedException x) {
     }
   }
 }
  
 class ThreadID extends ThreadLocal {
   private int nextID;
  
   public ThreadID() {
     nextID = 10001;
   }
  
   private synchronized Integer getNewID() {
     Integer id = new Integer(nextID);
     nextID++;
     return id;
   }
  
  
   protected Object initialValue() {
     print("in initialValue()");
     return getNewID();
   }
  
   public int getThreadID() {
     Integer id = (Integer) get();
     return id.intValue();
   }
  
   private static void print(String msg) {
     String name = Thread.currentThread().getName();
     System.out.println(name + ": " + msg);
   }
 }
```
编译后的结果为：
```
threadA: in initialValue()
threadA: var getThreadID =10001
threadB: in initialValue()
threadB: var getThreadID =10002
threadC: in initialValue()
threadC: var getThreadID =10003
threadA: var getThreadID =10001
threadB: var getThreadID =10002
threadC: var getThreadID =10003
```
##  Java 实例 - 线程挂起
以下实例演示了如何将线程挂起：


```
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
```
编译后的结果为：
```
#1: 5
#1: 4
#1: 3
#1: 2
#1: 1
#2: 5
#2: 4
#2: 3
#2: 2
#2: 1
#3: 5
#3: 4
#3: 3
#3: 2
#3: 1
#4: 5
#4: 4
#4: 3
#4: 2
#4: 1
#5: 5
#5: 4
#5: 3
#5: 2
#5: 1
线程已被挂起
```
##  Java 实例 - 终止线程
Java中原来在Thread中提供了stop()方法来终止线程，但这个方法是不安全的，所以一般不建议使用。

本文向大家介绍使用interrupt方法中断线程。

使用interrupt方法来终端线程可分为两种情况：

* （1）线程处于阻塞状态，如使用了sleep方法。

* （2）使用while（！isInterrupted（））{……}来判断线程是否被中断。

在第一种情况下使用interrupt方法，sleep方法将抛出一个InterruptedException例外，而在第二种情况下线程将直接退出。下面的代码演示了在第一种情况下使用interrupt方法。

```
public class ThreadInterrupt extends Thread 
{ 
    public void run() 
    { 
        try 
        { 
            sleep(50000);  // 延迟50秒 
        } 
        catch (InterruptedException e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
    public static void main(String[] args) throws Exception 
    { 
        Thread thread = new ThreadInterrupt(); 
        thread.start(); 
        System.out.println("在50秒之内按任意键中断线程!"); 
        System.in.read(); 
        thread.interrupt(); 
        thread.join(); 
        System.out.println("线程已经退出!"); 
    } 
}
```
编译后的结果为：
```
在50秒之内按任意键中断线程!

sleep interrupted
线程已经退出!
```

##  Java 实例 - 生产者/消费者问题
生产者和消费者问题是线程模型中的经典问题：生产者和消费者在同一时间段内共用同一个存储空间，如下图所示，生产者向空间里存放数据，而消费者取用数据，如果不加以协调可能会出现以下情况：

存储空间已满，而生产者占用着它，消费者等着生产者让出空间从而去除产品，生产者等着消费者消费产品，从而向空间中添加产品。互相等待，从而发生死锁。

![product](https://ws3.sinaimg.cn/large/006mQyr2gy1g69ebgb634g30dc02o0ss.gif)

以下实例演示了如何通过线程解决生产者/消费者问题：


```
public class ProducerConsumerTest {
   public static void main(String[] args) {
      CubbyHole c = new CubbyHole();
      Producer p1 = new Producer(c, 1);
      Consumer c1 = new Consumer(c, 1);
      p1.start(); 
      c1.start();
   }
}
class CubbyHole {
   private int contents;
   private boolean available = false;
   public synchronized int get() {
      while (available == false) {
         try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
      available = false;
      notifyAll();
      return contents;
   }
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         }
         catch (InterruptedException e) { 
         } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}

class Consumer extends Thread {
   private CubbyHole cubbyhole;
   private int number;
   public Consumer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   }
   public void run() {
      int value = 0;
         for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("消费者 #" + this.number+ " got: " + value);
         }
    }
}

class Producer extends Thread {
   private CubbyHole cubbyhole;
   private int number;

   public Producer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   }

   public void run() {
      for (int i = 0; i < 10; i++) {
         cubbyhole.put(i);
         System.out.println("生产者 #" + this.number + " put: " + i);
         try {
            sleep((int)(Math.random() * 100));
         } catch (InterruptedException e) { }
      }
   }
}
```
编译后的结果为：
```
生产者 #1 put: 0
消费者 #1 got: 0
生产者 #1 put: 1
消费者 #1 got: 1
生产者 #1 put: 2
消费者 #1 got: 2
生产者 #1 put: 3
消费者 #1 got: 3
生产者 #1 put: 4
消费者 #1 got: 4
生产者 #1 put: 5
消费者 #1 got: 5
生产者 #1 put: 6
消费者 #1 got: 6
生产者 #1 put: 7
消费者 #1 got: 7
生产者 #1 put: 8
消费者 #1 got: 8
生产者 #1 put: 9
消费者 #1 got: 9
```

## Java 实例 - 获取线程状态
Java中的线程的生命周期大体可分为5种状态。
*  1.新建状态（New）：新创建了一个线程对象。

*  2.就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
*  3.运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。

* 4.阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
   * （一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。

   * （二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。

   * （三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。

*  5.死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。

![SysFree](https://ws3.sinaimg.cn/large/006mQyr2gy1g69efzbuc8j30ev0diq3b.jpg)

以下实例演示了如何获取线程的状态：

```
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
```
编译后的结果为：
```
……
alive
alive
alive
MyThread #1 结束。
alive
alive
alive
alive
alive
alive
alive
MyThread #1 存活:false 状态:TERMINATED
```

##  Java 实例 - 获取所有线程
以下实例演示了如何使用 getName() 方法获取所有正在运行的线程：

```
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
```
编译后的结果为：
```
线程号：0 = main
线程号：1 = thread1
```

## Java 实例 - 查看线程优先级
以下实例演示了如何使用 getThreadId() 方法获取线程id：

```
public class ThreadMainDemo extends Object {
   private static Runnable makeRunnable() {
      Runnable r = new Runnable() {
         public void run() {
            for (int i = 0; i < 5; i++) {
               Thread t = Thread.currentThread();
               System.out.println("in run() - priority="
               + t.getPriority()+ ", name=" + t.getName());
               try {
                  Thread.sleep(2000);
               }
               catch (InterruptedException x) {
               }
            }
         }
      };
      return r;
   }
   public static void main(String[] args) {
      System.out.println("in main() - Thread.currentThread().getPriority()=" + Thread.currentThread().getPriority());
      System.out.println("in main() - Thread.currentThread().getName()="+ Thread.currentThread().getName());
      Thread threadA = new Thread(makeRunnable(), "threadA");
      threadA.start();
      try {
         Thread.sleep(3000);
      }
      catch (InterruptedException x) {
      }
      System.out.println("in main() - threadA.getPriority()="+ threadA.getPriority());
   }
}
```
编译后的结果为：
```
in main() - Thread.currentThread().getPriority()=5
in main() - Thread.currentThread().getName()=main
in run() - priority=5, name=threadA
in run() - priority=5, name=threadA
in main() - threadA.getPriority()=5
in run() - priority=5, name=threadA
in run() - priority=5, name=threadA
in run() - priority=5, name=threadA
```
##  Java 实例 - 中断线程
以下实例演示了如何使用interrupt()方法来中断线程并使用 isInterrupted() 方法来判断线程是否已中断：


```
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
```
编译后的结果为：
```
in run() - 将运行 work2() 方法
in main() - 中断其他线程
in main() - 离开
C isInterrupted()=true
in run() - 中断 work2() 方法
```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





