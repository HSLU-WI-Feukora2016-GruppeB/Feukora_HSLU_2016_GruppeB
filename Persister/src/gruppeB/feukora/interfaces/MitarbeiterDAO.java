package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;

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
	 * Löscht die Mitarbeiter-Entity für den uebergebenen Id-Wert.
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
	public List<Mitarbeiter> findAllMitarbeiter();
	
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
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen und Namen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Rolle zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByRolleIntern(int rolleIntern);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Strasse zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebenen Örtlichkeiten zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene User zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param user
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Startdaten zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetSeit
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(GregorianCalendar arbeitetSeit);
	
	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Enddaten zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetBis
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(GregorianCalendar arbeitetBis);
}
