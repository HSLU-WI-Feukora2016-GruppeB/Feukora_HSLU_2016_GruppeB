package rmi.interfaces;

import java.rmi.Remote;
import java.util.List;

import entitys.Waermeerzeuger;



/**
 * Das Interface stellt die CRUD-Funktionen für den Waermeerzeuger zur Verfügung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 */

public interface WaermeerzeugerRO extends Remote{

	
	/**
	 * Speichert einen Waermeerzeuger.
	 * @param entity
	 * @throws Exception
	 */
	public Waermeerzeuger add(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Passt die übergebene Waermeerzeuger an.
	 * @param entity
	 * @throws Exception
	 */
	public Waermeerzeuger update(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Löscht den übergebenen Waermeerzeuger.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Löscht den übergebenen Waermeerzeuger mithilfe seiner Id.
	 * @param idWaermeerzeuger
	 * @throws Exception
	 */
	public void deleteById(Integer idWaermeerzeuger) throws Exception;

	/**
	 * Liefert den Waermeerzeuger der mit der Id angefragt wurde. 
	 * @param idWaermeerzeuger
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger findById(Integer idWaermeerzeuger)throws Exception;
	
	/**
	 * Liefert alle Waermeerzeuger zurück.
	 * @return
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findAllWaermeerzeuger()throws Exception;
	
	/**
	 * Liefert einen Waermeerzeuger anhand des gesuchten Waermeerzeuger-Typ.
	 * @param waermeerzeugerTyp
	 * @return
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp)throws Exception;

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Brennstoff.
	 * @param brennstoff
	 * @return
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findByBrennstoff(int brennstoff)throws Exception;
	
	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Baujahrs.
	 * @param baujahr
	 * @return
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findByBaujahr(int baujahr)throws Exception;

}
