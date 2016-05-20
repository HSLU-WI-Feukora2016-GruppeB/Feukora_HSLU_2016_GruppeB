package testManager;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.AuftragManager;
import managerInterfaces.BenutzerManager;
import managerInterfaces.BrennerManager;
import managerInterfaces.FeuerungsanlageManager;
import managerInterfaces.KontaktManager;
import managerInterfaces.LiegenschaftManager;
import managerInterfaces.MessungsManager;
import managerInterfaces.MitarbeiterManager;
import managerInterfaces.OrtManager;
import managerInterfaces.WaermeerzeugerManager;
import managerKlassen.AuftragManagerImpl;
import managerKlassen.BenutzerManagerImpl;
import managerKlassen.BrennerManagerImpl;
import managerKlassen.FeuerungsanlageManagerImpl;
import managerKlassen.KontaktManagerImpl;
import managerKlassen.LiegenschaftManagerImpl;
import managerKlassen.MessungManagerImpl;
import managerKlassen.MitarbeiterManagerImpl;
import managerKlassen.OrtManagerImpl;
import managerKlassen.WaermeerzeugerManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.*;
import gruppeB.feukora.persister.AuftragDAOImpl;

/**
 * Testet die Funktionalität des AuftragManager.
 * @author Olivia
 * @since 1.0
 * @version 1.0
 *
 */
public class AuftragManagerTest {
	
