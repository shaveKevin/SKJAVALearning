import java.io.File;
 
public class ExistFileDemo {
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
    public static void main(String[] args) {
        long size = getFileSize("c:/java.txt");
        System.out.println("java.txt文件大小为: " + size);
    }
}