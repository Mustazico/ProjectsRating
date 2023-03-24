
package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//ider-database.westeurope.cloudapp.azure.com/Bonobo.Git.Server/Prosjekt4.git
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	public Brukere() {
		
	}
	
	
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


	@Override
	public String toString() {
		return id + " | " + epost + "|";
	}
	
}
