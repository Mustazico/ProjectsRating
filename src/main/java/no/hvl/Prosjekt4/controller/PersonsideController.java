package no.hvl.Prosjekt4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.LoginUtil;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.RatingRepo;
import no.hvl.Prosjekt4.entity.Ratings;

@Controller
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private ProsjektRepo prosjektRepo;

    @Autowired
    private ApiCallService api;

    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping("/personsside")
    public String visPersonside(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            String id = (String) inputFlashMap.get("id");
            System.out.println(id);
            model.addAttribute("id", id);
            int newId = Integer.parseInt(id);
            model.addAttribute(brukerRepo.findById(newId));
            List<String> lenker = prosjektRepo.findUsersProsjektlink(id);
            model.addAttribute("brukernavn", brukerRepo.getBrukernavn(newId));
            System.out.println(brukerRepo.getBrukernavn(newId));
            model.addAttribute("profilbilde", brukerRepo.getProfilbilde(newId));
            model.addAttribute("lenker", lenker);
            List<String> users = prosjektRepo.findUsersProsjektid(id);
            List<String> test = new ArrayList<>();
            List<String> githubbrukernavn = new ArrayList<>();
            List<String> repo = new ArrayList<>();
            for (String s : users) {

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
            for (Prosjektliste p : prosjekter) {
                prosjektidListe.add(p.getProsjektid());
            }
            model.addAttribute("prosjektId", prosjektidListe);
        } else {
            return "landingpage";
        }
        return "personside";
    }

    @PostMapping("/stemmer")
    public String stemPaProsjekt(String prosjektid, HttpServletRequest request,
            @RequestParam("rate") String verdi,
            RedirectAttributes ra,
            HttpSession session, Model model) {

        System.out.println("Stemmer på prosjekt: ");
        System.out.println("Med rating: " + verdi);
        System.out.println("Postmapping funker!");

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("errorMessage", "Logg inn før du kan stemme");
            return "redirect:" + "logginn";
        }

        String brukernavn = (String) session.getAttribute("brukernavn");
        System.out.println(brukernavn);
        Ratings stemme = new Ratings(prosjektid, brukernavn, verdi);

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            String id = (String) inputFlashMap.get("id");
            List<Prosjektliste> prosjekter = prosjektRepo.findProsjektByBrukerid(id);
            List<String> prosjektList = new ArrayList<>();
            for (Prosjektliste p : prosjekter) {
                prosjektList.add(p.getProsjektid());
                System.out.println(id);

            }

        }
        stemme.setProsjektid("7");
        stemme.setBrukerid(brukernavn);
        stemme.setVerdi(verdi);
        System.out.println("Homo");
        // ra.addFlashAttribute("Message", "Takk for din stemme");
        ratingRepo.save(stemme);
        return "redirect:personsside";

    }

    @PostMapping("/slettpost")
    @Transactional
    public String slettProsjekt(@RequestParam("id") String slett) {
        prosjektRepo.deleteByProsjektid(slett);
        return "redirect:" + "personsside";
    }

    @PostMapping("/leggtilpost")
    public String leggTilProsjekt(@RequestParam("brukerid") String brukerid,
            @RequestParam("tittel") String tittel,
            @RequestParam("prosjektlink") String prosjektlink) {
        Prosjektliste p = new Prosjektliste(brukerid, tittel, prosjektlink);
        prosjektRepo.save(p);

        return "redirect:" + "personsside";
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
