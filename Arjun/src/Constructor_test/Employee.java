package Constructor_test;

public class Employee 
{
	
	String name;
	int age;
	Employee(String name,int age)
	{
		
		this.name=name;
		this.age=age;
		System.out.println("my name is "+name + "and my age is"+age);
				
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		new Employee("Arjun",18);
		new Employee("Shanky",22);
		new myclass();

	}

}
