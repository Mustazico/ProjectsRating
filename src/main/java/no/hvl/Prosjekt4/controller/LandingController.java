package no.hvl.Prosjekt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landingpage")
public class LandingController {
	
	@GetMapping
	public String visLandingpage() {
		System.out.println("Ge de gis");
		return "landingpage";
	}
}
