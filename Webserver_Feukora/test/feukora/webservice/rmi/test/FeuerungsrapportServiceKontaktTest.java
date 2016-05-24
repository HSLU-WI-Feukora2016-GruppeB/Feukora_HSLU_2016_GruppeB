package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Kontakt;
import entitys.Ort;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Kontaktmethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceKontaktTest {

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
	 * {@link FeuerungsrapportServiceImpl#updateKontakt(Kontakt)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateKontakt() throws Exception {

		List<Kontakt> kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 8);

		Ort o = fservice.findOrtByPlz(5000).get(0);
		Kontakt k = fservice.findKontaktByOrt(o).get(0);
		assertNotNull(k);

		Ort oNew = fservice.findAllOrt().get(6);
		k.setOrt(oNew);

		fservice.updateKontakt(k);

		Kontakt oDB = fservice.findKontaktByOrt(oNew).get(0);
		assertNotNull(oDB);
		assertTrue(oDB.getOrt() != o);

		kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 8);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllKontakt()}
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllKontakt() throws Exception {

		List<Kontakt> kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 8);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findKontaktByName(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindKontaktByName() throws Exception {

		String n = "Zäh";

		List<Kontakt> k = fservice.findKontaktByName(n);

		assertNotNull(k);
		assertTrue(k.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findKontaktByVorname(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindKontaktByVorname() throws Exception {

		String v = "Heiri";
		List<Kontakt> k = fservice.findKontaktByVorname(v);
		assertNotNull(k);

		assertTrue(k.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findKontaktByOrt(Ort)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindKontaktByOrt() throws Exception {

		Ort o = fservice.findOrtByPlz(1000).get(0);
		List<Kontakt> kList = fservice.findKontaktByOrt(o);

		assertNotNull(kList);

		assertTrue(kList.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findKontaktByRolleExtern(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindKontaktByRolleExtern() throws Exception {

		List<Kontakt> k = fservice.findKontaktByRolleExtern(2);
		assertNotNull(k);

		assertTrue(k.size() == 6);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findKontaktByStrasse(String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindKontaktByStrasse() throws Exception {

		String s = "Zaubergass 7";
		List<Kontakt> k = fservice.findKontaktByStrasse(s);
		assertNotNull(k);

		assertTrue(k.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteKontakt(Kontakt)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteKontakt() throws Exception {

		List<Kontakt> kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 8);

		fservice.deleteKontakt(kListe.get(7));

		kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 7);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteKontaktById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteKontaktById() throws Exception {

		List<Kontakt> kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 8);

		fservice.deleteKontaktById(kListe.get(7).getId());

		kListe = fservice.findAllKontakt();
		assertTrue(kListe.size() == 7);
	}

	/**
	 * Initialisiert die Testwerte.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Kontakt> init() throws Exception {

		deleteAll();

		List<Kontakt> lKontakt = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();

		// 5 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));

		for (Ort o : lOrt) {
			fservice.addOrt(o);
		}

		List<Ort> lOrtDB = fservice.findAllOrt();

		// 4 Kontakte erstellen
		lKontakt.add(new Kontakt("Martina", "Meyer", "Altstrasse 1", lOrtDB
				.get(2), "0633335577", "m.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christoph", "Müller", "Neustrasse 1", lOrtDB
				.get(6), "0554445577", "c.m@gmail.com", 1));
		lKontakt.add(new Kontakt("Heiri", "Muster", "Bernstrasse 1", lOrtDB
				.get(4), "0688885577", "h.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christof", "Meyer", "Gassweg 1", lOrtDB
				.get(5), "0633335577", "ch.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Hanna", "Putz", "Malweg 5", lOrtDB.get(4),
				"0637777777", "h.p@gmail.com", 2));
		lKontakt.add(new Kontakt("Martina", "Zäh", "Altstrasse 90", lOrtDB
				.get(3), "0633888877", "m.z@gmail.com", 2));
		lKontakt.add(new Kontakt("Tina", "Bär", "Waserstrasse 4",
				lOrtDB.get(5), "0222235577", "t.b@gmail.com", 1));
		lKontakt.add(new Kontakt("Rudolf", "Santa", "Zaubergass 7", lOrtDB
				.get(1), "0699999997", "r.s@gmail.com", 2));

		for (Kontakt k : lKontakt) {
			fservice.addKontakt(k);
		}

		List<Kontakt> lKontaktDB = fservice.findAllKontakt();

		return lKontaktDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @since 1.0
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllKontakte();

		for (Ort o : fservice.findAllOrt()) {
			fservice.deleteOrt(o);
		}
	}

	/**
	 * Löscht alle Kontakte.
	 * 
	 * @since 1.0
	 * @throws Exception
	 */
	public static void deleteAllKontakte() throws Exception {

		for (Kontakt k : fservice.findAllKontakt()) {
			fservice.deleteKontakt(k);
		}
	}
}
