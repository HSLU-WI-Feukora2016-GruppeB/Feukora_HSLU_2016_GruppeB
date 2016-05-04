/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */
package gruppeB.feukora.persister;

import java.util.*;


/**
 * Interface f�r Persistierung von W�rmeerzeuger-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface W�rmeerzeugerDAO {

	/**
	 * Speichert die �bergebene W�rmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveW�rmeerzeuger(W�rmeerzeuger entity) throws Exception;
	
	/**
	 * Updatet die �bergebene W�rmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public W�rmeerzeuger updateW�rmeerzeuger(W�rmeerzeuger entity) throws Exception;
	
	/**
	 * L�scht die �bergebene W�rmeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteW�rmeerzeuger(W�rmeerzeuger entity) throws Exception;
	
	/**
	 * L�scht die W�rmeerzeuger-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteW�rmeerzeugerById(Integer id) throws Exception;
	
	/**
	 * Liefert die W�rmeerzeuger-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public W�rmeerzeuger findW�rmeerzeugerById(Integer id);
	
	/**
	 * Liefert alle W�rmeerzeuger-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<W�rmeerzeuger> findAllW�rmeerzeuger();
	
	/**
	 * Liefert die Liste mit W�rmeerzeuger f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<W�rmeerzeuger> findW�rmeerzeugerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den W�rmeerzeugern f�r das �bergebene Baujahr zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<W�rmeerzeuger> findW�rmeerzeugerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den W�rmeerzeugern f�r den �bergebenen Brennstoff zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<W�rmeerzeuger> findW�rmeerzeugerByBrennstoff(String brennstoff);
	
	
}
