package application.view.termin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import application.WsUtil;
import application.view.liegenschaft.LiegenschaftErfassen;
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
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.AuftragRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;

public class TerminBearbeiten {

	@FXML
	private TextField txtStrasseL, txtOrtL, txtVorname, txtStrasseK, txtPlzK, txtOrtK, txtNachnameK, txtVornameK;

	@FXML
	private ComboBox<String> cZeitslot, cFK, cTerminArt;

	@FXML
	private DatePicker dateoftermin;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	@FXML
	private Button btnSpeicher, btnAbbrechen;

	static String strasseL, ortL, strasseK, plzK, ortK, vornameK, nachnameK, zeitslot, kontrolleur, terminart;
	static GregorianCalendar date;

	private Stage ErfaStage = new Stage();

	LiegenschaftRO liegenschaftRO;
	Liegenschaft liegenschaft;
	KontaktRO kontaktRO;
	Kontakt kunde;
	MitarbeiterRO mitarbeiterRO;
	Mitarbeiter mitarbeiter;
	AuftragRO auftragRO;

	int zeitslotint;
	int terminartint;

	@FXML
	private void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		kontaktRO = WsUtil.getKontaktRO();
		liegenschaftRO = WsUtil.getLiegenschaftRO();
		mitarbeiterRO = WsUtil.getMitarbeiterRO();
		auftragRO = WsUtil.getAuftragRO();

		/*----------------------------------------------*/


		txtStrasseL.setText(strasseL);
		txtOrtL.setText(ortL);
		txtStrasseK.setText(strasseK);
		txtPlzK.setText(plzK);
		txtOrtK.setText(ortK);
		txtNachnameK.setText(nachnameK);
		txtVornameK.setText(vornameK);

		// Dropdown Terminarten setzen
		List<String> terminarten = new ArrayList<String>();
		terminarten.add("Routinekontrolle");
		terminarten.add("Abnahmekontrolle");
		ObservableList<String> terminarten2 = FXCollections.observableList(terminarten);
		cTerminArt.setItems(terminarten2);
		cTerminArt.getSelectionModel().select(terminart);

		// Dropdown Mitarbeiter
		List<Mitarbeiter> mitarbeiterlist = mitarbeiterRO.findAllMitarbeiter();
		List<String> list3 = new ArrayList<String>();
		for (Mitarbeiter i : mitarbeiterlist) {
			String rolle = i.getRolleIntern();
			if (rolle.equalsIgnoreCase("Kontrolleur")) {
				list3.add(i.getName());
			}
		}
		ObservableList<String> list2 = FXCollections.observableList(list3);
		cFK.setItems(list2);
		cFK.getSelectionModel().select(kontrolleur);

		// Dropdown zeitslots
		List<String> listzeitslot = new ArrayList<String>();
		listzeitslot.add("08:00 bis 10.00 Uhr");
		listzeitslot.add("10:00 bis 12:00 Uhr");
		listzeitslot.add("13:00 bis 15:00 Uhr");
		listzeitslot.add("15:00 bis 17:00 Uhr");
		ObservableList<String> listzeitslot2 = FXCollections.observableList(listzeitslot);
		cZeitslot.setItems(listzeitslot2);
		cZeitslot.getSelectionModel().select(zeitslot);

