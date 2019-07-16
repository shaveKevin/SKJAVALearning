import java.util.*;
import java.text.*;

public class DateDemo1 {
   public static void main(String args[]) {
      Date date = new Date();
      String str = String.format(Locale.US, "英文月份简称：%tb", date);
      System.out.println(str);
      System.out.printf("本地月份简称：%tb%n", date);
      // B的使用，月份全称
      str = String.format(Locale.US, "英文月份全称：%tB", date);
      System.out.println(str);
      System.out.printf("本地月份全称：%tB%n", date);
      // a的使用，星期简称
      str = String.format(Locale.US, "英文星期的简称：%ta", date);
      System.out.println(str);
      // A的使用，星期全称
      System.out.printf("本地星期的简称：%tA%n", date);
      // C的使用，年前两位
      System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
      // y的使用，年后两位
      System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
      // j的使用，一年的天数
      System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
      // m的使用，月份
      System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
      // d的使用，日（二位，不够补零）
      System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
      // e的使用，日（一位不补零）
      System.out.printf("月份的日（前面不补0）：%te", date);
      System.out.printf("\n");

      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
      String input = args.length == 0 ? "1818-11-11" : args[0];
      System.out.print(input + " Parses as ");
      Date t;
      try {
         t = ft.parse(input);
         System.out.println(t);
      } catch (ParseException e) {
         System.out.println("Unparseable using " + ft);
      }
   }
}
