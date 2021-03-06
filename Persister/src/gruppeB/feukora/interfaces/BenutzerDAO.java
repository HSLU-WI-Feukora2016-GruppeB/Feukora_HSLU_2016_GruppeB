package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Benutzer;

/**
 * Interface f�r Persistierung von Benutzer-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface BenutzerDAO {

	/**
	 * Speichert die �bergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @return Benutzer
	 * @throws Exception
	 */
	public Benutzer updateBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * L�scht die Benutzer-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBenutzerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Benutzer-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param idUser
	 * @return Benutzer
	 * @throws Exception
	 */
	public Benutzer findBenutzerById(Integer idUser) throws Exception;
	
	/**
	 * Liefert alle Benutzer-Objekte zur�ck.
	 * 
	 * @return List<Benutzer>
	 * @throws Exception
	 */
	List<Benutzer> findAllBenutzer() throws Exception;
	
	/**
	 * Liefert die Liste mit User f�r die �bergebene Usernames zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param username
	 * @return List<Benutzer>
	 * @throws Exception
	 */
	public List<Benutzer> findBenutzerByUsername(String username) throws Exception;
	
	/**
	 * Liefert die Liste mit den User f�r den �bergebenen Passw�rter zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param username
	 * @return List<Benutzer>
	 * @throws Exception
	 */
	public List<Benutzer> findBenutzerByUsernamePassword(String username, String password) throws Exception;
}
