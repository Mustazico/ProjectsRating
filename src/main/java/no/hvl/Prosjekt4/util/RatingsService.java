package no.hvl.Prosjekt4.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Ratings;

@Service
public class RatingsService {

	@Autowired
	RatingRepo rp;

//	public String getStarsForProjectByUser(String prosjektid, String brukernavn) {
//		Ratings rating = rp.findVerdiByProsjektidAndBrukerid(prosjektid, brukernavn);
//		if(rating != null) {
//			rating.getVerdi();
//		} 
//		return null; 
//		
//	} 
	
	
}
