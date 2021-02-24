package Encapsulation;

public class Diwan {
	
	private int account;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Diwan dd= new Diwan();
		dd.setAccount(1098100);
		System.out.println(dd.getAccount());

	}


	public int getAccount() {
		return account;
	}


	public void setAccount(int account) {
		this.account = account;
	}

}
