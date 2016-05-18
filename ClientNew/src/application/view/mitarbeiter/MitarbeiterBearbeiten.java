package application.view.mitarbeiter;

import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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

	@FXML
	private TextField txtName, txtVorname, txtOrt, txtRolle, txtLohn, txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

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
	}

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void mitarbeiterUpdate() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
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
			int rolleint = 0, lohnint = 0;

			try {
				Integer.parseInt(rolle);
				Integer.parseInt(lohn);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}


			Mitarbeiter updatemitarbeiter = createMitarbeiter(name, vorname,strasse, ort,
					rolleint,lohnint, email,telefonnr);
			//this.MitarbeiterRO.update(updatemitarbeiter);

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


	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort,
			int rolle, int lohn, String email, String telefonnr){
		//Exception werfen? bei Referenzprojekt hat ers gemacht



		maupdate.setName(name);
		maupdate.setVorname(vorname);
		maupdate.setRolleIntern(rolle);
		maupdate.setStrasse(strasse);
		maupdate.setLohn(lohn);
		maupdate.setEmail(email);
		maupdate.setTel(telefonnr);

		Ort ortschaft = OrtRO.findByOrtBez(ort);


		maupdate.setOrt(ortschaft);


		return maupdate;
	}


}
