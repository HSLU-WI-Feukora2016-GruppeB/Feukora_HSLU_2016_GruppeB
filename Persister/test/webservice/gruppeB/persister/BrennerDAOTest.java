package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import entitys.Brenner;
import gruppeB.feukora.persister.BrennerDAOImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrennerDAOTest {

private static BrennerDAOImpl brennerDAO = new BrennerDAOImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		BrennerDAOTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Testet die Methode {@link BrennerDAOImpl#findAllBrenner()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Brenner> bListe = brennerDAO.findAllBrenner();
		assertTrue(bListe.size() == 3);
	}
	
	/**
	 * Testet die Methode {@link BrennerDAOImpl#findBrennerByBaujahr(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBaujahr() throws Exception {
		
		int bj = 2012;
		List<Brenner> b = brennerDAO.findBrennerByBaujahr(bj);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link BrennerDAOImpl#findBrennerByBrennerart(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBrennerart() throws Exception {
		
		int ba = 1;
		List<Brenner> b = brennerDAO.findBrennerByBrennerart(ba);
		
		assertTrue(b.size() == 2);
	}

	
//	/**
//	 * Testet die Methode {@link BrennerDAOImpl#}
//	 * @throws Exception
//	 */
//	@Test
//	public void testUpdate() throws Exception {
//
//		List<Brenner> bListe = brennerDAO.findAllBrenner();
//		assertTrue(bListe.size() == 3);
//
//		String pNew = "testibus";
//		Brenner bUpdated = bListe.get(1);
//		bUpdated.setPassword(pNew);
//		
//		benutzerDAO.updateBenutzer(bUpdated);
//		
//		assertTrue(benutzerDAO.findAllBenutzer().size() == 6);
//	}
//
//	/**
//	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzer(Benutzer)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testDelete() throws Exception {
//
//		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
//		assertTrue(bListe.size() == 6);
//
//		benutzerDAO.deleteBenutzer(bListe.get(0));;
//
//		bListe = benutzerDAO.findAllBenutzer();
//		assertTrue(bListe.size() == 5);
//
//	}
//
//	/**
//	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzerById(Integer)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testDeleteById() throws Exception {
//		
//		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
//		assertTrue(bListe.size() == 6);
//
//		benutzerDAO.deleteBenutzerById(bListe.get(0).getIdUser());
//
//		bListe = benutzerDAO.findAllBenutzer();
//		assertTrue(bListe.size() == 5);
//	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Brenner> init() throws Exception {
		BrennerDAOTest.deleteAll();
		
		List<Brenner> lBrenner = new ArrayList<>();
		
		//3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));
		
		for(Brenner b : lBrenner){
			brennerDAO.saveBrenner(b);
		}
		
		return lBrenner;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Benutzer b : benutzerDAO.findAllBenutzer()){
			benutzerDAO.deleteBenutzer(b);
		}
	}


}
