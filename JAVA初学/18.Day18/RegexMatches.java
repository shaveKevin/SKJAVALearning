import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
   public static void main(String args[]) {
      String line = "this order was placed for qt3000! ok?";
      String pattern = "(\\D*)(\\d*)(.*)";
      // 创建Pattern对象
      Pattern r = Pattern.compile(pattern);
      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      if (m.find()) {
         System.out.println("Found value: " + m.group(0));
         System.out.println("Found value: " + m.group(1));
         System.out.println("Found value: " + m.group(2));
         System.out.println("Found value: " + m.group(3));
      } else {
         System.out.println("NO MATCH");
      }
   }
}
