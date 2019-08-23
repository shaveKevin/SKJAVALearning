/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-23 10:09:10
 * @LastEditors: Please set LastEditors
 */
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
 