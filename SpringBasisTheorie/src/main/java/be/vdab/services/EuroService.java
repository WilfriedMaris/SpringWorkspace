package be.vdab.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import be.vdab.restclients.KoersenClient;

//@Service
public class EuroService {
	private final KoersenClient koersenClient;
	
	public EuroService(/*@Qualifier("ECB")*/ KoersenClient koersenClient){
		this.koersenClient = koersenClient;
	}
	
	public BigDecimal naarDollar(BigDecimal euro){
		return euro.multiply(koersenClient.getDollarKoers())
				.setScale(2, RoundingMode.HALF_UP);
	}

}
