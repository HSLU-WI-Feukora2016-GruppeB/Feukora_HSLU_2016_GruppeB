package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;

/**
 * Interface f�r Persistierung von Auftrag-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface AuftragDAO {

	/**
	 * Speichert die �bergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveAuftrag(Auftrag entity) throws Exception;

	/**
	 * Updatet die �bergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @return Auftrag
	 * @throws Exception
	 */
	public Auftrag updateAuftrag(Auftrag entity) throws Exception;

	/**
	 * L�scht die �bergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteAuftrag(Auftrag entity) throws Exception;

	/**
	 * L�scht die Auftrag-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param idAuftrag
	 * @throws Exception
	 */
	public void deleteAuftragById(Integer idAuftrag) throws Exception;

	/**
	 * Liefert die Auftrag-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param idAuftrag
	 * @return Auftrag
	 * @throws Exception
	 */
	public Auftrag findAuftragById(Integer idAuftrag) throws Exception;

	/**
	 * Liefert alle Auftrag-Objekte zur�ck.
	 * 
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	List<Auftrag> findAllAuftrag() throws Exception;

	/**
	 * Liefert die Liste mit Auftr�ge f�r den �bergebenen Mitarbeiter zur�ck,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Daten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param datum
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception;

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebene Datumsspanne (Start  bis Ende) 
	 * und der f�r den entsprechenden Mitarbeiter zur�ck, falls welche gefunden werden. 
	 * Sonst eine leere Liste.
	 * 
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByDatumAndMitarbeiter(
			GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Kontakt zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception;

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Liegenschaften
	 * zur�ck, falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception;

	/**
	 * Liefert spezifischen Auftrag eines Mitarbeiters, zu bestimmten Datum, und Zeitslot.
	 * @param datum
	 * @param mitarbeiter
	 * @param zeitSlot
	 * @return Auftrag
	 * @throws Exception
	 */
	public Auftrag findAuftragByDateAndMitarbeiterAndZeitslot(
			GregorianCalendar datum, Mitarbeiter mitarbeiter, int zeitSlot) throws Exception;

}
