public class Encap {
  public static void main(String args[]) {
    EncapTest encap = new EncapTest();
    encap.setName("华安");
    encap.setAge(20);
    encap.setIdNum("9527");
    System.out.print("姓名 : " + encap.getName() + " 年龄 : " + encap.getAge() + "编号 : " + encap.getIdNum());
  }
}