
## Java URL处理

URL（Uniform Resource Locator）中文名为统一资源定位符，有时也被俗称为网页地址。表示为互联网上的资源，如网页或者FTP地址。

本章节我们将介绍Java是如处理URL的。URL可以分为如下几个部分。
```
protocol://host:port/path?query#fragment
```
protocol(协议)可以是 HTTP、HTTPS、FTP 和 File，port 为端口号，path为文件路径及文件名。

HTTP 协议的 URL 实例如下:
```
http://www.runoob.com/index.html?language=cn#j2se
```
URL 解析：

* 协议为(protocol)：http

* 主机为(host:port)：www.runoob.com

* 端口号为(port): 80 ，以上URL实例并未指定端口，因为 HTTP 协议默认的端口号为 80。

* 文件路径为(path)：/index.html

* 请求参数(query)：language=cn

* 定位位置(fragment)：j2se，定位到网页中 id 属性为 j2se 的 HTML 元素位置 。

## URL 类方法

在java.net包中定义了URL类，该类用来处理有关URL的内容。对于URL类的创建和使用，下面分别进行介绍。

java.net.URL提供了丰富的URL构建方式，并可以通过java.net.URL来获取资源。

| 序号  | 方法描述  | 
| ------ | ------ |
|1|public URL(String protocol, String host, int port, String file) throws MalformedURLException. 通过给定的参数(协议、主机名、端口号、文件名)创建URL。|
|2|public URL(String protocol, String host, String file) throws MalformedURLException 使用指定的协议、主机名、文件名创建URL，端口使用协议的默认端口。|
|3|public URL(String url) throws MalformedURLException 通过给定的URL字符串创建URL|
|4|public URL(URL context, String url) throws MalformedURLException 使用基地址和相对URL创建|

URL类中包含了很多方法用于访问URL的各个部分，具体方法及描述如下：

| 序号  | 方法描述  | 
| ------ | ------ |
|1|public String getPath() 返回URL路径部分。|
|2|public String getQuery() 返回URL查询部分。|
|3|public String getAuthority() 获取此 URL 的授权部分。|
|4|public int getPort()  返回URL端口部分。|
|5|public int getDefaultPort() 返回协议的默认端口号。|
|6|public String getProtocol()返回URL的协议。|
|7|public String getHost() 返回URL的主机。|
|8|public String getFile() 返回URL文件名部分。|
|9|public String getRef() 获取此 URL 的锚点（也称为"引用"）。|
|10|public URLConnection openConnection() throws IOException 打开一个URL连接，并运行客户端访问资源。|

## 实例

以上实例演示了使用java.net的URL类获取URL的各个部分参数：
```
import java.io.*;
import java.net.*;

public class URLDemo {
	public static void main(String[] args) {

		try {
			URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
			System.out.println("URL 为：" + url.toString());
			System.out.println("协议为：" + url.getProtocol());
			System.out.println("验证信息：" + url.getAuthority());
			System.out.println("文件名及请求参数：" + url.getFile());
			System.out.println("主机名：" + url.getHost());
			System.out.println("路径：" + url.getPath());
			System.out.println("端口：" + url.getPort());
			System.out.println("默认端口：" + url.getDefaultPort());
			System.out.println("请求参数：" + url.getQuery());
			System.out.println("定位位置：" + url.getRef());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
```
编译后的结果为：

```
URL 为：http://www.runoob.com/index.html?language=cn#j2se
协议为：http
验证信息：www.runoob.com
文件名及请求参数：/index.html?language=cn
主机名：www.runoob.com
路径：/index.html
端口：-1
默认端口：80
请求参数：language=cn
定位位置：j2se
```
## URLConnections 类方法

openConnection() 返回一个 java.net.URLConnection。
例如：

* 如果你连接HTTP协议的URL, openConnection() 方法返回 HttpURLConnection 对象。

* 如果你连接的URL为一个 JAR 文件, openConnection() 方法将返回 JarURLConnection 对象。

* 等等。

URLConnection 方法列表如下：

| 序号  | 方法描述  | 
| ------ | ------ |
|1|Object getContent() 检索URL链接内容|
|2|Object getContent(Class[] classes)  检索URL链接内容|
|3|String getContentEncoding() 检索URL链接内容|
|4|int getContentLength() 返回头部 content-length字段值|
|5|String getContentType() 返回头部 content-type 字段值|
|6|int getLastModified() 返回头部 last-modified 字段值。|
|7|long getExpiration()  返回头部 expires 字段值。|
|8|long getIfModifiedSince() 返回对象的 ifModifiedSince 字段值。|
|9|public void setDoInput(boolean input) URL 连接可用于输入和/或输出。如果打算使用 URL 连接进行输入，则将 DoInput 标志设置为 true；如果不打算使用，则设置为 false。默认值为 true。|
|10|public void setDoOutput(boolean output)URL 连接可用于输入和/或输出。如果打算使用 URL 连接进行输出，则将 DoOutput 标志设置为 true；如果不打算使用，则设置为 false。默认值为 false。|
|11|public InputStream getInputStream() throws IOException返回URL的输入流，用于读取资源|
|12|public OutputStream getOutputStream() throws IOException 返回URL的输出流, 用于写入资源。|
|13|public URL getURL() 返回 URLConnection 对象连接的URL|

## 实例
以下实例中URL采用了HTTP 协议。 openConnection 返回HttpURLConnection对象。

```
import java.io.*;
import java.net.*;

public class URLConnDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.baidu.com/");
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = null;
			if (urlConnection instanceof HttpURLConnection) {
				connection = (HttpURLConnection) urlConnection;
			} else {
				System.out.println("请输入 URL 地址");
				return;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
			}
			System.out.println(urlString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
```
编译后的结果为：
```
<!DOCTYPE html><!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always na
me=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body l
ink=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo
1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <in
put type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr">
<input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn
" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>
hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_tr
tieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登
录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === ""
 ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');                </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;"
>更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>
```


源地址：[Java URL处理](https://www.runoob.com/java/java-url-processing.html)
github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
