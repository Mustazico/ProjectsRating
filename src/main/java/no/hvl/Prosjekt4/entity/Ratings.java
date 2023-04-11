package no.hvl.Prosjekt4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ratings klassen representerer en rating i systemet. Den inneholder informasjon
 * om prosjektid, brukerid, og verdi.
 * Det er også laget getters og setters for alle variablene.
 */
@Entity
@Table(schema = "prosjekt4")
public class Ratings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String ratingid;
	private String prosjektid;
	private String brukerid;
	private String verdi;

/**
 * lager en tom konstruktør for vurderinger.
 */

	public Ratings() {

	}

	/**
	 * Konstruktør for vurderinger med de gitte parameterne.
	 * @param prosjektid er prosjekt ID til vurderingen.
	 * @param brukerid er bruker ID til vurderingen.
	 * @param verdi er verdien til vurderingen(som en String).
	 */
	public Ratings(String prosjektid, String brukerid, String verdi) {
		this.prosjektid = prosjektid; 
		this.brukerid = brukerid; 
		this.verdi = verdi;
	}

	/**
	 * Får prosjekt ID til prosjektet som er vurdert.
	 * @return prosjekt ID til prosjektet som er vurdert.
	 * Likt for alle de andre get og set metodene.
	 */
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
