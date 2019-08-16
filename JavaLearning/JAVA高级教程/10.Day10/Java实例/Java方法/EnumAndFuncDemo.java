/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:11:19
 * @LastEditors: Please set LastEditors
 */
public class EnumAndFuncDemo {
    public static void main(String[] args) {
        System.out.println("所有汽车的价格：");
        for (Bus c : Bus.values())
        System.out.println(c + " 需要 " 
        + c.getPrice() + " 千美元。");
    }
}
enum Bus {
    lamborghini(900),tata(2),audi(50),fiat(15),honda(12);
    private int price;
    Bus(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    } 
}