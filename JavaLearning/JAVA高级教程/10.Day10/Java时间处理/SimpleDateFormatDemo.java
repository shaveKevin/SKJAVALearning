/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-14 10:05:05
 * @LastEditors: Please set LastEditors
 */
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