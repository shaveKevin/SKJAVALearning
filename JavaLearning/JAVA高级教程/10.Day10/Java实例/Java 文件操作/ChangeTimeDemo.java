import java.io.File;
import java.util.Date;
 
public class ChangeTimeDemo {
    public static void main(String[] args) {
        File file = new File("ChangeTimeDemo.java");
        Long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        System.out.println(date);
    }
}