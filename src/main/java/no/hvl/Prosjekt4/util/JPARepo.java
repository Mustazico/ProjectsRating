package no.hvl.Prosjekt4.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.entity.Prosjektliste;

public interface JPARepo extends JpaRepository<Brukere, Integer>{
	Brukere findByMobil(String mobil); 
	Brukere findByEpost(String mail);
	Brukere findByBrukernavn(String brukernavn);
	Brukere findByRolle(String rolle); 
    Brukere findById(int id);
	boolean existsByMobil(String tlf);
	boolean existsByEpost(String mail);
	boolean existsByBrukernavn(String brukernavn);

    @Query("SELECT p.profilbilde FROM Brukere p WHERE p.id = :id")
    String getProfilbilde(@Param("id") int id);

    @Query("SELECT p.brukernavn FROM Brukere p WHERE p.id = :id")
    String getBrukernavn(@Param("id") int id);

    @Query("SELECT p.brukerintro FROM Brukere p WHERE p.id = :id")
    String getBrukerintro(@Param("id") int id);
}
