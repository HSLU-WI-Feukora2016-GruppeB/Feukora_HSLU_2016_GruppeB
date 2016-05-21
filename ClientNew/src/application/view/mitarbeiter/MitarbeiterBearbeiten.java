package application.view.mitarbeiter;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.MitarbeiterRO;
import rmi.OrtRO;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterErfassen. Hier können neue
 * Mitarbeiter erfasst und alte Bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterBearbeiten {

	OrtRO OrtRO;
	MitarbeiterRO  MitarbeiterRO;


	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ, txtRolle, txtLohn, txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private DatePicker startDatum, endDatum;

	@FXML
	private Pane leaf;



	static String name;
	static String vorname;
	static String strasse;
	static String ort;
	static String rolle;
	static String email;
	static String telefon;
	static String lohn2;
	static String plz;
	static GregorianCalendar startdatum,enddatum;



	static Mitarbeiter maupdate;

	public void initialize(){


		String url = "rmi://192.168.43.4:10099/";
		String MitarbeiterROName = "Mitarbeiter";
		String OrtROName = "Ort";

		try {
			this.MitarbeiterRO = (MitarbeiterRO) Naming.lookup(url + MitarbeiterROName);
			this.OrtRO = (OrtRO) Naming.lookup(url + OrtROName);
			System.out.println("yeah au das fonzt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}


		txtName.setText(name);
		txtVorname.setText(vorname);
		txtStrasse.setText(strasse);
		txtOrt.setText(ort);
		txtPLZ.setText(plz);
		txtRolle.setText(rolle);
		txtLohn.setText(lohn2);
		txtEmail.setText(email);
		txtTelefonNr.setText(telefon);
		startDatum.setValue(gregToLocal(startdatum));
		endDatum.setValue(gregToLocal(enddatum));

	}

	public static void bekommeMitarbeiter(Mitarbeiter mabearbeitet) throws Exception{
		maupdate = mabearbeitet;

		name = mabearbeitet.getName();
		vorname = mabearbeitet.getVorname();
		strasse = mabearbeitet.getStrasse();
		ort = mabearbeitet.getOrt().getOrt();
		plz = String.valueOf(mabearbeitet.getOrt().getPlz());
		rolle = mabearbeitet.getRolleIntern().toString();
		Integer lohn = (Integer) mabearbeitet.getLohn();
		lohn2 = lohn.toString();
		email = mabearbeitet.getEmail();
		telefon = mabearbeitet.getTel().toString();

		startdatum = mabearbeitet.getArbeitetSeit();

		enddatum = mabearbeitet.getArbeitetBis();

	}

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void mitarbeiterUpdate() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPLZ.getText();
		String rolle = txtRolle.getText();
		String lohn = txtLohn.getText();
		String email = txtEmail.getText();
		String telefonnr = txtTelefonNr.getText();
		LocalDate enddatum = endDatum.getValue();
		LocalDate startdatum = startDatum.getValue();


		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || ort.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty() ||
				enddatum.toString().isEmpty() || startdatum.toString().isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

			//Das arbeitet seit: in GregorianCalendar Format umwandeln
			int starttag = startdatum.getDayOfMonth();
			int startmonat = startdatum.getMonthValue();
			int startjahr = startdatum.getYear();
			GregorianCalendar gcalstart = new GregorianCalendar(startjahr, startmonat, starttag);

			// Das arbeitet bis: in GregorianCalendar umwandeln
			int endtag = enddatum.getDayOfMonth();
			int endmonat = enddatum.getMonthValue();
			int endjahr = enddatum.getYear();
			GregorianCalendar gcalend = new GregorianCalendar(endjahr, endmonat, endtag);
			// Parsen erst nach der Überprüfung da sonst die isEmpty() Methode
			// nicht vorhanden ist

			// Neue Variabeln für das Parsen
			int rolleint = 0, lohnint = 0, plzint =0;

			try {
				rolleint = Integer.parseInt(rolle);
				lohnint = Integer.parseInt(lohn);
				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}


			Mitarbeiter updatemitarbeiter = createMitarbeiter(name, vorname,strasse, ort, plzint,
					rolleint,lohnint, email,telefonnr,gcalstart,gcalend);
			try {
				//braucht es dieses this? überspeichere ich wirklich das alte Objekt?
				//evtl lösung könnte sein das alte einfach löschen und ein neue erstellen
				this.MitarbeiterRO.update(updatemitarbeiter);
			} catch (Exception e) {
				lblRueckmeldung.setText("Das überscheiben hat nicht funktioniert");
				e.printStackTrace();
			}

		}
	}

	/**
	 * Diese Methode führt den User zur Übersicht Rapportsübersicht zurück.
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

	/**
	 * Diese Methode erstellt ein neues Mitarbeiterobjekt.
	 *
	 * @param name
	 *            Name des Mitarbeiters
	 * @param vorname
	 *            Vorname des Mitarbeiters
	 * @param strasse
	 *            Strasse des Mitarbeiters
	 * @param plz
	 *            Plz des Mitarbeiters
	 * @param ort
	 *            Ort des Mitarbeiters
	 * @param rolle
	 *            Rolle des Mitarbeiters (Backoffice, Admin oder
	 *            Feuerungskontrolleur)
	 * @param lohn
	 *            Lohn des Mitarbeiters
	 * @param email
	 *            Email-Adresse des Kontaktes
	 * @param telnr
	 *            Telefonnummer des Kontaktes
	 *
	 * @return Ein neues Mitarbeiterobjekt
	 */
	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort, int plz,
			int rolle, int lohn, String email, String telefonnr, GregorianCalendar gcalstart, GregorianCalendar gcalend){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Ort ortschaft = new Ort();

		maupdate.setName(name);
		maupdate.setVorname(vorname);
		try {
			maupdate.setRolleIntern(rolle);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		maupdate.setStrasse(strasse);
		maupdate.setLohn(lohn);
		maupdate.setEmail(email);
		maupdate.setTel(telefonnr);
		maupdate.setArbeitetSeit(gcalstart);
		maupdate.setArbeitetBis(gcalend);

		try {
			//zu erst auf liste speichern damit man nachher das zweite der Liste prüfen kann falls nicht übereinstimmt
		 ortschaft = OrtRO.findByOrtPlz(plz).get(0);
		} catch (Exception e) {
			lblRueckmeldung.setText("PLZ nicht gefunden");
		}

		String ortvondb = ortschaft.getOrt();
		if(ort.equals(ortvondb)){
		maupdate.setOrt(ortschaft);
		}else{
			//prüfe zweites objekt auf der Liste
		}


		return maupdate;
	}

	/**
	 * Diese Funkion wandelt das startdatum bekommeMitarbeiter() um
	 * und wird dann wieder bei der initialize() aufgerufen
	 *
	 * @param startdatum
	 * @return LocalDate
	 */
	private LocalDate gregToLocal(GregorianCalendar changecal){

		Date zwischendate = changecal.getTime();

		LocalDate ldstartDatum = zwischendate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ldstartDatum;

	}

}
