public class CatchDemo {
    public static void main (String args[]) {
        int array[]={20,20,40};
        int num1=15,num2=10;
        int result=10;
        try{
            result = num1/num2;
            System.out.println("结果为 " +result);
            for(int i =5;i >=0; i--) {
                System.out.println ("数组的元素值为 " +array[i]);
            }
        }
        catch (Exception e) {
            System.out.println("触发异常 : "+e);
        }
    }
}