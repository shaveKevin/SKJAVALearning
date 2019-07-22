interface Animal {
  public void eat();
  public void travel();
}
public class Interface implements Animal {
  public  void eat(){
    System.out.println("实现eat 方法");
  }
  public void travel (){
    System.out.println("实现travel 方法");
  }
  public static void main(String[] args) {
    Interface inter = new Interface();
    inter.eat();
    inter.travel();
  }
}