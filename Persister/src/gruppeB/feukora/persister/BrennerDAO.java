/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

/**
 * Interface f�r Persistierung von Brenner-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface BrennerDAO {

	/**
	 * Speichert die �bergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveBrenner(Brenner entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Brenner updateBrenner(Brenner entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Brenner-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteBrenner(Brenner entity) throws Exception;
	
	/**
	 * L�scht die Brenner-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBrennerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Brenner findBrennerById(Integer id);
	
	/**
	 * Liefert alle Brenner-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit Brenner f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Brenner> findBrennerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Brenner f�r das �bergebene Baujahr zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Brenner> findBrennerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brennarten zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennart
	 * @return
	 */
	public List<Brenner> findBrennerByBrennart(String brennart);
	
	
}

