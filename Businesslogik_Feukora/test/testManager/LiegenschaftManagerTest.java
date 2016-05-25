package testManager;

import static org.junit.Assert.*;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import entitys.Waermeerzeuger;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.BrennerManager;
import managerInterfaces.FeuerungsanlageManager;
import managerInterfaces.KontaktManager;
import managerInterfaces.LiegenschaftManager;
import managerInterfaces.OrtManager;
import managerInterfaces.WaermeerzeugerManager;
import managerKlassen.BrennerManagerImpl;
import managerKlassen.FeuerungsanlageManagerImpl;
import managerKlassen.KontaktManagerImpl;
import managerKlassen.LiegenschaftManagerImpl;
import managerKlassen.OrtManagerImpl;
import managerKlassen.WaermeerzeugerManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der LiegenschaftsManager zuständig.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class LiegenschaftManagerTest {

	private static BrennerManager brennerDAO = new BrennerManagerImpl();
	private static FeuerungsanlageManager feuerungsanlageDAO = new FeuerungsanlageManagerImpl();
	private static KontaktManager kontaktDAO = new KontaktManagerImpl();
	private static LiegenschaftManager liegenschaftDAO = new LiegenschaftManagerImpl();
	private static OrtManager ortDAO = new OrtManagerImpl();
	private static WaermeerzeugerManager waermeerzeugerDAO = new WaermeerzeugerManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		LiegenschaftManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		LiegenschaftManagerTest.deleteAll();
	}

	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#findAll()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllLiegenschaft() throws Exception{
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 3);
	}

	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#findByKontakt(Kontakt)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByKontakt() throws Exception {
		
		Kontakt kontakt = kontaktDAO.findByName("Meyer").get(0);
		assertNotNull(kontakt);
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findByKontakt(kontakt);
		assertTrue(liegenschaftsListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#findByOrt(Ort)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByOrt() throws Exception {
		
		Ort ort = ortDAO.findByPlz(1000).get(0);
		assertNotNull(ort);
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findByOrt(ort);
		assertTrue(liegenschaftsListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#findByStrasse(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByStrasse() throws Exception {
		
		String strasse = "Musterweg 456";
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findByStrasse(strasse);
		assertTrue(liegenschaftsListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#update(Liegenschaft)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
	
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 3);
	
		Ort o = ortDAO.findByPlz(5000).get(0);
		Kontakt k = kontaktDAO.findByOrt(o).get(0);
		Liegenschaft l = liegenschaftDAO.findByKontakt(k).get(0);
		assertNotNull(l);
		
		Kontakt kNew = kontaktDAO.findAll().get(1);
		l.setKontakt(kNew);
		
		liegenschaftDAO.update(l);
		
		Liegenschaft aDB = liegenschaftDAO.findByKontakt(kNew).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getKontakt() != k);
		
		liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 3);
	
	}

	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#delete(Liegenschaft)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteLiegenschaft() throws Exception {
	
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 3);
	
		liegenschaftDAO.delete(liegenschaftsListe.get(0));
	
		liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 2);
	
	}

	/**
	 * Dieser Test tested die Methode {@link LiegenschaftManagerImpl#deleteById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 3);

		liegenschaftDAO.deleteById(liegenschaftsListe.get(0).getIdLiegenschaft());

		liegenschaftsListe = liegenschaftDAO.findAll();
		assertTrue(liegenschaftsListe.size() == 2);
	}
	
	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * @return lLiegenschaft
	 * @throws Exception
	 */
	public static List<Liegenschaft> init() throws Exception {
		LiegenschaftManagerTest.deleteAll();
		
		List<Brenner> lBrenner = new ArrayList<>();
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Kontakt> lKontakt = new ArrayList<>();
		List<Liegenschaft> lLiegenschaft = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
				
		//3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));
		
		//3 Waermeerzeuger erstellen
		lWaermeerzeuger.add(new Waermeerzeuger(1, "qwertz", 2012));
		lWaermeerzeuger.add(new Waermeerzeuger(2, "uiopü", 2011));
		lWaermeerzeuger.add(new Waermeerzeuger(3, "asdfg", 2010));
	
		//3 Feuerungsanlagen
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(0), lWaermeerzeuger.get(0), 65));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(1), lWaermeerzeuger.get(1), 87));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2), 46));

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
		
		//3 Liegenschaften erstellen
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(0), "Hausmeister bei Muster klingeln", "Abcweg 123", lOrt.get(3),lFeuerungsanlage.get(0)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(1), "07978885599 anrufen bei Ankunft", "Musterweg 456", lOrt.get(4),lFeuerungsanlage.get(1)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(2), "Türe ist offen", "Musterweg 456", lOrt.get(5),lFeuerungsanlage.get(2)));
		
		for(Ort o : lOrt){
			ortDAO.add(o);
		}
		
		for(Brenner b : lBrenner){
			brennerDAO.add(b);
		}
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerDAO.add(w);
		}
		
		for(Feuerungsanlage f : lFeuerungsanlage){
			feuerungsanlageDAO.add(f);
		}
		
		for(Kontakt k : lKontakt){
			kontaktDAO.add(k);
		}
		
		for(Liegenschaft l : lLiegenschaft){
			liegenschaftDAO.add(l);
		}
		
		return lLiegenschaft;
	}
	
	/**
	 * Loescht alle Objekte aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllLiegenschaft();
		
		for(Feuerungsanlage f : feuerungsanlageDAO.findAll()){
			feuerungsanlageDAO.delete(f);
		}
		for(Brenner b : brennerDAO.findAll()){
			brennerDAO.delete(b);
		}
		for(Waermeerzeuger w : waermeerzeugerDAO.findAll()){
			waermeerzeugerDAO.delete(w);
		}
		for(Kontakt k : kontaktDAO.findAll()){
			kontaktDAO.delete(k);
		}
		for(Ort o : ortDAO.findAll()){
			ortDAO.delete(o);
		}

	}

	/**
	 * Loescht alle Liegenschafts-Objekte aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllLiegenschaft() throws Exception {

		for (Liegenschaft l : liegenschaftDAO.findAll()) {
			liegenschaftDAO.delete(l);
		}
	}
}