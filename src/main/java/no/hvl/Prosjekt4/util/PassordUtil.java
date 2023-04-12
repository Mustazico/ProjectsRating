package no.hvl.Prosjekt4.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * PassordUtil classen inneholder metoder for å generere tilfeldig salt og hash
 * passord med salt.
 */
public class PassordUtil {
/**
 * Metoden genererTilfeldigSalt genererer et tilfeldig salt og returner den som en hexadesimal string.
 * @return en hexadesimal string som er saltet.
 */
	public static String genererTilfeldigSalt() {
		SecureRandom sr;
		byte[] salt = new byte[16];

		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(salt);
	}
	/**
	 * Metoden hashMedSalt tar inn et passord og et salt og returnerer en hash av passordet med saltet.
	 * @param passord er passordet som skal hashes.
	 * @param salt er saltet som skal brukes til å hash passordet.
	 * @return en hexadesimal string som er hashen av passordet med saltet.
	 * @throws IllegalArgumentException hvis passord eller salt er null.
	 */

	public static String hashMedSalt(String passord, String salt) {
		if (passord == null || salt == null) {
			throw new IllegalArgumentException();
		}

		char[] passchar = passord.toCharArray();
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);

		byte[] keyhash = null;

		try {
			PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			keyhash = skf.generateSecret(pks).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return DatatypeConverter.printHexBinary(keyhash);
	}

	/**
	 * Validerer det angitte passordet mot den angitte hashed-verdien og salt
	 * ved å hashe passordet med saltet og sammenligne det med den angitte
	 * hashed-verdien.
	 * @param passord passordet som skal valideres
	 * @param salt saltet som skal brukes til å hash passordet
	 * @param passordhash den angitte hashed-verdien
	 * @return true hvis passordet er riktig, false hvis passordet er feil
	 * @throws IllegalArgumentException hvis passord, salt eller passordhash er null
	 */

	public static boolean validerMedSalt(String passord, String salt, String passordhash) {
		if (passord == null || salt == null || passordhash == null) {
			throw new IllegalArgumentException();
		}
		return passordhash.equals(hashMedSalt(passord, salt));
	}
}
