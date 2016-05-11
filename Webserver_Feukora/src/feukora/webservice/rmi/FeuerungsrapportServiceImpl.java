/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c)
 */
package feukora.webservice.rmi;

import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;

/**
 * Diese Klasse implementiert die Konkreten Methoden des
 * FeuerungsrapportInterface für die Feuerungskontrolle zur Verfügung.
 * 
 * @author Dominik
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
@WebService(endpointInterface = "demo.webservice.over.rmi.ModulverwaltungService")
public class FeuerungsrapportServiceImpl implements FeuerungsrapportService {

	private Liegenschaft LiegenschaftManager;

	// private ModulRO modulManager;
	// private StudentRO studentManager;

	public FeuerungsrapportServiceImpl() throws Exception {

			String LiegenschaftROName = "LiegenschaftRO";
//			String dozentROName = "dozentRO";
//			String modulROName = "modulRO";

			/*
			 * Host-IP und RMI-Port definieren (an sich würde man diese Angaben aus
			 * der Property-Datei einlesen)
			 */
			String hostIp = "localhost";
			int rmiPort = 1099;

			// SecurityManager braucht nicht installiert zu werden, da Tomcat einen
			// eigenen SecurityManager hat
			try {
				
				/* Properties laden */
				Properties props = new Properties();

				InputStream is = FeuerungsrapportServiceImpl.class.getClassLoader()
						.getResourceAsStream("ws.properties");

				props.load(is);

				hostIp = props.getProperty("rmi.host_ip");
				rmiPort = Integer.parseInt(props.getProperty("rmi.port"));

				// URLs definieren
				String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/"
						+ LiegenschaftROName;
//				String urlDozentRO = "rmi://" + hostIp + ":" + rmiPort + "/"
//						+ dozentROName;
//				String urlModulRO = "rmi://" + hostIp + ":" + rmiPort + "/"
//						+ modulROName;

				/* Lookup */
				liegenschaftManager = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
//				modulManager = (ModulRO) Naming.lookup(urlModulRO);
//				studentManager = (StudentRO) Naming.lookup(urlStudentRO);
				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				throw e;			
			}
		}
	
		@Override
		public Liegenschaft addLiegenschaft(Liegenschaft liegenschaft)throws Exception {
			return liegenschaftManager.add(liegenschaft);
		}
		
		@Override
		public Liegenschaft updateiegenschaft(Liegenschaft liegenschaft)throws Exception {
			return liegenschaftManager.update(liegenschaft);
		}
		
		@Override
		public void deleteLiegenschaft(Liegenschaft liegenschaft)
			liegenschaftManager.delete(liegenschaft);
		}

		@Override
		public Liegenschaft findLiegenschaftById(Liegenschaft liegenschaft)
				throws Exception {
			return liegenschaftManager.findById
		}

		@Override
		public List<Liegenschaft> findAllLiegenschaft() throws Exception {
			return liegenschaftManager.finAll
		}

		@Override
		public List<Liegenschaft> findLiegenschaftByPostleitzahlUndOrt(
			int postleitzahl, String ort) throws Exception {
		return liegenschaftManager.findByPostleitzahlUndOrt(postleitzahl, ort);
		}

		@Override
		public Liegenschaft findLiegenschaftByEigentuemer(String eigentuemer)
			throws Exception {
		return liegenschaftManager.findByEigentuemer(eigentuemer);
		}

		@Override
		public Liegenschaft findLiegenschaftByBrenner(String brenner)
			throws Exception {
		return liegenschaftManager.findByBrenner(brenner);
		}

		@Override
		public Liegenschaft findLiegenschaftByWaermeerzeuger(String waermeerzeuger)
			throws Exception {
		return liegenschaftManager.findByWaermeerzeuger(waermeerzeuger);
		}
}
