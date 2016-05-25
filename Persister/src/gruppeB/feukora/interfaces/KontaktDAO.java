package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Kontakt;
import entitys.Ort;

/**
 * Interface für Persistierung von Kontakt-Entities.
 * @since 1.0
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
	 * @return Kontakt
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
	 * @param idKontakt
	 * @return Kontakt
	 * @throws Exception
	 */
	public Kontakt findKontaktById(Integer idKontakt) throws Exception;
	
	/**
	 * Liefert alle Kontakt-Objekte zurück.
	 * 
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findAllKontakte() throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Namen zurück, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByName(String name) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByVorname(String vorname) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Namen und Vornamen zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByNameVorname(String name, String vorname) throws Exception;

	/**
	 * Liefert die Liste mit den Kontakten für den übergebenen Ort zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Kontakt>
	 * @throws Exception
	 */	
	public List<Kontakt> findKontaktByOrt(Ort ort) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Rolle zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param rolleExtern
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten für die übergebene Strasse zurück,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByStrasse(String strasse) throws Exception;
}
