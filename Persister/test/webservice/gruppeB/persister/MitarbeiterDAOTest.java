package webservice.gruppeB.persister;

import static org.junit.Assert.*;
import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der MitarbeiterDAO-Implementierung zuständig.
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 */
public class MitarbeiterDAOTest {

	private static MitarbeiterDAOImpl mitarbeiterDAO = new MitarbeiterDAOImpl();
	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MitarbeiterDAOTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		MitarbeiterDAOTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#updateMitarbeiter(Mitarbeiter)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
		
		Mitarbeiter m = mitarbeiterDAO.findMitarbeiterByName("Raneri").get(0);
		assertNotNull(m);
		m.setName("Pagani");
		
		mitarbeiterDAO.updateMitarbeiter(m);
		
		Mitarbeiter aDB = mitarbeiterDAO.findMitarbeiterByName("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getName() != "Raneri");
		
		mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#deleteMitarbeiter(Mitarbeiter)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		mitarbeiterDAO.deleteMitarbeiter(mitarbeiterListe.get(0));

		mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#deleteMitarbeiterById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiterById()throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);

		mitarbeiterDAO.deleteMitarbeiterById(mitarbeiterListe.get(0).getIdMitarbeiter());

		mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByArbeitetBis(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetBis() throws Exception {
		
		GregorianCalendar bis = new GregorianCalendar(2018, 8, 11);
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByArbeitetBis(bis);
		assertEquals(6, mitarbeiterListe.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByArbeitetSeit(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByArbeitetSeit() throws Exception {
		
		GregorianCalendar seit = new GregorianCalendar(2016, 5, 1);
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByArbeitetSeit(seit);
		assertEquals(6, mitarbeiterListe.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByBenutzer(Benutzer)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByBenutzer() throws Exception {
		
		Benutzer benutzer = benutzerDAO.findBenutzerByUsername("lra").get(0);
		assertNotNull(benutzer);
		
		List<Mitarbeiter> mitarbeitersListe = mitarbeiterDAO.findMitarbeiterByBenutzer(benutzer);
		assertTrue(mitarbeitersListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByRolleIntern(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByRolleIntern() throws Exception {
		
		int rolleIntern = 1;
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByRolleIntern(rolleIntern);
		assertTrue(mitarbeiterListe.size() == 5);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByStrasse(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeiterByStrasse() throws Exception {
		
		String strasse = "Musterstrasse 5";
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByStrasse(strasse);
		assertTrue(mitarbeiterListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findAllMitarbeiter()}
	 * @throws Exception
	 */
	@Test
	public void testFindAllMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 6);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByName(name)}.
	 * 
	 */
	@Test
	public void testFindByName() {
		
		String name = "Raneri";
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByName(name);
		assertTrue(mitarbeiterListe.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByVorname(String)}.
	 * 
	 */
	@Test
	public void testFindByVorname(){
		
		String vorname = "Luca";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname).size() == 1);
		
		String vorname2 = "Fronzak";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname2).isEmpty());
	}
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByNameVorname(String, String)}.
	 * 
	 */	
	@Test
	public void testFindByNameVorname(){
		
		String name = "Raneri";
		String vorname = "Luca";
		assertTrue(mitarbeiterDAO.findMitarbeiterByNameVorname(name, vorname).size() == 1);
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MitarbeiterDAOImpl#findMitarbeiterByOrt(Ort)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMitarbeierByOrt() {
		
		Ort ort = ortDAO.findOrtByPlz(1000).get(0);
		assertNotNull(ort);
		
		List<Mitarbeiter> mitarbeitersListe = mitarbeiterDAO.findMitarbeiterByOrt(ort);
		assertTrue(mitarbeitersListe.size() == 1);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Mitarbeiter> init() throws Exception{
		
		MitarbeiterDAOTest.deleteAll();
		
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
			ortDAO.saveOrt(o);
		}
		
		for(Benutzer b : lBenutzer){
			benutzerDAO.saveBenutzer(b);
		}
		
		for(Mitarbeiter m : lMitarbeiter){
			mitarbeiterDAO.saveMitarbeiter(m);
		}
				
		return lMitarbeiter;
	}
	
	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {
		
		deleteAllMitarbeiter();
		
		for (Benutzer b : benutzerDAO.findAllBenutzer()){
			benutzerDAO.deleteBenutzer(b);
		}
	
		for (Ort o : ortDAO.findAllOrt()){
			ortDAO.deleteOrt(o);
		}
	}
	
	/**
	 * Löscht alle Mitarbeiter aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllMitarbeiter() throws Exception {

		for (Mitarbeiter m : mitarbeiterDAO.findAllMitarbeiter()) {
			mitarbeiterDAO.deleteMitarbeiter(m);
		}
	}
	
}