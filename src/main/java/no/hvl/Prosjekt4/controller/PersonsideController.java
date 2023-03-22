package no.hvl.Prosjekt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personside")

public class PersonsideController {
    @GetMapping
	public String visPersonside() {
		return "personside";
	}
    
}
