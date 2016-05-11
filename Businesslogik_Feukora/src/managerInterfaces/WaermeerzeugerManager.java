package managerInterfaces;

import java.util.List;

import entitäten.Waermeerzeuger;

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
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger add(Waermeerzeuger entitaet) throws Exception;
	
	/**
	 * Passt die übergebene Waermeerzeuger an.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeguer update(Waermeerzeuger entitaet) throws Exception;
	
	/**
	 * Löscht den übergebenen Waermeerzeuger.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public void delete(Waermeerzeuger entitaet) throws Exception;

	/**
	 * Liefert den Waermeerzeuger der mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Waermeerzeuger findById(Integer id);
	
	/**
	 * Liefert alle Waermeerzeuger zurück.
	 * @return
	 */
	public List<Waermeerzeuger> findAll();
	
	/**
	 * Liefert einen Waermeerzeuger anhand des gesuchten Waermeerzeuger-Typ.
	 * @param waermeerzeugerTyp
	 * @return
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp);

	/**
	 * Liefert eine Waermeerzeuger anhand des gesuchten Brennstoff.
	 * @param brennstoff
	 * @return
	 */
	public List<Waermeerzeuger> findByBrennstoff(String brennstoff);

}
