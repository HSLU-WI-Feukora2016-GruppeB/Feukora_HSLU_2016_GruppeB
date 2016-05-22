package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Waermeerzeuger;

import gruppeB.feukora.persister.BrennerDAOImpl;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse Testet BenutzerDAOImpl und ihre Funktionen.
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 * 
 */
public class FeuerungsanlageDAOTest {

	private static FeuerungsanlageDAOImpl feuerungsanlageDAO = new FeuerungsanlageDAOImpl();
	private static BrennerDAOImpl brennerDAO = new BrennerDAOImpl();
	private static WaermeerzeugerDAOImpl waermeerzeugerDAO = new WaermeerzeugerDAOImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		FeuerungsanlageDAOTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		FeuerungsanlageDAOTest.deleteAll();
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#findAllFeuerungsanlage()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Feuerungsanlage> fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);
	}
	
	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#findByBrenner(Brenner)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBrenner() throws Exception {
		
		Brenner b = brennerDAO.findAllBrenner().get(0);
		
		List<Feuerungsanlage> fList = feuerungsanlageDAO.findByBrenner(b);
		
		assertNotNull(fList);
		
		assertTrue(fList.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#findByWaermeerzeuger(Waermeerzeuger)}
	 * @throws Exception
	 */
	@Test
	public void testFindByWaermeerzeuger() throws Exception {
		
		Waermeerzeuger w = waermeerzeugerDAO.findAllWaermeerzeuger().get(0);
		List<Feuerungsanlage> fList = feuerungsanlageDAO.findByWaermeerzeuger(w);
		
		assertTrue(fList.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#updateFeuerungsanlage(Feuerungsanlage)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Feuerungsanlage> fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		Feuerungsanlage f = feuerungsanlageDAO.findAllFeuerungsanlage().get(0);
		Brenner bNew = brennerDAO.findAllBrenner().get(2);
		f.setBrenner(bNew);
		
		feuerungsanlageDAO.updateFeuerungsanlage(f);
		
		assertTrue(feuerungsanlageDAO.findAllFeuerungsanlage().size() == 3);
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#deleteFeuerungsanlage(Feuerungsanlage)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Feuerungsanlage> fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		feuerungsanlageDAO.deleteFeuerungsanlage(fListe.get(0));

		fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 2);
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageDAOImpl#deleteFeuerungsanlageById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Feuerungsanlage> fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 3);

		feuerungsanlageDAO.deleteFeuerungsanlageById(fListe.get(0).getIdFeuerungsanlage());

		fListe = feuerungsanlageDAO.findAllFeuerungsanlage();
		assertTrue(fListe.size() == 2);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Feuerungsanlage> init() throws Exception {
		FeuerungsanlageDAOTest.deleteAll();
		
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		
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
				lWaermeerzeuger.get(1), 88));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2), 46));

		for(Brenner b : lBrenner){
			brennerDAO.saveBrenner(b);
		}
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerDAO.saveWaermeerzeuger(w);
		}
		for(Feuerungsanlage f : lFeuerungsanlage){
			feuerungsanlageDAO.saveFeuerungsanlage(f);
		}
		
		return lFeuerungsanlage;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Feuerungsanlage f : feuerungsanlageDAO.findAllFeuerungsanlage()){
			feuerungsanlageDAO.deleteFeuerungsanlage(f);
		}
		for(Brenner b : brennerDAO.findAllBrenner()){
			brennerDAO.deleteBrenner(b);;
		}
		for(Waermeerzeuger w : waermeerzeugerDAO.findAllWaermeerzeuger()){
			waermeerzeugerDAO.deleteWaermeerzeuger(w);;
		}
	}


	
}
