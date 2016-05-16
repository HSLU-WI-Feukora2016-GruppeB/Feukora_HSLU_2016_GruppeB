package application.view.termin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse TerminErfassen. Hier können neue
 * Termine erstellt und alte bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class TerminErfassen {

	@FXML
	private TextField txtStrasseL, txtOrtL, txtNachname, txtVorname, txtStrasseK, txtPlzK, txtOrtK, txtNachnameK,
			txtVornameK;

	@FXML
	private ComboBox<String> cZeitslot, cFK;

	@FXML
	private DatePicker dateoftermin;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	@FXML
	private Button btnSpeicher, btnAbbrechen;

	private Stage ErfaStage = new Stage();

	// LiegenschaftRO liegenschaftRo;
	// Liegenschaft liegenschaft;
	// KundeRO kundeRO;
	// Kunde kunde;
	// MitarbeiterRO mitarbeiterRo;
	// Mitarbeier mitarbeiter;

	@FXML
	private void initialize() {

		// List<Mitarbeiter> list = mitarbeiterRO.findAllMitarbeit();
		// ObservableList<String> list2 = FXCollections.observableList(list);
		// cFK.setItems(list2);

		List<String> list = new ArrayList<String>();
		list.add("08:00 bis 10.00 Uhr");
		list.add("10:00 bis 12:00 Uhr");
		list.add("13:00 bis 15:00 Uhr");
		list.add("15:00 bis 17:00 Uhr");
		ObservableList<String> list2 = FXCollections.observableList(list);
		cZeitslot.setItems(list2);

	}

	/**
	 * Die Methode hollt die hinterlegten Kontaktinformationen zur eingegebener
	 * Liegenschaft
	 */
	public void liegenschaftSuchen() {

		String strasse = txtStrasseL.getText();
		String ort = txtOrtL.getText();

		if (strasse.isEmpty() || ort.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			// liegenschaft =
			// liegenschaftRO.findLiegenschaftByStrasseOrt(strasse,
			// ort);

			// Kontakt kunde = kundeRO.findKundeByLiegenschaft(liegenschaft);

			/*
			 * txtStrasseK.setText(kunde.getStrasseInklNr()); Ort ort =
			 * kunde.getAdresse(); txtOrtK.setText(ort.getOrt);
			 * txtPlz.setText(ort.getPlz);
			 */
		}

	}

	/**
	 * Die Methode speichert einen Termin
	 */
	public void terminSpeichern() {

		if (txtNachnameK.getText() == null || txtVornameK.getText() == null || txtStrasseK.getText() == null
				|| txtPlzK.getText() == null || txtOrtK.getText() == null || cZeitslot.getValue() == null
				|| cFK.getValue() == null || dateoftermin.getValue() == null) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen"); // funktioniert
																	// hier
																	// müsste
																	// aber noch
																	// ein neues
																	// Label
																	// gesetzt
																	// werden

		} else {
			String strasse = txtStrasseK.getText();
			String plz = txtPlzK.getText();
			String ort = txtOrtK.getText();
			String zeitslot = (String) cZeitslot.getValue();
			// SelectionModel<Mitarbeiter> fk = cFK.getSelectionModel();
			// SelectionModel<String> zs = cZeitslot.getSelectionModel().getIndex();
		}
		LocalDate datum = dateoftermin.getValue();
		int tag = datum.getDayOfMonth();
		int monat = datum.getMonthValue();
		int jahr = datum.getYear();
		GregorianCalendar gcal = new GregorianCalendar(jahr, monat, tag);

		// mitarbeiter = mitarbeiterRO.findMitarbeiterByName();

		// Auftrag auftrag = new Auftrag (kunde, liegenschaft, fk, zeitslot,
		// gcal);
		// this.AuftragRO.add(auftrag);

	}

	/**
	 * Diese Methode führt den User zur Übersicht TerminÜbersicht zurück.
	 */
	public void abbrechen() {
		try {

			ErfaStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/termin/TerminUebersicht.fxml"))));
			ErfaStage.setFullScreen(true);
			ErfaStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((Stage) leaf.getScene().getWindow()).close();

	}

}
