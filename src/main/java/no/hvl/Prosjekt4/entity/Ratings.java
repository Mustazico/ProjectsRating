package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "prosjekt4")
public class Ratings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String ratingid;
	private String prosjektid;
	private String brukerid;
	private String verdi;

	public Ratings() {

	}

	public Ratings(String prosjektid, String brukerid, String verdi) {
		this.prosjektid = prosjektid; 
		this.brukerid = brukerid; 
		this.verdi = verdi;
	}

	public String getProsjektid() {
		return prosjektid;
	}

	public void setProsjektid(String prosjektid) {
		this.prosjektid = prosjektid;
	}

	public String getBrukerid() {
		return brukerid;
	}

	public void setBrukerid(String brukerid) {
		this.brukerid = brukerid;
	}

	public String getVerdi() {
		return verdi;
	}

	public void setVerdi(String verdi) {
		this.verdi = verdi;
	}

	public String getRatingid() {
		return ratingid;
	}

	public void setRatingid(String ratingid) {
		this.ratingid = ratingid;
	}
	
	

}
