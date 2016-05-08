/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Mitarbeiter Modell-Klasse.

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
	public Auftrag updateAufrag(Auftrag entity) throws Exception;
	
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
	 * @param id
	 * @return
	 */
	public Auftrag findAuftragById(Integer id);
	
	/**
	 * Liefert alle Auftrag-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Auftrag> findAllAuftrag();
	
	/**
	 * Liefert die Liste mit Auftr�ge f�r den �bergebenen Mitarbeiter zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return
	 */
	//public List<Auftrag> findAuftragByMitarbeiter(Mitarbeiter mitarbeiter);
	
	
	//public List<Auftrag> findAuftragBy???();
	
	
	//public List<Auftrag> findAuftragBy???();
}
