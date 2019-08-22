/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:49:21
 * @LastEditors: Please set LastEditors
 */
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