/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.interfaces;

import java.util.List;

import entitäten.Kontakt;
import entitäten.Ort;

/**
 * Interface für Persistierung von Kontakt-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface KontaktDAO {

	/**
	 * Speichert die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Updatet die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Kontakt updateKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Löscht die übergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Löscht die Kontakt-Entity für den übergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteKontaktById(Integer id) throws Exception;
	
	/**
	 * Liefert die Kontakt-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 */
	public Kontakt findKontaktById(Integer idKontakt);
	
	/**
	 * Liefert alle Kontakt-Objekte zurück.
	 * 
	 * @return
	 */
	public List<Kontakt> findAllKontakte();
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return
	 */
	public List<Kontakt> findKontaktByName(String name);
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByVorname(String vorname);
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Namen und Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findKontaktByNameVorname(String name, String vorname);

	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Ort zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */	
	public List<Kontakt> findKontaktByOrt(Ort ort);
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Rolle zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param rolleExtern
	 * @return
	 */
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern);
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Strasse zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 */
	public List<Kontakt> findKontaktByStrasse(String strasse);
}
