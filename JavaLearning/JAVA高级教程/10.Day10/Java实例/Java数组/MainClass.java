/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-13 10:04:33
 * @LastEditors: Please set LastEditors
 */
import java.util.Arrays;
 
public class MainClass {
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);
        printArray("数组排序结果为", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
    }
    private static void printArray(String message, int array[]) {
        System.out.println(message
        + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}