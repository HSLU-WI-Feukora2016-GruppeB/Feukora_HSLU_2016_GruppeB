package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import entitys.Waermeerzeuger;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der WaermeerzeugerDAO-Implementierung zuständig.
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 */
public class WaermeerzeugerDAOTest {

	private static WaermeerzeugerDAOImpl waermeerzeugerDAO = new WaermeerzeugerDAOImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		WaermeerzeugerDAOTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		WaermeerzeugerDAOTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#updateWaermeerzeuger(Waermeerzeuger)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);
		
		Waermeerzeuger w = waermeerzeugerDAO.findByTyp("qwertz").get(0);
		assertNotNull(w);
		w.setWaermeerzeugerTyp("Pagani");
		
		waermeerzeugerDAO.updateWaermeerzeuger(w);
		
		Waermeerzeuger aDB = waermeerzeugerDAO.findByTyp("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getWaermeerzeugerTyp() != "qwertz");
		
		waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#deleteWaermeerzeuger(Waermeerzeuger)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);

		waermeerzeugerDAO.deleteWaermeerzeuger(waermeerzeugerListe.get(0));

		waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#deleteWaermeerzeugerById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeugerById()throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);

		waermeerzeugerDAO.deleteWaermeerzeugerById(waermeerzeugerListe.get(0).getIdWaermeerzeuger());

		waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findWaermeerzeugerByBaujahr(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBaujahr() throws Exception {
		
		int baujahr = 2010;
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findWaermeerzeugerByBaujahr(baujahr);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findByTyp(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByTyp() throws Exception {
		
		String typ = "qwertz";
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findByTyp(typ);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findWaermeerzeugerByBrennstoff(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBrennstoff() throws Exception {
		
		int brennstoff = 2;
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findWaermeerzeugerByBrennstoff(brennstoff);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findAllWaermeerzeuger()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerDAO.findAllWaermeerzeuger();
		assertTrue(waermeerzeugerListe.size() == 3);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @return
	 * @throws Exception
	 */
	public static List<Waermeerzeuger> init() throws Exception{
		
		WaermeerzeugerDAOTest.deleteAll();
		
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		
		//3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerDAO.saveWaermeerzeuger(w);
		}
				
		return lWaermeerzeuger;
	}
	
	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {
		
		deleteAllWaermeerzeuger();
	}
	
	/**
	 * Löscht alle Waermeerzeuger aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllWaermeerzeuger() throws Exception {

		for (Waermeerzeuger w : waermeerzeugerDAO.findAllWaermeerzeuger()) {
			waermeerzeugerDAO.deleteWaermeerzeuger(w);
		}
	}
	
}

