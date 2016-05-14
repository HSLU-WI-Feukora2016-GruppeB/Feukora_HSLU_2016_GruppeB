/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Brenner;
import entit�ten.Feuerungsanlage;
import entit�ten.Liegenschaft;
import entit�ten.Waermeerzeuger;

/**
 * Interface f�r Persistierung von Feuerungsanlage-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface FeuerungsanlageDAO {

	/**
	 * Speichert die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * L�scht die Feuerungsanlage-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteFeuerungsanlageById(Integer id) throws Exception;
	
	/**
	 * Liefert die Feuerungsanlage-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Feuerungsanlage findFeuerungsanlageById(Integer id);
	
	/**
	 * Liefert alle Feuerungsanlage-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Feuerungsanlage> findAllFeuerungsanlage();

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Liegenschaften zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Brenner zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brenner
	 * @return
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner);

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Waermeerzeuger zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeuger
	 * @return
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger);

}
