package finalkeywords;

public   class employee {// class 
	
	//final can be used with variables, methods and classes
	
	final int a = 10;
	int value;
	
	final void add(int d, int e) { // if method is final you can overide
	//	a= 20;
		value = d+e;
		System.out.println(value);
	}

}
