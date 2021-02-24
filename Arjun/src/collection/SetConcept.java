package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetConcept {

	/*
	 * set - it is interface . It has classes as treeset , hashsetetc
	 * it represents  unique element
	 * it can allow null values
	 * ---------Classed which implements list interface-----------
	 
	 * 
	 * assignment : remove , add, get
	 * int dfine , add all data
	 */
	
	public static void main(String[] args) {
		
		Set<String> str = new HashSet<String>();
		str.add("amit");
		str.add("arjun");
		str.add("sita");
		str.add("ram");
		str.add("arjun");
		str.add("sita");
		str.add("ram");
		//str.
		
		int count = str.size();
		
		System.out.println("Total size is "+count);
		
		
	}
}
