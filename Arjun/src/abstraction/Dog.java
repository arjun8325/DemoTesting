package abstraction;

public class Dog extends Animal{

	
	@Override
	public void animalSound() {
		// TODO Auto-generated method stub
		System.out.println("bho bho");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog d= new Dog();
		d.animalSound();

	}


}
