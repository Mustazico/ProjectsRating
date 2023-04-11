package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import no.hvl.Prosjekt4.entity.Ratings;

public interface RatingRepo extends JpaRepository<Ratings, Integer> {

	List<Ratings> findByProsjektid(String id);

	boolean existsByBrukerid(int id);

	Ratings findByProsjektidAndBrukerid(String prosjektid, String brukernavn);

}