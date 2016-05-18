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

//import entit�ten.Auftrag;
//import entit�ten.Benutzer;
//import entit�ten.Brenner;
////import entit�ten.Feuerungsanlage;
//import entit�ten.Kontakt;
//import entit�ten.Liegenschaft;
//import entit�ten.Messung;
//import entit�ten.Mitarbeiter;
//import entit�ten.Ort;
//import entit�ten.Waermeerzeuger;

/**
 * Interface f�r Feuerungsrapport-System als Webservice.
 * 
 * @author Dominik
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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Auftrag addAuftrag(@WebParam(name = "auftrag") Auftrag entity)
			throws Exception;

	/**
	 * Passt den �bergebenen Auftrag an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Auftrag updateAuftrag(@WebParam(name = "auftrag") Auftrag entity)
			throws Exception;

	/**
	 * L�scht den �bergebenen Auftrag.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteAuftrag(@WebParam(name = "auftrag") Auftrag entity)
			throws Exception;

	/**
	 * L�scht den �bergebenen Auftrag mithilfe der auftragsnummer.
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
	 * Liefert alle Auftr�ge zur�ck.
	 * 
	 * @return
	 */
	@WebMethod
	List<Auftrag> findAllAuftrag() throws Exception;

	/**
	 * Liefert eine Auftragliste anhand des gesuchten Terminsdatums.
	 * 
	 * @param datum
	 * @return
	 */
	@WebMethod
	List<Auftrag> findAuftragByDatum(
			@WebParam(name = "datum") GregorianCalendar datum) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter.
	 * 
	 * @param mitarbeiter
	 * @return
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
	 */
	@WebMethod
	List<Auftrag> findAuftragByKontakt(
			@WebParam(name = "kontakt") Kontakt kontakt) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter f�r eine
	 * bestimmte Arbeitswoche.
	 * 
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return
	 */
	@WebMethod
	List<Auftrag> findAuftragByDateAndMitarbeiter(
			@WebParam(name = "startdatum") GregorianCalendar startdatum,
			@WebParam(name = "enddatum") GregorianCalendar enddatum,
			@WebParam(name = "mitarbeiter") Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * 
	 * @param liegenschaftOrt
	 * @return
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
	 * Liefert einen Benutzer anhand der gesuchten Benutzerid.
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod
	Benutzer findBenutzerById(@WebParam(name = "idUser") Integer idUser)
			throws Exception;

	/**
	 * Liefert alle Benutzer zur�ck.
	 * 
	 * @return
	 */
	@WebMethod
	List<Benutzer> findAllBenutzer() throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * 
	 * @param username
	 * @return
	 */
	@WebMethod
	List<Benutzer> findBenutzerByUsername(
			@WebParam(name = "username") String username) throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Passworts.
	 * 
	 * @param password
	 * @return
	 */
	@WebMethod
	List<Benutzer> findBenutzerByUsernamePassword(
			@WebParam(name = "username") String username,
			@WebParam(name = "password") String password) throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Brenner
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Brenner.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Brenner addBrenner(@WebParam(name = "brenner") Brenner entity)
			throws Exception;

	/**
	 * Passt einen Brenner an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Brenner updateBrenner(@WebParam(name = "brenner") Brenner entit�t)
			throws Exception;

	/**
	 * L�scht den mitgegebenen Brenner.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@WebMethod
	void deleteBrenner(@WebParam(name = "brenner") Brenner entity)
			throws Exception;

	/**
	 * L�scht den Brenner mithilfe seiner Id.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@WebMethod
	void deleteBrennerById(@WebParam(name = "idBrenner") Integer idBrenner)
			throws Exception;

	/**
	 * Liefert Brenner mithilfe seiner Id.
	 * 
	 * @return
	 */
	@WebMethod
	Brenner findBrennerById(@WebParam(name = "idBrenner") Integer idBrenner)
			throws Exception;

	/**
	 * Liefert Liste aller Brenner.
	 * 
	 * @return
	 */

	@WebMethod
	List<Brenner> findAllBrenner() throws Exception;

	/**
	 * Liefert alle Brenner des angefragten Typs.
	 * 
	 * @param brennerTyp
	 * @return
	 */
	@WebMethod
	List<Brenner> findBrennerByTyp(@WebParam(name = "typ") String brennerTyp)
			throws Exception;

	/**
	 * Liefert alle Brenner der angefragten Art.
	 * 
	 * @param brennerArt
	 * @return
	 */
	@WebMethod
	List<Brenner> findBrennerByArt(@WebParam(name = "art") int brennerArt)
			throws Exception;

	/**
	 * Liefert alle Brenner mit angefragtem Baujahr.
	 * 
	 * @param baujahr
	 * @return
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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Feuerungsanlage addFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage entity)
			throws Exception;

	/**
	 * Passt eine Feuerungsanlage an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Feuerungsanlage updateFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage entity)
			throws Exception;

	/**
	 * L�scht die mitgegebene Feuerungsanlage.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@WebMethod
	void deleteFeuerungsanlage(
			@WebParam(name = "feuerungsanlage") Feuerungsanlage entity)
			throws Exception;

	/**
	 * L�scht die mitgegebene Feuerungsanlage mithilfe ihrer ID.
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
	 */
	@WebMethod
	List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen f�r die gesuchte Liegenschaft.
	 * 
	 * @param brennerTyp
	 * @return
	 */
	@WebMethod
	List<Feuerungsanlage> findFeuerungsanlageByLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen f�r den gesuchten Brenner.
	 * 
	 * @param brennerArt
	 * @return
	 */
	@WebMethod
	List<Feuerungsanlage> findFeuerungsanlageByBrenner(
			@WebParam(name = "brenner") Brenner brenner) throws Exception;

	/**
	 * Liefert alle Feuerungsanlagen f�r den gesuchten W�rmeerzeuger.
	 * 
	 * @param brennerArt
	 * @return
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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Kontakt addKontakt(@WebParam(name = "kontakt") Kontakt entity)
			throws Exception;

	/**
	 * Passt einen Kontakt an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Kontakt updateKontakt(@WebParam(name = "kontakt") Kontakt entity)
			throws Exception;

	/**
	 * L�scht den mitgegebenen Kontakt.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@WebMethod
	void deleteKontakt(@WebParam(name = "kontakt") Kontakt entity)
			throws Exception;

	/**
	 * L�scht den mitgegebenen Kontakt mithilfe seiner Id.
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
	 */
	@WebMethod
	List<Kontakt> findKontaktByName(@WebParam(name = "name") String name)
			throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * 
	 * @param vorname
	 * @return
	 */
	@WebMethod
	List<Kontakt> findKontaktByVorname(
			@WebParam(name = "vorname") String vorname) throws Exception;

	/**
	 * Liefert alle Kontakte mit gesuchtem Ort.
	 * 
	 * @param ort
	 * @return
	 */
	@WebMethod
	List<Kontakt> findKontaktByOrt(@WebParam(name = "ort") Ort ort)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * 
	 * @param rolleIntern
	 * @return
	 */
	@WebMethod
	List<Kontakt> findKontaktByRolleExtern(
			@WebParam(name = "rolleExtern") int rolleExtern) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * 
	 * @param strasse
	 * @return
	 */
	@WebMethod
	List<Kontakt> findKontaktByStrasse(
			@WebParam(name = "strasse") String strasse) throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Liegenschaft
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert die Liegenschaft.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft addLiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft entity)
			throws Exception;

	/**
	 * Updated die �bergebene Entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft updateiegenschaft(
			@WebParam(name = "liegenschaft") Liegenschaft entity)
			throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteLiegenschaft(@WebParam(name = "liegenschaft") Liegenschaft entity)
			throws Exception;

	/**
	 * L�scht die �bergebene Liegenschaft mithilfe ihrer ID.
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
	 * Sucht und liefert alle Entity-Objekte zur�ck
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
	 * Liefert die Liste mit Liegenschaften f�r den �bergebenen Kontakt
	 * (Eigent�mer, Verwalter, Hauswart) zur�ck, falls welche gefunden wurden,
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
	 * Liefert die Liste mit Liegenschaften f�r dem �bergebenen Ort zur�ck,
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
	 * Liefert die Liste mit Liegenschaften f�r der �bergebenen Postleitzahl
	 * zur�ck, falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param postleitzahl
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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Messung addMessung(@WebParam(name = "messung") Messung entity)
			throws Exception;

	/**
	 * Passt die �bergebene Messung an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Messung updateMessung(@WebParam(name = "messung") Messung entity)
			throws Exception;

	/**
	 * L�scht die �bergebene Messung.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteMessung(@WebParam(name = "messung") Messung entity)
			throws Exception;

	/**
	 * L�scht die �bergebene Messung mithilfe ihrer Id.
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
	 */
	@WebMethod
	Messung findMessungById(@WebParam(name = "idMessung") Integer idMessung)
			throws Exception;

	/**
	 * Liefert alle Messungen zur�ck.
	 * 
	 * @return
	 */
	@WebMethod
	List<Messung> findAllMessung() throws Exception;

	/**
	 * Liefert eine Messungsliste anhand des gesuchten Messdatums.
	 * 
	 * @param datum
	 * @return
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
	 */
	@WebMethod
	List<Messung> findMessungByBeurteilungNotOk(
			@WebParam(name = "beurteilungNotOK") boolean beurteilungNotOk)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Mitarbeiter
	// -----------------------------------------------------------------------------------------------
	/**
	 * Liefert alle Mitarbeiter des angefragten Typs.
	 * 
	 * @param name
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByName(@WebParam(name = "name") String name)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * 
	 * @param vorname
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByVorname(
			@WebParam(name = "vorname") String vorname) throws Exception;

	/**
	 * Liefert den Mitarbeiter zur mitgegebenen Id.
	 * 
	 * @param idMitarbeiter
	 * @return
	 */
	@WebMethod
	Mitarbeiter findMitarbeiterById(
			@WebParam(name = "idMitarbeiter") Integer idMitarbeiter)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * 
	 * @param name
	 * @param vorname
	 * @return
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
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByStrasse(
			@WebParam(name = "strasse") String strasse) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Ort.
	 * 
	 * @param ort
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByOrt(@WebParam(name = "ort") Ort ort)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Benutzernamen.
	 * 
	 * @param username
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByBenutzer(
			@WebParam(name = "user") Benutzer user) throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Arbeitsbeginn-Datum.
	 * 
	 * @param arbeitetSeit
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			@WebParam(name = "arbeitetSeit") GregorianCalendar arbeitetSeit)
			throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem K�ndigungs-Datum.
	 * 
	 * @param arbeitetBis
	 * @return
	 */
	@WebMethod
	List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			@WebParam(name = "arbeitetBis") GregorianCalendar arbeitetBis)
			throws Exception;

	// -----------------------------------------------------------------------------------------------
	// Ort
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Ort.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Ort addOrt(@WebParam(name = "ort") Ort entity) throws Exception;

	/**
	 * Passt den �bergebenen Ort an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Ort updateOrt(@WebParam(name = "ort") Ort entity) throws Exception;

	/**
	 * L�scht den �bergebenen Ort.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteOrt(@WebParam(name = "ort") Ort entity) throws Exception;

	/**
	 * L�scht den �bergebenen Ort mithilfe seiner Id.
	 * 
	 * @param plz
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteOrtById(@WebParam(name = "plz") Integer plz) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Id.
	 * 
	 * @param plz
	 * @return
	 */
	@WebMethod
	Ort findOrtById(@WebParam(name = "plz") Integer plz) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
	 * 
	 * @param ortBez
	 * @return
	 */
	@WebMethod
	List<Ort> findOrtByOrtBez(@WebParam(name = "ortBez") String ortBez)
			throws Exception;

	/**
	 * Liefert alle Benutzer zur�ck.
	 * 
	 * @return
	 */
	@WebMethod
	List<Ort> findAllOrt() throws Exception;

	// -----------------------------------------------------------------------------------------------
	// W�rmeerzeuger
	// -----------------------------------------------------------------------------------------------
	/**
	 * Speichert einen Waermeerzeuger.
	 * 
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Waermeerzeuger addWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger entitaet)
			throws Exception;

	/**
	 * Passt die �bergebene Waermeerzeuger an.
	 * 
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Waermeerzeuger updateWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger entitaet)
			throws Exception;

	/**
	 * L�scht den �bergebenen Waermeerzeuger.
	 * 
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") Waermeerzeuger entitaet)
			throws Exception;

	/**
	 * L�scht den �bergebenen Waermeerzeuger mithilfe seiner Id.
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
	 * @param id
	 * @return
	 */
	@WebMethod
	Waermeerzeuger findWaermeerzeugerById(
			@WebParam(name = "idWaermeerzeuger") Integer id) throws Exception;

	/**
	 * Liefert alle Waermeerzeuger zur�ck.
	 * 
	 * @return
	 */
	@WebMethod
	List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception;

	/**
	 * Liefert einen Waermeerzeuger anhand des gesuchten Waermeerzeuger-Typ.
	 * 
	 * @param waermeerzeugerTyp
	 * @return
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
	 */
	@WebMethod
	List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(
			@WebParam(name = "brennstoff") int brennstoff) throws Exception;

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Baujahrs.
	 * 
	 * @param baujahr
	 * @return
	 */
	@WebMethod
	List<Waermeerzeuger> findWaermeerzeugerByBaujahr(
			@WebParam(name = "baujahr") int baujahr) throws Exception;
}