	private static AuftragManager auftragManager = new AuftragManagerImpl();
	private static BenutzerManager benutzerManager = new BenutzerManagerImpl();
	private static BrennerManager brennerManager = new BrennerManagerImpl();
	private static FeuerungsanlageManager feuerungsanlageManager = new FeuerungsanlageManagerImpl();
	private static KontaktManager kontaktManager = new KontaktManagerImpl();
	private static LiegenschaftManager liegenschaftManager = new LiegenschaftManagerImpl();
	private static MessungsManager messungsManager = new MessungManagerImpl();
	private static MitarbeiterManager mitarbeiterManager = new MitarbeiterManagerImpl();
	private static OrtManager ortManager = new OrtManagerImpl();
	private static WaermeerzeugerManager waermeerzeugerManager = new WaermeerzeugerManagerImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		AuftragManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Testet die Methode {@link AuftragManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Auftrag> auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 3);
	}
	
	/**
	 * Testet die Methode {@link AuftragManagerImpl#findByMitarbeiter(Mitarbeiter)}
	 * @throws Exception
	 */
	@Test
	public void testFindByMitarbeiter() throws Exception {
		
		Mitarbeiter ma = mitarbeiterManager.findByName("Raneri").get(0);
		List<Auftrag> al = auftragManager.findByMitarbeiter(ma);
		
		assertNotNull(al);
		
		assertTrue(al.size() == 0);
	}
	
	/**
	 * Testet die Methode {@link AuftragManagerImpl#findByDatum(GregorianCalendar)}
	 * @throws Exception
	 */
	@Test
	public void testFindByDatum() throws Exception {
		
		GregorianCalendar d = new GregorianCalendar(2016, 9, 11);
		List<Auftrag> al = auftragManager.findByDatum(d);
		
		assertNotNull(al);
		
		assertTrue(al.size() == 2);
	}

	/**
	 * Testet die Methode {@link AuftragManagerImpl#findByKontakt(Kontakt)}
	 * @throws Exception
	 */
	@Test
	public void testFindByKontakt() throws Exception {
		
		Kontakt k = kontaktManager.findByName("Meyer").get(0);
		List<Auftrag> al = auftragManager.findByKontakt(k);
		
		assertNotNull(al);
		
		assertTrue(al.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link AuftragManagerImpl#findByLiegenschaft(Liegenschaft)}
	 * @throws Exception
	 */
	@Test
	public void testFindByLiegenschaft() throws Exception {
		
		Liegenschaft liegenschaft = liegenschaftManager.findByStrasse("Musterweg 456").get(0);
		assertNotNull(liegenschaft);
		
		List<Auftrag> aList = auftragManager.findByLiegenschaft(liegenschaft);
		assertTrue(aList.size() == 2);
		
	}
	

	/**
	 * Testet die Methode {@link AuftragManagerImpl#findByDateAndMitarbeiter(GregorianCalendar, GregorianCalendar, Mitarbeiter)}
	 */
	@Test
	public void testFindByDatumAndMitarbeiter() throws Exception {
		GregorianCalendar ds = new GregorianCalendar(2016, 05, 1);
		GregorianCalendar de = new GregorianCalendar(2018, 10, 11);
		Mitarbeiter m = mitarbeiterManager.findByNameVorname("Stirnimann", "Dominik").get(0);

		assertNotNull(ds);
		assertNotNull(de);
		assertNotNull(m);
		
		List<Auftrag> auftraege = auftragManager.findByDatumAndMitarbeiter(ds, de, m);
		assertTrue(auftraege.size() == 1);
	}
	 
	/**
	 * Testet die Methode {@link AuftragDAOImpl#findAuftragByDateAndMitarbeiterAndZeitslot(GregorianCalendar, Mitarbeiter, int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByDatumAndMitarbeiterAndZeitslot() throws Exception {
		
		GregorianCalendar d = new GregorianCalendar(2016, 9, 18);
		Mitarbeiter m = mitarbeiterManager.findByNameVorname("Stirnimann", "Dominik").get(0);
		int z = 1;
		assertNotNull(d);
		assertNotNull(m);
		assertNotNull(z);
		
		Auftrag auftrag = auftragManager.findAuftragByDateAndMitarbeiterAndZeitslot(d, m, z);
		assertNotNull(auftrag);
		
	}
	
	/**
	 * Testet die Methode {@link AuftragDAOImpl#updateAuftrag(Auftrag)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Auftrag> auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 3);

		Ort o = ortDAO.findOrtByPlz(5000).get(0);
		Kontakt k = kontaktManager.findKontaktByOrt(o).get(0);
		Liegenschaft l = liegenschaftManager.findLiegenschaftByKontakt(k).get(0);
		Auftrag a = auftragManager.findByLiegenschaft(l).get(0);
		assertNotNull(a);
		
		Liegenschaft lnew = liegenschaftManager.findAllLiegenschaft().get(1);
		a.setLiegenschaft(lnew);
		
		auftragManager.updateAuftrag(a);
		
		Auftrag aDB = auftragManager.findByLiegenschaft(lnew).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getLiegenschaft() != l);
		
		auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 3);

	}

	/**
	 * Testet die Methode {@link AuftragDAOImpl#deleteAuftrag(Auftrag)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Auftrag> auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 3);

		auftragManager.deleteAuftrag(auftragsListe.get(0));

		auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 2);

	}

	/**
	 * Testet die Methode {@link AuftragDAOImpl#deleteAuftragById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Auftrag> auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 3);

		auftragManager.deleteAuftragById(auftragsListe.get(0).getAuftragsNummer());

		auftragsListe = auftragManager.findAll();
		assertTrue(auftragsListe.size() == 2);
	}

	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Auftrag> init() throws Exception {
		AuftragManagerTest.deleteAll();
		
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
			benutzerManager.add(b);
		}
		
		for(Ort o : lOrt){
			ortManager.add(o);
		}
		
		for(Brenner b : lBrenner){
			brennerManager.add(b);
		}
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerManager.add(w);
		}
		
		for(Feuerungsanlage f : lFeuerungsanlage){
			feuerungsanlageManager.add(f);
		}
		
		for(Kontakt k : lKontakt){
			kontaktManager.add(k);
		}
		
		for(Liegenschaft l : lLiegenschaft){
			liegenschaftManager.add(l);
		}
		
		/*Wird nicht benötigt, da Cascade.ALL bei Messung*/
		for(Messung m : lMessung){
			messungsManager.add(m);
		}
		
		for(Mitarbeiter m : lMitarbeiter){
			mitarbeiterManager.add(m);
		}
		
		for(Auftrag a : lAuftrag){
			auftragManager.add(a);
		}
		
		return lAuftrag;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllAuftrag();
		
		for(Liegenschaft l : liegenschaftManager.findAll()){
			liegenschaftManager.delete(l);;
		}
		for(Feuerungsanlage f : feuerungsanlageManager.findAll()){
			feuerungsanlageManager.delete(f);;
		}
		for(Brenner b : brennerManager.findAll()){
			brennerManager.delete(b);;
		}
		for(Waermeerzeuger w : waermeerzeugerManager.findAll()){
			waermeerzeugerManager.delete(w);;
		}
		for(Mitarbeiter m : mitarbeiterManager.findAllMitarbeiter()){
			mitarbeiterManager.delete(m);
		}
		for(Benutzer b : benutzerManager.findAll()){
			benutzerManager.delete(b);
		}
		for(Kontakt k : kontaktManager.findAll()){
			kontaktManager.delete(k);
		}
		for(Ort o : ortManager.findAll()){
			ortManager.delete(o);
		}
		for(Messung m : messungsManager.findAll()){
			messungsManager.delete(m);
		}
	}

	/**
	 * Löscht alle Aufträge aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllAuftrag() throws Exception {

		for (Auftrag a : auftragManager.findAll()) {
			auftragManager.delete(a);
		}
	}

}
