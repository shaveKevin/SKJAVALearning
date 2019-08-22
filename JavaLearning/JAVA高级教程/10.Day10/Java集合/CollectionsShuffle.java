/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 16:53:11
 * @LastEditors: Please set LastEditors
 */
import java.util.*;
 
public class CollectionsShuffle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(new Integer(i));
        System.out.println("打乱前:");
        System.out.println(list);
 
        for (int i = 1; i < 6; i++) {
            System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
}