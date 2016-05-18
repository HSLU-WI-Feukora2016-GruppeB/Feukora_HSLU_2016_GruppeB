package application.view.mitarbeiter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rmi.MitarbeiterRO;
import rmi.OrtRO;

/**
 * Dies ist die Dokumentation der Klasse MitarbeiterErfassen. Hier können neue
 * Mitarbeiter erfasst und alte Bearbeitet werden.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

public class MitarbeiterErfassen {

	MitarbeiterRO  MitarbeiterRO;
	OrtRO OrtRO;

	@FXML
	private TextField txtName, txtVorname, txtOrt, txtPLZ, txtRolle, txtLohn, txtEmail, txtTelefonNr, txtStrasse;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	public void initialize(){
		/* SecurityManager zusätzlich
		System.setProperty("java.security.policy", "MitarbeiterRO.policy");

		System.setSecurityManager(new SecurityManager());
*/


		String url = "rmi://192.168.43.4:10099/";
		String MitarbeiterROName = "Mitarbeiter";
		String OrtROName = "Ort";



		try {
			this.MitarbeiterRO = (MitarbeiterRO) Naming.lookup(url + MitarbeiterROName);
			this.OrtRO = (OrtRO) Naming.lookup(url + OrtROName);
			System.out.println("yeah au das fonzt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
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
		String rolle = txtRolle.getText();
		String lohn = txtLohn.getText();
		String email = txtEmail.getText();
		String telefonnr = txtTelefonNr.getText();

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || ort.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty()) {

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {
			// Parsen erst nach der Überprüfung da sonst die isEmpty() Methode
			// nicht vorhanden ist

			// Neue Variabeln für das Parsen
			int rolleint = 0, lohnint = 0, plzint = 0;

			try {
				rolleint = Integer.parseInt(rolle);
				lohnint = Integer.parseInt(lohn);
				plzint = Integer.parseInt(plz);
			} catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}


			Mitarbeiter newmitarbeiter = createMitarbeiter(name,vorname,strasse,ort,plzint,
					rolleint,lohnint,email,telefonnr);
			try {
				this.MitarbeiterRO.add(newmitarbeiter);
			} catch (Exception e) {
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


	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort, int plz,
			int rolle, int lohn, String email, String telefonnr){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Mitarbeiter mitarbeiter = new Mitarbeiter();
		Ort ortschaft = new Ort();

		mitarbeiter.setName(name);
		mitarbeiter.setVorname(vorname);
		mitarbeiter.setRolleIntern(rolle);
		mitarbeiter.setStrasse(strasse);
		mitarbeiter.setLohn(lohn);
		mitarbeiter.setEmail(email);
		mitarbeiter.setTel(telefonnr);

		try {
			//zu erst auf liste speichern damit man nachher das zweite der Liste prüfen kann falls nicht übereinstimmt
		 ortschaft = OrtRO.findByOrtPlz(plz).get(0);
		} catch (Exception e) {
			lblRueckmeldung.setText("PLZ nicht gefunden");
		}

		String ortvondb = ortschaft.getOrt();
		if(ort.equals(ortvondb)){
		mitarbeiter.setOrt(ortschaft);
		}else{
			//prüfe zweites objekt auf der Liste
		}

		return mitarbeiter;
	}

}
