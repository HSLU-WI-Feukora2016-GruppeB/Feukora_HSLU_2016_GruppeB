/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

/**
 * Interface f�r Persistierung von Adresse-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface AdresseDAO {

	/**
	 * Speichert die �bergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveAdresse(Adresse entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Adresse updateAdresse(Adresse entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Adresse-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteAdresse(Adresse entity) throws Exception;
	
	/**
	 * L�scht die Adresse-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteAdresseById(Integer id) throws Exception;
	
	/**
	 * Liefert die Brenner-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Adresse findAdresseById(Integer id);
	
	/**
	 * Liefert alle Adresse-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Adresse> findAllAdresse();
	
}

