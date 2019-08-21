/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:19:06
 * @LastEditors: Please set LastEditors
 */
public class VarsDemo {
    static int  sumvarargs(int... intArrays){
        int sum, i;
        sum=0;
        for(i=0; i< intArrays.length; i++) {
            sum += intArrays[i];
        }
        return(sum);
    }
    public static void main(String args[]){
        int sum=0;
        sum = sumvarargs(new int[]{10,12,33});
        System.out.println("数字相加之和为: " + sum);
    }
}
