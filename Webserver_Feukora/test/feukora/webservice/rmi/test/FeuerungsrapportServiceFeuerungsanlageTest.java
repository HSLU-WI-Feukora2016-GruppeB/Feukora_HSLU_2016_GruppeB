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
import entitys.Feuerungsanlage;
import entitys.Waermeerzeuger;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Feuerungsanlagenmethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Dominik
 * @version 1.0
 * @since 1.0
 */
public class FeuerungsrapportServiceFeuerungsanlageTest {

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
	 * {@link FeuerungsrapportServiceImpl#updateFeuerungsanlage(Feuerungsanlage)}.
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateFeuerungsanlage() throws Exception {

		List<Feuerungsanlage> fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		Feuerungsanlage f = fservice.findAllFeuerungsanlage().get(0);
		Brenner bNew = fservice.findAllBrenner().get(2);
		f.setBrenner(bNew);

		fservice.updateFeuerungsanlage(f);

		assertTrue(fservice.findAllFeuerungsanlage().size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllFeuerungsanlage()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllFeuerungsanlage() throws Exception {

		List<Feuerungsanlage> fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findFeuerungsanlageByBrenner(Brenner)}.
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindFeuerungsanlageByBrenner() throws Exception {

		Brenner b = fservice.findAllBrenner().get(0);
		List<Feuerungsanlage> fList = fservice.findFeuerungsanlageByBrenner(b);

		assertNotNull(fList);
		assertTrue(fList.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findFeuerungsanlageByWaermeerzeuger(Waermeerzeuger)}.
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindFeuerungsanlageByWaermeerzeuger() throws Exception {

		Waermeerzeuger w = fservice.findAllWaermeerzeuger().get(0);
		List<Feuerungsanlage> fList = fservice
				.findFeuerungsanlageByWaermeerzeuger(w);

		assertTrue(fList.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteFeuerungsanlage(Feuerungsanlage)}.
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteFeuerungsanlage() throws Exception {

		List<Feuerungsanlage> fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		fservice.deleteFeuerungsanlage(fListe.get(0));

		fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteFeuerungsanlageById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteFeuerungsanlageById() throws Exception {

		List<Feuerungsanlage> fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		fservice.deleteFeuerungsanlageById(fListe.get(0).getIdFeuerungsanlage());

		fListe = fservice.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 2);
	}

	/**
	 * Initialisiert die Testwerte.
	 * 
	 * @return lFeuerungsanlageDB
	 * @throws Exception
	 */
	public static List<Feuerungsanlage> init() throws Exception {

		deleteAll();

		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();

		// 3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));

		for (Brenner br : lBrenner) {
			fservice.addBrenner(br);
		}

		List<Brenner> lBrennerDB = fservice.findAllBrenner();

		// 3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));

		for (Waermeerzeuger w : lWaermeerzeuger) {
			fservice.addWaermeerzeuger(w);
		}

		List<Waermeerzeuger> lWaermeerzeugerDB = fservice
				.findAllWaermeerzeuger();

		// 3 Feuerungsanlagen
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(0),
				lWaermeerzeugerDB.get(0), 65));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(1),
				lWaermeerzeugerDB.get(1), 46));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(2),
				lWaermeerzeugerDB.get(2), 88));

		for (Feuerungsanlage f : lFeuerungsanlage) {
			fservice.addFeuerungsanlage(f);
		}

		List<Feuerungsanlage> lFeuerungsanlageDB = fservice
				.findAllFeuerungsanlage();

		return lFeuerungsanlageDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for (Feuerungsanlage f : fservice.findAllFeuerungsanlage()) {
			fservice.deleteFeuerungsanlage(f);
		}
		for (Brenner b : fservice.findAllBrenner()) {
			fservice.deleteBrenner(b);
			;
		}
		for (Waermeerzeuger w : fservice.findAllWaermeerzeuger()) {
			fservice.deleteWaermeerzeuger(w);
			;
		}
	}
}
