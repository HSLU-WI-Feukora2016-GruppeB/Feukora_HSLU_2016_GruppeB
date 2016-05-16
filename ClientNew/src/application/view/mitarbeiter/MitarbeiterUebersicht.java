package application.view.mitarbeiter;

import java.util.ArrayList;
import java.util.List;

import entitys.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.MitarbeiterRO;

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
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnSuchen;

	@FXML
	private TextField txtName, txtVorname, txtStrasse, txtOrt;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	MitarbeiterRO mitarbeiterRO;
	Mitarbeiter mitarbeiter;
	// List<Mitarbeiter> list = mitarbeiterRO.findAllMitarbeiter();

	private void initialize() {

		// ObservableList<Mitarbeiter> list2 =
		// FXCollections.observableList(list);
		// tabelle.setItems(list2);
	}

	public void MitarbeiterSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");

		} else {

			// List<Mitarbeiter> list =
			// mitarbeiterRO.findByNameVorname(name,vorname);
			// ObservableList<Mitarbeiter> list2 =
			// FXCollections.observableList(list);
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
