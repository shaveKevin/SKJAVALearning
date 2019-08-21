public class StringReplaceEmp {
    public static void main(String[] args) {
        String str = "Hllo World";
        System.out.println(str.replace('H', 'W'));
        System.out.println(str.replaceFirst("He", "Wa"));
        System.out.println(str.replaceAll("He", "Ha"));

        String string = "runoob";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:" + string);
        System.out.println("字符串反转后:" + reverse);
    }
}