package no.hvl.Prosjekt4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.ProsjektService;
import no.hvl.Prosjekt4.util.RatingRepo;

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

	private RatingRepo ratingRepo;

	@GetMapping
	public String visLandingpage(Model model, HttpSession session, HttpServletRequest request) throws Exception {

		
		//	String id = (String) inputFlashMap.get("id");
			String id = "1";
			model.addAttribute("id", id);
			System.out.println("thisIsId:" + id);
			int newId = Integer.parseInt(id);
			model.addAttribute(brukerRepo.findById(newId));
			List<String> lenker = prosjektRepo.findUsersProsjektlink(id);
		//	model.addAttribute("brukernavn", brukerRepo.getBrukernavn(newId));
			System.out.println(brukerRepo.getBrukernavn(newId));
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
					System.out.println(githubbrukernavn);
					System.out.println(repo);
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
			System.out.println(brukerService.getBrukernavnByProsjektId("8"));

			for (Prosjektliste p : prosjekt) {
				prosjektidListe.add(prosjektRepo.findProsjektid(p));
		//		 individuelle prosjekt - finn en måte å hente ut brukernavnet til prosjektet
				System.out.println(prosjektidListe);
				brukernavnListe.add(brukerService.getBrukernavnByProsjektId(p.getProsjektid()));
			
			}
	//		for (String b : prosjektidListe) {
			//			int c = Integer.parseInt(b) ;
			//	brukernavnListe.add(brukerRepo.getBrukernavn(c));
			//	System.out.println(brukernavnListe);
			//}
			
			model.addAttribute("prosjektId", prosjektidListe);
			model.addAttribute("brukernavn", brukernavnListe);
			
			
		

		return "landingpage";
	}
	
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
