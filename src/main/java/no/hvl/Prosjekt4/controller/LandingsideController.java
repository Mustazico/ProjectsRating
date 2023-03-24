package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import no.hvl.Prosjekt4.entity.ApiCall;
import javax.servlet.http.*;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	ApiCall api = new ApiCall();
	@Autowired
	private BrukerService brukerService;
	
	@GetMapping
	public String visLandingpage(Model model, HttpSession session) throws Exception {
		model.addAttribute("brukere", brukerRepo.findAll());
		model.addAttribute("api", api.fetchReadme("h594754", "DAT108_Oblig4"));
		
		if(!LoginUtil.erBrukerInnlogget(session)) {
			System.out.println("køkk");
			return "redirect:" + "logginn";
		}
		
		return "landingpage";
	}
}
