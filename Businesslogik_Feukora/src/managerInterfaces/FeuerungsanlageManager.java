package managerInterfaces;

import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;



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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage add(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Passt eine Feuerungsanlage an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage update(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Löscht die mitgegebene Feuerungsanlage.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Löscht die mitgegebene Feuerungsanlage mithilfe ihrer ID.
	 * @param idFeuerungsanlage
	 * @throws Exception
	 */
	public void deleteById(Integer idFeuerungsanlage) throws Exception;
	
	/**
	 * Liefert die mitgegebene Feuerungsanlage mithilfe ihrer ID.
	 * @param idFeuerungsanlage
	 * @throws Exception
	 */
	public Feuerungsanlage findById(Integer idFeuerungsanlage) throws Exception;
	
	/**
	 * Liefert Liste aller Feuerungsanlagen.
	 * @return
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findAll();
	
	/**
	 * Liefert alle Feuerungsanlagen für die gesuchte Liegenschaft.
	 * @param brennerTyp
	 * @return
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);
	
	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Brenner.
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner);
	
	/**
	 * Liefert alle Feuerungsanlagen für den gesuchten Waermeerzeuger.
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);
}
