# Java高级编程第10天
## Java环境变量实例

### Java 实例 - 如何编译 Java 文件

我们在[Java基础](https://github.com/shaveKevin/SKJAVALearning/blob/master/JavaLearning/JAVA%E5%9F%BA%E7%A1%80/1.Day01/1.Day01.md)中已经讲过了如何编译java文件。

*  javac 命令来编译 Java 文件

*  java 命令执行编译的文件

> 注意要编译java文件需要先编译后执行。

### Java 实例 - 如何执行编译过 Java 文件

```
public class HelloWorld {
    public static void main(String []args) {
       System.out.println("Hello World");
    }
}
```
接下来我们使用 javac 命令来编译 Java 文件，执行该命令后在当前目录下会生成一个 HelloWorld.class 文件，我们可以使用 java 命令执行编译的文件:
```
javac HelloWorld.java
java HelloWorld
```
以上代码实例输出结果为：
```
Hello World
```
### Java 实例 - 如何执行指定class文件目录（classpath）

如果我们 Java 编译后的class文件不在当前目录，我们可以使用 -classpath 来指定class文件目录：

```
C:> java -classpath C:\java\DemoClasses HelloWorld
```
以上命令中我们使用了 -classpath 参数指定了 HelloWorld 的 class 文件所在目录。

如果class文件在jar文件中，则命令如下:
```
c:> java -classpath C:\java\myclasses.jar
```
### Java 实例 - 如何查看当前 Java 运行的版本?

我们可以使用 -version 参数来查看当前 Java 的运行版本，命令如下：
```
java -version
```
以上代码实例输出结果为：
```
openjdk version "1.8.0_212"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_212-b03)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.212-b03, mixed mode)
```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





