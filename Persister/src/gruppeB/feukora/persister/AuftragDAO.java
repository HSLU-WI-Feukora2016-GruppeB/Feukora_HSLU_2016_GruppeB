/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Auftrag;
import entit�ten.Kontakt;
import entit�ten.Liegenschaft;
import entit�ten.Mitarbeiter;

/**
 * Interface f�r Persistierung von Auftrag-Entities.
 * 
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
	 * @return
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
	 * @param id
	 * @throws Exception
	 */
	public void deleteAuftragById(Integer id) throws Exception;

	/**
	 * Liefert die Auftrag-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param auftragsNummer
	 * @return
	 */
	public Auftrag findAuftragByAuftragsNummer(Integer auftragsNummer);

	/**
	 * Liefert alle Auftrag-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Auftrag> findAllAuftrag();

	/**
	 * Liefert die Liste mit Auftr�ge f�r den �bergebenen Mitarbeiter zur�ck,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter);

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Daten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param datum
	 * @return
	 */
	public List<Auftrag> findByDatum(GregorianCalendar datum);

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebene DAtumsspanne (Start  bis Ende) 
	 * und der f�r den entsprechenden Mitarbeiter zur�ck, falls welche gefunden werden. 
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
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Kontakt zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt);

	/**
	 * Liefert die Liste mit Auftr�gen f�r die �bergebenen Liegenschaften
	 * zur�ck, falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft);

}
