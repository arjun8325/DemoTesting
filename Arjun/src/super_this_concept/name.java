package super_this_concept;

public class name extends age {
	
	int s= 20;
	
	void sub (int s) {
		System.out.println(s);
		System.out.println(this.s);// it refers to current instance variable
		System.out.println(super.s);// it refers to immediate parent instance variable
	}
	
	public static void main(String[] args) {
		name g = new name();
		g.sub(30);
	}

}
