package be.vdab.restclients;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ECB")
public class ECBKoersenClient implements KoersenClient{
	private static final Logger LOGGER = Logger.getLogger(ECBKoersenClient.class.getName());
	private final URL url;
	
	public ECBKoersenClient(@Value ("${ecbKoersenURL}") URL url){
		this.url = url;
	}
	
	@Override
	public BigDecimal getDollarKoers(){
		try(Scanner xmlScanner = new Scanner(url.openStream())){
			String regel;
			//regel per regel lezen tot we een regel vinden die USD bevat:
			while(! (regel = xmlScanner.nextLine()).contains("USD"));
			try(Scanner regelScanner = new Scanner(regel)){ //in die regel zelf lezen
				regelScanner.findInLine("rate='"); //tekens overslaan tot en met rate='
				regelScanner.useDelimiter("'"); // volgende leesoperatie stopt bij '
				return new BigDecimal(regelScanner.next());
			}
		}catch(IOException | NumberFormatException ex){
			LOGGER.log(Level.SEVERE, "kan koers niet lezen via ECB", ex);
			return null;
		}
	}
}
