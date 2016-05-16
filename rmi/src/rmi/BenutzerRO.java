package rmi;

import java.util.List;

import managerInterfaces.Benutzer;

/**
 * Das Interface stellt die CRUD-Funktionen für den Benutzer zur Verfügung.
 * 
 * @author Berri
 * @version 1.0
 * @since 1.0
 */
public interface BenutzerRO {
	
	/**
	 * Speichert die Aenderung des Benutzers.
	 * @param entity
	 * @throws Exception
	 */
	public Benutzer add(Benutzer entity) throws Exception;

	/**
	 * Aenderung des Benutzers
	 * @param entity
	 * @throws Exception
	 */
	public Benutzer update(Benutzer entity)  throws Exception;
	
	/**
	 * Löscht den Benutzer.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Benutzer entity) throws Exception;
	
	/**
	 * Löscht den übergebenen Benutzer mithilfe seiner Id.
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert einen Benutzer anhand der gesuchten Benutzerid.
	 * @param id
	 * @return
	 */
	public Benutzer findById(Integer id)throws Exception;

	/**
	 * Liefert alle Benutzer zurück.
	 * @return
	 */
	public List<Benutzer> findAll()throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * @param username
	 * @return
	 */
	public List<Benutzer> findByUsername(String username)throws Exception;
	
	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Passworts.
	 * @param password
	 * @return
	 */
	public List<Benutzer> findByPassword(String password)throws Exception;

}
