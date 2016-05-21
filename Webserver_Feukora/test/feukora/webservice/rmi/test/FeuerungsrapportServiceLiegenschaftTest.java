package feukora.webservice.rmi.test;

/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Dominik Stirnimann
 */

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.List;

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
 * @author Dominik
 * 
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

	/**
	 * Initialisiert die Testwerten.
	 * @throws Exception
	 */
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
	public void testUpdatLiegenschaft() throws Exception{
		
		List<Liegenschaft> liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 3);
		
		Ort altOrt = new Ort(6043,"Adligenswil");
		Liegenschaft o = fservice.findLiegenschaftByOrt(altOrt).get(0);
		assertNotNull(o);
		
		Ort neuOrt = new Ort(8000,"Zürich");
		o.setOrt(neuOrt);
		
		fservice.updatLiegenschaft(o);
		
		Liegenschaft t2 = fservice.findLiegenschaftByOrt(neuOrt).get(0);
		assertNotNull(t2);
		assertTrue(t2.getOrt() != altOrt);
		
		liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 4);
	}

	@Test
	public void testFindAllLiegenschaft() throws Exception {
		
		List<Liegenschaft> liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 3);
	}

	@Test
	public void testFindLiegenschaftById() throws Exception{
		fail("Not yet implemented");
		}

	@Test
	public void testFindLiegenschaftByKontakt() throws Exception {
		int lplz = 8000;
		Ort lo = fservice.findOrtByPlz(lplz).get(0);
		
		Kontakt lk = fservice.findKontaktByOrt(lo).get(0);
		
		List<Liegenschaft> b = fservice.findLiegenschaftByKontakt(lk);
		assertTrue(b.size() == 1);
	}

	@Test
	public void testFindLiegenschaftByOrt() {
			int lplz = 8000;
			Ort lo = fservice.findOrtByPlz(lplz).get(0);
			fservice.findLiegenschaftByOrt(lo)
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
		for(Kontakt k : fservice.findAllKontakt()){
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
