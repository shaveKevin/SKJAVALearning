
/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:16:28
 * @LastEditors: Please set LastEditors
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachDemoPlus {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println("----------使用 for 循环------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("---------使用 For-Each 循环-------------");

        // 增强的 for 循环 For-Each
        for (int element : arr) {
            System.out.println(element);
        }

        System.out.println("---------For-Each 循环二维数组-------------");

        // 遍历二维数组
        int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int[] row : arr2) {
            for (int element : row) {
                System.out.println(element);
            }
        }

        // 以三种方式遍历集合 List
        List<String> list = new ArrayList<String>();

        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");

        System.out.println("----------方式1：普通for循环-----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------方式2：使用迭代器-----------");
        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        System.out.println("----------方式3：For-Each 循环-----------");
        for (String str : list) {
            System.out.println(str);
        }
    }
}