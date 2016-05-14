/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Ort;

/**
 * Interface f�r Persistierung von Ort-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface OrtDAO {

	/**
	 * Speichert die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveOrt(Ort entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Ort updateOrt(Ort entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteOrt(Ort entity) throws Exception;
	
	/**
	 * L�scht die Ort-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrtById(Integer id) throws Exception;
	
	/**
	 * Liefert die Ort-Entity f�r die uebergebenen PLZ (id) zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Ort findOrtById(Integer id);
	
	/**
	 * Liefert alle Ort-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Ort> findAllOrt();
	
	/**
	 * Liefert die Liste mit den �rtlichkeiten f�r die �bergebene Ortsbezeichnung zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ortBez
	 * @return
	 */
	public List<Ort> findOrtByBezeichnung(String ortBez);
	
}
