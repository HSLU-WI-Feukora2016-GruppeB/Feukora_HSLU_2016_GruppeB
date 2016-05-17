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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.MitarbeiterRO;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterÜbersicht. Sie zeigt alle
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

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse, tblPlz, tblOrt, tblEMail, tblTelefon, tblPosition, tblLohn;

	MitarbeiterRO mitarbeiterRO;
	Mitarbeiter mitarbeiter;
	//List<Mitarbeiter> list = mitarbeiterRO.findAllMitarbeiter();

	private void initialize() {

		// ObservableList<Mitarbeiter> list2 =
		// FXCollections.observableList(list);
		/*tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("strasse"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("plz"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("ort"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("rolleIntern"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("lohn"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("email"));
		tblName.setCellValueFactory(new PropertyValueFactory<>("tel"));

		tabelle.setItems(list2);
        tabelle.getColumns().addAll(tblName, tblVorname, tblStrasse, tblPlz, tblOrt, tblEMail, tblTelefon, tblPosition, tblLohn);*/
		// https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/table-view.htm
	}

	public void MitarbeiterSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			// List<Mitarbeiter> list =
			// mitarbeiterRO.findByNameVorname(name,vorname);
			// ObservableList<Mitarbeiter> list2 =
			// FXCollections.observableList(list);
			// tabelle.setItems(list2);

		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung neuer Mitarbeiter.
	 */
	public void neuerMitarbeiter() {
		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterErfassen.fxml"))));

			MitarbeiterStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Mitarbeiter.
	 */
	public void bearbeitenMitarbeiter() {

		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterErfassen.fxml"))));

			MitarbeiterStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode führt den User zum Dashboard zurück
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
