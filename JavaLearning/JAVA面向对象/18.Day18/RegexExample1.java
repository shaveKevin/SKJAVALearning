import java.util.regex.*;
public class RegexExample1 {
   public static void main(String args[]) {
      String content = "My site is " + "shavekevin.com";
      String pattern = ".*shavekevin.*";
      boolean isMatch = Pattern.matches(pattern, content);
      System.out.println("字符串中是否包含了 'shavekevin' 子字符串? " + isMatch);
   }
}
