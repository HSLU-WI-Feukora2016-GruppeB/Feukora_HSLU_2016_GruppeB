package application.view.rapport;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import application.RmiUtil;
import entitys.Auftrag;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Messung;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi.interfaces.AuftragRO;
import rmi.interfaces.MessungRO;
import rmi.interfaces.OrtRO;

/**
 * Dies ist die Dokumentation der Klasse RapportErfassen. Hier werden neue
 * Feruengsrapporte erstellt.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 3.0
 * @since 1.0
 */

public class RapportErfassen {

	static Auftrag ausgewaehlterauftrag;
	MessungRO messungRO;
	AuftragRO auftragRO;
	OrtRO ortRO;

	@FXML
	private Button btnNeu;

	@FXML
	private TextField txtName, txtVorname, txtPLZ, txtOrt, txtTelefonNr, txtStrasseL, txtOrtL, txtPlzL, txtInfo,
			txtBrenner, txtBaujahr, txtBrennstoff, txtWaermeerzeuger, txtBaujahrW, txtBrennstoffW, txtLeistung,
			txtAuftragsart;

	// ----------------Messung1--------------------
	@FXML
	private TextField txtM1S1Russzahl, txtM1S1CO, txtM1S1Abgastemperatur, txtM1S1Verbrenn, txtM1S1Nox, txtM1S1Waermeerz,
			txtM1S1O2, txtM1S1Abgasverl, txtM1S2Russzahl, txtM1S2CO, txtM1S2Abgastemperatur, txtM1S2Verbrenn,
			txtM1S2Nox, txtM1S2Waermeerz, txtM1S2O2, txtM1S2Abgasverl;

	@FXML
	private CheckBox checkM1S1Oel, checkM1S2Oel;

	// ----------------Messung2---------------------
	@FXML
	private TextField txtM2S1Russzahl, txtM2S1CO, txtM2S1Abgastemperatur, txtM2S1Verbrenn, txtM2S1Nox, txtM2S1Waermeerz,
			txtM2S1O2, txtM2S1Abgasverl, txtM2S2Russzahl, txtM2S2CO, txtM2S2Abgastemperatur, txtM2S2Verbrenn,
			txtM2S2Nox, txtM2S2Waermeerz, txtM2S2O2, txtM2S2Abgasverl;

	@FXML
	private CheckBox checkM2S1Oel, checkM2S2Oel;

	@FXML
	private Label lblRueckmeldung;

	// Deklerationen für die bekommeAuftrag() methode
	private static String kundenvorname, kundenname, kundenort, kundenplz, kundentelnr, liegenschaftsstrasse,
			Liegenschaftsort, Liegenschaftsplz, Liegenschaftsinfo, brennertyp, brennerjahr, brennerstoff, waermetyp,
			waermejahr, waermestoff, auftragsart, feuerungsleistung;

	// Grenzwertcheckboxen
	@FXML
	private CheckBox cb30Tage, cbEinregulierung, cbBeurteilung, cbAbgasverluste, cbRusszahl, cbOelanteil, cbCo2, cbNo2;

	@FXML
	private TextArea taBemerkung;

	@FXML
	private Stage leaf;

	public void initialize() throws Exception {

		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		messungRO = RmiUtil.getMessungRO();
		auftragRO = RmiUtil.getAuftragRO();
		ortRO = RmiUtil.getOrtRO();

		/*----------------------------------------------*/

		// Kundenfelder setzen
		txtName.setText(kundenname);
		txtVorname.setText(kundenvorname);
		txtOrt.setText(kundenort);
		txtPLZ.setText(kundenplz);
		txtTelefonNr.setText(kundentelnr);

		// Liegenschaftsfelder setzen
		txtStrasseL.setText(liegenschaftsstrasse);
		txtOrtL.setText(Liegenschaftsort);
		txtPlzL.setText(Liegenschaftsplz);
		txtInfo.setText(Liegenschaftsinfo);

		// Brennerfelder setzen
		txtBrenner.setText(brennertyp);
		txtBaujahr.setText(brennerjahr);
		txtBrennstoff.setText(brennerstoff);

		// Wärmeerzeugerfelder setzen
		txtWaermeerzeuger.setText(waermetyp);
		txtBaujahrW.setText(waermejahr);
		txtBrennstoffW.setText(waermestoff);

		// Kontrollarten setzen
		txtAuftragsart.setText(auftragsart);
		txtLeistung.setText(feuerungsleistung);
	}

