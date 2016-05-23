package testManager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.OrtManager;
import managerKlassen.OrtManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Ort;

/**
 * Diese Klasse ist für das Testen der OrtManager zuständig.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class OrtManagerTest {

private static OrtManager ortManager = new OrtManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		OrtManagerTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		OrtManagerTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link OrtManagerImpl#update(Ort)}. 
	 * @throws Exception
	 */
	@Test
	public void testUpdateOrt() throws Exception {
		
		List<Ort> ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 7);
		
		Ort o = ortManager.findByOrtBez("Zürich").get(0);
		assertNotNull(0);
		o.setOrtBez("Entenhausen");
		
		ortManager.update(o);
		
		Ort aDB = ortManager.findByOrtBez("Entenhausen").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getOrt() != "Zürich");
		
		ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 7);
		
	}
	
	/**
	 * Testet die Methode {@link OrtManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAllOrt() throws Exception{
		
		List<Ort> ortListe = ortManager.findAll();
		assertTrue(ortListe.size() == 7);
	}
	
	/**
	 * Testet die Methode {@link OrtManagerImpl#findByOrtBez(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByBezeichnung() throws Exception {
		
		String bezeichnung = "Luzern";
		
		List<Ort> ortsListe = ortManager.findByOrtBez(bezeichnung);
		assertTrue(ortsListe.size() == 1);
	
	}
	
	/**
	 * Testet die Methode {@link OrtManagerImpl#findByPlz(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByPlz() throws Exception {
		
		int pl = 5000;
		
		List<Ort> ortListe = ortManager.findByPlz(pl);
		assertNotNull(pl);
		assertEquals(1, ortListe.size());
		
	}
	
	/**
	 * Testet die Methode {@link OrtManagerImpl#delete(Ort)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrt() throws Exception {

		List<Ort> ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 7);

		ortManager.delete(ortsListe.get(0));

		ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 6);

	}
	
	/**
	 * Testet die Methode {@link OrtManagerImpl#deleteById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrtById() throws Exception {
		
		List<Ort> ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 7);

		ortManager.deleteById(ortsListe.get(0).getId());
		
		ortsListe = ortManager.findAll();
		assertTrue(ortsListe.size() == 6);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return lOrt
	 * @throws Exception
	 */
	public static List<Ort> init() throws Exception {
		OrtManagerTest.deleteAll();


		List<Ort> lOrt = new ArrayList<>();
		
		
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));

		
		for(Ort o : lOrt){
			ortManager.add(o);
		}
		
		return lOrt;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllOrt();
	}

	/**
	 * Löscht alle Aufträge aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllOrt() throws Exception {

		for (Ort o : ortManager.findAll()) {
			ortManager.delete(o);
		}
	}


}
