/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Kontakt Modell-Klasse.

/**
 * Interface für Persistierung von Kontakt-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface KontaktDAO {

	/**
	 * Speichert die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Updatet die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Kontakt updateKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Löscht die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Löscht die Kontakt-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteKontaktById(Integer id) throws Exception;
	
	/**
	 * Liefert die Kontakt-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Kontakt findKontaktById(Integer id);
	
	/**
	 * Liefert alle Kontakt-Objekte zurück.
	 * 
	 * @return
	 */
	List<Kontakt> findAllKontakte();
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Kontakt> findKontaktByName(String name);
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Vornamen mit Nachnamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByNameUndVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Rolle zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param rolle
	 * @return
	 */
	//public List<Kontakt> findKontaktByRolle(Rolle rolle);
}
