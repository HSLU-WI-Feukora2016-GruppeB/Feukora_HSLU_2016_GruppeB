/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Person Modell-Klasse.

/**
 * Interface für Persistierung von Person-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface PersonDAO {

	/**
	 * Speichert die übergebene Person-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void savePerson(Person entity) throws Exception;
	
	/**
	 * Updatet die übergebene User-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public User updateUser(User entity) throws Exception;
	
	/**
	 * Löscht die übergebene User-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteUser(User entity) throws Exception;
	
	/**
	 * Löscht die User-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(Integer id) throws Exception;
	
	/**
	 * Liefert die User-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * Liefert alle User-Objekte zurück.
	 * 
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * Liefert die Liste mit User für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findUserByName(String name);
	
	/**
	 * Liefert die Liste mit den User für den übergebenen Vornamen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<User> findUserByVorname(String nachname);
}
