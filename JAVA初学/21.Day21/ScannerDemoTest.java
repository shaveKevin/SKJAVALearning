import java.util.*;

public class ScannerDemoTest {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.println("请输入整数：");
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            System.out.println("输入的整数数据为：" + i);
        } else {
            System.out.println("输入的不是整数");
        }
        System.out.println("请输入小数：");
        if (scan.hasNextFloat()) {
            f = scan.nextFloat();
            System.out.println("输入的小数数据为：" + f);

        } else {
            System.out.println("输入的不是小数");
        }

        scan.close();

    }
}
