package abstraction;

public class Employee extends Salary{

	@Override
	void add(int a, int b) {
		
		value = a+b;
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		Employee obj = new Employee();
		obj.add(10, 30);
		obj.sub(20, 10);
		
	}

}
