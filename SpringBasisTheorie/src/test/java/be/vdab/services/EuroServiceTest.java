package be.vdab.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.restclients.DummyKoersenClient;
import be.vdab.restclients.KoersenClient;

public class EuroServiceTest {
	private KoersenClient koersenClient;
	private EuroService euroService;
	
	@Before
	public void Before(){
		koersenClient = new DummyKoersenClient(); //Dummy injecteren in de service
		euroService = new EuroService(koersenClient);
	}
	
	@Test
	public void naarDollar(){
		assertEquals(0,BigDecimal.valueOf(3).compareTo(euroService.naarDollar(BigDecimal.valueOf(2))));
	}

}
