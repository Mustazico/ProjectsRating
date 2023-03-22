package no.hvl.Obligatorisk4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.Prosjekt4.util.BrukerService;
import no.hvl.Prosjekt4.util.JPARepo;
import no.hvl.Prosjekt4.util.PassordUtil;

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
}
