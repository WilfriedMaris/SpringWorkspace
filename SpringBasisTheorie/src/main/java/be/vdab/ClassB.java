package be.vdab;

class ClassB implements InterfaceB{
	private final String telefoonNrhelpDesk;
	private final int aantalPogingenUpdateklant;
	
	ClassB(String telefoonNrHelpDesk, int aantalPogingenUpdateKlant){
		this.telefoonNrhelpDesk = telefoonNrHelpDesk;
		this.aantalPogingenUpdateklant = aantalPogingenUpdateKlant;
	}

	public String getTelefoonNrhelpDesk() {
		return telefoonNrhelpDesk;
	}

	public int getAantalPogingenUpdateklant() {
		return aantalPogingenUpdateklant;
	}

	public String getBoodschap() {
		return "ClassB object";
	}
}
