package testManager;

import static org.junit.Assert.*;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Waermeerzeuger;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.BrennerManager;
import managerInterfaces.FeuerungsanlageManager;
import managerInterfaces.WaermeerzeugerManager;
import managerKlassen.BrennerManagerImpl;
import managerKlassen.FeuerungsanlageManagerImpl;
import managerKlassen.WaermeerzeugerManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testet die Funktionalität der FeuerungsanlageManager
 * @author Olivia
 * @since 1.0
 * @version 1.0
 *
 */
public class FeuerungsanlageManagerTest {

	private static FeuerungsanlageManager feuerungsanlageManager = new FeuerungsanlageManagerImpl();
	private static BrennerManager brennerManager = new BrennerManagerImpl();
	private static WaermeerzeugerManager waermeerzeugerManager = new WaermeerzeugerManagerImpl();

	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		FeuerungsanlageManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		FeuerungsanlageManagerTest.deleteAll();
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Feuerungsanlage> fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 3);
	}
	
	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#findByBrenner(Brenner)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBrenner() throws Exception {
		
		Brenner b = brennerManager.findAll().get(0);
		
		List<Feuerungsanlage> fList = feuerungsanlageManager.findByBrenner(b);
		
		assertNotNull(fList);
		
		assertTrue(fList.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#findByWaermeerzeuger(Waermeerzeuger)}
	 * @throws Exception
	 */
	@Test
	public void testFindByWaermeerzeuger() throws Exception {
		
		Waermeerzeuger w = waermeerzeugerManager.findAll().get(0);
		List<Feuerungsanlage> fList = feuerungsanlageManager.findByWaermeerzeuger(w);
		
		assertTrue(fList.size() == 1);
	}

	
	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#update(Feuerungsanlage)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Feuerungsanlage> fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 3);

		Feuerungsanlage f = feuerungsanlageManager.findAll().get(0);
		Brenner bNew = brennerManager.findAll().get(2);
		f.setBrenner(bNew);
		
		feuerungsanlageManager.update(f);
		
		assertTrue(feuerungsanlageManager.findAll().size() == 3);
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#delete(Feuerungsanlage)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Feuerungsanlage> fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 3);

		feuerungsanlageManager.delete(fListe.get(0));

		fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 2);
	}

	/**
	 * Testet die Methode {@link FeuerungsanlageManagerImpl#deleteById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Feuerungsanlage> fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 3);

		feuerungsanlageManager.deleteById(fListe.get(0).getIdFeuerungsanlage());

		fListe = feuerungsanlageManager.findAll();
		assertTrue(fListe.size() == 2);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return lFeuerungsanlage
	 * @throws Exception
	 */
	public static List<Feuerungsanlage> init() throws Exception {
		FeuerungsanlageManagerTest.deleteAll();
		
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
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2), 56));

		for(Brenner b : lBrenner){
			brennerManager.add(b);
		}
		for(Waermeerzeuger w : lWaermeerzeuger){
			waermeerzeugerManager.add(w);
		}
		for(Feuerungsanlage f : lFeuerungsanlage){
			feuerungsanlageManager.add(f);
		}
		
		return lFeuerungsanlage;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Feuerungsanlage f : feuerungsanlageManager.findAll()){
			feuerungsanlageManager.delete(f);
		}
		for(Brenner b : brennerManager.findAll()){
			brennerManager.delete(b);;
		}
		for(Waermeerzeuger w : waermeerzeugerManager.findAll()){
			waermeerzeugerManager.delete(w);;
		}
	}

}
