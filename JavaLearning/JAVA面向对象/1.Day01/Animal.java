// 企鹅类
public class Penguin {
	private String name;
	private int id;

	public Penguin(String myName, int myId) {
		name = myName;
		id = myId;
	}

	public void eat() {
		System.out.println(name + " 正在吃");
	}

	public void sleep() {
		System.out.print(name + " 正在睡觉");
	}

	public void introducation() {
		System.out.println("大家好，我是" + id + "号" + name + "。");
	}

}
// 老鼠类
public class Mouse {
	private String name;
	private int id;

	public Mouse(String myName, int myId) {
		name = myName;
		id = myId;
	}

	public void eat() {
		System.out.println(name + " 正在吃");
	}

	public void sleep() {
		System.out.print(name + " 正在睡觉");
	}

	public void introducation() {
		System.out.println("大家好，我是" + id + "号" + name + "。");
	}

}
// 动物类
public class Animal {
	private String name;
	private int id;

	public Animal(String myName, int myId) {
		name = myName;
		id = myId;
	}

	public void eat() {
		System.out.println(name + " 正在吃");
	}

	public void sleep() {
		System.out.print(name + " 正在睡觉");
	}

	public void introducation() {
		System.out.println("大家好，我是" + id + "号" + name + "。");
	}

}
public class Penguin1 extends Animal {
	public Penguin1(String myName, int myId) {
		super(myName, myId);
	}
}

public class Mouse1 extends Animal {
	public Mouse1(String myName, int myId) {
		super(myName, myId);
	}
}
