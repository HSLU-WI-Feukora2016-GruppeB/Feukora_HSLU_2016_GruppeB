package application.view.login;

/**
 * Dies ist die Dokumentation der Klasse Login. Sie dient zur
 * Authorisierung und Athentisierung eines Users.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 4.0
 * @since 1.0
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login {

	@FXML
	private Button btnLogin;

	@FXML
	private TextField txtusername;

	@FXML
	private PasswordField txtpassword;

	@FXML
	private Label lblRueckmeldung;

	@FXML
	private Pane leaf;

	/**
	 * Diese Methode öffnet die Methode goLogin() durch die Taste "Enter".
	 */
	@FXML
	public void goLoginEvent(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			goLogin();
		} else {
		}
	}

	/**
	 * Diese Methode authentisiert und authorisiert den User.
	 */
	@FXML
	public void goLogin() {

		String entername = txtusername.getText();
		String enterpassword = txtpassword.getText();

		// Nachname und Vorname
		// User m = findMitarbeiterByUsername(entername);

		// if(m.getUser().getUsername() == entername &&
		// m.getUser().getPassword() == enterpassword){
		if (entername.equals("a") && enterpassword.equals("a")) {

			// String rolle = m.getrolle();
			String rolle = "Feuerungskontrolleur";

			switch (rolle) {

			case "Feuerungskontrolleur":

				try {

					Stage DashboardFKStage = new Stage();

					DashboardFKStage.setScene(new Scene(FXMLLoader
							.load(getClass().getResource("/application/view/dashboard/DashboardKontrolleur.fxml"))));

					DashboardFKStage.show();

					((Stage) leaf.getScene().getWindow()).close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case "Backoffice":

				try {

					Stage DashboardBOStage = new Stage();

					DashboardBOStage
							.setScene(new Scene(FXMLLoader.load(getClass().getResource("Dashboard_Kontrolleur.fxml"))));
					DashboardBOStage.show();

					((Stage) leaf.getScene().getWindow()).close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "Administrator":

				try {
					Stage DashboardBOStage = new Stage();

					DashboardBOStage
							.setScene(new Scene(FXMLLoader.load(getClass().getResource("Dashboard_Kontrolleur.fxml"))));
					DashboardBOStage.show();

					((Stage) leaf.getScene().getWindow()).close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			}
		} else {
			lblRueckmeldung.setText("Benutzername oder Passwort falsch!");

		}

	}

}
