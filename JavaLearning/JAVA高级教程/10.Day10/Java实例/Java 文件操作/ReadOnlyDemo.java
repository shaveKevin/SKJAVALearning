import java.io.File;
 
public class ReadOnlyDemo {
    public static void main(String[] args) {
        File file = new File("C:/java.txt");
        System.out.println(file.setReadOnly());
        System.out.println(file.canWrite());
    }
}
