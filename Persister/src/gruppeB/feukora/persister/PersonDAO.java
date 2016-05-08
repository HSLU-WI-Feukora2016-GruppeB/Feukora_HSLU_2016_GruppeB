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
	 * Updatet die übergebene Person-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Person updatePerson(Person entity) throws Exception;
	
	/**
	 * Löscht die übergebene Person-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deletePerson(Person entity) throws Exception;
	
	/**
	 * Löscht die Person-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deletePersonById(Integer id) throws Exception;
	
	/**
	 * Liefert die Person-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Person findPersonById(Integer id);
	
	/**
	 * Liefert alle Person-Objekte zurück.
	 * 
	 * @return
	 */
	List<Person> findAllPerson();
	
	/**
	 * Liefert die Liste mit Person für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Person> findPersonByName(String name);
	
	/**
	 * Liefert die Liste mit den Person für den übergebenen Vornamen zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Person> findPersonByVorname(String vorname);
}
