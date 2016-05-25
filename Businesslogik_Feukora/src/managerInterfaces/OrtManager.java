package managerInterfaces;

import java.util.List;

import entitys.Ort;

/**
 * Verwaltet einen Ort und alle Funktionen.
 * 
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface OrtManager {

	/**
	 * Speichert einen Ort.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Ort add(Ort entity) throws Exception;

	/**
	 * Passt den übergebenen Ort an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Ort update(Ort entity) throws Exception;

	/**
	 * Löscht den übergebenen Ort.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Ort entity) throws Exception;

	/**
	 * Löscht den übergebenen Ort mithilfe seiner Id.
	 * 
	 * @param idOrt
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer idOrt) throws Exception;

	/**
	 * Liefert einen Ort anhand der gesuchten Id.
	 * 
	 * @param idOrt
	 * @return
	 * @throws Exception
	 */
	public Ort findById(Integer idOrt) throws Exception;

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
	public List<Ort> findByPlz(int plz) throws Exception;

	/**
	 * Liefert alle Benutzer zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Ort> findAll() throws Exception;

}
