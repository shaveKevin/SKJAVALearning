/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:54:40
 * @LastEditors: Please set LastEditors
 */
public class RectDemo {
    public static void main(String[] args) {
         //外层循环 每次输出一行*
        for (int i = 1; i <= 5; i++) {
            System.out.print("*");
            //内层循环 每次输出一个*
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}