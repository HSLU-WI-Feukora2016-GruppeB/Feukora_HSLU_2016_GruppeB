/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entitäten.Mitarbeiter;
//import Mitarbeiter Modell-Klasse.
import entitäten.RolleIntern;

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
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Rolle zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findByRolleIntern(RolleIntern rolleIntern);
}
