package application.view.liegenschaft;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rmi.BrennerRO;
import rmi.LiegenschaftRO;
import rmi.OrtRO;
import rmi.WaermeerzeugerRO;

/**
 * Dies ist die Dokumentation der Klasse LiegenschaftErfassen. Sie dient zur
 * Erfassung neuer Liegenschaften.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class LiegenschaftErfassen {

	LiegenschaftRO liegenschaftRO;
	WaermeerzeugerRO waermeerzeugerRO;
	BrennerRO brennerRO;
	OrtRO ortRO;

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz, txtBrennertyp, txtBrennerjahr, txtWaermetyp, txtWaermejahr;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private ComboBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	/**
	 * Die Mehode speichert eine Liegenschaft
	 */
	public void liegenschaftSpeichern() {

		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPlz.getText();
		String brennertyp = txtBrennertyp.getText();
		String brennerart = txtWaermejahr.getValue().toString();
		String baujahr = txtBrennerjahr.getText();

		// �berpr�fung ob die Felder auch mit einem Wert belegt wurden
		if (strasse.isEmpty() || ort.isEmpty() || plz.isEmpty() || ) {
			lblRueckmeldung.setText(" Bitte alle Felder ausf�llen!");
		}

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
