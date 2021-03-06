package rmi.interfaces;

import java.rmi.Remote;
import java.util.List;

import entitys.Benutzer;


/**
 * Das Interface stellt die CRUD-Funktionen f�r den Benutzer zur Verf�gung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 */
public interface BenutzerRO extends Remote {
	
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
	 * L�scht den Benutzer.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Benutzer entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Benutzer mithilfe seiner Id.
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;
	
	/**
	 * Liefert einen Benutzer anhand der gesuchten Benutzerid.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Benutzer findById(Integer id)throws Exception;

	/**
	 * Liefert alle Benutzer zur�ck.
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findAll()throws Exception;

	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Usernames.
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findByUsername(String username)throws Exception;
	
	/**
	 * Liefert eine Benutzerliste anhand des gesuchten Benutzernamens und Passworts.
	 * @param username, password
	 * @return
	 * @throws Exception
	 */
	public List<Benutzer> findByUsernamePassword(String username, String password)throws Exception;

}
