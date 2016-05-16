package application.view.kontakt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse KontaktErfassen. Hier werden neue
 * Kontaktobjekte erstellt und in der Datenbank gespeichert.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 3.0
 * @since 1.0
 */

public class KontaktErfassen {

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz, txtRolle, txtTelnr, txtEmail;

	@FXML
	private Button btnSpeichern, btnAbbrechen;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	/**
	 * Diese Methode speichert einen neuen Kontakt in der Datenbank.
	 */
	public void kontaktSpeichern() {

		String name = txtNachname.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String rolle = txtRolle.getText();
		String email = txtEmail.getText();
		String telnr = txtTelnr.getText();

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || rolle.isEmpty()
				|| email.isEmpty() || telnr.isEmpty()) {
			lblRueckmeldung.setText(" Bitte alle Felder ausfüllen!");

		} else {

			// Parsen erst nach der Überprüfung da sonst die isEmpty() Methode
			// nicht vorhanden ist
			// muss ahncheinend auf keine neue Variable gespeichert werden
			try {
				Integer.parseInt(rolle);
				Integer.parseInt(telnr);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}

			/*------
			Kontakt newkontakt = creatKontakt(String name, String vorname, String strasse,
					String ort, int rolle, String email, int telnr);
			this.KontaktRO.add(newkontakt);

			************/
		}

	}

	/**
	 * Diese Methode führt den User zum Dashboard zurück
	 */
	public void abbrechen() {

		((Stage) leaf.getScene().getWindow()).close();

	}

	/**
	 * Diese Methode erstellt ein neues Kontaktobjekt.
	 *
	 * @param name
	 *            Name des Kontaktes
	 * @param vorname
	 *            Vorname des Kontaktes
	 * @param strasse
	 *            Strasse des Kontaktes
	 * @param plz
	 *            Plz des Kontaktes
	 * @param ort
	 *            Ort des Kontaktes
	 * @param rolle
	 *            Rolle des Kontaktes (Eigentümer oder Verwaltung)
	 * @param email
	 *            Email-Adresse des Kontaktes
	 * @param telnr
	 *            Telefonnummer des Kontaktes
	 *
	 * @return Ein neues Kontaktobjekt
	 */

	/*---------
	private Kontakt creatKontakt(String name, String vorname, String strasse, int plz,
		String ort, int rolle, String email, int telnr){

	Kontakt kontakt = new Kontakt();

	kontakt.setNachname(name);
	kontakt.setVorname(vorname);
	kontakt.setRolleExtern(rolle);
	kontakt.setStrasseInklNr(strasse);
	kontakt.setEmail(email);
	kontakt.setTel(telnr);


	Ort ortschaft = new Ort();
	ortschaft.setOrt(ort);
	int plz = FindPlzbyOrt(ort);
	ortschaft.setPlz(plz);


	kontakt.setAdresse(ortschaft);

	return kontakt;
	}
	**************/

}
