package rmi;

import java.rmi.Remote;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;


/**
 * Das Interface stellt die CRUD-Funktionen für den Auftrag zur Verfügung.
 *
 * @author Matthias
 * @version 1.0
 * @since 1.0
 */

public interface AuftragRO extends Remote {

	/**
	 * Speichert die Aenderung im Auftrag.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entity) throws Exception;

	/**
	 * Aenderung des Auftrags.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entity) throws Exception;

	/**
	 * Löscht den Auftrag.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Auftrag entity) throws Exception;

	/**
	 * Löscht den übergebenen Auftrag mithilfe der Auftragsnummer.
	 * @param auftragsNummer
	 * @throws Exception
	 */
	public void deleteById(Integer auftragsNummer) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Auftragsnummer.
	 * @param auftragsNummer
	 * @throws Exception
	 */
	public Auftrag findByAuftragsNummer(Integer auftragsNummer) throws Exception;

	/**
	 * Liefert alle Auftraege in der Liste zurück.
	 * @throws Exception
	 */
	public List<Auftrag> findAll() throws Exception;

	/**
	 * Liefert eine Auftragliste anhand des gesuchten Terminsdatums.
	 * @param datum
	 * @throws Exception
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiters.
	 * @param mitarbeiter
	 * @throws Exception
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiters
	 * für eine bestimmte Arbeitswoche.
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @throws Exception
	 */
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @throws Exception
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * @param liegenschaft
	 * @throws Exception
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des Mitarbeiters, DAtums sowie Zeitslots.
	 * @param datum
	 * @param mitarbeiter
	 * @param zeitSlot
	 * @return
	 * @throws Exception
	 */
	public Auftrag findByDateAndMitarbeiterAndZeitslot(GregorianCalendar datum,
			Mitarbeiter mitarbeiter, int zeitSlot) throws Exception;
}
