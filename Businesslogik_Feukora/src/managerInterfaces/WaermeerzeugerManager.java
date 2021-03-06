package managerInterfaces;

import java.util.List;

import entitys.Waermeerzeuger;

/**
 * Verwaltet einen Waermeerzeuger und alle Funktionen.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */

public interface WaermeerzeugerManager {

	/**
	 * Speichert einen Waermeerzeuger.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger add(Waermeerzeuger entity) throws Exception;
	
	/**
	 * Passt die �bergebene Waermeerzeuger an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger update(Waermeerzeuger entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Waermeerzeuger.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Waermeerzeuger entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Waermeerzeuger mithilfe seiner Id.
	 * @param idWaermeerzeuger
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer idWaermeerzeuger) throws Exception;

	/**
	 * Liefert den Waermeerzeuger der mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger findById(Integer idWaermeerzeuger)throws Exception;
	
	/**
	 * Liefert alle Waermeerzeuger zur�ck.
	 * @return
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findAll()throws Exception;
	
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
