

public class StringDemo {
 
   public static void main(String args[]) {

   char[] helloWorldArray = {'h','e','l','l','o',',','J','a','v','a'};
   String helloWorldString  = new String(helloWorldArray);
   System.out.println(helloWorldString);

   String site = "http://www.shavekevin.com";
   int len = site.length();
   System.out.println("秦小风网址的长度是：" + len);

   String string1 = "秦小风的网址是：";
   System.out.println("1." + string1 + "http://www.shavekevin.com");

   float floatVar = 99.90f;
   int intVar = 99;
   String stringVar = "99";

   System.out.printf("浮点型变量的值为：" + "%f,整型变量的值为：" + " %d, 字符串变量的值为：" + "%s",floatVar,intVar,stringVar);
   System.out.println('\n');
   String printStr;
   printStr = String.format("浮点型变量的值为：" + "%f,整型变量的值为：" + " %d, 字符串变量的值为：" + "%s",floatVar,intVar,stringVar);
   System.out.println(printStr);

   }
}
