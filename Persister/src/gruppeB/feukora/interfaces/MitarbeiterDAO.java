package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;

/**
 * Interface f�r Persistierung von Mitarbeiter-Entities.
 * 
 * @since 1.0
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
	 * @return Mitarbeiter
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
	 * @return Mitarbeiter
	 * @throws Exception
	 */
	public Mitarbeiter findMitarbeiterById(Integer id) throws Exception;

	/**
	 * Liefert alle Mitarbeiter-Objekte zur�ck.
	 * 
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findAllMitarbeiter() throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name)
			throws Exception;

	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen
	 * zur�ck, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname)
			throws Exception;

	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen und
	 * Namen zur�ck, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name,
			String vorname) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Rolle zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByRolleIntern(int rolleIntern)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Strasse zur�ck,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByStrasse(String strasse)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebenen �rtlichkeiten
	 * zur�ck, falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByOrt(Ort ort) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene User zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param user
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByBenutzer(Benutzer user)
			throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Startdaten zur�ck,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetSeit
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetSeit(
			GregorianCalendar arbeitetSeit) throws Exception;

	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Enddaten zur�ck,
	 * falls welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param arbeitetBis
	 * @return List<Mitarbeiter>
	 * @throws Exception
	 */
	public List<Mitarbeiter> findMitarbeiterByArbeitetBis(
			GregorianCalendar arbeitetBis) throws Exception;
}
