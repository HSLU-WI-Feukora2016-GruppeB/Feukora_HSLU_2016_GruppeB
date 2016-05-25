package rmi.interfaces;

import java.rmi.Remote;
import java.util.List;

import entitys.Ort;


/**
 * Das Interface stellt die CRUD-Funktionen f�r den Ort zur Verf�gung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 */

public interface OrtRO extends Remote {
	
	
	/**
	 * Speichert einen Ort.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public Ort add(Ort entity) throws Exception;

	/**
	 * Passt den �bergebenen Ort an.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public Ort update(Ort entity) throws Exception;

	/**
	 * L�scht den �bergebenen Ort.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Ort entity) throws Exception;

	/**
	 * L�scht den �bergebenen Ort mithilfe seiner Id.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Ort findById(Integer id) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
	 * 
	 * @param ortBez
	 * @return
	 * @throws Exception
	 */
	public List<Ort> findByOrtBez(String ortBez) throws Exception;
	
	/**
	 * Liefert einen Ort anhand der gesuchten Postleitzahl.
	 * 
	 * @param plz
	 * @return
	 * @throws Exception
	 */
	public List<Ort> findByOrtPlz(int plz) throws Exception;

	/**
	 * Liefert alle Benutzer zur�ck.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Ort> findAll() throws Exception;

	}

