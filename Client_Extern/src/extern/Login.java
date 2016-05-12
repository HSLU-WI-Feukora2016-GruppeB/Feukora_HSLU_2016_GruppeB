package extern;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Login extends Application {

	@Override
	public void start(Stage stage) {
		try {
			stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(
					"extern.view/Login.fxml"))));
		} catch (IOException e) {
			// MainView.showError(e);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
