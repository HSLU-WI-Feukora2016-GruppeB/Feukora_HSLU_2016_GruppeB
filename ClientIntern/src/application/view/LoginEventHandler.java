package application.view;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginEventHandler implements EventHandler<ActionEvent>{

	@FXML
	private TextField txtusername;

	@FXML
	private TextField txtpassword;

	@FXML
	private Label lblRückmeldung;

	@FXML
	private BorderPane root;



	public void handle(ActionEvent event){


		String entername = txtusername.getText();
		String enterpassword = txtpassword.getText();



		//Nachname und Vorname
		//User m = findMitarbeiterByUsername(entername);


		//if(m.getUser().getUsername() == entername && m.getUser().getPassword() == enterpassword){
		if(entername.equals("a") && enterpassword.equals("a")){

			//String rolle = m.getrolle();
			String rolle = "Feuerungskontrolleur";

			switch(rolle){

			case "Feuerungskontrolleur":

				try{

					Stage DashboardFKStage = new Stage();

					DashboardFKStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Dashboard_Kontrolleur.fxml"))));

					DashboardFKStage.show();

					((Stage) root.getScene().getWindow()).close();
					}catch(Exception e){
						e.printStackTrace();
					}



				break;

			case "Backoffice":

				try{

					Stage DashboardBOStage = new Stage();

					DashboardBOStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Dashboard_Kontrolleur.fxml"))));
					DashboardBOStage.show();

					((Stage) root.getScene().getWindow()).close();

					}catch(Exception e){
						e.printStackTrace();
					}
				break;

			case "Administrator":

				try{
					Stage DashboardBOStage = new Stage();

					DashboardBOStage.setScene(new Scene(FXMLLoader.load(getClass()
							.getResource("Dashboard_Kontrolleur.fxml"))));
					DashboardBOStage.show();

					((Stage) root.getScene().getWindow()).close();

					}catch(Exception e){
						e.printStackTrace();
					}

				break;

			}
		}else{
			lblRückmeldung.setText("Benutzername oder Passwort falsch!");

			}


	}

}
