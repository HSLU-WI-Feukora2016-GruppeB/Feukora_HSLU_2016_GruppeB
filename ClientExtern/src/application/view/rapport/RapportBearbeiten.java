package application.view.rapport;


import java.util.ArrayList;
import entitys.Auftrag;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Messung;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *Diese Klasse zeigt einen Rapport mitsamt den erfassten Messdaten an
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 */
public class RapportBearbeiten {

	static Auftrag ausgewaehlterauftrag;


	@FXML
	private Button btnNeu;

	@FXML
	private TextField txtName, txtVorname, txtPlz, txtOrt, txtTelefonNr, txtStrasseL, txtOrtL, txtPlzL, txtInfo,
			txtBrenner, txtBaujahr, txtBrennstoff, txtWaermeerzeuger, txtBaujahrW, txtBrennstoffW, txtLeistung,
			txtAuftragsart;

	// ----------------Stufe 1--------------------
	@FXML
	private TextField txtM1S1Russzahl, txtM1S1CO, txtM1S1Abgastemperatur, txtM1S1Verbrenn, txtM1S1Nox, txtM1S1Waermeerz,
			txtM1S1O2, txtM1S1Abgasverl, txtM1S2Russzahl, txtM1S2CO, txtM1S2Abgastemperatur, txtM1S2Verbrenn,
			txtM1S2Nox, txtM1S2Waermeerz, txtM1S2O2, txtM1S2Abgasverl;

	@FXML
	private CheckBox checkS1M1Oel, checkS1M1Abgas, checkS1M1Russzahl, checkS1M1Co2, checkS1M1No2, checkS1M2Oel,
			checkS1M2Abgas, checkS1M2Russzahl, checkS1M2Co2, checkS1M2No2;

	// ----------------Stufe 2---------------------
	@FXML
	private TextField txtM2S1Russzahl, txtM2S1CO, txtM2S1Abgastemperatur, txtM2S1Verbrenn, txtM2S1Nox, txtM2S1Waermeerz,
			txtM2S1O2, txtM2S1Abgasverl, txtM2S2Russzahl, txtM2S2CO, txtM2S2Abgastemperatur, txtM2S2Verbrenn,
			txtM2S2Nox, txtM2S2Waermeerz, txtM2S2O2, txtM2S2Abgasverl;

	@FXML
	private CheckBox checkS2M1Oel, checkS2M2Oel, checkS2M1Abgas, checkS2M1Russzahl, checkS2M1Co2, checkS2M1No2,
			checkS2M2Abgas, checkS2M2Russzahl, checkS2M2Co2, checkS2M2No2;

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

	Messung m;

	public void initialize() throws Exception {

		// Kundenfelder setzen
		txtName.setText(kundenname);
		txtVorname.setText(kundenvorname);
		txtPlz.setText(kundenplz);
		txtTelefonNr.setText(kundentelnr);

		// Liegenschaftsfelder setzen
		txtStrasseL.setText(liegenschaftsstrasse);
		txtOrtL.setText(Liegenschaftsort);
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

		// Bewertungsfelder anzeigen
		ArrayList<Messung> messungsliste = new ArrayList<Messung>();
		messungsliste.add(ausgewaehlterauftrag.getMessung1stufe1());
		messungsliste.add(ausgewaehlterauftrag.getMessung2stufe1());
		messungsliste.add(ausgewaehlterauftrag.getMessung1stufe2());
		messungsliste.add(ausgewaehlterauftrag.getMessung2stufe2());
		cb30Tage.setSelected(ausgewaehlterauftrag.isEinregulierungInnert30());
		cbEinregulierung.setSelected(ausgewaehlterauftrag.isEinregulierungNichtMoeglich());

		setMessung1Stufe1();
		setMessung2Stufe1();
		setMessung1Stufe2();
		setMessung2Stufe2();

		taBemerkung.setText(ausgewaehlterauftrag.getBemerkung());

		/*---------wird nicht mehr gebraucht
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
		*/
		// Manuell eingetragene Felder des Kontrolleurs anzeigen


	}

