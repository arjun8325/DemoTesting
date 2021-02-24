package Encapsulation;

public class ClassEncapsulation {

	
	private String Name;
	
	//private int age;

	private int agge;

	public int getAge() {
		return agge;
	}

	public void setAge(int agge) {
		this.agge = agge;
	}

	
	public static void main(String[] args) 
	{
		
		ClassEncapsulation en= new ClassEncapsulation();
		en.setAge(11);
		System.out.println(en.getAge());
		
	}
	
}


/*

Wrapping of Data(Variables ) and Code acting on that data (Methods) together as a single unit
It is also known as data Hiding 
It can be acheived in two ways 

 1.Decalre the variable of a class as private
 2.providing public setter and getter method to modify and view the variable values.
 

*/