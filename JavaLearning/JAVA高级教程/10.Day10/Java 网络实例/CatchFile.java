/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 17:46:34
 * @LastEditors: Please set LastEditors
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
 
public class CatchFile {
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