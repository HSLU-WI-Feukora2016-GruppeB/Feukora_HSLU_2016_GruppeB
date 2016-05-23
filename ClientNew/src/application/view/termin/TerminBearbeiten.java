package application.view.termin;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.MitarbeiterRO;

public class TerminBearbeiten {

	@FXML
	private TextField txtStrasseL, txtOrtL, txtVorname, txtStrasseK, txtPlzK, txtOrtK, txtNachnameK,
			txtVornameK;

	@FXML
	private ComboBox<String> cZeitslot, cFK;

	@FXML
	private DatePicker dateoftermin;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	@FXML
	private Button btnSpeicher, btnAbbrechen;



	static String strasseL, ortL, nachname, vorname , strasseK, plzK, ortK, nachnameK, zeitslot, kontrolleur;
	static GregorianCalendar date;

	private Stage ErfaStage = new Stage();

	 LiegenschaftRO liegenschaftRo;
	 Liegenschaft liegenschaft;
	 KontaktRO kundeRO;
	 Kontakt kunde;
	 MitarbeiterRO mitarbeiterRo;
	 Mitarbeiter mitarbeiter;

	@FXML
	private void initialize() throws Exception {

		List<Mitarbeiter> list = mitarbeiterRo.findAllMitarbeiter();
		List<String> list3 = new ArrayList<String>();
		for (Mitarbeiter i : list) {
			String rolle = i.getRolleIntern();
			if (rolle.equalsIgnoreCase("Kontrolleur")) {
				list3.add(i.getName());
			}
		}
		ObservableList<String> list2 = FXCollections.observableList(list3);
		cFK.setItems(list2);
		cFK.getSelectionModel().select(kontrolleur);


		//Dropdown zeitslots
		List<String> listzeitslot = new ArrayList<String>();
		listzeitslot.add("08:00 bis 10.00 Uhr");
		listzeitslot.add("10:00 bis 12:00 Uhr");
		listzeitslot.add("13:00 bis 15:00 Uhr");
		listzeitslot.add("15:00 bis 17:00 Uhr");
		ObservableList<String> listzeitslot2 = FXCollections.observableList(listzeitslot);
		cZeitslot.setItems(listzeitslot2);
		cZeitslot.getSelectionModel().select(zeitslot);

		//Datum setzen
		dateoftermin.setValue(gregToLocal(date));




	}

public static void bekommeTermin(Auftrag termin) {


	//liegnschaftsobjekt holen
	Liegenschaft liegenschaft = termin.getLiegenschaft();

	strasseL = liegenschaft.getStrasse();
	ortL = liegenschaft.getOrt().getOrt();

	//Kunde holen
	Kontakt kontakt = termin.getKunde();
	nachnameK = kontakt.getNachname();
	vorname = kontakt.getVorname();
	strasseK = kontakt.getStrasse();
	plzK = String.valueOf(kontakt.getOrt().getPlz());
	ortK = kontakt.getOrt().getOrt();

	//getZeitslot
	zeitslot = termin.getZeitSlotString();

	//get datum
	date = termin.getTermin();

	//get Kontrolleur
	kontrolleur = termin.getMitarbeiter().getName();


	}

	/**
	 * Die Methode hollt die hinterlegten Kontaktinformationen zur eingegebener
	 * Liegenschaft
	 */
	public void liegenschaftSuchen() {

		String strasse = txtStrasseL.getText();
		String ort = txtOrtL.getText();

		if (strasse.isEmpty() || ort.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			// liegenschaft =
			// liegenschaftRO.findLiegenschaftByStrasseOrt(strasse,
			// ort);

			// Kontakt kunde = kundeRO.findKundeByLiegenschaft(liegenschaft);

			/*
			 * txtStrasseK.setText(kunde.getStrasseInklNr()); Ort ort =
			 * kunde.getAdresse(); txtOrtK.setText(ort.getOrt);
			 * txtPlz.setText(ort.getPlz);
			 */
		}

	}

	/**
	 * Die Methode speichert einen Termin
	 */
	public void terminSpeichern() {

		if (txtNachnameK.getText() == null || txtVornameK.getText() == null || txtStrasseK.getText() == null
				|| txtPlzK.getText() == null || txtOrtK.getText() == null || cZeitslot.getValue() == null
				|| cFK.getValue() == null || dateoftermin.getValue() == null) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen"); // funktioniert
																	// hier
																	// müsste
																	// aber noch
																	// ein neues
																	// Label
																	// gesetzt
																	// werden

		} else {
			String strasse = txtStrasseK.getText();
			String plz = txtPlzK.getText();
			String ort = txtOrtK.getText();
			String zeitslot = (String) cZeitslot.getValue();
			// SelectionModel<Mitarbeiter> fk = cFK.getSelectionModel();
			// SelectionModel<String> zs = cZeitslot.getSelectionModel().getIndex();
		}
		LocalDate datum = dateoftermin.getValue();
		int tag = datum.getDayOfMonth();
		int monat = datum.getMonthValue();
		int jahr = datum.getYear();
		GregorianCalendar gcal = new GregorianCalendar(jahr, monat, tag);

		// mitarbeiter = mitarbeiterRO.findMitarbeiterByName();

		// Auftrag auftrag = new Auftrag (kunde, liegenschaft, fk, zeitslot,
		// gcal);
		// this.AuftragRO.add(auftrag);

	}

	/**
	 * Diese Methode führt den User zur Übersicht TerminÜbersicht zurück.
	 */
	public void abbrechen() {
		try {

			ErfaStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/termin/TerminUebersicht.fxml"))));
			ErfaStage.setFullScreen(true);
			ErfaStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((Stage) leaf.getScene().getWindow()).close();

	}

	private LocalDate gregToLocal(GregorianCalendar changecal){

		Date zwischendate = changecal.getTime();

		LocalDate ldstartDatum = zwischendate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ldstartDatum;

	}


}
