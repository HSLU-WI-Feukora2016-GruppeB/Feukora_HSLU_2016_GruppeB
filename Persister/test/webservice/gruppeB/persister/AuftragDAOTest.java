package webservice.gruppeB.persister;

import static org.junit.Assert.*;
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
import gruppeB.feukora.persister.AuftragDAOImpl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuftragDAOTest {
	private static AuftragDAOImpl auftragDAO = new AuftragDAOImpl();

	@Before
	public void setUp() throws Exception {
		AuftragDAOTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByDatum() {

		GregorianCalendar auftragsDatum = new GregorianCalendar(2015, 07, 15);

		assertTrue(auftragDAO.findByDatum(auftragsDatum).size() == 1);
	}

	@Test
	public void testFindByLiegenschaft() {

		Ort ort = new Ort(6003, "Luzern");
		Kontakt olivia = new Kontakt("Olivia", "Wassmer", "Hirschengraben 40", ort, "0448817585", "olivia.wassmer@stud.hslu.ch", 1);
		
		assertTrue(auftragDAO.findByKontakt(olivia).size() == 1);

		Ort ort2 = new Ort(1111, "Testingen");
		Kontakt michi = new Kontakt("Michi", "Tester", "Testweg", ort2, "127691347", "test@test.ch", 2);
		
		assertTrue(auftragDAO.findByKontakt(michi).isEmpty());
	}


	
	@Test
	public void testSave() throws Exception {

		List<Auftrag> auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 2);

		//3. Auftragsobjekt a3
		Ort ort = new Ort(8000, "Zürich");
		Kontakt manuel = new Kontakt("Manuel", "Muster", "Musterstrasse 24",
				ort, "0448817585", "manuel.muster@stud.hslu.ch", 1);

		Brenner brenner = new Brenner(1, "abc123", 2014);
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(2, "cba321", 2003);
		Feuerungsanlage feuerungsanlage = new Feuerungsanlage(brenner,
				waermeerzeuger);
		Liegenschaft liegenschaft = new Liegenschaft(manuel,
				"Hausmeister bei Langstrumpf klingeln", "Teststrasse 123", ort,
				feuerungsanlage);

		GregorianCalendar messDatum = new GregorianCalendar(2016, 05, 15);
		Messung messung1 = new Messung(messDatum, 8, 3, false, 3, 2, 1, 7, 3, 7);
		Messung messung2 = new Messung(messDatum, 8, 4, false, 4, 3, 2, 7, 3, 7);
		Messung messung3 = new Messung(messDatum, 8, 5, false, 5, 4, 3, 7, 3, 7);
		Messung messung4 = new Messung(messDatum, 8, 6, false, 6, 5, 4, 7, 3, 7);

		Benutzer benutzer = new Benutzer("mmuster", "abc123");
		GregorianCalendar seit = new GregorianCalendar(2016, 01, 15);
		GregorianCalendar bis = null;
		Mitarbeiter mitarbeiter = new Mitarbeiter("Muster", "Patrick",
				"Testibusstrasse 456", ort, "0441234567",
				"patrick.muster@stud.hslu.ch", 3, benutzer, 1500, seit, bis);

		GregorianCalendar datum = new GregorianCalendar(2016, 11, 12);
		int zeitSlot = 3;
		int terminArt = 2;
		
		Auftrag a3 = new Auftrag(manuel, liegenschaft, mitarbeiter, datum,
				zeitSlot, terminArt);

		auftragDAO.saveAuftrag(a3);

		auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

	}

	@Test
	public void testUpdate() throws Exception {

		List<Auftrag> auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		// 3. Auftragsobjekt a3 check ob es nicht doppelt hinzufügt
		Ort ort = new Ort(8001, "Zürich");
		Kontakt manuelM = new Kontakt("Manuel", "Muster", "Musterstrasse 24",
				ort, "0448817585", "manuel.muster@stud.hslu.ch", 1);

		Brenner brenner = new Brenner(1, "abc123", 2014);
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(2, "cba321", 2003);
		Feuerungsanlage feuerungsanlage = new Feuerungsanlage(brenner,
				waermeerzeuger);
		Liegenschaft liegenschaft = new Liegenschaft(manuelM,
				"Hausmeister bei Langstrumpf klingeln", "Teststrasse 123", ort,
				feuerungsanlage);

		GregorianCalendar messDatum = new GregorianCalendar(2016, 05, 15);
		Messung messung1 = new Messung(messDatum, 8, 3, false, 3, 2, 1, 7, 3, 7);
		Messung messung2 = new Messung(messDatum, 8, 4, false, 4, 3, 2, 7, 3, 7);
		Messung messung3 = new Messung(messDatum, 8, 5, false, 5, 4, 3, 7, 3, 7);
		Messung messung4 = new Messung(messDatum, 8, 6, false, 6, 5, 4, 7, 3, 7);

		Benutzer benutzer = new Benutzer("mmuster", "abc123");
		GregorianCalendar seit = new GregorianCalendar(2016, 01, 15);
		GregorianCalendar bis = null;
		Mitarbeiter mitarbeiter = new Mitarbeiter("Muster", "Patrick",
				"Testibusstrasse 456", ort, "0441234567",
				"patrick.muster@stud.hslu.ch", 3, benutzer, 1500, seit, bis);

		GregorianCalendar datum = new GregorianCalendar(2016, 11, 12);
		int zeitSlot = 3;
		int terminArt = 2;

		Auftrag a3 = new Auftrag(manuelM, liegenschaft, mitarbeiter, datum,
				zeitSlot, terminArt);

		auftragDAO.saveAuftrag(a3);

		auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		/* Mutation Liegenschaft des Auftrag anschliessend update */
		Brenner brennerU = new Brenner(1, "edatpu123", 2014);
		Waermeerzeuger waermeerzeugerU = new Waermeerzeuger(2, "abc321", 2003);
		Feuerungsanlage feuerungsanlageU = new Feuerungsanlage(brenner,
				waermeerzeuger);
		Liegenschaft liegenschaftU = new Liegenschaft(manuelM,
				"Türe ist offen", "Teststrasse 123", ort,
				feuerungsanlage);

		a3.setLiegenschaft(liegenschaftU);

		auftragDAO.updateAuftrag(a3);

		Auftrag auftragFromDb = auftragDAO.findByLiegenschaft(liegenschaft).get(0);
		assertNotNull(auftragFromDb);

		assertEquals(liegenschaftU, auftragFromDb.getLiegenschaft());

	}

	@Test
	public void testDelete() throws Exception {

		List<Auftrag> auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 3);

		auftragDAO.deleteAuftrag(auftragsListe.get(0));

		auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 2);

	}

	@Test
	public void testDeleteById() throws Exception {

		List<Auftrag> auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 2);

		auftragDAO.deleteAuftragById(auftragsListe.get(0).getAuftragsNummer());

		auftragsListe = auftragDAO.findAllAuftrag();
		assertTrue(auftragsListe.size() == 1);
	}
	

	public static List<Auftrag> init() throws Exception {

		AuftragDAOTest.deleteAll();

		//1. Auftragsobjekt a1
		Ort ort = new Ort(6003, "Luzern");
		Kontakt kontakt = new Kontakt("Olivia", "Wassmer", "Hirschengraben 40", ort, "0448817585", "olivia.wassmer@stud.hslu.ch", 1);
		
		Brenner brenner = new Brenner(1, "abc123", 2014);
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(2, "cba321", 2003);
		Feuerungsanlage feuerungsanlage = new Feuerungsanlage(brenner, waermeerzeuger);
		Liegenschaft liegenschaft = new Liegenschaft(kontakt, "Hausmeister bei Müller klingeln", "Teststrasse 123", ort, feuerungsanlage);

		GregorianCalendar messDatum = new GregorianCalendar(2016, 05, 15);
		Messung messung1 = new Messung(messDatum, 2, 3, false, 3, 2, 1, 7, 3, 7);
		Messung messung2 = new Messung(messDatum, 3, 4, false, 4, 3, 2, 7, 3, 7);
		Messung messung3 = new Messung(messDatum, 4, 5, false, 5, 4, 3, 7, 3, 7);
		Messung messung4 = new Messung(messDatum, 5, 6, false, 6, 5, 4, 7, 3, 7);
		
		Benutzer benutzer = new Benutzer("dstirni", "abc123");
		GregorianCalendar seit = new GregorianCalendar(2016, 01, 15);
		GregorianCalendar bis = null;
		Mitarbeiter mitarbeiter = new Mitarbeiter("Stirnimann", "Dominik", "Testibusstrasse 456", ort, "0441234567", "dominik.stirnimann@stud.hslu.ch", 3, benutzer, 1500, seit, bis);		
		
		GregorianCalendar datum = new GregorianCalendar(2015, 07, 15);
		int zeitSlot = 3;
		int terminArt = 2;
		Auftrag a1 = new Auftrag(kontakt, liegenschaft, messung1, messung2, messung3, messung4, mitarbeiter, datum, zeitSlot, terminArt);

		//2. Auftragsobjekt a2
		Ort ort2 = new Ort(6002, "Bern");
		Kontakt kontakt2 = new Kontakt("Ramon", "Müller", "Hirschengraben 40", ort, "0448817585", "olivia.wassmer@stud.hslu.ch", 1);
		
		Brenner brenner2 = new Brenner(1, "abc123", 2014);
		Waermeerzeuger waermeerzeuger2 = new Waermeerzeuger(2, "cba321", 2003);
		Feuerungsanlage feuerungsanlage2 = new Feuerungsanlage(brenner, waermeerzeuger);
		Liegenschaft liegenschaft2 = new Liegenschaft(kontakt, "Hausmeister bei Sutter klingeln", "Teststrasse 123", ort, feuerungsanlage);

		GregorianCalendar messDatum2 = new GregorianCalendar(2016, 05, 15);
		Messung messung5 = new Messung(messDatum, 2, 3, false, 3, 2, 1, 7, 3, 7);
		Messung messung6 = new Messung(messDatum, 3, 4, false, 4, 3, 2, 7, 3, 7);
		Messung messung7 = new Messung(messDatum, 4, 5, false, 5, 4, 3, 7, 3, 7);
		Messung messung8 = new Messung(messDatum, 5, 6, false, 6, 5, 4, 7, 3, 7);
		
		Benutzer benutzer2 = new Benutzer("dstirni", "abc123");
		GregorianCalendar seit2 = new GregorianCalendar(2016, 01, 15);
		GregorianCalendar bis2 = null;
		Mitarbeiter mitarbeiter2 = new Mitarbeiter("Stirnimann", "Dominik", "Testibusstrasse 456", ort, "0441234567", "dominik.stirnimann@stud.hslu.ch", 3, benutzer, 1500, seit, bis);		
		
		GregorianCalendar datum2 = new GregorianCalendar(2016, 11, 12);
		int zeitSlot2 = 3;
		int terminArt2 = 2;
		Auftrag a2 = new Auftrag(kontakt2, liegenschaft2, messung5, messung6, messung7, messung8, mitarbeiter2, datum2, zeitSlot2, terminArt2);
		
		auftragDAO.saveAuftrag(a1);
		auftragDAO.saveAuftrag(a2);
		
		List<Auftrag> auftragsListe = new ArrayList<>();
		auftragsListe.add(a1);
		auftragsListe.add(a2);

		return auftragsListe;
	}

	private static void deleteAll() throws Exception {

		for (Auftrag a : auftragDAO.findAllAuftrag()) {
			auftragDAO.deleteAuftrag(a);
		}
	}

//	public static void deleteAlleAufträge() throws Exception {
//
//		for (Auftrag a : auftragDAO.findAllAuftrag()) {
//			auftragDAO.deleteAuftrag(a);
//		}
//	}

}