	public static void bekommeAuftrag(Auftrag auftrag) {

		ausgewaehlterauftrag = auftrag;

		// Kundenobjekt zerlegen
		kundenvorname = auftrag.getKunde().getVorname();
		kundenname = auftrag.getKunde().getNachname();
		kundenort = auftrag.getKunde().getOrt().getOrt();
		kundenplz = String.valueOf(auftrag.getKunde().getOrt().getPlz());
		kundentelnr = auftrag.getKunde().getTel();

		Liegenschaft liegenschaft = auftrag.getLiegenschaft();
		// Liegenschaftsobjekt zerlegen
		liegenschaftsstrasse = liegenschaft.getStrasse();
		Liegenschaftsort = liegenschaft.getOrt().getOrt();
		Liegenschaftsplz = String.valueOf(liegenschaft.getOrt().getPlz());
		Liegenschaftsinfo = liegenschaft.getInfoVorOrt();

		Feuerungsanlage feuerungs = liegenschaft.getFeuerungsanlage();
		// Brenner zerlegen
		brennertyp = feuerungs.getBrenner().getBrennerTyp();
		brennerjahr = String.valueOf(feuerungs.getBrenner().getBaujahr());
		brennerstoff = feuerungs.getBrenner().getBrennerArtString();

		// Wärmeerzeuger zerlegen
		waermetyp = feuerungs.getWaermeerzeuger().getWaermeerzeugerTyp();
		waermejahr = String.valueOf(feuerungs.getWaermeerzeuger().getBaujahr());
		waermestoff = feuerungs.getWaermeerzeuger().getBrennstoffString();

		// Kontrollarten
		auftragsart = auftrag.getTerminArt();
		feuerungsleistung = String.valueOf(feuerungs.getFeuerungswaermeleistung());
	}

	public void messwertePruefen() {
		//

		// DIESER TEIL SEHRWAHRSCHEINLICH UNNTÖTIG!!
		// //Kundenfelder holen
		// String name = txtName.getText();
		// String vorname = txtVorname.getText();
		// String plz = txtPlz.getText();
		// String ort = txtOrt.getText();
		// String telnr = txtTelefonNr.getText();
		//
		// //Liegenschaftsfelder holen
		// String strassel = txtStrasseL.getText();
		// String ortl = txtOrtL.getText();
		// String plzl = txtPlzL.getText();
		// String info = txtInfo.getText();
		// String brenner = txtBrenner.getText();
		// String baujahr = txtBaujahr.getText();
		// String brennstoff = txtBrennstoff.getText();
		// String waermeerzeuger = txtWaermeerzeuger.getText();
		// String baujahrw = txtBaujahrW.getText();
		// String brennstoffw = txtBrennstoffW.getText();
		//
		// //Kontrollarten holen
		// String leistung = txtLeistung.getText();
		// String kontrollart = cbKontrollart.getValue();

		Messung messung1stufe1 = null, messung2stufe1 = null, messung1stufe2 = null, messung2stufe2 = null;
		try {
			messung1stufe1 = this.createMessung1Stufe1();
			messung1stufe2 = this.createMessung1Stufe2();
			messung2stufe1 = this.createMessung2Stufe1();
			messung2stufe2 = this.createMessung2Stufe2();
		} catch (Exception e1) {
			lblRueckmeldung.setText("Messungen abspeichern fehlgeschlagen");
			e1.printStackTrace();
		}

		Auftrag gespeicherterauftrag = null;

		// könnte es sein dass wenn eine Messung nicht ausgefüllt worden ist und
		// somit in messungpruefen() eine
		// null Referenz bekommt, ich diese dann in den auftrag speicher und den
		// Auftrag in die Db speichere, dass programm
		// dann crasht?
		ausgewaehlterauftrag.setMessung1stufe1(messung1stufe1);

		ausgewaehlterauftrag.setMessung1stufe1(messung2stufe1);

		ausgewaehlterauftrag.setMessung2stufe1(messung1stufe2);

		ausgewaehlterauftrag.setMessung1stufe1(messung2stufe2);
		try {

			// hier update oder add? eigentlich update da sonst wieder ein neues
			// Objekt in der DB angelegt wird oder?
			// das Backoffice hat ja eines angelegt.
			gespeicherterauftrag = auftragRO.update(ausgewaehlterauftrag);

		} catch (Exception e) {
			lblRueckmeldung.setText("Auftrag speichern fehlgeschlagen");
			e.printStackTrace();
		}

		ArrayList<Messung> messungsliste = new ArrayList<Messung>();
		messungsliste.add(gespeicherterauftrag.getMessung1stufe1());
		messungsliste.add(gespeicherterauftrag.getMessung2stufe1());
		messungsliste.add(gespeicherterauftrag.getMessung1stufe2());
		messungsliste.add(gespeicherterauftrag.getMessung2stufe2());

		for (Messung m : messungsliste) {
			boolean notokey = m.isBeurteilungNotOk();
			if (notokey) {
				cbBeurteilung.setSelected(true);
				for (Messung m2 : messungsliste) {
					notokey = m2.isAbgasverlusteNotOk();
					if (notokey) {
						cbAbgasverluste.setSelected(true);
					}
					boolean notokey2 = m2.isCoMgNotOk();
					if (notokey2) {
						cbCo2.setSelected(true);
					}
					boolean notokey3 = m2.isNoMgNotOk();
					if (notokey3) {
						cbNo2.setSelected(true);
					}
					boolean notokey4 = m2.isOelanteilenNotOk();
					if (notokey4) {
						cbOelanteil.setSelected(true);
					}
					boolean notokey5 = m2.isRusszahlNotOk();
					if (notokey5) {
						cbRusszahl.setSelected(true);
					}
				}
			}
		}
	}

