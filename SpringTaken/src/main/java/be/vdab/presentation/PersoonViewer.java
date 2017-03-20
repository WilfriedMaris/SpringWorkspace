package be.vdab.presentation;
import java.util.List;

import be.vdab.entities.Persoon;
import be.vdab.enums.PersoonEigenschap;

public class PersoonViewer {
	private final PersoonEigenschap[] eigenschappen;
	
	public PersoonViewer(PersoonEigenschap[] eigenschappen){
		this.eigenschappen = eigenschappen;
	}
	
	public void Afbeelden(List<Persoon> lijst){
		for(Persoon persoon : lijst){
			for(PersoonEigenschap eigenschap : eigenschappen){
				tooneigenschap(persoon, eigenschap);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void tooneigenschap(Persoon persoon, PersoonEigenschap eigenschap){
		switch (eigenschap) {
		case PERSOON_NR:
			System.out.print(persoon.getPersoonNr());
			break;
		case VOORNAAM:
			System.out.print(persoon.getVoornaam());
			break;
		case FAMILIENAAM:
			System.out.print(persoon.getFamilienaam());
			break;
		case AANTAL_KINDEREN:
			System.out.print(persoon.getAantalKinderen());
			break;
		}
	}
}
