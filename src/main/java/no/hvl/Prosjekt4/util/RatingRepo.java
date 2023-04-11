package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.Prosjekt4.entity.Ratings;

public interface RatingRepo extends JpaRepository<Ratings, Integer> {

	static List<Ratings> findByProsjektid(String id) {
		throw new UnsupportedOperationException("Unimplemented method 'findByProsjektid'");
	}

	boolean existsByBrukerid(int id);

	Ratings findByProsjektidAndBrukerid(String prosjektid, String brukernavn);

}
