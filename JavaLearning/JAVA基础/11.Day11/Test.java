public class Test {
	public static void main(String[] args) {
		char grade  = 'C';
		switch(grade) {
			case 'A':
			System.out.println("优秀");
			break;
			case 'B':
			System.out.println("良好");
			break;
			case 'C':
			System.out.println("及格");
			break;
			case 'E':
			System.out.println("差");
			break;
			default:
			System.out.println("未知等级");
			break;
		}
	    System.out.println("你的等级是 " + grade);


	    int i = 10;
	    switch(i) {
	    	case 0:
	    	System.out.println("输出的是:0");
	    	case 1:
	        System.out.println("输出的是:1");
	        case 2:
	        System.out.println("输出的是:2");
	        default:
	        System.out.println("输出的是:默认值");

	    }
	    int j = 1;
	    switch(j) {
	    	case 0:
	    	System.out.println("输出的是:0");
	    	case 1:
	        System.out.println("输出的是:1");
	        case 2:
	        System.out.println("输出的是:2");
	        break;
	        default:
	        System.out.println("输出的是:默认值");

	    }

	}
}