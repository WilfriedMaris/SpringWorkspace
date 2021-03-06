package be.vdab.repositories;

import java.io.File;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:repository.properties")
public class RepositoryConfig {
	
	@Bean
	@Qualifier("CSV")
	PersoonRepository persoonRepositoryCSV (@Value("${persoonRepositoryCSV}") File bestand){
		return new PersoonRepositoryCSV(bestand);
	}
	
	@Bean
	@Qualifier("MeerdereRegels")
	PersoonRepository persoonRepositoryMeerdereREgels (@Value("${persoonRepositoryTXT}") File bestand){
		return new PersoonRepositoryMeerdereRegels(bestand);
	}

}
