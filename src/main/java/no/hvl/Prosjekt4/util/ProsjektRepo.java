package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.Prosjekt4.entity.Prosjektliste;

public interface ProsjektRepo extends JpaRepository<Prosjektliste, Integer>{
	List<Prosjektliste> findByBrukerid(String id); 
	Prosjektliste findByTittel(String tittel);
	Prosjektliste findByProsjektlink(String prosjektlink);
	
	
	boolean existsByBrukerid(String id);
	boolean existsByTittel(String tittel);
	boolean existsByProsjektlink(String prosjektlink);
}
