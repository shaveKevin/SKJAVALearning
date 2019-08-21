# Java高级编程第10天
## Java异常处理

## Java 实例 - 异常处理方法
以下实例演示了使用 System 类的 System.err.println() 来展示异常的处理方法：
```
class ExceptionDemo
{
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.err.println("Caught Exception");
            System.err.println("getMessage():" + e.getMessage());
            System.err.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.err.println("toString():" + e);
            System.err.println("printStackTrace():");
            e.printStackTrace();
        }
    }
}
```
编译后的结果为:
```
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
   at ExceptionDemo.main(ExceptionDemo.java:5)
```

## Java 实例 - 多个异常处理（多个catch）
对异常的处理：
1，声明异常时，建议声明更为具体的异常，这样可以处理的更具体
2,对方声明几个异常，就对应几个catch块， 如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面
以下实例演示了如何处理多异常：

```
class Demo  
{  
    int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException//在功能上通过throws的关键字声明该功能可能出现问题  
    {  
        int []arr = new int [a];  
  
        System.out.println(arr[4]);//制造的第一处异常  
  
        return a/b;//制造的第二处异常  
    }  
}  
  
  
class ExceptionMoreDemo  
{  
    public static void main(String[]args) //throws Exception  
    {  
        Demo d = new Demo();  
  
        try  
            {  
                int x = d.div(4,0);//程序运行截图中的三组示例 分别对应此处的三行代码  
                //int x = d.div(5,0);  
                //int x = d.div(4,1);  
                System.out.println("x="+x);   
        }  
        catch (ArithmeticException e)  
        {  
            System.out.println(e.toString());  
        }  
        catch (ArrayIndexOutOfBoundsException e)  
        {  
            System.out.println(e.toString());  
        }  
        catch (Exception e)//父类 写在此处是为了捕捉其他没预料到的异常 只能写在子类异常的代码后面  
                            //不过一般情况下是不写的   
        {  
            System.out.println(e.toString());  
        }  
          
  
  
        System.out.println("Over");  
    }  
  
}
```
编译后的结果为：
```
java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
Over
```
## Java 实例 - Finally的用法
Java 中的 Finally 关键一般与try一起使用，在程序进入try块之后，无论程序是因为异常而中止或其它方式返回终止的，finally块的内容一定会被执行 。
以下实例演示了如何使用 finally 通过 e.getMessage() 来捕获异常（非法参数异常）：

```
public class ExceptionDemo2 {
   public static void main(String[] argv) {
      new ExceptionDemo2().doTheWork();
   }
   public void doTheWork() {
      Object o = null;
      for (int i=0; i<5; i++) {
         try {
            o = makeObj(i);
         }
         catch (IllegalArgumentException e) {
            System.err.println
            ("Error: ("+ e.getMessage()+").");
            return;   
         }
         finally {
            System.err.println("都已执行完毕");
            if (o==null)
            System.exit(0);
        }
        System.out.println(o); 
      }
   }
   public Object makeObj(int type) 
   throws IllegalArgumentException {
      if (type == 1)  
      throw new IllegalArgumentException
      ("不是指定的类型： " + type);
      return new Object();
   }
}
```
编译后的结果为：
```
都已执行完毕
java.lang.Object@7852e922
Error: (不是指定的类型：1).
都已执行完毕
```
## Java 实例 - 使用 catch 处理异常

```
public class CatchDemo {
    public static void main (String args[]) {
        int array[]={20,20,40};
        int num1=15,num2=10;
        int result=10;
        try{
            result = num1/num2;
            System.out.println("结果为 " +result);
            for(int i =5;i >=0; i--) {
                System.out.println ("数组的元素值为 " +array[i]);
            }
        }
        catch (Exception e) {
            System.out.println("触发异常 : "+e);
        }
    }
}
```
编译后的结果为：
```
结果为 1

触发异常 : java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
```
## Java 实例 - 多线程异常处理

以下实例演示了多线程异常处理方法：

```
class MyThread extends Thread{
    public void run(){
        System.out.println("Throwing in " +"MyThread");
        throw new RuntimeException();
    }
}
class ThreadDemo {
    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();
        try{
            Thread.sleep(1000);
        }
        catch (Exception x){
            System.out.println("Caught it" + x);
        }
        System.out.println("Exiting main");
    }
}
```
编译后的结果为：
```
Throwing in MyThread
Exception in thread "Thread-0" java.lang.RuntimeException
        at testapp.MyThread.run(Main.java:19)
Exiting main
```
## Java 实例 - 获取异常的堆栈信息

以下实例演示了使用异常类的 printStack() 方法来获取堆栈信息：

```
public class ExceptionStackDemo {
    public static void main (String args[]){
        int array[]={20,20,40};
        int num1=15,num2=10;
        int result=10;
        try{
            result = num1/num2;
            System.out.println("The result is" +result);
            for(int i =5; i>=0; i--) {
                System.out.println("The value of array is" +array[i]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
编译后的结果为：
```
The result is1
java.lang.ArrayIndexOutOfBoundsException: 5
        at testapp.Main.main(Main.java:28)
```
## Java 实例 - 重载方法异常处理
以下实例演示了重载方法的异常处理：
```
public class OverloadingDemo {
    double method(int i) throws Exception{
        return i/0;
    }
    boolean method(boolean b) {
        return !b;
    }
    static double method(int x, double y) throws Exception  {
        return x + y ;
    }
    static double method(double x, double y) {
        return x + y - 3;
    }   
    public static void main(String[] args) {
        Main mn = new Main();
        try{
            System.out.println(method(10, 20.0));
            System.out.println(method(10.0, 20));
            System.out.println(method(10.0, 20.0));
            System.out.println(mn.method(10));
        }
        catch (Exception ex){
            System.out.println("exception occoure: "+ ex);
        }
    }
}
```
编译后的结果为：
```
30.0
27.0
27.0
exception occoure: java.lang.ArithmeticException: / by zero
```
## Java 实例 - 链试异常
以下实例演示了使用多个 catch 来处理链试异常：
```
public class LinkExceptionDemo {
    public static void main (String args[])throws Exception  {
        int n=20,result=0;
        try{
            result=n/0;
            System.out.println("结果为"+result);
        }
        catch(ArithmeticException ex){
            System.out.println("发算术异常: "+ex);
            try {
                throw new NumberFormatException();
            }
            catch(NumberFormatException ex1) {
                System.out.println("手动抛出链试异常 : "+ex1);
            }
        }
    }
}
```
编译后的结果为：
```
发算术异常: java.lang.ArithmeticException: / by zero

手动抛出链试异常 : java.lang.NumberFormatException
```
## Java 实例 - 自定义异常
以下实例演示了通过继承 Exception 来实现自定义异常：

```
class WrongInputException extends Exception {  // 自定义的类
    WrongInputException(String s) {
        super(s);
    }
}
class Input {
    void method() throws WrongInputException {
        throw new WrongInputException("Wrong input"); // 抛出自定义的类
    }
}
class TestInput {
    public static void main(String[] args){
        try {
            new Input().method();
        }
        catch(WrongInputException wie) {
            System.out.println(wie.getMessage());
        }
    } 
}
```
编译后的结果为：
```
Wrong input
```





源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





