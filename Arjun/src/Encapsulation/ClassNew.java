package Encapsulation;

public class ClassNew {
	
	private double a;

	
	
	
	public static void main(String[] args) {
		ClassNew d = new ClassNew();
		d.setA(10.20);
		System.out.println(d.getA());
	}




	public double getA() {
		return a;
	}




	public void setA(double a) {
		this.a = a;
	}

}
