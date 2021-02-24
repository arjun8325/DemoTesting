package array;

public class array_concepts {

	public static void main(String[] args) {
		
		
		int a[] = new int[5];//0,1,2,3,4
		a[0]=100;
		a[1]=200;
		a[2]=300;
		a[3]=400;
		a[4]=500;

		
		int bb[]= {1,2,4,5};
		
		
		int sizofbb=bb.length;
		
		System.out.println(bb[1]);
		
		for(int a1=0;a1<sizofbb;a1++)
		{
			System.out.println(bb[a1]);
		}
		/*
		 * int sizeofarray = a.length; System.out.println("size of array" +
		 * sizeofarray);
		 * 
		 * for(int arjun=0;arjun<sizeofarray;arjun++) { System.out.println(a[arjun]); }
		 */
		
		for(int s:a) {
			System.out.println(s);
		}

	}

}
