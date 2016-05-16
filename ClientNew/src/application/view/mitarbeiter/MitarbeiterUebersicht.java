package application.view.mitarbeiter;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse Mitarbeiter�bersicht. Sie zeigt alle
 * Mitarbeiter an.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterUebersicht {

	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen;

	@FXML
	private TextField txtName, txtVorname, txtStrasse, txtOrt, lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	// MitarbeiterRO mitarbeiterRO;
	// List<Mitarbeiter> list = mitarbeiterRO.findAllMitarbeit();

	private void initialize() {

		// ObservableList<String> list2 = FXCollections.observableList(list);
		// tabelle.setItems(list2);
	}

	void MitarbeiterSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();

		if (strasse.isEmpty() || ort.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");

		} else {

			// ObservableList<String> list2 = FXCollections.observableList(list);
			// tabelle.setItems(list2);

		}

	}

	/**
	 * Diese Methode �ffnet die �bersicht zur Erfassung neuer Mitarbeiter.
	 */
	public void neuerMitarbeiter() {
		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Mitarbeiter_Erfassen.fxml"))));

			MitarbeiterStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode �ffnet die �bersicht zur Bearbeitung von Mitarbeiter.
	 */
	public void bearbeitenMitarbeiter() {


	}

	/**
	 * Diese Methode f�hrt den User zum Dashboard zur�ck
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
