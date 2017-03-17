package be.vdab;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.vdab.entities.Persoon;
import be.vdab.presentation.PersoonViewer;

public class main {

	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("container.xml")){
			context.getBean(PersoonViewer.class).Afbeelden(Arrays.asList(
					new Persoon(101, "Dennis", "Maris", 2),
					new Persoon(102, "Willy", "Maris", 4),
					new Persoon(103, "Linda", "Maris", 8)));
		}

	}

}
