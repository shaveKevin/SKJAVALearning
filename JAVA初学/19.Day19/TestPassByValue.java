public class TestPassByValue {
   public static void main(String args[]) {
      int a = 10;
      int b = 30;
      System.out.println("方法调用前交换前a的值为:" + a + " 交换前b的值为：" + b);
      SwapValue(a, b);
      System.out.println("方法调用后交换前a的值为:" + a + " 交换前b的值为：" + b);

   }

   public static void SwapValue(int a, int b) {
      System.out.println("交换前a的值为:" + a + " 交换前b的值为：" + b);
      int tempValue;
      tempValue = a;
      a = b;
      b = tempValue;
      System.out.println("交换后a的值为:" + a + " 交换后b的值为：" + b);

   }
}
