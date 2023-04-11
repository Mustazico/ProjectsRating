package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.util.ProsjektRepo;

/** 
 * ProsjektlisteController klassen er en Spring MVC-kontroller som er
ansvarlig for å håndtere HTTP-forespørsler knyttet til "person"-ressursen.
 */
@Controller
@RequestMapping(value = "person")
public class ProsjektlisteController {
	
	@Autowired
	ProsjektRepo prepo; 
	
	/**
	 * Denne metoden håndterer HTTP GET-forespørsler for å vise person. Den får en liste med prosjekter og legger den til i modellen.
	 * @param model er en model som inneholder informasjon som skal vises på siden.
	 * @return visning av "person".
	 */
	@GetMapping
	public String visPerson(Model model) {
		model.addAttribute("hei", prepo.findByBrukerid("0"));
		return "person";
	}
}