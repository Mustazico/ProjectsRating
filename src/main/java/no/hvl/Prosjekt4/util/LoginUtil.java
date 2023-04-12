package no.hvl.Prosjekt4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import no.hvl.Prosjekt4.entity.Brukere;

/**
 * LoginUtil classen inneholder metoder for å logge inn og ut brukere.
 */
public class LoginUtil {

	/**
	 * Ugjyldiggjør gjeldende økt for å logge ut brukeren
	 * @param session er HttpSessions objektet som inneholder informasjon om økten.
	 * 
	 */
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}
	/**
	 * Logger inn brukeren ved å sette brukernavn, passord og rolle i session.
	 * @param request er HttpRequests objektet som inneholder informasjon om økten.
	 * @param brukernavn er brukernavnet til brukeren som skal logges inn.
	 * @param passord er passordet til brukeren som skal logges inn.
	 * @param rolle er rollen til brukeren som skal logges inn.
	 */

	public static void loggInnBruker(HttpServletRequest request, String brukernavn, String passord, String rolle) {
		// Logger ut bruker før den logger inn igjen slik at vi ikke får problemer med
		// autentisering
		HttpSession http = request.getSession();
		http.setAttribute("passord", passord);
		http.setAttribute("brukernavn", brukernavn);
		http.setAttribute("rolle", rolle);
		// Setter tiden man maks kan være inaktiv i sekunder.
		http.setMaxInactiveInterval(120);

	}

	/**
	 * Metoden sjekker om brukeren er innlogget.
	 * @param session er HttpSessions objektet som inneholder informasjon om økten.
	 * @return true hvis brukeren er innlogget, false hvis ikke.
	 */
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("passord") != null;
	}
	
	/**
	 * Metoden sjekker om gitt passord matcher passordet til brukeren som er innlogget med gitt tlfnummer.
	 * @param brukerrepo er JPARepo objektet som inneholder informasjon om brukere.
	 * @param mobilnr er tlfnummeret til brukeren som skal sjekkes.
	 * @param passord er passordet til brukeren som skal sjekkes.
	 * @return true hvis passordet er korrekt, false hvis ikke.
	 */
	public static boolean rettPassord(JPARepo brukerrepo, String mobilnr, String passord) {
		boolean retur = true;
		Brukere bruker = brukerrepo.findByMobil(mobilnr);
		
		String aktPassHash = PassordUtil.hashMedSalt(passord, bruker.getSalt());
		if(!aktPassHash.equals(bruker.getPassord())) {
			retur = false;
		}
		
		return retur;
	}
}