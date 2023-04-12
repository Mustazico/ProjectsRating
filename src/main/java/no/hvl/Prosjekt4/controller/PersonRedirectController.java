package no.hvl.Prosjekt4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.*;
import org.springframework.web.servlet.mvc.support.*;

import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import org.springframework.ui.Model;
/**
 * Denne klassen representerer en kontroller for håndtering av forespørsler knyttet til personer og omdirigerer dem til personsiden.
 */

@Controller
public class PersonRedirectController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private BrukerService brukerService;
    /**
     * Denne metoden håndterer forespørsler om å omdirigere brukeren til personsiden. Den tar inn en request, en redirectattribute og en model. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param request er en request som inneholder informasjon om forespørselen.
     * @param ra er en redirectattribute som inneholder informasjon som skal vises på siden.
     * @param model er en model som inneholder informasjon som skal vises på siden.
     * @return String som er navnet på html-siden som skal vises.
     */
    
    @GetMapping("personsside/petter")
    public String getPetter(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "5");
        return "redirect:/personsside";
    }

    @GetMapping("test")
    public String testing(HttpServletRequest request, RedirectAttributes ra, Model model){
        ra.addFlashAttribute("id", "8");
        return "test";

    }

    @GetMapping("personsside/fredrik")
    public String getFredrik(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "8");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/kristoffer")
    public String getKristoffer(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "3");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/torben")
    public String getTorben(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "2");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/eirik")
    public String getEirik(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "1");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/eirikl")
    public String getEirikl(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "6");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/trym")
    public String getTrym(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "7");
        return "redirect:/personsside";
    }
    @GetMapping("personsside/oskar")
    public String getOskar(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "4");
        return "redirect:/personsside";
    }
}
