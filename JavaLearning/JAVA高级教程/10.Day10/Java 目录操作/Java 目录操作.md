# Java高级编程第10天
## Java 目录操作

### Java 实例 - 递归创建目录
以下实例演示了使用 File 类的 mkdirs() 实现递归创建目录 ：

```
import java.io.File;
 
public class MkdirDemo {
    public static void main(String[] args) {
        String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
        File file = new File(directories);
        boolean result = file.mkdirs();
        System.out.println("Status = " + result);
    }
}
```
编译后的结果为：
```
Status = true
```
## Java 实例 - 删除目录
以下实例演示了使用 File 类的 ofdir.isDirectory(), dir.list() 和 deleteDir() 方法在一个个删除文件后删除目录 ：
```
import java.io.File;
 
public class DeleteFileDemo {
    public static void main(String[] argv) throws Exception {
        // 删除当前目录下的 test 目录
        deleteDir(new File("./test"));
    }
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir
                (new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        if(dir.delete()) {
            System.out.println("目录已被删除！");
            return true;
        } else {
            System.out.println("目录删除失败！");
            return false;
        }
    }
}
```
编译后的结果为：
```
目录已被删除！
```
## Java 实例 - 判断目录是否为空
以下实例演示了使用 File 类的 file.isDirectory() 和 file.list() 方法来判断目录是否为空：

```
import java.io.File;
 
public class ExistDirDemo
{
    public static void main(String[] args)
    {
        File file = new File("./testdir");  // 当前目录下的 testdir目录
        if(file.isDirectory()){
            if(file.list().length>0){
                System.out.println("目录不为空!");
            }else{
                System.out.println("目录为空!");
            }
        }else{
            System.out.println("这不是一个目录!");
        }
    }
}
```
编译后的结果为：
```
这不是一个目录!
```
## Java 实例 - 判断文件是否隐藏
以下实例演示了使用 File 类的 file.isHidden() 方法来判断文件是否隐藏：

```
import java.io.File;
 
public class HiddenFileDemo {
    public static void main(String[] args) {
        File file = new File("C:/Demo.txt");
        System.out.println(file.isHidden());
    }
}
```
编译后的结果为（Demo.txt为隐藏文件）：
```
True
```
## Java 实例 - 获取目录大小
以下实例演示了使用 File 类的 FileUtils.sizeofDirectory(File Name) 来获取目录的大小：

```
import java.io.File;
import org.apache.commons.io.FileUtils;
 
public class FileSizeDemo {
    public static void main(String[] args) {
        long size = FileUtils.sizeOfDirectory(new File("C:/test"));
        System.out.println("Size: " + size + " bytes");
    }
}
```
编译后的结果为：
```
Size: 2048 bytes
```
## Java 实例 - 在指定目录中查找文件
```
import java.io.File;
 
public class SearchFileDemo {
    public static void main(String[] argv) throws Exception {
        File dir = new File("../java");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }
}
```
编译后的结果为：
```
Car.class
FileUtil.class
FileUtil.java
HelloWorld.class
HelloWorld.java
HelloWorldDebug.class
HelloWorldDebug.java
……
```
## Java 实例 - 获取文件的上级目录
以下实例演示了使用 File 类的 file.getParent() 方法来获取文件的上级目录：

```
import java.io.File;
 
public class ParentDirectoryDemo {
    public static void main(String[] args) {
        File file = new File("C:/File/demo.txt");
        String strParentDirectory = file.getParent();
        System.out.println("文件的上级目录为 : " + strParentDirectory);
    }
}
```
编译后的结果为：
```
文件的上级目录为 : File
```
## Java 实例 - 获取目录最后修改时间
以下实例演示了使用 File 类的 file.lastModified() 方法来获取目录的最后修改时间：
```
import java.io.File;
import java.util.Date;
 
public class LastUpdateDemo {
    public static void main(String[] args) {
        File file = new File("C://FileIO//demo.txt");
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
    }
}
```
编译后的结果为：
```
最后修改时间：Fri Apr 10 11:09:19 CST 2015
```
## Java 实例 - 打印目录结构
以下实例演示了使用 File 类的 file.getName() 和 file.listFiles() 方法来打印目录结构：
```
import java.io.File;
import java.io.IOException;
 
public class FileUtil {
    public static void main(String[] a)throws IOException{
        showDir(1, new File("d:\\Java"));
    }
    static void showDir(int indent, File file) throws IOException {
        for (int i = 0; i < indent; i++)
            System.out.print('-');
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
                showDir(indent + 4, files[i]);
        }
    }
}
```
编译后的结果为：
```
-Java
-----codes
---------string.txt
---------array.txt
-----w3cschoolcc
```
## Java 实例 - 遍历指定目录下的所有目录
以下实例演示了如何使用 File 类的 list 方法来遍历指定目录下的所有目录：

