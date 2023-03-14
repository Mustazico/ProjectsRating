package no.hvl.Prosjekt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landingpage")
public class LandingsideController {
	
	@GetMapping
	public String visLandingpage() {
		return "landingpage";
	}
}
