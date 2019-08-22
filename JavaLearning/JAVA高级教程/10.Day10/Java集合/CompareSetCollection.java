/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-22 10:21:14
 * @LastEditTime: 2019-08-22 11:02:42
 * @LastEditors: Please set LastEditors
 */
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
 
class CompareSetCollection {
    public static void main(String[] args) {
        String[] coins = { "Penny", "nickel", "dime", "Quarter", "dollar" };
        Set<String> set = new TreeSet<String>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i <= 10; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
}
