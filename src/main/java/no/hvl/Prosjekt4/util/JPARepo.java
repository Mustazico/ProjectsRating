package no.hvl.Prosjekt4.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.entity.Prosjektliste;

/**
 * JPARepo definerer metoder for databaseoperasjoner knyttet til Brukere enheten
 * 
 */
public interface JPARepo extends JpaRepository<Brukere, Integer> {

    /**
     * FInner "Brukere" ved å søke på mobilnummeret
     * My likt nedover
     */
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

    @Query("SELECT p.rolle FROM Brukere p WHERE p.mobil= :mobil")
    String erBrukerAdmin(@Param("mobil") String mobil);

    @Query("SELECT p.brukernavn FROM Brukere p WHERE p.id = :id")
    String findBrukernavnById(@Param("id") int id);
    
    @Query("SELECT p.linkedinlenke FROM Brukere p WHERE p.id = :id")
    String findLinkedinlenkeById(@Param("id") int id);

}
