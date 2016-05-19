package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import gruppeB.feukora.persister.AuftragDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;

/**
 * Testet die Funktionalit�t von OrtDAO.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
public class OrtDAOTest {

	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	
	@Before
	public void setUp() throws Exception {
		OrtDAOTest.init();
	}	
	
	@After
	public void tearDown() throws Exception {
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
		
		Ort or = ortDAO.findOrtByBezeichnung("Luzern").get(0);
		assertNotNull(or);
	
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

		ortDAO.deleteOrtById(ortsListe.get(0).getPlz());
		ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 6);
	}
	
	/**
	 * Testet die Methode {@link OrtDAOImpl#updateOrt(Ort)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Ort> ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 7);

		Ort o = ortDAO.findOrtByPlz(5000).get(0);
		
		ortDAO.updateOrt(o);
		
		ortsListe = ortDAO.findAllOrt();
		assertTrue(ortsListe.size() == 6);

	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Ort> init() throws Exception {
		OrtDAOTest.deleteAll();


		List<Ort> lOrt = new ArrayList<>();
		
		
		//5 Orte
		lOrt.add(new Ort(8000, "Z�rich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuch�tel"));
		lOrt.add(new Ort(4000, "Basel"));

		
		for(Ort o : lOrt){
			ortDAO.saveOrt(o);
		}
		
		return lOrt;
	}

	/**
	 * L�scht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllOrt();

		for(Ort o : ortDAO.findAllOrt()){
			ortDAO.deleteOrt(o);
		}
	}

	/**
	 * L�scht alle Auftr�ge aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllOrt() throws Exception {

		for (Ort o : ortDAO.findAllOrt()) {
			ortDAO.deleteOrt(o);
		}
	}

}

