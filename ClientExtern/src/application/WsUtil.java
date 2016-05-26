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
import webservice.rmi.FeuerungsrapportService;
import webservice.rmi.FeuerungsrapportServiceImplService;

/**
 * Diese Klasse managed die Verbindungen
 *
 * @author Olivia Wassmer & Dominik Stirnimann
 * @version 1.0
 * @since 1.0
 *
 *
 */
public class WsUtil {

	
	public static void initialize() throws Exception{
		FeuerungsrapportServiceImplService service = null;
		
		service = new FeuerungsrapportServiceImplService();
		
		FeuerungsrapportService proxy = null;
		
		proxy = service.getFeuerungsrapportServiceImplPort();
		
	}

}
