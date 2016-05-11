/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */
package gruppeB.feukora.persister;

import java.util.*;

import entitäten.Waermeerzeuger;


/**
 * Interface für Persistierung von Waermeerzeuger-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface WaermeerzeugerDAO {

	/**
	 * Speichert die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Updatet die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Löscht die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Liefert die Waermeerzeuger-Entity für den uebergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Waermeerzeuger findWaermeerzeugerById(Integer id);
	
	/**
	 * Liefert alle Waermeerzeuger-Objekte zurück.
	 * 
	 * @return
	 */
	List<Waermeerzeuger> findAllWaermeerzeuger();
	
	/**
	 * Liefert die Liste mit Waermeerzeuger für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Waermeerzeugern für das übergebene Baujahr zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Brennstoff zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(String brennstoff);

	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Typ zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeugerTyp
	 * @return
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp);
	
	
}
