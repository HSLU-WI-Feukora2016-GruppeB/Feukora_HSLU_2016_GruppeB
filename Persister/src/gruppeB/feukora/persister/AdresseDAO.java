/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

/**
 * Interface für Persistierung von Adresse-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface AdresseDAO {

	/**
	 * Speichert die übergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveAdresse(Adresse entity) throws Exception;
	
	/**
	 * Updatet die übergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Adresse updateAdresse(Adresse entity) throws Exception;
	
	/**
	 * Löscht die übergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteAdresse(Adresse entity) throws Exception;
	
	/**
	 * Löscht die Adresse-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteAdresseById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Adresse findAdresseById(Integer id);
	
	/**
	 * Liefert alle Adresse-Objekte zurück.
	 * 
	 * @return
	 */
	List<Adresse> findAllAdresse();
	
}

