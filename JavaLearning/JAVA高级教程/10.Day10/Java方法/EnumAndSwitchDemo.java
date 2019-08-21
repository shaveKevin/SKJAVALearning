/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-02 09:04:59
 * @LastEditTime: 2019-08-16 14:08:23
 * @LastEditors: Please set LastEditors
 */
public class EnumAndSwitchDemo {
    public static void main(String[] args) {
        Car c;
        c = Car.tata;
        switch(c) {
            case lamborghini:
                System.out.println("你选择了 lamborghini!");
                break;
            case tata:
                System.out.println("你选择了 tata!");
                break;
            case audi:
                System.out.println("你选择了 audi!");
                break;
            case fiat:
                System.out.println("你选择了 fiat!");
                break;
            case honda:
                System.out.println("你选择了 honda!");
                break;
            default:
                System.out.println("我不知道你的车型。");
                break;
        }
    }
}
enum Car {
    lamborghini,tata,audi,fiat,honda
}