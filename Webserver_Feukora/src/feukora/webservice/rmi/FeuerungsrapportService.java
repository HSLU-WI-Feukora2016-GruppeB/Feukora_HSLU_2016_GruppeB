/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c)
 */
package feukora.webservice.rmi;

import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entitys.*;

/**
 * Interface für Feuerungsrapport-System als Webservice.
 * 
 * @author Dominik
 * @author Luca Raneri
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
@WebService
public interface FeuerungsrapportService {

	// -----------------------------------------------------------------------------------------------
	// Auftrag
	// -----------------------------------------------------------------------------------------------
	
	/**
	 * Speichert einen Auftrag.
	 * 
	 * @param auftrag
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Auftrag addAuftrag(@WebParam(name = "auftrag") Auftrag auftrag)
			throws Exception;

	/**
	 * Passt den übergebenen Auftrag an.
	 * 
	 * @param auftrag
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Auftrag updateAuftrag(@WebParam(name = "auftrag") Auftrag auftrag)
			throws Exception;

	/**
	 * Löscht den übergebenen Auftrag.
	 * 
	 * @param auftrag
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteAuftrag(@WebParam(name = "auftrag") Auftrag auftrag)
			throws Exception;

	/**
	 * Löscht den übergebenen Auftrag mithilfe der auftragsnummer.
	 * 
	 * @param auftragsNummer
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteAuftragById(
			@WebParam(name = "auftragsNummer") Integer auftragsNummer)
			throws Exception;

	/**
	 * Liefert alle Aufträge zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAllAuftrag() throws Exception;

	/**
	 * Liefert eine Auftragliste anhand des gesuchten Terminsdatums.
	 * 
	 * @param datum
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAuftragByDatum(
			@WebParam(name = "datum") GregorianCalendar datum) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter.
	 * 
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAuftragByMitarbeiter(
			@WebParam(name = "mitarbeiter") Mitarbeiter mitarbeiter)
			throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontakts.
	 * 
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAuftragByKontakt(
			@WebParam(name = "kontakt") Kontakt kontakt) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter für eine
	 * bestimmte Arbeitswoche.
	 * 
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAuftragByDateAndMitarbeiter(
			@WebParam(name = "startdatum") GregorianCalendar startdatum,
			@WebParam(name = "enddatum") GregorianCalendar enddatum,
			@WebParam(name = "mitarbeiter") Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * 
	 * @param liegenschaft
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Auftrag> findAuftragByLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Auftrags-Nummer.
	 * 
	 * @param auftragsNummer
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Auftrag findAuftragByAuftragsNummer(
			@WebParam(name = "auftragsNummer") Integer auftragsNummer)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Benutzer
	// -----------------------------------------------------------------------------------------------

	/**
	 * Speichert einen Benutzer.
	 * 
	 * @param benutzer
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Benutzer addBenutzer(@WebParam(name = "benutzer") Benutzer benutzer)
			throws Exception;
	
	/**
	 * Liefert einen Benutzer anhand der gesuchten Benutzer-Id.
	 * 
	 * @param idUser
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Benutzer findBenutzerById(@WebParam(name = "idUser") Integer idUser)
			throws Exception;

	/**
	 * Liefert alle Benutzer zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Benutzer> findAllBenutzer() throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Benutzer> findBenutzerByUsername(
			@WebParam(name = "username") String username) throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Passworts.
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Benutzer> findBenutzerByUsernamePassword(
			@WebParam(name = "username") String username,
			@WebParam(name = "password") String password) throws Exception;
	
	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param benutzer
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteBenutzer(@WebParam(name = "benutzer") Benutzer benutzer)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Brenner
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Brenner.
	 * 
	 * @param brenner
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Brenner addBrenner(@WebParam(name = "brenner") Brenner brenner)
			throws Exception;

	/**
	 * Passt einen Brenner an.
	 * 
	 * @param brenner
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Brenner updateBrenner(@WebParam(name = "brenner") Brenner brenner)
			throws Exception;

	/**
	 * Löscht den mitgegebenen Brenner.
	 * 
	 * @param brenner
	 * @throws Exception
	 */
	@WebMethod
	void deleteBrenner(@WebParam(name = "brenner") Brenner brenner)
			throws Exception;

	/**
	 * Löscht den Brenner mithilfe seiner Id.
	 * 
	 * @param idBrenner
	 * @throws Exception
	 */
	@WebMethod
	void deleteBrennerById(@WebParam(name = "idBrenner") Integer idBrenner)
			throws Exception;

	/**
	 * Liefert Brenner mithilfe seiner Id.
	 * 
	 * @param idBrenner
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Brenner findBrennerById(@WebParam(name = "idBrenner") Integer idBrenner)
			throws Exception;

	/**
	 * Liefert Liste aller Brenner.
	 * 
	 * @return
	 * @throws Exception
	 */

	@WebMethod
	List<Brenner> findAllBrenner() throws Exception;

	/**
	 * Liefert alle Brenner des angefragten Typs.
	 * 
	 * @param brennerTyp
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Brenner> findBrennerByTyp(@WebParam(name = "typ") String brennerTyp)
			throws Exception;

	/**
	 * Liefert alle Brenner der angefragten Art.
	 * 
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Brenner> findBrennerByArt(@WebParam(name = "art") int brennerArt)
			throws Exception;

	/**
	 * Liefert alle Brenner mit angefragtem Baujahr.
	 * 
	 * @param baujahr
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Brenner> findBrennerByBaujahr(@WebParam(name = "baujahr") int baujahr)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Feuerungsanlage
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert eine Feuerungsanlage.
	 * 
	 * @param feuerungsanlage
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Feuerungsanlage addFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage feuerungsanlage)
			throws Exception;

	/**
	 * Passt eine Feuerungsanlage an.
	 * 
	 * @param feuerungsanlage
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Feuerungsanlage updateFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage feuerungsanlage)
			throws Exception;

	/**
	 * Löscht die mitgegebene Feuerungsanlage.
	 * 
	 * @param feuerungsanlage
	 * @throws Exception
	 */
	@WebMethod
	void deleteFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage feuerungsanlage)
			throws Exception;

	/**
	 * Löscht die mitgegebene Feuerungsanlage mithilfe ihrer ID.
	 * 
	 * @param idFeuerungsanlage
	 * @throws Exception
	 */
	@WebMethod
	void deleteFeuerungsanlageById(
			@WebParam(name = "idFeuerungsanlage") Integer idFeuerungsanlage)
			throws Exception;

	/**
	 * Liefert die mitgegebene Feuerungsanlage mithilfe ihrer ID.
	 * 
	 * @param idFeuerungsanlage
	 * @throws Exception
	 */
	@WebMethod
	Feuerungsanlage findFeuerungsanlageById(
			@WebParam(name = "idFeuerungsanlage") Integer idFeuerungsanlage)
			throws Exception;

	/**
	 * Liefert Liste aller Feuerungsanlagen.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen für die gesuchte Liegenschaft.
	 * 
	 * @param brennerTyp
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Feuerungsanlage> findFeuerungsanlageByLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Brenner.
	 * 
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Feuerungsanlage> findFeuerungsanlageByBrenner(
			@WebParam(name = "brenner") Brenner brenner) throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Wärmeerzeuger.
	 * 
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Feuerungsanlage> findFeuerungsanlageByWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger waermeerzeuger)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Kontakt
	// -----------------------------------------------------------------------------------------------

	/**
	 * Speichert einen Kontakt.
	 * 
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Kontakt addKontakt(@WebParam(name = "kontakt") Kontakt kontakt)
			throws Exception;

	/**
	 * Passt einen Kontakt an.
	 * 
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Kontakt updateKontakt(@WebParam(name = "kontakt") Kontakt kontakt)
			throws Exception;

	/**
	 * Löscht den mitgegebenen Kontakt.
	 * 
	 * @param kontakt
	 * @throws Exception
	 */
	@WebMethod
	void deleteKontakt(@WebParam(name = "kontakt") Kontakt kontakt)
			throws Exception;

	/**
	 * Löscht den mitgegebenen Kontakt mithilfe seiner Id.
	 * 
	 * @param idKontakt
	 * @throws Exception
	 */
	@WebMethod
	void deleteKontaktById(@WebParam(name = "idKontakt") Integer idKontakt)
			throws Exception;

	/**
	 * Liefert Liste von Kontakten mit der mitgegebenen ID.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	public Kontakt findKontaktById(
			@WebParam(name = "idKontakt") Integer idKontakt) throws Exception;

	/**
	 * Liefert Liste aller Kontakte.
	 * 
	 * @return
	 */
	@WebMethod
	List<Kontakt> findAllKontakt() throws Exception;

	/**
	 * Liefert alle Kontakt mit gesuchtem Namen.
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findKontaktByName(@WebParam(name = "name") String name)
			throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * 
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findKontaktByVorname(
			@WebParam(name = "vorname") String vorname) throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchtem Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findKontaktByOrt(@WebParam(name = "ort") Ort ort)
			throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchter Rolle.
	 * 
	 * @param rolleExtern
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findKontaktByRolleExtern(
			@WebParam(name = "rolleExtern") int rolleExtern) throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchter Strasse.
	 * 
	 * @param strasse
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findKontaktByStrasse(
			@WebParam(name = "strasse") String strasse) throws Exception;
	
	/**
	 * Liefert alle Kontakte zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Kontakt> findAllKontakte() throws Exception;
	

	// -----------------------------------------------------------------------------------------------
	// Liegenschaft
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert die Liegenschaft.
	 * 
	 * @param liegenschaft
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft addLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Updated die übergebene Entity
	 * 
	 * @param liegenschaft
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft updatLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param liegenschaft
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteLiegenschaft(@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Löscht die übergebene Liegenschaft mithilfe ihrer ID.
	 * 
	 * @param idLiegenschaft
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteLiegenschaftById(
			@WebParam(name = "idLiegenschaft") Integer idLiegenschaft)
			throws Exception;

	/**
	 * Sucht und liefert alle Entity-Objekte zurück
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findAllLiegenschaft() throws Exception;

	/**
	 * Liefert die Liegenschaft die mit der Id angefragt wurde.
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod
	Liegenschaft findLiegenschaftById(
			@WebParam(name = "idLiegenschaft") Integer idLiegenschaft)
			throws Exception;

	/**
	 * Liefert die Liste mit Liegenschaften für den übergebenen Kontakt
	 * (Eigentümer, Verwalter, Hauswart) zurück, falls welche gefunden wurden,
	 * sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findLiegenschaftByKontakt(
			@WebParam(name = "kontakt") Kontakt kontakt) throws Exception;

	/**
	 * Liefert die Liste mit Liegenschaften für dem übergebenen Ort zurück,
	 * falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findLiegenschaftByOrt(@WebParam(name = "ort") Ort ort)
			throws Exception;

	/**
	 * Liefert die Liste mit Liegenschaften für der übergebenen Strasse
	 * zurück, falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findLiegenschaftByStrasse(
			@WebParam(name = "strasse") String strasse) throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Messung
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert eine Messung.
	 * 
	 * @param messung
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Messung addMessung(@WebParam(name = "messung") Messung messung)
			throws Exception;

	/**
	 * Passt die übergebene Messung an.
	 * 
	 * @param messung
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Messung updateMessung(@WebParam(name = "messung") Messung messung)
			throws Exception;

	/**
	 * Löscht die übergebene Messung.
	 * 
	 * @param messung
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteMessung(@WebParam(name = "messung") Messung messung)
			throws Exception;

	/**
	 * Löscht die übergebene Messung mithilfe ihrer Id.
	 * 
	 * @param idMessung
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteMessungById(@WebParam(name = "idMessung") Integer idMessung)
			throws Exception;

	/**
	 * Liefert eine Messungsliste anhand der gesuchten id.
	 * 
	 * @param idMessung
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Messung findMessungById(@WebParam(name = "idMessung") Integer idMessung)
			throws Exception;

	/**
	 * Liefert alle Messungen zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Messung> findAllMessung() throws Exception;

	/**
	 * Liefert eine Messungsliste anhand des gesuchten Messdatums.
	 * 
	 * @param messDatum
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Messung> findMessungByDatum(
			@WebParam(name = "messDatum") GregorianCalendar messDatum)
			throws Exception;

	/**
	 * Liefert alle Messungen wessen Beurteilungen NICHT ok waren (ausserhalb
	 * Grenzwerte).
	 * 
	 * @param beurteilungNotOk
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Messung> findMessungByBeurteilungNotOk(
			@WebParam(name = "beurteilungNotOK") boolean beurteilungNotOk)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Mitarbeiter
	// -----------------------------------------------------------------------------------------------
	
	/**
	 * Speichert einen Mitarbeiter.
	 * 
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Mitarbeiter addMitarbeiter(@WebParam(name = "mitarbeiter") Mitarbeiter mitarbeiter)
			throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findAllMitarbeiter() throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter des angefragten Typs.
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByName(@WebParam(name = "name") String name)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * 
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByVorname(
			@WebParam(name = "vorname") String vorname) throws Exception;

	/**
	 * Liefert den Mitarbeiter zur mitgegebenen Id.
	 * 
	 * @param idMitarbeiter
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Mitarbeiter findMitarbeiterById(
			@WebParam(name = "idMitarbeiter") Integer idMitarbeiter)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Namen und Vornamen.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByNameVorname(
			@WebParam(name = "name") String name,
			@WebParam(name = "vorname") String vorname) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * 
	 * @param strasse
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByStrasse(
			@WebParam(name = "strasse") String strasse) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByOrt(@WebParam(name = "ort") Ort ort)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Benutzernamen.
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByBenutzer(
			@WebParam(name = "username") Benutzer username) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Arbeitsbeginn-Datum.
	 * 
	 * @param arbeitetSeit
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			@WebParam(name = "arbeitetSeit") GregorianCalendar arbeitetSeit)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Kündigungs-Datum.
	 * 
	 * @param arbeitetBis
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			@WebParam(name = "arbeitetBis") GregorianCalendar arbeitetBis)
			throws Exception;
	
	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteMitarbeiter(@WebParam(name = "mitarbeiter") Mitarbeiter mitarbeiter)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Ort
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Ort addOrt(@WebParam(name = "ort") Ort ort) throws Exception;

	/**
	 * Passt den übergebenen Ort an.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Ort updateOrt(@WebParam(name = "ort") Ort ort) throws Exception;

	/**
	 * Löscht den übergebenen Ort.
	 * 
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteOrt(@WebParam(name = "ort") Ort ort) throws Exception;

	/**
	 * Löscht den übergebenen Ort mithilfe seiner Id.
	 * 
	 * @param idOrt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteOrtById(@WebParam(name = "idOrt") Integer idOrt) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Id.
	 * 
	 * @param idOrt
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Ort findOrtById(@WebParam(name = "idOrt") Integer idOrt) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
	 * 
	 * @param ortBez
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Ort> findOrtByOrtBez(@WebParam(name = "ortBez") String ortBez)
			throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
	 * 
	 * @param plz
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Ort> findOrtByPlz(@WebParam(name = "plz") int plz)
	throws Exception;
	
	/**
	 * Liefert alle Orte zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Ort> findAllOrt() throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Wärmeerzeuger
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Waermeerzeuger.
	 * 
	 * @param waermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Waermeerzeuger addWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger waermeerzeuger)
			throws Exception;

	/**
	 * Passt die übergebene Waermeerzeuger an.
	 * 
	 * @param waermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Waermeerzeuger updateWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger waermeerzeuger)
			throws Exception;

	/**
	 * Löscht den übergebenen Waermeerzeuger.
	 * 
	 * @param waermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger waermeerzeuger)
			throws Exception;

	/**
	 * Löscht den übergebenen Waermeerzeuger mithilfe seiner Id.
	 * 
	 * @param idWaermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteWaermeerzeugerById(
			@WebParam(name = "idWaermeerzeuger") Integer idWaermeerzeuger)
			throws Exception;

	/**
	 * Liefert den Waermeerzeuger der mit der Id angefragt wurde.
	 * 
	 * @param idWaermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Waermeerzeuger findWaermeerzeugerById(
			@WebParam(name = "idWaermeerzeuger") Integer idWaermeerzeuger) throws Exception;

	/**
	 * Liefert alle Waermeerzeuger zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception;

	/**
	 * Liefert einen Waermeerzeuger anhand des gesuchten Waermeerzeuger-Typ.
	 * 
	 * @param waermeerzeugerTyp
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Waermeerzeuger> findWaermeerzeugerByTyp(
			@WebParam(name = "waermeerzeugerTyp") String waermeerzeugerTyp)
			throws Exception;

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Brennstoff.
	 * 
	 * @param brennstoff
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(
			@WebParam(name = "brennstoff") int brennstoff) throws Exception;

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Baujahrs.
	 * 
	 * @param baujahr
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Waermeerzeuger> findWaermeerzeugerByBaujahr(
			@WebParam(name = "baujahr") int baujahr) throws Exception;
}