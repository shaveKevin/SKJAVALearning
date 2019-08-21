/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-12 09:34:50
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
 
public class StringTokenizerDemo {
    public static void main(String[] args) {
 
        String str = "This is String , split by StringTokenizer, created by runoob";
        StringTokenizer st = new StringTokenizer(str);
 
        System.out.println("----- 通过空格分隔 ------");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
 
        System.out.println("----- 通过逗号分隔 ------");
        StringTokenizer st2 = new StringTokenizer(str, ",");
 
        while (st2.hasMoreElements()) {
            System.out.println(st2.nextElement());
        }
    }
}