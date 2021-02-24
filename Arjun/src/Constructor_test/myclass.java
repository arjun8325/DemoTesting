package Constructor_test;

public class myclass {
	
	/*
	 * It is a block (Simller to method )having same name as class .
	 * default and Paramterized Constructor
	 * No argument-Same as Default 
	 * It does not have any return type not even void.\
	 * Constructors cannot return a value.
	 * Constructors are routinely called while an object is created.
	 */
	public myclass() // it gets triggered automatically when object is created
	{
		System.out.println("amit");
		
		
	}
	
	myclass(int a, int b)
	{
		int d  = a+b;
		System.out.println(d);
	}
	

	public static void main(String[] args) 

	{
		new myclass();
		new myclass(10,20);
		new myclass(23,20);
		new myclass(10,20);
		new myclass(10,20);
		new myclass(50,60);

	}

}
