package be.vdab.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.vdab.entities.Persoon;

//@Repository
//@Qualifier("CSVFormaat")
class PersoonRepositoryCSV implements PersoonRepository{
	private final File bestand;
	
	PersoonRepositoryCSV(/*@Value("${persoonRepositoryCSV}")*/ File bestand){
		this.bestand = bestand;
	}

	@Override
	public List<Persoon> findAll() throws IOException {
		List<Persoon> personen = new ArrayList<>();
		try(Scanner scanner = new Scanner(bestand)){
			while(scanner.hasNext()){
				String[] persoon = scanner.nextLine().split(",");
				personen.add(
						new Persoon(
								Integer.parseInt(persoon[0]),persoon[1],persoon[2],Integer.parseInt(persoon[3])));
			}
		}
		return personen;
	}
}
