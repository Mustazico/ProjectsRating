package no.hvl.Prosjekt4.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;

/**
 * Dette er controlleren for login-siden til brukeren. Den er ansvarlig for å håndtere forespørsler knyttet til login-siden.
 * Login-siden er den siden brukeren kommer til når h*n logger inn. Den inneholder informasjon om brukeren og prosjektene h*n er med i.
 */

@Controller
@RequestMapping("/logginn")
public class LoginController {
	/**
     *  JPARepo er en klasse som inneholder metoder som kan brukes til å hente ut informasjon fra databasen.
     */

	@Autowired
	JPARepo brukerrepo;
    /**
     * GET metode som håndterer forespørsler om login-siden. Den tar inn en model, en session og en request. Den returnerer en String som er navnet på html-siden som skal vises.
     * @return login siden som skal vises.
     */

    @GetMapping
    public String visLogginn() {
        return "logginn";
    }
    /**
     * POST metode som håndterer forespørsler om login-siden. Den tar inn en model, en session og en request. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param request HTTP servlet request object
     * @param brukernavn brukernavn som er skrevet inn i inputfeltet
     * @param passord passord som er skrevet inn i inputfeltet
     * @param ra RedirectAttributes som brukes til å sende meldinger til brukeren
     * @return landingpage siden som skal vises.
     */

    @PostMapping
    public String loggInn(
    		HttpServletRequest request, 
    		@RequestParam(name = "username") String brukernavn,
            @RequestParam(name = "password") String passord,
            @RequestParam(name = "personSide") String personSide,
            RedirectAttributes ra) {
    	
        if (LoginUtil.rettPassord(brukerrepo, brukernavn, passord)) {

            if(brukerrepo.erBrukerAdmin(brukernavn).equals("Admin")) {
            	ra.addFlashAttribute("msg", "Du er logget inn som admin");
            	LoginUtil.loggInnBruker(request, brukernavn, passord, "Admin");
                ra.addFlashAttribute("id", personSide);
            	return "redirect:/personsside";
            } else {
            ra.addFlashAttribute("msg", "Du er logget inn som standardbruker");
            LoginUtil.loggInnBruker(request, brukernavn, passord, "Standard");
            

            return "redirect:/personsside";
            }
        }
        ra.addFlashAttribute("msg", "Feil brukernavn eller passord");
        return "redirect:" + "logginn";
    }
}
