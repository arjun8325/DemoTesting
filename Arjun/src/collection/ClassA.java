package collection;

import java.util.ArrayList;
import java.util.List;

public class ClassA {
	
	/*
	 * List-it represents an order collection of element
	 * It Allow duplicate elements
	 * We can access element by there index
	 * ---------Classed which implements list interface-----------
	 * Array List
	 * Link List
	 * Stack
	 * Vector
	 * 
	 * assignment : remove , add, get
	 * int dfine , add all data
	 */
	public static void main(String[] args) {
		
	List<String> str = new ArrayList<String>();
	str.add("arjun diwan");
	str.add("Amit");
	str.add("arjun diwan");
	str.add("arjun diwan");
	str.add("ram");
	str.add("sita");
	str.remove(0);
	
	String s=str.get(4);
	
	
	
	System.out.println(s);
	
	
	int sizeoflist = str.size();
	System.out.println("size of list " + sizeoflist);
	
	for(String w : str) {
		System.out.println(w);
	}

}
}