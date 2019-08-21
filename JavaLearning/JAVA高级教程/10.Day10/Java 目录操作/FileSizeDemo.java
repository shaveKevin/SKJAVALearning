import java.io.File;
import org.apache.commons.io.FileUtils;
 
public class FileSizeDemo {
    public static void main(String[] args) {
        long size = FileUtils.sizeOfDirectory(new File("C:/test"));
        System.out.println("Size: " + size + " bytes");
    }
}