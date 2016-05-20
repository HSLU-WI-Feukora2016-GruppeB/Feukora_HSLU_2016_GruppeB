package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Mitarbeitermethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceMitarbeiterTest {

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
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#updateMitarbeiter(Mitarbeiter)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
		
		Mitarbeiter m = fservice.findMitarbeiterByName("Raneri").get(0);
		assertNotNull(m);
		m.setName("Pagani");
		
		fservice.updateMitarbeiter(m);
		
		Mitarbeiter aDB = fservice.findMitarbeiterByName("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getName() != "Raneri");
		
		mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
	}
	
	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findAllMitarbeiter()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
	}
	
	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByName(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByName() throws Exception {
		
		String name = "Raneri";
		List<Mitarbeiter> mitarbeiterListe = fservice.findMitarbeiterByName(name);
		assertTrue(mitarbeiterListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByVorname(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByVorname() throws Exception {
		
		String vorname = "Luca";
		assertTrue(fservice.findMitarbeiterByVorname(vorname).size() == 1);
		
		String vorname2 = "Fronzak";
		assertTrue(fservice.findMitarbeiterByVorname(vorname2).isEmpty());
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByNameVorname(String, String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByNameVorname() throws Exception {
		
		String name = "Raneri";
		String vorname = "Luca";
		assertTrue(fservice.findMitarbeiterByNameVorname(name, vorname).size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByStrasse(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByStrasse() throws Exception {

		String strasse = "Musterstrasse 5";
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findMitarbeiterByStrasse(strasse);
		assertTrue(mitarbeiterListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByOrt(Ort)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByOrt() throws Exception {
		
		Ort ort = fservice.findOrtByPlz(1000).get(0);
		assertNotNull(ort);
		
		List<Mitarbeiter> mitarbeitersListe = fservice.findMitarbeiterByOrt(ort);
		assertTrue(mitarbeitersListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByRolleIntern(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByRolleIntern() throws Exception {

		int rolleIntern = 1;
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findMitarbeiterByRolleIntern(rolleIntern);
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByBenutzer(Benutzer)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByBenutzer() throws Exception {
		
		Benutzer benutzer = fservice.findBenutzerByUsername("lra").get(0);
		assertNotNull(benutzer);
		
		List<Mitarbeiter> mitarbeitersListe = fservice.findMitarbeiterByBenutzer(benutzer);
		assertTrue(mitarbeitersListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByArbeitetSeit(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetSeit() throws Exception {
		
		GregorianCalendar seit = new GregorianCalendar(2016, 5, 1);
		List<Mitarbeiter> mitarbeiterListe = fservice.findMitarbeiterByArbeitetSeit(seit);
		assertEquals(6, mitarbeiterListe.size());
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMitarbeiterByArbeitetBis(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetBis() throws Exception {
		
		GregorianCalendar bis = new GregorianCalendar(2018, 8, 11);
		List<Mitarbeiter> mitarbeiterListe = fservice.findMitarbeiterByArbeitetBis(bis);
		assertEquals(6, mitarbeiterListe.size());
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#deleteMitarbeiter(Mitarbeiter)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		fservice.deleteMitarbeiter(mitarbeiterListe.get(0));

		mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#deleteMitarbeiterById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiterById() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		fservice.deleteMitarbeiterById(mitarbeiterListe.get(0).getIdMitarbeiter());

		mitarbeiterListe = fservice.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Initialisiert die Testwerte.
	 * @return
	 * @throws Exception
	 */
	public static List<Mitarbeiter> init() throws Exception{
		
		deleteAll();
		
		List<Ort> lOrt = new ArrayList<>();
		List<Mitarbeiter> lMitarbeiter = new ArrayList<>();
		List<Benutzer> lBenutzer = new ArrayList<>();
		
		//7 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));
		
		//6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		
		//6 Mitarbeiter erstellen
		lMitarbeiter.add(new Mitarbeiter("Olivia", "Wassmer", "Musterstrasse 1", lOrt.get(3), "1234567678", "o.w@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Matthias", "Perrollaz", "Musterstrasse 2", lOrt.get(4), "1234557678", "m.p@feukora.ch", 2, lBenutzer.get(4), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Dominik", "Stirnimann", "Musterstrasse 3", lOrt.get(3), "1234367678", "d.s@feukora.ch", 1, lBenutzer.get(3), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Pascal", "Steiner", "Musterstrasse 4", lOrt.get(2), "1234567678", "p.st@feukora.ch", 1, lBenutzer.get(2), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Luca", "Raneri", "Musterstrasse 5", lOrt.get(1), "1234567178", "l.r@feukora.ch", 1, lBenutzer.get(1), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Alexandra", "Lengen", "Musterstrasse 1", lOrt.get(0), "1234563678", "a.l@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		
		for(Ort o : lOrt){
			fservice.addOrt(o);
		}
		
		for(Benutzer b : lBenutzer){
			fservice.addBenutzer(b);
		}
		
		for(Mitarbeiter m : lMitarbeiter){
			fservice.addMitarbeiter(m);
		}
				
		return lMitarbeiter;
	}
	
	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {
		
		deleteAllMitarbeiter();
		
		for (Benutzer b : fservice.findAllBenutzer()){
			fservice.deleteBenutzer(b);
		}
	
		for (Ort o : fservice.findAllOrt()){
			fservice.deleteOrt(o);
		}
	}
	
	/**
	 * Löscht alle Mitarbeiter.
	 * @throws Exception
	 */
	public static void deleteAllMitarbeiter() throws Exception {

		for (Mitarbeiter m : fservice.findAllMitarbeiter()) {
			fservice.deleteMitarbeiter(m);
		}
	}
}
