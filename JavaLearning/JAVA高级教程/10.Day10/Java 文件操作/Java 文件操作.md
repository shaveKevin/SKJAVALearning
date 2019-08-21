# Java高级编程第10天
## 文件操作
## Java 实例 - 文件写入

以下实例演示了使用 write() 方法向文件写入内容：

```
import java.io.*;
 
public class WriteDemo {
    public static void main(String[] args)  {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
            out.write("菜鸟教程");
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
    }
}
```
编译后的结果为：
```
文件创建成功！
```
创建成功后当前目录下就会生成一个名为 runoob.txt 的文件并将 "菜鸟教程" 字符串写入该文件。

## Java 实例 - 读取文件内容
以下实例演示了使用 readLine() 方法来读取文件 test.log 内容，其中 test.log 文件内容为：

菜鸟教程
www.runoob.com

```
import java.io.*;
 
public class ReadLineDemo {
    public static void main(String[] args)  {
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.log"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println(str);
        } catch (IOException e) {
        }
    }
}
```
编译后的结果为：
```
菜鸟教程
www.runoob.com
null
```
## Java 实例 - 删除文件

以下实例演示了使用 delete() 方法将文件删除：

```
import java.io.*;
 
public class DeleteDemo
{
    public static void main(String[] args)
    {
        try{
            File file = new File("c:\\test.txt");
            if(file.delete()){
                System.out.println(file.getName() + " 文件已被删除！");
            }else{
                System.out.println("文件删除失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

```
编译后的结果为(需要在 C 盘上先创建 test.txt 文件)：

```
test.txt 文件已被删除！
```
## Java 实例 - 将文件内容复制到另一个文件
以下实例演示了使用 BufferedWriter 类的 read 和 write 方法将文件内容复制到另一个文件：
```
import java.io.*;
 
public class CopyDemo {
    public static void main(String[] args) throws Exception {
        BufferedWriter out1 = new BufferedWriter(new FileWriter("srcfile"));
        out1.write("string to be copied\n");
        out1.close();
        InputStream in = new FileInputStream(new File("srcfile"));
        OutputStream out = new FileOutputStream
        (new File("destnfile"));
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        BufferedReader in1 = new BufferedReader(new FileReader("destnfile"));
        String str;
        while ((str = in1.readLine()) != null) {
            System.out.println(str);
        }
        in1.close();
    }
}
```
编译后的结果为：
```
string to be copied
```
## Java 实例 - 向文件中追加数据

以下实例演示了使用 filewriter 方法向文件中追加数据：
```
import java.io.*;
 
public class FilewriterDemo {
    
    public static void main(String[] args) throws Exception {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("filename"));
            out.write("aString1\n");
            out.close();
            out = new BufferedWriter(new FileWriter("filename",true));
            out.write("aString2");
            out.close();
            BufferedReader in = new BufferedReader(new FileReader("filename"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        }
            catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }
}
```
编译后的结果为:
```
aString1
aString2
```
## Java 实例 - 创建临时文件
以下实例演示了使用 File 类的 createTempFile(String prefix, String suffix); 方法在默认临时目录来创建临时文件，参数 prefix 为前缀，suffix 为后缀：

```
import java.io.*;
 
public class TempFileDemo {
    public static void main(String[] args) throws Exception {
        File temp = File.createTempFile("testrunoobtmp", ".txt");
        System.out.println("文件路径: "+temp.getAbsolutePath());
        temp.deleteOnExit();
        BufferedWriter out = new BufferedWriter(new FileWriter(temp));
        out.write("aString");
        System.out.println("临时文件已创建:");
        out.close();
    }
}
```
也可以使用 `createTempFile(String prefix, String suffix, File directory)` 中的 directory 参数来指定临时文件的目录：
```
import java.io.File;
 
public class CreateFileDemo {
 
   public static void main(String[] args) {      
      File f = null;
            
      try {
      
         // 创建临时文件
         f = File.createTempFile("tmp", ".txt", new File("C:/"));
         
         // 输出绝对路径
         System.out.println("File path: "+f.getAbsolutePath());
         
         // 终止后删除临时文件
         f.deleteOnExit();
         
         // 创建临时文件
         f = File.createTempFile("tmp", null, new File("D:/"));
         
         // 输出绝对路径
         System.out.print("File path: "+f.getAbsolutePath());
         
         // 终止后删除临时文件
         f.deleteOnExit();
         
      } catch(Exception e) {
      
         // 如果有错误输出内容
         e.printStackTrace();
      }
   }
}
```
## Java 实例 - 修改文件最后的修改日期
以下实例演示了使用 File 类的 fileToChange.lastModified() 和 fileToChange setLastModified() 方法来修改文件最后的修改日期：
```
import java.io.File;
import java.util.Date;
 
public class FixFileDemo {
    public static void main(String[] args) throws Exception {
        File fileToChange = new File("C:/myjavafile.txt");
        fileToChange.createNewFile();
        Date filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));
        filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
    }
}
```
编译后的结果为：
```
Sat Mar 21 22:00:48 CST 2015
true
Fri Apr 10 11:09:19 CST 2015
```
## Java 实例 - 获取文件大小
以下实例演示了使用 File 类的 file.exists() 和 file.length() 方法来获取文件大小，以字节计算（1KB=1024字节 ）：

