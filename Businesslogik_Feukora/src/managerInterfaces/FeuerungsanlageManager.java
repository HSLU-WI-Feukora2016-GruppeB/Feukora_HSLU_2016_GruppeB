package managerInterfaces;

import java.util.List;

import entit�ten.Brenner;
import entit�ten.Feuerungsanlage;
import entit�ten.Liegenschaft;
import entit�ten.Waermeerzeuger;



/**
 * Handelt Feuerungsanlage Funktionalit�t
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface FeuerungsanlageManager {

	/**
	 * Speichert eine Feuerungsanlage.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage add(Feuerungsanlage entit�t) throws Exception;
	
	/**
	 * Passt eine Feuerungsanlage an.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage update(Feuerungsanlage entit�t) throws Exception;
	
	/**
	 * L�scht die mitgegebene Feuerungsanlage.
	 * @param entit�t
	 * @throws Exception
	 */
	public void delete(Feuerungsanlage entit�t) throws Exception;
	
	/**
	 * Liefert Liste aller Feuerungsanlagen.
	 * @return
	 */
	public List<Feuerungsanlage> findAll();
	
	/**
	 * Liefert alle Feuerungsanlagen f�r die gesuchte Liegenschaft.
	 * @param brennerTyp
	 * @return
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);
	
	/**
	 * Liefert alle Feuerungsanlagen f�r den gesuchten Brenner.
	 * @param brennerArt
	 * @return
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner);
	
	/**
	 * Liefert alle Feuerungsanlagen f�r den gesuchten W�rmeerzeuger.
	 * @param brennerArt
	 * @return
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);
}
