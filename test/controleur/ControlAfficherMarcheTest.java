package controleur;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlAfficherMarcheTest {

	@BeforeEach
	public void init() {
		Village v = new Village("Shaka", 10, 2);
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(v);
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(v);
		ControlAcheterProduit controlAP = new ControlAcheterProduit(controlId, controlTrouver, v);
		
		
	}
	
	@Test
	void testControlAfficherMarche() {
		assertNotNull(ControleAffciherMarche(v));
	}

	@Test
	void testDonnerInfosMarche() {
		fail("Not yet implemented");
	}

}
