/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Mitarbeiter Modell-Klasse.

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
	public Auftrag updateAufrag(Auftrag entity) throws Exception;
	
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
	 * @param id
	 * @return
	 */
	public Auftrag findAuftragById(Integer id);
	
	/**
	 * Liefert alle Auftrag-Objekte zurück.
	 * 
	 * @return
	 */
	List<Auftrag> findAllAuftrag();
	
	/**
	 * Liefert die Liste mit Aufträge für den übergebenen Mitarbeiter zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param mitarbeiter
	 * @return
	 */
	//public List<Auftrag> findAuftragByMitarbeiter(Mitarbeiter mitarbeiter);
	
	
	//public List<Auftrag> findAuftragBy???();
	
	
	//public List<Auftrag> findAuftragBy???();
}
