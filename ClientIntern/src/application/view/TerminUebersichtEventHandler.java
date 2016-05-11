package application.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Diese Klasse ist die Controllerklasse der Terminübersicht.
 *
 * @author Pascal Steiner & Alexandra Lengen
 * @version 1.0
 *
 *
 */
public class TerminUebersichtEventHandler implements EventHandler<ActionEvent>{


	@Override
	public void handle(ActionEvent event) {

		// Je nachdem welcher Button gedrückt wird, wird es auf einen String gecastet
		Button x = (Button) event.getSource();
        String idbutton = x.getId();



         switch(idbutton){

         case "btnNeuerTermin":
         try{
        	 Stage TerminStage = new Stage();
        	 TerminStage.setScene(new Scene(FXMLLoader.load(getClass()
						.getResource("Termin_Erfassen.fxml"))));

     		TerminStage.show();

     		}catch(Exception e){
     			e.printStackTrace();
     		}
         break;


         case "btnAktuelleTerminlist":
        	 //GetAllTermine()

            //ExportAllTermine evtl. mit Filewriter in TextFile und dann import in Excel

             break;

         case "btnRapportOeffnen":
             //FindAllRapporteByTermine  (oder sogar mit Zeit? ein bisschen schwierig umzusetzen)
        	 //Gib eine Liste zurück aber wie wird diese angezeigt

             break;


         }



	}



}
