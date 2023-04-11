package no.hvl.Obligatorisk4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.Prosjekt4.entity.Brukere;
import no.hvl.Prosjekt4.entity.Ratings;
import no.hvl.Prosjekt4.util.ApiCallService;
import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.PassordUtil;
import no.hvl.Prosjekt4.util.ProsjektRepo;
import no.hvl.Prosjekt4.util.RatingRepo;
import no.hvl.Prosjekt4.util.RatingsUtil;

@ExtendWith(MockitoExtension.class)
public class Tests {

	@Mock
	private JPARepo brukerRepo;

	@InjectMocks
	BrukerService bs;

	@Mock
	ProsjektRepo prepo;

	@InjectMocks
	ApiCallService apiService;

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

	@Test
	public void testAPIKall() throws Exception {
		Mockito.when(prepo.findProsjektidProsjektlink(Mockito.anyString()))
				.thenReturn("https://github.com/h594754/DAT108_Oblig4/");
		String result = apiService.kallReadMeApi("0");
		String forventet = "Denne readme bruker jeg i et API kall." + "\n";
		assertEquals(result, forventet);
	}

	@Test
	public void testRegnUtSnitt() {
		// Mock the RatingRepo and create a test Ratings list
		RatingRepo mockRepo = mock(RatingRepo.class);
		List<Ratings> testList = new ArrayList<>();
		testList.add(new Ratings("1", "2", "2"));
		testList.add(new Ratings("1", "3", "3"));
		testList.add(new Ratings("1", "4", "4"));
		when(mockRepo.findByProsjektid("1")).thenReturn(testList);

		// Call the regnUtSnitt method
		String result = new RatingsUtil().regnUtSnitt(mockRepo, "1");

		// Check that the result is correct
		assertEquals("3.0", result);
	}

}
