/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.interfaces;

import java.util.List;
import entitäten.Benutzer;

/**
 * Interface für Persistierung von Benutzer-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface BenutzerDAO {

	/**
	 * Speichert die übergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * Updatet die übergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Benutzer updateBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * Löscht die übergebene Benutzer-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteBenutzer(Benutzer entity) throws Exception;
	
	/**
	 * Löscht die Benutzer-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteBenutzerById(Integer id) throws Exception;
	
	/**
	 * Liefert die Benutzer-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Benutzer findBenutzerById(Integer idUser) throws Exception;
	
	/**
	 * Liefert alle Benutzer-Objekte zurück.
	 * 
	 * @return
	 */
	List<Benutzer> findAllBenutzer() throws Exception;
	
	/**
	 * Liefert die Liste mit User für die übergebene Usernames zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param username
	 * @return
	 */
	public List<Benutzer> findBenutzerByUsername(String username) throws Exception;
	
	/**
	 * Liefert die Liste mit den User für den übergebenen Passwörter zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param password
	 * @return
	 */
	public List<Benutzer> findBenutzerByPassword(String password) throws Exception;
}
