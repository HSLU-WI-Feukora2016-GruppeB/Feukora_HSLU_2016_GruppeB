package application.view.termin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
<<<<<<< HEAD
import rmi.interfaces.AuftragRO;
=======
import rmi.AuftragRO;
import rmi.MitarbeiterRO;
>>>>>>> refs/remotes/origin/master

public class TerminUebersichtListe {

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
	private TableColumn tblDatum, tblZeitSlot, tblLiegenschaft, tblKontakt;

	@FXML
	private ComboBox ddFK;

	@FXML
	private DatePicker startDatum, endDatum;

	AuftragRO auftragRO;
	MitarbeiterRO mitarbeiterRO;

	public void initialize() {

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
			if (rolle.equalsIgnoreCase("Kontrolleur")) {
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
					tblKontakt.setCellValueFactory(new PropertyValueFactory<>("kontakt"));
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
}
