# Java高级编程第10天
## Java数据结构
### Java 实例 - 数字求和运算

以下实例演示了使用do...while结构求0~100的整数数字之和：
```
public class PlusDemo {
    public static void main(String[] args) {
        int limit=100;
        int sum=0;
        int i=1;
        do
        {
            sum=sum+i;
            i++;
        }
        while(i<=limit);
        System.out.println("sum = "+sum);
    }
}
```
编译后的结果为：
```
sum = 5050
```
### Java 实例 - 利用堆栈将中缀表达式转换成后缀表达式
以下实例演示了如何使用堆栈进行表达式的堆栈将中缀（Infix）表达式转换成后缀（postfix）表达式：

```
import java.io.IOException;
 
public class InToPost {
   private Stack theStack;
   private String input;
   private String output = "";
   public InToPost(String in) {
      input = in;
      int stackSize = input.length();
      theStack = new Stack(stackSize);
   }
   public String doTrans() {
      for (int j = 0; j < input.length(); j++) {
         char ch = input.charAt(j);
         switch (ch) {
            case '+': 
            case '-':
            gotOper(ch, 1); 
            break; 
            case '*': 
            case '/':
            gotOper(ch, 2); 
            break; 
            case '(': 
            theStack.push(ch);
            break;
            case ')': 
            gotParen(ch); 
            break;
            default: 
            output = output + ch; 
            break;
         }
      }
      while (!theStack.isEmpty()) {
         output = output + theStack.pop();
      }
      System.out.println(output);
      return output; 
   }
   public void gotOper(char opThis, int prec1) {
      while (!theStack.isEmpty()) {
         char opTop = theStack.pop();
         if (opTop == '(') {
            theStack.push(opTop);
            break;
         }
         else {
            int prec2;
            if (opTop == '+' || opTop == '-')
            prec2 = 1;
            else
            prec2 = 2;
            if (prec2 < prec1) { 
               theStack.push(opTop);
               break;
            }
            else
            output = output + opTop;
         }
      }
      theStack.push(opThis);
   }
   public void gotParen(char ch){ 
      while (!theStack.isEmpty()) {
         char chx = theStack.pop();
         if (chx == '(') 
         break; 
         else
         output = output + chx; 
      }
   }
   public static void main(String[] args) 
   throws IOException {
      String input = "1+2*4/5-7+3/6";
      String output;
      InToPost theTrans = new InToPost(input);
      output = theTrans.doTrans(); 
      System.out.println("Postfix is " + output + '\n');
   }
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      public void push(char j) {
         stackArray[++top] = j;
      }
      public char pop() {
         return stackArray[top--];
      }
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
     }
   }
}
```
编译后的结果为：
```
124*5/+7-36/+
Postfix is 124*5/+7-36/+
```
### Java 实例 - 在链表（LinkedList）的开头和结尾添加元素
以下实例演示了如何使用 LinkedList 类的 addFirst() 和 addLast() 方法在链表的开头和结尾添加元素：

```
import java.util.LinkedList;
 
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        lList.addFirst("0");
        System.out.println(lList);
        lList.addLast("6");
        System.out.println(lList);
    }
}
```
编译后的结果为：
```
[1, 2, 3, 4, 5]
[0, 1, 2, 3, 4, 5]
[0, 1, 2, 3, 4, 5, 6]
```
### Java 实例 - 获取链表（LinkedList）的第一个和最后一个元素
以下实例演示了如何使用 LinkedList 类的 linkedlistname.getFirst() 和 linkedlistname.getLast() 来获取链表的第一个和最后一个元素：

```
import java.util.LinkedList;
 
public class LinkedListDemo2 {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("100");
        lList.add("200");
        lList.add("300");
        lList.add("400");
        lList.add("500");
        System.out.println("链表的第一个元素是：" + lList.getFirst());
        System.out.println("链表的最后一个元素是：" + lList.getLast());
    }
}
```
编译后的结果为：
```
链表的第一个元素是：100
链表的最后一个元素是：500

```
### Java 实例 - 删除链表中的元素
以下实例演示了使用 clear() 方法来删除链表中的元素：

```
import java.util.*;
 
public class ClearLinkedListDemo {
   public static void main(String[] args) {
      LinkedList<String> lList = new LinkedList<String>();
      lList.add("1");
      lList.add("8");
      lList.add("6");
      lList.add("4");
      lList.add("5");
      System.out.println(lList);
      lList.subList(2, 4).clear();
      System.out.println(lList);
   }
}
```
编译后的结果为：
```
[1, 8, 6, 4, 5]

[1, 8, 5]

```
### Java 实例 - 获取链表的元素

以下实例演示了使用 top() 和 pop() 方法来获取链表的元素：

```
import java.util.*;
 
public class LinkedListDemo3 {
   private LinkedList list = new LinkedList();
   public void push(Object v) {
      list.addFirst(v);
   }
   public Object top() {
      return list.getFirst();
   }
   public Object pop() {
      return list.removeFirst();
   }
   public static void main(String[] args) {
      Main stack = new Main();
      for (int i = 30; i < 40; i++)
         stack.push(new Integer(i));
      System.out.println(stack.top());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
   }
}
```
编译后的结果为：
```
39
39
38
37
```
## Java 实例 - 获取向量元素的索引值
以下实例演示了使用 Collections 类的 sort() 方法对向量进行排序并使用 binarySearch() 方法来获取向量元素的索引值：

