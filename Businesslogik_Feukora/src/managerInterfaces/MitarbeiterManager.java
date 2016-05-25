package managerInterfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;


/**
 * Interface welches Mitarbeiter funktionalitäten liefert.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface MitarbeiterManager {
	
	
	/**
	 * Speichert einen Mitarbeiter.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter add(Mitarbeiter entity) throws Exception;
	
	/**
	 * Passt einen Mitarbeiter an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter update(Mitarbeiter entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Mitarbeiter.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Mitarbeiter entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Mitarbeiter mithilfe seiner Id.
	 * @param idMitarbeiter
	 * @throws Exception
	 */
	public void deleteById(Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert den Mitarbeiter zur mitgegebenen Id.
	 * @param idMitarbeiter
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter findById(Integer idMitarbeiter)throws Exception;
	
	/**
	 * Liefert Liste aller Mitarbeiter.
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findAllMitarbeiter()throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit dem mitgegebenen Namen zurück.
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByName(String name)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByVorname(String vorname)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Namen und Vornamen.
	 * @param name
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByNameVorname(String name, String vorname)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByRolleIntern (int rolleIntern)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * @param strasse
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByStrasse (String strasse)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Ort.
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByOrt (Ort ort)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Benutzernamen.
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByBenutzer (Benutzer user)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Arbeitsbeginn-Datum.
	 * @param arbeitetSeit
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByArbeitetSeit (GregorianCalendar arbeitetSeit)throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Kündigungs-Datum.
	 * @param arbeitetBis
	 * @return
	 * @throws Exception
	 */
	public List<Mitarbeiter> findByArbeitetBis (GregorianCalendar arbeitetBis)throws Exception;
}
