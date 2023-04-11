package no.hvl.Prosjekt4.util;

import java.util.ArrayList;
import java.util.List;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;
import no.hvl.Prosjekt4.util.RatingRepo;

public class RatingsUtil {

	public List<Prosjektliste> sortedByRatings(ProsjektRepo prosjektrepo, String prosjektid) {
		List<Prosjektliste> retur = prosjektrepo.findAll();

		retur.stream().sorted((p1, p2) -> p1.getGjennomsnittrating().compareTo(p2.getGjennomsnittrating()));

		return retur;
	}

	public boolean hasUserRatedProject(String projectId, String username) {
		List<Ratings> ratings = RatingRepo.findByProsjektid(projectId);
		for (Ratings rating : ratings) {
			if (rating.getBrukerid().equals(username)) {
				return true;
			}
		}
		return false;
	}

}