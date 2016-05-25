package testManager;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Benutzer;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import managerInterfaces.BenutzerManager;
import managerKlassen.BenutzerManagerImpl;

/**
 * Testet die Funktionalität des BenutzerManager.
 * @author Matthias
 * @since 1.0
 * @version 1.0
 *
 */
public class BenutzerManagerTest {

	private static BenutzerManager benutzerManager = new BenutzerManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		BenutzerManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		BenutzerManagerTest.deleteAll();
	}
	
	/**
	 * Testet die Methode {@link BenutzerManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Benutzer> bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 6);
	}
	
	/**
	 * Testet die Methode {@link BenutzerManagerImpl#findByUsername(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByUsername() throws Exception {
		
		String u = "mpe";
		List<Benutzer> b = benutzerManager.findByUsername(u);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link BenutzerManagerImpl#findByUsernamePassword(String, String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByUsernamePassword() throws Exception {
		
		String u = "owa";
		String p = "121";
		List<Benutzer> b = benutzerManager.findByUsernamePassword(u, p);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}

	
	/**
	 * Testet die Methode {@link BenutzerDAOImpl#updateBenutzer(Benutzer)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Benutzer> bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 6);

		String pNew = "testibus";
		Benutzer bUpdated = bListe.get(1);
		bUpdated.setPassword(pNew);
		
		benutzerManager.update(bUpdated);
		
		assertTrue(benutzerManager.findAll().size() == 6);
	}

	/**
	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzer(Benutzer)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Benutzer> bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 6);

		benutzerManager.delete(bListe.get(0));

		bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 5);

	}

	/**
	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzerById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Benutzer> bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 6);

		benutzerManager.deleteById(bListe.get(0).getIdUser());

		bListe = benutzerManager.findAll();
		assertTrue(bListe.size() == 5);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return lBenutzer
	 * @throws Exception
	 */
	public static List<Benutzer> init() throws Exception {
		BenutzerManagerTest.deleteAll();
		
		List<Benutzer> lBenutzer = new ArrayList<>();
		
		//6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		
		for(Benutzer b : lBenutzer){
			benutzerManager.add(b);
		}
		
		return lBenutzer;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Benutzer b : benutzerManager.findAll()){
			benutzerManager.delete(b);
		}
	}
}
