/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

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
	 * Löscht die Liegenschaft-Entity für den übergebenen Id-Wert.
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
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Hauswärte zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param hauswart
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByHauswart(String hauswart);
	
	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Eigentümer zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param eigentümer
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByEigentümer(String eigentümer);
	
}
