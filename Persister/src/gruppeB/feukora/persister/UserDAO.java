/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import entit�ten.User;

/**
 * Interface f�r Persistierung von User-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface UserDAO {

	/**
	 * Speichert die �bergebene User-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveUser(User entity) throws Exception;
	
	/**
	 * Updatet die �bergebene User-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public User updateUser(User entity) throws Exception;
	
	/**
	 * L�scht die �bergebene User-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteUser(User entity) throws Exception;
	
	/**
	 * L�scht die User-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(Integer id) throws Exception;
	
	/**
	 * Liefert die User-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * Liefert alle User-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * Liefert die Liste mit User f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findUserByName(String name);
	
	/**
	 * Liefert die Liste mit den User f�r den �bergebenen Vornamen zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<User> findUserByVorname(String vorname);
}
