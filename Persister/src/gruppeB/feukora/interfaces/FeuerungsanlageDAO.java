package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;

/**
 * Interface f�r Persistierung von Feuerungsanlage-Entities.
 * @since 1.0
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
	 * @return Feuerungsanlage
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
	 * @return Feuerungsanlage
	 * @throws Exception
	 */
	public Feuerungsanlage findFeuerungsanlageById(Integer id) throws Exception;
	
	/**
	 * Liefert alle Feuerungsanlage-Objekte zur�ck.
	 * 
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Liegenschaften zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param liegenschaft
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Brenner zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brenner
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) throws Exception;

	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Waermeerzeuger zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param waermeerzeuger
	 * @return List<Feuerungsanlage>
	 * @throws Exception
	 */
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger) throws Exception;

}
