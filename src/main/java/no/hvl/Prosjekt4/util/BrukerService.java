package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Brukere;

/**
 * Serviceklasse for Brukere
 */
@Service
public class BrukerService {

	
	@Autowired
	private JPARepo brukerRepo; 
	
	@Autowired
	private ProsjektRepo prosjektRepo;
	
	/**
	 * Finner alle registrerte brukere i systemet
	 * @return en liste av registrerte brukere.
	 */

	public List<Brukere> finnAlleBrukere() {
		return brukerRepo.findAll();
	}
	/**
	 * Sjekker om brukeren med gitt mobilnummer er admin
	 * @param mobil er mobilnummeret til brukeren som skal sjekkes
	 * @return true hvis brukeren er admin, false hvis ikke
	 */
	public boolean erBrukerAdmin(String mobil) {
		Brukere bruker = brukerRepo.findByMobil(mobil);
		return bruker != null && bruker.getRolle().equals("Admin");
	}
	/**
	 * Får bruker navn fra bruker id gitt ved prosjket id
	 * @param prosjektId er ID til prosjektet som skal sjekkes
	 * @return brukernavn til brukeren som eier prosjektet, null hvis ikke funnet
	 */
	public String getBrukernavnByProsjektId(String prosjektId) {
		String brukerid = prosjektRepo.findBrukeridByProsjektid(prosjektId);
		int b = Integer.parseInt(brukerid);
		return brukerRepo.findBrukernavnById(b);
		
		
	}
}