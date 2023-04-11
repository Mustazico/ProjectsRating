package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;

public class RatingsUtil {
	
	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String userId) {
	    List<Prosjektliste> retur = prosjektrepo.findByBrukerid(userId);
	    
	    retur.stream()
	    .sorted((p1, p2) -> p2.getGjennomsnittrating().compareTo(p1.getGjennomsnittrating()));
	    Collections.reverse(retur);
	    
	    
	    return retur;
	}
	
	public String regnUtSnitt(RatingRepo repo, String prosjektId) {
		String retur = "";
		
		List<Ratings> liste = repo.findByProsjektid(prosjektId);
		
		List<Integer> verdiListe = liste.stream().map(x -> x.getVerdi()).map(x -> Integer.parseInt(x)).toList();
		
		Double snitt = verdiListe.stream().mapToInt(Integer::intValue).average().getAsDouble();
		
		retur += snitt;
		
		return retur;
	}
}