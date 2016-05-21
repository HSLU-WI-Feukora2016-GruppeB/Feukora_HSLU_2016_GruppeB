package testManager;

import static org.junit.Assert.*;
import entitys.Waermeerzeuger;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.WaermeerzeugerManager;
import managerKlassen.WaermeerzeugerManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservice.gruppeB.persister.WaermeerzeugerDAOTest;

/**
 * Diese Klasse ist für das Testen der WaermeerzeugerManager zuständig.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class WaermeerzeugerManagerTest {

	private static WaermeerzeugerManager waermeerzeugerManager = new WaermeerzeugerManagerImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		WaermeerzeugerManagerTest.init();
	}	
	
	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		WaermeerzeugerManagerTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#updateWaermeerzeuger(Waermeerzeuger)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 3);
		
		Waermeerzeuger w = waermeerzeugerManager.findByTyp("qwertz").get(0);
		assertNotNull(w);
		w.setWaermeerzeugerTyp("Pagani");
		
		waermeerzeugerManager.update(w);
		
		Waermeerzeuger aDB = waermeerzeugerManager.findByTyp("Pagani").get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getWaermeerzeugerTyp() != "qwertz");
		
		waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 3);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#deleteWaermeerzeuger(Waermeerzeuger)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 3);

		waermeerzeugerManager.delete(waermeerzeugerListe.get(0));

		waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#deleteWaermeerzeugerById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteWaermeerzeugerById()throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 3);

		waermeerzeugerManager.deleteById(waermeerzeugerListe.get(0).getIdWaermeerzeuger());

		waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findWaermeerzeugerByBaujahr(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBaujahr() throws Exception {
		
		int baujahr = 2010;
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findByBaujahr(baujahr);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findByTyp(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByTyp() throws Exception {
		
		String typ = "qwertz";
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findByTyp(typ);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findWaermeerzeugerByBrennstoff(int)}.
	 * @throws Exception
	 */
	@Test
	public void testFindWaermeerzeugerByBrennstoff() throws Exception {
		
		int brennstoff = 2;
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findByBrennstoff(brennstoff);
		assertTrue(waermeerzeugerListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link WaermeerzeugerDAOImpl#findAllWaermeerzeuger()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllWaermeerzeuger() throws Exception {
		
		List<Waermeerzeuger> waermeerzeugerListe = waermeerzeugerManager.findAll();
		assertTrue(waermeerzeugerListe.size() == 3);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @return
	 * @throws Exception
	 */
	public static List<Waermeerzeuger> init() throws Exception{
		
		WaermeerzeugerManagerTest.deleteAll();
		
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		
		//3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerManager.add(w);
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

		for (Waermeerzeuger w : waermeerzeugerManager.findAll()) {
			waermeerzeugerManager.delete(w);
		}
	}
	
}
