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
	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	
//	@BeforeClass
//	public static void setUpBeforClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
	
	@Before
	public void setUp() throws Exception {
		MitarbeiterDAOTest.init();
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
		
		Mitarbeiter m3 = new Mitarbeiter();
		
		try {
			mitarbeiterDAO.saveMitarbeiter(m3);
		} catch (Exception e) {
			//TODO catch block
			e.printStackTrace();
		}
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 3);
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
	 * Dieser Test tested die Methode deletMitarbeiterById.
	 * @throws Exception
	 */
	public void testDeleteMitarbeiterById()throws Exception {
		
	}
	
	public void testFindMitarbeiterByArbeitetBis() throws Exception {
		
	}
	
	public void testFindMitarbeiterByArbeitetSeit() throws Exception {
		
	}
	
	public void testFindMitarbeiterByBenutzer() throws Exception {
		
	}
	
	public void testFindMitarbeiterByRolleIntern() throws Exception {
		
	}
	
	public void testFindMitarbeiterByStrasse() throws Exception {
		
	}
	
	
	
	/**
	 * Dieser Test testet die Suchfunktion "FindAllMitarbeiter". 
	 * @throws Exception
	 */
	@Test
	public void testFindAllMitarbeiter() throws Exception {
		
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		assertTrue(mitarbeiterListe.size() == 2);
	}
	
	@Test
	public void testFindByName() {
		
		String name = "Noetig";
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByName(name);
		assertTrue(mitarbeiterListe.size() == 2);
	}

	@Test
	public void testFindByVorname(){
		
		String vorname = "Hans";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname).size() == 1);
		
		String vorname2 = "Fronzak";
		assertTrue(mitarbeiterDAO.findMitarbeiterByVorname(vorname2).isEmpty());
	}
	
	@Test
	public void testFindByNameVorname(){
		
		String name = "Kwyat";
		String vorname = "Daniil";
		assertTrue(mitarbeiterDAO.findMitarbeiterByNameVorname(name, vorname).size() == 1);
		
	}
	
	@Test
	public void testFindByOrt() {
		
		Ort ort2 = new Ort(6045, "Meggen");
		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findMitarbeiterByOrt(ort2);
		assertTrue(mitarbeiterListe.size() == 1);
		
	}
	
	public static List<Mitarbeiter> init() throws Exception{
		
		MitarbeiterDAOTest.deleteAll();
		
		//1. Mitarbeiter Objekt m1
		Ort ort1 = new Ort(6048, "Horw");
		Benutzer user1 = new Benutzer("hnoetig","1234");
		GregorianCalendar seit1 = new GregorianCalendar(2016,01,01);
		GregorianCalendar bis1 = new GregorianCalendar(2016,12,31);
		Mitarbeiter m1 = new Mitarbeiter("Hans", "Nötig", "Kantonsstrasse 21", ort1,
				"0791231234", "hans.noetig@hotmail.com", 2, user1,
				4200, seit1,
				bis1);
		
		//2. Mitarbeiter Objekt m2
		Ort ort2 = new Ort(6045, "Meggen");
		Benutzer user2 = new Benutzer("DK","Like_a_boss!");
		GregorianCalendar seit2 = new GregorianCalendar(2016,05,02);
		GregorianCalendar bis2 = new GregorianCalendar(2017,12,31);
		Mitarbeiter m2 = new Mitarbeiter("Daniil", "Kwyat", "Obermattstrasse 22b", ort2,
				"0791001010", "daniil.kwyat@hotmail.com", 1, user2,
				4400, seit2,
				bis2);
		
		ortDAO.saveOrt(ort1);
		ortDAO.saveOrt(ort2);
		benutzerDAO.saveBenutzer(user1);
		benutzerDAO.saveBenutzer(user2);
		mitarbeiterDAO.saveMitarbeiter(m1);
		mitarbeiterDAO.saveMitarbeiter(m2);
		
		List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
		mitarbeiterListe.add(m1);
		mitarbeiterListe.add(m2);
		
		return mitarbeiterListe;
	}
	
	private static void deleteAll() throws Exception {

		List<Mitarbeiter> mitarbeiterListe = mitarbeiterDAO.findAllMitarbeiter();
		
		for (Mitarbeiter m : mitarbeiterListe) {
			mitarbeiterDAO.deleteMitarbeiter(m);
		}
		
		for (Ort o : ortDAO.findAllOrt()){
			ortDAO.deleteOrt(o);
		}
		
		for (Benutzer b : benutzerDAO.findAllBenutzer()){
			benutzerDAO.deleteBenutzer(b);
		}
	
	
	
	
	
	
}}
