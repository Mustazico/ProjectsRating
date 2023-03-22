package no.hvl.Prosjekt4.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import no.hvl.Prosjekt4.util.JPARepo;

@Controller
@RequestMapping("personsside")
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @GetMapping()
	public String visPersonside(HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            String id = (String) inputFlashMap.get("person");
        }
		return "personsside";
	}
    
}
