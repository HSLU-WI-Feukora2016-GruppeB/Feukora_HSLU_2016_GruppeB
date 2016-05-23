package rmi.rmiserver;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import rmi.AuftragROImpl;
import rmi.BenutzerROImpl;
import rmi.BrennerROImpl;
import rmi.FeuerungsanlageROImpl;
import rmi.KontaktROImpl;
import rmi.LiegenschaftROImpl;
import rmi.MessungROImpl;
import rmi.MitarbeiterROImpl;
import rmi.OrtROImpl;
import rmi.WaermeerzeugerROImpl;
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
 * Diese Klasse fungiert als RMI-Server.
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */
public class RMIServer {

	public static void main(String[] args) {

//		int port = 1099;

		//Properties Objekt erstellen
		Properties dbProperties = new Properties();

		//Klassenloader holen
		ClassLoader cLoader = RMIServer.class.getClassLoader();

		//Properties laden
		try {
			dbProperties.load(cLoader.getResourceAsStream("rmi.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Port auslesen
		String stringPort = dbProperties.getProperty("port");
		Integer port = Integer.valueOf(stringPort);
	try {



	//entfernte Objekte erzeugen
	AuftragRO au = new AuftragROImpl();
	BenutzerRO be = new BenutzerROImpl();
	BrennerRO br = new BrennerROImpl();
	FeuerungsanlageRO fe = new FeuerungsanlageROImpl();
	KontaktRO ko = new KontaktROImpl();
	LiegenschaftRO li = new LiegenschaftROImpl();
	MessungRO me = new MessungROImpl();
	MitarbeiterRO mi = new MitarbeiterROImpl();
	OrtRO or = new OrtROImpl();
	WaermeerzeugerRO wa = new WaermeerzeugerROImpl();

	// Registry-Instanz erzeugen bzw. starten
	Registry reg = LocateRegistry.createRegistry(port);

	// Entferntes Objekt beim Namensdienst registrieren
	if (reg != null) {

		reg.rebind("Auftrag", au);
		reg.rebind("Benutzer", be);
		reg.rebind("Brenner", br);
		reg.rebind("Feuerungsanlage", fe);
		reg.rebind("Kontakt", ko);
		reg.rebind("Liegenschaft", li);
		reg.rebind("Messung", me);
		reg.rebind("Mitarbeiter", mi);
		reg.rebind("Ort", or);
		reg.rebind("Waermerzeuger", wa);

		// Ausgabe
		System.out.println("Objekt beim Namensdienst angemeldet.");

		//Server bereit
		System.out.println("Server bereit.");

		}

	} catch(RemoteException re){
		re.printStackTrace();
	}catch (Exception e){
		e.printStackTrace();
	}
}
}