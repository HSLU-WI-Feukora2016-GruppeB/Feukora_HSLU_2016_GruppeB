package application.view.kontakt;


import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import application.Main;
import feukora.webservice.rmi.Kontakt;
import feukora.webservice.rmi.Ort;


/**
 * Diese Klasse behandelt das Updaten eines Kontaktes
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 */
public class KontaktBearbeiten {

	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ, txtEmail, txtTelefonNr, txtStrasse;

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
	static String plz;

	static entitys.Kontakt kontaktupdate;
	
	/**
	 * Initialisiert die Felder von bekommeMitarbeiter()
	 *
	 * @throws Exception
	 */
	public void initialize() throws Exception {

		txtName.setText(name);
		txtVorname.setText(vorname);
		txtStrasse.setText(strasse);
		txtOrt.setText(ort);
		txtPLZ.setText(plz);
		txtEmail.setText(email);
		txtTelefonNr.setText(telefon);

	}

	/**
	 * Erhält den in der KontaktUebersicht ausgewählten Kontakt und speicher ihn auf variabeln
	 *
	 * @param kontaktbearbeitet
	 * @throws Exception
	 */
	public static void bekommeKontakt(entitys.Kontakt kontaktbearbeitet) throws Exception {
		kontaktupdate = kontaktbearbeitet;

		name = kontaktbearbeitet.getNachname();
		vorname = kontaktbearbeitet.getVorname();
		strasse = kontaktbearbeitet.getStrasse();
		ort = kontaktbearbeitet.getOrt().getOrt();
		plz = String.valueOf(kontaktbearbeitet.getOrt().getPlz());
		email = kontaktbearbeitet.getEmail();
		telefon = kontaktbearbeitet.getTel().toString();

	}

	/**
	 * Diese Methode updatet einen Mitarbeier.
	 */
	public void kontaktUpdate() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPLZ.getText();
		String email = txtEmail.getText();
		String telefonnr = txtTelefonNr.getText();

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || plz.isEmpty()
				|| email.isEmpty() || telefonnr.isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

			// Neue Variabeln für das Parsen
			int plzint = 0;

			try {

				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}

			try {
				
				Kontakt updatekontakt = updateKontakt(name, vorname, strasse, ort, plzint, email, telefonnr);
				Kontakt kontakt = updatekontakt;
				
				// braucht es dieses this? überspeichere ich wirklich das alte
				// Objekt?
				// evtl lösung könnte sein das alte einfach löschen und ein neue
				// erstellen
				Main.getFeuerungsRapportService().updateKontakt(updatekontakt);
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
	 * setzt die neuen Werte in das alte Objekt
	 *
	 * @param name
	 * @param vorname
	 * @param strasse
	 * @param ort
	 * @param plz
	 * @param email
	 * @param telefonnr
	 * @return
	 * @throws Exception
	 */
	private Kontakt updateKontakt(String name, String vorname, String strasse, String ort, int plz, String email,
			String telefonnr) throws Exception {

//		List<Ort> ortsliste = new ArrayList<Ort>();

		kontaktupdate.setNachname(name);
		kontaktupdate.setVorname(vorname);
		kontaktupdate.setStrasse(strasse);
		kontaktupdate.setEmail(email);
		kontaktupdate.setTel(telefonnr);

		// zu erst auf liste speichern damit man nachher das zweite der Liste
		// prüfen kann falls nicht übereinstimmt
//		ortsliste = Main.getFeuerungsRapportService().findOrtByPlz(plz);
		List<Ort> ortsliste = Main.getFeuerungsRapportService().findOrtByPlz(plz);

		// durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die
		// gleiche ist.
//		boolean found = false;
//		for (Ort o : ortsliste) {
//			if (ort.equals(o.getOrt())) {
//				kontaktupdate.setOrt(o);
//				found = true;
//				break;
//			}
//		}
		// wenn nicht gefunden wird neuöer ort hinzugefügt
		// orte können nicht upgedated werden etweder gefunden oder neu
//		if (!found) {
//			Ort ortDb = Main.getFeuerungsRapportService().add(new Ort(plz, ort));
//			kontaktupdate.setOrt(ortDb);
//		}

		return null;
	}

}
