package extern;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventHandlerLogin implements EventHandler <ActionEvent>{


	@FXML
	private TextField txBenutzername;

	@FXML
	private PasswordField pfPasswort;

	@FXML
	public void clickLogin() {
		
		
		//switch ()
		// Login login = new Login(new Sachbearbeiter("", "",
		// txBenutzername.getText()), pfPasswort.getText(), null);
		// Context.setLogin(login);
		if (RollenZuteil.login()) {

			try {
				Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource(
						"Dashboard_Kontrolleur.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// MainView.showError(e);
			}

			((Stage) txBenutzername.getParent().getScene().getWindow()).close();

		} else {
			txBenutzername.setText("");
			pfPasswort.setText("");
		}
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
