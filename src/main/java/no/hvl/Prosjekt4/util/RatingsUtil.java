package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;

public class RatingsUtil {
	
	public List<Prosjektliste> sortedRatings(RatingRepo ratingrepo, String prosjektid){
		 List<Prosjektliste> retur = new ArrayList<Prosjektliste>();
		 retur = ratingrepo.findByProsjektid(prosjektid);
		 
		 
		 
		 return retur;
	}
}
