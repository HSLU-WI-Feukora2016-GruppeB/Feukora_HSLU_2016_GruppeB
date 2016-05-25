package gruppeB.feukora.interfaces;

import java.util.*;

import entitys.Waermeerzeuger;

/**
 * Interface für Persistierung von Waermeerzeuger-Entities.
 * 
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface WaermeerzeugerDAO {

	/**
	 * Speichert die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveWaermeerzeuger(Waermeerzeuger entity) throws Exception;

	/**
	 * Updatet die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @return Waermeerzeuger
	 * @throws Exception
	 */
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity)
			throws Exception;

	/**
	 * Löscht die übergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception;

	/**
	 * Löscht die Waermeerzeuger-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteWaermeerzeugerById(Integer id) throws Exception;

	/**
	 * Liefert die Waermeerzeuger-Entity für den uebergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger findWaermeerzeugerById(Integer id) throws Exception;

	/**
	 * Liefert alle Waermeerzeuger-Objekte zurück.
	 * 
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern für das übergebene Baujahr
	 * zurück, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr)
			throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Brennstoff
	 * zurück, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff)
			throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern für den übergebenen Typ zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeugerTyp
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp)
			throws Exception;

}
