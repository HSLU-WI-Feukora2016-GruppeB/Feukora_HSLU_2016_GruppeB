package application.view;

import java.time.LocalDate;
import java.util.GregorianCalendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TerminErfassenEventHandler implements EventHandler<ActionEvent> {


	@FXML
	private TextField	Nachname;

	@FXML
	private TextField 	Vorname;

	@FXML
	private TextField Strasse;

	@FXML
	private TextField PLZ;

	@FXML
	private TextField Ort;

	@FXML
	private TextField Zeitslot;

	@FXML
	private DatePicker dateoftermin;


	@Override
	public void handle(ActionEvent event) {

		Button x = (Button) event.getSource();

        String idbutton = x.getId();

        switch(idbutton){



//if (Nachname = null ){
        case "btnSpeichern" :
        	//müssen wir das hier auch in einen try catch block setzen?


        	LocalDate datum = dateoftermin.getValue();

        	int tag = datum.getDayOfMonth();
        	int monat = datum.getMonthValue();
        	int jahr = datum.getYear();

        	GregorianCalendar gcal = new GregorianCalendar(jahr, monat, tag);


        break;



        case "btnAbbrechen":


        	Platform.exit();

        	break;
        }

	}





	}




