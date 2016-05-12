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
	 * Liefert alle Brenner-Objekte zurück.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brennarten zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennart
	 * @return
	 */
	public List<Brenner> findBrennerByBrennart(String brennerArt);

	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brenntypen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * @param brennerTyp
	 * @return
	 */
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp);
	
}

