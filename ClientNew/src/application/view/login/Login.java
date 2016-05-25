package application.view.login;


import java.util.ArrayList;
import java.util.List;

import rmi.interfaces.BenutzerRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.MitarbeiterRO;
import application.RmiUtil;
import entitys.Benutzer;
import entitys.Mitarbeiter;

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
import rmi.interfaces.KontaktRO;

/**
 *Managed das Login und die Authentifizierung
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 */
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

	BenutzerRO benutzerRO;
	MitarbeiterRO mitarbeiterRO;

	/**
	 * Diese Methode �ffnet die Methode goLogin() durch die Taste "Enter".
	 */
	@FXML
	public void goLoginEvent(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			goLogin();
		} else {
		}
	}

	public void initialize(){
		/*---------------RMI Verbindung---------------*/

		/* Lookup */
		benutzerRO = RmiUtil.getBenutzerRO();
		mitarbeiterRO = RmiUtil.getMitarbeiterRO();

		/*----------------------------------------------*/
	}


	/**
	 * Diese Methode authentisiert und authorisiert den User.
	 */
	@FXML
	public void goLogin() {

		String entername = txtusername.getText();
		String enterpassword = txtpassword.getText();
		Mitarbeiter mitarbeiter;
		Benutzer mitsingle = null;


		try {
			List<Benutzer> mit = benutzerRO.findByUsername(entername);
			mitsingle = mit.get(0);


			if(mitsingle.getUsername().equals(entername) &&
					mitsingle.getPassword().toString().equals(enterpassword)){

						List<Mitarbeiter> list = mitarbeiterRO.findByBenutzer(mitsingle);
						mitarbeiter = list.get(0);
String r = mitarbeiter.getRolleIntern();
			switch(r){

						case "Sachbearbeiter":

								Stage DashboardFKStage = new Stage();

								DashboardFKStage.setScene(new Scene(FXMLLoader
										.load(getClass().getResource("/application/view/dashboard/DashboardKontrolleur.fxml"))));

								DashboardFKStage.show();

								((Stage) leaf.getScene().getWindow()).close();
								break;

						case "Administrator":

							try {
								Stage DashboardBOStage = new Stage();

								DashboardBOStage
										.setScene(new Scene(FXMLLoader.load(getClass().getResource("/application/view/admin/BenutzerUebersicht"))));
								DashboardBOStage.show();

								((Stage) leaf.getScene().getWindow()).close();

							} catch (Exception e) {
								e.printStackTrace();
							}

							break;

						}
					}else {
						lblRueckmeldung.setText("Benutzername oder Passwort falsch");
					}
		} catch (Exception e1) {
			lblRueckmeldung.setText("Login fehlgeschlagen");
		}






	}

}
