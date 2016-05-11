package application.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MitarbeiterErfassen implements EventHandler<ActionEvent>{

	@FXML
	private TextField txtName, txtVorname, txtPLZ, txtOrt, txtPosition,
		txtLohn, txtEmail, txtTelefonNr;

	@Override
	public void handle(ActionEvent event) {

		Button x = (Button) event.getSource();
        String idbutton = x.getId();

        switch(idbutton){

        case"btnSpeichern":

        	String name = txtName.getText();
        	String vorname = txtVorname.getText();
        	String plz = txtPLZ.getText();
        	String ort = txtOrt.getText();
        	String position = txtPosition.getText();
        	String lohn = txtLohn.getText();
        	String email = txtEmail.getText();
        	String telefonnr = txtTelefonNr.getText();

        	Mitarbeiter newmitarbeiter = createMitarbeiter(String name, String vorname, String plz, String ort,
        			String position, String lohn, String email, String telefonnr);
        	//this.studentRO.add(newmitarbeiter);
        break;

        case"btnAbbrechen":
        	Platform.exit();
        break;
        }// End of switch

        private Mitarbeiter createMitarbeiter(String name, String vorname, String plz, String ort,
    			String position, String lohn, String email, String telefonnr){
        	//Exception werfen? bei Referenzprojekt hat ers gemacht

        	Mitarbeiter mitarbeiter = new Mitarbeiter();

        	mitarbeiter.setName(name);
        	mitarbeiter.setVorname(vorname);
        	mitarbeiter.setPosition(position);
        	mitarbeiter.setLohn(lohn);
        	mitarbeiter.setEmail(email);
        	mitarbeiter.setTelefonNr(telefonnr);


        	Strasse strasse = new Strasse();
        	strasse.setStrassenbezeichnung(strassenbezeichnung);//haben wir noch nicht. benötigen wir aber um einen Mitarbeiter zu erfassen!
        	strasse.setStrassennummer(strassennummer);//haben wir auch noch nicht.


        	Ort ortschaft = new Ort();
        	ortschaft.setPLZ(plz);
        	ortschaft.setOrtsbezeichnung(ort);

        	Adresse adresse = new Adresse();
        	adresse.setStrasse(strasse);
        	adresse.setOrtsbezeichnung(ortschaft);

        	mitarbeiter.setAdresse(adresse);

        	return Mitarbeiter;
        }

	}

}
