package abstraction;

public class Sparrow  extends Bird{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sparrow s= new Sparrow();
		s.sound();
		s.eat();

		
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		System.out.println("Sound is chi chi");
		
	}

}
