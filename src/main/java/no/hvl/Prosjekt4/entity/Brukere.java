
package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//ider-database.westeurope.cloudapp.azure.com/Bonobo.Git.Server/Prosjekt4.git
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Brukere klassen representerer en bruker i systemet. Den inneholder informasjon
 * om brukerens brukernavn, epost, mobilnummer, passord, salt, rolle profilbilde, og bruker intro.
 * Det er også laget getters og setters for alle variablene.
 */

@Entity
@Table(schema = "prosjekt4")
public class Brukere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String brukernavn; 
	private String epost; 
	private String mobil; 
	private String passord; 
	private String salt; 
	private String rolle;
	private String profilbilde;
    private String brukerintro;
	
	/**
	 * Tom konstruktør for brukere.
	 */
	public Brukere() {
		
	}
	
	/**
	 * Konstruktør for brukere.
	 * @param brukernavn er brukernavnet til brukeren.
	 * @param epost er eposten til brukeren.
	 * @param mobil er mobilnummeret til brukeren.
	 * @param passord er passordet til brukeren.
	 * @param salt er saltet som blir brukt for å hashe passordet.
	 * @param rolle er rollen til brukeren, om man er admin eller standard.
	 */
	public Brukere(String brukernavn, String epost, 
			String mobil, String passord, String salt, String rolle) {
		this.brukernavn = brukernavn;
		this.epost = epost; 
		this.epost = epost;
		this.mobil = mobil; 
		this.passord = passord; 
		this.salt = salt; 
		this.rolle = rolle;
	}
	
	/**
	 * Returnerer brukernavnet til brukeren.
	 * @return  brukernavnet til brukeren.
	 * Likt for alle de andre get og set metodene.
	 */
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}
	
	

	public String getProfilbilde() {
		return profilbilde;
	}


	public void setProfilbilde(String profilbilde) {
		this.profilbilde = profilbilde;
	}

	/**
	 * Returnerer brukerintroen til brukeren.
	 * @return brukerintroen til brukeren.
	 */

	@Override
	public String toString() {
		return id + " | " + epost + "|";
	}
	
}
