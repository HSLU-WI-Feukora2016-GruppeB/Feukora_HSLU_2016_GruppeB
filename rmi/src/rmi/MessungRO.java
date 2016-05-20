package rmi;

import java.rmi.Remote;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Messung;



/**
 * Das Interface stellt die CRUD-Funktionen für die Messung zur Verfügung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 */

public interface MessungRO extends Remote {

	
	/**
	 * Speichert eine Messung.
	 * @param entity
	 * @throws Exception
	 */
	public Messung add(Messung entity) throws Exception;
	
	/**
	 * Passt die übergebene Messung an.
	 * @param entity
	 * @throws Exception
	 */
	public Messung update(Messung entity) throws Exception;
	
	/**
	 * Löscht die übergebene Messung.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Messung entity) throws Exception;
	
	/**
	 * Löscht die übergebene Messung mithilfe ihrer Id.
	 * @param idMessung
	 * @throws Exception
	 */
	public void deleteById(Integer idMessung) throws Exception;

	/**
	 * Liefert eine Messungsliste anhand der gesuchten id.
	 * @param idMessung
	 */	
	public Messung findById(Integer idMessung)throws Exception;
	
	/**
	 * Liefert alle Messungen zurück.
	 * @return
	 */
	public List<Messung> findAll() throws Exception;
	
	/**
	 * Liefert eine Messungsliste anhand des gesuchten Messdatums.
	 * @param datum
	 * @return
	 */
	public List<Messung> findByDatum(GregorianCalendar messDatum)throws Exception;
	
	/**
	 * Liefert alle Messungen wessen Beurteilungen NICHT ok waren (ausserhalb Grenzwerte).
	 * @param beurteilungNotOk
	 * @return
	 */
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk)throws Exception;
	
	
}

