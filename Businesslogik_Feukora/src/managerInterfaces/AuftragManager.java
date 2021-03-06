package managerInterfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;

/**
 * Verwaltet einen Auftrag und alle Funktionen.
 * 
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface AuftragManager {

	/**
	 * Speichert einen Auftrag. Und �berpr�ft ob ein Mitarbeiter nur einen
	 * Termin pro Zeitslot hat, ansonsten wird dieser verweigert.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entity) throws Exception;

	/**
	 * Passt den �bergebenen Auftrag an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entity) throws Exception;

	/**
	 * L�scht den �bergebenen Auftrag.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Auftrag entity) throws Exception;

	/**
	 * L�scht den �bergebenen Auftrag mithilfe der auftragsnummer.
	 * 
	 * @param auftragsNummer
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer auftragsNummer) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Auftrags-Nummer.
	 * 
	 * @param auftragsNummer
	 * @return
	 * @throws Exception
	 */
	public Auftrag findById(Integer auftragsNummer) throws Exception;

	/**
	 * Liefert alle Auftr�ge zur�ck.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findAll() throws Exception;

	/**
	 * Liefert eine Auftragliste anhand des gesuchten Terminsdatums.
	 * 
	 * @param datum
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter.
	 * 
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter)
			throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter f�r eine
	 * bestimmte Arbeitswoche.
	 * 
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum,
			GregorianCalendar enddatum, Mitarbeiter mitarbeiter)
			throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter f�r ein
	 * bestimmtes Datum und ZeitSlot.
	 * 
	 * @param startdatum
	 * @param zeitSlot
	 * @param mitarbeiter
	 * @return
	 * @throws Exception
	 */
	public Auftrag findByDateAndMitarbeiterAndZeitslot(GregorianCalendar datum,
			Mitarbeiter mitarbeiter, int zeitSlot) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontakts.
	 * 
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * 
	 * @param liegenschaft
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft)
			throws Exception;

}
