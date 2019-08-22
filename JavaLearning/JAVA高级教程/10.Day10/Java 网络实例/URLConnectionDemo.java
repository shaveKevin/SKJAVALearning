/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:37:29
 * @LastEditors: Please set LastEditors
 */
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