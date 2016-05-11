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
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebene Bezeichnung zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Feuerungsanlagen für das übergebene Baujahr zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Feuerungsanlagen für die übergebenen Brennstoffe zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBrennstoff(String brennstoff);

	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);
	//toDO

	public List<Feuerungsanlage> findByBrenner(Brenner brenner);
	//toDO

	public List<Feuerungsanlage> findByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger);
	//toDO
}
