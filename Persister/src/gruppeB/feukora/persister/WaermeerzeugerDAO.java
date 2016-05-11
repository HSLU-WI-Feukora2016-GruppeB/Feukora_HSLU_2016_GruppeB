/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */
package gruppeB.feukora.persister;

import java.util.*;

import entit�ten.Waermeerzeuger;


/**
 * Interface f�r Persistierung von Waermeerzeuger-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface WaermeerzeugerDAO {

	/**
	 * Speichert die �bergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Liefert die Waermeerzeuger-Entity f�r den uebergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Waermeerzeuger findWaermeerzeugerById(Integer id);
	
	/**
	 * Liefert alle Waermeerzeuger-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Waermeerzeuger> findAllWaermeerzeuger();
	
	/**
	 * Liefert die Liste mit Waermeerzeuger f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r das �bergebene Baujahr zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r den �bergebenen Brennstoff zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(String brennstoff);

	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r den �bergebenen Typ zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeugerTyp
	 * @return
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp);
	
	
}
