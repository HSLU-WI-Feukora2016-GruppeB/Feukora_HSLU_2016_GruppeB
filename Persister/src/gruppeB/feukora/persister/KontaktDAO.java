/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
//import Kontakt Modell-Klasse.

/**
 * Interface f�r Persistierung von Kontakt-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface KontaktDAO {

	/**
	 * Speichert die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Kontakt updateKontakt(Kontakt entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteKontakt(Kontakt entity) throws Exception;
	
	/**
	 * L�scht die Kontakt-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteKontaktById(Integer id) throws Exception;
	
	/**
	 * Liefert die Kontakt-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Kontakt findKontaktById(Integer id);
	
	/**
	 * Liefert alle Kontakt-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Kontakt> findAllKontakte();
	
	/**
	 * Liefert die Liste mit den Kontakten f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Kontakt> findKontaktByName(String name);
	
	/**
	 * Liefert die Liste mit den Kontakten f�r den �bergebenen Vornamen mit Nachnamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByNameUndVorname(String name, String vorname);
	
	/**
	 * Liefert die Liste mit den Kontakten f�r den �bergebenen Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Kontakten f�r die �bergebene Rolle zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param rolle
	 * @return
	 */
	//public List<Kontakt> findKontaktByRolle(Rolle rolle);
}
