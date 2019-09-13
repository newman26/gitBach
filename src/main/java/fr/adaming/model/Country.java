package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="countries")
@XmlRootElement
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String countryName;
	long population;

	@Lob
	private byte[] drapeau;
	
	public Country() {
		super();
	}


	public Country(int id, String countryName, long population, byte[] drapeau) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.population = population;
		this.drapeau = drapeau;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}


	public byte[] getDrapeau() {
		return drapeau;
	}


	public void setDrapeau(byte[] drapeau) {
		this.drapeau = drapeau;
	}
	
	

}
