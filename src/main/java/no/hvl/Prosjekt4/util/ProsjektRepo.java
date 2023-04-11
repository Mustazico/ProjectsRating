package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import no.hvl.Prosjekt4.entity.Prosjektliste;

/**
 * ProsjektRepo definerer metoder for databaseoperasjoner knyttet til prosjektliste enheten
 * 
 */

public interface ProsjektRepo extends JpaRepository<Prosjektliste, Integer>{
	/**
	 * Returnerer en Prosjektliste entity ved å søke på tittelen til prosjektet.
	 * @param tittel er tittelen til prosjektet som skal returneres.
	 * @return en Prosjektliste entity, null hvis ikke funnet.
	 */
	Prosjektliste findByTittel(String tittel);
	/**
	 * Returnerer en Prosjektliste entity ved å søke på linken til prosjektet.
	 * @param prosjektlink er linken til prosjektet som skal returneres.
	 * @return en Prosjektliste entity, null hvis ikke funnet.
	 */
	Prosjektliste findByProsjektlink(String prosjektlink);
	/**
	 * Returnerer en liste av Prosjektliste entiteter som er tilknyttet en bruker.
	 * @param brukerid prosjektid til prosjektet som skal returneres.
	 * @return en Prosjektliste entitet som er tilknyttet en bruker.
	 * Likt nedover
	 */
	
	@Query("SELECT p FROM Prosjektliste p WHERE p.brukerid = :brukerid")
	List<Prosjektliste> findByBrukerid(String brukerid);
	
	@Query("SELECT p.prosjektlink FROM Prosjektliste p WHERE p.brukerid= :id")
	List<String> findUsersProsjektlink(@Param("id")int id);
	
	@Query("SELECT p.prosjektlink FROM Prosjektliste p WHERE p.prosjektid= :id")
	String findProsjektidProsjektlink(@Param("id") String users);

	@Query("SELECT p.prosjektlink FROM Prosjektliste p WHERE p.brukerid = :brukerid")
    List<String> findUsersProsjektlink(@Param("brukerid") String brukerid);
    
	@Query("SELECT p.profilbilde FROM Brukere p WHERE p.id = :id")
    String getProfilBilde(@Param("id") String id);
	
	@Query("SELECT p.prosjektid FROM Prosjektliste p WHERE p.brukerid = :brukerid")
	List<String> findUsersProsjektid(@Param("brukerid") String id);
	
	
//	@Query("SELECT p.brukernavn FROM Prosjektliste p WHERE p.prosjektid = :prosjektid")
//	String findUsername(@Param("prosjektid") Prosjektliste p);
	
	boolean existsByBrukerid(String id);
	boolean existsByTittel(String tittel);
	boolean existsByProsjektlink(String prosjektlink);
	
	void deleteByProsjektid(String prosjektid);
	List<Prosjektliste> findProsjektByBrukerid(String id);
	Prosjektliste findByProsjektid(String users);
	
	
	@Query("SELECT p.brukerid FROM Prosjektliste p WHERE p.prosjektid = :prosjektid")
	String findBrukeridByProsjektid(@Param("prosjektid") String p);
	
	@Query("SELECT p.prosjektid FROM Prosjektliste p WHERE p = :p")
	String findProsjektid(Prosjektliste p);
}
