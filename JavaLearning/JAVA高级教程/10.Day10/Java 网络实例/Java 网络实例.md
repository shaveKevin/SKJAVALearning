# Java高级编程第10天
## Java 网络实例

## Java 实例 - 获取指定主机的IP地址
```
import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class GetIP {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.runoob.com");
        }
        catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
        System.exit(0);
    }
}
```
编译后的结果为：
```
www.runoob.com=112.29.200.90

```
## Java 实例 - 查看端口是否已使用

以下实例演示了如何检测端口是否已经使用：

```
import java.net.*;
import java.io.*;
 
public class DorminUse {
   public static void main(String[] args) {
      Socket Skt;
      String host = "localhost";
      if (args.length > 0) {
         host = args[0];
      }
      for (int i = 0; i < 1024; i++) {
         try {
            System.out.println("查看 "+ i);
            Skt = new Socket(host, i);
            System.out.println("端口 " + i + " 已被使用");
         }
         catch (UnknownHostException e) {
            System.out.println("Exception occured"+ e);
            break;
         }
         catch (IOException e) {
         }
      }
   }
}
```
编译后的结果为：
```
……
查看 17
查看 18
查看 19
查看 20
查看 21
端口 21 已被使用
查看 22
查看 23
查看 24
……
```
## Java 实例 - 获取本机ip地址及主机名
以下实例演示了如何使用 InetAddress 类的 getLocalAddress() 方法获取本机ip地址及主机名：


```
import java.net.InetAddress;
 
public class InetAddress {
   public static void main(String[] args) 
   throws Exception {
      InetAddress addr = InetAddress.getLocalHost();
      System.out.println("Local HostAddress: 
      "+addr.getHostAddress());
      String hostname = addr.getHostName();
      System.out.println("Local host name: "+hostname);
   }
}
```
编译后的结果为：
```
Local HostAddress: 192.168.1.4
Local host name: harsh

```
## Java 实例 - 获取远程文件大小

```
import java.net.URL;
import java.net.URLConnection;
 
public class URLConnectionDemo {
   public static void main(String[] args) throws Exception {
      int size;
      URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
      URLConnection conn = url.openConnection();
      size = conn.getContentLength();
      if (size < 0)
          System.out.println("无法获取文件大小。");
      else
        System.out.println("文件大小为：" + size + " bytes");
      conn.getInputStream().close();
   }
}
```
编译后的结果为：
```
文件大小为：278 bytes
```
## Java 实例 - Socket 实现多线程服务器程序
以下实例演示了如何使用 Socket 类的 accept() 方法和 ServerSocket 类的 MultiThreadServer(socketname) 方法来实现多线程服务器程序：


```
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class MultiThreadServer implements Runnable {
   Socket csocket;
   MultiThreadServer(Socket csocket) {
      this.csocket = csocket;
   }
 
   public static void main(String args[]) 
   throws Exception {
      ServerSocket ssock = new ServerSocket(1234);
      System.out.println("Listening");
      while (true) {
         Socket sock = ssock.accept();
         System.out.println("Connected");
         new Thread(new MultiThreadServer(sock)).start();
      }
   }
   public void run() {
      try {
         PrintStream pstream = new PrintStream
         (csocket.getOutputStream());
         for (int i = 100; i >= 0; i--) {
            pstream.println(i + 
            " bottles of beer on the wall");
         }
         pstream.close();
         csocket.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }
}
```
编译后的结果为：
```
Listening
Connected

```
## Java 实例 - 查看主机指定文件的最后修改时间
以下实例演示了如何查看主机指定文件的最后修改时间：


```
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.text.SimpleDateFormat;
 
public class FileChangeTime {
    public static void main(String[] argv) throws Exception {
        URL u = new URL("http://127.0.0.1/test/test.html");
        URLConnection uc = u.openConnection();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        uc.setUseCaches(false);
        long timestamp = uc.getLastModified();
        System.out.println("test.html 文件最后修改时间 :" + ft.format(new Date(timestamp)));
    }
}
```
编译后的结果为：
```
test.html 文件最后修改时间 :2019-08-22 10:06:04
```
## Java 实例 - 使用 Socket 连接到指定主机
以下实例演示了如何使用 net.Socket 类的 getInetAddress() 方法来连接到指定主机：
```
import java.net.InetAddress;
import java.net.Socket;
 
public class WebPing {
    public static void main(String[] args) {
        try {
            InetAddress addr;
            Socket sock = new Socket("www.runoob.com", 80);
            addr = sock.getInetAddress();
            System.out.println("连接到 " + addr);
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("无法连接 " + args[0]);
            System.out.println(e);
        }
    }
}
```
编译后的结果为：
```
连接到 http:/www.runoob.com/222.73.134.120
```
## Java 实例 - 网页抓取
以下实例演示了如何使用 net.URL 类的 URL() 构造函数来抓取网页：


