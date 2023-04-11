package no.hvl.Prosjekt4.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.Prosjekt4.entity.Ratings;

public interface RatingRepo extends JpaRepository<Ratings, Integer> {

	/**
	 * @param id er prosjket id
	 * @return er en liste med ratings for prosjektet med prosjektid
	*/

	List<Ratings> findByProsjektid(String id);


	/**
	 * Sjekker om det finnes en rating med brukerid
	 * 
	 * @param id er bruker id
	 * @return true om en rating med brukerid finnes, false om ikke
	*/

	boolean existsByBrukerid(int id);

	/**
	 * Returnerer en rating for et gitt prosjekt id og bruker id
	 * 
	 * @param prosjektid er prosjekt id
	 * @param brukernavn er bruker id
	 * @return rating for et gitt prosjekt id og bruker id
	*/


	Ratings findByProsjektidAndBrukerid(String prosjektid, String brukernavn);

}