package polymorphism;

public class A {

	
	int value;
	 void add(int a ,int b)
	{
		value=a+b;
		System.out.println(value);
		
	}
	
	void add(float a  ,float b)
	{
		 float fnew = a+b;
		 System.out.println(fnew);
	}
	
	void add(int a  ,int b,int c)
	{
		int d= a+b+c;
		System.out.println(d);
	}
	
	void add(double x,double y)
	{
		
		double z= x+y;
		System.out.println(z);
	}
	
	public static void main(String[] args) {
		
		A aa = new  A();
		aa.add(5, 7);
		aa.add(4.0, 7.2);
		aa.add(7, 6, 5);
		aa.add(6.7, 5.0);
		
	}
}

/*
Poly-Many Morphism-forms

it allows us to perform in different ways
method overloading is also called static 
overriding is also known as dynamic polymorphism

*/

