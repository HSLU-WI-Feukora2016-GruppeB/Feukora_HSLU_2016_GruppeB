package application.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MitarbeitUerbersicht implements EventHandler<ActionEvent>{

	@FXML
	private BorderPane leaf;



	@Override
	public void handle(ActionEvent event) {

		Button x = (Button) event.getSource();
        String idbutton = x.getId();

        switch(idbutton){

        case "btnNeu":
        	try{
        		Stage MitarbeiterStage = new Stage();

				MitarbeiterStage.setScene(new Scene(FXMLLoader.load(getClass()
						.getResource("Mitarbeiter_Erfassen.fxml"))));

				MitarbeiterStage.show();
				}catch(Exception e){
					e.printStackTrace();
				}
        break;


        case "btnBearbeiten":

        	//Wähle das markierte Objekt in der Liste aus und setze es in das Mitarbeiter_Erfassen.fxml

        break;

        case "btnSchliessen":
        	((Stage) leaf.getScene().getWindow()).close();

        break;


	}
	}
}
