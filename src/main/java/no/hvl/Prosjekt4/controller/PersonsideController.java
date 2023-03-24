package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.ui.Model;
import javax.servlet.http.*;
import no.hvl.Prosjekt4.util.LoginUtil;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.entity.Prosjektliste;
import no.hvl.Prosjekt4.util.JPARepo;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("personsside")
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @Autowired
    private ProsjektRepo prosjektRepo;

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
        }
        else {
            return "landingpage";
        }
		return "personside";
	}
    
}
