package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.util.ProsjektRepo;

@Controller
@RequestMapping(value = "person")
public class ProsjektlisteController {
	
	@Autowired
	ProsjektRepo prepo; 
	
	@GetMapping
	public String visPerson(Model model) {
		model.addAttribute("hei", prepo.findByBrukerid("0"));
		return "person";
	}
}