package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	@Autowired
	private BrukerService brukerService;
	
	@GetMapping
	public String visLandingpage(Model model) {
		model.addAttribute("brukere", brukerRepo.findAll());
		System.out.println(brukerService.erBrukerAdmin("46838625"));
		return "landingpage";
	}
	

	
	
}
