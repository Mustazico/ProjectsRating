package no.hvl.Prosjekt4.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	@Autowired
	private ApiCallService api;
	@Autowired
	private BrukerService brukerService;
	
	@GetMapping
	public String visLandingpage(Model model, HttpSession session) throws Exception {
		
		model.addAttribute("brukere", brukerRepo.findAll());
		
		
//		if(!LoginUtil.erBrukerInnlogget(session)) {
//			System.out.println("køkk");
//			return "redirect:" + "logginn";
//		}
		
		
		return "landingpage";
	}
}
