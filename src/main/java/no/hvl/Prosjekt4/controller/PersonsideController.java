package no.hvl.Prosjekt4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.entity.Ratings;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.ProsjektService;
import no.hvl.Prosjekt4.util.RatingRepo;
import no.hvl.Prosjekt4.util.RatingsUtil;

/**
 * Dette er controlleren for personssiden til brukeren. Den er ansvarlig for å håndtere forespørsler knyttet til personssiden.
 * Personssiden er den siden brukeren kommer til når han trykker på et brukernavn. Den inneholder informasjon om brukeren og prosjektene han er med i.
 * Denne siden er også ansvarlig for å håndtere rating av prosjekter.
 */

@Controller
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private ProsjektRepo prosjektRepo;


    @Autowired
    private RatingRepo ratingRepo;
    
    @Autowired
    private ProsjektService prosjektService;


    @GetMapping("/personsside")
    @Transactional
    public String visPersonside(HttpServletRequest request, Model model, HttpSession session) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            String id = "";
            int newId = 0;

            if (inputFlashMap.get("id") instanceof String){

                id = (String) inputFlashMap.get("id");
                model.addAttribute("id", id);
                newId = Integer.parseInt(id);
            }
            else {
                newId = (int) inputFlashMap.get("id");
                id = String.valueOf(newId);
                model.addAttribute("id", id);
            }
            model.addAttribute(brukerRepo.findById(newId));
            
            RatingsUtil ratingsUtil = new RatingsUtil();
            List<String> lenker = ratingsUtil.sortedByRatings(prosjektRepo, id)
            		.stream()
            		.map(x->x.getProsjektlink())
            		.collect(Collectors.toList());
            
           
            model.addAttribute("brukernavn", brukerRepo.getBrukernavn(newId));
            model.addAttribute("profilbilde", brukerRepo.getProfilbilde(newId));
            model.addAttribute("lenker", lenker);

            List<String> prosjektIdTilBruker = ratingsUtil.sortedByRatings(prosjektRepo, id)
            		.stream()
            		.map(x->x.getProsjektid())
            		.collect(Collectors.toList());
            List<String> test = new ArrayList<>();
            List<String> githubbrukernavn = new ArrayList<>();
            List<String> repo = new ArrayList<>();
            List<String> gjennomsnittrating = new ArrayList<>();

            for (String s : prosjektIdTilBruker) {
                try {
                    // Henter readme fra github og pusher til database.
                    Prosjektliste p = prosjektRepo.findByProsjektid(s);
                    test.add(p.getReadme());
                    gjennomsnittrating.add(p.getGjennomsnittrating());

                    githubbrukernavn.add(prosjektService.splitBrukernavn(s));
                    repo.add(prosjektService.finnTittel(s));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            model.addAttribute("githubBrukernavn", githubbrukernavn);
            model.addAttribute("githubRepo", repo);
            model.addAttribute("api", test);
            model.addAttribute("gjsnittrating", gjennomsnittrating);
            model.addAttribute("bio", brukerRepo.getBrukerintro(newId));

            
            List<Prosjektliste> prosjekter = ratingsUtil.sortedByRatings(prosjektRepo, id);
            List<String> prosjektidListe = new ArrayList<>();
            List<String> stjernerGitt = new ArrayList<>();
            String brukernavn = (String) session.getAttribute("brukernavn");
            for (Prosjektliste p : prosjekter) {
                prosjektidListe.add(p.getProsjektid());
            }
            
            
            model.addAttribute("prosjektId", prosjektidListe);
            model.addAttribute("sjernerGitt", stjernerGitt);
        } else {
            return "redirect:landingpage";
        }
        return "personside";
    }

    /**
     * Denne metoden håndterer forespørsler om å stemme på et prosjekt. Den tar inn en prosjektid, en request, en verdi, en ra, en session og en model. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param prosjektid er en String som inneholder prosjektid-en til prosjektet som skal stemmes på.
     * @param request er en request som inneholder informasjon om forespørselen.
     * @param verdi er en String som inneholder verdien som skal stemmes på.
     * @param ra er en ra som inneholder informasjon som skal vises på siden.
     * @param session er en session som inneholder informasjon om brukeren som er logget inn.
     * @param model er en model som inneholder informasjon som skal vises på siden.
     * @return String som er navnet på html-siden som skal vises.
     */
    @PostMapping("/stemmer")
    @Transactional
    public String stemPaProsjekt(@RequestParam("id") String prosjektid, HttpServletRequest request,
            @RequestParam("rate") String verdi, @RequestParam("person") String person,
            RedirectAttributes ra,
            HttpSession session, Model model) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("errorMessage", "Logg inn før du kan stemme");
            ra.addFlashAttribute("person", person);
            return "redirect:" + "logginn";
        }

        RatingsUtil ratingsUtil = new RatingsUtil();

        String brukernavn = (String) session.getAttribute("brukernavn");
        Ratings gjeldende = ratingRepo.findByProsjektidAndBrukerid(prosjektid, brukernavn);
        Prosjektliste prosjekt = prosjektRepo.findByProsjektid(prosjektid);
        
        if (gjeldende != null) {
            gjeldende.setVerdi(verdi);
            ratingRepo.save(gjeldende);
            prosjekt.setGjennomsnittrating(ratingsUtil.regnUtSnitt(ratingRepo, prosjektid));
            ra.addFlashAttribute("id", person);
            return "redirect:/personsside";
        } else {
            Ratings nyRating = new Ratings(prosjektid, brukernavn, verdi);
            nyRating.setProsjektid(prosjektid);
            nyRating.setBrukerid(brukernavn);
            nyRating.setVerdi(verdi);
            ratingRepo.save(nyRating);
            prosjekt.incrementStemmer();
            prosjekt.setGjennomsnittrating(ratingsUtil.regnUtSnitt(ratingRepo, prosjektid));
            ra.addFlashAttribute("id", person);
            return "redirect:/personsside";
        }

    }

    /**
     * Denne metoden håndterer forespørsler om å slette et prosjekt. Den tar inn en prosjektid, en request, en session og en model. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param slett er en String som inneholder prosjektid-en til prosjektet som skal slettes.
     * @param request er en request som inneholder informasjon om forespørselen.
     * @param session er en session som inneholder informasjon om brukeren som er logget inn.
     * @param model er en model som inneholder informasjon som skal vises på siden.
     * @return String som er navnet på html-siden som skal vises.
     */
    @PostMapping("/slettpost")
    @Transactional
    public String slettProsjekt(@RequestParam("id") String slett) {
        prosjektRepo.deleteByProsjektid(slett);
        return "redirect:" + "personsside";
    }

    /**
     * Denne metoden håndterer forespørsler om å legge til et prosjekt. Den tar inn en brukerid, en tittel, en prosjektlink, en request, en session og en model. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param brukerid er en String som inneholder brukerid-en til brukeren som skal legge til prosjektet.
     * @param tittel er en String som inneholder tittelen til prosjektet som skal legges til.
     * @param prosjektlink er en String som inneholder prosjektlink-en til prosjektet som skal legges til.
     * @param request er en request som inneholder informasjon om forespørselen.
     * @param session er en session som inneholder informasjon om brukeren som er logget inn.
     * @param model er en model som inneholder informasjon som skal vises på siden.
     * @return String som er navnet på html-siden som skal vises.
     */
    @PostMapping("/leggtilpost")
    public String leggTilProsjekt(@RequestParam("brukerid") String brukerid,
            @RequestParam("tittel") String tittel,
            @RequestParam("prosjektlink") String prosjektlink, Model model) {
    	
    	int nyid = Integer.parseInt(brukerid);
    	
    	if(nyid > 99) {
    		model.addAttribute("msg", "Hallaien du!");
    		return "redirect:" + "personsside";
    	}
    	
        Prosjektliste p = new Prosjektliste(brukerid, tittel, prosjektlink);
        prosjektRepo.save(p);

        return "redirect:" + "personsside";
    }

    /**
     * Denne metoden håndterer forespørsler om å synkronisere readme-filen til et prosjekt. Den tar inn en request, en session og en model. Den returnerer en String som er navnet på html-siden som skal vises.
     * @param request er en request som inneholder informasjon om forespørselen.
     * @param session er en session som inneholder informasjon om brukeren som er logget inn.
     * @param model er en model som inneholder informasjon som skal vises på siden.
     * @return String som er navnet på html-siden som skal vises.
     */
    @PostMapping("/synkroniser")
    public String synkroniserReadme(HttpServletRequest request, Model model) {
        List<String> test = new ArrayList<>();
        List<Prosjektliste> prosjekter = prosjektRepo.findAll();
        List<String> prosjektIdListe = new ArrayList<>();
        for (Prosjektliste p : prosjekter) {
            String prosjektId = p.getProsjektid();
            prosjektIdListe.add(prosjektId);
        }

        for (String s : prosjektIdListe) {
            try {
                // Henter readme fra github og pusher til database.
                String readme = api.kallReadMeApi(s);
                Prosjektliste p = prosjektRepo.findByProsjektid(s);
                p.setReadme(readme);
                prosjektRepo.save(p);
                test.add(p.getReadme());

            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("api", test);
        }
        return "redirect:" + "personsside";
    }





}