	/**
	 * Hier wird nun der Auftrag endgültig abgespeichert
	 */
	public void auftragSpeichern() {

		ausgewaehlterauftrag.setBemerkung(taBemerkung.getText());
		ausgewaehlterauftrag.setEinregulierungInnert30(cb30Tage.isSelected());
		ausgewaehlterauftrag.setEinregulierungNichtMoeglich(cbEinregulierung.isSelected());

		try {
			this.auftragRO.update(ausgewaehlterauftrag);
		} catch (Exception e) {
			lblRueckmeldung.setText("Auftrag konnte nicht gespeichert werden");
		}

	}

	/**
	 * Diese Methode liefert die 1 Stufe der 1 Messung in einem Messungsobjekt
	 *
	 * @return messung1stufe1
	 * @throws Exception
	 */
	public Messung createMessung1Stufe1() throws Exception {

		String russzahl = txtM1S1Russzahl.getText();
		String cogehalt = txtM1S1CO.getText();
		String abgastemperatur = txtM1S1Abgastemperatur.getText();
		String verbrennungstemperatur = txtM1S1Verbrenn.getText();
		String no2gehalt = txtM1S1Nox.getText();
		String waermer = txtM1S1Waermeerz.getText();
		String o2gehalt = txtM1S1O2.getText();
		String abgasverluste = txtM1S1Abgasverl.getText();
		Boolean oelanteil = checkM1S1Oel.isSelected();
		Messung messung1stufe1 = this.messungpruefen(russzahl, cogehalt, abgastemperatur, verbrennungstemperatur,
				no2gehalt, waermer, o2gehalt, abgasverluste, oelanteil);

		return messung1stufe1;
	}

	/**
	 * Diese Methode liefert die 2 Stufe der 1 Messung in einem Messungsobjekt
	 *
	 * @return messung1stufe1
	 * @throws Exception
	 */
	public Messung createMessung1Stufe2() throws Exception {

		String russzahl = txtM1S2Russzahl.getText();
		String cogehalt = txtM1S2CO.getText();
		String abgastemperatur = txtM1S2Abgastemperatur.getText();
		String verbrennungstemperatur = txtM1S2Verbrenn.getText();
		String no2gehalt = txtM1S2Nox.getText();
		String waermer = txtM1S2Waermeerz.getText();
		String o2gehalt = txtM1S2O2.getText();
		String abgasverluste = txtM1S2Abgasverl.getText();
		Boolean oelanteil = checkM1S2Oel.isSelected();
		Messung messung1stufe2 = this.messungpruefen(russzahl, cogehalt, abgastemperatur, verbrennungstemperatur,
				no2gehalt, waermer, o2gehalt, abgasverluste, oelanteil);

		return messung1stufe2;
	}

