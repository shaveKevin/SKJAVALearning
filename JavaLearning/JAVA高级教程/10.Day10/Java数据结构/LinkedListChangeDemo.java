import java.util.LinkedList;
 
public class LinkedListChangeDemo {
   public static void main(String[] a) {
      LinkedList officers = new LinkedList();
      officers.add("B");
      officers.add("B");
      officers.add("T");
      officers.add("H");
      officers.add("P");
      System.out.println(officers);
      officers.set(2, "M");
      System.out.println(officers);
   }
}