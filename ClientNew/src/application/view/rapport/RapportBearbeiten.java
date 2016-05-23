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
import rmi.interfaces.AuftragRO;
import rmi.interfaces.MessungRO;

public class RapportBearbeiten {

	static Auftrag ausgewaehlterauftrag;
	MessungRO messungRO;
	AuftragRO auftragRO;


    @FXML
    private Button btnNeu;

    @FXML
    private TextField txtName, txtVorname,txtPlz, txtOrt,txtTelefonNr, txtStrasseL, txtOrtL, txtPlzL, txtInfo,
    txtBrenner, txtBaujahr, txtBrennstoff, txtWaermeerzeuger, txtBaujahrW, txtBrennstoffW, txtLeistung, txtAuftragsart;


    //----------------Messung1--------------------
    @FXML
    private TextField txtM1S1Russzahl, txtM1S1CO ,txtM1S1Abgastemperatur  ,txtM1S1Verbrenn, txtM1S1Nox, txtM1S1Waermeerz, txtM1S1O2, txtM1S1Abgasverl,
    txtM1S2Russzahl, txtM1S2CO ,txtM1S2Abgastemperatur  ,txtM1S2Verbrenn, txtM1S2Nox, txtM1S2Waermeerz, txtM1S2O2, txtM1S2Abgasverl;

    @FXML
    private CheckBox checkM1S1Oel, checkM1S2Oel;

    //----------------Messung2---------------------
    @FXML
    private TextField txtM2S1Russzahl, txtM2S1CO ,txtM2S1Abgastemperatur  ,txtM2S1Verbrenn, txtM2S1Nox, txtM2S1Waermeerz, txtM2S1O2, txtM2S1Abgasverl,
    txtM2S2Russzahl, txtM2S2CO ,txtM2S2Abgastemperatur  ,txtM2S2Verbrenn, txtM2S2Nox, txtM2S2Waermeerz, txtM2S2O2, txtM2S2Abgasverl;

    @FXML
    private CheckBox checkM2S1Oel, checkM2S2Oel;

    @FXML
    private Label lblRueckmeldung;

    //Deklerationen für die bekommeAuftrag() methode
    private static String kundenvorname, kundenname, kundenort, kundenplz,kundentelnr,
    liegenschaftsstrasse, Liegenschaftsort,Liegenschaftsplz,Liegenschaftsinfo,
    brennertyp, brennerjahr, brennerstoff, waermetyp, waermejahr, waermestoff, auftragsart, feuerungsleistung;

    //Grenzwertcheckboxen
    @FXML
    private CheckBox cb30Tage, cbEinregulierung, cbBeurteilung, cbAbgasverluste, cbRusszahl, cbOelanteil, cbCo2, cbNo2;

    @FXML
    private TextArea taBemerkung;

    @FXML
    private Stage leaf;

	 public void initialize(){

	    	//Kundenfelder setzen
	    	txtName.setText(kundenname);
	    	txtVorname.setText(kundenvorname);
	    	txtOrt.setText(kundenort);
	    	txtPlz.setText(kundenplz);
	    	txtTelefonNr.setText(kundentelnr);

	    	//Liegenschaftsfelder setzen
	    	txtStrasseL.setText(liegenschaftsstrasse);;
	    	txtOrtL.setText(Liegenschaftsort);
	    	txtPlzL.setText(Liegenschaftsplz);
	    	txtInfo.setText(Liegenschaftsinfo);

	    	//Brennerfelder setzen
	    	txtBrenner.setText(brennertyp);
	    	txtBaujahr.setText(brennerjahr);
	    	txtBrennstoff.setText(brennerstoff);

	    	//Wärmeerzeugerfelder setzen
	    	txtWaermeerzeuger.setText(waermetyp);
	    	txtBaujahrW.setText(waermejahr);
	    	txtBrennstoffW.setText(waermestoff);

	    	//Kontrollarten setzen
	    	txtAuftragsart.setText(auftragsart);
	    	txtLeistung.setText(feuerungsleistung);


	    	//Bewertungsfelder anzeigen
	    	ArrayList<Messung> messungsliste = new ArrayList<Messung>();
			messungsliste.add(ausgewaehlterauftrag.getMessung1stufe1());
			messungsliste.add(ausgewaehlterauftrag.getMessung2stufe1());
			messungsliste.add(ausgewaehlterauftrag.getMessung1stufe2());
			messungsliste.add(ausgewaehlterauftrag.getMessung2stufe2());

			for(Messung m: messungsliste){
				boolean notokey = m.isBeurteilungNotOk();
				if(notokey){
					cbBeurteilung.setSelected(true);
					for(Messung m2: messungsliste){
						notokey = m2.isAbgasverlusteNotOk();
						if(notokey){
							cbAbgasverluste.setSelected(true);
						}
						boolean notokey2 = m2.isCoMgNotOk();
						if(notokey2){
							cbCo2.setSelected(true);
						}
						boolean notokey3 = m2.isNoMgNotOk();
						if(notokey3){
							cbNo2.setSelected(true);
						}
						boolean notokey4 = m2.isOelanteilenNotOk();
						if(notokey4){
							cbOelanteil.setSelected(true);
						}
						boolean notokey5 = m2.isRusszahlNotOk();
						if(notokey5){
							cbRusszahl.setSelected(true);
						}
					}
				}
			}

			//Manuell eingetragene Felder des Kontrolleurs anzeigen
			cb30Tage.setSelected(ausgewaehlterauftrag.isEinregulierungInnert30());
			cbEinregulierung.setSelected(ausgewaehlterauftrag.isEinregulierungNichtMoeglich());

	    }




	    public static void bekommeAuftrag(Auftrag auftrag){

	    	ausgewaehlterauftrag = auftrag;

	        //Kundenobjekt zerlegen
	        kundenvorname = auftrag.getKunde().getVorname();
	        kundenname = auftrag.getKunde().getNachname();
	        kundenort = auftrag.getKunde().getOrt().getOrt();
	        kundenplz = String.valueOf(auftrag.getKunde().getOrt().getPlz());;
	        kundentelnr = auftrag.getKunde().getTel();

	        Liegenschaft liegenschaft = auftrag.getLiegenschaft();
	        //Liegenschaftsobjekt zerlegen
	        liegenschaftsstrasse = liegenschaft.getStrasse();
	        Liegenschaftsort = liegenschaft.getOrt().getOrt();
	        Liegenschaftsplz = String.valueOf(liegenschaft.getOrt().getPlz());
	        Liegenschaftsinfo = liegenschaft.getInfoVorOrt();

	        Feuerungsanlage feuerungs = liegenschaft.getFeuerungsanlage();
	        //Brenner zerlegen
	        brennertyp = feuerungs.getBrenner().getBrennerTyp();
	        brennerjahr = String.valueOf(feuerungs.getBrenner().getBaujahr());
	        brennerstoff = feuerungs.getBrenner().getBrennerArtString();

	        //Wärmeerzeuger zerlegen
	        waermetyp = feuerungs.getWaermeerzeuger().getWaermeerzeugerTyp();
	        waermejahr = String.valueOf(feuerungs.getWaermeerzeuger().getBaujahr());
	        waermestoff = feuerungs.getWaermeerzeuger().getBrennstoffString();

	        //Kontrollarten
	        auftragsart =auftrag.getTerminArt();
	        feuerungsleistung = String.valueOf(feuerungs.getFeuerungswaermeleistung());
	    }

	    /**
	     * verlässt die Szene
	     */
	      public void abbrechen() {
	  		((Stage) leaf.getScene().getWindow()).close();
	  	}

}
