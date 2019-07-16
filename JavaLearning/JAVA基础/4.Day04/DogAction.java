class Dog {
String breed;
int age;
String color;
void barking (){
System.out.println("狗狗在叫");
}
void hangry(){
System.out.println("狗狗饿了");

}
void sleep (){
System.out.println("狗狗要睡了");
}
}
public class DogAction {
public static void main(String[] args) {
		Dog dog = new Dog();
		dog.breed = "京巴";
		dog.age = 2;
		dog.color = "blackColor";
		dog.barking();
		dog.hangry();
		dog.sleep();
	}
}