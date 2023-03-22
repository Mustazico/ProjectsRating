package no.hvl.Prosjekt4.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

@Controller
public class PersonRedirectController {
    
    @GetMapping("personsside/petter")
    public String getPetter(HttpServletRequest request, RedirectAttributes ra) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("person", "petter");
        model.addAttribute("bruker", brukerRepo.findAll());
        return "redirect:personsside";
    }
}
