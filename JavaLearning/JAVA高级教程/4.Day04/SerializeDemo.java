import java.io.*;

// 序列化对象
public class SerializeDemo {
	public static void main(String[] args) {

		Employee e = new Employee();
		e.name = "shavekevin";
		e.address = "北京 朝阳";
		e.SSN = 123;
		e.number = 9527;
		try {
			FileOutputStream fileOut =
			new FileOutputStream("/tmp/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");

		} catch (Exception i) {
			// TODO: handle exception
		}

	}
}