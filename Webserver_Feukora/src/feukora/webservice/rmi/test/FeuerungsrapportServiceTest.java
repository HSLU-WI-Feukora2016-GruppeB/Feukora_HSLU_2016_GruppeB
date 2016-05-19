package feukora.webservice.rmi.test;

/*
 * ZWECK: Test der FeuerungsrapportService Klasse
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
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
 * Diese Klasse Testet die Funktionen von FeuerungsrapportService 
 * (WebService-Schnittstelle) auf Fehler.
 * 
 * @author Dominik
 * @version 1.0.0
 * @since 1.0.0
 * 
 */

public class FeuerungsrapportServiceTest {
	
		static FeuerungsrapportService fservice;


		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			fservice = new FeuerungsrapportServiceImpl();
			FeuerungsrapportServiceTest.init();
			
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
			
			//Entitäten
			for (Waermeerzeuger w : fservice.findAllWaermeerzeuger()) {
				fservice.deleteWaermeerzeuger(w);
			}

			for (Brenner b : fservice.findAllBrenner()) {
				fservice.deleteBrenner(b);
			}

			for (Feuerungsanlage f : fservice.findAllFeuerungsanlage()) {
				fservice.deleteFeuerungsanlage(f);
			}
		}
		@After
		public void tearDown() throws Exception {
		}
				/*
				 * Mögliche Tests:
				 * 
				 * 1. Datensatz einfügen-kontorlle ob dieser eingefügt wurde
				 * 
				 * 2. Datensatz löschen - kontrolle ob dieser gelöscht wurde. - 
				 * Darf im Datenbestand nicht mehr vorhanden sein.,
				 *
				 *3. Abruf von Datensatz bsp. Liegenschaft durch 2 verschiede arten,
				 *vergleich ob diese identisch sind oder nicht	
				 *
				 *4. Abruf von Datensatz aufgrund weiterem Kriterium welches mit ERD verknüpft ist.
				 *Vergleich auf Grösse der Listen per Hardcoding
				 *
				 *
				 */

		@Test
		public void testFindAllAuftrag() throws Exception{
			List<Auftrag> auftragsListe = fservice.findAllAuftrag();
			assertTrue(auftragsListe.size() == 3);
		}
		@Test
		public void testFindAuftragByDatum() throws Exception {
			
			GregorianCalendar d = new GregorianCalendar(2016, 9, 11);
			List<Auftrag> al = fservice.findAuftragByDatum(d);
			
			assertNotNull(al);
			
			assertTrue(al.size() == 2);
		}

		@Test
		public void testFindLiegenschaftByStrasse() throws Exception {
			
			Liegenschaft liegenschaft = fservice.findLiegenschaftByStrasse("Musterweg 456").get(0);
			assertNotNull(liegenschaft);
		}
		@Test
		public void testFindAuftragByLiegenschaft() throws Exception {
			Liegenschaft liegenschaft = fservice.findLiegenschaftByStrasse("Musterweg 456").get(0);
			assertNotNull(liegenschaft);
			List<Auftrag> aList = fservice.findAuftragByLiegenschaft(liegenschaft);
			assertTrue(aList.size() == 2);
		}
		
