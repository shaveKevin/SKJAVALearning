import java.io.File;
 
public class RenameDemo {
    public static void main(String[] args) {
        File oldName = new File("C:/program.txt");
        File newName = new File("C:/java.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
    }
}