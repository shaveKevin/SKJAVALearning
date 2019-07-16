import java.io.*;

public class CreateDir {
   public static void main(String args[]) throws IOException {
      String dirname = "/Users/houzhiwei/GitHubDemo/SKJAVALearning/JAVA初学/20.Day20/java";
      File d = new File(dirname);
      // 现在创建目录
      d.mkdirs();
   }

}
