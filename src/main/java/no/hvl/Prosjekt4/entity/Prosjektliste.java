package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(schema = "prosjekt4")
public class Prosjektliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String prosjektid;
	
	
	private String brukerid; 
	private String tittel; 
	private String prosjektlink;
	private String antallstemmer;
	private String gjennomsnittrating;
	
	@Lob
	private String readme;
	

	
	public Prosjektliste() {
		
	}
	
	public Prosjektliste(String brukerid, String tittel, String prosjektlink) {
		this.brukerid = brukerid; 
		this.tittel = tittel;
		this.prosjektlink = prosjektlink;
		this.antallstemmer = "0";
		this.gjennomsnittrating = "0";
	}

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

	public String getGjennomsnittrating() {
		return gjennomsnittrating;
	}

	public void setGjennomsnittrating(String gjennomsnittrating) {
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

	@Override
	public String toString() {
		return "BrukerId: " + brukerid + "\nProsjektlink:"+ prosjektlink;
	}
}
