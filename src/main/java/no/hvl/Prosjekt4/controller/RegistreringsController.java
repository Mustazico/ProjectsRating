package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping(value = "registering")
public class RegistreringsController {

	@Autowired
	JPARepo brukerRepo;
	
	@GetMapping
	public String visRegistrering() {
		return "registrering";
	}
	
	@PostMapping
	public String registrerBruker(@RequestParam(name = "username") String brukernavn, @RequestParam(name = "password") String passord) {
		System.out.println("Før save:");
		Brukere b = new Brukere("Mandela", "fredrik.kenneth@hotmail.com", "45433221", passord, "tiss", "Standard");
		
		brukerRepo.save(b);
		System.out.println("Etter save:");
		return "redirect:" + "landingpage";
	}
	
}
