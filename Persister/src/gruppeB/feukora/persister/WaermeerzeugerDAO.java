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
	 * Löscht die Waermeerzeuger-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteWaermeerzeugerById(Integer id) throws Exception;
	
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
	 * Liefert die Liste mit den Waermeerzeugern für das übergebene Baujahr zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr);
	
	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Brennstoff zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff);

	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Typ zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeugerTyp
	 * @return
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp);
		
}
