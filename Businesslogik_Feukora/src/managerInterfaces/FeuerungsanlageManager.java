package managerInterfaces;

import java.util.List;

import entitäten.Brenner;
import entitäten.Feuerungsanlage;
import entitäten.Liegenschaft;
import entitäten.Waermeerzeuger;



/**
 * Handelt Feuerungsanlage Funktionalität
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface FeuerungsanlageManager {

	/**
	 * Speichert eine Feuerungsanlage.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage add(Feuerungsanlage entität) throws Exception;
	
	/**
	 * Passt eine Feuerungsanlage an.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage update(Feuerungsanlage entität) throws Exception;
	
	/**
	 * Löscht die mitgegebene Feuerungsanlage.
	 * @param entität
	 * @throws Exception
	 */
	public void delete(Feuerungsanlage entität) throws Exception;
	
	/**
	 * Liefert Liste aller Feuerungsanlagen.
	 * @return
	 */
	public List<Feuerungsanlage> findAll();
	
	/**
	 * Liefert alle Feuerungsanlagen für die gesuchte Liegenschaft.
	 * @param brennerTyp
	 * @return
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);
	
	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Brenner.
	 * @param brennerArt
	 * @return
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner);
	
	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Wärmeerzeuger.
	 * @param brennerArt
	 * @return
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);
}
