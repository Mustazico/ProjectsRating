package no.hvl.Prosjekt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "login")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String brukernavn, @RequestParam String passord) {

        // Sjekker om passord og brukernavn er riktig

        if (brukernavn.equals("admin") && passord.equals("passord")) {
            return "Innlogget!";
        } else {
            return "Feil brukernavn eller passord";
        }
    }
}
