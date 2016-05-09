/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

/**
 * Interface f�r Persistierung von Liegenschaft-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface LiegenschaftDAO {

	/**
	 * Speichert die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft updateLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die Liegenschaft-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert die Liegenschaft-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Liegenschaft findLiegenschaftById(Integer id);
	
	/**
	 * Liefert alle Liegenschaft-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Liegenschaft> findAllLiegenschaft();
	
	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Hausw�rte zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param hauswart
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByHauswart(String hauswart);
	
	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Eigent�mer zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param eigent�mer
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByEigent�mer(String eigent�mer);
	
}
