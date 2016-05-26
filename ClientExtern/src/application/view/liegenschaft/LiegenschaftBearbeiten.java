package application.view.liegenschaft;

import java.util.ArrayList;
import java.util.List;

import application.Main;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import entitys.Waermeerzeuger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse LiegenschaftBearbeiten. Mit ihr k�nnen
 * bestehende Liegenschaften ver�ndert und in der Datenbank bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 1.0
 * @since 1.0
 */
public class LiegenschaftBearbeiten {

	@FXML
	private TextField txtVorname, txtNachname, txtStrasseL, txtOrtL, txtPlzL, txtBrennertyp, txtBrennerjahr,
			txtWaermetyp, txtWaermejahr, txtInfo, txtFeuerungswaermekW;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private TableView tvKundentbl;

	@FXML
	private ComboBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableColumn tblNachname, tblVorname, tblStrasse, tblEmail, tblTelefon, tblOrt;

	static Liegenschaft liegupdate;
	static Kontakt kontaktvonlieg;

	// Variabelndeklaration f�r static bekommeLiegenschaft() methode
	static String strassel, ortl, plzl, infovorort, feuerungsleistung, vorname, nachname, brennertyp, brennerart,
			brennerjahr, waermetyp, waermeart, waermejahr;


	public void initialize() throws Exception {

		// Kontaktanzeigen
		ArrayList<Kontakt> setkontakt = new ArrayList<Kontakt>();
		setkontakt.add(kontaktvonlieg);
		ObservableList<Kontakt> setkontakt2 = FXCollections.observableList(setkontakt);
		tvKundentbl.setItems(setkontakt2);

		txtVorname.setText(vorname);
		txtNachname.setText(nachname);

		// Liegenschaft anzeigen
		txtStrasseL.setText(strassel);
		txtOrtL.setText(ortl);
		txtPlzL.setText(plzl);
		txtInfo.setText(infovorort);

		// Brenner anzeigen
		txtBrennertyp.setText(brennertyp);
		txtBrennerjahr.setText(brennerjahr);
		// Brennerart in die Combobox einf�gen
		List<String> listbrennstoff = new ArrayList<String>();
		listbrennstoff.add("�l");
		listbrennstoff.add("Erdgas");
		listbrennstoff.add("Fl�ssiggas");

		ObservableList<String> listbrennstoff2 = FXCollections.observableList(listbrennstoff);
		cbBrennstoff.setItems(listbrennstoff2);
		cbBrennstoff.getSelectionModel().select(waermeart);

		// Waermeerzeuger anzeigen
		txtWaermetyp.setText(waermetyp);
		txtWaermejahr.setText(waermejahr);
		// Waermeerzeugerart in die Combobox einf�gen
		List<String> listbrennart = new ArrayList<String>();
		listbrennart.add("Gebl�sebrenner 1-stufig mit Heiz�l");
		listbrennart.add("Gebl�sebrenner 2-stufig mit Heiz�l");
		listbrennart.add("Verdampfungsbrenner");
		listbrennart.add("Gebl�sebrenner 1-stufig mit Gas");
		listbrennart.add("Gebl�sebrenner 2-stufig mit Gas");
		listbrennart.add("Athmosph�rischer Brenner");

		ObservableList<String> obslistbrennart = FXCollections.observableList(listbrennart);
		cbBrennart.setItems(obslistbrennart);
		cbBrennart.getSelectionModel().select(brennerart);

	}

	/**
	 *Speichert das erhaltene Objekt auf statische Variabeln
	 *
	 * @param liegenschaft
	 */
	public static void bekommeLiegenschaft(Liegenschaft liegenschaft) {
		liegupdate = liegenschaft;

		// Kunde holen
		kontaktvonlieg = liegenschaft.getKontakt();

		vorname = kontaktvonlieg.getVorname();
		nachname = kontaktvonlieg.getNachname();

		// Liegeschaftsdaten holen
		strassel = liegenschaft.getStrasse();
		ortl = liegenschaft.getOrt().getOrt();
		plzl = String.valueOf(liegenschaft.getOrt().getPlz());
		infovorort = liegenschaft.getInfoVorOrt();
		feuerungsleistung = String.valueOf(liegenschaft.getFeuerungsanlage().getFeuerungswaermeleistung());

		// Feuerungsanlage holen
		Feuerungsanlage feueranl = liegenschaft.getFeuerungsanlage();

		// Brennerdaten holen
		brennertyp = feueranl.getBrenner().getBrennerTyp();
		brennerart = feueranl.getBrenner().getBrennerArtString();
		brennerjahr = String.valueOf(feueranl.getBrenner().getBaujahr());

		// Waermeerzeugerdaten holen
		waermetyp = feueranl.getWaermeerzeuger().getWaermeerzeugerTyp();
		waermeart = feueranl.getWaermeerzeuger().getBrennstoffString();
		waermejahr = String.valueOf(feueranl.getWaermeerzeuger().getBaujahr());
	}


