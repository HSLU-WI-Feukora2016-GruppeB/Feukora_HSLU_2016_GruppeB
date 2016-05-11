package application.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardBOEventHandler implements EventHandler<ActionEvent> {


	@Override
	public void handle(ActionEvent event) {

			Stage DashStage = new Stage();

            Button x = (Button) event.getSource();

            String idbutton = x.getId();

            switch(idbutton){

            case "btnTerminUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Terminuebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;


            case "btnMitarbeiterUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Mitarbeiter_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;


            case "btnEigentümerUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Eigentümer_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;

            case "btnBrennerUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Brenner_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;


            case "btnWärmeerzeugerUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Waermeerzeuger_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;


            case "btnLiegenschaftUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Liegenschaft_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;

            case "btnRapportUebersicht":
            	try{

					DashStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Rapport_Uebersicht.fxml"))));

					DashStage.show();
					}catch(Exception e){
						e.printStackTrace();
					}
            	break;


            }//end of switch



	}



}
