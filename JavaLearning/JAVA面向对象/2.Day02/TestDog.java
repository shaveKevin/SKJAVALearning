class Animal {
	public void move(){
		System.out.println("动物可以移动");
	}
}
class Dog extends Animal {
	public void move(){
	// 这里不调用super 这说明重写了	
		System.out.println("狗可以跑和走");
	}
	public void bark(){
		System.out.println("狗可以吠叫");
	 }

}
public class TestDog {
	public static void main(String[] args) {
		// 定义Animal对象
		Animal a = new Animal();
		//dog 对象
		Animal b = new Dog();
		// 执行Animal 的move 方法
		a.move();
		// 执行Dog 的move 方法
		b.move();
		b.bark();
	}
}