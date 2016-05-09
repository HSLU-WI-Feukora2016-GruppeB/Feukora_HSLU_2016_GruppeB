/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */
package gruppeB.feukora.persister;

import java.util.*;


/**
 * Interface für Persistierung von Wärmeerzeuger-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface WärmeerzeugerDAO {

	/**
	 * Speichert die übergebene Wärmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveWärmeerzeuger(Wärmeerzeuger entity) throws Exception;
	
	/**
	 * Updatet die übergebene Wärmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Wärmeerzeuger updateWärmeerzeuger(Wärmeerzeuger entity) throws Exception;
	
	/**
	 * Löscht die übergebene Wärmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteWärmeerzeuger(Wärmeerzeuger entity) throws Exception;
	
	/**
	 * Löscht die Wärmeerzeuger-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteWärmeerzeugerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Wärmeerzeuger-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Wärmeerzeuger findWärmeerzeugerById(Integer id);
	
	/**
	 * Liefert alle Wärmeerzeuger-Objekte zurück.
	 * 
	 * @return
	 */
	List<Wärmeerzeuger> findAllWärmeerzeuger();
	
	/**
	 * Liefert die Liste mit Wärmeerzeuger für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Wärmeerzeuger> findWärmeerzeugerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Wärmeerzeugern für das übergebene Baujahr zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Wärmeerzeuger> findWärmeerzeugerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Wärmeerzeugern für den übergebenen Brennstoff zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Wärmeerzeuger> findWärmeerzeugerByBrennstoff(String brennstoff);
	
	
}
