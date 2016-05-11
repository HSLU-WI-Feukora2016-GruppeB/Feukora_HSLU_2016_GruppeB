/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Brenner;

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
	 * Liefert alle Brenner-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Brenner> findAllBrenner();
	
	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brennarten zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennart
	 * @return
	 */
	public List<Brenner> findBrennerByBrennart(String brennerArt);

	/**
	 * Liefert die Liste mit den Brenner f�r die �bergebenen Brenntypen zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * @param brennerTyp
	 * @return
	 */
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp);
	
}

