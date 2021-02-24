package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapConcept {
	
	//map : it allows key value pairing
	//it will always have unique keys. n number of values/ duplicate values can be declared
	//classes: hashmap, treemap, hashtable 
	public static void main(String[] args) {
		
	//char 'a';
	
	Map<Integer,String> str = new HashMap<Integer,String>();
	str.put(1, "arjun");
	str.put(2, "arjun");
	str.put(3, "sita");
	str.put(4, "amit");
	str.remove(2);
	
	
	
	System.out.println(str.size());
	
	boolean b=str.containsKey(1);
	System.out.println(b);

	int code=str.hashCode();
	System.out.println("hascode is "+code);
	
	if(str.containsValue("amit"))
	{
		System.out.println("amit present hai");
	}

	else
	{
		System.out.println("nhi hai");
	}
	System.out.println(str);
	
	System.out.println("value is : " +str.get(3) );
	
	for (Entry<Integer, String> str1:str.entrySet())
	{
		System.out.print(str1.getKey() + " :");
		System.out.println(str1.getValue());
		
	}	
	
	
	for(Entry<Integer, String> str2:str.entrySet())
	{
		System.out.println(str2.setValue("a"));
	}

}}
