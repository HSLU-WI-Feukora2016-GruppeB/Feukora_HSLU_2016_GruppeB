package webservice.gruppeB.persister;

import static org.junit.Assert.*;
import entitys.Benutzer;
import gruppeB.feukora.persister.BenutzerDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse Testet BenutzerDAOImpl und ihre Funktionen.
 * @author Olivia Wassmer
 * @version 1.0
 * @since 1.0
 * 
 */
public class BenutzerDAOTest {

	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		BenutzerDAOTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Testet die Methode {@link BenutzerDAOImpl#findAllBenutzer()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 6);
	}
	
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findByMitarbeiter(Mitarbeiter)
//	 * @throws Exception
//	 */
//	@Test
//	public void testFindByMitarbeiter() throws Exception {
//		
//		Mitarbeiter ma = mitarbeiterDAO.findMitarbeiterByName("Raneri").get(0);
//		List<Auftrag> al = auftragDAO.findByMitarbeiter(ma);
//		
//		assertNotNull(al);
//		
//		assertTrue(al.size() == 0);
//	}
//	
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findByDatum(GregorianCalendar)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testFindByDatum() throws Exception {
//		
//		GregorianCalendar d = new GregorianCalendar(2016, 9, 11);
//		List<Auftrag> al = auftragDAO.findByDatum(d);
//		
//		assertNotNull(al);
//		
//		assertTrue(al.size() == 2);
//	}
//
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findByKontakt(Kontakt)
//	 * @throws Exception
//	 */
//	@Test
//	public void testFindByKontakt() throws Exception {
//		
//		Kontakt k = kontaktDAO.findKontaktByName("Meyer").get(0);
//		List<Auftrag> al = auftragDAO.findByKontakt(k);
//		
//		assertNotNull(al);
//		
//		assertTrue(al.size() == 1);
//	}
//	
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findByLiegenschaft(Liegenschaft)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testFindByLiegenschaft() throws Exception {
//		
//		Liegenschaft liegenschaft = liegenschaftDAO.findLiegenschaftByStrasse("Musterweg 456").get(0);
//		assertNotNull(liegenschaft);
//		
//		List<Auftrag> aList = auftragDAO.findByLiegenschaft(liegenschaft);
//		assertTrue(aList.size() == 2);
//		
//	}
//	
//
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findByDatumAndMitarbeiter(GregorianCalendar, GregorianCalendar, Mitarbeiter)}
//	 */
//	@Test
//	public void testFindByDatumAndMitarbeiter() throws Exception {
//		GregorianCalendar ds = new GregorianCalendar(2016, 05, 1);
//		GregorianCalendar de = new GregorianCalendar(2018, 10, 11);
//		Mitarbeiter m = mitarbeiterDAO.findMitarbeiterByNameVorname("Stirnimann", "Dominik").get(0);
//
//		assertNotNull(ds);
//		assertNotNull(de);
//		assertNotNull(m);
//		
//		List<Auftrag> auftraege = auftragDAO.findByDatumAndMitarbeiter(ds, de, m);
//		assertTrue(auftraege.size() == 1);
//	}
//	 
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#findAuftragByDateAndMitarbeiterAndZeitslot(GregorianCalendar, Mitarbeiter, int)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testFindByDatumAndMitarbeiterAndZeitslot() throws Exception {
//		
//		GregorianCalendar d = new GregorianCalendar(2016, 9, 18);
//		Mitarbeiter m = mitarbeiterDAO.findMitarbeiterByNameVorname("Stirnimann", "Dominik").get(0);
//		int z = 1;
//		assertNotNull(d);
//		assertNotNull(m);
//		assertNotNull(z);
//		
//		Auftrag auftrag = auftragDAO.findAuftragByDateAndMitarbeiterAndZeitslot(d, m, z);
//		assertNotNull(auftrag);
//		
//	}
//	
//	/**
//	 * Testet die Methode {@link AuftragDAOImpl#updateAuftrag(Auftrag)}
//	 * @throws Exception
//	 */
//	@Test
//	public void testUpdate() throws Exception {
//
//		List<Auftrag> auftragsListe = auftragDAO.findAllAuftrag();
//		assertTrue(auftragsListe.size() == 3);
//
//		Ort o = ortDAO.findOrtByPlz(5000).get(0);
//		Kontakt k = kontaktDAO.findKontaktByOrt(o).get(0);
//		Liegenschaft l = liegenschaftDAO.findLiegenschaftByKontakt(k).get(0);
//		Auftrag a = auftragDAO.findByLiegenschaft(l).get(0);
//		assertNotNull(a);
//		
//		Liegenschaft lnew = liegenschaftDAO.findAllLiegenschaft().get(1);
//		a.setLiegenschaft(lnew);
//		
//		auftragDAO.updateAuftrag(a);
//		
//		Auftrag aDB = auftragDAO.findByLiegenschaft(lnew).get(0);
//		assertNotNull(aDB);
//		assertTrue(aDB.getLiegenschaft() != l);
//		
//		auftragsListe = auftragDAO.findAllAuftrag();
//		assertTrue(auftragsListe.size() == 3);
//
//	}

	/**
	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzer(Benutzer)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 6);

		benutzerDAO.deleteBenutzer(bListe.get(0));;

		bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 5);

	}

	/**
	 * Testet die Methode {@link BenutzerDAOImpl#deleteBenutzerById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 6);

		benutzerDAO.deleteBenutzerById(bListe.get(0).getIdUser());

		bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 5);
	}
	

	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Benutzer> init() throws Exception {
		BenutzerDAOTest.deleteAll();
		
		List<Benutzer> lBenutzer = new ArrayList<>();
		
		//6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		
		for(Benutzer b : lBenutzer){
			benutzerDAO.saveBenutzer(b);
		}
		
		return lBenutzer;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Benutzer b : benutzerDAO.findAllBenutzer()){
			benutzerDAO.deleteBenutzer(b);
		}
	}


}
