/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entitäten.Brenner;

/**
 * Interface für Persistierung von Brenner-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface BrennerDAO {

	/**
	 * Speichert die übergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveBrenner(Brenner entity) throws Exception;
	
	/**
	 * Updatet die übergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Brenner updateBrenner(Brenner entity) throws Exception;
	
	/**
	 * Löscht die übergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteBrenner(Brenner entity) throws Exception;
	
	/**
<<<<<<< HEAD
	 * Löscht die Brenner-Entity mit der übergebenen ID.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBrennerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entities für die übergebene ID zurück.
=======
	 * Löscht die Brenner-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBrennerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entity für den übergebenen Id-Wert zurück.
>>>>>>> refs/remotes/origin/master
	 * 
	 * @param id
	 * @return
	 */
	public Brenner findBrennerById(Integer id);
	
	/**
	 * Liefert alle Brenner-Objekte zurück.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit Brenner für die übergebene Bezeichnung zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Brenner> findBrennerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Brenner für das übergebene Baujahr zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Brenner> findBrennerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brennarten zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennart
	 * @return
	 */
<<<<<<< HEAD
	public List<Brenner> findBrennerByBrennart(String brennerArt);

	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brenntypen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerTyp
	 * @return
	 */
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp);
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brenntypen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Brenner> findBrennerByBaujahr(Integer baujahr);
=======
	public List<Brenner> findBrennerByBrennart(String brennart);
>>>>>>> refs/remotes/origin/master
	
}

