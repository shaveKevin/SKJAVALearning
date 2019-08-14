/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-14 09:58:43
 * @LastEditors: Please set LastEditors
 */
import java.util.Arrays;
 
public class ArrayEqualDemo {
    public static void main(String[] args) throws Exception {
        int[] ary = {1,2,3,4,5,6};
        int[] ary1 = {1,2,3,4,5,6};
        int[] ary2 = {1,2,3,4};
        System.out.println("数组 ary 是否与数组 ary1相等? ："
        +Arrays.equals(ary, ary1));
        System.out.println("数组 ary 是否与数组 ary2相等? ："
        +Arrays.equals(ary, ary2));
    }
}