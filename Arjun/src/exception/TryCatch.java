package exception;

public class TryCatch {

	public static void main(String[] args) {
		
		
		try 
		{
			int a=5/0;
			
			int b[]= new int [5];
			b[6]=7;
			
		}
		catch (ArithmeticException e)
		{
			
			System.out.println("you have to divide by some another number");
			System.out.println(e.getClass());
			System.out.println(	e.getMessage());
			System.out.println(e.getCause());
			
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e )
		{
			System.out.println("this will aaray");
		}
		

	}

}
