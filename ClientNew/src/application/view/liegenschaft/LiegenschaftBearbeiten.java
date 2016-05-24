package application.view.liegenschaft;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.RmiUtil;
import application.view.kontakt.KontaktBearbeiten;
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
import rmi.interfaces.AuftragRO;
import rmi.interfaces.BenutzerRO;
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.MessungRO;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;

/**
 * Dies ist die Dokumentation der Klasse LiegenschaftBearbeiten. Mit ihr k�nnen
 * bestehende Liegenschaften ver�ndert und in der Datenbank bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
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

	KontaktRO kontaktRO;
	LiegenschaftRO liegenschaftRO;
	WaermeerzeugerRO waermeerzeugerRO;
	BrennerRO brennerRO;
	OrtRO ortRO;
	FeuerungsanlageRO feuerungsanlageRO;

	public void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		kontaktRO = RmiUtil.getKontaktRO();
		brennerRO = RmiUtil.getBrennerRO();
		feuerungsanlageRO = RmiUtil.getFeuerungsanlageRO();
		kontaktRO = RmiUtil.getKontaktRO();
		liegenschaftRO = RmiUtil.getLiegenschaftRO();
		ortRO = RmiUtil.getOrtRO();
		waermeerzeugerRO = RmiUtil.getWaermeerzeugerRO();

		/*----------------------------------------------*/

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
		cbBrennstoff.getSelectionModel().select(brennerart);

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

			try {
				Liegenschaft newliegenschaft = updateLiegenschaft(strasse, plzint, ort, infovorort, brennertyp,
						brennerA, brennerJ, waermetyp, waermeA, waermeJ, leistungint);
				liegenschaftRO.update(newliegenschaft);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				lblRueckmeldung.setText("Liegenschaft konnte nicht gespeichert werden");
				e.printStackTrace();
			}
			((Stage) leaf.getScene().getWindow()).close();
		}
	}

	public void kontaktSuchen() {
		String vornameK = txtVorname.getText();
		String nameK = txtNachname.getText();

		if (nameK.isEmpty() || vornameK.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder m�ssen ausgef�llt werden!");

		} else {

			try {
				List<Kontakt> list = kontaktRO.findByNameVorname(nameK, vornameK);
				ObservableList<Kontakt> list2 = FXCollections.observableList(list);

				tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
				tblNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
				tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
				tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
				tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));
				tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

				tvKundentbl.setItems(list2);

			} catch (Exception e) {
				lblRueckmeldung.setText("Kontakt wurde nicht gefunden");
			}
		}
	}

	public Liegenschaft updateLiegenschaft(String strasse, int plz, String ortbez, String info, String btyp, int bart,
			int bjahr, String wtyp, int wart, int wjahr, int leistung) throws Exception {

		List<Ort> ortsliste = new ArrayList<Ort>();
		
		liegupdate.setStrasse(strasse);

		ortsliste = ortRO.findByOrtPlz(plz);

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
		if (!found) {
			Ort ortDb = ortRO.add(new Ort(plz, ortbez));
			liegupdate.setOrt(ortDb);
		}

		liegupdate.setInfoVorOrt(info);

		// neues Brenenrobjekt erstellen und speicher
		Brenner brenner = liegupdate.getFeuerungsanlage().getBrenner();

		Brenner brenner2 = brennerRO.update(brenner);

		// neues Waermeerzeugerobjekt erstellen und speicher
		Waermeerzeuger waermeerzeuger = liegupdate.getFeuerungsanlage().getWaermeerzeuger();

		Waermeerzeuger waermeerzeuger2 = waermeerzeugerRO.update(waermeerzeuger);

		// Feuerungsanlageobjekt erstellen, speichern und Liegenschaft
		// hinzuf�gen
		Feuerungsanlage feuera = liegupdate.getFeuerungsanlage();

		Feuerungsanlage feuera2 = feuerungsanlageRO.update(feuera);
		liegupdate.setFeuerungsanlage(feuera2);

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
