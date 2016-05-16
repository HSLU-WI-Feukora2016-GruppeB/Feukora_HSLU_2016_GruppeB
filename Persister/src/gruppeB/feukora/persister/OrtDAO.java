package gruppeB.feukora.persister;

import java.util.List;

import entitäten.Ort;

/**
 * Interface für Persistierung von Ort-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface OrtDAO {

	/**
	 * Speichert die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveOrt(Ort entity) throws Exception;
	
	/**
	 * Updatet die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Ort updateOrt(Ort entity) throws Exception;
	
	/**
	 * Löscht die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteOrt(Ort entity) throws Exception;
	
	/**
	 * Löscht die Ort-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param plz
	 * @throws Exception
	 */
	public void deleteOrtById(Integer plz) throws Exception;
	
	/**
	 * Liefert die Ort-Entity für die uebergebenen PLZ (id) zurück.
	 * 
	 * @param plz
	 * @return
	 */
	public Ort findOrtById(Integer plz);
	
	/**
	 * Liefert alle Ort-Objekte zurück.
	 * 
	 * @return
	 */
	List<Ort> findAllOrt();
	
	/**
	 * Liefert die Liste mit den Örtlichkeiten für die übergebene Ortsbezeichnung zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ortBez
	 * @return
	 */
	public List<Ort> findOrtByBezeichnung(String ortBez);
	
}
