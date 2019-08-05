import java.io.Serializable;
// 序列化
public class Employee implements Serializable {
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck()
	{
	   System.out.println("Mailing a check to " + name
							+ " " + address);
	}

}