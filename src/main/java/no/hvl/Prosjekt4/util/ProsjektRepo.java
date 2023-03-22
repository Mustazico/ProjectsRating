package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import no.hvl.Prosjekt4.entity.Prosjektliste;

public interface ProsjektRepo extends JpaRepository<Prosjektliste, Integer> {
	
	@Query("SELECT p FROM Prosjektliste p WHERE p.brukerid = :brukerid")
	List<Prosjektliste> findByBrukerid(String brukerid);
}
