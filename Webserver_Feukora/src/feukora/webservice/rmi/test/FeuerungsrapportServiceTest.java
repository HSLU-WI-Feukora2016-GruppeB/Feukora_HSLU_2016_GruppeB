/*
 * ZWECK: Test der FeuerungsrapportService Klasse
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 */
package feukora.webservice.rmi.test;

import java.util.ArrayList;

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new FeuerungsrapportServiceImpl();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		//Entit�ten
		for (Auftrag a : service.findAllAuftrag()) {
			service.deleteAuftrag(m);
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
			 * M�gliche Tests:
			 * 
			 * 1. Datensatz einf�gen-kontorlle ob dieser eingef�gt wurde
			 * 
			 * 2. Datensatz l�schen - kontrolle ob dieser gel�scht wurde. - 
			 * Darf im Datenbestand nicht mehr vorhanden sein.,
			 *
			 *3. Abruf von Datensatz bsp. Liegenschaft durch 2 verschiede arten,
			 *vergleich ob diese identisch sind oder nicht	
			 *
			 *4. Abruf von Datensatz aufgrund weiterem Kriterium welches mit ERD verkn�pft ist.
			 *Vergleich auf Gr�sse der Listen per Hardcoding
			 *
			 *
			 */
			
			//Beispieldaten
			public List<Student> initStudent() throws Exception {

				/* Student Meier Peter */
				Student peter = new Student("Meier", "Peter", new GregorianCalendar(
						1990, Calendar.FEBRUARY, 20), new Kontakt("pmeier@gmail.com",
						"079 666 66 66"), new Adresse("Pilatusstrasse 12", "Luzern",
						6002), 2);

				/* Speichern */
				service.addStudent(peter);

				/* Student Weber Marco */
				Student marco = new Student("Weber", "Marco", new GregorianCalendar(
						1988, Calendar.APRIL, 25), new Kontakt("mweber@gmail.com",
						"079 555 55 55"),
						new Adresse("Rigistrasse 12", "Ebikon", 6030), 2);

				/* Speichern */
				service.addStudent(marco);

				/* Student Weber Marco */
				Student robert = new Student("Fischer", "Robert",
						new GregorianCalendar(1992, Calendar.AUGUST, 15), new Kontakt(
								"rfischer@gmail.com", "079 444 44 44"), new Adresse(
								"Bachstrasse 12", "Horw", 6048), 3);

				/* Speichern */
				service.addStudent(robert);

				/* Student Bucheli Ivan */
				Student ivan = new Student("Bucheli", "Ivan", new GregorianCalendar(
						1990, Calendar.DECEMBER, 10), new Kontakt("ibucheli@gmail.com",
						"079 333 33 33"),
						new Adresse("Kantonsstrasse 25", "Horw", 6048), 2);

				/* Speichern */
				service.addStudent(ivan);

				ArrayList<Student> studentListe = new ArrayList<>();
				studentListe.add(peter);
				studentListe.add(marco);
				studentListe.add(robert);
				studentListe.add(ivan);

				return studentListe;

			}

			public List<Dozent> initDozent() throws Exception {

				Kontakt k1 = new Kontakt("fzbinden@hslu.ch", "041 228 55 44");
				Kontakt k2 = new Kontakt("rgisler@hslu.ch", "041 255 63 63");

				Adresse a1 = new Adresse("Berglistrasse 7", "Kriens", 6010);
				Adresse a2 = new Adresse("Rigistrasse 2", "Horw", 6048);

				Dozent fritz = new Dozent("Zbinden", "Fritz", k1, a1);
				Dozent rolf = new Dozent("Gisler", "Rolf", k2, a2);

				List<String> kompetenzenZbinden = new ArrayList<>();
				List<String> kompetenzenGisler = new ArrayList<>();

				kompetenzenZbinden.add("Datenbanken");
				kompetenzenZbinden.add("Projektmanagement");

				kompetenzenGisler.add("Datenbanken");
				kompetenzenGisler.add("SW Entwicklung");
				kompetenzenGisler.add("Testen mit JUnit");

				fritz.setKernkompetenzen(kompetenzenZbinden);
				rolf.setKernkompetenzen(kompetenzenGisler);

				service.addDozent(fritz);
				service.addDozent(rolf);

				List<Dozent> dozentenListe = new ArrayList<>();
				dozentenListe.add(fritz);
				dozentenListe.add(rolf);

				return dozentenListe;
			}
			//Init Methoden
			public List<Brenner> initBrenner() throws Exception{
				
				Brennerart bra1 = new Brennerart("Gebl�se");
				Brennerart bra2 = new Brennerart("atmosph�risch");
				Brennerart bra3 = new Brennerart("Verdampfer");
				
				Brennertyp brt1 = new Brennertyp("AC43B");
				Brennertyp brt2 = new Brennertyp("BR42B");
				Brennertyp brt3 = new Brennertyp("CG43B");
				Brennertyp brt4 = new Brennertyp("DC43B");
				Brennertyp brt5 = new Brennertyp("EC66J");
				
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
				
				Waermeerzeugerart waa1 = new Waermeerzeugerart("Gebl�se");
				Waermeerzeugerart waa2 = new Waermeerzeugerart("atmosph�risch");
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
			
			public static List<Modul> initModul() throws Exception {

				
				
				List<Kontakt> lKontakte = new ArrayList<>();
				List<Adresse> lAdressen = new ArrayList<>();
				List<Student> lStudenten = new ArrayList<>();
				List<Dozent> lDozenten = new ArrayList<>();

//				/* zehn Kontakte erstellen */
//				lKontakte.add(new Kontakt("cbucher@hslu.ch", "079 000 00 01"));
//				lKontakte.add(new Kontakt("cerni@hslu.ch", "079 000 00 02"));

//
//				/* zehn Adressen */
//				lAdressen.add(new Adresse("Pilatusstrasse 1", "Luzern", 6000));
//				lAdressen.add(new Adresse("Zentralstrasse 21", "Luzern", 6002));


//				/* sieben Studenten */
//				lStudenten.add(new Student("Bucher", "Christoph",
//						new GregorianCalendar(2082, 10, 10), lKontakte.get(0),
//						lAdressen.get(0), 1));
//				lStudenten.add(new Student("Erni", "Camil", new GregorianCalendar(2081,
//						8, 8), lKontakte.get(1), lAdressen.get(1), 1));
//				lStudenten.add(new Student("Unold", "Andreas", new GregorianCalendar(
//						2084, 7, 7), lKontakte.get(2), lAdressen.get(2), 1));
//				lStudenten.add(new Student("Kaiser", "Christian",
//						new GregorianCalendar(2085, 10, 2), lKontakte.get(3), lAdressen
//								.get(4), 2));
//				lStudenten.add(new Student("Baskin", "Oeskan", new GregorianCalendar(
//						2083, 6, 6), lKontakte.get(4), lAdressen.get(4), 2));
//				lStudenten.add(new Student("Walker", "Daniel", new GregorianCalendar(
//						2082, 4, 11), lKontakte.get(5), lAdressen.get(5), 2));
//				lStudenten.add(new Student("Wicki", "Swen", new GregorianCalendar(2086,
//						9, 12), lKontakte.get(6), lAdressen.get(6), 2));

//				/* drei Dozenten */
//				lDozenten.add(new Dozent("Zbinden", "Fritz", lKontakte.get(7),
//						lAdressen.get(7)));
//				lDozenten.add(new Dozent("Sucur", "Jordan", lKontakte.get(8), lAdressen
//						.get(8)));
//				lDozenten.add(new Dozent("Mathis", "Erwin", lKontakte.get(9), lAdressen
//						.get(9)));
//
//				lDozenten.get(0).setKernkompetenzen(Arrays.asList("Datenbanken"));
//				lDozenten.get(1)
//						.setKernkompetenzen(
//								Arrays.asList("Datenbanken", "SW Entwicklung",
//										"Testen", "JSF"));
//				lDozenten.get(2).setKernkompetenzen(
//						Arrays.asList("Datenbanken", "SW Entwicklung",
//								"Projektmanagement", "ITIL"));

				/* Ein Modul mit einem Dozenten und drei Studierenden */
				Modul datenbanken = new Modul("Datenbanken", 1);

				datenbanken.getDozentenListe().add(lDozenten.get(0));

				datenbanken.getStudentenListe().add(lStudenten.get(0));
				datenbanken.getStudentenListe().add(lStudenten.get(1));
				datenbanken.getStudentenListe().add(lStudenten.get(2));

				/* Ein Modul mit drei Dozenten und f�nf Studierenden */
				Modul programmieren = new Modul("Programmieren", 1);

				programmieren.getDozentenListe().add(lDozenten.get(0));
				programmieren.getDozentenListe().add(lDozenten.get(1));
				programmieren.getDozentenListe().add(lDozenten.get(2));

				/* Camil Erni besucht auch das Modul Programmieren */
				programmieren.getStudentenListe().add(lStudenten.get(1));
				programmieren.getStudentenListe().add(lStudenten.get(3));
				programmieren.getStudentenListe().add(lStudenten.get(4));
				programmieren.getStudentenListe().add(lStudenten.get(5));
				programmieren.getStudentenListe().add(lStudenten.get(6));

				List<Modul> lModule = new ArrayList<>();
				lModule.add(datenbanken);
				lModule.add(programmieren);

				/* Speichern */
				for (int i = 0; i < lBrenner.size(); i++) {
					lBrenner.get(i).setId(
							service.addBrenner(lBrenner.get(i)).getId());
				}

				for (int i = 0; i < lDozenten.size(); i++) {
					lDozenten.get(i).setId(service.addDozent(lDozenten.get(i)).getId());
				}

				for (Modul m : lModule) {
					m = service.addModul(m);
				}

				return lModule;
			}
		}
}
