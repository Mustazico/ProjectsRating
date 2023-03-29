package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;

public class RatingsUtil {
	
	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String prosjektid) {
	    List<Prosjektliste> retur = new ArrayList<>();
	    List<Prosjektliste> input = prosjektrepo.findAll();
	    
	    
	    input.stream().sorted();
	    
	    retur.addAll(input);
	    return retur;
	}
}