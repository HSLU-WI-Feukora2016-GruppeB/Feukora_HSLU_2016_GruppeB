package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Ort;
import gruppeB.feukora.persister.OrtDAOImpl;

/**
 * Testet die Funktionalität von OrtDAO.
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */
public class OrtDAOTest {

	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		OrtDAOTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		//OrtDAOTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link OrtDAOImpl#updateOrt(Ort)}. 
	 * @throws Exception
	 */
	@Test
	public void testUpdateOrt() throws Exception {
		
		List<Ort> ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 7);
		
		Ort o = ortDAO.findOrtByBezeichnung("Zürich").get(0);
		assertNotNull(0);
		o.setOrtBez("Entenhausen");
		
		ortDAO.updateOrt(o);
		
		Ort aDB = ortDAO.findOrtByBezeichnung("Entenhausen").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getOrt() != "Zürich");
		
		ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 7);
		
	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#findAllOrt()}
	 * @throws Exception
	 */
	@Test
	public void testFindAllOrt() throws Exception{
		
		List<Ort> ortListe = ortDAO.findAllOrt();
		assertTrue(ortListe.size() == 7);
	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#findOrtByBezeichnung(Ort)
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByBezeichnung() throws Exception {
		
		String bezeichnung = "Luzern";
		
		List<Ort> ortsListe = ortDAO.findOrtByBezeichnung(bezeichnung);
		assertTrue(ortsListe.size() == 1);
	
	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#findOrtByPlz(Plz)
	 * @throws Exception
	 */
	@Test
	public void testFindOrtByPlz() throws Exception {
		
		int pl = 5000;
		
		List<Ort> ortListe = ortDAO.findOrtByPlz(pl);
		assertNotNull(pl);
		assertEquals(1, ortListe.size());
		
	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#deleteOrt(Ort)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrt() throws Exception {

		List<Ort> ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		ortDAO.deleteOrt(ortsListe.get(0));

		ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 6);

	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#deleteOrtById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteOrtById() throws Exception {
		
		List<Ort> ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		ortDAO.deleteOrtById(ortsListe.get(0).getId());
		
		ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 6);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return lOrt
	 * @throws Exception
	 */
	public static List<Ort> init() throws Exception {
		OrtDAOTest.deleteAll();


		List<Ort> lOrt = new ArrayList<>();
		
		
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));

		
		for(Ort o : lOrt){
			ortDAO.saveOrt(o);
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

		for (Ort o : ortDAO.findAllOrt()) {
			ortDAO.deleteOrt(o);
		}
	}

}

