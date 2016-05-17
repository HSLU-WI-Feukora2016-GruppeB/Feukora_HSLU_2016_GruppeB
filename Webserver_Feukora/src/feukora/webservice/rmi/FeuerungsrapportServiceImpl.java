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

import entitäten.Auftrag;
import entitäten.Benutzer;
import entitäten.Brenner;
import entitäten.Feuerungsanlage;
import entitäten.Kontakt;
import entitäten.Liegenschaft;
import entitäten.Messung;
import entitäten.Mitarbeiter;
import entitäten.Ort;
import entitäten.Waermeerzeuger;
import managerInterfaces.*;

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

	// private AuftragRO AuftragManager;
	// private BenutzerRO BenutzerManager;
	// private BrennerRO BrennerManager;
	// private FeuerungsanlageRO FeuerungsanlageManager;
	// private KontaktRO KontaktManager;
	// private LiegenschaftRO LiegenschaftManager;
	// private MessungRO MessungManager;
	// private MitarbeiterRO MitarbeiterManager;
	// private OrtManagerRo OrtManager;
	// private WaermeerzeugerRO waermeerzeugerManager;

	private AuftragManager auftragManager;
	private BenutzerManager benutzerManager;
	private BrennerManager brennerManager;
	private FeuerungsanlageManager feuerungsanlageManager;
	private KontaktManager kontaktManager;
	private LiegenschaftManager liegenschaftManager;
	private MessungsManager messungManager;
	private MitarbeiterManager mitarbeiterManager;
	private OrtManager ortManager;
	private WaermeerzeugerManager waermeerzeugerManager;

	public FeuerungsrapportServiceImpl() throws Exception {

		String AuftragROName = "AuftragRO";
		String BenutzerROName = "BenutzerRO";
		String BrennerROName = "BrennerRO";
		String FeuerungsanlageROName = "FeuerungsanlageRO";
		String KontaktROName = "KontaktRO";
		String MessungsROName = "MessungsRO";
		String MitarbeiterROName = "MitarbeiterRO";
		String LiegenschaftROName = "LiegenschaftRO";
		String OrtROName = "OrtRO";
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
			String urlAuftragRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ AuftragROName;
			String urlBenutzerRO = "rmi://" + hostIp + ":" + rmiPort + "/"
					+ AuftragROName;
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
			AuftragManager = (AuftragRO) Naming.lookup(urlAuftragRO);
			BenutzerManager = (BenutzerRO) Naming.lookup(urlBenutzerRO);
			BrennerManager = (BrennerRO) Naming.lookup(urlBrennerRO);
			FeuerungsanlageManager = (FeuerungsanlageRO) Naming
					.lookup(urlFeuerungsanlageRO);
			KontaktManager = (KontaktRO) Naming.lookup(urlKontaktRO);
			MessungManager = (MessungRO) Naming.lookup(urlMessungRO);
			MitarbeiterManager = (MitarbeiterRO) Naming
					.lookup(urlMitarbeiterRO);
			LiegenschaftManager = (LiegenschaftRO) Naming
					.lookup(urlLiegenschaftRO);
			OrtManager = (OrtRO) Naming.lookup(urlOrtRO);
			WaermeerzeugerManager = (WaermeerzeugerRO) Naming
					.lookup(urlWaermeerzeugerRO);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
	}

	// -----------------------------------------------------------------------------------------------
	// Auftrag
	// -----------------------------------------------------------------------------------------------

	@Override
	public Auftrag addAuftrag(Auftrag entity) throws Exception {
		return auftragManager.add(entity);
	}

	@Override
	public Auftrag updateAuftrag(Auftrag entity) throws Exception {
		return auftragManager.update(entity);
	}

	@Override
	public void deleteAuftrag(Auftrag entity) throws Exception {
	}

	@Override
	public List<Auftrag> findAllAuftrag() throws Exception {
		return auftragManager.findAll();
	}

	@Override
	public List<Auftrag> findAuftragByDatum(GregorianCalender datum)
			throws Exception {
		return auftragManager.findByDatum(datum);
	}

	@Override
	public List<Auftrag> findAuftragByMitarbeiter(Mitarbeiter mitarbeiter)
			throws Exception {
		return auftragManager.findByMitarbeiter(mitarbeiter);
	}

	@Override
	public List<Auftrag> findAuftragByKontakt(Kontakt kontakt) throws Exception {
		return auftragManager.findByKontakt(kontakt);
	}

	@Override
	public List<Auftrag> findAuftragByLiegenschaft(Liegenschaft liegenschaft)
			throws Exception {
		return auftragManager.findByLiegenschaft(liegenschaft);
	}

	@Override
	public Auftrag findAuftragByAuftragsNummer(Integer auftragsNummer)
			throws Exception {
		return auftragManager.findByAuftragsNummer(auftragsNummer);
	}

	@Override
	public void deleteAuftragById(Integer auftragsNummer) throws Exception {
	}

	@Override
	public List<Auftrag> findAuftragByDateAndMitarbeiter(
			GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter) {
		return auftragManager.findByDateAndMitarbeiter(startdatum, enddatum,
				mitarbeiter);
	}

	// -----------------------------------------------------------------------------------------------
	// Benutzer
	// -----------------------------------------------------------------------------------------------

	@Override
	public Benutzer findBenutzerById(Integer idUser) throws Exception {
		return benutzerManager.findById(idUser);
	}

	@Override
	public List<Benutzer> findAllBenutzer() throws Exception {
		return benutzerManager.findAll();
	}

	@Override
	public List<Benutzer> findBenutzerByUsername(String username)
			throws Exception {
		return benutzerManager.findByUsername(username);
	}

	@Override
	public List<Benutzer> findBenutzerByPassword(String password)
			throws Exception {
		return benutzerManager.findByPassword(password);
	}

	// -----------------------------------------------------------------------------------------------
	// Brenner
	// -----------------------------------------------------------------------------------------------

	@Override
	public Brenner addBrenner(Brenner entity) throws Exception {
		return brennerManager.add(entity);
	}

	@Override
	public Brenner updateBrenner(Brenner entity) throws Exception {
		return brennerManager.update(entity);
	}

	@Override
	public void deleteBrenner(Brenner entity) throws Exception {
	}

	@Override
	public List<Brenner> findAllBrenner() throws Exception {
		return brennerManager.findAll();
	}

	@Override
	public List<Brenner> findBrennerByTyp(String brennerTyp) throws Exception {
		return brennerManager.findByTyp(brennerTyp);
	}

	@Override
	public List<Brenner> findBrennerByArt(int brennerArt) throws Exception {
		return brennerManager.findByArt(brennerArt);
	}

	@Override
	public void deleteBrennerById(Integer idBrenner) throws Exception {
	}

	@Override
	public Brenner findBrennerById(Integer idBrenner) throws Exception {
		return brennerManager.findById(idBrenner);
	}

	@Override
	public List<Brenner> findBrennerByBaujahr(int baujahr) throws Exception {
		return brennerManager.findByBaujahr(baujahr);
	}

	// -----------------------------------------------------------------------------------------------
	// Feuerungsanlage
	// -----------------------------------------------------------------------------------------------

	@Override
	public Feuerungsanlage addFeuerungsanlage(Feuerungsanlage entity)
			throws Exception {
		return feuerungsanlageManager.add(entity);
	}

	@Override
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity)
			throws Exception {
		return feuerungsanlageManager.update(entity);
	}

	@Override
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception {
	}

	@Override
	public List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception {
		return feuerungsanlageManager.findAll();
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByLiegenschaft(
			Liegenschaft liegenschaft) throws Exception {
		return feuerungsanlageManager.findByLiegenschaft(liegenschaft);
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByBrenner(Brenner brenner)
			throws Exception {
		return feuerungsanlageManager.findByBrenner(brenner);
	}

	@Override
	public List<Feuerungsanlage> findFeuerungsanlageByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger) throws Exception {
		return feuerungsanlageManager.findByWaermeerzeuger(waermeerzeuger);
	}

	@Override
	public void deleteFeuerungsanlageById(Integer idFeuerungsanlage)
			throws Exception {
	}

	@Override
	public Feuerungsanlage findFeuerungsanlageById(Integer idFeuerungsanlage)
			throws Exception {
		return feuerungsanlageManager.findById(idFeuerungsanlage);
	}

	// -----------------------------------------------------------------------------------------------
	// Kontakt
	// -----------------------------------------------------------------------------------------------

	@Override
	public Kontakt addKontakt(Kontakt entity) throws Exception {
		return kontaktManager.add(entity);
	}

	@Override
	public Kontakt updateKontakt(Kontakt entity) throws Exception {
		return kontaktManager.update(entity);
	}

	@Override
	public void deleteKontakt(Kontakt entity) throws Exception {
	}

	@Override
	public List<Kontakt> findAllKontakt() throws Exception {
		return kontaktManager.findAll();
	}

	@Override
	public List<Kontakt> findKontaktByName(String name) throws Exception {
		return kontaktManager.findByName(name);
	}

	@Override
	public List<Kontakt> findKontaktByVorname(String vorname) throws Exception {
		return kontaktManager.findByVorname(vorname);
	}

	@Override
	public List<Kontakt> findKontaktByOrt(Ort ort) throws Exception {
		return kontaktManager.findByOrt(ort);
	}

	@Override
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern)
			throws Exception {
		return kontaktManager.findByRolleExtern(rolleExtern);
	}

	@Override
	public void deleteKontaktById(Integer idKontakt) throws Exception {
	}

	@Override
	public Kontakt findKontaktById(Integer idKontakt) throws Exception {
		return kontaktManager.findById(idKontakt);
	}

	@Override
	public List<Kontakt> findKontaktByStrasse(String strasse) throws Exception {
		return kontaktManager.findByStrasse(strasse);
	}

	// -----------------------------------------------------------------------------------------------
	// Liegenschaft
	// -----------------------------------------------------------------------------------------------

	@Override
	public Liegenschaft addLiegenschaft(Liegenschaft entity) throws Exception {
		return liegenschaftManager.add(entity);
	}

	@Override
	public Liegenschaft updateiegenschaft(Liegenschaft entity) throws Exception {
		return liegenschaftManager.update(entity);
	}

	@Override
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception {
	}

	@Override
	public void deleteLiegenschaftById(Integer idLiegenschaft) throws Exception {
	}

	@Override
	public List<Liegenschaft> findAllLiegenschaft() throws Exception {
		return liegenschaftManager.findAll();
	}

	@Override
	public Liegenschaft findLiegenschaftById(Integer idLiegenschaft)
			throws Exception {
		return liegenschaftManager.findById(idLiegenschaft);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt)
			throws Exception {
		return liegenschaftManager.findByKontakt(kontakt);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort) throws Exception {
		return liegenschaftManager.findByOrt(ort);
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse)
			throws Exception {
		return liegenschaftManager.findByStrasse(strasse);
	}

	// -----------------------------------------------------------------------------------------------
	// Messung
	// -----------------------------------------------------------------------------------------------

	@Override
	public Messung addMessung(Messung entity) throws Exception {
		return messungManager.add(entity);
	}

	@Override
	public Messung updateMessung(Messung entity) throws Exception {
		return messungManager.update(entity);
	}

	@Override
	public void deleteMessung(Messung entity) throws Exception {
	}

	@Override
	public void deleteMessungById(Integer idMessung) throws Exception {
	}

	@Override
	public Messung findMessungById(Integer idMessung) throws Exception {
		return messungManager.findById(idMessung);
	}

	@Override
	public List<Messung> findAllMessung() throws Exception {
		return messungManager.findAll();
	}

	@Override
	public List<Messung> findMessungByDatum(GregorianCalendar messDatum)
			throws Exception {
		return messungManager.findByDatum(messDatum);
	}

	@Override
	public List<Messung> findMessungByBeurteilungNotOk(boolean beurteilungNotOk)
			throws Exception {
		return messungManager.findByBeurteilungNotOk(beurteilungNotOk);
	}

	// -----------------------------------------------------------------------------------------------
	// Mitarbeiter
	// -----------------------------------------------------------------------------------------------

	@Override
	public Mitarbeiter findMitarbeiterById(Integer idMitarbeiter)
			throws Exception {
		return mitarbeiterManager.findById(idMitarbeiter);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByName(String name) 
			throws Exception {
		return mitarbeiterManager.findByName(name);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname)
			throws Exception {
		return mitarbeiterManager.findByVorname(vorname);
	}
	
	@Override
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name,
			String vorname) throws Exception {
		return mitarbeiterManager.findByNameVorname(name, vorname);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse)
			throws Exception {
		return mitarbeiterManager.findByStrasse(strasse);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort) throws Exception {
		return mitarbeiterManager.findByOrt(ort);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user)
			throws Exception {
		return mitarbeiterManager.findByBenutzer(user);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			GregorianCalendar arbeitetSeit) throws Exception {
		return mitarbeiterManager.findByArbeitetSeit(arbeitetSeit);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			GregorianCalendar arbeitetBis) throws Exception {
		return mitarbeiterManager.findByArbeitetBis(arbeitetBis);
	}

	// -----------------------------------------------------------------------------------------------
	// Ort
	// -----------------------------------------------------------------------------------------------
	@Override
	public Ort addOrt(Ort entity) throws Exception {
		return ortManager.add(entity);
	}

	@Override
	public Ort updateOrt(Ort entity) throws Exception {
		return ortManager.update(entity);
	}

	@Override
	public void deleteOrt(Ort entity) throws Exception {
	}

	@Override
	public void deleteOrtById(Integer plz) throws Exception {
	}

	@Override
	public Ort findOrtById(Integer plz) throws Exception {
		return ortManager.findById(plz);
	}

	@Override
	public List<Ort> findOrtByOrtBez(String ortBez) throws Exception {
		return ortManager.findByOrtBez(ortBez);
	}

	@Override
	public List<Ort> findAllOrt() throws Exception {
		return ortManager.findAll();
	}

	// -----------------------------------------------------------------------------------------------
	// Wärmeerzeuger
	// -----------------------------------------------------------------------------------------------
	@Override
	public Waermeerzeuger addWaermeerzeuger(Waermeerzeuger entity)
			throws Exception {
		return waermeerzeugerManager.add(entity);
	}

	@Override
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity)
			throws Exception {
		return waermeerzeugerManager.update(entity);
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
		return waermeerzeugerManager.findById(id);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception {
		return waermeerzeugerManager.findAllWaermeerzeuger();
	}
	
	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByTyp(String waermeerzeugerTyp)
			throws Exception {
		return waermeerzeugerManager.findByTyp(waermeerzeugerTyp);
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff)
			throws Exception {
		return waermeerzeugerManager.findByBrennstoff(brennstoff);
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr)
			throws Exception {
		return waermeerzeugerManager.findByBaujahr(baujahr);
	}
}
