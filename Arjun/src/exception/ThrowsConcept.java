package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsConcept {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileInputStream file =  new FileInputStream("c://text.xtx");

	}

}
