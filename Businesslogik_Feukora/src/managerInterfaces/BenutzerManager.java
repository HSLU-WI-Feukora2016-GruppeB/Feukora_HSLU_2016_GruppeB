package managerInterfaces;

import java.util.List;

import entitys.Benutzer;

/**
	 * Verwaltet einen Benutzer und alle Funktionen.
	 * @author Olivia
	 * @version 1.0
	 * @since 1.0
	 *
	 */
public interface BenutzerManager {
	
	/**
	 * Speichert einen Benutzer.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Benutzer add(Benutzer entity) throws Exception;

	/**
	 * Passt den übergebenen Benutzer an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Benutzer update(Benutzer entity) throws Exception;

	/**
	 * Löscht den übergebenen Benutzer.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Benutzer entity) throws Exception;
	
	/**
	 * Löscht den übergebenen Benutzer mithilfe seiner Id.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;

	/**
	 * Liefert einen Benutzer anhand der gesuchten Benutzerid.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Benutzer findById(Integer id)throws Exception;

	/**
	 * Liefert alle Benutzer zurück.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findAll()throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findByUsername(String username)throws Exception;
	
	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Passworts.
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findByUsernamePassword(String username, String password)throws Exception;


}
