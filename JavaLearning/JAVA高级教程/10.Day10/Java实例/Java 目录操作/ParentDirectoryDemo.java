import java.io.File;
 
public class ParentDirectoryDemo {
    public static void main(String[] args) {
        File file = new File("C:/File/demo.txt");
        String strParentDirectory = file.getParent();
        System.out.println("文件的上级目录为 : " + strParentDirectory);
    }
}
