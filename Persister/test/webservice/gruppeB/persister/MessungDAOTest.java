package webservice.gruppeB.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Messung;
import entitys.Mitarbeiter;
import entitys.Ort;
import entitys.Waermeerzeuger;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import gruppeB.feukora.persister.BrennerDAOImpl;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import gruppeB.feukora.persister.KontaktDAOImpl;
import gruppeB.feukora.persister.LiegenschaftDAOImpl;
import gruppeB.feukora.persister.MessungDAOImpl;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse ist für das Testen der MessungDAO-Implementierung zuständig.
 * 
 * @version 1.0
 * @author Luca Raneri
 */
public class MessungDAOTest {

	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	private static BrennerDAOImpl brennerDAO = new BrennerDAOImpl();
	private static FeuerungsanlageDAOImpl feuerungsanlageDAO = new FeuerungsanlageDAOImpl();
	private static KontaktDAOImpl kontaktDAO = new KontaktDAOImpl();
	private static LiegenschaftDAOImpl liegenschaftDAO = new LiegenschaftDAOImpl();
	private static MessungDAOImpl messungDAO = new MessungDAOImpl();
	private static MitarbeiterDAOImpl mitarbeiterDAO = new MitarbeiterDAOImpl();
	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	private static WaermeerzeugerDAOImpl waermeerzeugerDAO = new WaermeerzeugerDAOImpl();
	
	@Before
	public void setUp() throws Exception {
		MessungDAOTest.init();
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#updateMessung(entitys.Messung)}.
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
	
		List<Messung> messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 4);
		
		GregorianCalendar altDatum = new GregorianCalendar(2011, 7, 3);
		Messung m = messungDAO.findByMessDatum(altDatum).get(0);
		assertNotNull(m);
		
		GregorianCalendar neuDatum = new GregorianCalendar(2016, 5, 18);
		m.setMessDatum(neuDatum);
		
		messungDAO.updateMessung(m);
		
		Messung aDB = messungDAO.findByMessDatum(neuDatum).get(0);
		assertNotNull(aDB);
		assertTrue(aDB.getMessDatum() != altDatum);
		
		messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 4);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#findAllMessung()}.
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception{
		
		List<Messung> messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 4);
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#deleteMessung(Messung).}
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		List<Messung> messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 4);

		messungDAO.deleteMessung(messungsListe.get(0));

		messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 3);

	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#findByMessDatum(GregorianCalendar)}.
	 * @throws Exception
	 */
	@Test
	public void testFindByMessDatum() throws Exception{
		
		GregorianCalendar d = new GregorianCalendar(2011, 7, 3);
		List<Messung> m = messungDAO.findByMessDatum(d);
		
		assertNotNull(m);
		assertEquals(1,m.size());
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#findByBeurteilungNotOk(boolean)}.
	 * @throws Exception
	 */
	@Test
	public void testFindByBeurteilungNotOk() throws Exception{
				
		List<Messung> m = messungDAO.findByBeurteilungNotOk(true);
		
		assertNotNull(m);
		assertEquals(1,m.size());
		
	}
	
	/**
	 * Dieser Test tested die Methode {@link MessungDAOImpl#deleteMessungById(Integer)}.
	 * @throws Exception
	 */
	@Test
	public void testDeleteById() throws Exception {
		
		List<Messung> messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 4);

		messungDAO.deleteMessungById(messungsListe.get(0).getIdMessung());

		messungsListe = messungDAO.findAllMessung();
		assertTrue(messungsListe.size() == 3);
	}
	
	
	/**
	 * Initialisiert die Objekte welche für die Tests verwendet werden.
	 * @return
	 * @throws Exception
	 */
	public static List<Messung> init() throws Exception {
		
		MessungDAOTest.deleteAll();
		
		List<Messung> lMessung = new ArrayList<>();
				
		//4 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true, 4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8, false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8, false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true, 4, 111, 22, 99, 3, 5));
		lMessung.get(0).setBeurteilungNotOk(true);
		
		for(Messung m : lMessung){
			messungDAO.saveMessung(m);
		}
		
		return lMessung;
	}
	
	/**
	 * Loescht alle Objekte aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		deleteAllMessungen();
		
		for(Liegenschaft l : liegenschaftDAO.findAllLiegenschaft()){
			liegenschaftDAO.deleteLiegenschaft(l);
		}
		for(Feuerungsanlage f : feuerungsanlageDAO.findAllFeuerungsanlage()){
			feuerungsanlageDAO.deleteFeuerungsanlage(f);
		}
		for(Brenner b : brennerDAO.findAllBrenner()){
			brennerDAO.deleteBrenner(b);
		}
		for(Waermeerzeuger w : waermeerzeugerDAO.findAllWaermeerzeuger()){
			waermeerzeugerDAO.deleteWaermeerzeuger(w);
		}
		for(Mitarbeiter m : mitarbeiterDAO.findAllMitarbeiter()){
			mitarbeiterDAO.deleteMitarbeiter(m);
		}
		for(Benutzer b : benutzerDAO.findAllBenutzer()){
			benutzerDAO.deleteBenutzer(b);
		}
		for(Kontakt k : kontaktDAO.findAllKontakte()){
			kontaktDAO.deleteKontakt(k);
		}
		for(Ort o : ortDAO.findAllOrt()){
			ortDAO.deleteOrt(o);
		}

	}

	/**
	 * Loescht alle Messungs-Objekte aus der Datenbank.
	 * @throws Exception
	 */
	public static void deleteAllMessungen() throws Exception {

		for (Messung m : messungDAO.findAllMessung()) {
			messungDAO.deleteMessung(m);
		}
	}
}
