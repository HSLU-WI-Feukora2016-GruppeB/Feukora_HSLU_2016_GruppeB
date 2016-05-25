package testManager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.KontaktManager;
import managerInterfaces.OrtManager;
import managerKlassen.KontaktManagerImpl;
import managerKlassen.OrtManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Kontakt;
import entitys.Ort;

/**
 * Diese Klasse ist für das Testen der KontaktManager zuständig.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class KontaktManagerTest {

	private static KontaktManager kontaktManager = new KontaktManagerImpl();
	private static OrtManager ortManager = new OrtManagerImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		KontaktManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		KontaktManagerTest.deleteAll();
	}

	/**
	 * Testet die Methode {@link KontaktManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Kontakt> kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 8);
	}
	
	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByName(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByName() throws Exception {
		
		String n = "Zäh";
		
		List<Kontakt> k =kontaktManager.findByName(n);
		
		assertNotNull(k);
		assertTrue(k.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByNameVorname(String, String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByNameVorname() throws Exception {
		
		String n = "Meyer";
		String v = "Martina";

		List<Kontakt> k = kontaktManager.findByNameVorname(n, v);

		assertNotNull(k);
		assertTrue(k.size() == 1);
	}

	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByOrt(Ort)}
	 * @throws Exception
	 */
	@Test
	public void testFindByOrt() throws Exception {
		
		Ort o = ortManager.findByPlz(1000).get(0);
		List<Kontakt> kList = kontaktManager.findByOrt(o);
		
		assertNotNull(kList);
		
		assertTrue(kList.size() == 2);
	}
	
	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByRolleExtern(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByRolleExtern() throws Exception {
		
		List<Kontakt> k = kontaktManager.findByRolleExtern(2);
		assertNotNull(k);
		
		assertTrue(k.size() == 6);
		
	}
	

	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByStrasse(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByStrasse() throws Exception {

		String s = "Zaubergass 7";
		List<Kontakt> k = kontaktManager.findByStrasse(s);
		assertNotNull(k);
		
		assertTrue(k.size() == 1);
	}
	 
	/**
	 * Testet die Methode {@link KontaktManagerImpl#findByVorname(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByVorname() throws Exception {
		
		String v = "Heiri";
		List<Kontakt> k = kontaktManager.findByVorname(v);
		assertNotNull(k);
		
		assertTrue(k.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link KontaktManagerImpl#update(Kontakt)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Kontakt> kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 8);

		Ort o = ortManager.findByPlz(5000).get(0);
		Kontakt k = kontaktManager.findByOrt(o).get(0);
		assertNotNull(k);
		
		Ort oNew = ortManager.findAll().get(6);
		k.setOrt(oNew);
		
		kontaktManager.update(k);
		
		Kontakt oDB = kontaktManager.findByOrt(oNew).get(0);
		assertNotNull(oDB);
		assertTrue(oDB.getOrt() != o);
		
		kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 8);
	}

	/**
	 * Testet die Methode {@link KontaktManagerImpl#delete(Kontakt)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Kontakt> kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 8);

		kontaktManager.delete(kListe.get(7));

		kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 7);

	}

	/**
	 * Testet die Methode {@link KontaktManagerImpl#deleteById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Kontakt> kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 8);

		kontaktManager.deleteById(kListe.get(7).getId());

		kListe = kontaktManager.findAll();
		assertTrue(kListe.size() == 7);
	}
	

	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return lKontakt
	 * @throws Exception
	 */
	public static List<Kontakt> init() throws Exception {
		KontaktManagerTest.deleteAll();
		
		List<Kontakt> lKontakt = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		
		//7 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));
		lOrt.add(new Ort(4000, "Basel"));
		
		//8 Kontakte erstellen
		lKontakt.add(new Kontakt("Martina", "Meyer", "Altstrasse 1", lOrt.get(2), "0633335577", "m.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christoph", "Müller", "Neustrasse 1", lOrt.get(6), "0554445577", "c.m@gmail.com", 1));
		lKontakt.add(new Kontakt("Heiri", "Muster", "Bernstrasse 1", lOrt.get(4), "0688885577", "h.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Christof", "Meyer", "Gassweg 1", lOrt.get(5), "0633335577", "ch.m@gmail.com", 2));
		lKontakt.add(new Kontakt("Hanna", "Putz", "Malweg 5", lOrt.get(4), "0637777777", "h.p@gmail.com", 2));
		lKontakt.add(new Kontakt("Martina", "Zäh", "Altstrasse 90", lOrt.get(3), "0633888877", "m.z@gmail.com", 2));
		lKontakt.add(new Kontakt("Tina", "Bär", "Waserstrasse 4", lOrt.get(5), "0222235577", "t.b@gmail.com", 1));
		lKontakt.add(new Kontakt("Rudolf", "Santa", "Zaubergass 7", lOrt.get(1), "0699999997", "r.s@gmail.com", 2));
		
		for(Ort o : lOrt){
			ortManager.add(o);
		}
		
		for(Kontakt k : lKontakt){
			kontaktManager.add(k);
		}
		
		return lKontakt;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllKontakt();
		
		for(Ort o : ortManager.findAll()){
			ortManager.delete(o);
		}
	}

	/**
	 * Löscht alle Aufträge aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllKontakt() throws Exception {

		for (Kontakt k : kontaktManager.findAll()) {
			kontaktManager.delete(k);
		}
	}

}
