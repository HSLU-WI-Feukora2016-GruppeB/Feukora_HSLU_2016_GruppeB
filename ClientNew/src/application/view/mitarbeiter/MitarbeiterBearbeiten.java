package application.view.mitarbeiter;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterErfassen. Hier können neue
 * Mitarbeiter erfasst und alte Bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterBearbeiten {

	OrtRO ortRO;
	MitarbeiterRO  mitarbeiterRO;


	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ,txtLohn, txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private DatePicker startDatum, endDatum;

	@FXML
	private Pane leaf;

	@FXML
	private ComboBox<String> cbRolle;


	static String name;
	static String vorname;
	static String strasse;
	static String ort;
	static String rolle;
	static String email;
	static String telefon;
	static String lohn2;
	static String plz;
	static GregorianCalendar startdatum,enddatum;



	static Mitarbeiter maupdate;

	public void initialize() throws Exception{

/*---------------RMI Verbindung---------------*/

		String OrtRO = "Ort";
		String MitarbeiterROName = "Mitarbeiter";

		try {

			// Properties Objekt erstellen
			Properties rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = MitarbeiterBearbeiten.class.getClassLoader();

			// Properties laden

				rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));


			// Port RMI auslesen
			String stringPort = rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/" + OrtRO;
			String urlMitarbeiterRO = "rmi://" + hostIp + ":" + rmiPort + "/" + MitarbeiterROName;

			/* Lookup */
			mitarbeiterRO = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);
			ortRO = (OrtRO) Naming.lookup(urlOrtRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}

