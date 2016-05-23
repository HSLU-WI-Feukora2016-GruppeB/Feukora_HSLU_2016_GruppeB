package application.view.mitarbeiter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import entitys.Auftrag;
import entitys.Benutzer;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Messung;
import entitys.Mitarbeiter;
import entitys.Ort;
import entitys.Waermeerzeuger;

import rmi.interfaces.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;


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
	private TextField txtName, txtVorname;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse, tblEMail, tblTelefon, tblPosition, tblOrt;


	MitarbeiterRO mitarbeiterRO;
	OrtRO ortRO;



	public static Mitarbeiter mastatic;

	public void initialize() throws Exception {


		/*---------------RMI Verbindung---------------*/

		String OrtRO = "Ort";
		String MitarbeiterROName = "Mitarbeiter";

		try {

			// Properties Objekt erstellen
			Properties  rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = MitarbeiterUebersicht.class.getClassLoader();

			// Properties laden

				rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));


			// Port RMI auslesen
			String stringPort =rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/" + OrtRO;
			String urlMitarbeiterRO = "rmi://" + hostIp + ":" + rmiPort + "/" + MitarbeiterROName;

			/* Lookup */

			ortRO = (OrtRO) Naming.lookup(urlOrtRO);
			mitarbeiterRO = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);


		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
		System.out.println("Verbunden mit RMI");



		try {
			 List<Mitarbeiter> listmitarbeiter = mitarbeiterRO.findAllMitarbeiter();
			ObservableList<Mitarbeiter> listmitarbeiter2 = FXCollections.observableList(listmitarbeiter);
			tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
			tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
			tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
			tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
			tblEMail.setCellValueFactory(new PropertyValueFactory<>("email"));
			tblPosition.setCellValueFactory(new PropertyValueFactory<>("rolleIntern"));
			tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));

			tabelle.setItems(listmitarbeiter2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void MitarbeiterSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			try {
				List<Mitarbeiter> list = mitarbeiterRO.findByNameVorname(name, vorname);
				ObservableList<Mitarbeiter> list2 = FXCollections.observableList(list);
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
	public void neuerMitarbeiter() {

		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterErfassen.fxml"))));

			MitarbeiterStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Mitarbeiter.
	 */
	public void bearbeitenMitarbeiter() {
		try {
			Mitarbeiter indSelected = (Mitarbeiter) tabelle.getSelectionModel().getSelectedItem();
			MitarbeiterBearbeiten.bekommeMitarbeiter(indSelected);

			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterBearbeiten.fxml"))));

			MitarbeiterStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			lblRueckmeldung.setText("Bitte Mitarbeiter auswählen");
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
