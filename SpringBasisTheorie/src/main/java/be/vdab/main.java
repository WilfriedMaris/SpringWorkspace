package be.vdab;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("container.xml")){
			ClassA objectA = context.getBean(ClassA.class);
			ClassB objectB = context.getBean(ClassB.class);
			//objectA
			System.out.println(objectA.getKoersenURL());
			System.out.println("Bestand bestaat: " + objectA.getImportData().exists());
			System.out.println(objectA.getDefaultBladRichting());
			//objectB
			System.out.println(objectB.getTelefoonNrhelpDesk());
			System.out.println(objectB.getAantalPogingenUpdateklant());
			//HelpdeskMedewerkers
			System.out.println(context.getBean(HelpdeskMedewerkers.class));
		}
	}
}
