public class TestArray1 {

   public static void main(String args[]) {
    double[] myList = {1.9,2.9,3.4,3.5};
     // 打印所有元素
    for (int i = 0 ; i < myList.length; i ++) {
        System.out.println(myList[i] + " ");
      }
      //求所有元素的和
      double total = 0;
      for (int i = 0; i < myList.length; i ++) {
          total += myList[i];
      }
      System.out.println("total is " + total);
      // 查找最大元素
      double max = myList[0];
      for (int i = 0; i < myList.length; i ++) {
          if (myList[i] > max) {
              max = myList[i];
          }

      }
      System.out.println("max is " + max);
     // 打印所有数组元素
      for (double element: myList) {
         System.out.println(element);
      }

   }
}
