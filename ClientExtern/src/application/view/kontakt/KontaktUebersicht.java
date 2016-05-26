package application.view.kontakt;

import java.util.List;
import application.WsUtil;
import entitys.Kontakt;
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
import rmi.interfaces.KontaktRO;
import rmi.interfaces.OrtRO;

/**
 *  Managed die Optionen für die Kontakte
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 */
public class KontaktUebersicht {

	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnSuchen;

	@FXML
	private TextField txtName, txtVorname;

	@FXML
	private Label lblRueckmeldung1, lblRueckmeldung2;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse, tblEMail, tblTelefon, tblOrt;

	KontaktRO kontaktRO;
	OrtRO ortRO;

	public static Mitarbeiter mastatic;

	public void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		kontaktRO = WsUtil.getKontaktRO();

		/*----------------------------------------------*/

		List<Kontakt> list = kontaktRO.findAll();
		ObservableList<Kontakt> list2 = FXCollections.observableList(list);
		tblName.setCellValueFactory(new PropertyValueFactory<>("nachname"));
		tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
		tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
		tblEMail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));

		tabelle.setItems(list2);

	}

	/**
	 * Manuelles suchen um den Kontakt in der Tableview anzuzeigen
	 */
	public void kontaktSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung1.setText("Beide Felder müssen ausgefüllt werden!");

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
			lblRueckmeldung1.setText("Bitte Kontakt auswählen");
		}
	}



	/**
	 * Diese Methode löscht das ausgewählte Objekt in der Tableview
	 */
	public void loeschen(){
		Kontakt indSelected = (Kontakt) tabelle.getSelectionModel().getSelectedItem();
		try {
			kontaktRO.delete(indSelected);
		} catch (Exception e) {
			lblRueckmeldung2.setText("Mitarbeiter wurde nicht gelöscht");
		}
		lblRueckmeldung2.setText("Mitarbeiter gelöscht");
	}


	/**
	 * Diese Methode führt den User zum Dashboard zurück
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
