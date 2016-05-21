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
import rmi.MessungRO;

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


    @FXML
    private Button btnNeu;

    @FXML
    private TextField txtName, txtVorname,txtPlz, txtOrt,txtTelefonNr, txtStrasseL, txtOrtL, txtPlzL, txtInfo,
    txtBrenner, txtBaujahr, txtBrennstoff, txtWaermeerzeuger, txtBaujahrW, txtBrennstoffW, txtLeistung, txtAuftragsart;


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
    private CheckBox checkboxreguliert, cbBeurteilung;

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


    public void auftragSpeichern(){
//

   // 	DIESER TEIL SEHRWAHRSCHEINLICH UNNTÖTIG!!
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
    	Messung messung2stufe1 = this.createMessung2Stufe1();
    	Messung messung2stufe2 = this.createMessung2Stufe2();
    	//nicht mehr gebraucht?
    	Messung m1s1 = null,m1s2 = null,m2s1 = null,m2s2 = null;

		try {
			m1s1 = messungRO.add(messung1stufe1);
			ausgewaehlterauftrag.setMessung1stufe1(m1s1);

			m1s2 = messungRO.add(messung1stufe2);
			ausgewaehlterauftrag.setMessung1stufe1(m1s2);

			m2s1 = messungRO.add(messung2stufe1);
			ausgewaehlterauftrag.setMessung1stufe1(m2s1);

			m2s2 = messungRO.add(messung2stufe2);
			ausgewaehlterauftrag.setMessung1stufe1(m2s2);

		} catch (Exception e) {
			lblRueckmeldung.setText("Messungen konnten nicht gespeichert werden");
		}

		if(m1s1.isBeurteilungNotOk() || m1s2.isBeurteilungNotOk() || m2s1.isBeurteilungNotOk() || m2s2.isBeurteilungNotOk()){
			// setze Check
		}else{

		}

    }




    /**
     * Diese Methode liefert die 1 Stufe der 1 Messung in einem Messungsobjekt
     *
     * @return messung1stufe1
     */
    public Messung createMessung1Stufe1(){

    	String russzahl = txtM1S1Russzahl.getText();
    	String cogehalt = txtM1S1CO.getText();
    	String abgastemperatur =txtM1S1Abgastemperatur.getText();
    	String verbrennungstemperatur = txtM1S1Verbrenn.getText();
    	String no2gehalt = txtM1S1Nox.getText();
    	String waermer = txtM1S1Waermeerz.getText();
    	String o2gehalt = txtM1S1O2.getText();
    	String abgasverluste = txtM1S1Abgasverl.getText();
    	Boolean oelanteil = checkM1S1Oel.isSelected();
    	Messung messung1stufe1 = this.messungpruefen(russzahl,cogehalt,abgastemperatur,verbrennungstemperatur,
    			no2gehalt, waermer,o2gehalt, abgasverluste,oelanteil);

    	return messung1stufe1;
    }

    /**
     * Diese Methode liefert die 2 Stufe der 1 Messung in einem Messungsobjekt
     *
     * @return messung1stufe1
     */
    public Messung createMessung1Stufe2(){

    	String russzahl = txtM1S2Russzahl.getText();
    	String cogehalt = txtM1S2CO.getText();
    	String abgastemperatur =txtM1S2Abgastemperatur.getText();
    	String verbrennungstemperatur = txtM1S2Verbrenn.getText();
    	String no2gehalt = txtM1S2Nox.getText();
    	String waermer = txtM1S2Waermeerz.getText();
    	String o2gehalt = txtM1S2O2.getText();
    	String abgasverluste = txtM1S2Abgasverl.getText();
    	Boolean oelanteil = checkM1S2Oel.isSelected();
    	Messung messung1stufe2 = this.messungpruefen(russzahl,cogehalt,abgastemperatur,verbrennungstemperatur, no2gehalt, waermer, o2gehalt, abgasverluste,oelanteil);

    	return messung1stufe2;
    }

    /**
     * Diese Methode liefert die 1 Stufe der 2 Messung in einem Messungsobjekt
     *
     * @return messung1stufe1
     */
    public Messung createMessung2Stufe1(){

    	String russzahl = txtM2S1Russzahl.getText();
    	String cogehalt = txtM2S1CO.getText();
    	String abgastemperatur =txtM2S1Abgastemperatur.getText();
    	String verbrennungstemperatur = txtM2S1Verbrenn.getText();
    	String no2gehalt = txtM2S1Nox.getText();
    	String waermer = txtM2S1Waermeerz.getText();
    	String o2gehalt = txtM2S1O2.getText();
    	String abgasverluste = txtM2S1Abgasverl.getText();
    	Boolean oelanteil = checkM2S1Oel.isSelected();
    	Messung messung2stufe1 = this.messungpruefen(russzahl,cogehalt,abgastemperatur,verbrennungstemperatur, no2gehalt, waermer, o2gehalt, abgasverluste,oelanteil);

    	return messung2stufe1;
    }



    /**
     * Diese Methode liefert die 1 Stufe der 2 Messung in einem Messungsobjekt
     *
     * @return messung1stufe1
     */
    public Messung createMessung2Stufe2(){

    	String russzahl = txtM2S2Russzahl.getText();
    	String cogehalt = txtM2S2CO.getText();
    	String abgastemperatur =txtM2S2Abgastemperatur.getText();
    	String verbrennungstemperatur = txtM2S2Verbrenn.getText();
    	String no2gehalt = txtM2S2Nox.getText();
    	String waermer = txtM2S2Waermeerz.getText();
    	String o2gehalt = txtM2S2O2.getText();
    	String abgasverluste = txtM2S2Abgasverl.getText();
    	Boolean oelanteil = checkM2S2Oel.isSelected();
    	Messung messung2stufe2 = this.messungpruefen(russzahl,cogehalt,abgastemperatur,verbrennungstemperatur, no2gehalt, waermer, o2gehalt, abgasverluste,oelanteil);

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
     * @return messung
     */
  private Messung messungpruefen(String stringrusszahl, String stringcogehalt, String stringabgastemperatur, String stringverbrennungstemparatur, String stringno2gehalt, String stringwaermer, String stringo2gehalt, String stringabgasverluste
		  ,boolean oelanteil){

	  if(stringrusszahl.isEmpty() || stringcogehalt.isEmpty()||stringabgastemperatur.isEmpty() || stringverbrennungstemparatur.isEmpty()
  			|| stringno2gehalt.isEmpty() || stringwaermer.isEmpty() || stringo2gehalt.isEmpty() || stringabgasverluste.isEmpty()){
  		lblRueckmeldung.setText("Messung 1 Stufe 1 nicht alle Felder ausgefüllt!");
  		return null;
  	}else{
  		//Alles parsen
  		int russzahl = Integer.parseInt(stringrusszahl);
  		int coGehalt = Integer.parseInt(stringcogehalt);
  		int abgastemperatur = Integer.parseInt(stringabgastemperatur);
  		int verbrennungstemperatur = Integer.parseInt(stringverbrennungstemparatur);
  		int no2gehalt = Integer.parseInt(stringno2gehalt);
  		int waermeerzeugertemperatur = Integer.parseInt(stringwaermer);
  		int o2gehalt = Integer.parseInt(stringo2gehalt);
  		int abgasverluste = Integer.parseInt(stringabgasverluste);


  		  //heutiges Datum holen
  	 		GregorianCalendar messDatum =new GregorianCalendar();
  			messDatum.getInstance().getTime();


  		Messung messung = new Messung(messDatum, russzahl, coGehalt, oelanteil, no2gehalt,
          	    abgastemperatur, waermeerzeugertemperatur, verbrennungstemperatur, o2gehalt, abgasverluste);
  		return messung;
  	}

  }



    public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}




}
