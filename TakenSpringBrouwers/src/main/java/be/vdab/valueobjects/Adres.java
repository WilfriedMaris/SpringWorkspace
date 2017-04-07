package be.vdab.valueobjects;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.constraints.Postcode;

public class Adres implements Serializable{
	private final static long serialVersionUID = 1L;
	@SafeHtml
	@NotBlank
	private String straat;
	@SafeHtml
	@NotBlank
	private String huisNr;
	@Postcode
	private Integer postcode;
	@SafeHtml
	@NotBlank
	private String gemeente;
	
	public Adres(){}
	
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}


	public String getHuisNr() {
		return huisNr;
	}


	public Integer getPostcode() {
		return postcode;
	}


	public String getGemeente() {
		return gemeente;
	}
	
}
