package no.hvl.Prosjekt4.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import no.hvl.Prosjekt4.util.ApiCallService;
import javax.servlet.http.*;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.ProsjektService;

@Controller
@RequestMapping(value="/landingpage", produces="text/html;charset=UTF-8")
public class LandingsideController {
	
	@Autowired
	private JPARepo brukerRepo; 
	
	@Autowired
	private ApiCallService api;
	@Autowired
	private BrukerService brukerService;
	
	@Autowired
	private ProsjektRepo pr; 
	
	@Autowired
	private ProsjektService ps; 
	
	@GetMapping
	public String visLandingpage(Model model, HttpSession session) throws Exception {		
		return "landingpage";
	}
}
	
	
		
