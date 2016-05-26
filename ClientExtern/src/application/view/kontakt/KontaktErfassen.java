package application.view.kontakt;


import java.util.ArrayList;
import java.util.List;
import application.WsUtil;
import entitys.Kontakt;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.OrtRO;

/**
 * Dies ist die Dokumentation der Klasse KontaktErfassen. Hier werden neue
 * Kontaktobjekte erstellt und in der Datenbank gespeichert.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 1.0
 * @since 1.0
 */

public class KontaktErfassen {

	KontaktRO kontaktRO;
	OrtRO ortRO;

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz, txtTelnr, txtEmail;

	@FXML
	private Button btnSpeichern, btnAbbrechen;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	public void initialize() throws Exception {
		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		kontaktRO = WsUtil.getKontaktRO();

		/*----------------------------------------------*/
	}

	/**
	 * Diese Methode speichert einen neuen Kontakt in der Datenbank.
	 * @throws Exception
	 */
	public void kontaktSpeichern() throws Exception {

		String name = txtNachname.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPlz.getText();
		String email = txtEmail.getText();
		String telnr = txtTelnr.getText();

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || plz.isEmpty()
				|| email.isEmpty() || telnr.isEmpty()) {
			lblRueckmeldung.setText(" Bitte alle Felder ausfüllen!");

		} else {

			// Parsen erst nach der Überprüfung da sonst die isEmpty() Methode
			// nicht vorhanden ist
			// muss ahncheinend auf keine neue Variable gespeichert werden
			int plzint = 0;
			try {

				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}

			Kontakt newkontakt = creatKontakt(name, vorname, strasse, ort, plzint, email, telnr);

			try {
				kontaktRO.add(newkontakt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	 * @throws Exception
	 */

	private Kontakt creatKontakt(String name, String vorname, String strasse, String ort, int plz, String email,
			String telnr) throws Exception {

		Kontakt kontakt = new Kontakt();
		Ort ortschaft = new Ort();
		List<Ort> ortsliste = new ArrayList<Ort>();

		kontakt.setNachname(name);
		kontakt.setVorname(vorname);

		kontakt.setStrasse(strasse);
		kontakt.setEmail(email);
		kontakt.setTel(telnr);


			ortsliste = ortRO.findByOrtPlz(plz);


		// durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die
		// gleiche ist.

			boolean found = false;
			for (Ort o : ortsliste) {
				if (ort.equals(o.getOrt())) {
					kontakt.setOrt(o);
					found = true;
					break;
				}
			}
			// wenn nicht gefunden wird neuöer ort hinzugefügt
			// orte können nicht upgedated werden etweder gefunden oder neu
			if (!found) {
				Ort ortDb = ortRO.add(new Ort(plz, ort));
				kontakt.setOrt(ortDb);
			}


		return kontakt;
	}

}
