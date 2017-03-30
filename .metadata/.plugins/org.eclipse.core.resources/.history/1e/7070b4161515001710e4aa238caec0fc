package be.vdab.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.vdab.restclients.KoersenClient;

@Configuration
public class ServicesConfig {
	
	@Bean
	EuroService euroService(KoersenClient koersenClient){
		return new EuroService(koersenClient);
	}
}
