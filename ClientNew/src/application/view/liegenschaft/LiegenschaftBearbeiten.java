package application.view.liegenschaft;

import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;



public class LiegenschaftBearbeiten {

	KontaktRO kontaktRO;
	LiegenschaftRO liegenschaftRO;
	WaermeerzeugerRO waermeerzeugerRO;
	BrennerRO brennerRO;
	OrtRO ortRO;
	FeuerungsanlageRO feuerungsanlageRO;

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
	private ComboBox<String> cbBrennart, cbBrennstoff;

	@FXML
	private Button btnSuchen;

	@FXML
	private BorderPane leaf;

	static Liegenschaft liegupdate;

	//Variabelndeklaration f�r static bekommeLiegenschaft() methode
	static String strassel,ortl,plzl,infovorort,feuerungsleistung,vorname,nachname,
	brennertyp,brennerart,brennerjahr, waermetyp, waermeart, waermejahr;

	static Kontakt kontaktvonlieg;

	public void initialize(){

		//Kontaktanzeigen
		ArrayList<Kontakt> setkontakt = new ArrayList<Kontakt>();
		setkontakt.add(kontaktvonlieg);
		ObservableList<Kontakt> setkontakt2 = FXCollections.observableList(setkontakt);
		tvKundentbl.setItems(setkontakt2);

		txtVorname.setText(vorname);
		txtNachname.setText(nachname);

		//Liegenschaft anzeigen
		txtStrasseL.setText(strassel);
		txtOrtL.setText(ortl);
		txtPlzL.setText(plzl);
		txtInfo.setText(infovorort);

		//Brenner anzeigen
		txtBrennertyp.setText(brennertyp);
		txtBrennerjahr.setText(brennerjahr);
		//Brennerart in die Combobox einf�gen
		List<String> listbrennstoff = new ArrayList<String>();
		listbrennstoff.add("�l");
		listbrennstoff.add("Erdgas");
		listbrennstoff.add("Fl�ssiggas");

		ObservableList<String> listbrennstoff2 = FXCollections.observableList(listbrennstoff);
		cbBrennstoff.setItems(listbrennstoff2);
		cbBrennstoff.getSelectionModel().select(brennerart);

		//Waermeerzeuger anzeigen
		txtWaermetyp.setText(waermetyp);
		txtWaermejahr.setText(waermejahr);
		//Waermeerzeugerart in die Combobox einf�gen
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

	public static void bekommeLiegenschaft(Liegenschaft liegenschaft){
		liegupdate = liegenschaft;

		//Kunde holen
		Kontakt kontaktvonlieg = liegenschaft.getKontakt();
		vorname = kontaktvonlieg.getVorname();
		nachname = kontaktvonlieg.getNachname();

		//Liegeschaftsdaten holen
		strassel = liegenschaft.getStrasse();
		ortl = liegenschaft.getOrt().getOrt();
		plzl = String.valueOf(liegenschaft.getOrt().getPlz());
		infovorort = liegenschaft.getInfoVorOrt();
		feuerungsleistung = String.valueOf(liegenschaft.getFeuerungsanlage().getFeuerungswaermeleistung());

		//Feuerungsanlage holen
		Feuerungsanlage feueranl = liegenschaft.getFeuerungsanlage();

		//Brennerdaten holen
		brennertyp = feueranl.getBrenner().getBrennerTyp();
		brennerart = feueranl.getBrenner().getBrennerArtString();
		brennerjahr = String.valueOf(feueranl.getBrenner().getBaujahr());

		//Waermeerzeugerdaten holen
		waermetyp = feueranl.getWaermeerzeuger().getWaermeerzeugerTyp();
		waermeart = feueranl.getWaermeerzeuger().getBrennstoffString();
		waermejahr = String.valueOf(feueranl.getWaermeerzeuger().getBaujahr());
	}



	public void liegenschaftUpdate(){

		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPlz.getText();
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
				Liegenschaft newliegenschaft = updateLiegenschaft(strasse, plzint, ort,infovorort,
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
				tvKundentbl.setItems(list2);
			} catch (Exception e) {
				lblRueckmeldung.setText("Kontakt wurde nicht gefunden");
			}
		}
	}




	public Liegenschaft updateLiegenschaft(	String strasse, int plz, String ortbez, String info, String btyp, int bart,
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
		Brenner brenner2 = brennerRO.update(brenner);

		// neues Waermeerzeugerobjekt erstellen und speicher
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(wart,wtyp,wjahr);
		Waermeerzeuger	waermeerzeuger2 = waermeerzeugerRO.update(waermeerzeuger);

		//Feuerungsanlageobjekt erstellen, speichern und Liegenschaft hinzuf�gen
		Feuerungsanlage feuera = new Feuerungsanlage(brenner2,waermeerzeuger2,leistung);
		Feuerungsanlage feuera2 = feuerungsanlageRO.update(feuera);
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
