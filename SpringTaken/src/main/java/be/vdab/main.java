package be.vdab;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.vdab.presentation.PersoonViewer;

public class main {

	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("container.xml")){
			//onderstaande try/catch staan niet in cursus. Echter word er overal een IOException gethrowed. Deze moet gevangen worden.
			try {
				context.getBean(PersoonViewer.class).afbeelden();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
