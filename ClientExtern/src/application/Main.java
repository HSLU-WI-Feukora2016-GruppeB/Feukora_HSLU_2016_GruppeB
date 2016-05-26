package application;

import feukora.webservice.rmi.FeuerungsrapportService;
import feukora.webservice.rmi.FeuerungsrapportServiceImplService;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Dies ist die Dokumentation der Klasse Main. Von hier aus wird das Programm
 * gestartet.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 1.0
 * @since 1.0
 */

public class Main extends Application {

	@FXML
	private Button btnLogin;

	@FXML
	private TextField txtusername;

	@FXML
	private PasswordField txtpassword;

	@FXML
	private Label lblRueckmeldung;

	private static FeuerungsrapportServiceImplService service;
	private static FeuerungsrapportService proxy;

	/**
	 * Diese Methode öffnet das Login-Fenster zur Authentisierung des Users.
	 * 
	 * @param primaryStage
	 *            Login-Fenster
	 */
	@Override
	public void start(Stage primaryStage) {

		try {

			primaryStage.setTitle("Login");

			primaryStage.setScene(new Scene(FXMLLoader.load(getClass()
					.getResource("view/login/Login.fxml"))));

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Hier startet das Hauptprogramm
	 */
	public static void main(String[] args) throws Exception {

		service = new FeuerungsrapportServiceImplService();

		proxy = service.getFeuerungsrapportServiceImplPort();
		launch(args);
	}

	public static FeuerungsrapportService getFeuerungsRapportService() {
		return proxy;
	}
	
}
