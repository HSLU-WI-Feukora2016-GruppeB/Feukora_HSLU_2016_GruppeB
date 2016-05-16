package rmi;

import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Auftrag;


/**
 * Das Interface stellt die CRUD-Funktionen f�r den Auftrag zur Verf�gung.
 * 
 * @author Berri
 * @version 1.0
 * @since 1.0
 */

public interface AuftragRO {
	
	/** 
	 * Speichert die Aenderung im Auftrag.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entity) throws Exception;
	
	/**
	 * Update des Auftrags.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entity) throws Exception;
	
	/**
	 * Test betreffend Grenzwert bei der Messung.
	 * @param auftrag
	 * @throws Exception
	 */
	public Auftrag checkMessungByGrenzwert(Auftrag auftrag) throws Exception;
	
	/**
	 * L�scht den Auftrag.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Auftrag entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Auftrag mithilfe der Auftragsnummer.
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
	 * Liefert alle Auftraege in der Liste zur�ck.
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
	 * f�r eine bestimmte Arbeitswoche.
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
}
