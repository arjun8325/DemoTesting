package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileException {
	 static FileInputStream fis;
	public static void main(String[] args) throws FileNotFoundException 
	{
		 int n = 10, result = 0;
		 
	      try 
	      
	      { // outer try block
	    	  
	    	  
	     //    FileInputStream fis = null;
	         fis = new FileInputStream (new File (args[0]));
	          // inner trty block
	            result = n/0;
	            System.out.println("The result is"+result);
	            
	      }
	        
	         catch(ArithmeticException e)
	         { // inner catch block
	            System.out.println("Division by Zero");
	         }
	      
	      catch(ArrayIndexOutOfBoundsException e)
	         { // inner catch block
	            System.out.println("ArrayIndexout of Bound");
	            e.printStackTrace();
	         }
	      
	      }
	
}
	
///Doubts hashmap method
//multiple exception
//conversion 
//

