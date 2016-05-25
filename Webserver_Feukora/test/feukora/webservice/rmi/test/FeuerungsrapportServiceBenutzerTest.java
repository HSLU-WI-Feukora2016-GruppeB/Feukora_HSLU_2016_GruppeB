package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Benutzer;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Benutzermethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Dominik
 * @version 1.0
 * @since 1.0
 */

public class FeuerungsrapportServiceBenutzerTest {

	static FeuerungsrapportService fservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fservice = new FeuerungsrapportServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initialisiert die Testwerte.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		init();
	}
	
	/**
	 * Schliesst Test ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		deleteAll();
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#updateBenutzer(Benutzer)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateBenutzer() throws Exception {
		
		List<Benutzer> bListe = fservice.findAllBenutzer();
		assertTrue(bListe.size() == 6);

		String pNew = "testibus";
		Benutzer bUpdated = bListe.get(1);
		bUpdated.setPassword(pNew);
		
		fservice.updateBenutzer(bUpdated);
		
		assertTrue(fservice.findAllBenutzer().size() == 6);
	}
	
	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findAllBenutzer()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllBenutzer() throws Exception {
		
		List<Benutzer> bListe = fservice.findAllBenutzer();
		assertTrue(bListe.size() == 6);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findBenutzerByUsername(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindBenutzerByUsername() throws Exception {
		
		String u = "mpe";
		List<Benutzer> b = fservice.findBenutzerByUsername(u);
		
		assertNotNull(b);
		assertTrue(b.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findBenutzerByUsernamePassword(String, String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindBenutzerByUsernamePassword() throws Exception {
		
		String u = "owa";
		String p = "121";
		List<Benutzer> b = fservice.findBenutzerByUsernamePassword(u, p);
		
		assertNotNull(b);
		assertTrue(b.size() == 1);
	}

	/**
	 * Initialisiert die Testwerte.
	 * @return lBenutzerDB
	 * @throws Exception
	 */
	public static List<Benutzer> init() throws Exception {
		
		deleteAll();
		
		List<Benutzer> lBenutzer = new ArrayList<>();
		
		//6 Benutzer hinzufügen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		
		for(Benutzer b : lBenutzer){
			fservice.addBenutzer(b);
		}
		
		List<Benutzer> lBenutzerDB = fservice.findAllBenutzer();
		
		return lBenutzerDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Benutzer b : fservice.findAllBenutzer()){
			fservice.deleteBenutzer(b);
		}
	}
}
