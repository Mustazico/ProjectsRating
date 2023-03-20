package no.hvl.Prosjekt4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import no.hvl.Prosjekt4.entity.Brukere;

@Controller
@RequestMapping("/registrering")
public class RegistreringsController {

    @GetMapping
    public String visRegistrering() {
        return "registrering";
    }

    @PostMapping
    public String registrerBruker(@RequestParam(name = "username") String brukernavn,
            @RequestParam(name = "password") String passord, RedirectAttributes ra) {
        if (!brukernavn.equals("admin") && !passord.equals("passord")) {
            ra.addFlashAttribute("msg", "Bruker er registrert");
            return "redirect:" + "registrering";
        }
        Brukere bruker = new Brukere();
        bruker.setBrukernavn(brukernavn);
        bruker.setPassord(passord);

        return "redirect:" + "landingpage";
    }

}
