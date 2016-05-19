package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Brenner;

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
	 * L�scht die Brenner-Entity mit der �bergebenen ID.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBrennerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entities f�r die �bergebene ID zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Brenner findBrennerById(Integer idBrenner);
	
	/**
	 * Liefert alle Brenner-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brennerarten zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerArt
	 * @return
	 */
	public List<Brenner> findBrennerByBrennerart(int brennerArt);

	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brenntypen zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennerTyp
	 * @return
	 */
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp);
	
	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brenntypen zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Brenner> findBrennerByBaujahr(int baujahr);
 	
}