	/**
	 * speichert den ausgewählten auftrag auf Variabeln
	 *
	 * @param auftrag
	 */
	public static void bekommeAuftrag(Auftrag auftrag) {

		ausgewaehlterauftrag = auftrag;

		// Kundenobjekt zerlegen
		kundenvorname = auftrag.getKunde().getVorname();
		kundenname = auftrag.getKunde().getNachname();
		kundenplz = String.valueOf(auftrag.getKunde().getOrt().toString());
		kundentelnr = auftrag.getKunde().getTel();

		Liegenschaft liegenschaft = auftrag.getLiegenschaft();
		// Liegenschaftsobjekt zerlegen
		liegenschaftsstrasse = liegenschaft.getStrasse();
		Liegenschaftsort = liegenschaft.getOrt().toString();
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

	/**
	 * Diese Methode liefert die 1 Stufe der 1 Messung in einem Messungsobjekt
	 *
	 * @throws Exception
	 */
	public void setMessung1Stufe1() throws Exception {
		m= ausgewaehlterauftrag.getMessung1stufe1();

		if(m != null){
		 txtM1S1Russzahl.setText(String.valueOf(m.getRusszahl()));
		txtM1S1CO.setText(String.valueOf(m.getCoGehalt()));
		txtM1S1Abgastemperatur.setText(String.valueOf(m.getAbgastemperatur()));
		txtM1S1Verbrenn.setText(String.valueOf(m.getVerbrennungstemperatur()));
		txtM1S1Nox.setText(String.valueOf(m.getNo2Gehalt()));
		txtM1S1Waermeerz.setText(String.valueOf(m.getWaermeerzeugertemperatur()));
		txtM1S1O2.setText(String.valueOf(m.getO2gehalt()));
		txtM1S1Abgasverl.setText(String.valueOf(m.getAbgasverluste()));
		checkS1M1Oel.setSelected(m.isOelanteilenNotOk());
		checkS1M1Abgas.setSelected(m.isAbgasverlusteNotOk());
		checkS1M1Russzahl.setSelected(m.isRusszahlNotOk());
		checkS1M1Co2.setSelected(m.isCoMgNotOk());
		checkS1M1No2.setSelected(m.isNoMgNotOk());
		}
	}

	/**
	 * Diese Methode liefert die 1 Stufe der 2 Messung in einem Messungsobjekt
	 *
	 * @throws Exception
	 */
	public void setMessung2Stufe1() throws Exception {
		m= ausgewaehlterauftrag.getMessung2stufe1();
		if(m!= null){
		 txtM2S1Russzahl.setText(String.valueOf(m.getRusszahl()));
		txtM2S1CO.setText(String.valueOf(m.getCoGehalt()));
		txtM2S1Abgastemperatur.setText(String.valueOf(m.getAbgastemperatur()));
		txtM2S1Verbrenn.setText(String.valueOf(m.getVerbrennungstemperatur()));
		txtM2S1Nox.setText(String.valueOf(m.getNo2Gehalt()));
		txtM2S1Waermeerz.setText(String.valueOf(m.getWaermeerzeugertemperatur()));
		txtM2S1O2.setText(String.valueOf(m.getO2gehalt()));
		txtM2S1Abgasverl.setText(String.valueOf(m.getAbgasverluste()));
		checkS1M2Oel.setSelected(m.isOelanteilenNotOk());
		checkS1M2Abgas.setSelected(m.isAbgasverlusteNotOk());
		checkS1M2Russzahl.setSelected(m.isRusszahlNotOk());
		checkS1M2Co2.setSelected(m.isCoMgNotOk());
		checkS1M2No2.setSelected(m.isNoMgNotOk());
		}
	}


	/**
	 * Diese Methode liefert die 2 Stufe der 1 Messung in einem Messungsobjekt
	 *
	 * @throws Exception
	 */
	public void setMessung1Stufe2() throws Exception {
		m= ausgewaehlterauftrag.getMessung1stufe2();
		if(m!= null){
		 txtM1S2Russzahl.setText(String.valueOf(m.getRusszahl()));
		txtM1S2CO.setText(String.valueOf(m.getCoGehalt()));
		txtM1S2Abgastemperatur.setText(String.valueOf(m.getAbgastemperatur()));
		txtM1S2Verbrenn.setText(String.valueOf(m.getVerbrennungstemperatur()));
		txtM1S2Nox.setText(String.valueOf(m.getNo2Gehalt()));
		txtM1S2Waermeerz.setText(String.valueOf(m.getWaermeerzeugertemperatur()));
		txtM1S2O2.setText(String.valueOf(m.getO2gehalt()));
		txtM1S2Abgasverl.setText(String.valueOf(m.getAbgasverluste()));
		checkS2M1Oel.setSelected(m.isOelanteilenNotOk());
		checkS2M1Abgas.setSelected(m.isAbgasverlusteNotOk());
		checkS2M1Russzahl.setSelected(m.isRusszahlNotOk());
		checkS2M1Co2.setSelected(m.isCoMgNotOk());
		checkS2M1No2.setSelected(m.isNoMgNotOk());
		}
	}

	/**
	 * Diese Methode liefert die 2 Stufe der 2 Messung in einem Messungsobjekt
	 *
	 * @throws Exception
	 */
	public void setMessung2Stufe2() throws Exception {
		m= ausgewaehlterauftrag.getMessung2stufe2();
		if(m!=null){
		 txtM2S2Russzahl.setText(String.valueOf(m.getRusszahl()));
		txtM2S2CO.setText(String.valueOf(m.getCoGehalt()));
		txtM2S2Abgastemperatur.setText(String.valueOf(m.getAbgastemperatur()));
		txtM2S2Verbrenn.setText(String.valueOf(m.getVerbrennungstemperatur()));
		txtM2S2Nox.setText(String.valueOf(m.getNo2Gehalt()));
		txtM2S2Waermeerz.setText(String.valueOf(m.getWaermeerzeugertemperatur()));
		txtM2S2O2.setText(String.valueOf(m.getO2gehalt()));
		txtM2S2Abgasverl.setText(String.valueOf(m.getAbgasverluste()));
		checkS2M2Oel.setSelected(m.isOelanteilenNotOk());
		checkS2M2Abgas.setSelected(m.isAbgasverlusteNotOk());
		checkS2M2Russzahl.setSelected(m.isRusszahlNotOk());
		checkS2M2Co2.setSelected(m.isCoMgNotOk());
		checkS2M2No2.setSelected(m.isNoMgNotOk());
		}
	}


	/**
	 * verlässt die Szene
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
