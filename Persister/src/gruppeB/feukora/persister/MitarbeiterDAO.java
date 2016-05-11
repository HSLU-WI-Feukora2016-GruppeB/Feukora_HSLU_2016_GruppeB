/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Mitarbeiter;
//import Mitarbeiter Modell-Klasse.
import entit�ten.RolleIntern;

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
	 * Liefert die Liste mit den Mitarbeiter f�r den �bergebenen Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit Mitarbeiter f�r die �bergebene Rolle zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findByRolleIntern(RolleIntern rolleIntern);
}
