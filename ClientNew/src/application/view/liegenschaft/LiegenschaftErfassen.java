package application.view.liegenschaft;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import application.view.rapport.RapportErfassen;
import entitys.*;
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
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;

/**
 * Dies ist die Dokumentation der Klasse LiegenschaftErfassen. Sie dient zur
 * Erfassung neuer Liegenschaften.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class LiegenschaftErfassen {

	KontaktRO kontaktRO;
	LiegenschaftRO liegenschaftRO;
	WaermeerzeugerRO waermeerzeugerRO;
	BrennerRO brennerRO;
	OrtRO ortRO;
	FeuerungsanlageRO feuerungsanlageRO;

	//txtVorname usw nicht mehr gebraucht?
	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtOrt, txtPlz,
		txtStrasseL, txtOrtL, txtPlzL,
		txtBrennertyp, txtBrennerjahr,
		txtWaermetyp, txtWaermejahr, txtInfo, txtFeuerungswaermekW;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private TableView tvKundentbl;

	@FXML
	private TableColumn tblNachname, tblVorname, tblStrasse, tblEmail, tblTelefon, tblOrt;

	@FXML
	private ComboBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	@FXML
	private BorderPane leaf;


	public void initialize() throws Exception{

		/*---------------RMI Verbindung---------------*/


		String KontaktROName = "Kontakt";
		String LiegenschaftRO = "Liegenschaft";
		String WaermeerzeugerRO = "Waermerzeuger";
		String BrennerRO = "Brenner";
		String OrtRO = "Ort";
		String FeuerungsanlageRO = "Feuerungsanlage";

		try {

			// Properties Objekt erstellen
			Properties rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = LiegenschaftErfassen.class.getClassLoader();

			// Properties laden
			try {
				rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Port RMI auslesen
			String stringPort = rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren

			String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/" + KontaktROName;
			String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/" + LiegenschaftRO;
			String urlWaermeerzeugerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + WaermeerzeugerRO;
			String urlBrennerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + BrennerRO;
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/" + OrtRO;
			String urlFeuerungsanlageRO = "rmi://" + hostIp + ":" + rmiPort + "/" + FeuerungsanlageRO;

			/* Lookup */
			brennerRO = (BrennerRO) Naming.lookup(urlBrennerRO);
			feuerungsanlageRO = (FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
			kontaktRO = (KontaktRO) Naming.lookup(urlKontaktRO);
			liegenschaftRO = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
			ortRO = (OrtRO) Naming.lookup(urlOrtRO);
			waermeerzeugerRO = (WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}

/*----------------------------------------------*/



		List<String> listbrennstoff = new ArrayList<String>();
		listbrennstoff.add("�l");
		listbrennstoff.add("Erdgas");
		listbrennstoff.add("Fl�ssiggas");


		ObservableList<String> obslistbrennstoff = FXCollections.observableList(listbrennstoff);
		cbBrennstoff.setItems(obslistbrennstoff);

		List<String> listbrennart = new ArrayList<String>();
		listbrennart.add("Gebl�sebrenner 1-stufig mit Heiz�l");
		listbrennart.add("Gebl�sebrenner 2-stufig mit Heiz�l");
		listbrennart.add("Verdampfungsbrenner");
		listbrennart.add("Gebl�sebrenner 1-stufig mit Gas");
		listbrennart.add("Gebl�sebrenner 2-stufig mit Gas");
		listbrennart.add("Athmosph�rischer Brenner");

		ObservableList<String> obslistbrennart = FXCollections.observableList(listbrennart);
		cbBrennart.setItems(obslistbrennart);

	}
	/**
	 * Methode speichert eine Liegenschaft neu.
	 */
	public void liegenschaftSpeichern() {

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
			//plz parsen
			int plzint = Integer.parseInt(plz);

			int leistungint = Integer.parseInt(leistung);

			try {
				Liegenschaft newliegenschaft = createLiegenschaft(strasse, plzint, ort,infovorort,
						brennertyp, brennerA, brennerJ, waermetyp, waermeA, waermeJ, leistungint);
				liegenschaftRO.add(newliegenschaft);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				lblRueckmeldung.setText("Liegenschaft konnte nicht gespeichert werden");
			}


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
				tblNachname.setCellValueFactory(new PropertyValueFactory<>("name"));
				tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
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


	public Liegenschaft createLiegenschaft(	String strasse, int plz, String ortbez, String info, String btyp, int bart,
			int bjahr, String wtyp, int wart, int wjahr, int leistung) throws Exception{

		List<Ort> ortsliste = new ArrayList<Ort>();
		Ort ort = new Ort();


		//Liegenschaftsobjekt erstellen und speichern
		Liegenschaft liegenschaft = new Liegenschaft();

		liegenschaft.setStrasse(strasse);

		 ortsliste = ortRO.findByOrtPlz(plz);

			//durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die gleiche ist.
		 for(Ort o: ortsliste){
				if(ortbez.equals(o.getOrt())){
					ort = ortRO.add(o);
					liegenschaft.setOrt(ort);
					}
		 }

		liegenschaft.setInfoVorOrt(info);

		// neues Brenenrobjekt erstellen und speicher
		Brenner brenner = new Brenner(bart,btyp,bjahr);
		Brenner brenner2 = brennerRO.add(brenner);

		// neues Waermeerzeugerobjekt erstellen und speicher
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(wart,wtyp,wjahr);
		Waermeerzeuger	waermeerzeuger2 = waermeerzeugerRO.add(waermeerzeuger);

		//Feuerungsanlageobjekt erstellen, speichern und Liegenschaft hinzuf�gen
		Feuerungsanlage feuera = new Feuerungsanlage(brenner2,waermeerzeuger2,leistung);
		Feuerungsanlage feuera2 = feuerungsanlageRO.add(feuera);
		liegenschaft.setFeuerungsanlage(feuera2);


		//Kontakt nehmen und hinzuf�gen
		Kontakt indSelected = (Kontakt) tvKundentbl.getSelectionModel().getSelectedItem();
		liegenschaft.setKontakt(indSelected);


		return liegenschaft;

	}



	/**
	 * Diese Methode f�hrt den User zur �bersicht Rapports�bersicht zur�ck.
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
