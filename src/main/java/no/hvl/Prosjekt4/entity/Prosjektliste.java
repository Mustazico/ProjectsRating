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
	private String prosjektid;
	
	
	private String brukerid; 
	private String tittel; 
	private String prosjektlink;
	private String antallstemmer;
	private Double gjennomsnittrating;
	

	
	public Prosjektliste() {
		
	}
	
	public Prosjektliste(String brukerid, String tittel, String prosjektlink) {
		this.brukerid = brukerid; 
		this.tittel = tittel;
		this.prosjektlink = prosjektlink;
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

	public Double getGjennomsnittrating() {
		return gjennomsnittrating;
	}

	public void setGjennomsnittrating(Double gjennomsnittrating) {
		this.gjennomsnittrating = gjennomsnittrating;
	}

	@Override
	public String toString() {
		return "BrukerId: " + brukerid + "\nProsjektlink:"+ prosjektlink;
	}
	
	public int compareTo(Prosjektliste other) {
        return Double.compare(other.getGjennomsnittrating(), this.getGjennomsnittrating());
    }
}
