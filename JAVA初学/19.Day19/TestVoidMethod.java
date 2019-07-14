public class TestVoidMethod {
   public static void main(String args[]) {
      printGrade(66.5);
      nPrintln("hello", 5);
   }
   public static void printGrade(double score) {
      if(score >= 90.0) {
         System.out.println('A');
      } else if(score >= 80.0) {
         System.out.println('B');
      } else if(score >= 70.0) {
         System.out.println('C');
      } else if(score >= 60.0) {
         System.out.println('D');
      } else {
         System.out.println('E');
      }
   }
   public static void nPrintln(String message, int n) {
      for (int i = 0; i < n; i++) {
        System.out.println(message);
      }
    }
}
