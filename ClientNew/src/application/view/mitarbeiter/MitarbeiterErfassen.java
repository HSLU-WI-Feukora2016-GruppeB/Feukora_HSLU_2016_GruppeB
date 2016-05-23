package application.view.mitarbeiter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import rmi.AuftragRO;
import rmi.BenutzerRO;
import rmi.BrennerRO;
import rmi.FeuerungsanlageRO;
import rmi.KontaktRO;
import rmi.LiegenschaftRO;
import rmi.MessungRO;
import rmi.MitarbeiterRO;
import rmi.OrtRO;
import rmi.WaermeerzeugerRO;
import rmi.rmiserver.RMIServer;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterErfassen. Hier können neue
 * Mitarbeiter erfasst und alte Bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterErfassen {

	MitarbeiterRO MitarbeiterRO;
	OrtRO OrtRO;

	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ, txtLohn, txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private DatePicker startDatum, endDatum;
	@FXML
	private Pane leaf;

	@FXML
	private ComboBox<String> cbRolle;

	private AuftragRO auftragManager;
	private BenutzerRO benutzerManager;
	private BrennerRO brennerManager;
	private FeuerungsanlageRO feuerungsanlageManager;
	private KontaktRO kontaktManager;
	private LiegenschaftRO liegenschaftManager;
	private MessungRO messungManager;
	private MitarbeiterRO mitarbeiterManager;
	private OrtRO ortManager;
	private WaermeerzeugerRO waermeerzeugerManager;

	public void initialize() throws Exception {
		/*
		 * SecurityManager zusätzlich falls man will
		 * System.setProperty("java.security.policy", "MitarbeiterRO.policy");
		 *
		 * System.setSecurityManager(new SecurityManager());
		 */
		String AuftragROName = "Auftrag";
		String BenutzerROName = "Benutzer";
		String BrennerROName = "Brenner";
		String FeuerungsanlageROName = "Feuerungsanlage";
		String KontaktROName = "Kontakt";
		String MessungsROName = "Messung";
		String MitarbeiterROName = "Mitarbeiter";
		String LiegenschaftROName = "Liegenschaft";
		String OrtROName = "Ort";
		String WaermeerzeugerROName = "Waermerzeuger";

		try {

			// Properties Objekt erstellen
			Properties webserverProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = MitarbeiterErfassen.class.getClassLoader();

			// Properties laden
			try {
				webserverProperties.load(cLoader.getResourceAsStream("webserver.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Port RMI auslesen
			String stringPort = webserverProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = webserverProperties.getProperty("rmiIp");

			// URLs definieren
			String urlAuftragRO = "rmi://" + hostIp + ":" + rmiPort + "/" + AuftragROName;
			String urlBenutzerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + BenutzerROName;
			String urlBrennerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + BrennerROName;
			String urlFeuerungsanlageRO = "rmi://" + hostIp + ":" + rmiPort + "/" + FeuerungsanlageROName;
			String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/" + KontaktROName;
			String urlMessungRO = "rmi://" + hostIp + ":" + rmiPort + "/" + MessungsROName;
			String urlMitarbeiterRO = "rmi://" + hostIp + ":" + rmiPort + "/" + MitarbeiterROName;
			String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/" + LiegenschaftROName;
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/" + OrtROName;
			String urlWaermeerzeugerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + WaermeerzeugerROName;

			/* Lookup */
			auftragManager = (AuftragRO) Naming.lookup(urlAuftragRO);
			benutzerManager = (BenutzerRO) Naming.lookup(urlBenutzerRO);
			brennerManager = (BrennerRO) Naming.lookup(urlBrennerRO);
			feuerungsanlageManager = (FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
			kontaktManager = (KontaktRO) Naming.lookup(urlKontaktRO);
			messungManager = (MessungRO) Naming.lookup(urlMessungRO);
			mitarbeiterManager = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);
			liegenschaftManager = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
			ortManager = (OrtRO) Naming.lookup(urlOrtRO);
			waermeerzeugerManager = (WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}

		List<String> list = new ArrayList<String>();
		list.add("Administrator");
		list.add("Sachbearbeiter");
		list.add("Kontrolleur");

		ObservableList<String> list2 = FXCollections.observableList(list);
		cbRolle.setItems(list2);

	}

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void mitarbeiterSpeichern() {

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
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || plz.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty() || enddatum.toString().isEmpty()
				|| startdatum.toString().isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

			// Die Rolle wieder in einen int verwandel
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

			// Das arbeitet seit: in GregorianCalendar Format umwandeln
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
			int lohnint = 0, plzint = 0;

			try {
				lohnint = Integer.parseInt(lohn);
				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}

			System.out.println("vor addmitarbeiter");
			try {
				Mitarbeiter newmitarbeiter = createMitarbeiter(name, vorname, strasse, ort, plzint, rolleint, lohnint,
						email, telefonnr, gcalstart, gcalend);
				MitarbeiterRO.add(newmitarbeiter);
			} catch (Exception e) {
				lblRueckmeldung.setText("Mitarbeiter konnte nicht gespeichert werden");
			}
			System.out.println("nach addmitarbeiter");

		}
	}

	/**
	 * Diese Methode führt den User zur Übersicht MitarbeierÜbersicht zurück.
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

	/**
	 * Diese Methode erstellt ein neues Mitarbeiterobjekt.
	 *
	 * @param name
	 * @param vorname
	 * @param strasse
	 * @param ort
	 * @param plz
	 * @param rolle
	 * @param lohn
	 * @param email
	 * @param telefonnr
	 * @param gcalstart
	 * @param gcalend
	 *
	 * @return Mitarbeiter
	 * @throws Exception
	 */
	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort, int plz, int rolle,
			int lohn, String email, String telefonnr, GregorianCalendar gcalstart, GregorianCalendar gcalend)
			throws Exception {

		Mitarbeiter mitarbeiter = new Mitarbeiter();
		List<Ort> ortsliste = new ArrayList<Ort>();

		mitarbeiter.setName(name);
		mitarbeiter.setVorname(vorname);
		mitarbeiter.setRolleIntern(rolle);
		mitarbeiter.setStrasse(strasse);
		mitarbeiter.setLohn(lohn);
		mitarbeiter.setEmail(email);
		mitarbeiter.setTel(telefonnr);
		mitarbeiter.setArbeitetSeit(gcalstart);
		mitarbeiter.setArbeitetBis(gcalend);

		// zu erst auf liste speichern damit man nachher das zweite der Liste
		// prüfen kann falls nicht übereinstimmt
		ortsliste = OrtRO.findByOrtPlz(plz);

		// durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die
		// gleiche ist.
		for (Ort o : ortsliste) {
			if (ort.equals(o.getOrt())) {
				Ort o2 = OrtRO.add(o);
				mitarbeiter.setOrt(o2);
			}
		}

		return mitarbeiter;
	}

}
