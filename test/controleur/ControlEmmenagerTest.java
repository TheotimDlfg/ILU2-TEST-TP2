package controleur;




import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	private Village v;
	private Chef ax;
	
	@BeforeEach
	public void init() {
		v = new Village("Shaka", 10, 2);
		ax = new Chef("Abraracourcix", 10, v);
		v.setChef(ax);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager CE = new ControlEmmenager(v);
		assertNotNull(CE, "Contructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEM = new ControlEmmenager(v);
		controlEM.ajouterGaulois("b", 10);
		assertTrue(controlEM.isHabitant("b"));
		assertFalse(controlEM.isHabitant("d"));
		controlEM.ajouterDruide("p", 10, 1, 5);
		assertTrue(controlEM.isHabitant("p"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEm = new ControlEmmenager(v);
		controlEm.ajouterDruide("p", 10, 1, 5);
	}

	@Test
	void testAjouterGaulois() {
		
	}

}
