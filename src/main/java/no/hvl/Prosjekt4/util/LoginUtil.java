package no.hvl.Prosjekt4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import no.hvl.Prosjekt4.entity.Brukere;

public class LoginUtil {

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, String brukernavn, String passord) {
		// Logger ut bruker før den logger inn igjen slik at vi ikke får problemer med
		// autentisering
		HttpSession http = request.getSession();
		http.setAttribute("passord", passord);
		http.setAttribute("brukernavn", brukernavn);
		// Setter tiden man maks kan være inaktiv i sekunder.
		http.setMaxInactiveInterval(120);

	}

	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("passord") != null;
	}
	
	public static boolean rettPassord(JPARepo brukerrepo, String brukernavn, String passord) {
		boolean retur = true;
		Brukere bruker = brukerrepo.findByBrukernavn(brukernavn);
		
		String aktPassHash = PassordUtil.hashMedSalt(passord, bruker.getSalt());
		if(!aktPassHash.equals(bruker.getPassord())) {
			retur = false;
		}
		
		return retur;
	}
}