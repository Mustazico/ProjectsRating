package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Denne klassen representerer en prosjektliste i systemet. Den inneholder informasjon
 * om prosjektid, brukerid, tittel, prosjektlink, antallstemmer, gjennomsnittrating og readme.
 */

@Entity
@Table(schema = "prosjekt4")
public class Prosjektliste {

	/**
	 * Den unike id-en til prosjektet.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String prosjektid;
	/**
	 * Brukerid til brukeren som har laget prosjektet.
	 */
	
	private String brukerid; 
	/**
	 * Tittelen til prosjektet.
	 */
	private String tittel; 
	/**
	 * Linken til prosjektet.
	 */
	private String prosjektlink;
	/**
	 * Antallstemmer til prosjektet.
	 */
	private String antallstemmer;
	/**
	 * Gjennomsnittrating til prosjektet.
	 */
	private Double gjennomsnittrating;
	/**
	 * Readme til prosjektet.
	 */
	
	@Lob
	private String readme;
	 
	/**
	 * Tom konstruktør for Prosjektliste.
	 */
	public Prosjektliste() {
		
	}
	/**
	 * Konstruktør for Prosjektliste.
	 * @param brukerid unike id-en til brukeren som har laget prosjektet.
	 * @param tittel tittelen til prosjektet.
	 * @param prosjektlink linken til prosjektet.
	 */
	
	public Prosjektliste(String brukerid, String tittel, String prosjektlink) {
		this.brukerid = brukerid; 
		this.tittel = tittel;
		this.prosjektlink = prosjektlink;
		this.readme = readme; 
	}
	//Getters og setters for Prosjektliste.

	public String getBrukerid() {
		return brukerid;
	}

	public void setBrukerid(String brukerid) {
		this.brukerid = brukerid;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getProsjektlink() {
		return prosjektlink;
	}

	public void setProsjektlink(String prosjektlink) {
		this.prosjektlink = prosjektlink;
	}
	
	public String getAntallstemmer() {
		return antallstemmer;
	}

	public void setAntallstemmer(String antallstemmer) {
		this.antallstemmer = antallstemmer;
	}

	public Double getGjennomsnittrating() {
		return gjennomsnittrating;
	}

	public void setGjennomsnittrating(Double gjennomsnittrating) {
		this.gjennomsnittrating = gjennomsnittrating;
	}
	

	public String getProsjektid() {
		return prosjektid;
	}

	public void setProsjektid(String prosjektid) {
		this.prosjektid = prosjektid;
	}
	
	

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	/**
	 * toString metode for Prosjektliste.
	 */

	@Override
	public String toString() {
		return "BrukerId: " + brukerid + "\nProsjektlink:"+ prosjektlink;
	}
}
