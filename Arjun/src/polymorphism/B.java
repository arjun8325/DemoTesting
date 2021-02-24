package polymorphism;

public class B extends A {
	
	void add(int a ,int b)
	{
		value=a-b;
		System.out.println(value);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B bb= new B();
		
		bb.add(10, 5);
	}

}