//		@Test
//		public void testTest() throws Exception{
//			Liegenschaft liegenschaftByStrasse = fservice.findLiegenschaftByStrasse("Musterweg 456").get(0);
//			assertNotNull(liegenschaftByStrasse);
//			Liegenschaft liegenschaftByOrt = fservice.findLiegenschaftByOrt("Genf").get(0);
//			assertNotNull(liegenschaftByOrt);
//			
//			assertEquals(liegenschaftByStrasse,liegenschaftByOrt);
//		}
		
		@Test
		public void testAddAuftrag() throws Exception {
			
			Benutzer b = new Benutzer("muster", "test");
			Brenner br = new Brenner(1, "lalala33", 2017);
			Waermeerzeuger w = new Waermeerzeuger(2, "lilalal", 2012);
			Feuerungsanlage f = new Feuerungsanlage(br, w);
			Ort o = new Ort(8000, "Zürich");
			Kontakt k = new Kontakt("Peter", "Musti", "TheStreet 1", o, "0000000000", "t.t@gmail.com", 1);
			Liegenschaft l = new Liegenschaft(k, "Added", "Test 456", o, f);
			Messung m = new Messung(new GregorianCalendar(2077, 7, 3), 4, 8, false, 4, 500, 60, 120, 3, 5);
			Mitarbeiter ma = new Mitarbeiter("Tini", "Little", "Kleinstrasse 1", o, "9999999999", "test@feukora.ch", 1, b, 5000, new GregorianCalendar(2099, 05, 1), new GregorianCalendar(2088, 8, 11));
			Auftrag a = new Auftrag(k, l, m, m, m, m, ma, new GregorianCalendar(2066, 9, 11), 2, 2);
			
			try {
				fservice.addAuftrag(a);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Auftrag> auftragListe = fservice.findAllAuftrag();
			assertTrue(auftragListe.size() == 3);
		}

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

		@Test
		public void testDelete() throws Exception {

			List<Auftrag> auftragsListe = fservice.findAllAuftrag();
			assertTrue(auftragsListe.size() == 3);

			fservice.deleteAuftrag(auftragsListe.get(0));

			auftragsListe = fservice.findAllAuftrag();
			assertTrue(auftragsListe.size() == 2);
		}

		@Test
		public void testDeleteById() throws Exception {
			
			List<Auftrag> auftragsListe = fservice.findAllAuftrag();
			assertTrue(auftragsListe.size() == 3);

			fservice.deleteAuftragById(auftragsListe.get(0).getAuftragsNummer());

			auftragsListe = fservice.findAllAuftrag();
			assertTrue(auftragsListe.size() == 2);
		}
			
	
		public static List<Auftrag> init() throws Exception {
//			FeuerungsrapportServiceTest.deleteAll();
			
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
			
			return lAuftrag;		
		}
}
//			for(Benutzer b : lBenutzer){
//				benutzerDAO.saveBenutzer(b);
//			}
//			
//			for(Ort o : lOrt){
//				ortDAO.saveOrt(o);
//			}
//			
//			for(Brenner b : lBrenner){
//				brennerDAO.saveBrenner(b);
//			}
//			
//			for(Waermeerzeuger w : lWaermeerzeuger){
//				waermeerzeugerDAO.saveWaermeerzeuger(w);
//			}
//			
//			for(Feuerungsanlage f : lFeuerungsanlage){
//				feuerungsanlageDAO.saveFeuerungsanlage(f);
//			}
//			
//			for(Kontakt k : lKontakt){
//				kontaktDAO.saveKontakt(k);
//			}
//			
//			for(Liegenschaft l : lLiegenschaft){
//				liegenschaftDAO.saveLiegenschaft(l);
//			}
//			
//			/*Wird nicht benötigt, da Cascade.ALL bei Messung*/
//			for(Messung m : lMessung){
//				messungDAO.saveMessung(m);
//			}
//			
//			for(Mitarbeiter m : lMitarbeiter){
//				mitarbeiterDAO.saveMitarbeiter(m);
//			}
//			
//			for(Auftrag a : lAuftrag){
//				auftragDAO.saveAuftrag(a);
//			}
//			
//			
//		}
//
//		private static void deleteAll() throws Exception {
//
//			deleteAllAuftrag();
//			
//			for(Liegenschaft l : liegenschaftDAO.findAllLiegenschaft()){
//				liegenschaftDAO.deleteLiegenschaft(l);
//			}
//			for(Feuerungsanlage f : feuerungsanlageDAO.findAllFeuerungsanlage()){
//				feuerungsanlageDAO.deleteFeuerungsanlage(f);
//			}
//			for(Brenner b : brennerDAO.findAllBrenner()){
//				brennerDAO.deleteBrenner(b);
//			}
//			for(Waermeerzeuger w : waermeerzeugerDAO.findAllWaermeerzeuger()){
//				waermeerzeugerDAO.deleteWaermeerzeuger(w);
//			}
//			for(Mitarbeiter m : mitarbeiterDAO.findAllMitarbeiter()){
//				mitarbeiterDAO.deleteMitarbeiter(m);
//			}
//			for(Benutzer b : benutzerDAO.findAllBenutzer()){
//				benutzerDAO.deleteBenutzer(b);
//			}
//			for(Kontakt k : kontaktDAO.findAllKontakte()){
//				kontaktDAO.deleteKontakt(k);
//			}
//			for(Ort o : ortDAO.findAllOrt()){
//				ortDAO.deleteOrt(o);
//			}
//			for(Messung m : messungDAO.findAllMessung()){
//				messungDAO.deleteMessung(m);
//			}
//		}
//
//		public static void deleteAllAuftrag() throws Exception {
//
//			for (Auftrag a : auftragDAO.findAllAuftrag()) {
//				auftragDAO.deleteAuftrag(a);
//			}
//		}
//
//
//	@Test
//	public void testAddBrenner() throws Exception {
//	initBrenner();
//	}
//	
//	@Test
//	public void testUpdateBrenner() throws Exception {
//		initBrenner();
//		// b3 holen
//		List<Brenner> brListe=service.findByTyp("brt5");
//		assertTrue(brListe.size() == 1);
//		
//		Brenner brenner = dListe.get(0);
//		
//		Brennerart brennerartVorUpdate = brenner.getBrennerArtString();
//		// bra2 ("atmospärisch")
//		
//		assertTrue("atmospärisch".equals(brennerartVorUpdate.getBrennerArtString()));
//		
//		/*
//		 * Neuer Brennerart erstellen, b3 wird von Brennerart bra2 
//		 * "atmospärisch" auf bra4 "Kompression" umgesetzt
//		 */
//		Brennerart bra4 = new Brennerart("Kompression");
//		brenner.setBrennerArt(bra4);
//		
//		/*Updaten*/
//		service.updateBrenner(brenner);
//		
//		/* AlleBrenner aus Datenbank holen*/
//		List<Brenner> alleBrenner = service.
//		
//	}
//	//Init Methoden
//	public List<Brenner> initBrenner() throws Exception{
//		
//		Brennerart bra1 = new Brennerart("Gebläse");
//		Brennerart bra2 = new Brennerart("atmosphärisch");
//		Brennerart bra3 = new Brennerart("Verdampfer");
//		
//		Brennertyp brt1 = new Brennertyp("AC43B");
//		Brennertyp brt2 = new Brennertyp("BR42B");
//		Brennertyp brt3 = new Brennertyp("CG43B");
//		Brennertyp brt4 = new Brennertyp("DC43B");
//		Brennertyp brt5 = new Brennertyp("EC66J");
//		
//		int j1995 = 1995;
//		Baujahr j1996 = new Baujahr(1996);
//		Baujahr j1997 = new Baujahr(1997);
//		Baujahr j1998 = new Baujahr(1998);
//		Baujahr j1999 = new Baujahr(1999);
//		Baujahr j2000 = new Baujahr(2000);
//		Baujahr j2001 = new Baujahr(2001);
//		Baujahr j2002 = new Baujahr(2002);
//		Baujahr j2003 = new Baujahr(2003);
//		Baujahr j2004 = new Baujahr(2004);
//		
//		/*Brenner 1*/
//		 Brenner b1 = new Brenner(bra1,brt1,j1995);
//		 service.addBrenner(b1);
//		 
//		 /*Brenner 2*/
//		 Brenner b2 = new Brenner(bra3,brt3,j1998);
//		 service.addBrenner(b2);
//		 
//		 /*Brenner 3*/
//		 Brenner b3 = new Brenner(bra2,brt5,j2004);
//		 service.addBrenner(b3);
//		 
//		 /*Brenner 4*/
//		 Brenner b4 = new Brenner(bra2,brt2,j2001);
//		 service.addBrenner(b4);
//		 
//		 
//		 ArrayList<Brenner> brennerListe = new ArrayList<>();
//		 	brennerListe.add(b1);
//		 	brennerListe.add(b2);
//		 	brennerListe.add(b3);
//			brennerListe.add(b4);
//			
//			return brennerListe;
//	}
//	public List<Waermeerzeuger> initWaermeerzeuger() throws Exception {
//		
//		Waermeerzeugerart waa1 = new Waermeerzeugerart("Gebläse");
//		Waermeerzeugerart waa2 = new Waermeerzeugerart("atmosphärisch");
//		Waermeerzeugerart waa3 = new Waermeerzeugerart("Verdampfer");
//		
//		Waermeerzeugertyp wat1 = new Waermeerzeugertyp("AC43B");
//		Waermeerzeugertyp wat2 = new Waermeerzeugertyp("BR42B");
//		Waermeerzeugertyp wat3 = new Waermeerzeugertyp("CG43B");
//		Waermeerzeugertyp wat4 = new Waermeerzeugertyp("DC43B");
//		Waermeerzeugertyp wat5 = new Waermeerzeugertyp("EC66J");
//		
//		Baujahr j1995 = new Baujahr(1995);
//		Baujahr j1996 = new Baujahr(1996);
//		Baujahr j1997 = new Baujahr(1997);
//		Baujahr j1998 = new Baujahr(1998);
//		Baujahr j1999 = new Baujahr(1999);
//		Baujahr j2000 = new Baujahr(2000);
//		Baujahr j2001 = new Baujahr(2001);
//		Baujahr j2002 = new Baujahr(2002);
//		Baujahr j2003 = new Baujahr(2003);
//		Baujahr j2004 = new Baujahr(2004);
//		
//		/*Brenner 1*/
//		Waermeerzeuger w1 = new Waermeerzeuger(waa1,wat1,j1995);
//		 service.addBrenner(w1);
//		 
//		 /*Brenner 2*/
//		 Waermeerzeuger w2 = new Waermeerzeuger(waa3,wat3,j1998);
//		 service.addBrenner(w2);
//		 
//		 /*Brenner 3*/
//		 Waermeerzeuger w3 = new Waermeerzeuger(waa2,wat5,j2004);
//		 service.addBrenner(w3);
//		 
//		 /*Brenner 4*/
//		 Waermeerzeuger w4 = new Waermeerzeuger(waa2,wat2,j2001);
//		 service.addWaermeerzeuger(w4);
//		 
//		 
//		 ArrayList<Waermeerzeuger> waermeerzeugerListe = new ArrayList<>();
//		 	waermeerzeugerListe.add(w1);
//		 	waermeerzeugerListe.add(w2);
//		 	waermeerzeugerListe.add(w3);
//		 	waermeerzeugerListe.add(w4);
//			
//			return waermeerzeugerListe;
//	}
//
//}