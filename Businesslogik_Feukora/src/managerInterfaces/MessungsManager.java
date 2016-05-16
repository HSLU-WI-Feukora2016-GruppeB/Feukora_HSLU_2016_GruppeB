package managerInterfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Messung;


/**
 * Verwaltet eine Messung, kontrolliert die Grenzwerte sowie weitere Funktionen.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface MessungsManager {
	
	/**
	 * Speichert eine Messung.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Messung add(Messung entity) throws Exception;
	
	/**
	 * Passt die �bergebene Messung an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Messung update(Messung entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Messung.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Messung entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Messung mithilfe ihrer Id.
	 * @param idMessung
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer idMessung) throws Exception;

	/**
	 * Liefert eine Messungsliste anhand der gesuchten id.
	 * @param idMessung
	 * @return
	 */	
	public Messung findById(Integer idMessung);
	
	/**
	 * Liefert alle Messungen zur�ck.
	 * @return
	 */
	public List<Messung> findAll();
	
	/**
	 * Liefert eine Messungsliste anhand des gesuchten Messdatums.
	 * @param datum
	 * @return
	 */
	public List<Messung> findByDatum(GregorianCalendar messDatum);
	
	/**
	 * Liefert alle Messungen wessen Beurteilungen NICHT ok waren (ausserhalb Grenzwerte).
	 * @param beurteilungNotOk
	 * @return
	 */
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk);
	
	
}
