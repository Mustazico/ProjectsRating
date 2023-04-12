package no.hvl.Prosjekt4.util;

import java.util.regex.Pattern;
import no.hvl.Prosjekt4.entity.Brukere;

/**
 * InputUtil classe for validering av brukerinput i registreringsskjemaet
 */
public class InputUtil {
	
	/**
	 * Validerer brukerinput i registreringsskjemaet
	 * @param brukerrepo er repositoriet for å nå til bruker data
	 * @param bruker er brukeren som skal registreres
	 * @param passord2 er passordet som skal sjekkes mot passordet i bruker
	 * @return true hvis alle input er gyldige, false hvis ikke
	 */
	
	public static boolean registreringsValidator(JPARepo brukerrepo, Brukere bruker, String passord2) {
		return(
		brukernavnValidator(brukerrepo, bruker) &&
		mailValidator(brukerrepo, bruker) &&
		tlfValidator(brukerrepo, bruker) &&
		passordValidator(brukerrepo, bruker, passord2));
	}
	
	/**
	 * Validerer formatet og unikheten til brukernavnet
	 * @param brukerrepo er repositoriet for å nå til bruker data
	 * @param bruker er bruker objektet som skal sjekkes
	 * @return true hvis brukernavnet er gyldig og unikt, false hvis ikke 
	 * Mye likt med de andre validatorene nedenfor
	 */
	public static boolean brukernavnValidator(JPARepo brukerrepo, Brukere bruker) {
		String brukernavn = bruker.getBrukernavn();
		boolean retur = true;
		
		String USERNAME_REGEX = "^[a-zA-Z ]{3,40}$";
		Pattern pattern = Pattern.compile(USERNAME_REGEX);
		if(!pattern.matcher(brukernavn).matches()) {
			retur = false;
		}
		
		
		if(brukerrepo.existsByBrukernavn(brukernavn)) {
			retur = false;
		}
		
		return retur;
	}


	
	public static boolean mailValidator(JPARepo brukerrepo, Brukere bruker) {
		String mail = bruker.getEpost();
		boolean retur = true;
		
		String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
	            "[a-zA-Z0-9_+&*-]+)*@" +
	            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		
		if(!pattern.matcher(mail).matches()) {
			retur = false;
		}
		
		if(brukerrepo.existsByEpost(mail)) {
			retur = false;
		}
		
		return retur;
	}
	
	public static boolean tlfValidator(JPARepo brukerrepo, Brukere bruker) {
		String tlf = bruker.getMobil();
		boolean retur = true;
		String pattern = "^\\d{8}$";
		
		if(!tlf.matches(pattern)) {
			retur = false;
		}
		
		if(brukerrepo.existsByMobil(tlf)) {
			retur = false;
		}
		
		return retur;
	}
	
	public static boolean passordValidator(JPARepo brukerrepo, Brukere bruker, String passord2) {
		return (passord2.length() > 4) && PassordUtil.validerMedSalt(passord2, bruker.getSalt(), bruker.getPassord());
	}
}
