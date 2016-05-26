package feukora.webservice.rmi;

/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 *
 * Copyright (c) Dominik Stirnimann
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

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
import entitys.*;

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

	private AuftragRO auftragManager;
	private BenutzerRO benutzerManager;
	private BrennerRO brennerManager;
	private FeuerungsanlageRO feuerungsanlageManager;
	private KontaktRO kontaktManager;
	private LiegenschaftRO liegenschaftManager;
	private MessungRO messungManager;
	private MitarbeiterRO mitarbeiterManager;
	private OrtRO ortManager;
	private WaermeerzeugerRO waermeerzeugerManager;

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
		String WaermeerzeugerROName = "Waermeerzeuger";

		try {

			//Properties Objekt erstellen
			Properties webserverProperties = new Properties();

			//Klassenloader holen
			ClassLoader cLoader = FeuerungsrapportServiceImpl.class.getClassLoader();

			//Properties laden
			try {
				webserverProperties.load(cLoader
						.getResourceAsStream("webserver.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			//Port RMI auslesen
			String stringPort = webserverProperties.getProperty("rmiPort");
			Integer rmiPort = Integer.valueOf(stringPort);


			String hostIp = webserverProperties.getProperty("rmiIp");

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
			auftragManager = (AuftragRO) Naming.lookup(urlAuftragRO);
			benutzerManager = (BenutzerRO) Naming.lookup(urlBenutzerRO);
			brennerManager = (BrennerRO) Naming.lookup(urlBrennerRO);
			feuerungsanlageManager = (FeuerungsanlageRO) Naming.lookup(urlFeuerungsanlageRO);
			kontaktManager = (KontaktRO) Naming.lookup(urlKontaktRO);
			messungManager = (MessungRO) Naming.lookup(urlMessungRO);
			mitarbeiterManager = (MitarbeiterRO) Naming.lookup(urlMitarbeiterRO);
			liegenschaftManager = (LiegenschaftRO) Naming.lookup(urlLiegenschaftRO);
			ortManager = (OrtRO) Naming.lookup(urlOrtRO);
			waermeerzeugerManager = (WaermeerzeugerRO) Naming.lookup(urlWaermeerzeugerRO);

			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Endpoint.publish("http://localhost:1234/test", new FeuerungsrapportServiceImpl());
	}

	// -----------------------------------------------------------------------------------------------
	// Auftrag
	// -----------------------------------------------------------------------------------------------

	@Override
	public Auftrag addAuftrag(Auftrag auftrag) throws Exception {
		return auftragManager.add(auftrag);
	}

	@Override
	public Auftrag updateAuftrag(Auftrag auftrag) throws Exception {
		return auftragManager.update(auftrag);
	}

	@Override
	public List<Auftrag> findAllAuftrag() throws Exception {
		return auftragManager.findAll();
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
	public List<Auftrag> findAuftragByDatum(GregorianCalendar datum)
			throws Exception {
		return auftragManager.findByDatum(datum);
	}
	@Override
	public List<Auftrag> findAuftragByDateAndMitarbeiter(GregorianCalendar startdatum,
			GregorianCalendar enddatum, Mitarbeiter mitarbeiter) throws Exception {

		return auftragManager.findByDateAndMitarbeiter(startdatum, enddatum, mitarbeiter);
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
	public List<Benutzer> findBenutzerByUsernamePassword(String username, String password)
			throws Exception {
		return benutzerManager.findByUsernamePassword(username, password);
	}

	// -----------------------------------------------------------------------------------------------
	// Brenner
	// -----------------------------------------------------------------------------------------------

	@Override
	public Brenner addBrenner(Brenner brenner) throws Exception {
		return brennerManager.add(brenner);
	}

	@Override
	public Brenner updateBrenner(Brenner brenner) throws Exception {
		return brennerManager.update(brenner);
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
	public Feuerungsanlage addFeuerungsanlage(Feuerungsanlage feuerungsanlage)
			throws Exception {
		return feuerungsanlageManager.add(feuerungsanlage);
	}

	@Override
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage feuerungsanlage)
			throws Exception {
		return feuerungsanlageManager.update(feuerungsanlage);
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
	public Feuerungsanlage findFeuerungsanlageById(Integer idFeuerungsanlage)
			throws Exception {
		return feuerungsanlageManager.findById(idFeuerungsanlage);
	}
	// -----------------------------------------------------------------------------------------------
	// Kontakt
	// -----------------------------------------------------------------------------------------------

	@Override
	public Kontakt addKontakt(Kontakt kontakt) throws Exception {
		return kontaktManager.add(kontakt);
	}

	@Override
	public Kontakt updateKontakt(Kontakt kontakt) throws Exception {
		return kontaktManager.update(kontakt);
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
	public List<Kontakt> findAllKontakte() throws Exception {
		return kontaktManager.findAll();
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
	public Liegenschaft addLiegenschaft(Liegenschaft liegenschaft) throws Exception {
		return liegenschaftManager.add(liegenschaft);
	}

	@Override
	public Liegenschaft updatLiegenschaft(Liegenschaft liegenschaft) throws Exception {
		return liegenschaftManager.update(liegenschaft);
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
	public Messung addMessung(Messung messung) throws Exception {
		return messungManager.add(messung);
	}

	@Override
	public Messung updateMessung(Messung messung) throws Exception {
		return messungManager.update(messung);
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
	public Ort addOrt(Ort ort) throws Exception {
		return ortManager.add(ort);
	}

	@Override
	public Ort updateOrt(Ort ort) throws Exception {
		return ortManager.update(ort);
	}

	@Override
	public Ort findOrtById(Integer idOrt) throws Exception {
		return ortManager.findById(idOrt);
	}

	@Override
	public List<Ort> findOrtByOrtBez(String ortBez) throws Exception {
		return ortManager.findByOrtBez(ortBez);
	}

	@Override
	public List<Ort> findOrtByPlz(int plz) throws Exception {
		return ortManager.findByOrtPlz(plz);
	}

	@Override
	public List<Ort> findAllOrt() throws Exception {
		return ortManager.findAll();
	}

	// -----------------------------------------------------------------------------------------------
	// Wärmeerzeuger
	// -----------------------------------------------------------------------------------------------
	@Override
	public Waermeerzeuger addWaermeerzeuger(Waermeerzeuger waermeerzeuger)
			throws Exception {
		return waermeerzeugerManager.add(waermeerzeuger);
	}

	@Override
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger waermeerzeuger)
			throws Exception {
		return waermeerzeugerManager.update(waermeerzeuger);
	}

	@Override
	public Waermeerzeuger findWaermeerzeugerById(Integer idWaermeerzeuger) throws Exception {
		return waermeerzeugerManager.findById(idWaermeerzeuger);
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

	//----------------------------------------------------------------------------
	// Nur für Testzwecken
	// edit: Luca Raneri
    //----------------------------------------------------------------------------
	
	@Override
	public void deleteBenutzer(Benutzer benutzer) throws Exception {
		benutzerManager.delete(benutzer);
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() throws Exception {
		return mitarbeiterManager.findAllMitarbeiter();
	}

	@Override
	public void deleteMessung(Messung messung) throws Exception {
		messungManager.delete(messung);
	}

	@Override
	public void deleteMessungById(Integer idMessung) throws Exception {
		messungManager.deleteById(idMessung);
	}

	@Override
	public void deleteMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
		mitarbeiterManager.delete(mitarbeiter);
	}

	@Override
	public void deleteOrt(Ort ort) throws Exception {
		ortManager.delete(ort);
	}

	@Override
	public void deleteOrtById(Integer idOrt) throws Exception {
		ortManager.deleteById(idOrt);
	}

	@Override
	public void deleteWaermeerzeuger(Waermeerzeuger waermeerzeuger) throws Exception {
		waermeerzeugerManager.delete(waermeerzeuger);
	}

	@Override
	public void deleteWaermeerzeugerById(Integer idWaermeerzeuger) throws Exception {
		waermeerzeugerManager.deleteById(idWaermeerzeuger);
	}

	@Override
	public void deleteAuftrag(Auftrag auftrag) throws Exception {
		auftragManager.delete(auftrag);
	}

	@Override
	public void deleteAuftragById(Integer auftragsNummer) throws Exception {
		auftragManager.deleteById(auftragsNummer);
	}

	@Override
	public void deleteBrenner(Brenner brenner) throws Exception {
		brennerManager.delete(brenner);
	}

	@Override
	public void deleteBrennerById(Integer idBrenner) throws Exception {
		brennerManager.deleteById(idBrenner);
	}

	@Override
	public void deleteFeuerungsanlage(Feuerungsanlage feuerungsanlage) throws Exception {
		feuerungsanlageManager.delete(feuerungsanlage);
	}

	@Override
	public void deleteFeuerungsanlageById(Integer idFeuerungsanlage) throws Exception {
		feuerungsanlageManager.deleteById(idFeuerungsanlage);
	}

	@Override
	public void deleteKontakt(Kontakt kontakt) throws Exception {
		kontaktManager.delete(kontakt);
	}

	@Override
	public void deleteKontaktById(Integer idKontakt) throws Exception {
		kontaktManager.deleteById(idKontakt);
	}

	@Override
	public void deleteLiegenschaft(Liegenschaft liegenschaft) throws Exception {
		liegenschaftManager.delete(liegenschaft);
	}

	@Override
	public void deleteLiegenschaftById(Integer idLiegenschaft) throws Exception {
		liegenschaftManager.deleteById(idLiegenschaft);
	}

	@Override
	public Benutzer addBenutzer(Benutzer benutzer) throws Exception {
		return benutzerManager.add(benutzer);
	}

	@Override
	public Mitarbeiter addMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
		return mitarbeiterManager.add(mitarbeiter);
	}

	@Override
	public Benutzer updateBenutzer(Benutzer benutzer) throws Exception {
		return benutzerManager.update(benutzer);
	}

	@Override
	public Mitarbeiter updateMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
		return mitarbeiterManager.update(mitarbeiter);
	}

	@Override
	public void deleteMitarbeiterById(Integer idMitarbeiter) throws Exception {
		mitarbeiterManager.deleteById(idMitarbeiter);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByRolleIntern(int rolleIntern) throws Exception {
		return mitarbeiterManager.findByRolleIntern(rolleIntern);
	}
}
