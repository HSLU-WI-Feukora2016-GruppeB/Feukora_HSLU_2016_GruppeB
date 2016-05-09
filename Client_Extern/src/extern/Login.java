package extern;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Login extends Application  {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setScene(new Scene(FXMLLoader.load(getClass()
					.getResource("extern/Login.fxml"))));
		} catch (IOException e) {
			// MainView.showError(e);
		}
		primaryStage.show();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}
