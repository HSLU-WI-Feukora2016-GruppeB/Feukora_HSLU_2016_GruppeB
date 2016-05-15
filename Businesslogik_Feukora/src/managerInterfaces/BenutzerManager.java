package managerInterfaces;

import java.util.List;

import entit�ten.Benutzer;

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
	 * Passt den �bergebenen Benutzer an.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Benutzer update(Benutzer entity) throws Exception;

	/**
	 * L�scht den �bergebenen Benutzer.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Benutzer entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Benutzer mithilfe seiner Id.
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
	 */
	public Benutzer findById(Integer id);

	/**
	 * Liefert alle Benutzer zur�ck.
	 * 
	 * @return
	 */
	public List<Benutzer> findAll();

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * 
	 * @param username
	 * @return
	 */
	public List<Benutzer> findByUsername(String username);
	
	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Passworts.
	 * 
	 * @param password
	 * @return
	 */
	public List<Benutzer> findByPassword(String password);

}
