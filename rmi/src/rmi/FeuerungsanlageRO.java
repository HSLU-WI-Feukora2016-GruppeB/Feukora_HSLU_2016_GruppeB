package rmi;

import java.rmi.Remote;
import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;


/**
 * Das Interface stellt die CRUD-Funktionen für die Feuerungsanlage zur Verfügung.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 */

public interface FeuerungsanlageRO extends Remote {
	
	/**
	 * Speichert eine Feuerungsanlage.
	 * @param entity
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
	 * Liefert alle Feuerungsanlagen für den gesuchten Waermeerzeuger.
	 * @param brennerArt
	 * @return
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);

}
