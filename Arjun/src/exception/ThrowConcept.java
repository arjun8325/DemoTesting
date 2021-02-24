package exception;

public class ThrowConcept {

	static void validate(int age)
	{
		if(age<18) 
			throw new ArithmeticException("not valid");
			else
				System.out.println("valid");
	}
	
	public static void main(String[] args) {
		ThrowConcept.validate(20);
		System.out.println("now execute");

	}

}
