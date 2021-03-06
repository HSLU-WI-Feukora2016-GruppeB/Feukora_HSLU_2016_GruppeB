package application.view.termin;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Properties;

import javax.imageio.ImageIO;

import entitys.Auftrag;
import entitys.Benutzer;
import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Messung;
import entitys.Mitarbeiter;
import entitys.Ort;
import entitys.Waermeerzeuger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterUebersicht. Sie zeigt alle
 * Termine an.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class TerminUebersicht {

	@FXML
	private Button btnNeuerTermin, btnAktuelleTerminliste, btnAbbrechen, btnWocheAnzeigen;

	@FXML
	private TextField txtMontag, txtDienstag, txtMittwoch, txtDonnerstag, txtFreitag, T1Z1, T1Z2, T1Z3, T1Z4, T2Z1,
			T2Z2, T2Z3, T2Z4, T3Z1, T3Z2, T3Z3, T3Z4, T4Z1, T4Z2, T4Z3, T4Z4, T5Z1, T5Z2, T5Z3, T5Z4;

	@FXML
	private Pane leaf;

	@FXML
	private ComboBox<String> ddFK;

	@FXML
	private Label lblRueckmeldung, lblDruckRueckmeldung;

	@FXML
	private DatePicker startDatum, endDatum;

	private Stage TermStage = new Stage();

//	AuftragRO auftragRO;
//	MitarbeiterRO mitarbeiterRO;


	public void initialize() throws Exception {

//		List<Mitarbeiter> list = mitarbeiterRO.findAllMitarbeiter();
//		List<String> list3 = new ArrayList<String>();
//		for (Mitarbeiter i : list) {
//			String rolle = i.getRolleIntern();
//			if (rolle.equalsIgnoreCase("Kontrolleur")) {
//				list3.add(i.getName());
//			}
//		}
//		ObservableList<String> list2 = FXCollections.observableList(list3);
//		ddFK.setItems(list2);

	}

	/**
	 * Diese Methode zeigte alle Termine der ausgew�hlten Woche an.
	 *
	 * @throws Exception
	 */
	public void wocheAnzeigen() throws Exception {

		if (startDatum.getValue() == null || ddFK.getValue() == null) {
			lblRueckmeldung.setText("Bitte Datumsfelder und \n" + "Kontrolleur ausf�llen");

		} else {

//			LocalDate vonDatum = startDatum.getValue();
//			LocalDate bisDatum = vonDatum.plusDays(4);
//			endDatum.setValue(bisDatum);
//			String fk = ddFK.getValue();
//			List<Mitarbeiter> mitlist = mitarbeiterRO.findByName(fk);
//			Mitarbeiter kontrolleur = mitlist.get(0);

//			if (vonDatum.getDayOfWeek().name() != "MONDAY") {
//				lblRueckmeldung.setText("Bitte einen Montag anw�hlen!");
//
//			} else {
//				lblRueckmeldung.setText(" ");
//
//				txtMontag.setText(vonDatum.toString());
//				txtDienstag.setText(vonDatum.plusDays(1).toString());
//				txtMittwoch.setText(vonDatum.plusDays(2).toString());
//				txtDonnerstag.setText(vonDatum.plusDays(3).toString());
//				txtFreitag.setText(vonDatum.plusDays(4).toString());
//
//				int tag = vonDatum.getDayOfMonth();
//				int tag2 = vonDatum.plusDays(1).getDayOfMonth();
//				int tag3 = vonDatum.plusDays(2).getDayOfMonth();
//				int tag4 = vonDatum.plusDays(3).getDayOfMonth();
//				int tag5 = vonDatum.plusDays(4).getDayOfMonth();
//				int monat = vonDatum.getMonthValue();
//				int jahr = vonDatum.getYear();
//				GregorianCalendar gcal1 = new GregorianCalendar(jahr, monat, tag);
//				GregorianCalendar gcal2 = new GregorianCalendar(jahr, monat, tag2);
//				GregorianCalendar gcal3 = new GregorianCalendar(jahr, monat, tag3);
//				GregorianCalendar gcal4 = new GregorianCalendar(jahr, monat, tag4);
//				GregorianCalendar gcal5 = new GregorianCalendar(jahr, monat, tag5);
//
//				// Montag
//				Auftrag auftrag11 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal1, kontrolleur, 1);
//				if( auftrag11 != null){
//				T1Z1.setText(auftrag11.getLiegenschaft().getStrasse());
//				}
//				Auftrag auftrag12 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal1, kontrolleur, 2);
//				if(auftrag12 !=null){
//				T1Z2.setText(auftrag12.getLiegenschaft().toString());
//				}
//				Auftrag auftrag13 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal1, kontrolleur, 3);
//				if(auftrag13 != null){
//				T1Z3.setText(auftrag13.getLiegenschaft().toString());
//				}
//				Auftrag auftrag14 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal1, kontrolleur, 4);
//				if(auftrag14 != null){
//				T1Z4.setText(auftrag14.getLiegenschaft().toString());
//				}
//				// Dienstag
//				Auftrag auftrag21 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal2, kontrolleur, 1);
//				if(auftrag21 != null){
//				T2Z1.setText(auftrag21.getLiegenschaft().toString());
//				}
//				Auftrag auftrag22 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal2, kontrolleur, 2);
//				if(auftrag22 != null){
//				T2Z2.setText(auftrag22.getLiegenschaft().toString());
//				}
//				Auftrag auftrag23 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal2, kontrolleur, 3);
//				if(auftrag23 != null){
//				T2Z3.setText(auftrag23.getLiegenschaft().toString());
//				}
//				Auftrag auftrag24 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal2, kontrolleur, 4);
//				if(auftrag24 != null){
//				T2Z4.setText(auftrag24.getLiegenschaft().toString());
//				}
//				// Mittwoch
//				Auftrag auftrag31 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal3, kontrolleur, 1);
//				if(auftrag31 != null){
//				T3Z1.setText(auftrag31.getLiegenschaft().toString());
//				}
//				Auftrag auftrag32 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal3, kontrolleur, 2);
//				if(auftrag32 != null){
//				T3Z2.setText(auftrag32.getLiegenschaft().toString());
//				}
//				Auftrag auftrag33 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal3, kontrolleur, 3);
//				if(auftrag33 != null){
//				T3Z3.setText(auftrag33.getLiegenschaft().toString());
//				}
//				Auftrag auftrag34 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal3, kontrolleur, 4);
//				if(auftrag34 != null){
//				T3Z4.setText(auftrag34.getLiegenschaft().toString());
//				}
//
//				// Donnerstag
//				Auftrag auftrag41 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal4, kontrolleur, 1);
//				if(auftrag41 != null){
//				T4Z1.setText(auftrag41.getLiegenschaft().toString());
//				}
//				Auftrag auftrag42 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal4, kontrolleur, 2);
//				if(auftrag42 != null){
//				T4Z2.setText(auftrag42.getLiegenschaft().toString());
//				}
//				Auftrag auftrag43 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal4, kontrolleur, 3);
//				if(auftrag43 != null){
//				T4Z3.setText(auftrag43.getLiegenschaft().toString());
//				}
//				Auftrag auftrag44 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal4, kontrolleur, 4);
//				if(auftrag43 != null){
//				T4Z4.setText(auftrag44.getLiegenschaft().toString());
//				}
//
//				// Freitag
//				Auftrag auftrag51 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal5, kontrolleur, 1);
//				if(auftrag51 !=null){
//				T5Z1.setText(auftrag51.getLiegenschaft().toString());
//				}
//				Auftrag auftrag52 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal5, kontrolleur, 2);
//				if(auftrag52 != null){
//				T5Z2.setText(auftrag52.getLiegenschaft().toString());
//				}
//				Auftrag auftrag53 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal5, kontrolleur, 3);
//				if(auftrag53 != null){
//				T5Z3.setText(auftrag53.getLiegenschaft().toString());
//				}
//				Auftrag auftrag54 = auftragRO.findByDateAndMitarbeiterAndZeitslot(gcal5, kontrolleur, 4);
//				if(auftrag54 != null){
//				T5Z4.setText(auftrag54.getLiegenschaft().toString());
//				}

				// Alternative Olivia:
				// List<Auftrag> la = null;// =
				// auftragRO.findByDateAndMitarbeiter(startdatum, enddatum,
				// mitarbeiter);
				// for(Auftrag a : la){
				// int dayOfWeek = a.getTermin().get(Calendar.DAY_OF_WEEK);
				// int slot = a.getZeitSlot();
				// setTerminOnDay(dayOfWeek, slot, a);
				// }
				//
				// >>wenn du das ohne jedes einzelne feld selber setzten willst
				// musst
				// du ein 2 Dimensionales Array machen um die KAlender matrix
				// zu strukturieren dannkannst du es mit noh weniger code machen
				// public void setTerminOnDay(int dayOfWeek, int slot, Auftrag
				// auftrag){
				//
				// if(dayOfWeek ==Calendar.MONDAY){
				// switch(slot){
				// case 1: T1Z1.setText(formatAuftragHeadline(auftrag));
				// break;
				// case 2:
				// }
				// }else if(dayOfWeek == Calendar.TUESDAY){
				// switch()
			}

		}
//	}

	/**
	 * Diese Methode erstellt ein neues Terminobjekt.
	 */
	public void neuerTermin() {
		try {
			Stage TerminStage = new Stage();
			TerminStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("TerminErfassen.fxml"))));

			TerminStage.show();

			((Stage) leaf.getScene().getWindow()).close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode zeit den Rapport zum angew�hlten Termin an.
	 */
	public void rapportOeffnen(Event e) {

	}

	/**
	 * Hier kann die Terminliste in einer Wochenansicht gedruckt werden.
	 */
	public void terminDrucken() {

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage screenShot = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		try {
			ImageIO.write(screenShot, "png", new File("C:\\Users\\Alexandra Lengen\\Desktop\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblDruckRueckmeldung.setText("Screenhot auf Desktop \n" + "wurde erstellt");
	}

	/**
	 * Diese Methode f�hrt den User zur �bersicht Termin�bersicht zur�ck.
	 */
	public void abbrechen() {
		try {

			TermStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/dashboard/DashboardKontrolleur.fxml"))));

			TermStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((Stage) leaf.getScene().getWindow()).close();

	}

}
