package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import rmi.interfaces.AuftragRO;
import rmi.interfaces.BenutzerRO;
import rmi.interfaces.BrennerRO;
import rmi.interfaces.FeuerungsanlageRO;
import rmi.interfaces.KontaktRO;
import rmi.interfaces.LiegenschaftRO;
import rmi.interfaces.MessungRO;
import rmi.interfaces.MitarbeiterRO;
import rmi.interfaces.OrtRO;
import rmi.interfaces.WaermeerzeugerRO;

/**
 * Diese Klasse managed die RO-Objekte und Verbindungen
 *
 * @author Pascal Steiner & Alexandra Lenggen
 * @version 1.0
 * @since 1.0
 *
 *
 */
public class WsUtil {

	private static AuftragRO auftragRO;
	private static BenutzerRO benutzerRO;
	private static BrennerRO brennerRO;
	private static FeuerungsanlageRO feuerungsanlageRO;
	private static KontaktRO kontaktRO;
	private static LiegenschaftRO liegenschaftRO;
	private static MessungRO messungRO;
	private static MitarbeiterRO mitarbeiterRO;
	private static OrtRO ortRO;
	private static WaermeerzeugerRO waermeerzeugerRO;



	public static void initialize() throws Exception{
		/*---------------RMI Verbindung---------------*/

		String auftragROName = "Auftrag";
		String benutzerROName = "Benutzer";
		String brennerROName = "Brenner";
		String feuerungsanlageROName = "Feuerungsanlage";
		String kontaktROName = "Kontakt";
		String liegenschaftROName = "Liegenschaft";
		String messungROName = "Messung";
		String mitarbeiterROName = "Mitarbeiter";
		String ortROName = "Ort";
		String waermeerzeugerROName = "Waermeerzeuger";

		try {

			// Properties Objekt erstellen
			Properties rmiProperties = new Properties();

			// Klassenloader holen
			ClassLoader cLoader = WsUtil.class.getClassLoader();

			// Properties laden
			rmiProperties.load(cLoader.getResourceAsStream("clientintern.properties"));

			// Port RMI auslesen
			String stringPort = rmiProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);

			String hostIp = rmiProperties.getProperty("rmiIp");

			// URLs definieren
			String urlAuftragRO = "rmi://" + hostIp + ":" + rmiPort + "/" + auftragROName;
			String urlBenutzerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + benutzerROName;
			String urlBrennerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + brennerROName;
			String urlFeuerungsanlageRO = "rmi://" + hostIp + ":" + rmiPort + "/" + feuerungsanlageROName;
			String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/" + kontaktROName;
			String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/" + liegenschaftROName;
			String urlMessungRO = "rmi://" + hostIp + ":" + rmiPort + "/" + messungROName;
			String urlMitarbeiterRO = "rmi://" + hostIp + ":" + rmiPort + "/" + mitarbeiterROName;
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/" + ortROName;
			String urlWaermeerzeugerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + waermeerzeugerROName;


			/* Lookup */
			auftragRO = (AuftragRO) Naming.lookup(urlAuftragRO);
			benutzerRO = (BenutzerRO) Naming.lookup(urlBenutzerRO);
			brennerRO = (BrennerRO) Naming.lookup(urlBrennerRO);
			feuerungsanlageRO = (FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
			kontaktRO = (KontaktRO) Naming.lookup(urlKontaktRO);
			liegenschaftRO = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
			messungRO = (MessungRO) Naming.lookup(urlMessungRO);
			mitarbeiterRO = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);
			ortRO = (OrtRO) Naming.lookup(urlOrtRO);
			waermeerzeugerRO = (WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
	}

	public static AuftragRO getAuftragRO() {
		return auftragRO;
	}

	public static BenutzerRO getBenutzerRO() {
		return benutzerRO;
	}

	public static BrennerRO getBrennerRO() {
		return brennerRO;
	}

	public static FeuerungsanlageRO getFeuerungsanlageRO() {
		return feuerungsanlageRO;
	}

	public static KontaktRO getKontaktRO() {
		return kontaktRO;
	}

	public static LiegenschaftRO getLiegenschaftRO() {
		return liegenschaftRO;
	}

	public static MessungRO getMessungRO() {
		return messungRO;
	}

	public static MitarbeiterRO getMitarbeiterRO() {
		return mitarbeiterRO;
	}

	public static OrtRO getOrtRO() {
		return ortRO;
	}

	public static WaermeerzeugerRO getWaermeerzeugerRO() {
		return waermeerzeugerRO;
	}


}
