import java.util.LinkedList;

public class LinkSearchDemo {
   public static void main(String[] args) {
      LinkedList lList = new LinkedList();
      lList.add("1");
      lList.add("2");
      lList.add("3");
      lList.add("4");
      lList.add("5");
      lList.add("2");
      System.out.println("元素 2 第一次出现的位置：" + lList.indexOf("2"));
      System.out.println("元素 2 最后一次出现的位置：" + lList.lastIndexOf("2"));
   }
}