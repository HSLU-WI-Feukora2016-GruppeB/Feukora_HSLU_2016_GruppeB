package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;

/**
 * Interface für Persistierung von Feuerungsanlage-Entities.
 * @since 1.0
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
	 * @return Feuerungsanlage
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
	 * @return Feuerungsanlage
	 * @throws Exception
	 */
	public Feuerungsanlage findFeuerungsanlageById(Integer id) throws Exception;
	
	/**
	 * Liefert alle Feuerungsanlage-Objekte zurück.
	 * 
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Liegenschaften zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Brenner zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brenner
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Waermeerzeuger zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeuger
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger) throws Exception;

}
