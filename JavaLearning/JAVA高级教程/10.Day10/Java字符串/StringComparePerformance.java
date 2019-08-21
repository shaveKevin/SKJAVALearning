/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-12 10:03:56
 * @LastEditors: Please set LastEditors
 */
public class StringComparePerformance {
    public static void main(String[] args) {
        String variables[] = new String[50000];
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables[i] = "hello";
        }

        long endTime0 = System.currentTimeMillis();
        System.out.println("使用字面量直接赋值字符串，花费时间：" + (endTime0 - startTime0) + "毫秒");
        String variables1[] = new String[50000];
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables1[i] = new String("hello");
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println("使用字符串对象花费时间：" + (endTime1 - startTime1) + "毫秒");
        String variables2[] = new String[50000];
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables2[i] = new String("hello");
            variables2[i] = variables2[i].intern();
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("使用字符串对象intern()方法花费时间：" + (endTime2 - startTime2) + "毫秒");
    }
}