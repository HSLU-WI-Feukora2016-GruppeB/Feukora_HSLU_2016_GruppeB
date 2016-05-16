package application.view.liegenschaft;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Dies ist die Dokumentation der Klasse LiegenschaftErfassen. Sie dient zur
 * Erfassung neuer Liegenschaften.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class LiegenschaftErfassen {

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private ChoiceBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	/**
	 * Die Mehode speichert eine Liegenschaft
	 */
	public void liegenschaftSpeichern() {

	}

	/**
	 * Die Methode sucht das Kontaktobjekt in der DB mithilfe der Eingaben
	 */
	public void suchen() {

		String vorname = txtVorname.getText();
		String nachname = txtNachname.getText();

		// pr�fe ob Eingaben gemacht wurden
		if (vorname.isEmpty() || nachname.isEmpty()) {

			lblRueckmeldung.setText("Bitte beide Felder ausf�llen");
		} else {
			try {
				// Kontakt kontakt = FindKontaktByNameVorname();
			} catch (Exception e) {
				lblRueckmeldung.setText("Kontakt wurde nicht gefunden. Rechtschreibung �berpr�fen!");
			}

			// txtStrasse.setText(kontakt.getStrasse());
			// txtOrt.setText(adresse.getOrt);
			// txtPlz.setText(adresse.GetPlz());
		}
	}

	/**
	 * Diese Methode f�hrt den User zum Dashboard zur�ck
	 */
	public void abbrechen() {

	}

}
