import java.io.File;
 
public class FilenameDemo {
    public static void main(String[] args) {
        File file1 = new File("C:/File/demo1.txt");
        File file2 = new File("C:/java/demo1.txt");
        if(file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }
}