package be.vdab;

import java.util.Properties;

public class HelpdeskMedewerkers {
	private final Properties medewerkers; //key = naam medewerker, value = intern telefoonnummer

	HelpdeskMedewerkers(Properties medewerkers){
		this.medewerkers = medewerkers;
	}

	public String toString(){
	return medewerkers.toString();
	}

}
