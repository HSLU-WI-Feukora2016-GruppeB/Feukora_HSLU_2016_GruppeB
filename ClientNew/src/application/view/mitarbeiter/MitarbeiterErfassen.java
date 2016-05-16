package application.view.mitarbeiter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterErfassen. Hier können neue
 * Mitarbeiter erfasst und alte Bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterErfassen {

	@FXML
	private TextField txtName, txtVorname, txtOrt, txtRolle, txtLohn, txtEmail, txtTelefonNr, txtStrasse;
	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void mitarbeiterSpeichern() {

		/*------------ Wir haben arbeitet seit und arbeitet bis (beides GregorianCalendar) noch nicht-----------*/

		// Hole alle Werte von den Textfeldern
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
			try {
				Integer.parseInt(rolle);
				Float.parseFloat(lohn);
				Integer.parseInt(telefonnr);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}

			/*---------
			Mitarbeiter newmitarbeiter = createMitarbeiter(String name, String vorname,String strasse,String ort,
					int rolle, Float lohn, String email, int telefonnr);
			//this.MitarbeiterRO.add(newmitarbeiter);
			*********/
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

	/*-----------------
	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String plz, String ort,
			int rolle, Float lohn, String email, int telefonnr){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Mitarbeiter mitarbeiter = new Mitarbeiter();

		mitarbeiter.setName(name);
		mitarbeiter.setVorname(vorname);
		mitarbeiter.setRolleIntern(rolle);
		mitarbeiter.setStrasseInklNr(strasse);
		mitarbeiter.setLohn(lohn);
		mitarbeiter.setEmail(email);
		mitarbeiter.setTel(telefonnr);

		Ort ortschaft = new Ort();
		ortschaft.setOrt(ort);
		int plz = FindPlzbyOrt(ort);
		ortschaft.setPlz(plz);

		mitarbeiter.setAdresse(ortschaft);


		return mitarbeiter;
	}
	************/
}
