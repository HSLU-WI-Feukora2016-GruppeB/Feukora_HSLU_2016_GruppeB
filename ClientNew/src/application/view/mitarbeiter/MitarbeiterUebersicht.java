package application.view.mitarbeiter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
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
 * Dies ist die Dokumentation der Klasse MitarbeiterÜbersicht. Sie zeigt alle
 * Mitarbeiter an.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterUebersicht {

	@FXML
	private Button btnNeu, btnBearbeiten, btnSchliessen, btnSuchen;

	@FXML
	private TextField txtName, txtVorname;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private BorderPane leaf;

	@FXML
	private TableView tabelle;

	@FXML
	private TableColumn tblName, tblVorname, tblStrasse, tblEMail, tblTelefon, tblPosition, tblOrt;

	MitarbeiterRO MitarbeiterRO;
	OrtRO OrtRO;

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

	public static Mitarbeiter mastatic;

	private void initialize() throws Exception {
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

		List<Benutzer> lBenutzer = new ArrayList<>();
		List<Mitarbeiter> lMitarbeiter = new ArrayList<>();
		List<Ort> lOrt = new ArrayList<>();

		// 6 Benutzer erstellen
		lBenutzer.add(new Benutzer("ale", "123"));
		lBenutzer.add(new Benutzer("lra", "456"));
		lBenutzer.add(new Benutzer("pst", "789"));
		lBenutzer.add(new Benutzer("dst", "101"));
		lBenutzer.add(new Benutzer("mpe", "111"));
		lBenutzer.add(new Benutzer("owa", "121"));

		// 5 Orte
		lOrt.add(new Ort(8000, "Zürich"));
		lOrt.add(new Ort(6000, "Luzern"));
		lOrt.add(new Ort(5000, "Aarau"));
		lOrt.add(new Ort(3000, "Bern"));
		lOrt.add(new Ort(1000, "Genf"));
		lOrt.add(new Ort(2000, "Neuchâtel"));

		// 6 Mitarbeiter erstellen
		lMitarbeiter.add(new Mitarbeiter("Olivia", "Wassmer", "Musterstrasse 1", lOrt.get(3), "1234567678",
				"o.w@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 06, 6),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Matthias", "Perrollaz", "Musterstrasse 2", lOrt.get(4), "1234557678",
				"m.p@feukora.ch", 2, lBenutzer.get(4), 5000, new GregorianCalendar(2016, 05, 1),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Dominik", "Stirnimann", "Musterstrasse 3", lOrt.get(3), "1234367678",
				"d.s@feukora.ch", 1, lBenutzer.get(3), 5000, new GregorianCalendar(2016, 9, 15),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Pascal", "Steiner", "Musterstrasse 4", lOrt.get(2), "1234567678",
				"d.st@feukora.ch", 1, lBenutzer.get(2), 5000, new GregorianCalendar(2016, 05, 1),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Luca", "Raneri", "Musterstrasse 5", lOrt.get(1), "1234567178",
				"l.r@feukora.ch", 1, lBenutzer.get(1), 5000, new GregorianCalendar(2016, 05, 1),
				new GregorianCalendar(2018, 8, 11)));
		lMitarbeiter.add(new Mitarbeiter("Alexandra", "Lengen", "Musterstrasse 1", lOrt.get(0), "1234563678",
				"a.l@feukora.ch", 1, lBenutzer.get(5), 5000, new GregorianCalendar(2016, 05, 1),
				new GregorianCalendar(2018, 8, 11)));

		List<Mitarbeiter> list = lMitarbeiter;

		try {
			// List<Mitarbeiter> list = MitarbeiterRO.findAllMitarbeiter();
			ObservableList<Mitarbeiter> list2 = FXCollections.observableList(list);
			tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
			tblVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
			tblStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
			tblOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
			tblEMail.setCellValueFactory(new PropertyValueFactory<>("email"));
			tblPosition.setCellValueFactory(new PropertyValueFactory<>("rolleIntern"));
			tblTelefon.setCellValueFactory(new PropertyValueFactory<>("tel"));

			tabelle.setItems(list2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void MitarbeiterSuchen() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();

		if (name.isEmpty() || vorname.isEmpty()) {

			lblRueckmeldung.setText("Beide Felder müssen ausgefüllt werden!");

		} else {

			try {
				List<Mitarbeiter> list = MitarbeiterRO.findByNameVorname(name, vorname);
				ObservableList<Mitarbeiter> list2 = FXCollections.observableList(list);
				tabelle.setItems(list2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Erfassung neuer Mitarbeiter.
	 */
	public void neuerMitarbeiter() {

		try {
			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterErfassen.fxml"))));

			MitarbeiterStage.show();
			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode öffnet die Übersicht zur Bearbeitung von Mitarbeiter.
	 */
	public void bearbeitenMitarbeiter() {
		try {
			Mitarbeiter indSelected = (Mitarbeiter) tabelle.getSelectionModel().getSelectedItem();
			MitarbeiterBearbeiten.bekommeMitarbeiter(indSelected);

			Stage MitarbeiterStage = new Stage();

			MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MitarbeiterBearbeiten.fxml"))));

			MitarbeiterStage.show();

			((Stage) leaf.getScene().getWindow()).close();
		} catch (Exception e) {
			lblRueckmeldung.setText("Bitte Mitarbeiter auswählen");
			e.printStackTrace();
		}

	}

	/**
	 * Diese Methode führt den User zum Dashboard zurück
	 */
	public void abbrechen() {
		((Stage) leaf.getScene().getWindow()).close();
	}

}
