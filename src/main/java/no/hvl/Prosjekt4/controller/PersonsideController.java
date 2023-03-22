package no.hvl.Prosjekt4.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.util.JPARepo;

@RestController
@RequestMapping("/personside")
public class PersonsideController {

    @Autowired
    private JPARepo brukerRepo;

    @GetMapping
    public ResponseEntity<Brukere> visPersonside(@PathVariable String brukernavn) {
        Brukere bruker = brukerRepo.findByBrukernavn(brukernavn);
        if (bruker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bruker);
    }

=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personside")

public class PersonsideController {
    @GetMapping
	public String visPersonside() {
		return "personside";
	}
    
>>>>>>> master
}
