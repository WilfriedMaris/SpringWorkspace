package be.vdab;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.vdab.gaming.Spelletje;

public class main {

	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml")){
			System.out.println(context.getBean(Spelletje.class).getAantalVijanden());
		}
		
//		try(AnnotationConfigApplicationContext context = 
//				new AnnotationConfigApplicationContext(
//						new Class[] {PresentationConfig.class, 
//								RepositoryConfig.class, ServiceConfig.class})){
//			//onderstaande try/catch staan niet in cursus. Echter word er overal een IOException gethrowed. Deze moet gevangen worden.
//			try {
//				context.getBean(PersoonViewer.class).afbeelden();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}

	}

}
