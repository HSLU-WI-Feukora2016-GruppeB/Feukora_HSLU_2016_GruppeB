package application.view.rapport;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import application.RmiUtil;
import application.view.termin.TerminBearbeiten;
import entitys.Auftrag;
import entitys.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.interfaces.AuftragRO;
import rmi.interfaces.MitarbeiterRO;


/**
 *Diese Klasse zeigt die Uebersicht der Rapporte einer Woche anhand des ausgewählten kontrolleurs
 * und der ausgewählten Woche.
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 *
 */
public class RapportUebersicht {

	// ----------------Stufe 1--------------------
	@FXML
	private TextField txtM1S1Russzahl, txtM1S1CO, txtM1S1Abgastemperatur, txtM1S1Verbrenn, txtM1S1Nox, txtM1S1Waermeerz,
			txtM1S1O2, txtM1S1Abgasverl, txtM1S2Russzahl, txtM1S2CO, txtM1S2Abgastemperatur, txtM1S2Verbrenn,
			txtM1S2Nox, txtM1S2Waermeerz, txtM1S2O2, txtM1S2Abgasverl;

	@FXML
	private CheckBox checkS1M1Oel, checkS1M1Abgas, checkS1M1Russzahl, checkS1M1Co2, checkS1M1No2, checkS1M2Oel,
			checkS1M2Abgas, checkS1M2Russzahl, checkS1M2Co2, checkS1M2No2;

	// ----------------Stufe 2---------------------
	@FXML
	private TextField txtM2S1Russzahl, txtM2S1CO, txtM2S1Abgastemperatur, txtM2S1Verbrenn, txtM2S1Nox, txtM2S1Waermeerz,
			txtM2S1O2, txtM2S1Abgasverl, txtM2S2Russzahl, txtM2S2CO, txtM2S2Abgastemperatur, txtM2S2Verbrenn,
			txtM2S2Nox, txtM2S2Waermeerz, txtM2S2O2, txtM2S2Abgasverl;

	@FXML
	private CheckBox check21M1Oel, checkS2M2Oel, checkS2M1Abgas, checkS2M1Russzahl, checkS2M1Co2, checkS2M1No2,
			checkS2M2Abgas, checkS2M2Russzahl, checkS2M2Co2, checkS2M2No2;

	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnWocheAnzeigen, btnRapportAnzeigen, btnRapportErstellen;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblDatum, tblZeitSlot, tblLiegenschaft, tblKunde;

	@FXML
	private ComboBox ddFK;

	@FXML
	private DatePicker startDatum, endDatum;

	AuftragRO auftragRO;
	MitarbeiterRO mitarbeiterRO;


	/**
	 * Initialisiert das GUI
	 *
	 * @throws Exception
	 */
	public void initialize() throws Exception {

		/* Lookup */
		auftragRO = RmiUtil.getAuftragRO();
		mitarbeiterRO = RmiUtil.getMitarbeiterRO();

		/*----------------------------------------------*/

		// Alle Feuerungskontrolleure in der Combobox anzeigen lassen
		List<Mitarbeiter> list = new ArrayList<Mitarbeiter>();
		try {
			list = mitarbeiterRO.findAllMitarbeiter();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> list3 = new ArrayList<String>();
		for (Mitarbeiter i : list) {
			String rolle = i.getRolleIntern();
			if (rolle.equals("Kontrolleur")) {
				list3.add(i.getName());
			}
		}
		ObservableList<String> list2 = FXCollections.observableList(list3);
		ddFK.setItems(list2);
	}

	/**
	 * Diese Methode zeigte alle Termine der ausgewählten Woche an.
	 */
	public void wocheAnzeigen() {

		Mitarbeiter kontrolleur = null;
		if (startDatum.getValue() == null || ddFK.getValue() == null) {
			lblRueckmeldung.setText("Bitte Datumsfelder und \n" + "Kontrolleur ausfüllen");

		} else {

			LocalDate vonDatum = startDatum.getValue();
			LocalDate bisDatum = vonDatum.plusDays(4);
			endDatum.setValue(bisDatum);
			String fk = String.valueOf(ddFK.getValue());
			List<Mitarbeiter> mitlist;
			try {
				mitlist = mitarbeiterRO.findByName(fk);
				kontrolleur = mitlist.get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (vonDatum.getDayOfWeek().name() != "MONDAY") {
				lblRueckmeldung.setText("Bitte einen Montag anwählen!");

			} else {
				lblRueckmeldung.setText(" ");

				int tag = vonDatum.getDayOfMonth();
				int tag5 = vonDatum.plusDays(4).getDayOfMonth();
				int monat = vonDatum.getMonthValue();
				int jahr = vonDatum.getYear();
				GregorianCalendar gcalstart = new GregorianCalendar(jahr, monat, tag);
				GregorianCalendar gcalend = new GregorianCalendar(jahr, monat, tag5);

				try {
					List<Auftrag> auftragsliste = auftragRO.findByDateAndMitarbeiter(gcalstart, gcalend, kontrolleur);
					ObservableList<Auftrag> listauftrag2 = FXCollections.observableList(auftragsliste);
					tblKunde.setCellValueFactory(new PropertyValueFactory<>("kunde"));
					tblLiegenschaft.setCellValueFactory(new PropertyValueFactory<>("liegenschaft"));
					tblDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));

					tabelle.setItems(listauftrag2);
				} catch (Exception e) {
					lblRueckmeldung.setText("Auftragsliste nicht gefunden");
				}

			}
		}
	}

	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung eines neuen Auftrages(Termines).
	 */
	public void neuerAuftrag() {

		try {
			Stage AuftragStage = new Stage();

			AuftragStage.setScene(
					new Scene(FXMLLoader.load(getClass().getResource("/application/view/termin/TerminErfassen.fxml"))));

			AuftragStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Terminen.
	 */
	public void bearbeitenAuftrag() {
		try {
			Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
			TerminBearbeiten.bekommeTermin(indSelected);

			Stage TerminStage = new Stage();

			TerminStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/termin/TerminBearbeiten.fxml"))));

			TerminStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	/**
	 * Löscht den in der Tableview ausgewählten Auftrag
	 *
	 * @throws Exception
	 */
	public void loeschenAuftrag() throws Exception {
		Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
		auftragRO.delete(indSelected);
	}


	/**
	 * Öffnet den in der Tableview ausgewählten Auftrag, solange er noch keine Messungen enthält
	 */
	public void neuRapport (){

			Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
			if(indSelected.getMessung1stufe1() == null){
				try {
				RapportErfassen.bekommeAuftrag(indSelected);


				Stage RapportStage = new Stage();

				RapportStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RapportErfassen.fxml"))));

				RapportStage.show();
				((Stage) leaf.getScene().getWindow()).close();
			} catch (Exception e) {
				e.printStackTrace();
				lblRueckmeldung.setText("Bitte Rapport auswählen");
			}
			}else{
				lblRueckmeldung.setText("Enthält bereits Messungen");
			}


	}

	/**
	 * Zeigt den ausgewählten Auftrag mit den erfassten Messergebnissen an
	 */
	public void anzeigenRapport() {
		try {
			Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
			RapportBearbeiten.bekommeAuftrag(indSelected);

			Stage RapportStage = new Stage();

			RapportStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RapportBearbeiten.fxml"))));

			RapportStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			lblRueckmeldung.setText("Bitte Rapport auswählen");
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