	/**
	 * �berspeichert die Daten des Objekts
	 */
	public void liegenschaftUpdate() {

		String strasse = txtStrasseL.getText();
		String ort = txtOrtL.getText();
		String plz = txtPlzL.getText();
		String brennertyp = txtBrennertyp.getText();
		String brennerart = cbBrennart.getValue().toString();
		String brennerjahr = txtBrennerjahr.getText();
		String waermetyp = txtWaermetyp.getText();
		String waermeart = cbBrennstoff.getValue().toString();
		String waermejahr = txtWaermejahr.getText();
		String infovorort = txtInfo.getText();
		String leistung = txtFeuerungswaermekW.getText();

		// �berpr�fung ob die Felder auch mit einem Wert belegt wurden
		if (strasse.isEmpty() || ort.isEmpty() || plz.isEmpty() || brennertyp.isEmpty() || brennerart.isEmpty()
				|| brennerjahr.isEmpty() || waermetyp.isEmpty() || waermeart.isEmpty() || waermejahr.isEmpty()
				|| infovorort.isEmpty() || leistung.isEmpty()) {
			lblRueckmeldung.setText(" Bitte alle Felder ausf�llen!");
		} else {
			// Combobox je nach Text int vergeben
			int brennerA = 0;
			switch (brennerart) {
			case "Gebl�sebrenner 1-stufig mit Heiz�l":
				brennerA = 1;
				break;
			case "Gebl�sebrenner 2-stufig mit Heiz�l":
				brennerA = 2;
				break;
			case "Verdampfungsbrenner":
				brennerA = 3;
				break;
			case "Gebl�sebrenner 1-stufig mit Gas":
				brennerA = 4;
				break;
			case "Gebl�sebrenner 2-stufig mit Gas":
				brennerA = 5;
				break;
			case "Athmosph�rischer Brenner":
				brennerA = 6;
				break;
			}

			// Combobox je nach Text int vergeben
			int waermeA = 0;
			switch (waermeart) {
			case "�l":
				waermeA = 1;
				break;
			case "Erdgas":
				waermeA = 2;
				break;
			case "Fl�ssiggas":
				waermeA = 3;
				break;
			}

			// W�rmeerzeugerjahr in int parsen
			int waermeJ = Integer.parseInt(waermejahr);
			// brennerjahr in int parsen
			int brennerJ = Integer.parseInt(brennerjahr);
			// plz parsen
			int plzint = Integer.parseInt(plz);

			int leistungint = Integer.parseInt(leistung);

//			try {
//				Liegenschaft newliegenschaft = updateLiegenschaft(strasse, plzint, ort, infovorort, brennertyp,
//						brennerA, brennerJ, waermetyp, waermeA, waermeJ, leistungint);
//				Main.getFeuerungsRapportService().update(newliegenschaft);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				lblRueckmeldung.setText("Liegenschaft konnte nicht gespeichert werden");
//				e.printStackTrace();
//			}
			((Stage) leaf.getScene().getWindow()).close();
		}
	}

	/**
	 * Manuelles suchen um den Kontakt in der Tableview anzuzeigen
	 */
	public void kontaktSuchen() {
		String vornameK = txtVorname.getText();
		String nameK = txtNachname.getText();

		if (nameK.isEmpty() || vornameK.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");

		} else {

//			try {
//				List<Kontakt> list = Main.getFeuerungsRapportService().findByNameVorname(nameK, vornameK);
//				ObservableList<Kontakt> list2 = FXCollections.observableList(list);
//
//				tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
//				tblNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
//				tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
//				tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
//				tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));
//				tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//				tvKundentbl.setItems(list2);
//
//			} catch (Exception e) {
//				lblRueckmeldung.setText("Kontakt wurde nicht gefunden");
//			}
		}
	}


	/**
	 * Setzt die Parameter zu einem neuen Liegenschaftsobjekt zusammen
	 *
	 * @param strasse
	 * @param plz
	 * @param ortbez
	 * @param info
	 * @param btyp
	 * @param bart
	 * @param bjahr
	 * @param wtyp
	 * @param wart
	 * @param wjahr
	 * @param leistung
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft updateLiegenschaft(String strasse, int plz, String ortbez, String info, String btyp, int bart,
			int bjahr, String wtyp, int wart, int wjahr, int leistung) throws Exception {

		List<Ort> ortsliste = new ArrayList<Ort>();

		liegupdate.setStrasse(strasse);

//		ortsliste = Main.getFeuerungsRapportService().findByOrtPlz(plz);

		// durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die
		// gleiche ist.

		boolean found = false;
		for (Ort o : ortsliste) {
			if (ortbez.equals(o.getOrt())) {
				liegupdate.setOrt(o);
				found = true;
				break;
			}
		}
		// wenn nicht gefunden wird neu�er ort hinzugef�gt
		// orte k�nnen nicht upgedated werden etweder gefunden oder neu
//		if (!found) {
//			Ort ortDb = Main.getFeuerungsRapportService().add(new Ort(plz, ortbez));
//			liegupdate.setOrt(ortDb);
//		}

		liegupdate.setInfoVorOrt(info);

		// neues Brenenrobjekt erstellen und speicher
		Brenner brenner = liegupdate.getFeuerungsanlage().getBrenner();

//		Brenner brenner2 = Main.getFeuerungsRapportService().update(brenner);

		// neues Waermeerzeugerobjekt erstellen und speicher
		Waermeerzeuger waermeerzeuger = liegupdate.getFeuerungsanlage().getWaermeerzeuger();

//		Waermeerzeuger waermeerzeuger2 = Main.getFeuerungsRapportService().update(waermeerzeuger);

		// Feuerungsanlageobjekt erstellen, speichern und Liegenschaft
		// hinzuf�gen
		Feuerungsanlage feuera = liegupdate.getFeuerungsanlage();

//		Feuerungsanlage feuera2 = Main.getFeuerungsRapportService().updatLiegenschaft(feuera);
//		liegupdate.setFeuerungsanlage(feuera2);

		// Kontakt nehmen und hinzuf�gen
		Kontakt indSelected = (Kontakt) tvKundentbl.getSelectionModel().getSelectedItem();
		liegupdate.setKontakt(indSelected);

		return liegupdate;
	}

	/**
	 * Diese Methode f�hrt den User zur �bersicht Rapports�bersicht zur�ck.
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
