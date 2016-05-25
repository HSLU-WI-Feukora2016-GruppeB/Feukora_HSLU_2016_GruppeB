package testManager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import managerInterfaces.BrennerManager;
import managerKlassen.BrennerManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.Brenner;

/**
 * Diese Klasse ist für das Testen der BrennerManager zuständig.
 * @author Pascal Steiner
 * @version 1.0
 * @since 1.0
 */
public class BrennerManagerTest {

	private static BrennerManager brennerManager = new BrennerManagerImpl();
	
	/**
	 * Initialisiert die Datenbank mit Testwerten.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		BrennerManagerTest.init();
	}

	/**
	 * Schliesst Test mit Datenbank ab.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		BrennerManagerTest.deleteAll();
	}
	
	/**
	 * Testet die Methode {@link BrennerManagerImpl#findAll()}
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Brenner> bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 3);
	}
	
	/**
	 * Testet die Methode {@link BrennerManagerImpl#findByBaujahr(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBaujahr() throws Exception {
		
		int bj = 2013;
		List<Brenner> b = brennerManager.findByBaujahr(bj);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link BrennerManagerImpl#findByArt(int)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBrennerart() throws Exception {
		
		int ba = 1;
		List<Brenner> b = brennerManager.findByArt(ba);
		
		assertTrue(b.size() == 2);
	}
	
	/**
	 * Testet die Methode {@link BrennerManagerImpl#findByTyp(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByBrennertyp() throws Exception {
		
		String bt = "abc123";
		List<Brenner> b = brennerManager.findByTyp(bt);
		
		assertTrue(b.size() == 1);
	}

	
	/**
	 * Testet die Methode {@link BrennerManagerImpl#update(Brenner)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Brenner> bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 3);

		String bNew = "testibus";
		Brenner bUpdated = bListe.get(1);
		bUpdated.setBrennerTyp(bNew);
		
		brennerManager.update(bUpdated);
		
		assertTrue(brennerManager.findAll().size() == 3);
	}

	/**
	 * Testet die Methode {@link BrennerDAOImpl#deleteBrenner(Brenner)}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Brenner> bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 3);

		brennerManager.delete(bListe.get(0));;

		bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 2);
	}

	/**
	 * Testet die Methode {@link BrennerDAOImpl#deleteBrennerById(Integer)}
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Brenner> bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 3);

		brennerManager.deleteById(bListe.get(0).getId());

		bListe = brennerManager.findAll();
		assertTrue(bListe.size() == 2);
	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Brenner> init() throws Exception {
		BrennerManagerTest.deleteAll();
		
		List<Brenner> lBrenner = new ArrayList<>();
		
		//3 Brenner erstellen
		lBrenner.add(new Brenner(1, "abc123", 2013));
		lBrenner.add(new Brenner(2, "def456", 2014));
		lBrenner.add(new Brenner(1, "ghi789", 2015));
		
		for(Brenner b : lBrenner){
			brennerManager.add(b);
		}
		
		return lBrenner;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for(Brenner b : brennerManager.findAll()){
			brennerManager.delete(b);
		}
	}

}
