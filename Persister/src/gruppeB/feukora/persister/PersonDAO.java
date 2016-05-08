/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Person Modell-Klasse.

/**
 * Interface f�r Persistierung von Person-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface PersonDAO {

	/**
	 * Speichert die �bergebene Person-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void savePerson(Person entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Person-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Person updatePerson(Person entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Person-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deletePerson(Person entity) throws Exception;
	
	/**
	 * L�scht die Person-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deletePersonById(Integer id) throws Exception;
	
	/**
	 * Liefert die Person-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Person findPersonById(Integer id);
	
	/**
	 * Liefert alle Person-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Person> findAllPerson();
	
	/**
	 * Liefert die Liste mit Person f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Person> findPersonByName(String name);
	
	/**
	 * Liefert die Liste mit den Person f�r den �bergebenen Vornamen zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Person> findPersonByVorname(String vorname);
}
