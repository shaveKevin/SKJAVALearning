public class ArrayDemo {

   public static void main(String args[]) {
   	// 定义数组的大小
     int size = 10;
     //初始化大小为10，元素为double类型的数组
     double[] myList = new double[size];
     myList[0] = 5.6;
     myList[1] = 4.5;
     myList[2] = 3.3;
     myList[3] = 13.2;
     myList[4] = 4.0;
     myList[5] = 34.33;
     myList[6] = 3.99;
     myList[7] = 23.45;
     myList[8] = 78.45;
     myList[9] = 111234;
     myList[10] = 999;
     // 计算所有元素的和
     double toatl = 0;
     for (int i = 0; i < size; i ++) {
     	toatl += myList[i];
     }
     System.out.println("总和为：" + toatl);

   }
}
