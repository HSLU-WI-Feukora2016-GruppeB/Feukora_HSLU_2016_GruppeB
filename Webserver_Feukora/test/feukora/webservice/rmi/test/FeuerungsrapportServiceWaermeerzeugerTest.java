package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Waermeerzeugermethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceWaermeerzeugerTest {

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
	
	@Test
	public void testUpdateWaermeerzeuger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllWaermeerzeuger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWaermeerzeugerByTyp() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWaermeerzeugerByBrennstoff() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWaermeerzeugerByBaujahr() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteWaermeerzeuger() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteWaermeerzeugerById() {
		fail("Not yet implemented");
	}

}
