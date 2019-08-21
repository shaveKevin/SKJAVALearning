/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:02:30
 * @LastEditors: Please set LastEditors
 */
public class ContinueDemo {
    public static void main(String[] args) {
        StringBuffer searchstr = new StringBuffer("hello how are you. ");
        int length = searchstr.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (searchstr.charAt(i) != 'h')
            continue;
            count++;
            searchstr.setCharAt(i, 'h');
        }
        System.out.println("发现 " + count 
        + " 个 h 字符");
        System.out.println(searchstr);
    }
}