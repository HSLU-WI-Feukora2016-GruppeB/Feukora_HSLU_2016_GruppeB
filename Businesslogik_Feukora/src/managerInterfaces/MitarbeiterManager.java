package managerInterfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Benutzer;
import entit�ten.Mitarbeiter;
import entit�ten.Ort;


/**
 * Interface welches Mitarbeiter funktionalit�ten liefert.
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
	 * L�scht den mitgegebenen Mitarbeiter.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Mitarbeiter entity) throws Exception;
	
	/**
	 * L�scht den mitgegebenen Mitarbeiter mithilfe seiner Id.
	 * @param idMitarbeiter
	 * @throws Exception
	 */
	public void deleteById(Integer idMitarbeiter) throws Exception;
	
	/**
	 * Liefert den Mitarbeiter zur mitgegebenen Id.
	 * @param idMitarbeiter
	 * @return
	 */
	public Mitarbeiter findById(Integer idMitarbeiter)throws Exception;
	
	/**
	 * Liefert Liste aller Mitarbeiter.
	 * @return
	 */
	public List<Mitarbeiter> findAllMitarbeiter()throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter des angefragten Typs.
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findByName(String name)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findByVorname(String vorname)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findByNameVorname(String name, String vorname)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findByRolleIntern (int rolleIntern)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * @param strasse
	 * @return
	 */
	public List<Mitarbeiter> findByStrasse (String strasse)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Ort.
	 * @param ort
	 * @return
	 */
	public List<Mitarbeiter> findByOrt (Ort ort)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Benutzernamen.
	 * @param username
	 * @return
	 */
	public List<Mitarbeiter> findByBenutzer (Benutzer user)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Arbeitsbeginn-Datum.
	 * @param arbeitetSeit
	 * @return
	 */
	public List<Mitarbeiter> findByArbeitetSeit (GregorianCalendar arbeitetSeit)throws Exception;

	/**
	 * Liefert alle Mitarbeiter mit gesuchtem K�ndigungs-Datum.
	 * @param arbeitetBis
	 * @return
	 */
	public List<Mitarbeiter> findByArbeitetBis (GregorianCalendar arbeitetBis)throws Exception;
}
