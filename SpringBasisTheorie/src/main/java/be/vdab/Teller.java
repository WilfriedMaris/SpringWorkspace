package be.vdab;

public class Teller {
	private int teller;
	
	Teller(){
		System.out.println("Teller constructor, teller is " + teller);
	}
	
	void verhoog(){
		++teller;
		System.out.println("teller is verhoogd tot " + teller);
	}

}
