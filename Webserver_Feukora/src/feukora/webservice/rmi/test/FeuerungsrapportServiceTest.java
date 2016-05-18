package feukora.webservice.rmi.test;

/*
 * ZWECK: Test der FeuerungsrapportService Klasse
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entitys.Brenner;
import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImpl;

/**
 * Diese Klasse Testet die Funktionen von FeuerungsrapportService 
 * (WebService-Schnittstelle) auf Fehler.
 * 
 * @author Dominik
 * @version 1.0.0
 * @since 1.0.0
 * 
 */

public class FeuerungsrapportServiceTest {
	
		static FeuerungsrapportService fservice;


		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			service = new FeuerungsrapportServiceImpl();
			
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
			
			//Entitäten
			for (Waermeerzeuger w : service.findAllWaermeerzeuger()) {
				service.deleteWaermeerzeuger(m);
			}

			for (Brenner b : service.findAllBrenner()) {
				service.deleteBrenner(s);
			}

			for (Feuerungsanlage f : service.findAllFeuerungsanlage()) {
				service.deleteFeuerungsanlage(d);
				
		@After
		public void tearDown() throws Exception {
		}
				/*
				 * Mögliche Tests:
				 * 
				 * 1. Datensatz einfügen-kontorlle ob dieser eingefügt wurde
				 * 
				 * 2. Datensatz löschen - kontrolle ob dieser gelöscht wurde. - 
				 * Darf im Datenbestand nicht mehr vorhanden sein.,
				 *
				 *3. Abruf von Datensatz bsp. Liegenschaft durch 2 verschiede arten,
				 *vergleich ob diese identisch sind oder nicht	
				 *
				 *4. Abruf von Datensatz aufgrund weiterem Kriterium welches mit ERD verknüpft ist.
				 *Vergleich auf Grösse der Listen per Hardcoding
				 *
				 *
				 */



	@Test
	public void testAddBrenner() throws Exception {
	initBrenner();
	}
	
	@Test
	public void testUpdateBrenner() throws Exception {
		initBrenner();
		// b3 holen
		List<Brenner> brListe=service.findByTyp("brt5");
		assertTrue(brListe.size() == 1);
		
		Brenner brenner = dListe.get(0);
		
		Brennerart brennerartVorUpdate = brenner.getBrennerArtString();
		// bra2 ("atmospärisch")
		
		assertTrue("atmospärisch".equals(brennerartVorUpdate.getBrennerArtString()));
		
		/*
		 * Neuer Brennerart erstellen, b3 wird von Brennerart bra2 
		 * "atmospärisch" auf bra4 "Kompression" umgesetzt
		 */
		Brennerart bra4 = new Brennerart("Kompression");
		brenner.setBrennerArt(bra4);
		
		/*Updaten*/
		service.updateBrenner(brenner);
		
		/* AlleBrenner aus Datenbank holen*/
		List<Brenner> alleBrenner = service.
		
	}
	//Init Methoden
	public List<Brenner> initBrenner() throws Exception{
		
		Brennerart bra1 = new Brennerart("Gebläse");
		Brennerart bra2 = new Brennerart("atmosphärisch");
		Brennerart bra3 = new Brennerart("Verdampfer");
		
		Brennertyp brt1 = new Brennertyp("AC43B");
		Brennertyp brt2 = new Brennertyp("BR42B");
		Brennertyp brt3 = new Brennertyp("CG43B");
		Brennertyp brt4 = new Brennertyp("DC43B");
		Brennertyp brt5 = new Brennertyp("EC66J");
		
		int j1995 = 1995;
		Baujahr j1996 = new Baujahr(1996);
		Baujahr j1997 = new Baujahr(1997);
		Baujahr j1998 = new Baujahr(1998);
		Baujahr j1999 = new Baujahr(1999);
		Baujahr j2000 = new Baujahr(2000);
		Baujahr j2001 = new Baujahr(2001);
		Baujahr j2002 = new Baujahr(2002);
		Baujahr j2003 = new Baujahr(2003);
		Baujahr j2004 = new Baujahr(2004);
		
		/*Brenner 1*/
		 Brenner b1 = new Brenner(bra1,brt1,j1995);
		 service.addBrenner(b1);
		 
		 /*Brenner 2*/
		 Brenner b2 = new Brenner(bra3,brt3,j1998);
		 service.addBrenner(b2);
		 
		 /*Brenner 3*/
		 Brenner b3 = new Brenner(bra2,brt5,j2004);
		 service.addBrenner(b3);
		 
		 /*Brenner 4*/
		 Brenner b4 = new Brenner(bra2,brt2,j2001);
		 service.addBrenner(b4);
		 
		 
		 ArrayList<Brenner> brennerListe = new ArrayList<>();
		 	brennerListe.add(b1);
		 	brennerListe.add(b2);
		 	brennerListe.add(b3);
			brennerListe.add(b4);
			
			return brennerListe;
	}
	public List<Waermeerzeuger> initWaermeerzeuger() throws Exception {
		
		Waermeerzeugerart waa1 = new Waermeerzeugerart("Gebläse");
		Waermeerzeugerart waa2 = new Waermeerzeugerart("atmosphärisch");
		Waermeerzeugerart waa3 = new Waermeerzeugerart("Verdampfer");
		
		Waermeerzeugertyp wat1 = new Waermeerzeugertyp("AC43B");
		Waermeerzeugertyp wat2 = new Waermeerzeugertyp("BR42B");
		Waermeerzeugertyp wat3 = new Waermeerzeugertyp("CG43B");
		Waermeerzeugertyp wat4 = new Waermeerzeugertyp("DC43B");
		Waermeerzeugertyp wat5 = new Waermeerzeugertyp("EC66J");
		
		Baujahr j1995 = new Baujahr(1995);
		Baujahr j1996 = new Baujahr(1996);
		Baujahr j1997 = new Baujahr(1997);
		Baujahr j1998 = new Baujahr(1998);
		Baujahr j1999 = new Baujahr(1999);
		Baujahr j2000 = new Baujahr(2000);
		Baujahr j2001 = new Baujahr(2001);
		Baujahr j2002 = new Baujahr(2002);
		Baujahr j2003 = new Baujahr(2003);
		Baujahr j2004 = new Baujahr(2004);
		
		/*Brenner 1*/
		Waermeerzeuger w1 = new Waermeerzeuger(waa1,wat1,j1995);
		 service.addBrenner(w1);
		 
		 /*Brenner 2*/
		 Waermeerzeuger w2 = new Waermeerzeuger(waa3,wat3,j1998);
		 service.addBrenner(w2);
		 
		 /*Brenner 3*/
		 Waermeerzeuger w3 = new Waermeerzeuger(waa2,wat5,j2004);
		 service.addBrenner(w3);
		 
		 /*Brenner 4*/
		 Waermeerzeuger w4 = new Waermeerzeuger(waa2,wat2,j2001);
		 service.addWaermeerzeuger(w4);
		 
		 
		 ArrayList<Waermeerzeuger> waermeerzeugerListe = new ArrayList<>();
		 	waermeerzeugerListe.add(w1);
		 	waermeerzeugerListe.add(w2);
		 	waermeerzeugerListe.add(w3);
		 	waermeerzeugerListe.add(w4);
			
			return waermeerzeugerListe;
	}

}