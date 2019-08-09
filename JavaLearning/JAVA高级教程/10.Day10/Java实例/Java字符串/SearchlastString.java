public class SearchlastString {
    public static void main(String[] args) {
        // 字符串搜索
        String strOrig = "Hello world ,Hello Runoob";
        int lastIndex = strOrig.lastIndexOf("Runoob");
        //好不到的时候返回-1
        if(lastIndex == - 1){
           System.out.println("没有找到字符串 Runoob");
        }else{
           System.out.println("Runoob 字符串最后出现的位置： "+ lastIndex);
        }
        // 字符串删除
        String str = "this is Java";
      System.out.println(removeCharAt(str, 3));
      String strOrig1 = "Google Runoob Taobao";
      int intIndex = strOrig1.indexOf("Runoob");
      if(intIndex == - 1){
         System.out.println("没有找到字符串 Runoob");
      }else{
         System.out.println("Runoob 字符串位置 " + intIndex);
      }
      
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
     }
}