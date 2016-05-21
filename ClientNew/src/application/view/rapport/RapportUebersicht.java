package application.view.rapport;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rmi.AuftragRO;

public class RapportUebersicht {

	AuftragRO auftragro;




	@FXML
	private Label lblRueckmeldung;

	@FXML
	private TextField txtName, txtVorname,

	@FXML
	private DatePicker dpDate;

	@FXML
	private ComboBox<Integer> cbZeitslot;




	public void initialize(){


	}


	public void rapportSuchen(){

		//Felder auslesen
		String name = txtName.getText();
		String vorname = txtVorname.getText();
		LocalDate dpdate = dpDate.getValue();


		if(name.isEmpty()|| vorname.isEmpty() || dpdate == null || cbZeitslot.getValue() == null){
			lblRueckmeldung.setText("Bitte alle Felder ausfüllen");
		}else{
			int slut = cbZeitslot.getValue();
			auftragro

		}



	}





}
