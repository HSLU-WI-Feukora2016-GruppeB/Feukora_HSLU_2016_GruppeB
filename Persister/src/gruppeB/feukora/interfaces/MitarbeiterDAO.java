package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;

/**
 * Interface für Persistierung von Mitarbeiter-Entities.
 * 
 * @since 1.0
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
	 * @return Mitarbeiter
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
	 * @return Mitarbeiter
	 * @throws Exception
	 */
	public Mitarbeiter findMitarbeiterById(Integer id) throws Exception;

	/**
	 * Liefert alle Mitarbeiter-Objekte zurück.
	 * 
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findAllMitarbeiter() throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name)
			throws Exception;

	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen
	 * zurück, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname)
			throws Exception;

	/**
	 * Liefert die Liste mit den Mitarbeiter für den übergebenen Vornamen und
	 * Namen zurück, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name,
			String vorname) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Rolle zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByRolleIntern(int rolleIntern)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Strasse zurück,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebenen Örtlichkeiten
	 * zurück, falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene User zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param user
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Startdaten zurück,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetSeit
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			GregorianCalendar arbeitetSeit) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter für die übergebene Enddaten zurück,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetBis
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			GregorianCalendar arbeitetBis) throws Exception;
}
