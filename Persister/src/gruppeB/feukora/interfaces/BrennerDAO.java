package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Brenner;

/**
 * Interface für Persistierung von Brenner-Entities.
 * @since 1.0
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
	 * @return Brenner
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
	 * Löscht die Brenner-Entity mit der übergebenen ID.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBrennerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entities für die übergebene ID zurück.
	 * 
	 * @param id
	 * @return Brenner
	 * @throws Exception
	 */
	public Brenner findBrennerById(Integer idBrenner) throws Exception;
	
	/**
	 * Liefert alle Brenner-Objekte zurück.
	 * 
	 * @return List<Brenner>
	 * @throws Exception
	 */
	List<Brenner> findAllBrenner() throws Exception;
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brennerarten zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerArt
	 * @return List<Brenner>
	 * @throws Exception
	 */
	public List<Brenner> findBrennerByBrennerart(int brennerArt) throws Exception;

	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brenntypen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerTyp
	 * @return List<Brenner>
	 * @throws Exception
	 */
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp) throws Exception;
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brenntypen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return List<Brenner>
	 * @throws Exception
	 */
	public List<Brenner> findBrennerByBaujahr(int baujahr) throws Exception;
 	
}