```
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
 
public class Main {
   public static void main(String[] args) 
   throws Exception {
      URL url = new URL("http://www.runoob.com");
      BufferedReader reader = new BufferedReader
      (new InputStreamReader(url.openStream()));
      BufferedWriter writer = new BufferedWriter
      (new FileWriter("data.html"));
      String line;
      while ((line = reader.readLine()) != null) {
         System.out.println(line);
         writer.write(line);
         writer.newLine();
      }
      reader.close();
      writer.close();
   }
}
```
编译后的结果为：
```
<!DOCTYPE html> <html> <head> <meta charset="UTF-8"/> <meta http-equiv="X-UA-Compatible" content="IE=11,IE=10,IE=9,IE=8"/>……
```
## Java 实例 - 获取 URL响应头的日期信息
以下实例演示了如何使用 HttpURLConnection 的 httpCon.getDate() 方法来获取 URL响应头的日期信息：


```
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
 
public class URLConnectionHeader {
   public static void main(String args[]) 
   throws Exception {
      URL url = new URL("http://www.runoob.com");
      HttpURLConnection httpCon = 
      (HttpURLConnection) url.openConnection();
      long date = httpCon.getDate();
      if (date == 0)
      System.out.println("无法获取信息。");
      else
      System.out.println("Date: " + new Date(date));
   }
}
```
编译后的结果为：
```
Date: Thu Aug 22 17:47:36 CST 2019
```
## Java 实例 - 获取 URL 响应头信息
以下实例演示了如何获取指定 URL 的响应头信息：

```
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
 
public class URLConnectionHeaderDemo {
    public static void main(String[] args) throws IOException{
        URL url = new URL("http://www.runoob.com");
        URLConnection conn = url.openConnection();
        
        Map headers = conn.getHeaderFields();
        Set<String> keys = headers.keySet();
        for( String key : keys ){
            String val = conn.getHeaderField(key);
            System.out.println(key+"    "+val);
        }
        System.out.println( conn.getLastModified() );
    }
}
```
编译后的结果为：
```
null    HTTP/1.1 301 Moved Permanently
Server    Tengine
Timing-Allow-Origin    *
Connection    keep-alive
Content-Length    278
EagleId    6f209ecf15664673642488644e
Date    Thu, 22 Aug 2019 09:49:24 GMT
Via    cache7.cn1159[,0]
Location    https://www.runoob.com/
Content-Type    text/html
0
```
##  Java 实例 - 解析 URL
以下实例演示了如何使用 net.URL 类的 url.getProtocol() ,url.getFile() 等方法来解析 URL 地址：

```
import java.net.URL;
 
public class AnalySURLDemo {
   public static void main(String[] args) 
   throws Exception {
      URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
      System.out.println("URL 是 " + url.toString());
      System.out.println("协议是 " + url.getProtocol());
      System.out.println("文件名是 " + url.getFile());
      System.out.println("主机是 " + url.getHost());
      System.out.println("路径是 " + url.getPath());
      System.out.println("端口号是 " + url.getPort());
      System.out.println("默认端口号是 " 
      + url.getDefaultPort());
   }
}
```
编译后的结果为：
```
URL 是 http://www.runoob.com/html/html-tutorial.html
协议是 http
文件名是 /html/html-tutorial.html
主机是 www.runoob.com
路径是 /html/html-tutorial.html
端口号是 -1
默认端口号是 80
```
##  Java 实例 - ServerSocket 和 Socket 通信实例
以下实例演示了如何实现客户端发送消息到服务器，服务器接收到消息并读取输出，然后写出到客户端客户端接收到输出。

1、建立服务器端
* 服务器建立通信ServerSocket

* 服务器建立Socket接收客户端连接

* 建立IO输入流读取客户端发送的数据

* 建立IO输出流向客户端发送数据消息


```
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
   public static void main(String[] args) {
      try {
         ServerSocket ss = new ServerSocket(8888);
         System.out.println("启动服务器....");
         Socket s = ss.accept();
         System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");
         
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         //读取客户端发送来的消息
         String mess = br.readLine();
         System.out.println("客户端："+mess);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
         bw.write(mess+"\n");
         bw.flush();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
```
编译后的结果为：
```
启动服务器....

```

2、建立客户端
* 创建Socket通信，设置通信服务器的IP和Port

* 建立IO输出流向服务器发送数据消息

* 建立IO输入流读取服务器发送来的数据消息

```
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class Client {
   public static void main(String[] args) {
      try {
         Socket s = new Socket("127.0.0.1",8888);
         
         //构建IO
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //向服务器端发送一条消息
         bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
         bw.flush();
         
         //读取服务器返回的消息
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         System.out.println("服务器："+mess);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
```
编译后的结果为：
```
服务器：测试客户端和服务器通信，服务器接收到消息返回到客户端

```

源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





