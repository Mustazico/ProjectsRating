package no.hvl.Prosjekt4.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.Prosjekt4.entity.Brukere;

@Service
public class BrukerService {

	
	@Autowired
	private JPARepo brukerRepo; 
	
	public List<Brukere> finnAlleBrukere() {
		return brukerRepo.findAll();
	}
}
