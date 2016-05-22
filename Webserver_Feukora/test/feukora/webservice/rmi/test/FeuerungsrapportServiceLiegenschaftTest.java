package feukora.webservice.rmi.test;

/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c) Dominik Stirnimann
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import entitys.Waermeerzeuger;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Liegenschaftsmethoden im
 * FeuerungsrapportServiceImpl.
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
		deleteAll();
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#updateLiegenschaft(entitys.Liegenschaft)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdatLiegenschaft() throws Exception {

		List<Liegenschaft> liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 3);

		Ort altOrt = new Ort(6043, "Adligenswil");
		Liegenschaft o = fservice.findLiegenschaftByOrt(altOrt).get(0);
		assertNotNull(o);

		Ort neuOrt = new Ort(8000, "Zürich");
		o.setOrt(neuOrt);

		fservice.updatLiegenschaft(o);

		Liegenschaft t2 = fservice.findLiegenschaftByOrt(neuOrt).get(0);
		assertNotNull(t2);
		assertTrue(t2.getOrt() != altOrt);

		liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 4);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findLiegenschaftByOrt(Ort)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllLiegenschaft() throws Exception {

		List<Liegenschaft> liegenschaftListe = fservice.findAllLiegenschaft();
		assertTrue(liegenschaftListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findLiegenschaftByKontakt(Kontakt)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByKontakt() throws Exception {
		int lplz = 8000;

		Ort lo = fservice.findOrtByPlz(lplz).get(0);

		Kontakt lk = fservice.findKontaktByOrt(lo).get(0);

		List<Liegenschaft> b = fservice.findLiegenschaftByKontakt(lk);
		assertTrue(b.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findLiegenschaftByOrt(Ort)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByOrt() throws Exception {
		int lplz = 8000;

		Ort lo = fservice.findOrtByPlz(lplz).get(0);

		List<Liegenschaft> ll = fservice.findLiegenschaftByOrt(lo);
		assertTrue(ll.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findLiegenschaftByStrasse(String)} .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByStrasse() throws Exception {
		String ls = "Musterweg 456";

		List<Liegenschaft> ll = fservice.findLiegenschaftByStrasse(ls);
		assertTrue(ll.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteLiegenschaft(Liegenschaft)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteLiegenschaft() throws Exception {
		List<Liegenschaft> lListe = fservice.findAllLiegenschaft();
		assertTrue(lListe.size() == 3);

		fservice.deleteLiegenschaft(lListe.get(0));

		lListe = fservice.findAllLiegenschaft();
		assertTrue(lListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteLiegenschaftById(Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteLiegenschaftById() throws Exception {

		List<Liegenschaft> lListe = fservice.findAllLiegenschaft();
		assertTrue(lListe.size() == 3);

		fservice.deleteLiegenschaftById(lListe.get(0).getIdLiegenschaft());

		lListe = fservice.findAllLiegenschaft();
		assertTrue(lListe.size() == 2);
	}
	/**
	 * Initialisiert die Testwerte.
	 * @return
	 * @throws Exception
	 */
	public static List<Liegenschaft> init() throws Exception {

		deleteAll();

		List<Liegenschaft> lLiegenschaft = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		List<Kontakt> lKontakt = new ArrayList<>();

		// 3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));

		// 3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));

		// 3 Feuerungsanlagen
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(0),
				lWaermeerzeuger.get(0), 65));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(1),
				lWaermeerzeuger.get(1), 46));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2),
				lWaermeerzeuger.get(2), 88));

		// 5 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));

		// 4 Kontakte erstellen
		lKontakt.add(new Kontakt("Martina", "Meyer", "Altstrasse 1", lOrt
				.get(2), "0633335577", "m.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christoph", "Müller", "Neustrasse 1", lOrt
				.get(6), "0554445577", "c.m@gmail.com", 1));
		lKontakt.add(new Kontakt("Heiri", "Muster", "Bernstrasse 1", lOrt
				.get(4), "0688885577", "h.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christof", "Meyer", "Gassweg 1", lOrt.get(5),
				"0633335577", "ch.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Hanna", "Putz", "Malweg 5", lOrt.get(4),
				"0637777777", "h.p@gmail.com", 2));
		lKontakt.add(new Kontakt("Martina", "Zäh", "Altstrasse 90",
				lOrt.get(3), "0633888877", "m.z@gmail.com", 2));
		lKontakt.add(new Kontakt("Tina", "Bär", "Waserstrasse 4", lOrt.get(5),
				"0222235577", "t.b@gmail.com", 1));
		lKontakt.add(new Kontakt("Rudolf", "Santa", "Zaubergass 7",
				lOrt.get(1), "0699999997", "r.s@gmail.com", 2));

		// 3 Liegenschaften erstellen
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(0),
				"Hausmeister bei Muster klingeln", "Abcweg 123", lOrt.get(3),
				lFeuerungsanlage.get(0)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(1),
				"07978885599 anrufen bei Ankunft", "Musterweg 456",
				lOrt.get(4), lFeuerungsanlage.get(1)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(2), "Türe ist offen",
				"Musterweg 456", lOrt.get(5), lFeuerungsanlage.get(2)));

		for (Liegenschaft l : lLiegenschaft) {
			fservice.addLiegenschaft(l);
		}
		for (Brenner b : lBrenner) {
			fservice.addBrenner(b);
		}
		for (Waermeerzeuger w : lWaermeerzeuger) {
			fservice.addWaermeerzeuger(w);
		}
		for (Feuerungsanlage f : lFeuerungsanlage) {
			fservice.addFeuerungsanlage(f);
		}
		for (Ort o : lOrt) {
			fservice.addOrt(o);
		}
		for (Kontakt k : lKontakt) {
			fservice.addKontakt(k);
		}
		return lLiegenschaft;

	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllLiegenschaft();

		for (Feuerungsanlage f : fservice.findAllFeuerungsanlage()) {
			fservice.deleteFeuerungsanlage(f);
		}
		for (Brenner b : fservice.findAllBrenner()) {
			fservice.deleteBrenner(b);
		}
		for (Waermeerzeuger w : fservice.findAllWaermeerzeuger()) {
			fservice.deleteWaermeerzeuger(w);
		}
		for (Kontakt k : fservice.findAllKontakt()) {
			fservice.deleteKontakt(k);
		}
		for (Ort o : fservice.findAllOrt()) {
			fservice.deleteOrt(o);
		}
	}

	/**
	 * Löscht alle Liegenschaften.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllLiegenschaft() throws Exception {

		for (Liegenschaft l : fservice.findAllLiegenschaft()) {
			fservice.deleteLiegenschaft(l);
		}
	}
}
