package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.*;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	@GetMapping
	public String visLandingpage(Model model, HttpSession session) {
		model.addAttribute("brukere", brukerRepo.findAll());
		
		if(!LoginUtil.erBrukerInnlogget(session)) {
			System.out.println("køkk");
			return "redirect:" + "logginn";
		}
		
		return "landingpage";
	}
}
