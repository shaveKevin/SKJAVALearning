import java.io.File;
 
public class SearchFileDemo {
    public static void main(String[] argv) throws Exception {
        File dir = new File("../java");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }
}