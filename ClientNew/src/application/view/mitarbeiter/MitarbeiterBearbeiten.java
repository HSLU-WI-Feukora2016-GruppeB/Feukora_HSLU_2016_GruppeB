package application.view.mitarbeiter;


import java.time.LocalDate;
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
	static GregorianCalendar startdatum, enddatum;



	static Mitarbeiter maupdate;

	public void initialize() {
		txtName.setText(name);
		txtVorname.setText(vorname);
		txtStrasse.setText(strasse);
		txtOrt.setText(ort);
		txtRolle.setText(rolle);
		txtLohn.setText(lohn2);
		txtEmail.setText(email);
		txtTelefonNr.setText(telefon);
		startDatum.setValue(gregToLocal(startdatum));

	}

	public static void bekommeMitarbeiter(Mitarbeiter mabearbeitet) {
		maupdate = mabearbeitet;

		name = mabearbeitet.getName().toString();
		vorname = mabearbeitet.getVorname();
		strasse = mabearbeitet.getStrasse();
		ort = mabearbeitet.getOrt().getOrt();
		rolle = mabearbeitet.getRolleIntern().toString();
		Integer lohn = (Integer) mabearbeitet.getLohn();
		lohn2 = lohn.toString();
		email = mabearbeitet.getEmail();
		telefon = mabearbeitet.getTel().toString();
		startdatum = mabearbeitet.getArbeitetSeit();

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

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || ort.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {
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
					rolleint,lohnint, email,telefonnr);
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
	 * Diese Methode führt den User zur Übersicht MitarbeierÜbersicht zurück.
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
			int rolle, int lohn, String email, String telefonnr){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Ort ortschaft = new Ort();

		maupdate.setName(name);
		maupdate.setVorname(vorname);
		maupdate.setRolleIntern(rolle);
		maupdate.setStrasse(strasse);
		maupdate.setLohn(lohn);
		maupdate.setEmail(email);
		maupdate.setTel(telefonnr);

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
	private LocalDate gregToLocal(GregorianCalendar startdatum){
		int starttag = startdatum.DAY_OF_MONTH;
		int startmonat = startdatum.MONTH;
		int startjahr = startdatum.YEAR;

		LocalDate ldstartDatum = LocalDate.of(startjahr, startmonat, starttag);

		return ldstartDatum;

	}


}
