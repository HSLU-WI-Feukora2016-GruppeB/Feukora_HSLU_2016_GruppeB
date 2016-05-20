package testManager;

import static org.junit.Assert.*;
import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.BenutzerManager;
import managerInterfaces.MitarbeiterManager;
import managerInterfaces.OrtManager;
import managerKlassen.BenutzerManagerImpl;
import managerKlassen.MitarbeiterManagerImpl;
import managerKlassen.OrtManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MitarbeiterManagerTest {

	private static MitarbeiterManager mitarbeiterManager = new MitarbeiterManagerImpl();
	private static OrtManager ortManager = new OrtManagerImpl();
	private static BenutzerManager benutzerManager = new BenutzerManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MitarbeiterManagerTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		MitarbeiterManagerTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#updateMitarbeiter(Mitarbeiter)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
		
		Mitarbeiter m = mitarbeiterManager.findByName("Raneri").get(0);
		assertNotNull(m);
		m.setName("Pagani");
		
		mitarbeiterManager.update(m);
		
		Mitarbeiter aDB = mitarbeiterManager.findByName("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getName() != "Raneri");
		
		mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#deleteMitarbeiter(Mitarbeiter)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		mitarbeiterManager.delete(mitarbeiterListe.get(0));

		mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#deleteMitarbeiterById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiterById()throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		mitarbeiterManager.deleteById(mitarbeiterListe.get(0).getIdMitarbeiter());

		mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByArbeitetBis(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetBis() throws Exception {
		
		GregorianCalendar bis = new GregorianCalendar(2018, 8, 11);
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findByArbeitetBis(bis);
		assertEquals(6, mitarbeiterListe.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByArbeitetSeit(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetSeit() throws Exception {
		
		GregorianCalendar seit = new GregorianCalendar(2016, 5, 1);
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findByArbeitetSeit(seit);
		assertEquals(6, mitarbeiterListe.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByBenutzer(Benutzer)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByBenutzer() throws Exception {
		
		Benutzer benutzer = benutzerManager.findByUsername("lra").get(0);
		assertNotNull(benutzer);
		
		List<Mitarbeiter> mitarbeitersListe = mitarbeiterManager.findByBenutzer(benutzer);
		assertTrue(mitarbeitersListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByRolleIntern(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByRolleIntern() throws Exception {
		
		int rolleIntern = 1;
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findByRolleIntern(rolleIntern);
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByStrasse(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByStrasse() throws Exception {
		
		String strasse = "Musterstrasse 5";
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findByStrasse(strasse);
		assertTrue(mitarbeiterListe.size() == 1);
	}
	
	/**
	 * Dieser Test testet die Suchfunktion "FindAllMitarbeiter". 
	 * @throws Exception
	 */
	@Test
	public void testFindAllMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
	}
	
	@Test
	public void testFindByName() throws Exception{
		
		String name = "Raneri";
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterManager.findByName(name);
		assertTrue(mitarbeiterListe.size() == 1);
	}

	@Test
	public void testFindByVorname()throws Exception{
		
		String vorname = "Luca";
		assertTrue(mitarbeiterManager.findByVorname(vorname).size() == 1);
		
		String vorname2 = "Fronzak";
		assertTrue(mitarbeiterManager.findByVorname(vorname2).isEmpty());
	}
	
	@Test
	public void testFindByNameVorname()throws Exception{
		
		String name = "Raneri";
		String vorname = "Luca";
		assertTrue(mitarbeiterManager.findByNameVorname(name, vorname).size() == 1);
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByOrt(Ort)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeierByOrt()throws Exception{
		
		Ort ort = ortManager.findByPlz(1000).get(0);
		assertNotNull(ort);
		
		List<Mitarbeiter> mitarbeitersListe = mitarbeiterManager.findByOrt(ort);
		assertTrue(mitarbeitersListe.size() == 1);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Mitarbeiter> init() throws Exception{
		
		MitarbeiterManagerTest.deleteAll();
		
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
			ortManager.add(o);
		}
		
		for(Benutzer b : lBenutzer){
			benutzerManager.add(b);
		}
		
		for(Mitarbeiter m : lMitarbeiter){
			mitarbeiterManager.add(m);
		}
				
		return lMitarbeiter;
	}
	
	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {
		
		deleteAllMitarbeiter();
		
		for (Benutzer b : benutzerManager.findAll()){
			benutzerManager.delete(b);
		}
	
		for (Ort o : ortManager.findAll()){
			ortManager.delete(o);
		}
	}
	
	/**
	 * Löscht alle Mitarbeiter aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllMitarbeiter() throws Exception {

		for (Mitarbeiter m : mitarbeiterManager.findAllMitarbeiter()) {
			mitarbeiterManager.delete(m);
		}
	}

}
