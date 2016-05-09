/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Mitarbeiter Modell-Klasse.

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
	 * L�scht die Mitarbeiter-Entity f�r den �bergebenen Id-Wert.
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
	List<Mitarbeiter> findAllMitarbeiter();
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen mit Nachnamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByNameUndVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen zur�ck,
	 * welche zurzeit einen Auftrag ausf�hren, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Namen zur�ck,
	 * welche zurzeit einen Auftrag ausf�hren, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByName(String name);
	
	/**
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen mit Nachnamen zur�ck,
	 * welche zurzeit einen Auftrag ausf�hren, falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findActiveMitarbeiterByGanzerName(String name, String vorname);
	
	/**
	 * Liefert alle Mitarbeiter-Objekte zur�ck, welche zurzeit einen Auftrag ausf�hren.
	 * 
	 * @return
	 */
	List<Mitarbeiter> findAllActiveMitarbeiter();
}
