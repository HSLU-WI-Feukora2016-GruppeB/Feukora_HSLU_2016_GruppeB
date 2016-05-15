/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.GregorianCalendar;
import java.util.List;

import entitäten.Auftrag;
import entitäten.Kontakt;
import entitäten.Liegenschaft;
import entitäten.Mitarbeiter;

/**
 * Interface für Persistierung von Auftrag-Entities.
 * 
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
	 * @return
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
	 * @param id
	 * @throws Exception
	 */
	public void deleteAuftragById(Integer id) throws Exception;

	/**
	 * Liefert die Auftrag-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param auftragsNummer
	 * @return
	 */
	public Auftrag findAuftragByAuftragsNummer(Integer auftragsNummer);

	/**
	 * Liefert alle Auftrag-Objekte zurück.
	 * 
	 * @return
	 */
	List<Auftrag> findAllAuftrag();

	/**
	 * Liefert die Liste mit Aufträge für den übergebenen Mitarbeiter zurück,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter);

	/**
	 * Liefert die Liste mit Aufträgen für die übergebenen Daten zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param datum
	 * @return
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum);

	/**
	 * Liefert die Liste mit Aufträgen für die übergebene DAtumsspanne (Start  bis Ende) 
	 * und der für den entsprechenden Mitarbeiter zurück, falls welche gefunden werden. 
	 * Sonst eine leere Liste.
	 * 
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByDatumAndMitarbeiter(
			GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter);

	/**
	 * Liefert die Liste mit Aufträgen für die übergebenen Kontakt zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt);

	/**
	 * Liefert die Liste mit Aufträgen für die übergebenen Liegenschaften
	 * zurück, falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft);

}
