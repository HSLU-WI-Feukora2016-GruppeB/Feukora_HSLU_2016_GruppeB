package application.view.termin;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Liegenschaft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import rmi.AuftragRO;

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
	private TableColumn tblName, tblVorname, tblStrasse, tblEMail, tblTelefon, tblPosition, tblOrt;


	AuftragRO auftragRO;

	public void initialize(){


		//Listenattribute anpassen
		try{
			List<Auftrag> list = auftragRO.findAll();
			ObservableList<Auftrag> list2 = FXCollections.observableList(list);
			tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
			tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
			tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
			tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
			tblEMail.setCellValueFactory(new PropertyValueFactory<>("email"));
			tblPosition.setCellValueFactory(new PropertyValueFactory<>("rolleIntern"));
			tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));

			tabelle.setItems(list2);
			}catch(Exception e){
				e.printStackTrace();
			}
	}


	/**
	 * Diese Methode zeigte alle Termine der ausgewählten Woche an.
	 */
	public void wocheAnzeigen() {

		if (startDatum.getValue() == null || ddFK.getValue() == null) {
			lblRueckmeldung.setText("Bitte Datumsfelder und \n" + "Kontrolleur ausfüllen");

		} else {

			LocalDate vonDatum = startDatum.getValue();
			LocalDate bisDatum = vonDatum.plusDays(4);
			endDatum.setValue(bisDatum);
			//String fk = ddFK.getSelectionModel();
			//List<Mitarbeiter> mitlist = mitarbeiterRo.findByName(fk);
			//Mitarbeiter kontrolleur = mitlist.get(0);

			if (vonDatum.getDayOfWeek().name() != "MONDAY") {
				lblRueckmeldung.setText("Bitte einen Montag anwählen!");

			} else {
				lblRueckmeldung.setText(" ");

				txtMontag.setText(vonDatum.toString());
				txtDienstag.setText(vonDatum.plusDays(1).toString());
				txtMittwoch.setText(vonDatum.plusDays(2).toString());
				txtDonnerstag.setText(vonDatum.plusDays(3).toString());
				txtFreitag.setText(vonDatum.plusDays(4).toString());

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
			}
			}
		}


}
