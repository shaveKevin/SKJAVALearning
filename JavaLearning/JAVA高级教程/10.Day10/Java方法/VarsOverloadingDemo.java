/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:22:06
 * @LastEditors: Please set LastEditors
 */
public class VarsOverloadingDemo {
    static void vaTest(int ... no) {
        System.out.print("vaTest(int ...): " 
        + "参数个数: " + no.length +" 内容: ");
        for(int n : no)
        System.out.print(n + " ");
        System.out.println();
    }
    static void vaTest(boolean ... bl) {
        System.out.print("vaTest(boolean ...) " +
        "参数个数: " + bl.length + " 内容: ");
        for(boolean b : bl)
        System.out.print(b + " ");
        System.out.println();
    }
    static void vaTest(String msg, int ... no) {
        System.out.print("vaTest(String, int ...): " +
        msg +"参数个数: "+ no.length +" 内容: ");
        for(int  n : no)
        System.out.print(n + " ");
        System.out.println();
    }
    public static void main(String args[]){
        vaTest(1, 2, 3);
        vaTest("测试: ", 10, 20);
        vaTest(true, false, false);
    }
}