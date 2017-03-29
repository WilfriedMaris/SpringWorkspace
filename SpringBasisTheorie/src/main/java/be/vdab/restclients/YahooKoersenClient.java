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
@Qualifier("Yahoo")
public class YahooKoersenClient implements KoersenClient{
	private static final Logger LOGGER = Logger.getLogger(YahooKoersenClient.class.getName());
	private final URL url;
	
	public YahooKoersenClient(@Value("${yahooKoersenURL}") URL url){
		this.url = url;
	}
	
	@Override
	public BigDecimal getDollarKoers(){
		try(Scanner scanner = new Scanner(url.openStream())){
			return new BigDecimal(scanner.nextLine());
		}catch(IOException | NumberFormatException ex){
			LOGGER.log(Level.SEVERE, "Kan koers niet lezen via Yahoo", ex);
			return null;
		}
	}

}
