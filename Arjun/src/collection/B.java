package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> hh=new ArrayList<String>();
		hh.add("Hi");
		hh.add("I");
		hh.add("AM");
		hh.add("Arjun");
		hh.add(1, "world");

		
		System.out.println("Printing first List");
		for(String a:hh)
		{
			System.out.println(a);
			
		}

		
		System.out.println("Printing Second List");
		
		List<String> ii=new ArrayList<String>();
		ii.add("Welocme");
		ii.add("to");
		ii.add("the");
		ii.add("delhi");
		ii.add(1, "Diwan");
		boolean bool=ii.isEmpty();
		
		
		
		System.out.println("check if it is empty"+bool);
		//ii.toString();
		Collections.sort(ii);
		//ii.
		
		ii.set(2, "new values");
		
		System.out.println(ii);
		
		//How to Sort
		
		System.out.println("after sorting"+ii);
		
		System.out.println("what is happening here"+ii);
		//ii.clear();iT will clear the list 
		
		
		for(String b:ii)
		{
			System.out.println(b);
			
		}

		//To add to Array List
		hh.addAll(ii);
		System.out.println("adding two list"+hh);
		
		
		ii.removeAll(ii);
		System.out.println("removing list from "+ii);
		System.out.println(ii);
		
		//hh.clear();
		//To Get The class
		System.out.println(ii.getClass());
		
		
		
	}

}
