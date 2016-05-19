package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Brenner;

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
	 * @return
	 */
	public Brenner findBrennerById(Integer idBrenner);
	
	/**
	 * Liefert alle Brenner-Objekte zurück.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit den Brenner für die übergebenen Brennerarten zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerArt
	 * @return
	 */
	public List<Brenner> findBrennerByBrennerart(int brennerArt);

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
	public List<Brenner> findBrennerByBaujahr(int baujahr);
 	
}

