/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-14 09:15:30
 * @LastEditors: Please set LastEditors
 */
public class ArrayExpended {
    public static void main(String[] args) {
        String[] names = new String[] { "A", "B", "C" };
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str : extended){
            System.out.println(str);
        }
    }
}