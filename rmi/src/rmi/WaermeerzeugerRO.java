package rmi;

import java.rmi.Remote;
import java.util.List;

import entit�ten.Waermeerzeuger;



/**
 * Das Interface stellt die CRUD-Funktionen f�r den Waermeerzeuger zur Verf�gung.
 * 
 * @author Matthias
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
	 * Passt die �bergebene Waermeerzeuger an.
	 * @param entity
	 * @throws Exception
	 */
	public Waermeerzeuger update(Waermeerzeuger entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Waermeerzeuger.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Waermeerzeuger entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Waermeerzeuger mithilfe seiner Id.
	 * @param idWaermeerzeuger
	 * @throws Exception
	 */
	public void deleteById(Integer idWaermeerzeuger) throws Exception;

	/**
	 * Liefert den Waermeerzeuger der mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Waermeerzeuger findById(Integer idWaermeerzeuger)throws Exception;
	
	/**
	 * Liefert alle Waermeerzeuger zur�ck.
	 * @return
	 */
	public List<Waermeerzeuger> findAllWaermeerzeuger()throws Exception;
	
	/**
	 * Liefert einen Waermeerzeuger anhand des gesuchten Waermeerzeuger-Typ.
	 * @param waermeerzeugerTyp
	 * @return
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp)throws Exception;

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Brennstoff.
	 * @param brennstoff
	 * @return
	 */
	public List<Waermeerzeuger> findByBrennstoff(int brennstoff)throws Exception;
	
	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Baujahrs.
	 * @param baujahr
	 * @return
	 */
	public List<Waermeerzeuger> findByBaujahr(int baujahr)throws Exception;

}
