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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;

import rmi.*;
import entitys.*;

/* import entitäten.Auftrag;
 * import entitäten.Benutzer;
 * import entitäten.Brenner;
 * import entitäten.Feuerungsanlage;
 * import entitäten.Kontakt;
 * import entitäten.Liegenschaft;
 * import entitäten.Messung;
 * import entitäten.Mitarbeiter;
 * import entitäten.Ort;
 * import entitäten.Waermeerzeuger;
 * import managerInterfaces.*;
 */

/**
 * Diese Klasse implementiert die Konkreten Methoden des
 * FeuerungsrapportInterface für die Feuerungskontrolle zur Verfügung.
 * 
 * @author Dominik
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
@WebService(endpointInterface = "feukora.webservice.rmi.FeuerungsrapportService")
public class FeuerungsrapportServiceImpl implements FeuerungsrapportService {

	 private AuftragRO auftragRO;
	 private BenutzerRO benutzerRO;
	 private BrennerRO brennerRO;
	 private FeuerungsanlageRO feuerungsanlageRO;
	 private KontaktRO kontaktRO;
	 private LiegenschaftRO liegenschaftRO;
	 private MessungRO messungRO;
	 private MitarbeiterRO mitarbeiterRO;
	 private OrtRO ortRO;
	 private WaermeerzeugerRO waermeerzeugerRO;


	public FeuerungsrapportServiceImpl() throws Exception {

		String AuftragROName = "Auftrag";
		String BenutzerROName = "Benutzer";
		String BrennerROName = "Brenner";
		String FeuerungsanlageROName = "Feuerungsanlage";
		String KontaktROName = "Kontakt";
		String MessungsROName = "Messung";
		String MitarbeiterROName = "Mitarbeiter";
		String LiegenschaftROName = "Liegenschaft";
		String OrtROName = "Ort";
		String WaermeerzeugerROName = "Waermerzeuger";

		/*
		 * Host-IP und RMI-Port definieren (an sich würde man diese Angaben aus
		 * der Property-Datei einlesen)
		 */
		String hostIp = "localhost";
		int rmiPort = 10090;
		
		
		Properties dbProperties = new Properties();
		

		// SecurityManager braucht nicht installiert zu werden, da Tomcat einen
		// eigenen SecurityManager hat
		try {

			/* Properties laden */
//			Properties props = new Properties();
//
//			InputStream is = FeuerungsrapportServiceImpl.class.getClassLoader()
//					.getResourceAsStream("webserver.properties");
//
//			props.load(is);

//			hostIp = props.getProperty("rmi.server_ip");
//			rmiPort = Integer.parseInt(props.getProperty("rmi.server_port"));

			// URLs definieren
			String urlAuftragRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ AuftragROName;
			String urlBenutzerRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ BenutzerROName;
			String urlBrennerRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ BrennerROName;
			String urlFeuerungsanlageRO = "rmi://" + hostIp + ":" + rmiPort
					+ "/" + FeuerungsanlageROName;
			String urlKontaktRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ KontaktROName;
			String urlMessungRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ MessungsROName;
			String urlMitarbeiterRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ MitarbeiterROName;
			String urlLiegenschaftRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ LiegenschaftROName;
			String urlOrtRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ OrtROName;
			String urlWaermeerzeugerRO = "rmi://" + hostIp + ":" + rmiPort
					+ "/" + WaermeerzeugerROName;
			
			/* Lookup */
			auftragRO = (AuftragRO) Naming.lookup(urlAuftragRO);
			benutzerRO = (BenutzerRO) Naming.lookup(urlBenutzerRO);
			brennerRO = (BrennerRO) Naming.lookup(urlBrennerRO);
			feuerungsanlageRO = (FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
			kontaktRO = (KontaktRO) Naming.lookup(urlKontaktRO);
			messungRO = (MessungRO) Naming.lookup(urlMessungRO);
			mitarbeiterRO = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);
			liegenschaftRO = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
			ortRO = (OrtRO) Naming.lookup(urlOrtRO);
			waermeerzeugerRO = (WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);

		} catch (Exception e) {
		throw e;
		}
	}
	
	// -----------------------------------------------------------------------------------------------
	// Auftrag
	// -----------------------------------------------------------------------------------------------

	@Override
	public Auftrag addAuftrag(Auftrag entity) throws Exception {
		return auftragRO.add(entity);
	}

	@Override
	public Auftrag updateAuftrag(Auftrag entity) throws Exception {
		return auftragRO.update(entity);
	}

	@Override
	public void deleteAuftrag(Auftrag entity) throws Exception {
		auftragRO.delete(entity);
	}

	@Override
	public List<Auftrag> findAllAuftrag() throws Exception {
		return auftragRO.findAll();
	}

	@Override
	public List<Auftrag> findAuftragByMitarbeiter(Mitarbeiter mitarbeiter)
			throws Exception {
		return auftragRO.findByMitarbeiter(mitarbeiter);
	}

	@Override
	public List<Auftrag> findAuftragByKontakt(Kontakt kontakt) throws Exception {
		return auftragRO.findByKontakt(kontakt);
	}

	@Override
	public List<Auftrag> findAuftragByLiegenschaft(Liegenschaft liegenschaft)
			throws Exception {
		return auftragRO.findByLiegenschaft(liegenschaft);
	}

	@Override
	public Auftrag findAuftragByAuftragsNummer(Integer auftragsNummer)
			throws Exception {
		return auftragRO.findByAuftragsNummer(auftragsNummer);
	}

	@Override
	public List<Auftrag> findAuftragByDatum(GregorianCalendar datum)
			throws Exception {
		return auftragRO.findByDatum(datum);
	}
	@Override
	public void deleteAuftragById(Integer auftragsNummer) throws Exception {
	}

	@Override
	public List<Auftrag> findAuftragByDateAndMitarbeiter(
			GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter) throws Exception {
		return auftragRO.findByDateAndMitarbeiter(startdatum, enddatum,
				mitarbeiter);
	}

	// -----------------------------------------------------------------------------------------------
	// Benutzer
	// -----------------------------------------------------------------------------------------------

	@Override
	public Benutzer findBenutzerById(Integer idUser) throws Exception {
		return benutzerRO.findById(idUser);
	}

	@Override
	public List<Benutzer> findAllBenutzer() throws Exception {
		return benutzerRO.findAll();
	}

	@Override
	public List<Benutzer> findBenutzerByUsername(String username)
			throws Exception {
		return benutzerRO.findByUsername(username);
	}

	@Override
	public List<Benutzer> findBenutzerByUsernamePassword(String username, String password)
			throws Exception {
		return benutzerRO.findByUsernamePassword(username, password);
	}

	// -----------------------------------------------------------------------------------------------
	// Brenner
	// -----------------------------------------------------------------------------------------------

	@Override
	public Brenner addBrenner(Brenner entity) throws Exception {
		return brennerRO.add(entity);
	}

	@Override
	public Brenner updateBrenner(Brenner entity) throws Exception {
		return brennerRO.update(entity);
	}

	@Override
	public void deleteBrenner(Brenner entity) throws Exception {
	}

	@Override
	public List<Brenner> findAllBrenner() throws Exception {
		return brennerRO.findAll();
	}

	@Override
	public List<Brenner> findBrennerByTyp(String brennerTyp) throws Exception {
		return brennerRO.findByTyp(brennerTyp);
	}

	@Override
	public List<Brenner> findBrennerByArt(int brennerArt) throws Exception {
		return brennerRO.findByArt(brennerArt);
	}

	@Override
	public void deleteBrennerById(Integer idBrenner) throws Exception {
	}

	@Override
	public Brenner findBrennerById(Integer idBrenner) throws Exception {
		return brennerRO.findById(idBrenner);
	}

	@Override
	public List<Brenner> findBrennerByBaujahr(int baujahr) throws Exception {
		return brennerRO.findByBaujahr(baujahr);
	}
	// -----------------------------------------------------------------------------------------------
	// Feuerungsanlage
	// -----------------------------------------------------------------------------------------------
	@Override
	public Feuerungsanlage addFeuerungsanlage(Feuerungsanlage entity)
			throws Exception {
		return feuerungsanlageRO.add(entity);
	}

	@Override
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity)
			throws Exception {
		return feuerungsanlageRO.update(entity);
	}

	@Override
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception {
	}

	@Override
	public List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception {
		return feuerungsanlageRO.findAll();
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByLiegenschaft(
			Liegenschaft liegenschaft) throws Exception {
		return feuerungsanlageRO.findByLiegenschaft(liegenschaft);
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByBrenner(Brenner brenner)
			throws Exception {
		return feuerungsanlageRO.findByBrenner(brenner);
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger) throws Exception {
		return feuerungsanlageRO.findByWaermeerzeuger(waermeerzeuger);
	}

	@Override
	public void deleteFeuerungsanlageById(Integer idFeuerungsanlage)
			throws Exception {
	}

	@Override
	public Feuerungsanlage findFeuerungsanlageById(Integer idFeuerungsanlage)
			throws Exception {
		return feuerungsanlageRO.findById(idFeuerungsanlage);
	}
	// -----------------------------------------------------------------------------------------------
	// Kontakt
	// -----------------------------------------------------------------------------------------------

	@Override
	public Kontakt addKontakt(Kontakt entity) throws Exception {
		return kontaktRO.add(entity);
	}

	@Override
	public Kontakt updateKontakt(Kontakt entity) throws Exception {
		return kontaktRO.update(entity);
	}

	@Override
	public void deleteKontakt(Kontakt entity) throws Exception {
	}

	@Override
	public List<Kontakt> findAllKontakt() throws Exception {
		return kontaktRO.findAll();
	}

	@Override
	public List<Kontakt> findKontaktByName(String name) throws Exception {
		return kontaktRO.findByName(name);
	}

	@Override
	public List<Kontakt> findKontaktByVorname(String vorname) throws Exception {
		return kontaktRO.findByVorname(vorname);
	}

	@Override
	public List<Kontakt> findKontaktByOrt(Ort ort) throws Exception {
		return kontaktRO.findByOrt(ort);
	}

	@Override
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern)
			throws Exception {
		return kontaktRO.findByRolleExtern(rolleExtern);
	}

	@Override
	public void deleteKontaktById(Integer idKontakt) throws Exception {
	}

	@Override
	public Kontakt findKontaktById(Integer idKontakt) throws Exception {
		return kontaktRO.findById(idKontakt);
	}

	@Override
	public List<Kontakt> findKontaktByStrasse(String strasse) throws Exception {
		return kontaktRO.findByStrasse(strasse);
	}

	// -----------------------------------------------------------------------------------------------
	// Liegenschaft
	// -----------------------------------------------------------------------------------------------

	@Override
	public Liegenschaft addLiegenschaft(Liegenschaft entity) throws Exception {
		return liegenschaftRO.add(entity);
	}

	@Override
	public Liegenschaft updateiegenschaft(Liegenschaft entity) throws Exception {
		return liegenschaftRO.update(entity);
	}

	@Override
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception {
	}

	@Override
	public void deleteLiegenschaftById(Integer idLiegenschaft) throws Exception {
	}

	@Override
	public List<Liegenschaft> findAllLiegenschaft() throws Exception {
		return liegenschaftRO.findAll();
	}

	@Override
	public Liegenschaft findLiegenschaftById(Integer idLiegenschaft)
			throws Exception {
		return liegenschaftRO.findById(idLiegenschaft);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt)
			throws Exception {
		return liegenschaftRO.findByKontakt(kontakt);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort) throws Exception {
		return liegenschaftRO.findByOrt(ort);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse)
			throws Exception {
		return liegenschaftRO.findByStrasse(strasse);
	}

	// -----------------------------------------------------------------------------------------------
	// Messung
	// -----------------------------------------------------------------------------------------------

	@Override
	public Messung addMessung(Messung entity) throws Exception {
		return messungRO.add(entity);
	}

	@Override
	public Messung updateMessung(Messung entity) throws Exception {
		return messungRO.update(entity);
	}

	@Override
	public void deleteMessung(Messung entity) throws Exception {
	}

	@Override
	public void deleteMessungById(Integer idMessung) throws Exception {
	}

	@Override
	public Messung findMessungById(Integer idMessung) throws Exception {
		return messungRO.findById(idMessung);
	}

	@Override
	public List<Messung> findAllMessung() throws Exception {
		return messungRO.findAll();
	}

	@Override
	public List<Messung> findMessungByDatum(GregorianCalendar messDatum)
			throws Exception {
		return messungRO.findByDatum(messDatum);
	}

	@Override
	public List<Messung> findMessungByBeurteilungNotOk(boolean beurteilungNotOk)
			throws Exception {
		return messungRO.findByBeurteilungNotOk(beurteilungNotOk);
	}

	// -----------------------------------------------------------------------------------------------
	// Mitarbeiter
	// -----------------------------------------------------------------------------------------------

	@Override
	public Mitarbeiter findMitarbeiterById(Integer idMitarbeiter)
			throws Exception {
		return mitarbeiterRO.findById(idMitarbeiter);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByName(String name) 
			throws Exception {
		return mitarbeiterRO.findByName(name);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname)
			throws Exception {
		return mitarbeiterRO.findByVorname(vorname);
	}
	
	@Override
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name,
			String vorname) throws Exception {
		return mitarbeiterRO.findByNameVorname(name, vorname);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse)
			throws Exception {
		return mitarbeiterRO.findByStrasse(strasse);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort) throws Exception {
		return mitarbeiterRO.findByOrt(ort);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user)
			throws Exception {
		return mitarbeiterRO.findByBenutzer(user);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			GregorianCalendar arbeitetSeit) throws Exception {
		return mitarbeiterRO.findByArbeitetSeit(arbeitetSeit);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			GregorianCalendar arbeitetBis) throws Exception {
		return mitarbeiterRO.findByArbeitetBis(arbeitetBis);
	}

	// -----------------------------------------------------------------------------------------------
	// Ort
	// -----------------------------------------------------------------------------------------------
	@Override
	public Ort addOrt(Ort entity) throws Exception {
		return ortRO.add(entity);
	}

	@Override
	public Ort updateOrt(Ort entity) throws Exception {
		return ortRO.update(entity);
	}

	@Override
	public void deleteOrt(Ort entity) throws Exception {
	}

	@Override
	public void deleteOrtById(Integer id) throws Exception {
	}

	@Override
	public Ort findOrtById(Integer id) throws Exception {
		return ortRO.findById(id);
	}

	@Override
	public List<Ort> findOrtByOrtBez(String ortBez) throws Exception {
		return ortRO.findByOrtBez(ortBez);
	}

	@Override
	public List<Ort> findOrtByPlz(int plz) throws Exception {
		return ortRO.findByOrtPlz(plz);
	}

	@Override
	public List<Ort> findAllOrt() throws Exception {
		return ortRO.findAll();
	}

	// -----------------------------------------------------------------------------------------------
	// Wärmeerzeuger
	// -----------------------------------------------------------------------------------------------
	@Override
	public Waermeerzeuger addWaermeerzeuger(Waermeerzeuger entity)
			throws Exception {
		return waermeerzeugerRO.add(entity);
	}

	@Override
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity)
			throws Exception {
		return waermeerzeugerRO.update(entity);
	}

	@Override
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception {
	}

	@Override
	public void deleteWaermeerzeugerById(Integer idWaermeerzeuger)
			throws Exception {
	}

	@Override
	public Waermeerzeuger findWaermeerzeugerById(Integer id) throws Exception {
		return waermeerzeugerRO.findById(id);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception {
		return waermeerzeugerRO.findAllWaermeerzeuger();
	}
	
	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByTyp(String waermeerzeugerTyp)
			throws Exception {
		return waermeerzeugerRO.findByTyp(waermeerzeugerTyp);
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff)
			throws Exception {
		return waermeerzeugerRO.findByBrennstoff(brennstoff);
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr)
			throws Exception {
		return waermeerzeugerRO.findByBaujahr(baujahr);
	}
}
