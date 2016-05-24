package application.view.kontakt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import application.RmiUtil;
import application.view.mitarbeiter.MitarbeiterBearbeiten;
import entitys.Benutzer;
import entitys.Kontakt;
import entitys.Mitarbeiter;
import entitys.Ort;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.OrtRO;

public class KontaktUebersicht {

	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnSuchen;

	@FXML
	private TextField txtName, txtVorname;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse, tblEMail, tblTelefon, tblOrt;

	KontaktRO kontaktRO;
	OrtRO ortRO;

	public static Mitarbeiter mastatic;

	@FXML
	private void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		kontaktRO = RmiUtil.getKontaktRO();

		/*----------------------------------------------*/

		System.out.println("RMI verbunden");

		List<Kontakt> list = kontaktRO.findAll();
		ObservableList<Kontakt> list2 = FXCollections.observableList(list);
		tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
		tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
		tblEMail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));

		tabelle.setItems(list2);

	}

	public void kontaktSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			try {
				List<Kontakt> list = kontaktRO.findByNameVorname(name, vorname);
				ObservableList<Kontakt> list2 = FXCollections.observableList(list);
				tabelle.setItems(list2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung neuer Mitarbeiter.
	 */
	public void neuerKontakt() {

		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("KontaktErfassen.fxml"))));

			MitarbeiterStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Mitarbeiter.
	 */
	public void bearbeitenKontakt() {
		try {
			Kontakt indSelected = (Kontakt) tabelle.getSelectionModel().getSelectedItem();
			KontaktBearbeiten.bekommeKontakt(indSelected);

			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("KontaktBearbeiten.fxml"))));

			MitarbeiterStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			lblRueckmeldung.setText("Bitte Kontakt auswählen");
		}

	}

	/**
	 * Diese Methode führt den User zum Dashboard zurück
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
