package feukora.webservice.rmi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entitys.*;

import java.util.*;

import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionalität der Auftragsmethoden im
 * FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 */
public class FeuerungsrapportServiceAuftragTest {

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
	 * {@link FeuerungsrapportServiceImpl#updateAuftrag(Auftrag)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateAuftrag() throws Exception {
		List<Auftrag> auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		Ort o = fservice.findOrtByPlz(5000).get(0);
		Kontakt k = fservice.findKontaktByOrt(o).get(0);
		Liegenschaft l = fservice.findLiegenschaftByKontakt(k).get(0);
		Auftrag a = fservice.findAuftragByLiegenschaft(l).get(0);
		assertNotNull(a);

		Liegenschaft lnew = fservice.findAllLiegenschaft().get(1);
		a.setLiegenschaft(lnew);

		fservice.updateAuftrag(a);

		Auftrag aDB = fservice.findAuftragByLiegenschaft(lnew).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getLiegenschaft() != l);

		auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#deleteAuftrag(Auftrag)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteAuftrag() throws Exception {

		List<Auftrag> auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		fservice.deleteAuftrag(auftragsListe.get(0));

		auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAllAuftrag()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllAuftrag() throws Exception {

		List<Auftrag> auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByMitarbeiter(Mitarbeiter)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAuftragByMitarbeiter() throws Exception {

		Mitarbeiter ma = fservice.findMitarbeiterByName("Stirnimann").get(0);
		List<Auftrag> al = fservice.findAuftragByMitarbeiter(ma);

		assertNotNull(al);
		assertTrue(al.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByKontakt(Kontakt)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAuftragByKontakt() throws Exception {

		Kontakt k = fservice.findKontaktByName("Meyer").get(0);
		List<Auftrag> al = fservice.findAuftragByKontakt(k);

		assertNotNull(al);
		assertTrue(al.size() == 1);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByLiegenschaft(Liegenschaft)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAuftragByLiegenschaft() throws Exception {

		Liegenschaft liegenschaft = fservice.findLiegenschaftByStrasse(
				"Musterweg 456").get(0);
		assertNotNull(liegenschaft);

		List<Auftrag> aList = fservice.findAuftragByLiegenschaft(liegenschaft);
		assertTrue(aList.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByDatum(GregorianCalendar)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAuftragByDatum() throws Exception {

		GregorianCalendar d = new GregorianCalendar(2016, 9, 11);
		List<Auftrag> al = fservice.findAuftragByDatum(d);

		assertNotNull(al);
		assertTrue(al.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByAuftragsNummer(Integer)}
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteAuftragById() throws Exception {

		List<Auftrag> auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		fservice.deleteAuftragById(auftragsListe.get(0).getAuftragsNummer());

		auftragsListe = fservice.findAllAuftrag();
		assertTrue(auftragsListe.size() == 2);
	}

	/**
	 * Dieser Test tested die Methode
	 * {@link FeuerungsrapportServiceImpl#findAuftragByDateAndMitarbeiter(GregorianCalendar, GregorianCalendar, Mitarbeiter)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAuftragByDateAndMitarbeiter() throws Exception {

		GregorianCalendar ds = new GregorianCalendar(2016, 05, 1);
		GregorianCalendar de = new GregorianCalendar(2018, 10, 11);
		Mitarbeiter m = fservice.findMitarbeiterByNameVorname("Stirnimann",
				"Dominik").get(0);

		assertNotNull(ds);
		assertNotNull(de);
		assertNotNull(m);

		List<Auftrag> auftraege = fservice.findAuftragByDateAndMitarbeiter(ds,
				de, m);
		assertTrue(auftraege.size() == 1);
	}

	/**
	 * Initialisiert die Testwerte
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Auftrag> init() throws Exception {
		deleteAll();

		List<Benutzer> lBenutzer = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Kontakt> lKontakt = new ArrayList<>();
		List<Liegenschaft> lLiegenschaft = new ArrayList<>();
		List<Messung> lMessung = new ArrayList<>();
		List<Mitarbeiter> lMitarbeiter = new ArrayList<>();
		List<Auftrag> lAuftrag = new ArrayList<>();

		// 6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));

		for (Benutzer b : lBenutzer) {
			fservice.addBenutzer(b);
		}

		List<Benutzer> lBenutzerDB = fservice.findAllBenutzer();

		// 3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));

		for (Brenner br : lBrenner) {
			fservice.addBrenner(br);
		}

		List<Brenner> lBrennerDB = fservice.findAllBrenner();

		// 3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));

		for (Waermeerzeuger w : lWaermeerzeuger) {
			fservice.addWaermeerzeuger(w);
		}

		List<Waermeerzeuger> lWaermeerzeugerDB = fservice
				.findAllWaermeerzeuger();

		// 3 Feuerungsanlagen
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(0),
				lWaermeerzeugerDB.get(0), 65));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(1),
				lWaermeerzeugerDB.get(1), 46));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrennerDB.get(2),
				lWaermeerzeugerDB.get(2), 88));

		for (Feuerungsanlage f : lFeuerungsanlage) {
			fservice.addFeuerungsanlage(f);
		}

		List<Feuerungsanlage> lFeuerungsanlageDB = fservice
				.findAllFeuerungsanlage();

		// 5 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));

		for (Ort o : lOrt) {
			fservice.addOrt(o);
		}

		List<Ort> lOrtDB = fservice.findAllOrt();

		// 8 Kontakte erstellen
		lKontakt.add(new Kontakt("Martina", "Meyer", "Altstrasse 1", lOrtDB
				.get(2), "0633335577", "m.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christoph", "Müller", "Neustrasse 1", lOrtDB
				.get(6), "0554445577", "c.m@gmail.com", 1));
		lKontakt.add(new Kontakt("Heiri", "Muster", "Bernstrasse 1", lOrtDB
				.get(4), "0688885577", "h.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christof", "Meyer", "Gassweg 1", lOrtDB
				.get(5), "0633335577", "ch.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Hanna", "Putz", "Malweg 5", lOrtDB.get(4),
				"0637777777", "h.p@gmail.com", 2));
		lKontakt.add(new Kontakt("Martina", "Zäh", "Altstrasse 90", lOrtDB
				.get(3), "0633888877", "m.z@gmail.com", 2));
		lKontakt.add(new Kontakt("Tina", "Bär", "Waserstrasse 4",
				lOrtDB.get(5), "0222235577", "t.b@gmail.com", 1));
		lKontakt.add(new Kontakt("Rudolf", "Santa", "Zaubergass 7", lOrtDB
				.get(1), "0699999997", "r.s@gmail.com", 2));

		for (Kontakt k : lKontakt) {
			fservice.addKontakt(k);
		}

		List<Kontakt> lKontaktDB = fservice.findAllKontakt();

		// 3 Liegenschaften erstellen
		lLiegenschaft.add(new Liegenschaft(lKontaktDB.get(0),
				"Hausmeister bei Muster klingeln", "Abcweg 123", lOrtDB.get(3),
				lFeuerungsanlageDB.get(0)));
		lLiegenschaft.add(new Liegenschaft(lKontaktDB.get(1),
				"07978885599 anrufen bei Ankunft", "Musterweg 456", lOrtDB
						.get(4), lFeuerungsanlageDB.get(1)));
		lLiegenschaft.add(new Liegenschaft(lKontaktDB.get(2), "Türe ist offen",
				"Musterweg 456", lOrtDB.get(5), lFeuerungsanlageDB.get(2)));

		for (Liegenschaft l : lLiegenschaft) {
			fservice.addLiegenschaft(l);
		}

		List<Liegenschaft> lLiegenschaftDB = fservice.findAllLiegenschaft();

		// 8 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true,
				4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8,
				false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8,
				false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true,
				4, 111, 22, 99, 3, 5));
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

		// 6 Mitarbeiter erstellen
		lMitarbeiter.add(new Mitarbeiter("Olivia", "Wassmer",
				"Musterstrasse 1", lOrtDB.get(3), "1234567678",
				"o.w@feukora.ch", 1, lBenutzerDB.get(5), 5000,
				new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018,
						8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Matthias", "Perrollaz",
				"Musterstrasse 2", lOrtDB.get(4), "1234557678",
				"m.p@feukora.ch", 2, lBenutzerDB.get(4), 5000,
				new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018,
						8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Dominik", "Stirnimann",
				"Musterstrasse 3", lOrtDB.get(3), "1234367678",
				"d.s@feukora.ch", 1, lBenutzerDB.get(3), 5000,
				new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018,
						8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Pascal", "Steiner",
				"Musterstrasse 4", lOrtDB.get(2), "1234567678",
				"p.st@feukora.ch", 1, lBenutzerDB.get(2), 5000,
				new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018,
						8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Luca", "Raneri", "Musterstrasse 5",
				lOrtDB.get(1), "1234567178", "l.r@feukora.ch", 1, lBenutzerDB
						.get(1), 5000, new GregorianCalendar(2016, 05, 1),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Alexandra", "Lengen",
				"Musterstrasse 1", lOrtDB.get(0), "1234563678",
				"a.l@feukora.ch", 1, lBenutzerDB.get(5), 5000,
				new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018,
						8, 11)));

		for (Mitarbeiter m : lMitarbeiter) {
			fservice.addMitarbeiter(m);
		}

		List<Mitarbeiter> lMitarbeiterDB = fservice.findAllMitarbeiter();

		// 3 Aufträge erstellen
		lAuftrag.add(new Auftrag(lKontaktDB.get(0), lLiegenschaftDB.get(0),
				lMessungDB.get(0), lMessungDB.get(1), lMessungDB.get(2),
				lMessungDB.get(3), true, false, "Keine", lMitarbeiterDB.get(0),
				new GregorianCalendar(2016, 9, 11), 1, 1));
		lAuftrag.add(new Auftrag(lKontaktDB.get(1), lLiegenschaftDB.get(1),
				lMessungDB.get(4), lMessungDB.get(2), lMessungDB.get(5),
				lMessungDB.get(3), true, false,
				"Bekommen demnächst neue Heizung", lMitarbeiterDB.get(2),
				new GregorianCalendar(2016, 9, 18), 1, 1));
		lAuftrag.add(new Auftrag(lKontaktDB.get(2), lLiegenschaftDB.get(1),
				lMessungDB.get(6), lMessungDB.get(7), lMessungDB.get(8),
				lMessungDB.get(9), false, true,
				"Komplett verrostet, geht nicht ohne neue Anlage",
				lMitarbeiterDB.get(3), new GregorianCalendar(2016, 9, 11), 2, 2));

		for (Auftrag a : lAuftrag) {
			fservice.addAuftrag(a);
		}

		List<Auftrag> lAuftragDB = fservice.findAllAuftrag();

		return lAuftragDB;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * 
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllAuftrag();

		for (Liegenschaft l : fservice.findAllLiegenschaft()) {
			fservice.deleteLiegenschaft(l);
		}
		for (Feuerungsanlage f : fservice.findAllFeuerungsanlage()) {
			fservice.deleteFeuerungsanlage(f);
		}
		for (Brenner b : fservice.findAllBrenner()) {
			fservice.deleteBrenner(b);
		}
		for (Waermeerzeuger w : fservice.findAllWaermeerzeuger()) {
			fservice.deleteWaermeerzeuger(w);
		}
		for (Mitarbeiter m : fservice.findAllMitarbeiter()) {
			fservice.deleteMitarbeiter(m);
		}
		for (Benutzer b : fservice.findAllBenutzer()) {
			fservice.deleteBenutzer(b);
		}
		for (Kontakt k : fservice.findAllKontakt()) {
			fservice.deleteKontakt(k);
		}
		for (Ort o : fservice.findAllOrt()) {
			fservice.deleteOrt(o);
		}
		for (Messung m : fservice.findAllMessung()) {
			fservice.deleteMessung(m);
		}
	}

	/**
	 * Löscht alle Aufträge.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllAuftrag() throws Exception {

		for (Auftrag a : fservice.findAllAuftrag()) {
			fservice.deleteAuftrag(a);
		}
	}

}
