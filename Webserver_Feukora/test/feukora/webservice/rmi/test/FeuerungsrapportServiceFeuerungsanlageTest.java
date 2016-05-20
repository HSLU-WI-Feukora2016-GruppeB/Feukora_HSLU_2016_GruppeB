package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Feuerungsanlagenmethoden im FeuerungsrapportServiceImpl.
 *  
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceFeuerungsanlageTest {

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
	public void testUpdateFeuerungsanlage() {
		
		List<Feuerungsanlage> fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		Feuerungsanlage f = feuerungsanlageDAO.findAllFeuerungsanlage().get(0);
		Brenner bNew = brennerDAO.findAllBrenner().get(2);
		f.setBrenner(bNew);
		
		feuerungsanlageDAO.updateFeuerungsanlage(f);
		
		assertTrue(feuerungsanlageDAO.findAllFeuerungsanlage().size() == 3);
	}

	@Test
	public void testFindAllFeuerungsanlage() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFeuerungsanlageByLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFeuerungsanlageByBrenner() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFeuerungsanlageByWaermeerzeuger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFeuerungsanlageById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteFeuerungsanlage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteFeuerungsanlageById() {
		fail("Not yet implemented");
	}

}
