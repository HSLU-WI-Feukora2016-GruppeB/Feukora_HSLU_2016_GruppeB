package application.view.mitarbeiter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Mitarbeiter;
import entitys.Ort;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
	private DatePicker startDatum, endDatum;
	@FXML
	private Pane leaf;

	public void initialize(){
		/* SecurityManager zusätzlich falls man will
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
		LocalDate enddatum = endDatum.getValue();
		LocalDate startdatum = startDatum.getValue();

		// Überprüfung ob die Felder auch mit einem Wert belegt wurden
		if (name.isEmpty() || vorname.isEmpty() || strasse.isEmpty() || ort.isEmpty() || ort.isEmpty()
				|| rolle.isEmpty() || email.isEmpty() || telefonnr.isEmpty() || enddatum.toString().isEmpty()
				|| startdatum.toString().isEmpty()){

			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");

		} else {

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
			int rolleint = 0, lohnint = 0, plzint = 0;

			try {
				rolleint = Integer.parseInt(rolle);
				lohnint = Integer.parseInt(lohn);
				plzint = Integer.parseInt(plz);
			}catch (Exception e) {
				lblRueckmeldung.setText("Parsen hat fehlgeschlagen");
			}


			Mitarbeiter newmitarbeiter = createMitarbeiter(name,vorname,strasse,ort,plzint,
					rolleint,lohnint,email,telefonnr,gcalstart, gcalend);
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
	 */
	private Mitarbeiter createMitarbeiter(String name, String vorname, String strasse, String ort, int plz,
			int rolle, int lohn, String email, String telefonnr,
			GregorianCalendar gcalstart, GregorianCalendar gcalend){
		//Exception werfen? bei Referenzprojekt hat ers gemacht

		Mitarbeiter mitarbeiter = new Mitarbeiter();
		Ort ortschaft = new Ort();
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

		try {
			//zu erst auf liste speichern damit man nachher das zweite der Liste prüfen kann falls nicht übereinstimmt
		 ortsliste = OrtRO.findByOrtPlz(plz);
		} catch (Exception e) {
			lblRueckmeldung.setText("PLZ nicht gefunden");
		}

		//durchgehe alle Ortsobjekte in der liste und schaue ob die OrtsBez die gleiche ist.
		for(Ort o: ortsliste){
			o = ortsliste.get(0);
			if(ort.equals(o.getOrt())){
				mitarbeiter.setOrt(ortschaft);
				}
		}

		return mitarbeiter;
	}

}
