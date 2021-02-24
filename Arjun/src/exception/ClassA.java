package exception;

public class ClassA {

	public static void main(String[] args) {
		
		try {
			//int a=5/0;
			
			int[] b= new int[5];		
			b[6]=7;
			
			System.out.println("Divid by Zero");
		
		} 
		catch (ArithmeticException e) {
			// TODO Auto-generated catch block
	
			//
			System.out.println("Execution Successfully");
			e.printStackTrace();
		}
		
	
			catch(ArrayIndexOutOfBoundsException e)
		
		{
		         System.out.println("Accessing array elements outside of the limit");
		         e.printStackTrace();
	
		}
		finally
		{
			System.out.println("Finally is executed Successfully");
		}
	}

}
