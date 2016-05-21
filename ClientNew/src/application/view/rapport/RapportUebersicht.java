package application.view.rapport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Mitarbeiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import rmi.AuftragRO;
import rmi.MitarbeiterRO;

public class RapportUebersicht {

	AuftragRO auftragro;
	MitarbeiterRO mitarbeiterro;



	@FXML
	private Label lblRueckmeldung;

	@FXML
	private TextField txtName, txtVorname;

	@FXML
	private DatePicker dpDate;

	@FXML
	private ComboBox<Integer> cbZeitslot;

	@FXML
	private ComboBox<String> cbMitarbeiter;

	@FXML
	private TableView tvTabelle;

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse,  tblOrt, tblAuftragart, tblZeitslot, tblKontaktname;


	public void initialize(){
		List<Mitarbeiter> list = null;
		List<Auftrag> auftragslisteheute = null;

		//Mitarbeiter in der Combobox anzeigen lassen

		try {
			list = mitarbeiterro.findAllMitarbeiter();
		} catch (Exception e) {
			lblRueckmeldung.setText("keine Mitarbeiter gefunden");
		}
		List<String> list3 = new ArrayList<String>();
		for (Mitarbeiter i : list) {
			String rolle = i.getRolleIntern();
			if (rolle.equalsIgnoreCase("Kontrolleur")) {
				list3.add(i.getName());
			}
		}
		ObservableList<String> list2 = FXCollections.observableList(list3);
		cbMitarbeiter.setItems(list2);


		//Zeitslotsanzeigenlassen
		List<Integer> zeitslots = new ArrayList<Integer>();
		zeitslots.add(1);
		zeitslots.add(2);
		zeitslots.add(3);
		zeitslots.add(4);
		ObservableList<Integer> listzeitslot = FXCollections.observableList(zeitslots);
		cbZeitslot.setItems(listzeitslot);

		//Auftragsliste des heutigen Tages in die TableView
		GregorianCalendar today =new GregorianCalendar();
			today.getInstance().getTime();

		try {
			auftragslisteheute = auftragro.findByDatum(today);
		} catch (Exception e) {
		lblRueckmeldung.setText("keine aufträge gefunden");
		}


		ObservableList<Auftrag> auftragslisteheute2 = FXCollections.observableList(auftragslisteheute);
		tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
		tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
		tblZeitslot.setCellValueFactory(new PropertyValueFactory<>("zeitSlot"));
		tblKontaktname.setCellValueFactory(new PropertyValueFactory<>("kontakt"));

		tvTabelle.setItems(list2);

	}


	public void rapportSuchen(){

		//Felder auslesen
		String name = txtName.getText();
		String vorname = txtVorname.getText();
		LocalDate dpdate = dpDate.getValue();


		if(name.isEmpty()|| vorname.isEmpty() || dpdate == null || cbZeitslot.getValue() == null){
			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");
		}else{


			int slut = cbZeitslot.getValue();

			Mitarbeiter mitarbeiter = null;

			//Mitarbeiter finden
			List<Mitarbeiter> mitarbeiterliste;
			try {
				mitarbeiterliste = mitarbeiterro.findByNameVorname(name, vorname);
				mitarbeiter = mitarbeiterliste.get(0);
			} catch (Exception e1) {
				lblRueckmeldung.setText("Mitarbeiter nicht gefunden!");
			}


			//GregorianCalendar erstellen
			int tag = dpdate.getDayOfMonth();
			int monat = dpdate.getMonthValue();
			int jahr = dpdate.getYear();
			GregorianCalendar gcal = new GregorianCalendar(jahr,monat,tag);

			try {
				Auftrag auftrag = auftragro.findByDateAndMitarbeiterAndZeitslot(gcal, mitarbeiter, slut);
				RapportErfassen.bekommeAuftrag(auftrag);
			} catch (Exception e) {
				lblRueckmeldung.setText("Auftrag nicht gefunden!");
			}
		}

	}








}
