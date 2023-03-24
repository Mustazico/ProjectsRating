package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.entity.ApiCall;
import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	ApiCall api = new ApiCall();
	
	@GetMapping
	public String visLandingpage(Model model) throws Exception {
		model.addAttribute("brukere", brukerRepo.findAll());
		model.addAttribute("api", api.fetchReadme("h594754", "DAT108_Oblig4"));
		
		return "landingpage";
	}
	

	
	
}
