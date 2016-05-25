package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Ort;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalit�t der Ortmethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Alexandra
 * @version 1.0
<<<<<<< HEAD
 * @since 1.0
=======
 * @since 1.0.0
>>>>>>> refs/remotes/origin/master
 */
public class FeuerungsrapportServiceOrtTest {

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
	 * {@link FeuerungsrapportServiceImpl#updateOrt(entitys.Ort)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateOrt() throws Exception {

		List<Ort> ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		Ort o = fservice.findOrtByOrtBez("Z�rich").get(0);
		assertNotNull(0);
		o.setOrtBez("Entenhausen");

		fservice.updateOrt(o);

		Ort aDB = fservice.findOrtByOrtBez("Entenhausen").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getOrt() != "Z�rich");

		ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 7);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findOrtByOrtBez(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByOrtBez() throws Exception {

		String bezeichnung = "Luzern";

		List<Ort> ortsListe = fservice.findOrtByOrtBez(bezeichnung);
		assertTrue(ortsListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findOrtByPlz(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByPlz() throws Exception {

		int pl = 5000;

		List<Ort> ortListe = fservice.findOrtByPlz(pl);
		assertNotNull(pl);
		assertEquals(1, ortListe.size());
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllOrt()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllOrt() throws Exception {

		List<Ort> ortListe = fservice.findAllOrt();
		assertTrue(ortListe.size() == 7);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteOrt(entitys.Ort)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrt() throws Exception {

		List<Ort> ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		fservice.deleteOrt(ortsListe.get(0));

		ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 6);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteOrtById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrtById() throws Exception {

		List<Ort> ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		fservice.deleteOrtById(ortsListe.get(0).getId());

		ortsListe = fservice.findAllOrt();
		assertTrue(ortsListe.size() == 6);
	}

	/**
	 * Initialisiert die Testwerte.
	 * 
	 * @return lOrt
	 * @throws Exception
	 */
	public static List<Ort> init() throws Exception {

		deleteAll();

		List<Ort> lOrt = new ArrayList<>();

		// 5 Orte
		lOrt.add(new Ort(8000, "Z�rich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuch�tel"));
		lOrt.add(new Ort(4000, "Basel"));

		for (Ort o : lOrt) {
			fservice.addOrt(o);
		}

		List<Ort> lOrtDB = fservice.findAllOrt();
		
		return lOrtDB;
	}

	/**
	 * L�scht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllOrt();
	}

	/**
	 * L�scht alle Auftr�ge aus der Datenbank.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllOrt() throws Exception {

		for (Ort o : fservice.findAllOrt()) {
			fservice.deleteOrt(o);
		}
	}
}
