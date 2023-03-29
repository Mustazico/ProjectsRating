package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;

public class RatingsUtil {
	
	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String prosjektid) {
	    List<Prosjektliste> retur = prosjektrepo.findAll();
	    
	    retur.stream().sorted((p1, p2) -> p1.getGjennomsnittrating().compareTo(p2.getGjennomsnittrating()));
	    
	    return retur;
	}
}