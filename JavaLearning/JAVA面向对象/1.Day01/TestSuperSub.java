class SuperClass {
	private int n;
	SuperClass (){
		System.out.println("suoer class");
	}
	SuperClass (int n) {
		System.out.print("super class int n ");
		this.n = n;
	}
}
// subClass 类继承
class  SubClass extends SuperClass {
	private int n;
	SubClass(){
		System.out.println("SubClass");
	}
	public SubClass (int n) {
		super(230);
		System.out.println("SubClass int n "+ n);
		this.n = n;
	}
}
class SubClass2 extends SubClass {
	private int n;
	SubClass2(){
	// 调用父类中带有参数的构造器
		super(300);  
		System.out.println("SubClass2");
	  }  
	  // 自动调用父类的无参数构造器（不写super 默认调用父类无参构造方法）
	  public SubClass2(int n){ 
		System.out.println("SubClass2(int n):"+n);
		this.n = n;
	  }
}

public class TestSuperSub {
	public static void main(String[] args) {
		System.out.println("------SubClass 类继承------");
		SubClass superClass1 = new SubClass();
		SubClass superClass12 = new SubClass(100); 
		System.out.println("------SubClass2 类继承------");
		SubClass2 superClass3 = new SubClass2();
		SubClass2 superClass4 = new SubClass2(200);
	}
}