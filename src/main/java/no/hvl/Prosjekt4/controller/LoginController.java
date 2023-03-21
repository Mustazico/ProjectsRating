package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping("/logginn")
public class LoginController {
	
	@Autowired
	JPARepo brukerrepo;

    @GetMapping
    public String visLogginn() {
        return "logginn";
    }

    @PostMapping
    public String loggInn(@RequestParam(name = "username") String brukernavn,
            @RequestParam(name = "password") String passord, RedirectAttributes ra) {
        if (brukernavn.equals("admin") && passord.equals("passord")) {
            ra.addFlashAttribute("msg", "Du er logget inn");
            return "redirect:" + "landingpage";
        }
        ra.addFlashAttribute("msg", "Feil brukernavn eller passord");
        return "redirect:" + "logginn";
    }
}