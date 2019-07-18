public class Test {

	public static void main(String[] args) {
		// 以 Cat 对象调用 show 方法
		show(new Cat());
		// 以 Dog 对象调用 show 方法
		show(new Dog());
		// 向上转型
		Animal a = new Cat();
		// 调用 Cat类中的eat方法
		a.eat();
		// 向下转型
		Cat c = (Cat) a;
		// 调用的是Cat的work
		c.work();
	}

	public static void show(Animal a) {
		a.eat();
		// 类型判断：
		if (a instanceof Cat) {
			Cat c = (Cat) a;
			c.work();
		} else if (a instanceof Dog) {
			Dog c = (Dog) a;
			c.work();
		}

	}
}
// 抽象类
abstract class Animal {
	abstract void eat();
}

class Cat extends Animal {
	public void eat() {
		System.out.println("吃鱼");
	}

	public void work() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("吃骨头");
	}

	public void work() {
		System.out.println("看家护院");
	}
}