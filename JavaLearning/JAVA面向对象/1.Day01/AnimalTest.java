class AnimalSuper {
	void eat() {
		System.out.println("animal: eat");
	}

}

class Dog extends AnimalSuper {
	void eat(){ 
		System.out.println(" dog : eat");
	}

	void testEat() {
		// 调用自己类的方法
		this.eat();
		// 调用父类的方法
		super.eat();
	}
}
public class AnimalTest {
	public static void main(String[] args) {
		AnimalSuper animal = new AnimalSuper();
		animal.eat();
		Dog dog = new Dog();
		dog.testEat();
	}
}