package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Brenner;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Brennermethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Alexandra
 * @version 1.0
 * @since 1.0
 */
public class FeuerungsrapportServiceBrennerTest {

	static FeuerungsrapportService fservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fservice = new FeuerungsrapportServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initialisiert die Testwerten.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		init();
	}

	/**
	 * Schliesst Test ab.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		deleteAll();
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#updateBrenner(entitys.Brenner)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateBrenner() throws Exception {

		List<Brenner> bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 3);

		String bNew = "testibus";
		Brenner bUpdated = bListe.get(1);
		bUpdated.setBrennerTyp(bNew);

		fservice.updateBrenner(bUpdated);

		assertTrue(fservice.findAllBrenner().size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllBrenner()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllBrenner() throws Exception {

		List<Brenner> bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findBrennerByTyp(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindBrennerByTyp() throws Exception {

		String bt = "abc123";
		List<Brenner> b = fservice.findBrennerByTyp(bt);

		assertTrue(b.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findBrennerByArt(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindBrennerByArt() throws Exception {

		int ba = 1;
		List<Brenner> b = fservice.findBrennerByArt(ba);

		assertTrue(b.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findBrennerByBaujahr(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindBrennerByBaujahr() throws Exception {

		int bj = 2013;
		List<Brenner> b = fservice.findBrennerByBaujahr(bj);

		assertNotNull(b);

		assertTrue(b.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteBrenner(Brenner)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteBrenner() throws Exception {

		List<Brenner> bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 3);

		fservice.deleteBrenner(bListe.get(0));
		;

		bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteBrennerById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteBrennerById() throws Exception {

		List<Brenner> bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 3);

		fservice.deleteBrennerById(bListe.get(0).getId());

		bListe = fservice.findAllBrenner();
		assertTrue(bListe.size() == 2);
	}

	/**
	 * Initialisiert die Testwerte
	 * 
	 * @return lBrennerDB
	 * @throws Exception
	 */
	public static List<Brenner> init() throws Exception {

		deleteAll();

		List<Brenner> lBrenner = new ArrayList<>();

		// 3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));

		for (Brenner br : lBrenner) {
			fservice.addBrenner(br);
		}

		List<Brenner> lBrennerDB = fservice.findAllBrenner();

		return lBrennerDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for (Brenner b : fservice.findAllBrenner()) {
			fservice.deleteBrenner(b);
			;
		}
	}
}
