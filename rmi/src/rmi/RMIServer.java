package rmi;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import rmi.KundeRO;
import rmi.KundeROImpl;
// import aller sonstiger Klassen und Interface


/**
 * Diese Klasse bildet den RMI-Server ab und ist für das Instanzieren von
 * Entfernten Objekten (RO), deren Registrierung (binding) und Deregistrierung
 * (unbinding) bei RMI Registry zuständig.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 * 
 */
public class RMIServer {

	public static void main(String[] args) {

		/*
		 * Port und Host-IP (an sich sollten diese Angaben aus einer
		 * Property-Datei eingelesen werden)
		 */
		int port = 60140;
		String hostIp = "147.88.210.191";

		String kundeROName = "kundeRO";

		Registry registry = null;

		try {

			if (args.length == 1) {
				// Port auslesen
				try {
					port = Integer.parseInt(args[0]);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					showUsageMessage();
					return;
				}
			} else if (args.length == 2) {

				// hostIp auslesen
				hostIp = args[0];

				// Port auslesen
				try {
					port = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					showUsageMessage();
					return;
				}
			}

			InetAddress.getLocalHost();

			/*
			 * Die NIC-IP nach 'aussen' kommunizieren (falls die Namensauflösung
			 * Probleme bereiten sollte)
			 */
			System.setProperty("java.rmi.server.hostname", hostIp);

			// SocketFactory-Instanz erstellen
			MySocketFactory sFactory = new MySocketFactory(
					InetAddress.getByName(hostIp));

			// Registry starten
			registry = LocateRegistry.createRegistry(port, null, sFactory);

			if (registry != null) {

				// Entfernte Objekte erstellen
				KundeRO kundeRO = new KundeROImpl();


				registry.rebind(kundeROName, kundeRO);


				String msg = "RMI-Server ist bereit für Client-Anfragen.\n\n"
						+ "Server herunterfahren?";
				JOptionPane.showMessageDialog(null, msg, "ServerName ["
						+ hostIp + ":" + port + "]",
						JOptionPane.QUESTION_MESSAGE);

				registry.unbind(kundeROName);


				System.out.println("RMI Server wird heruntergefahren!\n");

				System.exit(0);
			} else {
				System.out
						.println("Entferntes Objekt konnte nicht exportiert werden!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showUsageMessage() {
		System.out
				.println("Usage: \n\n  java rmi.bind.to.multiple.nic.server.demo.RmiPrimCheckerServer portNummer");

		System.out
				.println("\n  or (to bind rmi to spezified network interface)");

		System.out
				.println("\n  java java rmi.bind.to.multiple.nic.server.demo.RmiPrimCheckerServer hostIP portNummer");

	}

}
