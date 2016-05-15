package webservice.gruppeB.persister;

import static org.junit.Assert.*;
import entitäten.Mitarbeiter;
import entitäten.Ort;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der MitarbeiterDAO-Implementierung zuständig.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class MitarbeiterDAOTest {

	private static MitarbeiterDAOImpl mitarbeiterDAO = new MitarbeiterDAOImpl();
	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	
	@BeforeClass
	public static void setUpBeforClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		
		//TODO
		
		//ResetDatabase.resetDatabase();
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		
		for (Mitarbeiter m : mitarbeiterListe){
			mitarbeiterDAO.deleteMitarbeiter(m);
		}
	}	
		
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Dieser Test speichert einen Mitarbeiter.
	 * @throws Exception
	 */
	@Test
	public void testSaveMitarbeiter() throws Exception {
		
		Mitarbeiter m1 = new Mitarbeiter();
		
		try {
			mitarbeiterDAO.saveMitarbeiter(m1);
		} catch (Exception e) {
			//TODO catch block
			e.printStackTrace();
		}
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 1);
	}
	
	/**
	 * Dieser Test updatet einen Mitarbeiter.
	 * @throws Exception
	 */
	@Test
	public void testUpdateMitarbeiter() throws Exception {
		
		Mitarbeiter m2 = new Mitarbeiter();
		
		try {
			mitarbeiterDAO.saveMitarbeiter(m2);
		} catch (Exception e) {
			//TODO catch block
			e.printStackTrace();
		}
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 1);
		
		m2.setTel("0791234567");
		
		try {
			mitarbeiterDAO.updateMitarbeiter(m2);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		String a = "0791234567";
		String b = m2.getTel();
		assertEquals(a, b);
		
	}
	
	/**
	 * Dieser Test loescht einen Mitarbeiter.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMitarbeiter() throws Exception {
		
		Mitarbeiter m2  = new Mitarbeiter();
		
		try {
			mitarbeiterDAO.saveMitarbeiter(m2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 1);
		
		// Mitarbeiter m2 löschen
		try {
			mitarbeiterDAO.deleteMitarbeiter(m2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(mitarbeiterDAO.findAllMitarbeiter().isEmpty());
	}
	
	/**
	 * Dieser Test testet die Suchfunktion "FindAllMitarbeiter". 
	 * @throws Exception
	 */
	@Test
	public void testFindAllMitarbeiter() throws Exception {
		
		Mitarbeiter m6  = new Mitarbeiter();
		
		try {
			mitarbeiterDAO.saveMitarbeiter(m6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Alle Mitarbeiter suchen
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 1);
	}
	
	@Test
	public void testFindByName() {
		
		String name = "Nötig";
		assertTrue(mitarbeiterDAO.findMitarbeiterByName(name).size() == 1);
	}

	@Test
	public void testFindByVorname(){
		
		String vorname = "Hans";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname).size() == 1);
		
		vorname = "Fronzak";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname).isEmpty());
	}
	
	@Test
	public void testFindByNameVorname(){
		
		String name = "Fronzak";
		String vorname = "Chris";
		assertTrue(mitarbeiterDAO.findMitarbeiterByNameVorname(name, vorname).size() == 1);
		
		vorname = "Adriano";
		assertTrue(mitarbeiterDAO.findMitarbeiterByNameVorname(name, vorname).isEmpty());
	}
	
	@Test
	public void testFindByOrt() {
		
		//TODO ort initialisieren
		Ort ort = null;
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findByOrt(ort);
		assertTrue(mitarbeiterListe.size() == 1);
		
		mitarbeiterListe = mitarbeiterDAO.findByOrt(ort);
	}
	
	
	
	
	
	
	
	
}
