package no.hvl.Prosjekt4.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PassordUtil {

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

	public static boolean validerMedSalt(String passord, String salt, String passordhash) {
		if (passord == null || salt == null || passordhash == null) {
			throw new IllegalArgumentException();
		}
		return passordhash.equals(hashMedSalt(passord, salt));
	}
}
