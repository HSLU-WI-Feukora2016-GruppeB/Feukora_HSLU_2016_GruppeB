package application.view.kontakt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import application.view.mitarbeiter.MitarbeiterErfassen;
import entitys.Kontakt;
import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;

public class KontaktBearbeiten {

	OrtRO ortRO;
	KontaktRO  kontaktRO;


	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ,txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;



	static String name;
	static String vorname;
	static String strasse;
	static String ort;
	static String rolle;
	static String email;
	static String telefon;
	static String lohn2;
	static String plz;



	static Kontakt kontaktupdate;

	public void initialize() throws Exception{


		/*---------------RMI Verbindung---------------*/


		String KontaktROName = "Kontakt";

		try {

			// Properties Objekt erstellen
			Properties rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = KontaktBearbeiten.class.getClassLoader();

			// Properties laden
			try {
				rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Port RMI auslesen
			String stringPort = rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren

			String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/" + KontaktROName;

			/* Lookup */
			kontaktRO = (KontaktRO) Naming.lookup(urlKontaktRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}

/*----------------------------------------------*/


		txtName.setText(name);
		txtVorname.setText(vorname);
		txtStrasse.setText(strasse);
		txtOrt.setText(ort);
		txtPLZ.setText(plz);
		txtEmail.setText(email);
		txtTelefonNr.setText(telefon);

	}

	public static void bekommeKontakt(Kontakt kontaktbearbeitet) throws Exception{
		kontaktupdate = kontaktbearbeitet;

		name = kontaktbearbeitet.getNachname();
		vorname = kontaktbearbeitet.getVorname();
		strasse = kontaktbearbeitet.getStrasse();
		ort = kontaktbearbeitet.getOrt().getOrt();
		plz = String.valueOf(kontaktbearbeitet.getOrt().getPlz());
		email = kontaktbearbeitet.getEmail();
		telefon = kontaktbearbeitet.getTel().toString();

	}

	/**
	 * Diese Methode speichert einen Mitarbeier.
	 */
	public void kontaktUpdate() {

		String name = txtName.getText();
		String vorname = txtVorname.getText();
		String strasse = txtStrasse.getText();
		String ort = txtOrt.getText();
		String plz = txtPLZ.getText();
		String email = txtEmail.getText();
		String telefonnr = txtTelefonNr.getText();


		// �berpr�fung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty()
				|| plz.isEmpty() || email.isEmpty() || telefonnr.isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausf�llen");

		} else {

			// Neue Variabeln f�r das Parsen
			int plzint =0;

			try {

				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}



			try {
				Kontakt updatekontakt = createKontakt(name, vorname,strasse, ort, plzint, email,telefonnr);
				//braucht es dieses this? �berspeichere ich wirklich das alte Objekt?
				//evtl l�sung k�nnte sein das alte einfach l�schen und ein neue erstellen
				this.kontaktRO.update(updatekontakt);
			} catch (Exception e) {
				lblRueckmeldung.setText("Das �berscheiben hat nicht funktioniert");
				e.printStackTrace();
			}

		}
	}

	/**
	 * Diese Methode f�hrt den User zur �bersicht Mitarbeier�bersicht zur�ck.
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
	private Kontakt createKontakt(String name, String vorname, String strasse, String ort, int plz,
			String email, String telefonnr) throws Exception{
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		List<Ort> ortsliste = new ArrayList<Ort>();

		kontaktupdate.setNachname(name);
		kontaktupdate.setVorname(vorname);
		kontaktupdate.setStrasse(strasse);
		kontaktupdate.setEmail(email);
		kontaktupdate.setTel(telefonnr);

		//zu erst auf liste speichern damit man nachher das zweite der Liste pr�fen kann falls nicht �bereinstimmt
		 ortsliste = ortRO.findByOrtPlz(plz);

		//durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die gleiche ist.
			for(Ort o: ortsliste){
				if(ort.equals(o.getOrt())){
					Ort o2 = ortRO.add(o);
					kontaktupdate.setOrt(o2);
					}
			}


		return kontaktupdate;
	}

}
