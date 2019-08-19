import java.io.File;
 
public class HiddenFileDemo {
    public static void main(String[] args) {
        File file = new File("C:/Demo.txt");
        System.out.println(file.isHidden());
    }
}