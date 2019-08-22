/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:47:33
 * @LastEditors: Please set LastEditors
 */
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
 
public class URLConnectionHeader{
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