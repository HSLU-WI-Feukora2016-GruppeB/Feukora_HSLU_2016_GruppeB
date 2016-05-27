package dbInit;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Benutzer;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Messung;
import entitys.Mitarbeiter;
import entitys.Ort;
import entitys.Waermeerzeuger;
import gruppeB.feukora.persister.AuftragDAOImpl;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import gruppeB.feukora.persister.BrennerDAOImpl;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import gruppeB.feukora.persister.KontaktDAOImpl;
import gruppeB.feukora.persister.LiegenschaftDAOImpl;
import gruppeB.feukora.persister.MessungDAOImpl;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import gruppeB.feukora.persister.OrtDAOImpl;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;

/**
 * Initialisiert die Datenbank mit Testwerten.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class DbInit {
	
	private static AuftragDAOImpl auftragDAO = new AuftragDAOImpl();
	private static BenutzerDAOImpl benutzerDAO = new BenutzerDAOImpl();
	private static BrennerDAOImpl brennerDAO = new BrennerDAOImpl();
	private static FeuerungsanlageDAOImpl feuerungsanlageDAO = new FeuerungsanlageDAOImpl();
	private static KontaktDAOImpl kontaktDAO = new KontaktDAOImpl();
	private static LiegenschaftDAOImpl liegenschaftDAO = new LiegenschaftDAOImpl();
	private static MessungDAOImpl messungDAO = new MessungDAOImpl();
	private static MitarbeiterDAOImpl mitarbeiterDAO = new MitarbeiterDAOImpl();
	private static OrtDAOImpl ortDAO = new OrtDAOImpl();
	private static WaermeerzeugerDAOImpl waermeerzeugerDAO = new WaermeerzeugerDAOImpl();

	public static void main(String[] args) {
		
		try {
			DbInit.init();
		} catch (Exception e) {
			System.out.println("Konnte nicht initialisiert werden!");
			e.printStackTrace();
		}

	}
	
	/**
	 * Initialisiert die Datenbank mit Testwerten
	 * @return
	 * @throws Exception
	 */
	public static List<Auftrag> init() throws Exception {
		DbInit.deleteAll();

		List<Benutzer> lBenutzer = new ArrayList<>();
		List<Brenner> lBrenner = new ArrayList<>();
		List<Feuerungsanlage> lFeuerungsanlage = new ArrayList<>();
		List<Kontakt> lKontakt = new ArrayList<>();
		List<Liegenschaft> lLiegenschaft = new ArrayList<>();
		List<Messung> lMessung = new ArrayList<>();
		List<Mitarbeiter> lMitarbeiter = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();
		List<Waermeerzeuger> lWaermeerzeuger = new ArrayList<>();
		List<Auftrag> lAuftrag = new ArrayList<>();

		//6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));
		lBenutzer.add(new Benutzer("admin", "admin"));


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
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(1), lWaermeerzeuger.get(1), 88));
		lFeuerungsanlage.add(new Feuerungsanlage(lBrenner.get(2), lWaermeerzeuger.get(2), 46));

		//5 Orte
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

		//6 Liegenschaften erstellen
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(0), "Hausmeister bei Muster klingeln", "Abcweg 123", lOrt.get(3),lFeuerungsanlage.get(0)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(1), "07978885599 anrufen bei Ankunft", "Musterweg 456", lOrt.get(4),lFeuerungsanlage.get(1)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(3), "Türe ist offen", "Musterweg 456", lOrt.get(5),lFeuerungsanlage.get(2)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(4), "Einfach reinkommen", "Hirschengraben 6", lOrt.get(2),lFeuerungsanlage.get(2)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(5), "Türe ist offen", "Rösslimatte 666", lOrt.get(1),lFeuerungsanlage.get(2)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(6), "Türe ist offen", "Grebli 1", lOrt.get(0),lFeuerungsanlage.get(2)));
		lLiegenschaft.add(new Liegenschaft(lKontakt.get(7), "Türe ist offen", "Hinterhof 96", lOrt.get(6),lFeuerungsanlage.get(2)));

		//8 Messungen erstellen
		lMessung.add(new Messung(new GregorianCalendar(2011, 7, 3), 4, 8, true, 4, 100, 60, 120, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 8, 2), 4, 8, false, 4, 130, 55, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2012, 10, 5), 4, 8, false, 4, 100, 60, 75, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2011, 4, 7), 4, 8, true, 4, 111, 22, 99, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2014, 2, 9), 4, 8, true, 4, 130, 60, 200, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2015, 1, 10), 4, 8, false, 4, 140, 99, 150, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2016, 6, 29), 4, 8, false, 4, 133, 100, 70, 3, 5));
		lMessung.add(new Messung(new GregorianCalendar(2009, 7, 30), 4, 8, true, 4, 150, 60, 55, 9, 5));
		lMessung.add(new Messung(new GregorianCalendar(2013, 8, 31), 4, 8, false, 4, 150, 44, 70, 3, 49));
		lMessung.add(new Messung(new GregorianCalendar(2014, 12, 5), 4, 8, false, 4, 99, 67, 70, 3, 389));

		//6 Mitarbeiter erstellen
		lMitarbeiter.add(new Mitarbeiter("Olivia", "Wassmer", "Musterstrasse 1", lOrt.get(3), "1234567678", "o.w@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Matthias", "Perrollaz", "Musterstrasse 2", lOrt.get(4), "1234557678", "m.p@feukora.ch", 2, lBenutzer.get(4), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Dominik", "Stirnimann", "Musterstrasse 3", lOrt.get(3), "1234367678", "d.s@feukora.ch", 1, lBenutzer.get(3), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Pascal", "Steiner", "Musterstrasse 4", lOrt.get(2), "1234567678", "p.st@feukora.ch", 1, lBenutzer.get(2), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Luca", "Raneri", "Musterstrasse 5", lOrt.get(1), "1234567178", "l.r@feukora.ch", 1, lBenutzer.get(1), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Alexandra", "Lengen", "Musterstrasse 1", lOrt.get(0), "1234563678", "a.l@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Feukora", "Admin", "Adminstrasse 1", lOrt.get(0), "1234563678", "admin@feukora.ch", 1, lBenutzer.get(6), 5000, new GregorianCalendar(2016, 05, 1), new GregorianCalendar(2018, 8, 11)));

		//3 Aufträge erstellen
		lAuftrag.add(new Auftrag(lKontakt.get(0), lLiegenschaft.get(0), lMessung.get(0), lMessung.get(1), lMessung.get(2), lMessung.get(0), true, false, "Keine", lMitarbeiter.get(0), new GregorianCalendar(2016, 6, 8), 1, 1));
		lAuftrag.add(new Auftrag(lKontakt.get(1), lLiegenschaft.get(1), lMessung.get(1), lMessung.get(2), lMessung.get(3), lMessung.get(1), true, false, "Bekommen bald neue Feuerungsanlage", lMitarbeiter.get(1), new GregorianCalendar(2016, 6, 10), 1, 1));
		lAuftrag.add(new Auftrag(lKontakt.get(2), lLiegenschaft.get(2), lMessung.get(2), lMessung.get(3), lMessung.get(4), lMessung.get(2), false, true, "-", lMitarbeiter.get(2), new GregorianCalendar(2016, 6, 9), 3, 2));
		lAuftrag.add(new Auftrag(lKontakt.get(3), lLiegenschaft.get(3), lMessung.get(3), lMessung.get(4), lMessung.get(5), lMessung.get(3), false, true, "", lMitarbeiter.get(3), new GregorianCalendar(2016, 6, 22), 4, 2));
		lAuftrag.add(new Auftrag(lKontakt.get(4), lLiegenschaft.get(4), null, null, null, null, false, true, "???", lMitarbeiter.get(4), new GregorianCalendar(2016, 6, 23), 1, 2));
		lAuftrag.add(new Auftrag(lKontakt.get(4), lLiegenschaft.get(4), lMessung.get(4), lMessung.get(5), lMessung.get(6), lMessung.get(4), false, true, "war niemand zuhause", lMitarbeiter.get(4), new GregorianCalendar(2016, 6, 23), 1, 2));
		lAuftrag.add(new Auftrag(lKontakt.get(5), lLiegenschaft.get(5), lMessung.get(5), lMessung.get(6), lMessung.get(7), lMessung.get(5), false, true, "Heizung defekt", lMitarbeiter.get(5), new GregorianCalendar(2016, 6, 24), 4, 2));

		for(Benutzer b : lBenutzer){
			benutzerDAO.saveBenutzer(b);
		}

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

		/*Wird nicht benötigt, da Cascade.ALL bei Messung*/
		for(Messung m : lMessung){
			messungDAO.saveMessung(m);
		}

		for(Mitarbeiter m : lMitarbeiter){
			mitarbeiterDAO.saveMitarbeiter(m);
		}

		for(Auftrag a : lAuftrag){
			auftragDAO.saveAuftrag(a);
		}

		return lAuftrag;
	}

	/**
	 * Löscht alle initialisierten Daten aus der Datenbank.
	 * @throws Exception
	 */
	private static void deleteAll() throws Exception {

		for (Auftrag a : auftragDAO.findAllAuftrag()) {
			auftragDAO.deleteAuftrag(a);
		}

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
		for(Messung m : messungDAO.findAllMessung()){
			messungDAO.deleteMessung(m);
		}
	}

}
