package multilevel;

public class ClassA {
	
	
	int value;
	
	void add(int a,int b) {
		
	
		value=a+b;
		System.out.println("value of new "+value);
	}
	
	
	

}


/*

ClassA extends in ClassB and ClassB Extends in ClassC

The properties of ClassA will get inherited in classB and ClassB properties get inherited in Class C

i.e properties of A and B get Class C

Assignment in class a Create one method ,in class B create method and inherit both the methods in Class c

*/


