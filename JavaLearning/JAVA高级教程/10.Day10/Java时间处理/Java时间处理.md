# Java高级编程第10天
## Java时间处理

## Java 实例 - 格式化时间（SimpleDateFormat）

以下实例演示了如何使用 SimpleDateFormat 类的 format(date) 方法来格式化时间

```
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class SimpleDateFormatDemo{
    public static void main(String[] args){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));
    }
}
```
编译后的结果为：
```
2019-08-14 10:05:07

```
## Java 实例 - 获取当前时间
```
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class CurrentDate{
    public static void main(String[] args){
        
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制） 
    } 
}
```
编译后的结果为：

```
现在时间：2019-08-14 10:08:34 上午
```
## Java 实例 - 获取年份、月份等
以下实例演示了如何使用 Calendar 类来输出年份、月份等：

```
import java.util.Calendar;
 
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);
 
        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
    }
}
```
编译后的结果为：

```
月份: 8
年份: 2019
一周的第几天: 4
一月中的第几天: 14
一年的第几天: 226
```
## Java 实例 - 时间戳转换成时间

以下实例演示了如何使用 SimpleDateFormat 类的 format() 方法将时间戳转换成时间。

日期和时间模式(注意大小写，代表的含义是不同的)
* yyyy：年
* MM：月
* dd：日
* hh：1~12小时制(1-12)
* HH：24小时制(0-23)
* mm：分
* ss：秒
* S：毫秒
* E：星期几
* D：一年中的第几天
* F：一月中的第几个星期(会把这个月总共过的天数除以7)
* w：一年中的第几个星期
* W：一月中的第几星期(会根据实际情况来算)
* a：上下午标识
* k：和HH差不多，表示一天24小时制(1-24)
* K：和hh差不多，表示一天12小时制(0-11)
* z：表示时区

```
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class DateDemo{
    public static void main(String[] args){
        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);
 
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd2);
   }
}
```
编译后的结果为：

```
格式化结果：2019-08-14 10:22:17
格式化结果：2019 年 08 月 14 日 10 时 22 分 17 秒

```
源地址：[Java 实例](https://www.runoob.com/java/java-examples.html)

github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)
 
		
 
		


		


		
	