```
import java.io.File;
 
public class ExistFileDemo {
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
    public static void main(String[] args) {
        long size = getFileSize("c:/java.txt");
        System.out.println("java.txt文件大小为: " + size);
    }
}
```
编译后的结果为:
```
java.txt文件大小为: 480
```
## Java 实例 - 文件重命名
以下实例演示了使用 File 类的 oldName.renameTo(newName) 方法来重命名文件：

```
import java.io.File;
 
public class RenameDemo {
    public static void main(String[] args) {
        File oldName = new File("C:/program.txt");
        File newName = new File("C:/java.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
    }
}
```
编译后的结果为（执行该程序前你可以先创建 program.txt 文件）：
```
已重命名
```
## Java 实例 - 设置文件只读

以下实例演示了使用 File 类的 file.setReadOnly() 和 file.canWrite() 方法来设置文件只读：

```
import java.io.File;
 
public class ReadOnlyDemo {
    public static void main(String[] args) {
        File file = new File("C:/java.txt");
        System.out.println(file.setReadOnly());
        System.out.println(file.canWrite());
    }
}
```
以上代码运行输出结果为：
```
true
false
```

## Java 实例 - 检测文件是否存在

以下实例演示了使用 File 类的 file.exists() 方法来检测文件是否存在：

```
import java.io.File;
 
public class ExistDemo {
    public static void main(String[] args) {
        File file = new File("C:/java.txt");
        System.out.println(file.exists());
    }
}
```
编译后的结果为:
```
true
```
## Java 实例 - 在指定目录中创建文件

以下实例演示了使用 File 类的 file.createTempFile() 方法在指定目录中创建文件：

```
import java.io.File;
 
public class CreateDocDemo {
    public static void main(String[] args) throws Exception {
        File file = null;
        File dir = new File("C:/");
        file = File.createTempFile
        ("JavaTemp", ".javatemp", dir);
        System.out.println(file.getPath());
    }
}
```
编译后的结果为：
```
C:\JavaTemp37056.javatemp
```
## Java 实例 - 获取文件修改时间
以下实例演示了使用 File 类的 file.lastModified() 方法来获取文件最后的修改时间
```
import java.io.File;
import java.util.Date;
 
public class ChangeTimeDemo {
    public static void main(String[] args) {
        File file = new File("ChangeTimeDemo.java");
        Long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        System.out.println(date);
    }
}
```
编译后的结果为：
```
Thu Jan 01 08:00:00 CST 1970
```
## Java 实例 - 创建文件
以下实例演示了使用 File 类的 File() 构造函数和 file.createNewFile() 方法来创建一个新的文件

```
import java.io.File;
import java.io.IOException;
 
public class SKCreateDemo {
    public static void main(String[] args) {
        try{
            File file = new File("C:/myfile.txt");
            if(file.createNewFile())
                System.out.println("文件创建成功！");
            else
                System.out.println("出错了，该文件已经存在。");
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
```
编译后的结果为：
```
文件创建成功！
```
## Java 实例 - 文件路径比较
以下实例演示了使用 File 类的 filename.compareTo (another filename) 方法来比较两个文件路径是否在同一个目录下：

```
import java.io.File;
 
public class FilenameDemo {
    public static void main(String[] args) {
        File file1 = new File("C:/File/demo1.txt");
        File file2 = new File("C:/java/demo1.txt");
        if(file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }
}
```
编译后的结果为:
```
文件路径不一致！
```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





