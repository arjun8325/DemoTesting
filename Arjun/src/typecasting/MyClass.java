package typecasting;

public class MyClass {

	public static void main(String[] args) {
		
		
		char a='C';

		int b=a;
		String s=Character.toString(a);
	
		System.out.println(b);
		System.out.println(s);
		
		int d=10;
		int dd=15;
		String s2="100";
		
		int c=Integer.valueOf(s2);
		System.out.println(c);
		Double dd1=Double.valueOf(dd);
		System.out.println(dd1);
		String s1= String.valueOf(d);
		System.out.println(d);
		
		/**
		 * String to int
		 * int to double
		 * double to int
		 */
	}

}
