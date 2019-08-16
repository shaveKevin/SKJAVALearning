/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:14:53
 * @LastEditors: Please set LastEditors
 */
public class ForEachDemo {
    public static void main(String[] args) {
        int[] intary = { 1,2,3,4};
        forDisplay(intary);
        foreachDisplay(intary);
    }
    public static void forDisplay(int[] a){  
        System.out.println("使用 for 循环数组");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void foreachDisplay(int[] data){
        System.out.println("使用 foreach 循环数组");
        for (int a  : data) {
            System.out.print(a+ " ");
        }
    }
}