```
import java.io.*;
 
class FilterListDemo {
   public static void main(String[] args) {
      File dir = new File("F:");
      File[] files = dir.listFiles();
      FileFilter fileFilter = new FileFilter() {
         public boolean accept(File file) {
            return file.isDirectory();
         }
      };
      files = dir.listFiles(fileFilter);
      System.out.println(files.length);
      if (files.length == 0) {
         System.out.println("目录不存在或它不是一个目录");
      }
      else {
         for (int i=0; i< files.length; i++) {
            File filename = files[i];
            System.out.println(filename.toString());
         }
      }
   }
}
```
编译后的结果为：
```
14
F:\C Drive Data Old HDD
F:\Desktop1
F:\harsh
F:\hharsh final
F:\hhhh
F:\mov
F:\msdownld.tmp
F:\New Folder
F:\ravi
F:\ravi3
F:\RECYCLER
F:\System Volume Information
F:\temp
F:\work
```
## Java 实例 - 输出指定目录下的所有文件
以下实例演示了如何使用 File 类的 list 方法来输出指定目录下的所有文件：
```
class PrintFileListDemo {
    public static void main(String[] args) {
        File dir = new File("C:");
        String[] children = dir.list();
        if (children == null) {
            System.out.println( "目录不存在或它不是一个目录");
        }
        else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }
}
```
编译后的结果为：
```
build
build.xml
destnfile
detnfile
filename
manifest.mf
nbproject
outfilename
src
srcfile
test
```
## Java 实例 - 在指定目录中查找文件
以下实例演示了在 C 盘中查找以字母 'b' 开头的所有文件：
```
import java.io.*;
 
class FilenameFilterDemo {
   public static void main(String[] args) {
      File dir = new File("C:");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept
         (File dir, String name) {
            return name.startsWith("b");
        }
      };
      String[] children = dir.list(filter);
      if (children == null) {
         System.out.println("目录不存在或它不是一个目录");
      } 
      else {
         for (int i=0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      } 
   }
}
```
编译后的结果为:
```
build
build.xml
```
## Java 实例 - 查看系统根目录
以下实例演示了使用 File 类的 listRoots() 方法来输出系统所有根目录：


```
import java.io.*;
 
class RootListDemo {
    public static void main(String[] args){
        File[] roots = File.listRoots();
        System.out.println("系统所有根目录：");
        for (int i=0; i < roots.length; i++) {
            System.out.println(roots[i].toString());
        }
    }
}
```
编译后的结果为：
```
系统所有根目录：
C:\
D:\
E:\
F:\
G:\
H:\
```
## Java 实例 - 查看当前工作目录

以下实例演示了使用 System 的 getProperty() 方法来获取当前的工作目录：

```
class CurrentDirDemo {
    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");
        System.out.println("你当前的工作目录为 :" + curDir);
    }
}
```
编译后的结果为：
```
你当前的工作目录为 :/www/java
```


## Java 实例 - 遍历目录
以下实例演示了使用 File 类的 dir.isDirectory() 和 dir.list() 方法来遍历目录：


```
import java.io.File;
 
public class SortDemo {
    public static void main(String[] argv) throws Exception {
        System.out.println("遍历目录");
        File dir = new File("/www/java"); //要遍历的目录
        visitAllDirsAndFiles(dir);
    }
    public static void visitAllDirsAndFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                visitAllDirsAndFiles(new File(dir, children[i]));
            }
        }
    }
}
```
编译后的结果为：
```
遍历目录
/www/java
/www/java/Car.class
/www/java/FileUtil.class
/www/java/FileUtil.java
/www/java/HelloWorld.class
/www/java/HelloWorld.java
/www/java/HelloWorldDebug.class
/www/java/HelloWorldDebug.java
/www/java/Main$1.class
/www/java/Main.class
/www/java/Main.java
/www/java/MainClass.class
/www/java/MainClass.java
/www/java/MyClass.class
/www/java/outfilename
/www/java/test.log
```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





