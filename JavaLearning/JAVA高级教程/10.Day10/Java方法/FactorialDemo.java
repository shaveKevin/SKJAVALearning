/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-15 10:21:52
 * @LastEditors: Please set LastEditors
 */
public class FactorialDemo {
    public static void main(String args[]) {
    for (int counter = 0; counter <= 10; counter++){
        System.out.printf("%d! = %d\n", counter,
        factorial(counter));
    }
    }
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}