	/**
	 * Diese Methode liefert die 1 Stufe der 2 Messung in einem Messungsobjekt
	 *
	 * @return messung1stufe1
	 * @throws Exception
	 */
	public Messung createMessung2Stufe1() throws Exception {

		String russzahl = txtM2S1Russzahl.getText();
		String cogehalt = txtM2S1CO.getText();
		String abgastemperatur = txtM2S1Abgastemperatur.getText();
		String verbrennungstemperatur = txtM2S1Verbrenn.getText();
		String no2gehalt = txtM2S1Nox.getText();
		String waermer = txtM2S1Waermeerz.getText();
		String o2gehalt = txtM2S1O2.getText();
		String abgasverluste = txtM2S1Abgasverl.getText();
		Boolean oelanteil = checkM2S1Oel.isSelected();
		Messung messung2stufe1 = this.messungpruefen(russzahl, cogehalt, abgastemperatur, verbrennungstemperatur,
				no2gehalt, waermer, o2gehalt, abgasverluste, oelanteil);

		return messung2stufe1;
	}

	/**
	 * Diese Methode liefert die 1 Stufe der 2 Messung in einem Messungsobjekt
	 *
	 * @return messung1stufe1
	 * @throws Exception
	 */
	public Messung createMessung2Stufe2() throws Exception {

		String russzahl = txtM2S2Russzahl.getText();
		String cogehalt = txtM2S2CO.getText();
		String abgastemperatur = txtM2S2Abgastemperatur.getText();
		String verbrennungstemperatur = txtM2S2Verbrenn.getText();
		String no2gehalt = txtM2S2Nox.getText();
		String waermer = txtM2S2Waermeerz.getText();
		String o2gehalt = txtM2S2O2.getText();
		String abgasverluste = txtM2S2Abgasverl.getText();
		Boolean oelanteil = checkM2S2Oel.isSelected();
		Messung messung2stufe2 = this.messungpruefen(russzahl, cogehalt, abgastemperatur, verbrennungstemperatur,
				no2gehalt, waermer, o2gehalt, abgasverluste, oelanteil);

		return messung2stufe2;
	}

	/**
	 * Prueft die Messwerte der Messungen
	 *
	 * @param stringrusszahl
	 * @param stringcogehalt
	 * @param stringabgastemperatur
	 * @param stringverbrennungstemparatur
	 * @param stringno2gehalt
	 * @param stringwaermer
	 * @param stringo2gehalt
	 * @param stringabgasverluste
	 * @param oelanteil
	 * @return m
	 * @throws Exception
	 */
	private Messung messungpruefen(String stringrusszahl, String stringcogehalt, String stringabgastemperatur,
			String stringverbrennungstemparatur, String stringno2gehalt, String stringwaermer, String stringo2gehalt,
			String stringabgasverluste, boolean oelanteil) throws Exception {

		// falls nur ein Feld nicht ausgefüllt wird wird die Messung nicht
		// abgespeichert und der Kotrolleur weiss es nicht!!!!!!!!!!
		if (stringrusszahl.isEmpty() || stringcogehalt.isEmpty() || stringabgastemperatur.isEmpty()
				|| stringverbrennungstemparatur.isEmpty() || stringno2gehalt.isEmpty() || stringwaermer.isEmpty()
				|| stringo2gehalt.isEmpty() || stringabgasverluste.isEmpty()) {
			// objekt wird mit null Referenzzuweisung gelöscht
			return null;
		} else {
			// Alles parsen
			int russzahl = Integer.parseInt(stringrusszahl);
			int coGehalt = Integer.parseInt(stringcogehalt);
			int abgastemperatur = Integer.parseInt(stringabgastemperatur);
			int verbrennungstemperatur = Integer.parseInt(stringverbrennungstemparatur);
			int no2gehalt = Integer.parseInt(stringno2gehalt);
			int waermeerzeugertemperatur = Integer.parseInt(stringwaermer);
			int o2gehalt = Integer.parseInt(stringo2gehalt);
			int abgasverluste = Integer.parseInt(stringabgasverluste);

			// heutiges Datum holen
			GregorianCalendar messDatum = new GregorianCalendar();
			messDatum.getInstance().getTime();

			Messung messung = new Messung(messDatum, russzahl, coGehalt, oelanteil, no2gehalt, abgastemperatur,
					waermeerzeugertemperatur, verbrennungstemperatur, o2gehalt, abgasverluste);

			// Messung in der DB abspeichern
			Messung m = messungRO.add(messung);

			return m;
		}

	}

	/**
	 * verlässt die Szene
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
