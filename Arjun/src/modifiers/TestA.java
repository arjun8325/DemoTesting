package modifiers;

public class TestA {

	//Public: The access level of a public modifier is everywhere. 
	public void methodPublic(){
	//	methodPublic();
		System.out.println("methodPublic");
	}
	
	//Protected: The access level of a protected modifier is within the package and outside the package through child class. 
	protected void methodProtected(){
	//	methodProtected();
		System.out.println("methodProtected");
	}
	
	//Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. 
	 void methodDefault(){
	//	methodDefault();
		System.out.println("methodDefault");
	}
	
	////Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
	private void methodPrivate(){
		//methodPrivate
		System.out.println("methodPrivate");
	}
}
