package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.util.InputUtil;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.PassordUtil;

/**
 * RegistreringsController klassen håndterer forespørsler knyttet til registrering av brukere.
 */
@Controller
@RequestMapping(value="/registrering")
public class RegistreringsController {
	
	@Autowired
	JPARepo brukerrepo;
    /**
     * viser registreringssiden.
     * @return Navnet på registreringssiden.
     */

    @GetMapping
    public String visRegistrering() {
        return "registrering";
    }

    /**
     * Registrer en ny bruker.
     * @param brukernavn er brukernavnet til nye brukeren.
     * @param mail er eposten til  nye brukeren.
     * @param tlf er telefonnummeret til nye brukeren.
     * @param passord er passordet til nye brukeren.
     * @param passord2 er passordbekreftelsen til nye brukeren.
     * @param ra er en redirectattributt som sender med en melding til landingpage.
     * @return Redirecter til landingpage.
     */
    @PostMapping
    public String registrerBruker(
    		@RequestParam(name = "username") String brukernavn, 
            @RequestParam(name = "mail") String mail, 
            @RequestParam(name = "tlf") String tlf, 
            @RequestParam(name = "password") String passord, 
            @RequestParam(name = "password2") String passord2, 
            RedirectAttributes ra) {
    	
    	
        String salt = PassordUtil.genererTilfeldigSalt();
        String saltetpass = PassordUtil.hashMedSalt(passord, salt);
       
        Brukere bruker = new Brukere(brukernavn, mail, tlf, saltetpass, salt, "Bruker" );
        
        if(!InputUtil.registreringsValidator(brukerrepo, bruker, passord2)) {
        	ra.addFlashAttribute("msg", "Feil input, prøv på nytt.");
        	return "redirect:" + "registrering";
        }
        
        
        brukerrepo.save(bruker);

        return "redirect:" + "landingpage";
    }
}
