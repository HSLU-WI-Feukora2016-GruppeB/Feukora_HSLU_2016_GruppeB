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
 * Diese Klasse Testet die Funktionalität der Messungsmethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Dominik
 * @version 1.0
<<<<<<< HEAD
 * @since 1.0
=======
 * @since 1.0.0
>>>>>>> refs/remotes/origin/master
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
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		init();
	}

	/**
	 * Schliesst Test ab.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		//deleteAll();
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#updateMessung(Messung)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateMessung() throws Exception {

		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 10);

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
		assertTrue(messungsListe.size() == 10);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllMessung()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllMessung() throws Exception {

		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 10);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findMessungByDatum(GregorianCalendar)}
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindMessungByDatum() throws Exception {

		GregorianCalendar d = new GregorianCalendar(2011, 7, 3);
		List<Messung> m = fservice.findMessungByDatum(d);

		assertNotNull(m);
		assertEquals(1, m.size());
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteMessung(Messung)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteMessung() throws Exception {

		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 10);

		fservice.deleteMessung(messungsListe.get(0));

		messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 9);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteMessungById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteMessungById() throws Exception {

		List<Messung> messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 10);

		fservice.deleteMessungById(messungsListe.get(0).getIdMessung());

		messungsListe = fservice.findAllMessung();
		assertTrue(messungsListe.size() == 9);
	}

	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * 
	 * @return lMessungDB
	 * @throws Exception
	 */
	public static List<Messung> init() throws Exception {

		deleteAll();

		List<Messung> lMessung = new ArrayList<>();

		// 8 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true,
				4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8,
				false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8,
				false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 5555, 8888, true,
				9000, 8000, 4000, 3000, 2999, 5000));
		lMessung.add(new Messung(new GregorianCalendar(2014, 2, 9), 4, 8, true,
				4, 130, 60, 200, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2015, 1, 10), 4, 8,
				false, 4, 140, 99, 150, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2016, 6, 29), 4, 8,
				false, 4, 133, 100, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2009, 7, 30), 4, 8,
				true, 4, 150, 60, 55, 9, 5));
		lMessung.add(new Messung(new GregorianCalendar(2013, 8, 31), 4, 8,
				false, 4, 150, 44, 70, 3, 49));
		lMessung.add(new Messung(new GregorianCalendar(2014, 12, 5), 4, 8,
				false, 4, 99, 67, 70, 3, 389));

		for (Messung m : lMessung) {
			fservice.addMessung(m);
		}

		List<Messung> lMessungDB = fservice.findAllMessung();

		return lMessungDB;
	}

	/**
	 * Loescht alle Objekte.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllMessungen();
	}

	/**
	 * Loescht alle Messungs-Objekte.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllMessungen() throws Exception {

		for (Messung m : fservice.findAllMessung()) {
			fservice.deleteMessung(m);
		}
	}
}
