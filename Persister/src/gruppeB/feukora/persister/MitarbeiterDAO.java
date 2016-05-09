/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Mitarbeiter Modell-Klasse.

/**
 * Interface für Persistierung von Mitarbeiter-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface MitarbeiterDAO {

	/**
	 * Speichert die übergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * Updatet die übergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter updateMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * Löscht die übergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * Löscht die Mitarbeiter-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteMitarbeiterById(Integer id) throws Exception;
	
	/**
	 * Liefert die Mitarbeiter-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Mitarbeiter findMitarbeiterById(Integer id);
	
	/**
	 * Liefert alle Mitarbeiter-Objekte zurück.
	 * 
	 * @return
	 */
	List<Mitarbeiter> findAllMitarbeiter();
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen mit Nachnamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByNameUndVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen zurück,
	 * welche zurzeit einen Auftrag ausführen, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Namen zurück,
	 * welche zurzeit einen Auftrag ausführen, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByName(String name);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen mit Nachnamen zurück,
	 * welche zurzeit einen Auftrag ausführen, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByGanzerName(String name, String vorname);
	
	/**
	 * Liefert alle Mitarbeiter-Objekte zurück, welche zurzeit einen Auftrag ausführen.
	 * 
	 * @return
	 */
	List<Mitarbeiter> findAllActiveMitarbeiter();
}
