package be.vdab.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import be.vdab.entities.Persoon;
import be.vdab.repositories.PersoonRepository;

@Service
public class PersoonServiceImpl implements PersoonService {
	private final PersoonRepository persoonRepository;

	public PersoonServiceImpl(@Qualifier("CSV") PersoonRepository persoonRepository) {
		this.persoonRepository = persoonRepository;
	}
	
	@Override
	public List<Persoon> findAll() throws IOException{
		return persoonRepository.findAll();
	}
}
