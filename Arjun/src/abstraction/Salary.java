package abstraction;

public  abstract class Salary {
	
	//1. abstract class : a class having a keyword abstract
	/*
	 * a abstract class can have both methods: abstract method and concrete(normal methods)
	 *
	 */
	
	int value;
	
	abstract void add(int a, int b);// securing the code
	
	void sub(int c, int m) {
		value =  c-m;
		System.out.println(value);
	}
	
	
	
	
	//2. abstract method : a method having a keyword abstract
	//it doesnot have a body
	//you can pass n number of agrments
	
	//3. if you have any abstract methods in abstract class, then that methods(abstract method), has to implemented if we inherit

}

//what is an abstraction : hiding the details(code,database, server) and showing only the functionality of the application
//how to achieve abstraction : 1. abstract class 2. Interface
//oops concepts
/*
 * 1. abstraction
 * 2. inheritance
 * 3. encapsulation
 * 4. interface
 * 5. poplymorphism
 */
