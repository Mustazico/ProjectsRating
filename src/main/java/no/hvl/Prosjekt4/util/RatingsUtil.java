package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;

/**
 * RatingsUtil klassen inneholder metoder for å sortere prosjekter etter gjennomsnittrating, 
 * og for å regne ut gjennomsnittrating for et prosjekt
 */

public class RatingsUtil {
	
	/**
	 * Returnerer en liste med prosjekter for en gitt bruker, sortert etter gjennomsnittrating i synkende rekkefølge
	 * @param prosjektrepo er repositoriet for prosjekter
	 * @param userId er brukerid til brukeren som eier prosjektene
	 * @return en sortert liste med prosjekter
	 */
	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String userId) {
	    List<Prosjektliste> retur = prosjektrepo.findByBrukerid(userId);
	    
	    retur.stream()
	    .sorted((p1, p2) -> p2.getGjennomsnittrating().compareTo(p1.getGjennomsnittrating()));
	    Collections.reverse(retur);
	    
	    
	    return retur;
	}
	/**
	 * Regner ut gjennomsnittrating for et prosjekt
	 * @param repo er repositoriet for ratings
	 * @param prosjektId er prosjektid til prosjektet som skal regnes ut
	 * @return gjennomsnittratingen til prosjektet
	 */
	
	public String regnUtSnitt(RatingRepo repo, String prosjektId) {
		String retur = "";
		
		List<Ratings> liste = repo.findByProsjektid(prosjektId);
		
		List<Integer> verdiListe = liste.stream().map(x -> x.getVerdi()).map(x -> Integer.parseInt(x)).toList();
		
		Double snitt = verdiListe.stream().mapToInt(Integer::intValue).average().getAsDouble();
		
		retur += snitt;
		
		return retur;
	}
}