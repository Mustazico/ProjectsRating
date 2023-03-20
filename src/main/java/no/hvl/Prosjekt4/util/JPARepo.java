package no.hvl.Prosjekt4.util;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.Prosjekt4.entity.Brukere;

public interface JPARepo extends JpaRepository<Brukere, Integer>{
	Brukere findByMobil(String mobil); 
}
