/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c)
 */
package feukora.webservice.rmi;

import java.io.InputStream;
import java.net.MalformedURLException;
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

	
	private AuftragRO AuftragManager;
	private BrennerRO BrennerManager;
	private FeuerungsanlageRO FeuerungsanlageManager;
	private KontaktRO KontaktManager;
	private LiegenschaftRO LiegenschaftManager;
	private WaermeerzeugerRO WaermeerzeugerManager;

	public FeuerungsrapportServiceImpl() throws Exception {

			
			String AuftragROName = "AuftragRO";
			String BrennerROName = "BrennerRO";
			String FeuerungsanlageROName = "FeuerungsanlageRO";
			String KontaktROName = "KontaktRO";
			String LiegenschaftROName = "LiegenschaftRO";
			String WaermeerzeugerROName = "WaermeerzeugerRO";


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
				String urlAuftragRO = "rmi://" + hostIp + ":" + rmiPort + "/" + AuftragROName;
				String urlBrennerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + BrennerROName;
				String urlFeuerungsanlageRO	= "rmi://" + hostIp + ":" + rmiPort + "/" + FeuerungsanlageROName;
				String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/" + KontaktROName;
				String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/" + LiegenschaftROName;
				String urlWaermeerzeugerRO = "rmi://" + hostIp + ":" + rmiPort + "/" + WaermeerzeugerROName;
				
				/* Lookup */
				AuftragManager 			= 	(AuftragRO) Naming.lookup(urlAuftragRO);
				BrennerManager 			= 	(BrennerRO) Naming.lookup(urlBrennerRO);
				FeuerungsanlageManager 	= 	(FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
				KontaktManager 			= 	(KontaktRO) Naming.lookup(urlKontaktRO);
				LiegenschaftManager 	= 	(LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
				WaermeerzeugerManager 	= 	(WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);
				
//				modulManager = (ModulRO) Naming.lookup(urlModulRO);
//				studentManager = (StudentRO) Naming.lookup(urlStudentRO);
				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				throw e;			
			}
		}
		//-----------------------------------------------------------------------------------------------
		//												Auftrag
		//-----------------------------------------------------------------------------------------------
		@Override
		public Auftrag addAuftrag(Auftrag entity) throws Exception {
			return auftragManager.add(auftrag);
		}

		@Override
		public Auftrag updateAuftrag(Auftrag entity) throws Exception {
			return auftragManager.update(auftrag);
		}

		@Override
		public void deleteAuftrag(Auftrag entity) throws Exception {
			return auftragManager.delete(auftrag);
			
		}

		@Override
		public List<Auftrag> findAllAuftrag() throws Exception {
			return auftrasManager.findAll(auftrag);
		}

		@Override
		public List<Auftrag> findAuftragByDatum(GregorianCalender datum)
				throws Exception {
			return auftragManager.findByDatum(auftrag);
		}

		@Override
		public List<Auftrag> findAuftragByMitarbeiter(String mitarbeiter)
				throws Exception {
			return auftragManager.findByMitarbeiter(auftrag);
		}

		@Override
		public List<Auftrag> findAuftragByKontakt(String kontakt)
				throws Exception {
			return auftragManager.findByKontakt(auftrag);
		}
		@Override
		public List<Auftrag> findAuftragByLiegenschaft(String liegenschaft)
				throws Exception {
			return auftragManager.findByLiegenschaft(auftrag);
		}

		@Override
		public List<Auftrag> findAuftragByAuftragsnummer(int auftragsNummer) {
			return auftragManager.findByAuftragsnummer(auftrag);
		}
		//-----------------------------------------------------------------------------------------------
		//												Brenner
		//-----------------------------------------------------------------------------------------------
		@Override
		public Brenner addBrenner(Brenner entity) throws Exception {
			return brennerManager.add(brenner);
		}

		@Override
		public Brenner updateBrenner(Brenner entität) throws Exception {
			return brennerManager.update(brenner);
		}

		@Override
		public void deleteBrenner(Brenner entity) throws Exception {
			return brennerManager.delete(brenner);
			
		}

		@Override
		public List<Brenner> findBrennerByAllBrenner() throws Exception {
			return brennerManager.findAll(brenner);
		}

		@Override
		public List<Brenner> findBrennerByTyp(String brennerTyp)
				throws Exception {
			return brennerManager.findByTyp(brenner);
		}

		@Override
		public List<Brenner> findBrennerByArt(String brennerArt)
				throws Exception {
			return brennerManager.findByArt(brenner);
		}
		//-----------------------------------------------------------------------------------------------
		//												Feuerungsanlage
		//-----------------------------------------------------------------------------------------------
		@Override
		public Feuerungsanlage addFeuerungsanlage(Feuerungsanlage entity)
				throws Exception {
			return feuerungsanlageManager.add(feuerungsanlage);
		}

		@Override
		public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity)
				throws Exception {
			return feuerungsanlageManager.update(feuerungsanlage);
		}

		@Override
		public void deleteFeuerungsanlage(Feuerungsanlage entity)
				throws Exception {
			return feuerungsanlageManager.delete(feuerungsanlage);
			
		}

		@Override
		public List<Feuerungsanlage> findAllFeuerungsanlage() 
				throws Exception {
			return feuerungsanlageManager.findAll(feuerungsanlage);
		}

		@Override
		public List<Feuerungsanlage> findFeuerungsanlageByLiegenschaft(Liegenschaft liegenschaft)
				throws Exception {
			return feuerungsanlageManager.findByLiegenschaft(liegenschaft);
		}

		@Override
		public List<Feuerungsanlage> findFeuerungsanlageByBrenner(Brenner brenner) 
				throws Exception {
			return feuerungsanlageManager.findByBrenner(brenner);
		}

		@Override
		public List<Feuerungsanlage> findFeuerungsanlageByWaermeerzeuger(Waermeerzeuger waermeerzeuger) 
				throws Exception {
			return feuerungsanlageManager.findByWaermeerzeuger(waermeerzeuger);
		}
		//-----------------------------------------------------------------------------------------------
		//												Kontakt
		//-----------------------------------------------------------------------------------------------
		@Override
		public Kontakt addKontakt(Kontakt entity)
				throws Exception {
			return kontaktManager.add(kontakt);
		}

		@Override
		public Kontakt updateKontakt(Kontakt entity) 
				throws Exception {
			return kontaktManager.update(kontakt);
		}

		@Override
		public void deleteKontakt(Kontakt entity) 
				throws Exception {
			return kontaktManager.delete(kontakt);
			
		}

		@Override
		public List<Kontakt> findAllKontakt() 
				throws Exception {
			return kontaktManager.findAll(kontakt);
		}

		@Override
		public List<Kontakt> findKontaktByName(String name) 
				throws Exception {
			return kontaktManager.findByName(name);
		}

		@Override
		public List<Kontakt> findKontaktByVorname(String vorname)
				throws Exception {
			return kontaktManager.findByVorname(vorname);
		}

		@Override
		public List<Kontakt> findKontaktByOrt(String ort) 
				throws Exception {
			return kontaktManager.findByOrt(ort);
		}

		@Override
		public List<Kontakt> findKontaktByRolleExtern(RolleExtern rolleExtern)
				throws Exception {
			return kontaktManager.findByRolleExtern(rolleExtern);
		}
		//-----------------------------------------------------------------------------------------------
		//												Liegenschaft
		//-----------------------------------------------------------------------------------------------
		@Override
		public Liegenschaft addLiegenschaft(Liegenschaft liegenschaft)
				throws Exception {
			return liegenschaftManager.add(liegenschaft);
		}

		@Override
		public Liegenschaft updateiegenschaft(Liegenschaft liegenschaft)
				throws Exception {
			return liegenschaftManager.update(liegenschaft);
		}

		@Override
		public void deleteLiegenschaft(Liegenschaft liegenschaft)
				throws Exception {
			liegenschaftManager.delete(liegenschaft);
		}
		
		@Override
		public List<Liegenschaft> findAllLiegenschaft() 
				throws Exception {
			return liegenschaftManager.findAll(liegenschaft);
		}
		
		@Override
		public List<Liegenschaft> findLiegenschaftByOrt(String ort)
				throws Exception {
			return liegenschaftManager.findByOrt(ort);
		}

		@Override
		public List<Liegenschaft> findLiegenschaftByStrasse(String strasse)
				throws Exception {
			return liegenschaftManager.findByStrasse(strasse);
		}

		@Override
		public Liegenschaft findLiegenschaftByKontakt(String kontakt)
				throws Exception {
			return liegenschaftManager.findByKontakt(kontakt);
		}
		
		//-----------------------------------------------------------------------------------------------
		//												Wärmeerzeuger
		//-----------------------------------------------------------------------------------------------
		@Override
		public Waermeerzeuger addWaermeerzeuger(Waermeerzeuger entitaet)
				throws Exception {
			return waermeerzeugerManager.add(waermeerzeuger);
		}

		@Override
		public Waermeerzeguer updateWaermeerzeuger(Waermeerzeuger entitaet)
				throws Exception {
			return waermeerzeugerManager.update(waermeerzeuger);
		}

		@Override
		public void deleteWaermeerzeuger(Waermeerzeuger entitaet)
				throws Exception {
			return waermeerzeugerManager.delete(waermeerzeuger);
			
		}

		@Override
		public Waermeerzeuger findWaermeerzeugerById(Integer id)
				throws Exception {
			return waermeerzeugerManager.findById(id);
		}

		@Override
		public List<Waermeerzeuger> findAllWaermeerzeuger() 
				throws Exception {
			return waermeerzeugerManager.findAll(waermeerzeuger);
		}

		@Override
		public List<Waermeerzeuger> findWaermeerzeugerByTyp(String waermeerzeugerTyp) 
				throws Exception {
			return waermeerzeugerManager.findByTyp(typ);
		}

		@Override
		public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(String brennstoff) 
						throws Exception {
			return waermeerzeugerManager.findByBrennstoff(brennstoff);
		}
}
