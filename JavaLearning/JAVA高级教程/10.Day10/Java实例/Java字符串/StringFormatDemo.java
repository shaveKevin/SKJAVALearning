/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-12 10:09:24
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
 
public class StringFormatDemo {
    public static void main(String[] args){
        double e = Math.E;
        System.out.format("%f%n", e);
        System.out.format(Locale.CHINA  , "%-10.4f%n%n", e);  //指定本地为中国（CHINA）
    }
}