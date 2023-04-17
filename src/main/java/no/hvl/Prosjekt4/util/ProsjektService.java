package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Prosjektliste;

/**
 * Denne klassen representerer en tjeneste som gir
 *  operasjoner for håndtering av prosjekter.
 */

@Service
public class ProsjektService {
	/**
	 * ProsjektRepo er repositoriet for prosjekter.
	 */

	private final ProsjektRepo prosjektRepo;
	/**
	 * Konstruktør for ProsjektService.
	 * @param prepo er repositoriet for prosjekter.
	 */
	public ProsjektService(ProsjektRepo prepo) {
		this.prosjektRepo = prepo;
	}
	/**
	 * Får en liste med prosjekter for en gitt bruker.
	 * @param brukerId er brukerid til brukeren som eier prosjektene.
	 * @return en liste med prosjekter for en spesifikk bruker.
	 */
	
	public List<Prosjektliste> getProsjektliste(String brukerId) {
		return prosjektRepo.findByBrukerid(brukerId);
	}
	/**
	 * Sletter et prosjekt med en gitt prosjektid.
	 * @param prosjektid er prosjektid til prosjektet som skal slettes.
	 */
	
	public void slettProsjekt(String prosjektid) {
		prosjektRepo.deleteByProsjektid(prosjektid);
	}
	
    public String finnTittel(String id) {
        String tittel = prosjektRepo.findProsjektidTittel(id);
        return tittel;
    }
    
	/**
	 * Denne metoden brukes til å splitte GitHub brukernavn fra prosjekt linken.
	 * @param id er prosjekt id'en.
	 * @return String som er GitHub brukernavnet.
	 * @throws Exception kan kaste en exception.
	 */
    public String splitBrukernavn(String id) {
        String lenke = prosjektRepo.findProsjektidProsjektlink(id);
        String[] deler = lenke.split("/");
        String brukernavn = deler[3];
        return brukernavn;
    }
	
}
