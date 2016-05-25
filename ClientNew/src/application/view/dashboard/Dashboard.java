package application.view.dashboard;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Dies ist die Dokumentation der Klasse Dashboard. Von hier aus werden
 * sämtliche Übersichten geöffnet.
 *
 * @author Alexandra Lengen und Pascal Steiner
 * @version 1.0
 * @since 1.0
 */
public class Dashboard {

	@FXML
	private Button btnTerminVerwaltung, btnMitarbeiterVerwaltung, btnKontaktVerwaltung, btnLiegenschaftVerwaltung,
			btnRapporUebersicht;

	private Stage DashStage = new Stage();

	@FXML
	private Pane leaf;

	/**
	 * Diese Methode dient zur Öffnung der Übersicht Terminübersicht.
	 */
	public void terminVerwaltung() {

		try {

			DashStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/termin/TerminUebersicht.fxml"))));

			DashStage.setFullScreen(true);
			DashStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode dient zur Öffnung der Übersicht Mitarbeiterverwaltung.
	 */
	public void mitarbeiterVerwaltung() {

		try {

			DashStage.setScene(new Scene(FXMLLoader
					.load(getClass().getResource("/application/view/mitarbeiter/MitarbeiterUebersicht.fxml"))));

			DashStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode dient zur Öffnung der Übersicht Kontaktverwaltung.
	 */
	public void kontaktVerwaltung() {
		try {

			DashStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/kontakt/KontaktUebersicht.fxml"))));

			DashStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode dient zur Öffnung der Übersicht Liegenschaftverwaltung.
	 */
	public void liegenschaftVerwaltung() {
		try {

			DashStage.setScene(new Scene(FXMLLoader
					.load(getClass().getResource("/application/view/liegenschaft/LiegenschaftUebersicht.fxml"))));

			DashStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode dient zur Öffnung der Übersicht Rapportverwaltung.
	 */
	public void rapportVerwalten() {
		try {

			DashStage.setScene(new Scene(
					FXMLLoader.load(getClass().getResource("/application/view/rapport/RapportUebersicht.fxml"))));

			DashStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
