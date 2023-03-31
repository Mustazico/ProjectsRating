package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Brukere;

@Service
public class BrukerService {

	
	@Autowired
	private JPARepo brukerRepo; 
	
	@Autowired
	private ProsjektRepo prosjektRepo;
	
	public List<Brukere> finnAlleBrukere() {
		return brukerRepo.findAll();
	}
	public boolean erBrukerAdmin(String mobil) {
		Brukere bruker = brukerRepo.findByMobil(mobil);
		return bruker != null && bruker.getRolle().equals("Admin");
	}
	public String getBrukernavnByProsjektId(String prosjektId) {
		String brukerid = prosjektRepo.findBrukeridByProsjektid(prosjektId);
		int b = Integer.parseInt(brukerid);
		return brukerRepo.findBrukernavnById(b);
		
		
	}
}