package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Messung;

/**
 * Interface f�r Persistierung von Messung-Entities.
 * 
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface MessungDAO {

	/**
	 * Speichert die �bergebene Messung-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveMessung(Messung entity) throws Exception;

	/**
	 * Updatet die �bergebene Messung-Entity.
	 * 
	 * @param entity
	 * @return Messung
	 * @throws Exception
	 */
	public Messung updateMessung(Messung entity) throws Exception;

	/**
	 * L�scht die �bergebene Messung-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteMessung(Messung entity) throws Exception;

	/**
	 * Liefert die Messung-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return Messung
	 * @throws Exception
	 */
	public Messung findMessungById(Integer id) throws Exception;

	/**
	 * L�scht die Messung-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteMessungById(Integer id) throws Exception;

	/**
	 * Liefert alle Messung-Objekte zur�ck.
	 * 
	 * @return List<Messung>
	 * @throws Exception
	 */
	public List<Messung> findAllMessung() throws Exception;

	/**
	 * Liefert die Liste mit Messungen f�r die �bergebenen Daten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param messDatum
	 * @return List<Messung>
	 * @throws Exception
	 */
	public List<Messung> findByMessDatum(GregorianCalendar messDatum) throws Exception;

	/**
	 * Liefert die Liste mit Messungen wessen Beurteilungen nicht ok sind, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param beurteilungNotOk
	 * @return List<Messung>
	 * @throws Exception
	 */
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk) throws Exception;

}
