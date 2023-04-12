package no.hvl.Prosjekt4.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Math;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;

/**
 * RatingsUtil klassen inneholder metoder for å sortere prosjekter etter gjennomsnittrating, 
 * og for å regne ut gjennomsnittrating for et prosjekt
 */
public class RatingsUtil {

	@Autowired
	RatingRepo repo;
	
	@Autowired
	ProsjektRepo prosjektrepo;
	
	public RatingsUtil() {
	}

	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String userId) {
		List<Prosjektliste> retur = prosjektrepo.findByBrukerid(userId);

		retur = retur.stream()
				.sorted((p1, p2) -> p1.getGjennomsnittrating().compareTo(p2.getGjennomsnittrating()))
				.collect(Collectors.toList());
		
		Collections.reverse(retur);

		return retur;
	}

	public String regnUtSnitt(RatingRepo repo, String prosjektId) {
		String retur = "";

		List<Ratings> liste = repo.findByProsjektid(prosjektId);

		List<Integer> verdiListe = liste.stream()
				.map(x -> x.getVerdi())
				.map(x -> Integer.parseInt(x))
				.toList();

		Double snitt = verdiListe.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();

		snitt = Math.round(snitt * 10.0) / 10.0;
		

		retur += snitt;

		return retur;
	}
	
	public boolean hasUserRatedProject(RatingRepo repo, String projectId, String username) {
		List<Ratings> ratings = repo.findByProsjektid(projectId);
		for (Ratings rating : ratings) {
			if (rating.getBrukerid().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	

}