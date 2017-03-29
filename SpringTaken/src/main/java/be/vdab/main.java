package be.vdab;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.vdab.presentation.PersoonViewer;
import be.vdab.presentation.PresentationConfig;
import be.vdab.repositories.RepositoryConfig;
import be.vdab.services.ServiceConfig;

public class main {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
						new Class[] {PresentationConfig.class, 
								RepositoryConfig.class, ServiceConfig.class})){
			//onderstaande try/catch staan niet in cursus. Echter word er overal een IOException gethrowed. Deze moet gevangen worden.
			try {
				context.getBean(PersoonViewer.class).afbeelden();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
