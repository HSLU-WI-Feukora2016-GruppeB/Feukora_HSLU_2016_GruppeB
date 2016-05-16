package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;

/**
 * Interface f�r Persistierung von Mitarbeiter-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface MitarbeiterDAO {

	/**
	 * Speichert die �bergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter updateMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Mitarbeiter-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteMitarbeiter(Mitarbeiter entity) throws Exception;
	
	/**
	 * L�scht die Mitarbeiter-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteMitarbeiterById(Integer id) throws Exception;
	
	/**
	 * Liefert die Mitarbeiter-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Mitarbeiter findMitarbeiterById(Integer id);
	
	/**
	 * Liefert alle Mitarbeiter-Objekte zur�ck.
	 * 
	 * @return
	 */
	public List<Mitarbeiter> findAllMitarbeiter();
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen und Namen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Rolle zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByRolleIntern(int rolleIntern);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Strasse zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebenen �rtlichkeiten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene User zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param user
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Startdaten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetSeit
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(GregorianCalendar arbeitetSeit);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Enddaten zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetBis
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(GregorianCalendar arbeitetBis);
}
