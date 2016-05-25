package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import entitys.Waermeerzeuger;
import gruppeB.feukora.persister.BrennerDAOImpl;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import gruppeB.feukora.persister.KontaktDAOImpl;
import gruppeB.feukora.persister.LiegenschaftDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;

/**
 * Diese Klasse ist für das Testen der LiegenschaftDAO-Implementierung zuständig.
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 */
public class LiegenschaftDAOTest {

	private static BrennerDAOImpl brennerDAO = new BrennerDAOImpl();
	private static FeuerungsanlageDAOImpl feuerungsanlageDAO = new FeuerungsanlageDAOImpl();
	private static KontaktDAOImpl kontaktDAO = new KontaktDAOImpl();
	private static LiegenschaftDAOImpl liegenschaftDAO = new LiegenschaftDAOImpl();
	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	private static WaermeerzeugerDAOImpl waermeerzeugerDAO = new WaermeerzeugerDAOImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		LiegenschaftDAOTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		LiegenschaftDAOTest.deleteAll();
	}

	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#updateLiegenschaft(Liegenschaft)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 3);

		Ort o = ortDAO.findOrtByPlz(5000).get(0);
		Kontakt k = kontaktDAO.findKontaktByOrt(o).get(0);
		Liegenschaft l = liegenschaftDAO.findLiegenschaftByKontakt(k).get(0);
		assertNotNull(l);
		
		Kontakt kNew = kontaktDAO.findAllKontakte().get(1);
		l.setKontakt(kNew);
		
		liegenschaftDAO.updateLiegenschaft(l);
		
		Liegenschaft aDB = liegenschaftDAO.findLiegenschaftByKontakt(kNew).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getKontakt() != k);
		
		liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 3);

	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#findAllLiegenschaft()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAllLiegenschaft() throws Exception{
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 3);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#deleteLiegenschaft(Liegenschaft)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteLiegenschaft() throws Exception {

		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 3);

		liegenschaftDAO.deleteLiegenschaft(liegenschaftsListe.get(0));

		liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 2);

	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#findLiegenschaftByKontakt(Kontakt)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByKontakt() throws Exception {
		
		Kontakt kontakt = kontaktDAO.findKontaktByName("Meyer").get(0);
		assertNotNull(kontakt);
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findLiegenschaftByKontakt(kontakt);
		assertTrue(liegenschaftsListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#findLiegenschaftByOrt(Ort)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByOrt() throws Exception {
		
		Ort ort = ortDAO.findOrtByPlz(1000).get(0);
		assertNotNull(ort);
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findLiegenschaftByOrt(ort);
		assertTrue(liegenschaftsListe.size() == 1);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#findLiegenschaftByStrasse(String)}.
	 * @throws Exception
	 */
	@Test
	public void testFindLiegenschaftByStrasse() throws Exception {
		
		String strasse = "Musterweg 456";
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findLiegenschaftByStrasse(strasse);
		assertTrue(liegenschaftsListe.size() == 2);
	}
	
	/**
	 * Dieser Test tested die Methode {@link LiegenschaftDAOImpl#deleteLiegenschaftById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Liegenschaft> liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 3);

		liegenschaftDAO.deleteLiegenschaftById(liegenschaftsListe.get(0).getIdLiegenschaft());

		liegenschaftsListe = liegenschaftDAO.findAllLiegenschaft();
		assertTrue(liegenschaftsListe.size() == 2);
	}
	
	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * @return lLiegenschaft
	 * @throws Exception
	 */
	public static List<Liegenschaft> init() throws Exception {
		LiegenschaftDAOTest.deleteAll();
		
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
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(1), lWaermeerzeuger.get(1), 46));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2), 88));

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
			ortDAO.saveOrt(o);
		}
		
		for(Brenner b : lBrenner){
			brennerDAO.saveBrenner(b);
		}
		
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerDAO.saveWaermeerzeuger(w);
		}
		
		for(Feuerungsanlage f : lFeuerungsanlage){
			feuerungsanlageDAO.saveFeuerungsanlage(f);
		}
		
		for(Kontakt k : lKontakt){
			kontaktDAO.saveKontakt(k);
		}
		
		for(Liegenschaft l : lLiegenschaft){
			liegenschaftDAO.saveLiegenschaft(l);
		}
		
		return lLiegenschaft;
	}
	
	/**
	 * Loescht alle Objekte aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllLiegenschaft();
		
		for(Feuerungsanlage f : feuerungsanlageDAO.findAllFeuerungsanlage()){
			feuerungsanlageDAO.deleteFeuerungsanlage(f);
		}
		for(Brenner b : brennerDAO.findAllBrenner()){
			brennerDAO.deleteBrenner(b);
		}
		for(Waermeerzeuger w : waermeerzeugerDAO.findAllWaermeerzeuger()){
			waermeerzeugerDAO.deleteWaermeerzeuger(w);
		}
		for(Kontakt k : kontaktDAO.findAllKontakte()){
			kontaktDAO.deleteKontakt(k);
		}
		for(Ort o : ortDAO.findAllOrt()){
			ortDAO.deleteOrt(o);
		}

	}

	/**
	 * Loescht alle Liegenschafts-Objekte aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllLiegenschaft() throws Exception {

		for (Liegenschaft l : liegenschaftDAO.findAllLiegenschaft()) {
			liegenschaftDAO.deleteLiegenschaft(l);
		}
	}
}
