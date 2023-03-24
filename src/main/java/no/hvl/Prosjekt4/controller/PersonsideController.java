package no.hvl.Prosjekt4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.ProsjektRepo;

@Controller
@RequestMapping("personsside")
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private ProsjektRepo prosjektRepo;
    
    @Autowired
    private ApiCallService api;

    @GetMapping
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
            model.addAttribute("bio", brukerRepo.getBrukerintro(newId));
            try {
				model.addAttribute("api", api.kallReadMeApi(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        else {
            return "landingpage";
        }
		return "personside";
	}
    
}
