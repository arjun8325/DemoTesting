package modifiers_outside;

import modifiers.TestA;

public class employee extends TestA{

	public static void main(String[] args) {
		employee H= new employee();
		H.methodProtected();
		H.methodPublic();

	}

}
