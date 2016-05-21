package application.view.rapport;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse RapportErfassen. Hier werden neue
 * Feruengsrapporte erstellt.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 3.0
 * @since 1.0
 */

public class RapportErfassen {

    @FXML
    private Button btnNeu;

    @FXML
    private TextField txtName, txtVorname,txtPlz, txtOrt,txtTelefonNr, txtStrasseL, txtOrtL, txtPlzL, txtInfo,
    txtBrenner, txtBaujahr, txtBrennstoff, txtWaermeerzeuger, txtBaujahrW, txtBrennstoffW, txtLeistung;

    @FXML
    private ChoiceBox<String> cbKontrollart;

    //Messung1--------------------
    @FXML
    private TextField txtM1S1Russzahl, txtM1S1CO ,txtM1S1Abgastemperatur  ,txtM1S1Verbrenn, txtM1S1Nox, txtM1S1Waermeerz, txtM1S1O2, txtM1S1Abgasverl,
    txtM1S2Russzahl, txtM1S2CO ,txtM1S2Abgastemperatur  ,txtM1S2Verbrenn, txtM1S2Nox, txtM1S2Waermeerz, txtM1S2O2, txtM1S2Abgasverl;

    @FXML
    private CheckBox checkM1S1Oel, checkM1S2Oel;

    //Messung2---------------------
    @FXML
    private TextField txtM2S1Russzahl, txtM2S1CO ,txtM2S1Abgastemperatur  ,txtM2S1Verbrenn, txtM2S1Nox, txtM2S1Waermeerz, txtM2S1O2, txtM2S1Abgasverl,
    txtM2S2Russzahl, txtM2S2CO ,txtM2S2Abgastemperatur  ,txtM2S2Verbrenn, txtM2S2Nox, txtM2S2Waermeerz, txtM2S2O2, txtM2S2Abgasverl;

    @FXML
    private CheckBox checkM2S1Oel, checkM2S2Oel;

    @FXML
    private Label lblRueckmeldung;

    private static String kundenvorname, kundenname, kundenort, kundenplz,kundentelnr,
    liegenschaftsstrasse, Liegenschaftsort,Liegenschaftsplz,Liegenschaftsinfo,
    brennertyp, brennerjahr, brennerstoff, waermetyp, waermejahr, waermestoff, auftragsart, feuerungsleistung;

    @FXML
    private CheckBox checkboxreguliert;



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
    	cbKontrollart.setText(auftragsart);
    	txtLeistung.setText(feuerungsleistug);


    }




    public static void bekommeAuftrag(Auftrag auftrag){


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
        feuerungsleistung = feuerungs.getFeuerungswaermeleistung();
    }


    public void auftragSpeichern(){
//
//    	//Kundenfelder holen
//    	String name = txtName.getText();
//    	String vorname = txtVorname.getText();
//    	String plz = txtPlz.getText();
//    	String ort = txtOrt.getText();
//    	String telnr = txtTelefonNr.getText();
//
//    	//Liegenschaftsfelder holen
//    	String strassel = txtStrasseL.getText();
//    	String ortl = txtOrtL.getText();
//    	String plzl = txtPlzL.getText();
//    	String info = txtInfo.getText();
//        String brenner = txtBrenner.getText();
//        String baujahr = txtBaujahr.getText();
//        String brennstoff = txtBrennstoff.getText();
//        String waermeerzeuger = txtWaermeerzeuger.getText();
//        String baujahrw = txtBaujahrW.getText();
//        String brennstoffw = txtBrennstoffW.getText();
//
//        //Kontrollarten holen
//        String leistung = txtLeistung.getText();
//    	String kontrollart = cbKontrollart.getValue();

    	Messung messung1stufe1 = this.createMessung1Stufe1();
    	Messung messung1stufe2 = this.createMessung1Stufe2();

    	Auftrag newauftrag = new Auftrag();

    }


    public Messung createMessung1Stufe1(){



    	String stringrusszahl = txtM1S1Russzahl.getText();
    	String stringcogehalt = txtM1S1CO.getText();
    	String stringabgastemperatur =txtM1S1Abgastemperatur.getText();
    	String stringverbrennungstemparatur = txtM1S1Verbrenn.getText();
    	String stringno2gehalt = txtM1S1Nox.getText();
    	String stringwaermer = txtM1S1Waermeerz.getText();
    	String stringo2gehalt = txtM1S1O2.getText();
    	String stringabgasverluste = txtM1S1Abgasverl.getText();
    	Boolean checkoel = checkM1S1Oel.isSelected();

    	if(stringrusszahl.isEmpty() || stringcogehalt.isEmpty()||stringabgastemperatur.isEmpty() || stringverbrennungstemparatur.isEmpty()
    			|| stringno2gehalt.isEmpty() || stringwaermer.isEmpty() || stringo2gehalt.isEmpty() || stringabgasverluste.isEmpty()){
    		lblRueckmeldung.setText("Messung 1 Stufe 1 nicht alle Felder ausgefüllt!");
    	}else{
    		//Alles parsen

    		int russzahl = Integer.parseInt(stringrusszahl);
    		int coGehalt = Integer.parseInt(stringcogehalt);
    		int abgastemparatur = Integer.parseInt(stringabgastemperatur);
    		int verbrennungstemparatur = Integer.parseInt(stringverbrennungstemparatur);
    		int no2gehalt = Integer.parseInt(stringno2gehalt);
    		int waermeerzeugertemparatur = Integer.parseInt(stringwaermer);
    		int o2gehalt = Integer.parseInt(stringo2gehalt);
    		int abgasverluste = Integer.parseInt(stringabgasverluste);

    		//heutiges Datum holen
    		Date now = new LocalDate().now()
    		GregorianCalendar messDatum = new GregorianCalendar().gett



    	 Messung messung1stufe1 = new Messung(messDatum, russzahl, coGehalt, oelanteil, no2gehalt,
    	    abgastemperatur, waermeerzeugertemperatur, verbrennungstemperatur, o2gehalt, abgasverluste);


    	}





        return messung1stufe1;
    }

    public Messung createMessung1Stufe2(){
    	String stringrusszahl = txtM1S2Russzahl.getText();
        String stringcogehalt = txtM1S2CO.getText();
        String stringabgastemparatur = txtM1S2Abgastemperatur.getText();
        String stringverbrennungsgefahr =  txtM1S2Verbrenn.getText();
        String stringno2gehalt = txtM1S2Nox.getText();
        String stringwaermer = txtM1S2Waermeerz
        txtM1S2O2
        txtM1S2Abgasverl


    }



    public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}




}
