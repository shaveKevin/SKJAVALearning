public class Test {
	public static void main(String[] args) {
		int x = 10;
		while ( x < 20) {
			System.out.println("value of x is " + x);
			x++;
			System.out.println("\n");
		}
		int y = 10;
		do {
			System.out.println("value of y is " + y);
			y++;
			System.out.println("\n");

		}while (y < 20);
		for (int z = 10; z < 20; z ++) {
	        System.out.println("value of z is " + z);
		}
		
		int []numbers = {10,20,30,40,50};
		for (int m: numbers ) {
			System.out.println(m);
			System.out.println(",");
		}
		System.out.println("\n");
		String [] names = {"James", ":Larry","Tom","Lacy"};
		for (String name : names) {
			System.out.println(name);
			System.out.println(",");
		}

		int []numberValues = {10,20,30,40,50};
		for (int n : numberValues) {
			if (n == 30) {
				break;
			}
			System.out.println(n);

		}
		int []intValueNumbers = {10,20,30,40,50};

          for (int p : numberValues) {
			if (p == 30) {
				continue;
			}
			System.out.println(p);

		}
	}
}