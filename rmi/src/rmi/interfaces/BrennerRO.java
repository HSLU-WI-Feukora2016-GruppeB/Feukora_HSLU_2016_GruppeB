package rmi.interfaces;

import java.rmi.Remote;
import java.util.List;

import entitys.Brenner;


/**
 * Das Interface stellt die CRUD-Funktionen f�r den Brenner zur Verf�gung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 */

public interface BrennerRO extends Remote {

	/**
	 * Speichert einen Brenner.
	 * @param entit�t
	 * @throws Exception
	 */
	public Brenner add(Brenner entity) throws Exception;
	
	/**
	 * Passt einen Brenner an.
	 * @param entity
	 * @throws Exception
	 */
	public Brenner update(Brenner entity) throws Exception;
	
	/**
	 * L�scht den mitgegebenen Brenner.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Brenner entity) throws Exception;
	
	/**
	 * L�scht den Brenner mithilfe seiner Id.
	 * @param entity
	 * @throws Exception
	 */
	public void deleteById(Integer idBrenner) throws Exception;
	
	/**
	 * Liefert Brenner mithilfe seiner Id.
	 * @return
	 * @throws Exception
	 */
	public Brenner findById(Integer id) throws Exception;
	
	/**
	 * Liefert Liste aller Brenner.
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findAll() throws Exception;
	
	/**
	 * Liefert alle Brenner des angefragten Typs.
	 * @param brennerTyp
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByTyp(String brennerTyp) throws Exception;
	
	/**
	 * Liefert alle Brenner der angefragten Art.
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByArt(int brennerArt) throws Exception;
	
	/**
	 * Liefert alle Brenner mit angefragtem Baujahr.
	 * @param baujahr
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByBaujahr(int baujahr) throws Exception;
	
}