/*----------------------------------------------*/


		txtName.setText(name);
		txtVorname.setText(vorname);
		txtStrasse.setText(strasse);
		txtOrt.setText(ort);
		txtPLZ.setText(plz);

		//Rolle ins die Combobox einfügen
		List<String> list = new ArrayList<String>();
		list.add("Administrator");
		list.add("Sachbearbeiter");
		list.add("Kontrolleur");

		ObservableList<String> list2 = FXCollections.observableList(list);
		cbRolle.setItems(list2);
		cbRolle.getSelectionModel().select(rolle);


		txtLohn.setText(lohn2);
		txtEmail.setText(email);
		txtTelefonNr.setText(telefon);
		startDatum.setValue(gregToLocal(startdatum));
		endDatum.setValue(gregToLocal(enddatum));

	}

	public static void bekommeMitarbeiter(Mitarbeiter mabearbeitet) throws Exception{
		maupdate = mabearbeitet;

		name = mabearbeitet.getName();
		vorname = mabearbeitet.getVorname();
		strasse = mabearbeitet.getStrasse();
		ort = mabearbeitet.getOrt().getOrt();
		plz = String.valueOf(mabearbeitet.getOrt().getPlz());
		rolle = mabearbeitet.getRolleIntern();
		Integer lohn = (Integer) mabearbeitet.getLohn();
		lohn2 = lohn.toString();
		email = mabearbeitet.getEmail();
		telefon = mabearbeitet.getTel().toString();

		startdatum = mabearbeitet.getArbeitetSeit();

		enddatum = mabearbeitet.getArbeitetBis();

	}

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void mitarbeiterUpdate() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPLZ.getText();
		String rolle = cbRolle.getValue();
		String lohn = txtLohn.getText();
		String email = txtEmail.getText();
		String telefonnr = txtTelefonNr.getText();
		LocalDate enddatum = endDatum.getValue();
		LocalDate startdatum = startDatum.getValue();


		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || ort.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty() ||
				enddatum.toString().isEmpty() || startdatum.toString().isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

			//Die Rolle wieder in einen int verwandel
			int rolleint = 0;
			switch (rolle) {
			case "Kontrolleur":
				rolleint = 1;
				break;
			case "Sachbearbeiter":
				rolleint = 2;
				break;
			case "Administrator":
				rolleint = 3;
				break;
			}


			//Das arbeitet seit: in GregorianCalendar Format umwandeln
			int starttag = startdatum.getDayOfMonth();
			int startmonat = startdatum.getMonthValue();
			int startjahr = startdatum.getYear();
			GregorianCalendar gcalstart = new GregorianCalendar(startjahr, startmonat, starttag);


			// Das arbeitet bis: in GregorianCalendar umwandeln
			int endtag = enddatum.getDayOfMonth();
			int endmonat = enddatum.getMonthValue();
			int endjahr = enddatum.getYear();
			GregorianCalendar gcalend = new GregorianCalendar(endjahr, endmonat, endtag);
			// Parsen erst nach der Überprüfung da sonst die isEmpty() Methode
			// nicht vorhanden ist


			// Neue Variabeln für das Parsen
			int lohnint = 0, plzint =0;

			try {
				rolleint = Integer.parseInt(rolle);
				lohnint = Integer.parseInt(lohn);
				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}



			try {
				Mitarbeiter updatemitarbeiter = createMitarbeiter(name, vorname,strasse, ort, plzint,
						rolleint,lohnint, email,telefonnr,gcalstart,gcalend);
				//braucht es dieses this? überspeichere ich wirklich das alte Objekt?
				//evtl lösung könnte sein das alte einfach löschen und ein neue erstellen
				this.mitarbeiterRO.update(updatemitarbeiter);
			} catch (Exception e) {
				lblRueckmeldung.setText("Das überscheiben hat nicht funktioniert");
				e.printStackTrace();
			}

		}
	}





	/**
	 * Diese Methode führt den User zur Übersicht Rapportsübersicht zurück.
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

	/**
	 * Diese Methode erstellt ein neues Mitarbeiterobjekt.
	 *
	 * @param name
	 *            Name des Mitarbeiters
	 * @param vorname
	 *            Vorname des Mitarbeiters
	 * @param strasse
	 *            Strasse des Mitarbeiters
	 * @param plz
	 *            Plz des Mitarbeiters
	 * @param ort
	 *            Ort des Mitarbeiters
	 * @param rolle
	 *            Rolle des Mitarbeiters (Backoffice, Admin oder
	 *            Feuerungskontrolleur)
	 * @param lohn
	 *            Lohn des Mitarbeiters
	 * @param email
	 *            Email-Adresse des Kontaktes
	 * @param telnr
	 *            Telefonnummer des Kontaktes
	 *
	 * @return Ein neues Mitarbeiterobjekt
	 * @throws Exception
	 */
	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort, int plz,
			int rolle, int lohn, String email, String telefonnr, GregorianCalendar gcalstart, GregorianCalendar gcalend) throws Exception{
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		List<Ort> ortsliste = new ArrayList<Ort>();

		maupdate.setName(name);
		maupdate.setVorname(vorname);
		maupdate.setRolleIntern(rolle);
		maupdate.setStrasse(strasse);
		maupdate.setLohn(lohn);
		maupdate.setEmail(email);
		maupdate.setTel(telefonnr);
		maupdate.setArbeitetSeit(gcalstart);
		maupdate.setArbeitetBis(gcalend);

			//zu erst auf liste speichern damit man nachher das zweite der Liste prüfen kann falls nicht übereinstimmt
		 ortsliste = ortRO.findByOrtPlz(plz);

		//durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die gleiche ist.
			for(Ort o: ortsliste){
				if(ort.equals(o.getOrt())){
					Ort o2 = ortRO.add(o);
					maupdate.setOrt(o2);
					}
			}

		return maupdate;
	}





	/**
	 * Diese Funkion wandelt das startdatum bekommeMitarbeiter() um
	 * und wird dann wieder bei der initialize() aufgerufen
	 *
	 * @param startdatum
	 * @return LocalDate
	 */
	private LocalDate gregToLocal(GregorianCalendar changecal){

		Date zwischendate = changecal.getTime();

		LocalDate ldstartDatum = zwischendate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ldstartDatum;

	}

}
