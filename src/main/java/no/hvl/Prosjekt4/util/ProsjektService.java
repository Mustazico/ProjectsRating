package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Prosjektliste;

@Service
public class ProsjektService {

	private final ProsjektRepo prepo;
	
	public ProsjektService(ProsjektRepo prepo) {
		this.prepo = prepo;
	}
	
	public List<Prosjektliste> getProsjektliste(String brukerId) {
		return prepo.findByBrukerid(brukerId);
	}
	
}
