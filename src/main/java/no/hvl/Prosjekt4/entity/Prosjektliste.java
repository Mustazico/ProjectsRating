package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "prosjekt4")
public class Prosjektliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektid;
	
	
	private String brukerid; 
	private String tittel; 
	private String prosjektlink;

	
	public Prosjektliste() {
		
	}
	
	public Prosjektliste(String brukerId, String tittel, String prosjektlink) {
		this.brukerid = brukerId; 
		this.tittel = tittel;
		this.prosjektlink = prosjektlink;
	}

	public String getBrukerId() {
		return brukerid;
	}

	public void setBrukerId(String brukerId) {
		this.brukerid = brukerId;
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
	
	
	@Override
	public String toString() {
		return "BrukerId: " + brukerid + "\nProsjektlink:"+ prosjektlink;
	}
	
}