```
import java.util.Collections;
import java.util.Vector;
 
public class SortDemo {
   public static void main(String[] args) {
      Vector v = new Vector();
      v.add("X");
      v.add("M");
      v.add("D");
      v.add("A");
      v.add("O");
      Collections.sort(v);
      System.out.println(v);
      int index = Collections.binarySearch(v, "D");
      System.out.println("元素索引值为 : " + index);
   }
}
```
编译后的结果为：
```
[A, D, M, O, X]
元素索引值为 : 1
```
## Java 实例 - 栈的实现
以下实例演示了用户如何通过创建用于插入元素的自定义函数 push() 方法和用于弹出元素的 pop() 方法来实现栈：
```
public class MyStack {
   private int maxSize;
   private long[] stackArray;
   private int top;
   public MyStack(int s) {
      maxSize = s;
      stackArray = new long[maxSize];
      top = -1;
   }
   public void push(long j) {
      stackArray[++top] = j;
   }
   public long pop() {
      return stackArray[top--];
   }
   public long peek() {
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == -1);
   }
   public boolean isFull() {
      return (top == maxSize - 1);
   }
   public static void main(String[] args) {
      MyStack theStack = new MyStack(10); 
      theStack.push(10);
      theStack.push(20);
      theStack.push(30);
      theStack.push(40);
      theStack.push(50);
      while (!theStack.isEmpty()) {
         long value = theStack.pop();
         System.out.print(value);
         System.out.print(" ");
      }
      System.out.println("");
   }
}
```
编译后的结果为：
```
50 40 30 20 10
```
## Java 实例 - 链表元素查找
以下实例演示了使用 linkedlistname.indexof(element) 和 linkedlistname.Lastindexof(elementname) 方法在链表中获取元素第一次和最后一次出现的位置：

```
import java.util.LinkedList;
public class LinkSearchDemo {
   public static void main(String[] args) {
      LinkedList lList = new LinkedList();
      lList.add("1");
      lList.add("2");
      lList.add("3");
      lList.add("4");
      lList.add("5");
      lList.add("2");
      System.out.println("元素 2 第一次出现的位置：" + lList.indexOf("2"));
      System.out.println("元素 2 最后一次出现的位置：" + lList.lastIndexOf("2"));
   }
}
```
编译后的结果为：
```
元素 2 第一次出现的位置：1
元素 2 最后一次出现的位置：5
```
## Java 实例 - 压栈出栈的方法实现字符串反转
以下实例演示了使用用户自定义的方法 StringReverserThroughStack() 来实现字符串反转：// 这个用stack比较合适 后进先出
```
import java.io.IOException;
 
public class StringReverserThroughStack {
   private String input; 
   private String output;
   public StringReverserThroughStack(String in) {
      input = in;
   }
   public String doRev() {
      int stackSize = input.length(); 
      Stack theStack = new Stack(stackSize); 
      for (int i = 0; i < input.length(); i++) {
         char ch = input.charAt(i); 
         theStack.push(ch); 
      }
      output = "";
      while (!theStack.isEmpty()) {
         char ch = theStack.pop(); 
         output = output + ch; 
      }
      return output;
   }
   public static void main(String[] args) 
   throws IOException {
      String input = "www.w3cschool.cc";
      String output;
      StringReverserThroughStack theReverser = 
      new StringReverserThroughStack(input);
      output = theReverser.doRev();
      System.out.println("反转前： " + input);
      System.out.println("反转后： " + output);
   }
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      public void push(char j) {
         stackArray[++top] = j;
      }
      public char pop() {
         return stackArray[top--];
      }
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
      }
   }
}
```
编译后的结果为：
```
反转前： www.w3cschool.cc
反转后： cc.loohcsc3w.www
```
## Java 实例 - 队列（Queue）用法
队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
以下实例演示了队列（Queue）的用法：
```
import java.util.LinkedList;
import java.util.Queue;
 
public class QueueDemo {
    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素 
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素 
        for(String q : queue){
            System.out.println(q);
        }
    }
}
```
编译后的结果为：
```
a
b
c
d
e
===
poll=a
b
c
d
e
===
element=b
b
c
d
e
===
peek=b
b
c
d
e
```
## Java 实例 - 获取向量的最大元素
以下实例演示了使用 Vector 类的 v.add() 方法及 Collection 类的 Collections.max() 来获取向量的最大元素：

```
import java.util.Collections;
import java.util.Vector;
 
public class MaxVectorDemo {
   public static void main(String[] args) {
      Vector v = new Vector();
      v.add(new Double("3.4324"));
      v.add(new Double("3.3532"));
      v.add(new Double("3.342"));
      v.add(new Double("3.349"));
      v.add(new Double("2.3"));
      Object obj = Collections.max(v);
      System.out.println("最大元素是："+obj);
   }
}
```
编译后的结果为：
```
最大元素是：3.4324
```
## Java 实例 - 链表修改
```
import java.util.LinkedList;
 
public class LinkedListChangeDemo {
   public static void main(String[] a) {
      LinkedList officers = new LinkedList();
      officers.add("B");
      officers.add("B");
      officers.add("T");
      officers.add("H");
      officers.add("P");
      System.out.println(officers);
      officers.set(2, "M");
      System.out.println(officers);
   }
}
```
编译后的结果为：
```
[B, B, T, H, P]
[B, B, M, H, P]
```
## Java 实例 - 旋转向量
以下实例演示了使用 swap() 函数来旋转向量：

```
import java.util.Collections;
import java.util.Vector;
 
public class SwapDemo {
   public static void main(String[] args) {
      Vector<String> v = new Vector();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      System.out.println(v);
      Collections.swap(v, 0, 4);
      System.out.println("旋转后");
      System.out.println(v);
   }
}
```
编译后的结果为：
```
1 2 3 4 5 
旋转后
5 2 3 4 1
```


源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





