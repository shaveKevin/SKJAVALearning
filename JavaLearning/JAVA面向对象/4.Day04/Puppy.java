public class Puppy {

	int puppyAge;
	public Puppy (String name) {
		//创建带有参数的构造器
		System.out.println("狗狗的名字是:"+ name);
	}
	// setter方法
	public void setAge(int age) {
		puppyAge = age;
	}
	// getter方法
	public int getAge(){
		System.out.println("狗狗的年龄是:"+ puppyAge);
		return puppyAge;
	}
	public static void main(String[] args) {
        /* 创建对象 */
		Puppy puppy = new Puppy("京巴");
		 /* 通过方法来设定age */
		puppy.setAge(2);
		 /* 调用另一个方法获取age */
		puppy.getAge();
		  /*访问成员变量 */
		System.out.println("变量获取的狗狗的年龄是:"+ puppy.puppyAge);
	}
}