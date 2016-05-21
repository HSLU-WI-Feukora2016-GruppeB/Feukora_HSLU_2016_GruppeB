package application.view.liegenschaft;

import java.util.List;

import entitys.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import rmi.BrennerRO;
import rmi.KontaktRO;
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

	static KontaktRO kontaktRO;
	LiegenschaftRO liegenschaftRO;
	WaermeerzeugerRO waermeerzeugerRO;
	BrennerRO brennerRO;
	OrtRO ortRO;

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz,
		txtStrasseL, txtOrtL, txtPlzL,
		txtBrennertyp, txtBrennerjahr,
		txtWaermetyp, txtWaermejahr;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private TableView tvKundentbl;

	@FXML
	private ComboBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	/**
	 * Methode speichert eine Liegenschaft neu.
	 */
	public void liegenschaftSpeichern() {

		String vornameK = txtVorname.getText();
		String nameK = txtNachname.getText();

		try {
			Kontakt foundKontakt = kontaktSuchen(vornameK, nameK);
		} catch (Exception e) {
			lblRueckmeldung.setText("Kontakt konnte nicht gefunden werden, bitte neuen Kontakt hinzuf�gen.");
		}

		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPlz.getText();
		String brennertyp = txtBrennertyp.getText();
		String brennerart = cbBrennart.getValue().toString();
		String brennerjahr = txtBrennerjahr.getText();
		String waermetyp = txtWaermetyp.getText();
		String waermeart = cbBrennstoff.getValue().toString();
		String waermejahr = txtWaermejahr.getText();

		// �berpr�fung ob die Felder auch mit einem Wert belegt wurden
		if (strasse.isEmpty() || ort.isEmpty() || plz.isEmpty() || brennertyp.isEmpty() || brennerart.isEmpty()
				|| brennerjahr.isEmpty() || waermetyp.isEmpty() || waermeart.isEmpty() || waermejahr.isEmpty()) {
			lblRueckmeldung.setText(" Bitte alle Felder ausf�llen!");
		} else {
			// Combobox je nach Text int vergeben
			int brennerA = 0;
			switch (brennerart) {
			case "Gebl�sebrenner 1-stufig mit Heiz�l":
				brennerA = 1;
				break;
			case "Gebl�sebrenner 2-stufig mit Heiz�l":
				brennerA = 2;
				break;
			case "Verdampfungsbrenner":
				brennerA = 3;
				break;
			case "Gebl�sebrenner 1-stufig mit Gas":
				brennerA = 4;
				break;
			case "Gebl�sebrenner 2-stufig mit Gas":
				brennerA = 5;
				break;
			case "Athmosph�rischer Brenner":
				brennerA = 6;
				break;
			}
			// brennerjahr in int parsen
			int brennerJ = Integer.parseInt(brennerjahr);

			// neues Brenenrobjekt erstellen
			Brenner newBrenner = new Brenner(brennerA, brennertyp, brennerJ);

			// Combobox je nach Text int vergeben
			int waermeA = 0;
			switch (waermeart) {
			case "�l":
				waermeA = 1;
				break;
			case "Erdgas":
				waermeA = 2;
				break;
			case "Fl�ssiggas":
				waermeA = 3;
				break;
			}

			// W�rmeerzeugerjahr in int parsen
			int waermeJ = Integer.parseInt(waermejahr);

			// neues Waermeerzeugerobjekt erstellen
			Waermeerzeuger newWaermeerzeuger = new Waermeerzeuger(waermeA, waermetyp, waermeJ);

		}

	}

	private Kontakt kontaktSuchen(String vornameK, String nameK) {

//		if (name.isEmpty() || vorname.isEmpty()) {
//
//			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");
//
//		} else {
//
//			try {
//				List<Mitarbeiter> list = MitarbeiterRO.findByNameVorname(name, vorname);
//				ObservableList<Mitarbeiter> list2 = FXCollections.observableList(list);
//				tabelle.setItems(list2);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
	}

	public Liegenschaft createLiegenschaft(String kvorname, String kname, String kstrasse, int kplz, String kort,
			String lstrasse, int lplz, String lort, String btyp, int bart, int bjahr, String wtyp, int wart, int wjahr){

		Liegenschaft = new Liegenschaft();


		return newliegenschaft;


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
