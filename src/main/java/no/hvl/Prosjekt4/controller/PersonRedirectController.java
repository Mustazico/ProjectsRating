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

@Controller
public class PersonRedirectController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private BrukerService brukerService;
    
    @GetMapping("personsside/petter")
    public String getPetter(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "5");
        return "redirect:/personsside";
    }

    @GetMapping("personsside/fredrik")
    public String getFredrik(HttpServletRequest request, RedirectAttributes ra, Model model) {
        // Setter inn et object kalt person med verdi petter
        ra.addFlashAttribute("id", "8");
        return "redirect:/personsside";
    }
}
