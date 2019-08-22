/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:42:37
 * @LastEditors: Please set LastEditors
 */
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