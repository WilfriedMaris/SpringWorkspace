package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class InMemoryBrouwerRepository implements BrouwerRepository {
	private ConcurrentHashMap<Long, Brouwer> brouwers = new ConcurrentHashMap<>();

	InMemoryBrouwerRepository() {
		brouwers.put(1L, new Brouwer(1, "Wilfried Maris", 
				new Adres("Kempenlaan", "15", 3600, "Genk"), 15513));
		brouwers.put(2L, new Brouwer(2, "Dennis Teunis", 
				new Adres("Raralaan", "19", 3500, "Hasselt"), 19512));
		brouwers.put(3L, new Brouwer(3, "Linda Loiacono",
				new Adres("Stratidaloia", "30", 2200, "Italia"), 210));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwer.setId(Collections.max(brouwers.keySet()) + 1);
		brouwers.put(brouwer.getId(), brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		beginNaam = beginNaam.toUpperCase();
		List<Brouwer> resultaat = new ArrayList<>();
		for(Brouwer brouwer : brouwers.values()){
			if(brouwer.getNaam().toUpperCase().startsWith(beginNaam)){
				resultaat.add(brouwer);
			}
		}
		return resultaat;
	}

}