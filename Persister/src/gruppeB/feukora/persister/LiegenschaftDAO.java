package gruppeB.feukora.persister;

import java.util.List;

import entitäten.Liegenschaft;
import entitäten.Kontakt;
import entitäten.Ort;

/**
 * Interface für Persistierung von Liegenschaft-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface LiegenschaftDAO {

	/**
	 * Speichert die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Updatet die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft updateLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die Liegenschaft-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert die Liegenschaft-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Liegenschaft findLiegenschaftById(Integer id);
	
	/**
	 * Liefert alle Liegenschaft-Objekte zurück.
	 * 
	 * @return
	 */
	List<Liegenschaft> findAllLiegenschaft();

	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Kontakt zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt);
	
	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Ort zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort);

	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Strasse zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse);
	
}
