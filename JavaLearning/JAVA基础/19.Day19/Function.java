public class Function {
   public static void main(String args[]) {
      int result = max(5, 10);
      System.out.println("max is " + result);
   }

   public static int max(int num1, int num2) {
      if (num1 > num2) {
         return num1;
      } else {
         return num2;
      }
   }
}
