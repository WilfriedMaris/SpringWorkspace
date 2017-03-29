package be.vdab;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.vdab.restclients.RestClientsConfig;
import be.vdab.services.EuroService;
import be.vdab.services.ServicesConfig;

public class main {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
						new Class[] {ServicesConfig.class,RestClientsConfig.class})){
//			ClassA objectA = context.getBean(ClassA.class);
//			ClassB objectB = context.getBean(ClassB.class);
//		//objectA
//			System.out.println(objectA.getKoersenURL());
//			System.out.println("Bestand bestaat: " + objectA.getImportData().exists());
//			System.out.println(objectA.getDefaultBladRichting());
//			System.out.println(objectA.getWebMasterEMailAdres());
//			System.out.println(objectA.getWebsiteGestart());
//			System.out.println();
//		//objectB
//			System.out.println(objectB.getTelefoonNrhelpDesk());
//			System.out.println(objectB.getAantalPogingenUpdateklant());
//			System.out.println();
//		//HelpdeskMedewerkers
//			System.out.println(context.getBean(HelpdeskMedewerkers.class));
//			System.out.println();
//		//Tellers
//			context.getBean("teller1", Teller.class).verhoog();
//			context.getBean("teller1", Teller.class).verhoog();
//			Teller teller2 = context.getBean("teller2", Teller.class);
//			teller2.verhoog();
//			context.getBean("teller2", Teller.class).verhoog();
//			System.out.println();
		//EuroService
			System.out.println(context.getBean(EuroService.class).naarDollar(BigDecimal.valueOf(2)));
			
		}
	}
}
