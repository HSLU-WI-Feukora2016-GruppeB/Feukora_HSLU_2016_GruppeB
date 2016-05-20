package application.view.kontakt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import entitys.Kontakt;
import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.KontaktRO;
import rmi.OrtRO;

public class KontaktBearbeiten {

	OrtRO OrtRO;
	KontaktRO  KontaktRO;


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

	public void initialize(){


		String url = "rmi://192.168.43.4:10099/";
		String MitarbeiterROName = "Mitarbeiter";
		String OrtROName = "Ort";

		try {
			this.KontaktRO = (KontaktRO) Naming.lookup(url + MitarbeiterROName);
			this.OrtRO = (OrtRO) Naming.lookup(url + OrtROName);
			System.out.println("yeah au das fonzt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}


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


		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty()
				|| plz.isEmpty() || email.isEmpty() || telefonnr.isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

			// Neue Variabeln für das Parsen
			int plzint =0;

			try {

				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}


			Kontakt updatekontakt = createKontakt(name, vorname,strasse, ort, plzint, email,telefonnr);
			try {
				//braucht es dieses this? überspeichere ich wirklich das alte Objekt?
				//evtl lösung könnte sein das alte einfach löschen und ein neue erstellen
				this.KontaktRO.update(updatekontakt);
			} catch (Exception e) {
				lblRueckmeldung.setText("Das überscheiben hat nicht funktioniert");
				e.printStackTrace();
			}

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
	 */
	private Kontakt createKontakt(String name, String vorname, String strasse, String ort, int plz,
			String email, String telefonnr){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Ort ortschaft = new Ort();

		kontaktupdate.setNachname(name);
		kontaktupdate.setVorname(vorname);
		kontaktupdate.setStrasse(strasse);
		kontaktupdate.setEmail(email);
		kontaktupdate.setTel(telefonnr);

		try {
			//zu erst auf liste speichern damit man nachher das zweite der Liste prüfen kann falls nicht übereinstimmt
		 ortschaft = OrtRO.findByOrtPlz(plz).get(0);
		} catch (Exception e) {
			lblRueckmeldung.setText("PLZ nicht gefunden");
		}

		String ortvondb = ortschaft.getOrt();
		if(ort.equals(ortvondb)){
			kontaktupdate.setOrt(ortschaft);
		}else{
			//prüfe zweites objekt auf der Liste
		}


		return kontaktupdate;
	}

}
