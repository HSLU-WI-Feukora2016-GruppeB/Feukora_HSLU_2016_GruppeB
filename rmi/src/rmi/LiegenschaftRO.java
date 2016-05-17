package rmi;

import java.rmi.Remote;
import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;


/**
 * Das Interface stellt die CRUD-Funktionen für die Liegenschaft zur Verfügung.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 */

public interface LiegenschaftRO extends Remote {
	
	/**
	 * Speichert eine Liegenschaft.
	 * @param entity
	 * @throws Exception
	 */
	public Liegenschaft add(Liegenschaft entity) throws Exception;
	
	/**
	 * Passt die übergebene Liegenschaft an.
	 * @param entity
	 * @throws Exception
	 */
	public Liegenschaft update(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die übergebene Liegenschaft.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die übergebene Liegenschaft mithilfe ihrer ID.
	 * @param idLiegenschaft
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer idLiegenschaft) throws Exception;

	/**
	 * Liefert die Liegenschaft die mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Liegenschaft findById(Integer idLiegenschaft)throws Exception;
	
	/**
	 * Liefert alle Liegenschaften zurück.
	 * @return
	 */
	public List<Liegenschaft> findAll()throws Exception;
	
	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @return
	 */
	public List<Liegenschaft> findByKontakt(Kontakt kontakt)throws Exception;

	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Orts.
	 * @param ort
	 * @return
	 */
	public List<Liegenschaft> findByOrt(Ort ort)throws Exception;
	
	/**
	 * Liefert eine Liegenschaftsliste anhand der gesuchten Strasse.
	 * @param strasseInklNr
	 * @return
	 */	
	public List<Liegenschaft> findByStrasse(String strasse)throws Exception;

	
}
