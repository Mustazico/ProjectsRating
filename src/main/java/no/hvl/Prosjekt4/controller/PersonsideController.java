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
    @Transactional
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
                System.out.println(s);
                try {
                    // Henter readme fra github og pusher til database.
                    Prosjektliste p = prosjektRepo.findByProsjektid(s);
                    test.add(p.getReadme());

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
    public String stemPaProsjekt(@RequestParam("id") String prosjektid, HttpServletRequest request,
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
        Ratings gjeldendeRating = ratingRepo.findByProsjektidAndBrukerid(prosjektid, brukernavn);
        if (gjeldendeRating != null) {
            // Handle the case where the current user has already rated this project
            // For example, you could return an error message or take some other action
            ra.addFlashAttribute("errorMessage", "Du har allerede gitt en vurdering for dette prosjektet");
            return "redirect:" + "personsside";
        } else {
            // Create a new rating object and save it to the database
            Ratings nyRating = new Ratings(prosjektid, brukernavn, verdi);
            nyRating.setProsjektid(prosjektid);
            nyRating.setBrukerid(brukernavn);
            nyRating.setVerdi(verdi);
            ratingRepo.save(nyRating);
            return "redirect:personsside";
        }
    }
    // ra.addFlashAttribute("Message", "Takk for din stemme");

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

    @PostMapping("/synkroniser")
    public String synkroniserReadme(HttpServletRequest request, Model model) {
        System.out.println("jeg kjører ikke fordi input er null");
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
                System.out.println("JEg er fra try statementen:" + p);

            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("api", test);
        }
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
