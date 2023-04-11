package no.hvl.Prosjekt4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.ProsjektService;
import no.hvl.Prosjekt4.util.RatingRepo;
import no.hvl.Prosjekt4.util.RatingsUtil;
/**
 * Dette er controlleren for landingssiden til brukeren. Den er ansvarlig for å håndtere forespørsler knyttet til landingssiden.
 * Landingssiden er den siden brukeren kommer til når han logger inn. Den inneholder informasjon om brukeren og prosjektene han er med i.
 */
@Controller
@RequestMapping(value = "/landingpage", produces = "text/html;charset=UTF-8")
public class LandingsideController {

	@Autowired
	private JPARepo brukerRepo;

	@Autowired
	private ApiCallService api;
	@Autowired
	private BrukerService brukerService;

	@Autowired
	private ProsjektRepo pr;

	@Autowired
	private ProsjektService ps;

	@Autowired
	private ProsjektRepo prosjektRepo;

	@Autowired
	private RatingRepo ratingRepo;
/**
 * Denne metoden håndterer forespørsler om landingssiden. Den tar inn en model, en session og en request. Den returnerer en String som er navnet på html-siden som skal vises.
 * @param model er en model som inneholder informasjon som skal vises på siden.
 * @param session er en session som inneholder informasjon om brukeren som er logget inn.
 * @param request er en request som inneholder informasjon om forespørselen.
 * @return String som er navnet på html-siden som skal vises.
 * @throws Exception kan kaste en exception.
*/
	public String visLandingpage(Model model, HttpSession session, HttpServletRequest request) throws Exception {

		
		//	String id = (String) inputFlashMap.get("id");
			String id = "1";
			model.addAttribute("id", id);
			int newId = Integer.parseInt(id);
			model.addAttribute(brukerRepo.findById(newId));
			List<String> lenker = prosjektRepo.findUsersProsjektlink(id);
		//	model.addAttribute("brukernavn", brukerRepo.getBrukernavn(newId));
			model.addAttribute("profilbilde", brukerRepo.getProfilbilde(newId));
			model.addAttribute("lenker", lenker);
			List<String> prosjektIdListe = prosjektRepo.findUsersProsjektid(id);
			List<String> test = new ArrayList<>();
			List<String> githubbrukernavn = new ArrayList<>();
			List<String> repo = new ArrayList<>();
			for (String s : prosjektIdListe) {

				try {
					test.add(api.kallReadMeApi(s));
					githubbrukernavn.add(splitBrukernavn(s));
					repo.add(splitRepo(s));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			

			model.addAttribute("githubBrukernavn", githubbrukernavn);
			model.addAttribute("githubRepo", repo);
			model.addAttribute("api", test);
			model.addAttribute("bio", brukerRepo.getBrukerintro(newId));

			List<Prosjektliste> prosjekter = prosjektRepo.findProsjektByBrukerid(id);
			List<String> prosjektidListe = new ArrayList<>();
			List<String> brukernavnListe = new ArrayList<>();
			List<Prosjektliste> prosjekt = prosjektRepo.findAll();
		
			//Prosjektliste prosjeket = new Prosjektliste();

			for (Prosjektliste p : prosjekt) {
				prosjektidListe.add(prosjektRepo.findProsjektid(p));
		//		 individuelle prosjekt - finn en måte å hente ut brukernavnet til prosjektet
				brukernavnListe.add(brukerService.getBrukernavnByProsjektId(p.getProsjektid()));
			
			}
			
			model.addAttribute("prosjektId", prosjektidListe);
			model.addAttribute("brukernavn", brukernavnListe);
			
			
		

		return "landingpage";
	}
	/**
	 * Denne metoden brukes til å splitte GitHub brukernavn fra prosjekt linken.
	 * @param id er prosjekt id'en.
	 * @return String som er GitHub brukernavnet.
	 * @throws Exception kan kaste en exception.
	 */
	
	   public String splitBrukernavn(String id) {
	    	String lenke = prosjektRepo.findProsjektidProsjektlink(id);
			String[] deler = lenke.split("/");
			String brukernavn = deler[3];
	    	return brukernavn;
	    }
	    
	    public String splitRepo(String id) {
	    	String lenke = prosjektRepo.findProsjektidProsjektlink(id);
			String[] deler = lenke.split("/");
			String repo = deler[4];
	    	return repo;
	    }
}
