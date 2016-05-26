package application.view.liegenschaft;


import java.util.List;
import application.WsUtil;
import entitys.Liegenschaft;
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
import rmi.interfaces.LiegenschaftRO;

/**
 * Dies ist die Dokumentation der Klasse Liegenschaften-�bersicht. Sie zeigt
 * alle Liegenschaften an.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 1.0
 * @since 1.0
 */
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

	public void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		liegenschaftRO = WsUtil.getLiegenschaftRO();

		/*----------------------------------------------*/

		List<Liegenschaft> list = liegenschaftRO.findAll();
		ObservableList<Liegenschaft> list2 = FXCollections.observableList(list);
		tblInfovorort.setCellValueFactory(new PropertyValueFactory<>("infoVorOrt"));
		tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
		tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));

		tabelle.setItems(list2);

	}

	/**
	 * Mit dieser Methode wird anhand der Strasse nach einer Liegenschaft gesucht.
	 */
	public void LiegenschaftSuchen() {

		String strasse = txtStrasse.getText();

		if (strasse.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");

		} else {

			try {
				List<Liegenschaft> list = liegenschaftRO.findByStrasse(strasse);
				ObservableList<Liegenschaft> list2 = FXCollections.observableList(list);
				tabelle.setItems(list2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Diese Methode �ffnet die �bersicht zur Erfassung neuer Liegenschaften.
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
	 * Diese Methode l�scht das ausgew�hlte Objekt in der Tableview
	 */
	public void loeschen(){
		Liegenschaft indSelected = (Liegenschaft) tabelle.getSelectionModel().getSelectedItem();
		try {
			liegenschaftRO.delete(indSelected);
		} catch (Exception e) {
			lblRueckmeldung.setText("Liegenschaft wurde nicht gel�scht");
		}
		lblRueckmeldung.setText("Liegenschaft gel�scht");
	}

	/**
	 * Diese Methode �ffnet die �bersicht zur Bearbeitung von Liegenschaften.
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
			lblRueckmeldung.setText("Bitte Liegenschaft ausw�hlen");
			e.printStackTrace();
		}
	}



	/**
	 * Diese Methode f�hrt den User zum Dashboard zur�ck
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
