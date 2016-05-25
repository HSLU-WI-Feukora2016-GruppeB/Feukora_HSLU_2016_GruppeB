package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Waermeerzeuger;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Waermeerzeugermethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Dominik
 * @version 1.0
<<<<<<< HEAD
 * @since 1.0
=======
 * @since 1.0.0
>>>>>>> refs/remotes/origin/master
 */
public class FeuerungsrapportServiceWaermeerzeugerTest {

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
	 * {@link FeuerungsrapportServiceImpl#updateWaermeerzeuger(entitys.Waermeerzeuger)}.
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateWaermeerzeuger() throws Exception {

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);

		Waermeerzeuger w = fservice.findWaermeerzeugerByTyp("qwertz").get(0);
		assertNotNull(w);
		w.setWaermeerzeugerTyp("Pagani");

		fservice.updateWaermeerzeuger(w);

		Waermeerzeuger aDB = fservice.findWaermeerzeugerByTyp("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getWaermeerzeugerTyp() != "qwertz");

		waermeerzeugerListe = fservice.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllWaermeerzeuger()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllWaermeerzeuger() throws Exception {

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findWaermeerzeugerByTyp(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByTyp() throws Exception {

		String typ = "qwertz";

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findWaermeerzeugerByTyp(typ);
		assertTrue(waermeerzeugerListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findWaermeerzeugerByBrennstoff(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBrennstoff() throws Exception {

		int brennstoff = 2;

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findWaermeerzeugerByBrennstoff(brennstoff);
		assertTrue(waermeerzeugerListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findWaermeerzeugerByBaujahr(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBaujahr() throws Exception {

		int baujahr = 2010;

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findWaermeerzeugerByBaujahr(baujahr);
		assertTrue(waermeerzeugerListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteWaermeerzeuger(entitys.Waermeerzeuger)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeuger() throws Exception {

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);

		fservice.deleteWaermeerzeuger(waermeerzeugerListe.get(0));

		waermeerzeugerListe = fservice.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteWaermeerzeugerById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeugerById() throws Exception {

		List<Waermeerzeuger> waermeerzeugerListe = fservice
				.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);

		fservice.deleteWaermeerzeugerById(waermeerzeugerListe.get(0)
				.getIdWaermeerzeuger());

		waermeerzeugerListe = fservice.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 2);
	}

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Waermeerzeuger> init() throws Exception {

		deleteAll();

		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();

		// 3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));

		for (Waermeerzeuger w : lWaermeerzeuger) {
			fservice.addWaermeerzeuger(w);
		}

		List<Waermeerzeuger> lWaermeerzeugerDB = fservice
				.findAllWaermeerzeuger();

		return lWaermeerzeugerDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllWaermeerzeuger();
	}

	/**
	 * Löscht alle Waermeerzeuger.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllWaermeerzeuger() throws Exception {

		for (Waermeerzeuger w : fservice.findAllWaermeerzeuger()) {
			fservice.deleteWaermeerzeuger(w);
		}
	}

}
