package gruppeB.feukora.interfaces;

import java.util.*;

import entitys.Waermeerzeuger;

/**
 * Interface f�r Persistierung von Waermeerzeuger-Entities.
 * 
 * @since 1.0
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
	 * @return Waermeerzeuger
	 * @throws Exception
	 */
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity)
			throws Exception;

	/**
	 * L�scht die �bergebene Waermeerzeuger-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception;

	/**
	 * L�scht die Waermeerzeuger-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteWaermeerzeugerById(Integer id) throws Exception;

	/**
	 * Liefert die Waermeerzeuger-Entity f�r den uebergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Waermeerzeuger findWaermeerzeugerById(Integer id) throws Exception;

	/**
	 * Liefert alle Waermeerzeuger-Objekte zur�ck.
	 * 
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r das �bergebene Baujahr
	 * zur�ck, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr)
			throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r den �bergebenen Brennstoff
	 * zur�ck, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff)
			throws Exception;

	/**
	 * Liefert die Liste mit den Waermeerzeugern f�r den �bergebenen Typ zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeugerTyp
	 * @return List<Waermeerzeuger>
	 * @throws Exception
	 */
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp)
			throws Exception;

}
