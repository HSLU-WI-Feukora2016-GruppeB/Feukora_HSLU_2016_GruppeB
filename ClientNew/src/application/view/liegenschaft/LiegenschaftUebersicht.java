package application.view.liegenschaft;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.view.mitarbeiter.MitarbeiterBearbeiten;
import entitys.Liegenschaft;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;

public class LiegenschaftUebersicht {

	@FXML
	private TextField txtStrasse;
	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnSuchen;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblInfovorort, tblStrasse, tblOrt;

	LiegenschaftRO liegenschaftRO;

	public void initialize() throws Exception{

		/*---------------RMI Verbindung---------------*/

		String LiegenschaftRO = "Liegenschaft";

		try {

			// Properties Objekt erstellen
			Properties rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = LiegenschaftUebersicht.class.getClassLoader();

			// Properties laden
			try {
				rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Port RMI auslesen
			String stringPort = rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren

			String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/" + LiegenschaftRO;

			/* Lookup */
			liegenschaftRO = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);


		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}

/*----------------------------------------------*/


			List<Liegenschaft> list = liegenschaftRO.findAll();
			ObservableList<Liegenschaft> list2 = FXCollections.observableList(list);
			tblInfovorort.setCellValueFactory(new PropertyValueFactory<>("infoVorOrt"));
			tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
			tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));


			tabelle.setItems(list2);

	}

	public void LiegenschaftSuchen() {

		String strasse = txtStrasse.getText();

		if (strasse.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			try {
				List<Liegenschaft> list = liegenschaftRO.findByStrasse(strasse);
				ObservableList<Liegenschaft> list2 = FXCollections.observableList(list);
				tabelle.setItems(list2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung neuer Liegenschaften.
	 */
	public void neueLiegenschaft() {

		try {
			Stage LiegenschaftStage = new Stage();

			LiegenschaftStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("LiegenschaftErfassen.fxml"))));

			LiegenschaftStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Liegenschaften.
	 */
	public void bearbeitenLiegenschaft() {
		try {
			Liegenschaft indSelected = (Liegenschaft) tabelle.getSelectionModel().getSelectedItem();
			LiegenschaftBearbeiten.bekommeLiegenschaft(indSelected);

			Stage LiegenschaftStage = new Stage();

			LiegenschaftStage
					.setScene(new Scene(FXMLLoader.load(getClass().getResource("LiegenschaftBearbeiten.fxml"))));

			LiegenschaftStage.show();

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
