/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entitäten.Brenner;
import entitäten.Feuerungsanlage;
import entitäten.Liegenschaft;
import entitäten.Waermeerzeuger;

/**
 * Interface für Persistierung von Feuerungsanlage-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface FeuerungsanlageDAO {

	/**
	 * Speichert die übergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Updatet die übergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Löscht die übergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Löscht die Feuerungsanlage-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteFeuerungsanlageById(Integer id) throws Exception;
	
	/**
	 * Liefert die Feuerungsanlage-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Feuerungsanlage findFeuerungsanlageById(Integer id);
	
	/**
	 * Liefert alle Feuerungsanlage-Objekte zurück.
	 * 
	 * @return
	 */
	List<Feuerungsanlage> findAllFeuerungsanlage();

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Liegenschaften zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Brenner zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brenner
	 * @return
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner);

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Waermeerzeuger zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeuger
	 * @return
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);

}
