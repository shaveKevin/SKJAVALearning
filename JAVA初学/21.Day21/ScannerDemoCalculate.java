import java.util.Scanner;

public class ScannerDemoCalculate {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Double sum = 0.0;
        int m = 0;
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.println(m + "个数的和为：" + sum);
        System.out.println(m + "个数的平均值为：" + (sum / m));
        scan.close();

    }
}
