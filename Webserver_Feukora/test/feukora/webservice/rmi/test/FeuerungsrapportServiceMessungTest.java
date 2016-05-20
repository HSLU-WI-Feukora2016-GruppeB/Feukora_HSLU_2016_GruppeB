package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Messung;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Messungsmethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceMessungTest {

	static FeuerungsrapportService fservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fservice = new FeuerungsrapportServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initialisiert die Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		init();
	}
	
	/**
	 * Schliesst Test ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		deleteAll();
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#updateMessung(Messung)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdateMessung() throws Exception{
		
		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 4);
		
		GregorianCalendar altDatum = new GregorianCalendar(2011, 7, 3);
		Messung m = fservice.findMessungByDatum(altDatum).get(0);
		assertNotNull(m);
		
		GregorianCalendar neuDatum = new GregorianCalendar(2016, 5, 18);
		m.setMessDatum(neuDatum);
		
		fservice.updateMessung(m);
		
		Messung aDB = fservice.findMessungByDatum(neuDatum).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getMessDatum() != altDatum);
		
		messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 4);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findAllMessung()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllMessung() throws Exception {
		
		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 4);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMessungByDatum(GregorianCalendar)}
	 * @throws Exception
	 */
	@Test
	public void testFindMessungByDatum() throws Exception {
		
		GregorianCalendar d = new GregorianCalendar(2011, 7, 3);
		List<Messung> m = fservice.findMessungByDatum(d);
		
		assertNotNull(m);
		assertEquals(1,m.size());
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#findMessungByBeurteilungNotOk(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testFindMessungByBeurteilungNotOk() throws Exception {

		List<Messung> m = fservice.findMessungByBeurteilungNotOk(true);
		
		assertNotNull(m);
		assertEquals(1,m.size());
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#deleteMessung(Messung)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMessung() throws Exception {
		
		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 4);

		fservice.deleteMessung(messungsListe.get(0));

		messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode {@link FeuerungsrapportServiceImpl#deleteMessungById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteMessungById() throws Exception {
		
		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 4);

		fservice.deleteMessungById(messungsListe.get(0).getIdMessung());

		messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 3);
	}

	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * @return
	 * @throws Exception
	 */
	public static List<Messung> init() throws Exception {
		
		deleteAll();
		
		List<Messung> lMessung = new ArrayList<>();
				
		//4 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true, 4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8, false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8, false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true, 4, 111, 22, 99, 3, 5));
		lMessung.get(0).setBeurteilungNotOk(true);
		
		for(Messung m : lMessung){
			fservice.addMessung(m);
		}
		
		return lMessung;
	}	
		
	/**
	 * Loescht alle Objekte.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllMessungen();
	}

	/**
	 * Loescht alle Messungs-Objekte.
	 * @throws Exception
	 */
	public static void deleteAllMessungen() throws Exception {

		for (Messung m : fservice.findAllMessung()) {
			fservice.deleteMessung(m);
		}
	}
}