		// Datum setzen
		dateoftermin.setValue(gregToLocal(date));

	}

	public static void bekommeTermin(Auftrag termin) {

		// liegnschaftsobjekt holen
		Liegenschaft liegenschaft = termin.getLiegenschaft();

		strasseL = liegenschaft.getStrasse();
		ortL = liegenschaft.getOrt().getOrt();

		// Kunde holen
		Kontakt kontakt = termin.getKunde();
		nachnameK = kontakt.getNachname();
		vornameK = kontakt.getVorname();
		strasseK = kontakt.getStrasse();
		plzK = String.valueOf(kontakt.getOrt().getPlz());
		ortK = kontakt.getOrt().getOrt();

		// getZeitslot
		zeitslot = termin.getZeitSlotString();

		// get datum
		date = termin.getTermin();

		// get Kontrolleur
		kontrolleur = termin.getMitarbeiter().getName();

		// Terminart holen
		terminart = termin.getTerminArt();

	}

	/**
	 * Die Methode hollt die hinterlegten Kontaktinformationen zur eingegebener
	 * Liegenschaft
	 *
	 * @throws Exception
	 */
	public void liegenschaftSuchen() throws Exception {

		String strasse = txtStrasseL.getText();
		String ort = txtOrtL.getText();

		if (strasse.isEmpty() || ort.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			List<Liegenschaft> liegenschaftliste = liegenschaftRO.findByStrasse(strasse);

			for (Liegenschaft l : liegenschaftliste) {
				if (ort.equals(l.getOrt().getOrt())) {
					liegenschaft = l;
				}
			}

			List<Kontakt> kundenListe = kontaktRO.findByStrasse(strasse);
			for (Kontakt k : kundenListe) {
				if (ort.equals(k.getOrt().getOrt())) {
					kunde = k;
				}
			}

			txtStrasseK.setText(kunde.getStrasse());
			txtOrtK.setText(kunde.getOrt().getOrt());
			txtPlzK.setText(String.valueOf(kunde.getOrt().getPlz()));

		}

		List<Kontakt> kundenListe = kontaktRO.findByStrasse(strasse);
		for (Kontakt k : kundenListe) {
			if (ort.equals(k.getOrt().getOrt())) {
				kunde = k;
			}
		}

		txtStrasseK.setText(kunde.getStrasse());
		txtOrtK.setText(kunde.getOrt().getOrt());
		txtPlzK.setText(String.valueOf(kunde.getOrt().getPlz()));

	}

	/**
	 * Die Methode speichert einen Termin
	 *
	 * @throws Exception
	 */
	public void terminSpeichern() throws Exception {

		if (txtNachnameK.getText() == null || txtVornameK.getText() == null || txtStrasseK.getText() == null
				|| txtPlzK.getText() == null || txtOrtK.getText() == null || cZeitslot.getValue() == null
				|| cFK.getValue() == null || dateoftermin.getValue() == null) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {
			String kontakt = txtNachnameK.getText();
			List<Kontakt> kontaktliste = new ArrayList<Kontakt>();
			kontaktliste = kontaktRO.findByName(kontakt);
			kunde = kontaktliste.get(0);

			String zeitslot = (String) cZeitslot.getValue();

			switch (zeitslot) {

			case "08:00 bis 10.00 Uhr":
				zeitslotint = 1;
				break;
			case "10:00 bis 12.00 Uhr":
				zeitslotint = 2;
				break;
			case "13:00 bis 15.00 Uhr":
				zeitslotint = 3;
				break;
			case "15:00 bis 17.00 Uhr":
				zeitslotint = 4;
				break;
			}

			String terminart = (String) cTerminArt.getValue();

			switch (terminart) {

			case "Routinekontrolle":
				terminartint = 1;
				break;
			case "Abnhamekontrolle":
				terminartint = 2;
				break;
			}

			String fk = cFK.getValue();
			List<Mitarbeiter> kontrolleurliste = new ArrayList<Mitarbeiter>();
			kontrolleurliste = mitarbeiterRO.findByName(fk);
			mitarbeiter = kontrolleurliste.get(0);

			LocalDate datum = dateoftermin.getValue();
			int tag = datum.getDayOfMonth();
			int monat = datum.getMonthValue();
			int jahr = datum.getYear();
			GregorianCalendar gcal = new GregorianCalendar(jahr, monat, tag);

			Auftrag auftrag = new Auftrag(kunde, liegenschaft, mitarbeiter, gcal, zeitslotint, terminartint);
			auftragRO.update(auftrag);
		}
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

	private LocalDate gregToLocal(GregorianCalendar changecal) {

		Date zwischendate = changecal.getTime();

		LocalDate ldstartDatum = zwischendate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ldstartDatum;

	}

}
