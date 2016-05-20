package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Auftrag;
import entitys.Benutzer;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Messung;
import entitys.Mitarbeiter;
import entitys.Ort;
import entitys.Waermeerzeuger;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Liegenschaftsmethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceLiegenschaftTest {

	static FeuerungsrapportService fservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fservice = new FeuerungsrapportServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		init();
	}
		
	@After
	public void tearDown() throws Exception {
		deleteAll();
	}
	
	@Test
	public void testAddLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLiegenschaftById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLiegenschaftByKontakt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLiegenschaftByOrt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLiegenschaftByStrasse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLiegenschaftById() {
		fail("Not yet implemented");
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllLiegenschaft();
		
		for(Feuerungsanlage f : fservice.findAllFeuerungsanlage()){
			fservice.deleteFeuerungsanlage(f);
		}
		for(Brenner b : fservice.findAllBrenner()){
			fservice.deleteBrenner(b);
		}
		for(Waermeerzeuger w : fservice.findAllWaermeerzeuger()){
			fservice.deleteWaermeerzeuger(w);
		}
		for(Mitarbeiter m : fservice.findAllMitarbeiter()){
			fservice.deleteMitarbeiter(m);
		}
		for(Benutzer b : fservice.findAllBenutzer()){
			fservice.deleteBenutzer(b);
		}
		for(Kontakt k : fservice.findAllKontakte()){
			fservice.deleteKontakt(k);
		}
		for(Ort o : fservice.findAllOrt()){
			fservice.deleteOrt(o);
		}
		for(Messung m : fservice.findAllMessung()){
			fservice.deleteMessung(m);
		}
	}

	/**
	 * Löscht alle Liegenschaften.
	 * @throws Exception
	 */
	public static void deleteAllLiegenschaft() throws Exception {
			
		for(Liegenschaft l : fservice.findAllLiegenschaft()){
				fservice.deleteLiegenschaft(l);
		}
	}
}
