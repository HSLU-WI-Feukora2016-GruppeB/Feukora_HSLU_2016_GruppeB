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
 * Diese Klasse Testet die Funktionalität der Auftragmethoden im FeuerungsrapportServiceImpl.
 * 
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 */
public class FeuerungsrapportServiceAuftragTest {

	static FeuerungsrapportService fservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fservice = new FeuerungsrapportServiceImpl();
		//FeuerungsrapportServiceTest.init();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deleteAll();
	}
		
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddAuftrag() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAuftrag() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAuftrag() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllAuftrag() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByMitarbeiter() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByKontakt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByLiegenschaft() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByAuftragsNummer() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByDatum() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAuftragById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuftragByDateAndMitarbeiter() {
		fail("Not yet implemented");
	}
	
	/**
	 * Initialisiert die Testwerte
	 * @return
	 * @throws Exception
	 */
	public static List<Auftrag> init() throws Exception {
		deleteAll();
		
		List<Benutzer> lBenutzer = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Kontakt> lKontakt = new ArrayList<>();
		List<Liegenschaft> lLiegenschaft = new ArrayList<>();
		List<Messung> lMessung = new ArrayList<>();
		List<Mitarbeiter> lMitarbeiter = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		List<Auftrag> lAuftrag = new ArrayList<>();
		
		//6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		
		
		//3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));
		
		//3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));
	
		//3 Feuerungsanlagen
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(0), lWaermeerzeuger.get(0)));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(1), lWaermeerzeuger.get(1)));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2)));

		//5 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));
		
		//4 Kontakte erstellen
		lKontakt.add(new Kontakt("Martina", "Meyer", "Altstrasse 1", lOrt.get(2), "0633335577", "m.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christoph", "Müller", "Neustrasse 1", lOrt.get(6), "0554445577", "c.m@gmail.com", 1));
		lKontakt.add(new Kontakt("Heiri", "Muster", "Bernstrasse 1", lOrt.get(4), "0688885577", "h.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christof", "Meyer", "Gassweg 1", lOrt.get(5), "0633335577", "ch.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Hanna", "Putz", "Malweg 5", lOrt.get(4), "0637777777", "h.p@gmail.com", 2));
		lKontakt.add(new Kontakt("Martina", "Zäh", "Altstrasse 90", lOrt.get(3), "0633888877", "m.z@gmail.com", 2));
		lKontakt.add(new Kontakt("Tina", "Bär", "Waserstrasse 4", lOrt.get(5), "0222235577", "t.b@gmail.com", 1));
		lKontakt.add(new Kontakt("Rudolf", "Santa", "Zaubergass 7", lOrt.get(1), "0699999997", "r.s@gmail.com", 2));
		
		//3 Liegenschaften erstellen
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(0), "Hausmeister bei Muster klingeln", "Abcweg 123", lOrt.get(3),lFeuerungsanlage.get(0)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(1), "07978885599 anrufen bei Ankunft", "Musterweg 456", lOrt.get(4),lFeuerungsanlage.get(1)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(2), "Türe ist offen", "Musterweg 456", lOrt.get(5),lFeuerungsanlage.get(2)));
		
		//8 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true, 4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8, false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8, false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true, 4, 111, 22, 99, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2014, 2, 9), 4, 8, true, 4, 130, 60, 200, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2015, 1, 10), 4, 8, false, 4, 140, 99, 150, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2016, 6, 29), 4, 8, false, 4, 133, 100, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2009, 7, 30), 4, 8, true, 4, 150, 60, 55, 9, 5));
		lMessung.add(new Messung(new GregorianCalendar(2013, 8, 31), 4, 8, false, 4, 150, 44, 70, 3, 49));
		lMessung.add(new Messung(new GregorianCalendar(2014, 12, 5), 4, 8, false, 4, 99, 67, 70, 3, 389));
		
		//6 Mitarbeiter erstellen
		lMitarbeiter.add(new Mitarbeiter("Olivia", "Wassmer", "Musterstrasse 1", lOrt.get(3), "1234567678", "o.w@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Matthias", "Perrollaz", "Musterstrasse 2", lOrt.get(4), "1234557678", "m.p@feukora.ch", 2, lBenutzer.get(4), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Dominik", "Stirnimann", "Musterstrasse 3", lOrt.get(3), "1234367678", "d.s@feukora.ch", 1, lBenutzer.get(3), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Pascal", "Steiner", "Musterstrasse 4", lOrt.get(2), "1234567678", "p.st@feukora.ch", 1, lBenutzer.get(2), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Luca", "Raneri", "Musterstrasse 5", lOrt.get(1), "1234567178", "l.r@feukora.ch", 1, lBenutzer.get(1), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Alexandra", "Lengen", "Musterstrasse 1", lOrt.get(0), "1234563678", "a.l@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		
		//3 Aufträge erstellen
		lAuftrag.add(new Auftrag(lKontakt.get(0), lLiegenschaft.get(0), lMessung.get(0), lMessung.get(1), lMessung.get(2), lMessung.get(3), lMitarbeiter.get(0), new GregorianCalendar(2016, 9, 11), 1, 1));
		lAuftrag.add(new Auftrag(lKontakt.get(1), lLiegenschaft.get(1), lMessung.get(4), lMessung.get(2), lMessung.get(5), lMessung.get(3), lMitarbeiter.get(2), new GregorianCalendar(2016, 9, 18), 1, 1));
		lAuftrag.add(new Auftrag(lKontakt.get(2), lLiegenschaft.get(1), lMessung.get(6), lMessung.get(7), lMessung.get(8), lMessung.get(9), lMitarbeiter.get(3), new GregorianCalendar(2016, 9, 11), 2, 2));
		
		for(Benutzer b : lBenutzer){
			fservice.addBenutzer(b);
		}
		
		for(Ort o : lOrt){
			fservice.addOrt(o);
		}
		
		for(Brenner b : lBrenner){
			fservice.addBrenner(b);
		}
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			fservice.addWaermeerzeuger(w);
		}
		
		for(Feuerungsanlage f : lFeuerungsanlage){
			fservice.addFeuerungsanlage(f);
		}
		
		for(Kontakt k : lKontakt){
			fservice.addKontakt(k);
		}
		
		for(Liegenschaft l : lLiegenschaft){
			fservice.addLiegenschaft(l);
		}
		
		for(Messung m : lMessung){
			fservice.addMessung(m);
		}
		
		for(Mitarbeiter m : lMitarbeiter){
			fservice.addMitarbeiter(m);
		}
		
		for(Auftrag a : lAuftrag){
			fservice.addAuftrag(a);
		}
		
		return lAuftrag;
	}

	/**
	 * Löscht alle initialisierten Daten.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllAuftrag();
		
		for(Liegenschaft l : fservice.findAllLiegenschaft()){
			fservice.deleteLiegenschaft(l);
		}
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
	 * Löscht alle Aufträge.
	 * @throws Exception
	 */
	public static void deleteAllAuftrag() throws Exception {

		for (Auftrag a : fservice.findAllAuftrag()) {
			fservice.deleteAuftrag(a);
		}
	}

}


