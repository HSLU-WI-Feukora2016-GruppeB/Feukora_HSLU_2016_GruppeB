package rmi.interfaces;

import java.rmi.Remote;
import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;


/**
 * Das Interface stellt die CRUD-Funktionen f�r die Liegenschaft zur Verf�gung.
 * 
 * @author Matthias Perrollaz
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
	 * Passt die �bergebene Liegenschaft an.
	 * @param entity
	 * @throws Exception
	 */
	public Liegenschaft update(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Liegenschaft.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Liegenschaft mithilfe ihrer ID.
	 * @param idLiegenschaft
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer idLiegenschaft) throws Exception;

	/**
	 * Liefert die Liegenschaft die mit der Id angefragt wurde. 
	 * @param idLiegenschaft
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft findById(Integer idLiegenschaft)throws Exception;
	
	/**
	 * Liefert alle Liegenschaften zur�ck.
	 * @return
	 * @throws Exception
	 */
	public List<Liegenschaft> findAll()throws Exception;
	
	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @return
	 * @throws Exception
	 */
	public List<Liegenschaft> findByKontakt(Kontakt kontakt)throws Exception;

	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Orts.
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public List<Liegenschaft> findByOrt(Ort ort)throws Exception;
	
	/**
	 * Liefert eine Liegenschaftsliste anhand der gesuchten Strasse.
	 * @param strasse
	 * @return
	 * @throws Exception
	 */	
	public List<Liegenschaft> findByStrasse(String strasse)throws Exception;

	
}
