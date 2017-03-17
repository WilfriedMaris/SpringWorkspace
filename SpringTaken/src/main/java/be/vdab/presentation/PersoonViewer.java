package be.vdab.presentation;
import java.util.List;

import be.vdab.entities.Persoon;

public class PersoonViewer {
	private boolean aantalKinderenTonen;
	
	public void setAantalKinderenTonen(boolean aantalKinderenTonen) {
		this.aantalKinderenTonen = aantalKinderenTonen;
	}

	public void Afbeelden(List<Persoon> lijst){
		for(Persoon persoon : lijst){
			System.out.printf("%d %s %s ",
				persoon.getPersoonNr(),
				persoon.getVoornaam(),
				persoon.getFamilienaam());
			if(aantalKinderenTonen){
				System.out.println(persoon.getAantalKinderen());
			}
			System.out.println();
		}
	}		
}
