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
	
	/**
	 * Testet die Methode {@link BenutzerDAOImpl#findBenutzerByUsername(String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByUsername() throws Exception {
		
		String u = "mpe";
		List<Benutzer> b = benutzerDAO.findBenutzerByUsername(u);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}
	
	/**
	 * Testet die Methode {@link BenutzerDAOImpl#findBenutzerByUsernamePassword(String, String)}
	 * @throws Exception
	 */
	@Test
	public void testFindByUsernamePassword() throws Exception {
		
		String u = "owa";
		String p = "121";
		List<Benutzer> b = benutzerDAO.findBenutzerByUsernamePassword(u, p);
		
		assertNotNull(b);
		
		assertTrue(b.size() == 1);
	}

	
	/**
	 * Testet die Methode {@link BenutzerDAOImpl#updateBenutzer(Benutzer)}
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {

		List<Benutzer> bListe = benutzerDAO.findAllBenutzer();
		assertTrue(bListe.size() == 6);

		String pNew = "testibus";
		Benutzer bUpdated = bListe.get(1);
		bUpdated.setPassword(pNew);
		
		benutzerDAO.updateBenutzer(bUpdated);
		
		assertTrue(benutzerDAO.findAllBenutzer().size() == 6);
	}

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
