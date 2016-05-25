package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;

/**
 * Interface für Persistierung von Auftrag-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface AuftragDAO {

	/**
	 * Speichert die übergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveAuftrag(Auftrag entity) throws Exception;

	/**
	 * Updatet die übergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @return Auftrag
	 * @throws Exception
	 */
	public Auftrag updateAuftrag(Auftrag entity) throws Exception;

	/**
	 * Löscht die übergebene Auftrag-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteAuftrag(Auftrag entity) throws Exception;

	/**
	 * Löscht die Auftrag-Entity für den übergebenen Id-Wert.
	 * 
	 * @param idAuftrag
	 * @throws Exception
	 */
	public void deleteAuftragById(Integer idAuftrag) throws Exception;

	/**
	 * Liefert die Auftrag-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param idAuftrag
	 * @return Auftrag
	 * @throws Exception
	 */
	public Auftrag findAuftragById(Integer idAuftrag) throws Exception;

	/**
	 * Liefert alle Auftrag-Objekte zurück.
	 * 
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	List<Auftrag> findAllAuftrag() throws Exception;

	/**
	 * Liefert die Liste mit Aufträge für den übergebenen Mitarbeiter zurück,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) throws Exception;

	/**
	 * Liefert die Liste mit Aufträgen für die übergebenen Daten zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param datum
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception;

	/**
	 * Liefert die Liste mit Aufträgen für die übergebene Datumsspanne (Start  bis Ende) 
	 * und der für den entsprechenden Mitarbeiter zurück, falls welche gefunden werden. 
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
	 * Liefert die Liste mit Aufträgen für die übergebenen Kontakt zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return List<Auftrag>
	 * @throws Exception
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception;

	/**
	 * Liefert die Liste mit Aufträgen für die übergebenen Liegenschaften
	 * zurück, falls welche gefunden werden. Sonst eine leere Liste.
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
