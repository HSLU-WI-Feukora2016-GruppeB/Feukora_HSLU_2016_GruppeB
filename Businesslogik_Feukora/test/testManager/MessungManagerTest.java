package testManager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.MessungsManager;
import managerKlassen.MessungManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Messung;

/**
 * Diese Klasse ist für das Testen der MessungsManager zuständig.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class MessungManagerTest {

private static MessungsManager messungManager = new MessungManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MessungManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		MessungManagerTest.deleteAll();
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#findAll()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Messung> messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 4);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#findByDatum(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindByMessDatum() throws Exception{
		
		GregorianCalendar d = new GregorianCalendar(2011, 7, 3);
		List<Messung> m = messungManager.findByDatum(d);
		
		assertNotNull(m);
		assertEquals(1,m.size());
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#findByBeurteilungNotOk(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testFindByBeurteilungNotOk() throws Exception{
				
		List<Messung> m = messungManager.findByBeurteilungNotOk(true);
		
		assertNotNull(m);
		assertEquals(1,m.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#update(Messung)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
	
		List<Messung> messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 4);
		
		GregorianCalendar altDatum = new GregorianCalendar(2011, 7, 3);
		Messung m = messungManager.findByDatum(altDatum).get(0);
		assertNotNull(m);
		
		GregorianCalendar neuDatum = new GregorianCalendar(2016, 5, 18);
		m.setMessDatum(neuDatum);
		
		messungManager.update(m);
		
		Messung aDB = messungManager.findByDatum(neuDatum).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getMessDatum() != altDatum);
		
		messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 4);
	}

	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#delete(Messung)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
	
		List<Messung> messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 4);
	
		messungManager.delete(messungsListe.get(0));
	
		messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 3);
	
	}

	/**
	 * Dieser Test tested die Methode {@link MessungManagerImpl#deleteById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Messung> messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 4);

		messungManager.deleteById(messungsListe.get(0).getIdMessung());

		messungsListe = messungManager.findAll();
		assertTrue(messungsListe.size() == 3);
	}
	
	
	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * @return
	 * @throws Exception
	 */
	public static List<Messung> init() throws Exception {
		
		MessungManagerTest.deleteAll();
		
		List<Messung> lMessung = new ArrayList<>();
				
		//4 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true, 4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8, false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8, false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true, 4, 111, 22, 99, 3, 5));
		lMessung.get(0).setBeurteilungNotOk(true);
		
		for(Messung m : lMessung){
			messungManager.add(m);
		}
		
		return lMessung;
	}
	
	/**
	 * Loescht alle Objekte aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllMessungen();
	}

	/**
	 * Loescht alle Messungs-Objekte aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllMessungen() throws Exception {

		for (Messung m : messungManager.findAll()) {
			messungManager.delete(m);
		}
	}

}
