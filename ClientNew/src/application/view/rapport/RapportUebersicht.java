package application.view.rapport;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import application.RmiUtil;
import application.view.liegenschaft.LiegenschaftBearbeiten;
import application.view.mitarbeiter.MitarbeiterBearbeiten;
import application.view.termin.TerminBearbeiten;
import entitys.Auftrag;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import rmi.interfaces.MessungRO;
import rmi.interfaces.MitarbeiterRO;

public class RapportUebersicht {

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
			String fk = ddFK.getSelectionModel().toString();
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
				int tag2 = vonDatum.plusDays(1).getDayOfMonth();
				int tag3 = vonDatum.plusDays(2).getDayOfMonth();
				int tag4 = vonDatum.plusDays(3).getDayOfMonth();
				int tag5 = vonDatum.plusDays(4).getDayOfMonth();
				int monat = vonDatum.getMonthValue();
				int jahr = vonDatum.getYear();
				GregorianCalendar gcal1 = new GregorianCalendar(jahr, monat, tag);
				GregorianCalendar gcal2 = new GregorianCalendar(jahr, monat, tag2);
				GregorianCalendar gcal3 = new GregorianCalendar(jahr, monat, tag3);
				GregorianCalendar gcal4 = new GregorianCalendar(jahr, monat, tag4);
				GregorianCalendar gcal5 = new GregorianCalendar(jahr, monat, tag5);

				try {
					List<Auftrag> auftragsliste = auftragRO.findByDateAndMitarbeiter(gcal1, gcal5, kontrolleur);
					ObservableList<Auftrag> listauftrag2 = FXCollections.observableList(auftragsliste);
					tblKunde.setCellValueFactory(new PropertyValueFactory<>("kontakt"));
					tblLiegenschaft.setCellValueFactory(new PropertyValueFactory<>("liegenschaft"));
					tblDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
					tblZeitSlot.setCellValueFactory(new PropertyValueFactory<>("zeitSlot"));

					tabelle.setItems(listauftrag2);
				} catch (Exception e) {
					lblRueckmeldung.setText("Auftragsliste nicht gefunden");
				}

			}
		}
	}

	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung eines neuen Auftrages.
	 */
	public void neuerAuftrag() {

		try {
			Stage AuftragStage = new Stage();

			AuftragStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/application/view/termin/TerminErfassen.fxml"))));

			AuftragStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Liegenschaften.
	 */
	public void bearbeitenAuftrag() {
		try {
			Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
			TerminBearbeiten.bekommeTermin(indSelected);

			Stage TerminStage = new Stage();

			TerminStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("termin/TerminBearbeiten.fxml"))));

			TerminStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void loeschenAuftrag() throws Exception {
		Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
		auftragRO.delete(indSelected);
	}

	public void neuRapport (){
		try {
			Stage RapportStage = new Stage();

			RapportStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RapportErfassen.fxml"))));

			RapportStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void anzeigenRapport(){
		try {
			Auftrag indSelected = (Auftrag) tabelle.getSelectionModel().getSelectedItem();
			RapportBearbeiten.bekommeAuftrag(indSelected);

			Stage RapportStage = new Stage();

			RapportStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RapportBearbeiten.fxml"))));

			RapportStage.show();

			((Stage) leaf.getScene().getWindow()).close();
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
