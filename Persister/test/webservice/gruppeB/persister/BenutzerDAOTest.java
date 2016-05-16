/*
 * ZWECK: Praxisprojekt
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package webservice.gruppeB.persister;

import static org.junit.Assert.*;
import entitys.Benutzer;
import entitys.Kontakt;
import entitys.Mitarbeiter;
import entitys.Ort;
import gruppeB.feukora.persister.BenutzerDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der BenutzerDAO-Implementierung zuständig.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class BenutzerDAOTest {

	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void setDown() throws Exception{	
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteBenutzer() throws Exception {
		
		List<Benutzer> benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 2);

		benutzerDAO.deleteBenutzer(benutzerListe.get(0));

		benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 1);
	}
	
	@Test
	public void testDeleteBenutzerById() throws Exception {
		
		List<Benutzer> benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 2);

		//benutzerDAO.deleteBenutzerById(benutzerListe.get(0));

		benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 1);
	}

	@Test
	public void testSaveBenutzer() throws Exception {
		
		List<Benutzer> benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 2);

		Mitarbeiter k = new Mitarbeiter();
		Benutzer b = new Benutzer();

		List<String> kompetenzListe = new ArrayList<>();
		kompetenzListe.add("Prozessmodellierung");

		//b.setKernkompetenzen(kompetenzListe);

		benutzerDAO.saveBenutzer(b);

		benutzerListe = benutzerDAO.findAllBenutzer();
		assertTrue(benutzerListe.size() == 3);
	}

	@Test
	public Benutzer updateBenutzer(Benutzer entity) throws Exception {
		return benutzerDAO.updateBenutzer(entity);
	}

	public Benutzer findBenutzerById(Integer id) {
		return benutzerDAO.findBenutzerById(id);
	}

	public List<Benutzer> findAllBenutzer() {
		return benutzerDAO.findAllBenutzer();
	}

	public List<Benutzer> findBenutzerByPassword(String password) {
		return benutzerDAO.findBenutzerByPassword(password);
	}

	public List<Benutzer> findBenutzerByUsername(String username) {
		return benutzerDAO.findBenutzerByUsername(username);
	}

	public int hashCode() {
		return benutzerDAO.hashCode();
	}

	public String toString() {
		return benutzerDAO.toString();
	}

}
