package no.hvl.Obligatorisk4;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.PassordUtil;
import no.hvl.Prosjekt4.entity.Brukere;

@ExtendWith(MockitoExtension.class)
public class Tests {

	@Mock
	private JPARepo brukerRepo;

	@InjectMocks
	BrukerService bs;

	@Test
	public void passordValideringTest() {
		String passord = "passord";
		String salt = "1111111111111111";

		String hash = PassordUtil.hashMedSalt(passord, salt);
		assertTrue(PassordUtil.validerMedSalt("passord", salt, hash));
	}

	@Test
	public void generertilfeldigSaltTest() {
		String salt = PassordUtil.genererTilfeldigSalt();
		assertTrue(salt.length() == 32);
	}

	@Test
	public void erBrukerInnlogget() {
		String adminMobil = "95750537";
		String ikkeAdmingMobil = "12345678";

		Brukere adminbruker = new Brukere();
		adminbruker.setMobil(adminMobil);
		adminbruker.setRolle("Admin");

		Brukere ikkeAdminbruker = new Brukere();
		ikkeAdminbruker.setMobil(ikkeAdmingMobil);
		ikkeAdminbruker.setRolle("Standard");

		Mockito.when(brukerRepo.findByMobil(adminMobil)).thenReturn(adminbruker);
		Mockito.when(brukerRepo.findByMobil(ikkeAdmingMobil)).thenReturn(ikkeAdminbruker);

		boolean erAdmin = bs.erBrukerAdmin(adminMobil);
		boolean erIkkeAdmin = bs.erBrukerAdmin(ikkeAdmingMobil);
		assertTrue(erAdmin);
		assertTrue(!erIkkeAdmin);

	}

}
