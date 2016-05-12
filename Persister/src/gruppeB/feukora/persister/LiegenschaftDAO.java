/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Liegenschaft;

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
	public void addLiegenschaft(Liegenschaft entity) throws Exception;
	
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
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Kontakt zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 */
	public List<Liegenschaft> findByKontakt(String kontakt);
	
	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Ort zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Liegenschaft> findByOrt(String ort);

	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Strasse inkl. Nr. zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasseInklNr
	 * @return
	 */
	public List<Liegenschaft> findByStrasse(String strasseInklNr);
	
}
